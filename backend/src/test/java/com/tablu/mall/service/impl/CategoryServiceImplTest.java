package com.tablu.mall.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.service.CategoryService;
import com.tablu.mall.vo.CategoryVo;
import com.tablu.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class CategoryServiceImplTest extends MallApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void getCategories() {
        ResponseVo<List<CategoryVo>> vo = categoryService.getCategories();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("resp={}", gson.toJson(vo));
    }

}