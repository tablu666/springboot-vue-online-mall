package com.tablu.mall.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class QueryCategory {

    Set<Integer> categoryIdSet;

    Set<Byte> markSet;
}
