package com.tablu.mall.service;

import com.github.pagehelper.PageInfo;
import com.tablu.mall.form.PaymentForm;
import com.tablu.mall.vo.OrderVo;
import com.tablu.mall.vo.ResponseVo;

public interface OrderService {

    ResponseVo<OrderVo> createOrder(Integer shippingId, Integer userId);

    ResponseVo<PageInfo> orderList(Integer pageSize, Integer pageNum, Integer userId);

    ResponseVo<OrderVo> detail(Integer orderNo, Integer userId);

    ResponseVo cancel(Integer orderNo, Integer userId);

    //TODO: 对接支付系统
    ResponseVo paymentOrder(PaymentForm paymentForm, Integer userId, String verifyCode);
}
