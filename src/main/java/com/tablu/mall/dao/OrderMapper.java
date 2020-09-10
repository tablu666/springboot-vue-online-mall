package com.tablu.mall.dao;

import com.tablu.mall.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByUserId(Integer userId);

    Order selectByOrderNoAndUserId(@Param("orderNo") Integer orderNo,
                              @Param("userId") Integer userId);

//    List<Order> selectAll();

    List<Order> selectOrderWithStatus(@Param("status") Integer status);
}