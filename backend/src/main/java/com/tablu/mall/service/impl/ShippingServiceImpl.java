package com.tablu.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tablu.mall.dao.ShippingMapper;
import com.tablu.mall.enums.ResponseEnum;
import com.tablu.mall.enums.ShippingEnum;
import com.tablu.mall.form.ShippingForm;
import com.tablu.mall.pojo.Shipping;
import com.tablu.mall.service.ShippingService;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public ResponseVo<Map<String,Integer>> add(ShippingForm shippingForm, Integer userId) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(shippingForm, shipping);
        shipping.setUserId(userId);
        int res = shippingMapper.insertSelective(shipping);
        if (res == 0) {
            return ResponseVo.error(ResponseEnum.ERROR, ShippingEnum.ADD_ERROR.getMsg());
        }

        Map<String,Integer> resultMap = new HashMap<>();
        resultMap.put("shippingId", shipping.getId());
        return ResponseVo.success(ShippingEnum.ADD_SUCCESS.getMsg(), resultMap);
    }

    @Override
    public ResponseVo delete(Integer shippingId, Integer userId) {
        int res = shippingMapper.deleteByIdAndUserId(shippingId, userId);
        if (res == 0) {
            return ResponseVo.error(ResponseEnum.ERROR, ShippingEnum.DELETE_ERROR.getMsg());
        }

        return ResponseVo.successByMsg(ShippingEnum.DELETE_SUCCESS.getMsg());
    }

    @Override
    public ResponseVo update(ShippingForm shippingForm, Integer shippingId, Integer userId) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(shippingForm, shipping);
        shipping.setId(shippingId);
        shipping.setUserId(userId);
        int res = shippingMapper.updateByPrimaryKeySelective(shipping);
        if (res == 0) {
            return ResponseVo.error(ResponseEnum.ERROR, ShippingEnum.UPDATE_ERROR.getMsg());
        }
        return ResponseVo.successByMsg(ShippingEnum.UPDATE_SUCCESS.getMsg());
    }

    @Override
    public ResponseVo<PageInfo> getShippingList(Integer pageNum, Integer pageSize, Integer userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippings = shippingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippings);
        return ResponseVo.success(pageInfo);
    }


}
