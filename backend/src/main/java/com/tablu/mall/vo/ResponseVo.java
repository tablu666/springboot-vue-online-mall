package com.tablu.mall.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tablu.mall.enums.ResponseEnum;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {

    private Integer status;
    private String msg;
    private T data;

    private ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ResponseVo(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseVo(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseVo<T> successByMsg(String msg) {
        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), data);
    }

    public static <T> ResponseVo<T> success() {
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
    }

    public static <T> ResponseVo<T> success(String msg, T data) {
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResponseVo<T> error() {
        return new ResponseVo<>(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
    }

    public static <T> ResponseVo<T> error(ResponseEnum responseEnum) {
        return new ResponseVo<>(responseEnum.getCode(), responseEnum.getDesc());
    }

    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, String msg) {
        return new ResponseVo<>(responseEnum.getCode(), msg);
    }
}
