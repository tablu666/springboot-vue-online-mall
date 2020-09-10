package com.tablu.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.form.ShippingForm;
import com.tablu.mall.service.ShippingService;
import com.tablu.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Transactional
public class ShippingServiceImplTest extends MallApplicationTests {

    @Autowired
    private ShippingService shippingService;

    @Test
    public void add() {
        ShippingForm shippingForm = new ShippingForm();
        shippingForm.setReceiverName("大宝剑");
        shippingForm.setReceiverAddress("菜鸟驿站");
        shippingForm.setReceiverCity("上海市");
        shippingForm.setReceiverDistrict("浦东新区");
        shippingForm.setReceiverMobile("15088888888");
        shippingForm.setReceiverProvince("上海市");
        shippingForm.setReceiverZip("200120");
        ResponseVo<Map<String, Integer>> vo = shippingService.add(shippingForm, 3);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(vo));
    }

    @Test
    public void delete() {
        ResponseVo vo = shippingService.delete(4, 1);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(vo));
    }

    @Test
    public void update() {
        ShippingForm shippingForm = new ShippingForm();
        shippingForm.setReceiverName("奥利给");
        ResponseVo vo = shippingService.update(shippingForm, 5, 1);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(vo));
    }

    @Test
    public void getShippingList() {
        ResponseVo<PageInfo> vo = shippingService.getShippingList(1, 3, 1);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(vo));
    }
}