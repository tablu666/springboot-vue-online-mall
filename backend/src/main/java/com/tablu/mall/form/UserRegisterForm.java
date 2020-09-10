package com.tablu.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
