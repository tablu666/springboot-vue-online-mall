package com.tablu.mall.service;

import com.tablu.mall.form.CartAddForm;
import com.tablu.mall.form.CartUpdateForm;
import com.tablu.mall.pojo.Cart;
import com.tablu.mall.vo.CartVo;
import com.tablu.mall.vo.ResponseVo;

import java.util.List;

public interface CartService {

    ResponseVo<CartVo> cartList(Integer userId);

    ResponseVo<CartVo> add(CartAddForm cartAddForm, Integer userId);

    ResponseVo<CartVo> update(CartUpdateForm cartUpdateForm, Integer productId, Integer userId);

    ResponseVo<CartVo> delete(Integer productId, Integer userId);

    boolean deleteByOrder(Integer productId, Integer userId);

    ResponseVo<CartVo> selectAll(Integer userId);

    ResponseVo<CartVo> unSelectAll(Integer userId);

    ResponseVo<Integer> sum(Integer userId);

    List<Cart> cartUnitList(Integer userId);
}
