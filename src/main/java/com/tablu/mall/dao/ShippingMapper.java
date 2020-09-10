package com.tablu.mall.dao;

import com.tablu.mall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

//    Integer selectUserIdById(Integer id);

    List<Shipping> selectByUserId(Integer id);

    int deleteByIdAndUserId(@Param("shippingId") Integer shippingId,
                            @Param("userId") Integer userId);

    Shipping selectByIdAndUserId(@Param("shippingId") Integer shippingId,
                            @Param("userId") Integer userId);
}