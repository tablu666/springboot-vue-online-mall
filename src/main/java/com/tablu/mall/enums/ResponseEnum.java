package com.tablu.mall.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    ERROR(-1, "服务器错误，请联系管理员"),
    SUCCESS(0, "成功"),
    VERIFY_CODE_ERROR(1, "验证码错误"),
    USERNAME_OR_PASSWORD_ERROR(2, "用户名或密码错误"),
    USERNAME_EXIST(3, "用户名已存在"),
    EMAIL_EXIST(4, "邮箱已存在"),
    METHOD_ERROR(5,"请求方式错误"),
    AUTHORITY_ERROR(6, "权限不足，请联系管理员"),
    NEED_LOGIN(10,"未登录，请先登录"),
    PAGE_NOT_FOUND(11, "404页面未找到"),
    PARAM_ERROR(12, "参数错误，请联系管理员"),

    PRODUCT_STATUS_ERROR(13, "该商品已下架或删除"),
    PRODUCT_NOT_EXIST(20, "商品不存在"),
    PRODUCT_NOT_ON_SALE(25, "商品不是在售状态"),

    STOCK_NOT_ENOUGH(30, "库存不足"),

    CART_WITHOUT_PRODUCT(40, "购物车无此商品"),
    CART_SELECTED_EMPTY(50, "购物车无选中商品"),

    ORDER_CREATE_ERROR(60, "创建订单失败"),
    ORDER_NOT_FOUND(61, "没有找到订单"),
    ORDER_STATUS_ERROR(62, "该订单无法取消"),
    ORDER_PAYMENT_ERROR(63, "该订单无法支付"),

    MANAGEMENT_PARAM_ERROR(100, "操作失败，请检查参数是否有误！"),

    ;

    private Integer code;
    private String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
