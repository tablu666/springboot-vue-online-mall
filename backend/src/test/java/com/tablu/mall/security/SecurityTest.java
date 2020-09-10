package com.tablu.mall.security;

import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.dao.UserMapper;
import com.tablu.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class SecurityTest extends MallApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Test
    public void testPasswordMatching() {
        User user = userMapper.selectByPrimaryKey(1);
        String password = user.getPassword();
        String rawPassword = "123";
        boolean matches = encoder.matches(rawPassword, password);
        log.info("result={}", matches);
    }

}
