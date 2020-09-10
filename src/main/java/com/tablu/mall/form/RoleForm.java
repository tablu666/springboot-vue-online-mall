package com.tablu.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RoleForm {

    @NotNull
    private Integer id;

    @NotBlank
    private String roleName;

    @NotBlank
    private String roleDesc;
}
