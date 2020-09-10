package com.tablu.mall.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.dao.UserMapper;
import com.tablu.mall.pojo.User;
import com.tablu.mall.service.UserService;
import com.tablu.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void userRegister() throws JsonProcessingException {
        User user = new User();
        user.setUsername("goodman");
        user.setPassword("123");
        user.setEmail("employee@outlook.com");
//        user.setEmail("goodman@gmail.com");
//        User user = userMapper.selectByPrimaryKey(1);
        ResponseVo responseVo = userService.userRegister(user);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(responseVo);
        log.info("resp={}", s);
    }

}