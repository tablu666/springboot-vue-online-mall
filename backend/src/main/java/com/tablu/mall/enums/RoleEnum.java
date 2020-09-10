package com.tablu.mall.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

    CUSTOMER_SHIPPING("/shippings/**","ROLE_CUSTOMER"),
    CUSTOMER_CART("/carts/**","ROLE_CUSTOMER"),
    CUSTOMER_ORDER("/orders/**","ROLE_CUSTOMER"),
    EMPLOYEE_SELLER("/seller/**","ROLE_EMPLOYEE"),
    MANAGER_SELLER("/seller/**","ROLE_MANAGER"),
    MANAGER_MANAGEMENT("/management/**","ROLE_MANAGER"),

    ;

    private String url;
    private String roleName;

    RoleEnum(String url, String roleName) {
        this.url = url;
        this.roleName = roleName;
    }
}
