package com.tablu.mall.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
public class UserMapperTest extends MallApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("user={}", gson.toJson(user));
    }

    @Test
    public void selectByUsername() {
        User user = userMapper.selectByUsername("jimmy");
        log.info("user={}", user);
    }

    @Test
    public void countByUsername() {
        int res = userMapper.countByUsername("employee");
        log.info("res={}", res);
    }

    @Test
    public void countByEmail() {
        int res = userMapper.countByEmail("employee@outlook.com");
        log.info("res={}", res);
    }

    @Test
    public void getIdByUsername() {
        int id = userMapper.getIdByUsername("employee");
        log.info("id={}", id);
    }

    @Test
    public void insertSelective() {
        User user = new User();
        user.setUsername("kim");
        user.setPassword(passwordEncoder.encode("123"));
        user.setEmail("justicematters@gmail.com");
        int res = userMapper.insertSelective(user);
        log.info("res={}", res);
    }

}