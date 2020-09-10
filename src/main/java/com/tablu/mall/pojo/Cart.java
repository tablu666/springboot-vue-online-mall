package com.tablu.mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private Integer productId;

    private Integer quantity;

    private Boolean productSelected;

}
