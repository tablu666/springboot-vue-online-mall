package com.tablu.mall.dao;

import com.tablu.mall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    int insertByOrderItemList(@Param("orderItemList") List<OrderItem> orderItemList,
                              @Param("userId") Integer userId);

    List<OrderItem> selectByOrderNoSet(@Param("orderNoSet") Set<Long> orderNoSet);

    List<OrderItem> selectByOrderNo(Integer orderNo);

}