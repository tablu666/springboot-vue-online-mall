package com.tablu.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductUpdateForm {

    @NotNull
    private Integer id;

    private Integer categoryId;

    private Byte markId;

    private String name;

    private String subtitle;

    private String mainImage;

    private String subImages;

    private String detail;

    private BigDecimal price;

    private Integer stock;

    private Integer status;
}
