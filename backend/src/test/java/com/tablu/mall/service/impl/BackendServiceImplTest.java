package com.tablu.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.pojo.Product;
import com.tablu.mall.pojo.Role;
import com.tablu.mall.pojo.User;
import com.tablu.mall.service.BackendService;
import com.tablu.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class BackendServiceImplTest extends MallApplicationTests {

    @Autowired
    private BackendService backendService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void filteredOrders() {
        //订单状态:0-已取消,10-未付款,20-已付款,40-已发货,50-交易成功,60-交易关闭
        ResponseVo<PageInfo> vo = backendService.filteredOrders(10, 1, 10);
        log.info("{}", gson.toJson(vo));
    }

    @Test
    public void customerOrder() {
        ResponseVo<PageInfo> vo = backendService.customerOrder(4, 1, 3);
        log.info("{}", gson.toJson(vo));
    }

    @Test
    public void roleList() {
        ResponseVo<List<Role>> vo = backendService.roleList();
        log.info("{}", gson.toJson(vo));
    }

    @Test
    public void productList() {
        ResponseVo<List<Product>> vo = backendService.productList();
        log.info("{}", gson.toJson(vo));
    }

    @Test
    public void getUser() {
        ResponseVo<User> vo = backendService.getUser("jimmy");
        log.info("{}", gson.toJson(vo));
    }

    @Test
    public void userList() {
        ResponseVo<List<User>> vo = backendService.userList();
        log.info("{}", gson.toJson(vo));
    }
}