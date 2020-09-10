package com.tablu.mall.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.pojo.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class RoleMapperTest extends MallApplicationTests {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void selectAll() {
        List<Role> roleList = roleMapper.selectAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("roleList={}", gson.toJson(roleList));
    }
}