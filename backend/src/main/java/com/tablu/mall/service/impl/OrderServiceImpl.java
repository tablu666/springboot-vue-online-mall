package com.tablu.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tablu.mall.dao.OrderItemMapper;
import com.tablu.mall.dao.OrderMapper;
import com.tablu.mall.dao.ProductMapper;
import com.tablu.mall.dao.ShippingMapper;
import com.tablu.mall.enums.OrderStatusEnum;
import com.tablu.mall.enums.PaymentTypeEnum;
import com.tablu.mall.enums.ProductStatusEnum;
import com.tablu.mall.enums.ResponseEnum;
import com.tablu.mall.exception.OrderBuildException;
import com.tablu.mall.form.PaymentForm;
import com.tablu.mall.pojo.*;
import com.tablu.mall.service.CartService;
import com.tablu.mall.service.OrderService;
import com.tablu.mall.utils.UUIDUtil;
import com.tablu.mall.vo.OrderItemVo;
import com.tablu.mall.vo.OrderVo;
import com.tablu.mall.vo.ResponseVo;
import com.tablu.mall.vo.ShippingVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ShippingMapper shippingMapper;

    @Autowired
    private CartService cartService;

    @Override
    public ResponseVo<OrderVo> createOrder(Integer shippingId, Integer userId) {
        //地址是否存在
        Shipping shipping = shippingMapper.selectByIdAndUserId(shippingId, userId);
        if (shipping == null) {
            return ResponseVo.error(ResponseEnum.ORDER_CREATE_ERROR);
        }

        //是否有选中商品
        List<Cart> cartsSelected = cartService.cartUnitList(userId)
                .stream()
                .filter(Cart::getProductSelected)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(cartsSelected)) {
            return ResponseVo.error(ResponseEnum.CART_SELECTED_EMPTY);
        }

        List<Integer> productIdList = cartsSelected.stream()
                .map(Cart::getProductId)
                .collect(Collectors.toList());
        List<Product> productList = productMapper.selectByProductIdList(productIdList);
        Map<Integer, Product> productMap = productList.stream()
                .collect(Collectors.toMap(Product::getId, product -> product));

        Long orderNo = UUIDUtil.getUUIDInOrderNo();
        List<OrderItem> orderItemList = new ArrayList<>();

        for (Cart cart : cartsSelected) {
            Product product = productMap.get(cart.getProductId());
            //判断商品是否存在？状态是否正常？库存是否正常？
            if (product == null) {
                return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST,
                        ResponseEnum.PRODUCT_NOT_EXIST.getDesc()
                                + " product ID=" + cart.getProductId());
            }
            if (!product.getStatus().equals(ProductStatusEnum.ON_SALE.getCode())) {
                return ResponseVo.error(ResponseEnum.PRODUCT_NOT_ON_SALE,
                        ResponseEnum.PRODUCT_NOT_ON_SALE.getDesc()
                                + " product name=" + product.getName());
            }
            if (product.getStock() < cart.getQuantity()) {
//                return ResponseVo.error(ResponseEnum.STOCK_NOT_ENOUGH);
                throw new OrderBuildException(ResponseEnum.STOCK_NOT_ENOUGH.getDesc());
            }

            OrderItem orderItem = buildOrderItem(product, cart.getQuantity(), orderNo, userId);
            orderItemList.add(orderItem);

            //更新库存
            product.setStock(product.getStock() - cart.getQuantity());
            int res = productMapper.updateByPrimaryKeySelective(product);
            if (res == 0) {
                throw new OrderBuildException(ResponseEnum.ERROR.getDesc());
            }
        }

        //数据库写入orderItem
        int res = orderItemMapper.insertByOrderItemList(orderItemList, userId);
        if (res == 0) {
            throw new OrderBuildException(ResponseEnum.ERROR.getDesc());
        }

        //数据库写入order
        Order order = buildOrder(orderItemList, shipping, userId, orderNo);
        int row = orderMapper.insertSelective(order);
        if (row == 0) {
            throw new OrderBuildException(ResponseEnum.ERROR.getDesc());
        }

        //redis更新购物车
        for (Cart cart : cartsSelected) {
            if (!cartService.deleteByOrder(cart.getProductId(), userId)) {
                return ResponseVo.error();
            }
        }

        OrderVo orderVo = buildOrderVo(order, orderItemList, shipping);
        return ResponseVo.success(orderVo);
    }

    @Override
    public ResponseVo<PageInfo> orderList(Integer pageSize, Integer pageNum, Integer userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.selectByUserId(userId);

        Set<Long> orderNoSet = orderList.stream()
                .map(Order::getOrderNo)
                .collect(Collectors.toSet());
        List<OrderItem> orderItemList = orderItemMapper.selectByOrderNoSet(orderNoSet);
        Map<Long, List<OrderItem>> orderNoOrderItemListMap = orderItemList.stream()
                .collect(Collectors.groupingBy(OrderItem::getOrderNo));

        List<OrderVo> orderVoList = orderList.stream()
                .map(order -> {
                    List<OrderItem> sortedOrderItemList = orderNoOrderItemListMap.get(order.getOrderNo());
                    return buildOrderVo(order, sortedOrderItemList, buildShipping(order));
                }).collect(Collectors.toList());

        PageInfo pageInfo = new PageInfo(orderList);
        pageInfo.setList(orderVoList);

        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<OrderVo> detail(Integer orderNo, Integer userId) {
        Order order = orderMapper.selectByOrderNoAndUserId(orderNo, userId);
        if (order == null) {
            return ResponseVo.error(ResponseEnum.ORDER_NOT_FOUND);
        }
        List<OrderItem> orderItemList = orderItemMapper.selectByOrderNo(orderNo);
        OrderVo orderVo = buildOrderVo(order, orderItemList, buildShipping(order));
        return ResponseVo.success(orderVo);
    }

    @Override
    public ResponseVo cancel(Integer orderNo, Integer userId) {
        Order order = orderMapper.selectByOrderNoAndUserId(orderNo, userId);
        ResponseVo responseVo = preCheckOrder(order, ResponseEnum.ORDER_STATUS_ERROR);
        if (responseVo != null) {
            return responseVo;
        }

        order.setStatus(OrderStatusEnum.CANCEL.getCode());
        order.setCloseTime(new Date());
        int res = orderMapper.updateByPrimaryKeySelective(order);
        if (res == 0) {
            throw new OrderBuildException(ResponseEnum.ERROR.getDesc());
        }

        //释放库存
        // TODO: 优化存取方式
        List<OrderItem> orderItemList = orderItemMapper.selectByOrderNo(orderNo);
        for (OrderItem orderItem : orderItemList) {
            Product product = productMapper.selectByPrimaryKey(orderItem.getProductId());
            product.setStock(product.getStock() + orderItem.getQuantity());
            productMapper.updateByPrimaryKeySelective(product);
        }

        return ResponseVo.success();
    }

    @Override
    public ResponseVo paymentOrder(PaymentForm paymentForm, Integer userId, String verifyCode) {
        //验证码校验
        String codeFromUser = paymentForm.getCode();
        if (StringUtils.isEmpty(codeFromUser)
                || verifyCode == null
                || !verifyCode.equalsIgnoreCase(codeFromUser)) {
            return ResponseVo.error(ResponseEnum.VERIFY_CODE_ERROR);
        }

        Order order = orderMapper.selectByOrderNoAndUserId(paymentForm.getOrderNo(), userId);
        ResponseVo responseVo = preCheckOrder(order, ResponseEnum.ORDER_PAYMENT_ERROR);
        if (responseVo != null) {
            return responseVo;
        }

        order.setStatus(OrderStatusEnum.PAID.getCode());
        order.setPaymentTime(new Date());
        int res = orderMapper.updateByPrimaryKeySelective(order);
        if (res == 0) {
            return ResponseVo.error();
        }
        return ResponseVo.success("支付成功！");
    }

    private ResponseVo preCheckOrder(Order order, ResponseEnum responseEnum) {
        if (order == null) {
            return ResponseVo.error(ResponseEnum.ORDER_NOT_FOUND);
        }

        Integer status = order.getStatus();
        if (!status.equals(OrderStatusEnum.UNPAID.getCode())) {
            return ResponseVo.error(responseEnum);
        }

        return null;
    }

    private Shipping buildShipping(Order order) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(order, shipping);
        return shipping;
    }

    private OrderVo buildOrderVo(Order order, List<OrderItem> orderItemList, Shipping shipping) {
        OrderVo orderVo = new OrderVo();
        BeanUtils.copyProperties(order, orderVo);

        List<OrderItemVo> orderItemVoList = orderItemList.stream().map(orderItem -> {
            OrderItemVo orderItemVo = new OrderItemVo();
            BeanUtils.copyProperties(orderItem, orderItemVo);
            return orderItemVo;
        }).collect(Collectors.toList());

        orderVo.setOrderItemVoList(orderItemVoList);
        orderVo.setShippingId(shipping.getId());
        orderVo.setShippingVo(buildShippingVo(shipping));
        return orderVo;
    }

    private Order buildOrder(List<OrderItem> orderItemList, Shipping shipping,
                             Integer userId, Long orderNo) {
        Order order = new Order();

        BigDecimal payment = BigDecimal.ZERO;
        for (OrderItem orderItem : orderItemList) {
            payment = payment.add(orderItem.getTotalPrice());
        }

        order.setOrderNo(orderNo);
        order.setUserId(userId);
        order.setShippingId(shipping.getId());
        order.setReceiverName(shipping.getReceiverName());
        order.setReceiverMobile(shipping.getReceiverMobile());
        order.setReceiverProvince(shipping.getReceiverProvince());
        order.setReceiverCity(shipping.getReceiverCity());
        order.setReceiverDistrict(shipping.getReceiverDistrict());
        order.setReceiverAddress(shipping.getReceiverAddress());
        order.setReceiverZip(shipping.getReceiverZip());
        order.setPayment(payment);
        order.setPaymentType(PaymentTypeEnum.VERIFY_CODE.getCode());
        order.setPostage(0);
        order.setStatus(OrderStatusEnum.UNPAID.getCode());

        return order;
    }

    private ShippingVo buildShippingVo(Shipping shipping) {
        ShippingVo shippingVo = new ShippingVo();
        BeanUtils.copyProperties(shipping, shippingVo);
        return shippingVo;
    }

    private OrderItem buildOrderItem(Product product, Integer quantity,
                                     Long orderNo, Integer userId) {
        OrderItem orderItem = new OrderItem();

        orderItem.setUserId(userId);
        orderItem.setOrderNo(orderNo);
        orderItem.setProductId(product.getId());
        orderItem.setProductName(product.getName());
        orderItem.setProductImage(product.getMainImage());
        orderItem.setCurrentUnitPrice(product.getPrice());
        orderItem.setQuantity(quantity);
        orderItem.setTotalPrice(product.getPrice()
                .multiply(BigDecimal.valueOf(quantity)));

        return orderItem;
    }

}
