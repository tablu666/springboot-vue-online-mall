package com.tablu.mall.enums;

import lombok.Getter;

@Getter
public enum ShippingEnum {

    ADD_SUCCESS("新建地址成功"),
    ADD_ERROR("新建地址失败"),
    DELETE_SUCCESS("删除地址成功"),
    DELETE_ERROR("删除地址失败"),
    UPDATE_SUCCESS("更新地址成功"),
    UPDATE_ERROR("更新地址失败"),

    ;

    String msg;

    ShippingEnum(String msg) {
        this.msg = msg;
    }
}
