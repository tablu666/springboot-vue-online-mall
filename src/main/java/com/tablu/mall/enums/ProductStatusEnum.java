package com.tablu.mall.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    ON_SALE(1),

    OFF_SALE(2),

    DELETE(3),

    ;

    private Integer code;

    ProductStatusEnum(Integer code) {
        this.code = code;
    }
}
