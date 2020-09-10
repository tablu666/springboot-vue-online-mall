package com.tablu.mall.enums;

import lombok.Getter;

@Getter
public enum  PaymentTypeEnum {

    ON_LINE(1, "在线支付"),
    VERIFY_CODE(2, "验证码支付"),
    ;

    private Integer code;
    private String desc;

    PaymentTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
