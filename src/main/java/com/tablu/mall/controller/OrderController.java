package com.tablu.mall.controller;

import com.github.pagehelper.PageInfo;
import com.tablu.mall.form.OrderCreateForm;
import com.tablu.mall.form.PaymentForm;
import com.tablu.mall.pojo.User;
import com.tablu.mall.service.OrderService;
import com.tablu.mall.vo.OrderVo;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseVo<OrderVo> create(@Valid @RequestBody OrderCreateForm orderCreateForm) {
        return orderService.createOrder(orderCreateForm.getShippingId(), getUserId());
    }

    @GetMapping("/orders")
    public ResponseVo<PageInfo> orderList(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(required = false, defaultValue = "1") Integer pageNum) {
        return orderService.orderList(pageSize, pageNum, getUserId());
    }

    @GetMapping("/orders/{orderNo}")
    public ResponseVo<OrderVo> detail(@PathVariable("orderNo") Integer orderNo) {
        return orderService.detail(orderNo, getUserId());
    }

    @PutMapping("/orders/{orderNo}")
    public ResponseVo cancel(@PathVariable("orderNo") Integer orderNo) {
        return orderService.cancel(orderNo, getUserId());
    }

    @PostMapping("/orders/payment")
    public ResponseVo payment(@Valid @RequestBody PaymentForm paymentForm,
                              HttpServletRequest request) {
        String verifyCode = (String) request.getSession().getAttribute("verify_code");
        return orderService.paymentOrder(paymentForm, getUserId(), verifyCode);
    }

    private Integer getUserId() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getId();
    }
}
