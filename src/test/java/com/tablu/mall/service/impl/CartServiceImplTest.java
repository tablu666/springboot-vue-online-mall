package com.tablu.mall.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.pojo.Cart;
import com.tablu.mall.service.CartService;
import com.tablu.mall.vo.CartVo;
import com.tablu.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
public class CartServiceImplTest extends MallApplicationTests {

    @Autowired
    private CartService cartService;

    @Test
    public void cartList() {
        ResponseVo<CartVo> vo = cartService.cartList(3);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(vo));
    }


    @Test
    public void selectAll() {
        ResponseVo<CartVo> vo = cartService.selectAll(3);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(vo));
    }

    @Test
    public void cartUnitList() {
        List<Cart> carts = cartService.cartUnitList(3);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(carts));
    }
}