package com.tablu.mall.service;

import com.github.pagehelper.PageInfo;
import com.tablu.mall.form.ShippingForm;
import com.tablu.mall.vo.ResponseVo;

import java.util.Map;

public interface ShippingService {

    ResponseVo<Map<String,Integer>> add(ShippingForm shippingForm, Integer userId);

    ResponseVo delete(Integer shippingId, Integer userId);

    ResponseVo update(ShippingForm shippingForm, Integer shippingId, Integer userId);

    ResponseVo<PageInfo> getShippingList(Integer pageNum, Integer pageSize, Integer userId);
}
