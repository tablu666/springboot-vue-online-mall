#### 1.创建订单

**POST /orders**

> request

```
shippingId
```

> response

success

```
{
"status": 0,
  "data": {
    "orderNo": 1293350368,
    "payment": 12999.00,
    "paymentType": 2,
    "postage": 0,
    "status": 10,
    "orderItemVoList": [
      {
        "orderNo": 1293350368,
        "productId": 1,
        "productName": "Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机",
        "currentUnitPrice": 12999.00,
        "quantity": 1,
        "totalPrice": 12999.00
      }
    ],
    "shippingId": 7,
    "shippingVo": {
      "id": 7,
      "userId": 3,
      "receiverName": "大宝剑",
      "receiverMobile": "15088888888",
      "receiverProvince": "上海市",
      "receiverCity": "上海市",
      "receiverDistrict": "浦东新区",
      "receiverAddress": "菜鸟驿站",
      "receiverZip": "200120",
      "createTime": "Aug 24, 2020 9:40:27 PM",
      "updateTime": "Aug 24, 2020 9:40:27 PM"
    }
  }
}
```

fail
```
{
    "status": 60,
    "msg": "创建订单失败"
}
```

------

#### 2.订单List

**GET /orders**

> request

```
pageSize(default=10)
pageNum(default=1)
```

订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭

> response

success

```
{
    "status": 0,
    "data": {
        "total": 1,
        "list": [
            {
                "orderNo": 496061947,
                "payment": 14298,
                "paymentType": 2,
                "postage": 0,
                "status": 0,
                "paymentTime": null,
                "sendTime": null,
                "endTime": null,
                "closeTime": "2020-08-24T11:05:11.000+0000",
                "createTime": "2020-08-24T19:01:07.000+0000",
                "orderItemVoList": [
                    {
                        "orderNo": 496061947,
                        "productId": 1,
                        "productName": "Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机",
                        "productImage": null,
                        "currentUnitPrice": 12999,
                        "quantity": 1,
                        "totalPrice": 12999,
                        "createTime": "2020-08-24T19:01:07.000+0000"
                    },
                    {
                        "orderNo": 496061947,
                        "productId": 3,
                        "productName": "瑞克和莫蒂 Rick姥爷UFO迷你版",
                        "productImage": null,
                        "currentUnitPrice": 1299,
                        "quantity": 1,
                        "totalPrice": 1299,
                        "createTime": "2020-08-24T19:01:07.000+0000"
                    }
                ],
                "shippingId": 2,
                "shippingVo": {
                    "id": 2,
                    "userId": 3,
                    "receiverName": "大宝剑",
                    "receiverMobile": "15088888888",
                    "receiverProvince": "上海市",
                    "receiverCity": "上海市",
                    "receiverDistrict": "浦东新区",
                    "receiverAddress": "菜鸟驿站",
                    "receiverZip": "200120",
                    "createTime": "2020-08-24T19:01:07.000+0000",
                    "updateTime": "2020-08-24T19:01:07.000+0000"
                }
            }
        ],
        "pageNum": 1,
        "pageSize": 10,
        "size": 1,
        "startRow": 1,
        "endRow": 1,
        "pages": 1,
        "prePage": 0,
        "nextPage": 0,
        "isFirstPage": true,
        "isLastPage": true,
        "hasPreviousPage": false,
        "hasNextPage": false,
        "navigatePages": 8,
        "navigatepageNums": [
            1
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 1
    }
}
```

fail
```
{
  "status": 10,
  "msg": "用户未登录,请登录"
}
```

------

#### 3.订单详情

**GET /orders/{orderNo}**

> request

```
orderNo
```

> response

success

```
{
    "status": 0,
    "data": {
        "orderNo": 496061947,
        "payment": 14298,
        "paymentType": 2,
        "postage": 0,
        "status": 0,
        "paymentTime": null,
        "sendTime": null,
        "endTime": null,
        "closeTime": "2020-08-24T11:05:11.000+0000",
        "createTime": "2020-08-24T19:01:07.000+0000",
        "orderItemVoList": [
            {
                "orderNo": 496061947,
                "productId": 1,
                "productName": "Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机",
                "productImage": null,
                "currentUnitPrice": 12999,
                "quantity": 1,
                "totalPrice": 12999,
                "createTime": "2020-08-24T19:01:07.000+0000"
            },
            {
                "orderNo": 496061947,
                "productId": 3,
                "productName": "瑞克和莫蒂 Rick姥爷UFO迷你版",
                "productImage": null,
                "currentUnitPrice": 1299,
                "quantity": 1,
                "totalPrice": 1299,
                "createTime": "2020-08-24T19:01:07.000+0000"
            }
        ],
        "shippingId": 2,
        "shippingVo": {
            "id": 2,
            "userId": 3,
            "receiverName": "大宝剑",
            "receiverMobile": "15088888888",
            "receiverProvince": "上海市",
            "receiverCity": "上海市",
            "receiverDistrict": "浦东新区",
            "receiverAddress": "菜鸟驿站",
            "receiverZip": "200120",
            "createTime": "2020-08-24T19:01:07.000+0000",
            "updateTime": "2020-08-24T19:01:07.000+0000"
        }
    }
}
```

fail
```
{
  "status": 61,
  "msg": "没有找到订单"
}
```

------

#### 4.取消订单

**PUT /orders/{orderNo}**

> request

```
orderNo
```

> response

success

```
{
  "status": 0,
  "msg": "成功"
}

```

fail
```
{
  "status": 61,
  "msg": "没有找到订单"
}

或
{
  "status": 62,
  "msg": "该订单无法取消"
}
```

------

#### 5.支付订单
**POST /orders/payment**

> request

```
{
	"orderNo":"613527788",
	"code":"hsim"
}
```

> response

success

```
{
  "status": 0
  "msg": "支付成功"
}

```

fail
```
{
  "status": 61,
  "msg": "没有找到订单"
}

或
{
  "status": 63,
  "msg": "该订单无法支付"
}
```

------

