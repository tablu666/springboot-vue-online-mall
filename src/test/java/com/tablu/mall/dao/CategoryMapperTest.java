package com.tablu.mall.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.pojo.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Transactional
@Slf4j
public class CategoryMapperTest extends MallApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void selectAll() {
        List<Category> categories = categoryMapper.selectAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(categories);
        log.info("categories={}", s);
    }
}