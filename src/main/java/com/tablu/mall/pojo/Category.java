package com.tablu.mall.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Category {

    private Integer id;

    private Integer parentId;

    private String name;

    private Boolean status;

    private Byte mark;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

}