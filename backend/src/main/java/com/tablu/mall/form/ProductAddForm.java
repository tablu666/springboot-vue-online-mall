package com.tablu.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductAddForm {

    @NotNull
    private Integer categoryId;

    @NotNull
    private Byte markId;

    @NotBlank
    private String name;

    @NotBlank
    private String subtitle;

    private String mainImage;

    private String subImages;

    private String detail;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer stock;

    @NotNull
    private Integer status;
}
