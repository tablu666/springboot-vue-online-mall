package com.tablu.mall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role implements GrantedAuthority {

    private Integer id;

    private String roleName;

    private String roleDesc;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}