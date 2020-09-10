package com.tablu.mall.dao;

import com.tablu.mall.MallApplicationTests;
import com.tablu.mall.pojo.OrderItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class OrderItemMapperTest extends MallApplicationTests {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Test
    public void selectByOrderSet() {
        Set<Long> orderSet = new HashSet<>();
        orderSet.add((long) 2146620071);
        orderSet.add((long) 251071072);
        orderSet.add((long) 159187104);
        List<OrderItem> orderItemList = orderItemMapper.selectByOrderNoSet(orderSet);
        log.info("{}", orderItemList);
    }
}