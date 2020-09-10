package com.tablu.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tablu.mall.dao.OrderItemMapper;
import com.tablu.mall.dao.OrderMapper;
import com.tablu.mall.dao.ProductMapper;
import com.tablu.mall.dao.RoleMapper;
import com.tablu.mall.enums.ResponseEnum;
import com.tablu.mall.form.ProductAddForm;
import com.tablu.mall.form.ProductUpdateForm;
import com.tablu.mall.form.RoleForm;
import com.tablu.mall.pojo.*;
import com.tablu.mall.service.BackendService;
import com.tablu.mall.service.OrderService;
import com.tablu.mall.service.UserService;
import com.tablu.mall.vo.OrderItemVo;
import com.tablu.mall.vo.OrderVo;
import com.tablu.mall.vo.ResponseVo;
import com.tablu.mall.vo.ShippingVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BackendServiceImpl implements BackendService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Override
    public ResponseVo<PageInfo> filteredOrders(Integer pageSize, Integer pageNum, Integer status) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.selectOrderWithStatus(status);
        return getPageInfoResponseVo(orders);
    }

    private ResponseVo<PageInfo> getPageInfoResponseVo(List<Order> orders) {
        Set<Long> orderNoSet = orders.stream().map(Order::getOrderNo)
                .collect(Collectors.toSet());
        List<OrderItem> orderItemList = orderItemMapper.selectByOrderNoSet(orderNoSet);
        Map<Long, List<OrderItem>> orderNoItemMap = orderItemList.stream().
                collect(Collectors.groupingBy(OrderItem::getOrderNo));

        List<OrderVo> orderVoList = orders.stream()
                .map(order -> buildOrderVo(order, orderNoItemMap.get(order.getOrderNo())))
                .collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo(orders);
        pageInfo.setList(orderVoList);
        return ResponseVo.success(pageInfo);
    }

    private OrderVo buildOrderVo(Order order, List<OrderItem> orderItemList) {
        OrderVo orderVo = new OrderVo();
        BeanUtils.copyProperties(order, orderVo);

        ShippingVo shippingVo = new ShippingVo();
        BeanUtils.copyProperties(order, shippingVo);
        orderVo.setShippingVo(shippingVo);

        List<OrderItemVo> orderItemVoList = orderItemList.stream().map(orderItem -> {
            OrderItemVo orderItemVo = new OrderItemVo();
            BeanUtils.copyProperties(orderItem, orderItemVo);
            return orderItemVo;
        }).collect(Collectors.toList());

        orderVo.setOrderItemVoList(orderItemVoList);
        return orderVo;
    }

    @Override
    public ResponseVo<PageInfo> customerOrder(Integer pageSize, Integer pageNum, Integer userId) {
        return orderService.orderList(pageSize, pageNum, userId);
    }

    @Override
    public ResponseVo<List<Role>> roleList() {
        List<Role> roleList = roleMapper.selectAll();
        return ResponseVo.success(roleList);
    }

    @Override
    public ResponseVo<Role> addRole(RoleForm roleForm) {
        Role role = new Role();
        BeanUtils.copyProperties(roleForm, role);
        int res = roleMapper.insertSelective(role);
        if (res == 0) {
            return ResponseVo.error();
        }
        return ResponseVo.success(role);
    }

    @Override
    public ResponseVo<Role> updateRole(RoleForm roleForm) {
        Role role = new Role();
        BeanUtils.copyProperties(roleForm, role);
        int res = roleMapper.updateByPrimaryKeySelective(role);
        if (res == 0) {
            return ResponseVo.error();
        }
        return ResponseVo.success(role);
    }

    @Override
    public ResponseVo<List<Product>> productList() {
        List<Product> productList = productMapper.selectAll();
        return ResponseVo.success(productList);
    }

    @Override
    public ResponseVo<Product> addProduct(ProductAddForm productAddForm) {
        Product product = new Product();
        BeanUtils.copyProperties(productAddForm, product);
        int res = productMapper.insertSelective(product);
        if (res == 0) {
            return ResponseVo.error();
        }
        Product productRes = productMapper.selectByPrimaryKey(product.getId());
        return ResponseVo.success(productRes);
    }

    @Override
    public ResponseVo<Product> updateProduct(ProductUpdateForm productUpdateForm) {
        Product product = new Product();
        BeanUtils.copyProperties(productUpdateForm, product);
        int res = productMapper.updateByPrimaryKeySelective(product);
        if (res == 0) {
            return ResponseVo.error(ResponseEnum.MANAGEMENT_PARAM_ERROR);
        }
        Product productRes = productMapper.selectByPrimaryKey(product.getId());
        return ResponseVo.success(productRes);
    }

    @Override
    public ResponseVo<User> getUser(String username) {
        return userService.userProfileByManagement(username);
    }

    @Override
    public ResponseVo<List<User>> userList() {
        return userService.userListByManagement();
    }

}
