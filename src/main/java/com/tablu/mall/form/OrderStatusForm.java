package com.tablu.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderStatusForm {

    private Integer status;

    @NotNull
    private Integer pageSize;

    @NotNull
    private Integer pageNum;
}
