package com.tablu.mall.dao;

import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.pojo.Shipping;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
public class ShippingMapperTest extends MallApplicationTests {

    @Autowired
    private ShippingMapper shippingMapper;

    @Test
    public void deleteByIdAndUid() {
        int res = shippingMapper.deleteByIdAndUserId(6, 1);
        log.info("res={}", res);
    }

    @Test
    public void selectByIdAndUserId() {
        Shipping shipping = shippingMapper.selectByIdAndUserId(1, 2);
        log.info("shipping={}", shipping);
    }
}