package com.tablu.mall.service;

import com.tablu.mall.pojo.QueryCategory;
import com.tablu.mall.vo.CategoryVo;
import com.tablu.mall.vo.ResponseVo;

import java.util.List;

public interface CategoryService {

    ResponseVo<List<CategoryVo>> getCategories();

    QueryCategory getCategoryIdAndMarkSet(Integer categoryId);
}
