package com.tablu.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.service.ProductService;
import com.tablu.mall.vo.ProductDetailVo;
import com.tablu.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ProductServiceImplTest extends MallApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void productList() {
        ResponseVo<PageInfo> vo = productService.productList(100003, 1, 3);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(vo));
    }

    @Test
    public void productDetail() {
        ResponseVo<ProductDetailVo> vo = productService.productDetail(2);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(vo));
    }
}