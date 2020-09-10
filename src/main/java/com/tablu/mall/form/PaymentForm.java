package com.tablu.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PaymentForm {

    @NotNull
    private Integer orderNo;

    @NotBlank
    private String code;
}
