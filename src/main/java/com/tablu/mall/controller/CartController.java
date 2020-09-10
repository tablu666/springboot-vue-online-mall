package com.tablu.mall.controller;

import com.tablu.mall.form.CartAddForm;
import com.tablu.mall.form.CartUpdateForm;
import com.tablu.mall.pojo.User;
import com.tablu.mall.service.CartService;
import com.tablu.mall.vo.CartVo;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/carts")
    public ResponseVo<CartVo> list() {
        return cartService.cartList(getUserId());
    }

    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm) {
        return cartService.add(cartAddForm, getUserId());
    }

    @PutMapping("/carts/{productId}")
    public ResponseVo<CartVo> update(@PathVariable("productId") Integer productId, @RequestBody CartUpdateForm cartUpdateForm) {
        return cartService.update(cartUpdateForm, productId, getUserId());
    }

    @DeleteMapping("/carts/{productId}")
    public ResponseVo<CartVo> delete(@PathVariable("productId") Integer productId) {
        return cartService.delete(productId, getUserId());
    }

    @PutMapping("/carts/selectAll")
    public ResponseVo<CartVo> selectAll() {
        return cartService.selectAll(getUserId());
    }

    @PutMapping("/carts/unSelectAll")
    public ResponseVo<CartVo> unSelectAll() {
        return cartService.unSelectAll(getUserId());
    }

    @GetMapping("/carts/products/sum")
    public ResponseVo<Integer> sum() {
        return cartService.sum(getUserId());
    }

    private Integer getUserId() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getId();
    }
}
