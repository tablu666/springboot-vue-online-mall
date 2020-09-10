package com.tablu.mall.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {

    private Integer id;

    private Long orderNo;

    private Integer userId;

    private Integer shippingId;

    private String receiverName;

    private String receiverMobile;

    private String receiverProvince;

    private String receiverCity;

    private String receiverDistrict;

    private String receiverAddress;

    private String receiverZip;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer postage;

    private Integer status;

    private Date paymentTime;

    private Date sendTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;

}