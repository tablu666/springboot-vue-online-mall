package com.tablu.mall.dao;

import com.tablu.mall.pojo.Product;
import com.tablu.mall.pojo.QueryCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

//    List<Product> selectByCategoryId(@Param("categoryIdSet") Set<Integer> categoryId);

    List<Product> selectByQueryCategory(@Param("queryCategory") QueryCategory queryCategory);

    List<Product> selectByProductIdList(@Param("productIdList") List<Integer> productIdList);

    List<Product> selectAll();
}