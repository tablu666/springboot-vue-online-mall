package com.tablu.mall.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.service.OrderService;
import com.tablu.mall.vo.OrderVo;
import com.tablu.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Slf4j
@Transactional
public class OrderServiceImplTest extends MallApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void createOrder() {
        ResponseVo<OrderVo> vo = orderService.createOrder(7, 3);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(vo));
    }
}