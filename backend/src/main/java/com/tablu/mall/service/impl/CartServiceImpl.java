package com.tablu.mall.service.impl;

import com.google.gson.Gson;
import com.tablu.mall.dao.ProductMapper;
import com.tablu.mall.enums.ProductStatusEnum;
import com.tablu.mall.enums.ResponseEnum;
import com.tablu.mall.form.CartAddForm;
import com.tablu.mall.form.CartUpdateForm;
import com.tablu.mall.pojo.Cart;
import com.tablu.mall.pojo.Product;
import com.tablu.mall.service.CartService;
import com.tablu.mall.vo.CartProductVo;
import com.tablu.mall.vo.CartVo;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private static final String CART_KEY = "cart_%d";
    private static final Integer DEFAULT_ADD_QUANTITY = 1;
    private static final Boolean SELECTED_CONDITION = true;
    private static final Boolean UNSELECTED_CONDITION = false;
    private Gson gson = new Gson();

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public ResponseVo<CartVo> cartList(Integer userId) {
        String redisKey = String.format(CART_KEY, userId);
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        Map<String, String> productIdCartMap = opsForHash.entries(redisKey);

        BigDecimal cartTotalPrice = BigDecimal.ZERO;
        Integer cartTotalQuantity = 0;
        //购物车默认全选
        boolean selectedAll = true;

        List<Integer> productIdList = new ArrayList<>();
        for (String strProductId : productIdCartMap.keySet()) {
            productIdList.add(Integer.valueOf(strProductId));
        }

        List<Product> productList = productMapper.selectByProductIdList(productIdList);
        if (productList == null) {
            CartVo cartVo = new CartVo(new ArrayList<>(), true, cartTotalPrice, cartTotalQuantity);
            return ResponseVo.success(cartVo);
        }

        List<CartProductVo> cartProductVoList = productList.stream()
                .map(product -> {
            Cart cart = gson.fromJson(productIdCartMap.get(String.valueOf(product.getId())), Cart.class);
            return new CartProductVo(
                    product.getId(),
                    cart.getQuantity(),
                    product.getName(),
                    product.getSubtitle(),
                    product.getMainImage(),
                    product.getPrice(),
                    product.getStatus(),
                    product.getPrice().multiply(BigDecimal.valueOf(cart.getQuantity())),
                    product.getStock(),
                    cart.getProductSelected());
        }).collect(Collectors.toList());

        for (CartProductVo cartProductVo : cartProductVoList) {
            if (selectedAll && !cartProductVo.getProductSelected()) {
                selectedAll = false;
            }
            if (cartProductVo.getProductSelected()) {
                cartTotalPrice = cartTotalPrice.add(cartProductVo.getProductTotalPrice());
            }
            cartTotalQuantity += cartProductVo.getQuantity();
        }

        CartVo cartVo = new CartVo(
                cartProductVoList,
                selectedAll,
                cartTotalPrice,
                cartTotalQuantity);

        return ResponseVo.success(cartVo);
    }

    @Override
    public ResponseVo<CartVo> add(CartAddForm cartAddForm, Integer userId) {
        Integer productId = cartAddForm.getProductId();
        //商品是否存在？是否在售？是否有库存？
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }

        if (!product.getStatus().equals(ProductStatusEnum.ON_SALE.getCode())) {
            return ResponseVo.error(ResponseEnum.PRODUCT_STATUS_ERROR);
        }

        if (product.getStock() < 1) {
            return ResponseVo.error(ResponseEnum.STOCK_NOT_ENOUGH);
        }

        //uid, productId, cart
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_KEY, userId);
        String strCart = opsForHash.get(redisKey, String.valueOf(productId));
        Cart cart;
        if (StringUtils.isEmpty(strCart)) {
            cart = new Cart(productId, DEFAULT_ADD_QUANTITY, cartAddForm.getSelected());
        } else {
            cart = gson.fromJson(strCart, Cart.class);
            cart.setQuantity(cart.getQuantity() + DEFAULT_ADD_QUANTITY);
        }
        opsForHash.put(redisKey, String.valueOf(productId), gson.toJson(cart));

        return cartList(userId);
    }

    @Override
    public ResponseVo<CartVo> update(CartUpdateForm cartUpdateForm, Integer productId, Integer userId) {
        String redisKey = String.format(CART_KEY, userId);
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String strCart = opsForHash.get(redisKey, String.valueOf(productId));

        if (StringUtils.isEmpty(strCart)) {
            return ResponseVo.error(ResponseEnum.CART_WITHOUT_PRODUCT);
        }

        Cart cart = gson.fromJson(strCart, Cart.class);
        if (cartUpdateForm.getQuantity() != null && cartUpdateForm.getQuantity() >= 0) {
            cart.setQuantity(cartUpdateForm.getQuantity());
        }
        if (cartUpdateForm.getSelected() != null) {
            cart.setProductSelected(cartUpdateForm.getSelected());
        }
        opsForHash.put(redisKey, String.valueOf(productId), gson.toJson(cart));

        return cartList(userId);
    }

    @Override
    public ResponseVo<CartVo> delete(Integer productId, Integer userId) {
        if (!deleteFromCart(productId, userId)) {
            return ResponseVo.error(ResponseEnum.CART_WITHOUT_PRODUCT);
        }
        return cartList(userId);
    }

    @Override
    public boolean deleteByOrder(Integer productId, Integer userId) {
        return deleteFromCart(productId, userId);
    }

    private boolean deleteFromCart(Integer productId, Integer userId) {
        String redisKey = String.format(CART_KEY, userId);
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String strCart = opsForHash.get(redisKey, String.valueOf(productId));

        if (StringUtils.isEmpty(strCart)) {
            return false;
        }

        opsForHash.delete(redisKey, String.valueOf(productId));
        return true;
    }

    @Override
    public ResponseVo<CartVo> selectAll(Integer userId) {
        return setSelectedCondition(SELECTED_CONDITION, userId);
    }

    @Override
    public ResponseVo<CartVo> unSelectAll(Integer userId) {
        return setSelectedCondition(UNSELECTED_CONDITION, userId);
    }

    @Override
    public ResponseVo<Integer> sum(Integer userId) {
        String redisKey = String.format(CART_KEY, userId);
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        Map<String, String> productIdCartMap = opsForHash.entries(redisKey);
        Integer quantity = 0;
        for (String strCart : productIdCartMap.values()) {
            Cart cart = gson.fromJson(strCart, Cart.class);
            quantity += cart.getQuantity();
        }
        return ResponseVo.success(quantity);
    }

    @Override
    public List<Cart> cartUnitList(Integer userId) {
        String redisKey = String.format(CART_KEY, userId);
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        Map<String, String> productIdCartMap = opsForHash.entries(redisKey);
        List<Cart> carts = new ArrayList<>();
        for (String srtCart : productIdCartMap.values()) {
            Cart cart = gson.fromJson(srtCart, Cart.class);
            carts.add(cart);
        }

        return carts;
    }

    private ResponseVo<CartVo> setSelectedCondition(boolean condition, Integer userId) {
        String redisKey = String.format(CART_KEY, userId);
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        Map<String, String> productIdCartMap = opsForHash.entries(redisKey);
        for (Map.Entry<String, String> entry : productIdCartMap.entrySet()) {
            String strProductId = entry.getKey();
            Cart cart = gson.fromJson(entry.getValue(), Cart.class);
            cart.setProductSelected(condition);
            opsForHash.put(redisKey, strProductId, gson.toJson(cart));
        }
        return cartList(userId);
    }

}
