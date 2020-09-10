package com.tablu.mall.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

    CANCEL(0, "已取消"),
    UNPAID(10, "未付款"),
    PAID(20, "已付款"),
    SHIPPED(40, "已发货"),
    SUCCESS(50, "交易成功"),
    BLOCK(60, "交易关闭"),

    ;

    private Integer code;
    private String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
