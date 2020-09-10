package com.tablu.mall.controller;

import com.tablu.mall.service.CategoryService;
import com.tablu.mall.vo.CategoryVo;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> categories() {
        return categoryService.getCategories();
    }
}
