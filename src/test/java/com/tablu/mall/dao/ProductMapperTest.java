package com.tablu.mall.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.pojo.Product;
import com.tablu.mall.pojo.QueryCategory;
import com.tablu.mall.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductMapperTest extends MallApplicationTests {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryService categoryService;

    @Test
    public void selectByQueryCategory() {
        QueryCategory queryCategory = categoryService.getCategoryIdAndMarkSet(100001);
//        queryCategory.setMarkSet(new HashSet<>());
        List<Product> products = productMapper.selectByQueryCategory(queryCategory);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(products);
        log.info("productList={}", s);
    }

    @Test
    public void selectByProductIdList() {
        List<Integer> productIdList = new ArrayList<>();
//        productIdList.add(1);
//        productIdList.add(2);
//        productIdList.add(4);
        List<Product> products = productMapper.selectByProductIdList(productIdList);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("products={}", gson.toJson(products));
    }
}