package com.tablu.mall.utils;


import java.util.UUID;

public class UUIDUtil {

    public static Long getUUIDInOrderNo() {
        return (long) Math.abs(UUID.randomUUID().toString().hashCode());
    }

}
