package com.tablu.mall.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ShippingVo {

    private Integer id;

    private Integer userId;

    private String receiverName;

    private String receiverMobile;

    private String receiverProvince;

    private String receiverCity;

    private String receiverDistrict;

    private String receiverAddress;

    private String receiverZip;

    private Date createTime;

    private Date updateTime;
}
