package com.tablu.mall.controller;

import com.github.pagehelper.PageInfo;
import com.tablu.mall.form.ShippingForm;
import com.tablu.mall.pojo.User;
import com.tablu.mall.service.ShippingService;
import com.tablu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@RestController
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/shippings")
    public ResponseVo<Map<String,Integer>> add(@Valid @RequestBody ShippingForm shippingForm) {
        return shippingService.add(shippingForm, getUserId());
    }

    @DeleteMapping("/shippings/{shippingId}")
    public ResponseVo delete(@PathVariable("shippingId") Integer shippingId) {
        return shippingService.delete(shippingId, getUserId());
    }

    @PutMapping("/shippings/{shippingId}")
    public ResponseVo update(@Valid @RequestBody ShippingForm shippingForm,
                             @PathVariable("shippingId") Integer shippingId) {
        return shippingService.update(shippingForm, shippingId, getUserId());
    }

    @GetMapping("/shippings")
    public ResponseVo<PageInfo> getShipping(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return shippingService.getShippingList(pageNum, pageSize, getUserId());
    }

    private Integer getUserId() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getId();
    }
}
