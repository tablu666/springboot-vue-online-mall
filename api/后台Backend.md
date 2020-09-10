#### 1.所有订单（订单状态）

**GET /seller**

> request

```
pageSize(default=10)
pageNum(default=1)
status 可不传
```
订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭


> response

success

```
{
    "status": 0,
    "data": {
        "total": 3,
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
                "orderItemVoList": null,
                "shippingId": 7,
                "shippingVo": null
            },
            {
                "orderNo": 744698850,
                "payment": 14298,
                "paymentType": 2,
                "postage": 0,
                "status": 20,
                "paymentTime": "2020-08-24T13:09:37.000+0000",
                "sendTime": null,
                "endTime": null,
                "closeTime": null,
                "createTime": "2020-08-24T21:04:47.000+0000",
                "orderItemVoList": null,
                "shippingId": 7,
                "shippingVo": null
            },
            {
                "orderNo": 530441001,
                "payment": 25998,
                "paymentType": 2,
                "postage": 0,
                "status": 0,
                "paymentTime": null,
                "sendTime": null,
                "endTime": null,
                "closeTime": "2020-08-24T13:43:52.000+0000",
                "createTime": "2020-08-24T21:17:12.000+0000",
                "orderItemVoList": null,
                "shippingId": 7,
                "shippingVo": null
            }
        ],
        "pageNum": 1,
        "pageSize": 10,
        "size": 3,
        "startRow": 1,
        "endRow": 3,
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
    "status": 6,
    "msg": "权限不足，请联系管理员"
}
```

------

#### 2.客户订单

**GET /seller/{userId}**

> request

```
pageSize(default=10)
pageNum(default=1)
userId=3
```

> response

success

```
{
    "status": 0,
    "data": {
        "total": 3,
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
            },
            {
                "orderNo": 744698850,
                "payment": 14298,
                "paymentType": 2,
                "postage": 0,
                "status": 20,
                "paymentTime": "2020-08-24T13:09:37.000+0000",
                "sendTime": null,
                "endTime": null,
                "closeTime": null,
                "createTime": "2020-08-24T21:04:47.000+0000",
                "orderItemVoList": [
                    {
                        "orderNo": 744698850,
                        "productId": 3,
                        "productName": "瑞克和莫蒂 Rick姥爷UFO迷你版",
                        "productImage": null,
                        "currentUnitPrice": 1299,
                        "quantity": 1,
                        "totalPrice": 1299,
                        "createTime": "2020-08-24T21:04:47.000+0000"
                    },
                    {
                        "orderNo": 744698850,
                        "productId": 1,
                        "productName": "Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机",
                        "productImage": null,
                        "currentUnitPrice": 12999,
                        "quantity": 1,
                        "totalPrice": 12999,
                        "createTime": "2020-08-24T21:04:47.000+0000"
                    }
                ],
                "shippingId": 3,
                "shippingVo": {
                    "id": 3,
                    "userId": 3,
                    "receiverName": "大宝剑",
                    "receiverMobile": "15088888888",
                    "receiverProvince": "上海市",
                    "receiverCity": "上海市",
                    "receiverDistrict": "浦东新区",
                    "receiverAddress": "菜鸟驿站",
                    "receiverZip": "200120",
                    "createTime": "2020-08-24T21:04:47.000+0000",
                    "updateTime": "2020-08-24T21:04:47.000+0000"
                }
            },
            {
                "orderNo": 530441001,
                "payment": 25998,
                "paymentType": 2,
                "postage": 0,
                "status": 0,
                "paymentTime": null,
                "sendTime": null,
                "endTime": null,
                "closeTime": "2020-08-24T13:43:52.000+0000",
                "createTime": "2020-08-24T21:17:12.000+0000",
                "orderItemVoList": [
                    {
                        "orderNo": 530441001,
                        "productId": 1,
                        "productName": "Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机",
                        "productImage": null,
                        "currentUnitPrice": 12999,
                        "quantity": 2,
                        "totalPrice": 25998,
                        "createTime": "2020-08-24T21:17:12.000+0000"
                    }
                ],
                "shippingId": 4,
                "shippingVo": {
                    "id": 4,
                    "userId": 3,
                    "receiverName": "大宝剑",
                    "receiverMobile": "15088888888",
                    "receiverProvince": "上海市",
                    "receiverCity": "上海市",
                    "receiverDistrict": "浦东新区",
                    "receiverAddress": "菜鸟驿站",
                    "receiverZip": "200120",
                    "createTime": "2020-08-24T21:17:12.000+0000",
                    "updateTime": "2020-08-24T21:17:12.000+0000"
                }
            }
        ],
        "pageNum": 1,
        "pageSize": 10,
        "size": 3,
        "startRow": 1,
        "endRow": 3,
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
    "status": 6,
    "msg": "权限不足，请联系管理员"
}
```

------

#### 3.权限清单

**GET /management/roles**

> request

```
无
```

> response

success

```
{
    "status": 0,
    "data": [
        {
            "id": 1,
            "roleName": "ROLE_CUSTOMER",
            "roleDesc": "用户",
            "createTime": "2020-08-19T13:56:01.000+0000",
            "updateTime": "2020-08-19T13:56:01.000+0000"
        },
        {
            "id": 2,
            "roleName": "ROLE_EMPLOYEE",
            "roleDesc": "员工",
            "createTime": "2020-08-19T13:56:01.000+0000",
            "updateTime": "2020-08-19T13:56:01.000+0000"
        },
        {
            "id": 3,
            "roleName": "ROLE_MANAGER",
            "roleDesc": "经理",
            "createTime": "2020-08-19T13:56:01.000+0000",
            "updateTime": "2020-08-19T13:56:01.000+0000"
        }
    ]
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

#### 4.新增权限

**PUT /management/roles**

> request

```
{
  "id": 4,
  "roleName": "ROLE_TEST",   
  "roleDesc": "测试"
}
```

> response

success

```
{
    "status": 0,
    "data": {
        "id": 4,
        "roleName": "ROLE_TEST",
        "roleDesc": "测试"
    }
}
```

fail
```
{
    "status": 12,
    "msg": "id must not be null"
}
```

------

#### 5.修改权限
**PUT /management/roles**

> request

```
{
	"id": 4,
	"roleName": "ROLE_TEST",   
	"roleDesc": "内测"
}
```

> response

success

```
{
    "status": 0,
    "data": {
        "id": 4,
        "roleName": "ROLE_TEST",
        "roleDesc": "内测"
    }
}
```

fail
```
{
    "status": 12,
    "msg": "id must not be null"
}
```

------
#### 6.查看商品
**GET /management/products**

> request

```
无
```

> response

success

```
{
    "status": 0,
    "data": [
        {
            "id": 1,
            "categoryId": 100012,
            "markId": 1,
            "name": "Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机",
            "subtitle": "iPhone 12，美剧联名款上线。",
            "mainImage": null,
            "subImages": null,
            "detail": null,
            "price": 12999,
            "stock": 9,
            "status": 1,
            "createTime": "2020-08-17T14:36:23.000+0000",
            "updateTime": "2020-08-17T14:36:23.000+0000"
        },
        {
            "id": 2,
            "categoryId": 100012,
            "markId": 2,
            "name": "16+512G 华为 Mate40 风骚律师 Better Call Saul",
            "subtitle": "华为5G旗舰，震撼来袭。",
            "mainImage": null,
            "subImages": null,
            "detail": null,
            "price": 8999,
            "stock": 6,
            "status": 2,
            "createTime": "2020-08-17T14:36:23.000+0000",
            "updateTime": "2020-08-20T22:10:58.000+0000"
        },
        {
            "id": 3,
            "categoryId": 100017,
            "markId": 5,
            "name": "瑞克和莫蒂 Rick姥爷UFO迷你版",
            "subtitle": "真实还原Rick姥爷座驾细节",
            "mainImage": null,
            "subImages": null,
            "detail": null,
            "price": 1299,
            "stock": 6,
            "status": 1,
            "createTime": "2020-08-17T14:36:23.000+0000",
            "updateTime": "2020-08-24T21:15:25.000+0000"
        }
    ]
}
```

fail
```
{
    "status": 6,
    "msg": "权限不足，请联系管理员"
}
```

------
#### 7.新增商品
**POST /management/products**

> request

```
{
	"categoryId":"100019",
	"markId":"3",
	"name":"行尸走肉TWD 瑞克同款牛仔夹克 加厚版",
	"subtitle":"TWD联名，穿上更有型！",
	"price":"4999",
	"stock":"4",
	"status":"1"
}
```

> response

success

```
{
    "status": 0,
    "data": {
        "id": null,
        "categoryId": 100019,
        "markId": 3,
        "name": "行尸走肉TWD 瑞克同款牛仔夹克 加厚版",
        "subtitle": "TWD联名，穿上更有型！",
        "mainImage": null,
        "subImages": null,
        "detail": null,
        "price": 4999,
        "stock": 4,
        "status": 1,
        "createTime": null,
        "updateTime": null
    }
}
```

fail
```
{
    "status": 12,
    "msg": "name must not be blank"
}
```

------
#### 8.修改商品
**PUT /management/products**

> request

```
{
	"id":"4",
	"price":"3999"
}
```

> response

success

```
{
    "status": 0,
    "data": {
        "id": 4,
        "categoryId": 100019,
        "markId": 3,
        "name": "行尸走肉TWD 瑞克同款牛仔夹克 加厚版",
        "subtitle": "TWD联名，穿上更有型！",
        "mainImage": null,
        "subImages": null,
        "detail": null,
        "price": 3999,
        "stock": 4,
        "status": 1,
        "createTime": "2020-08-25T11:07:28.000+0000",
        "updateTime": "2020-08-25T11:24:16.000+0000"
    }
}
```

fail
```
{
    "status": 12,
    "msg": "id must not be null"
}
```

------
#### 9.查询用户
**GET /management/users/{username}**

request

```
username=jimmy
```

> response

success

```
{
    "status": 0,
    "data": {
        "id": 3,
        "username": "jimmy",
        "email": "saulgoodman@gmail.com",
        "createTime": "2020-08-19T23:32:28.000+0000",
        "updateTime": "2020-08-19T23:32:28.000+0000",
        "roleList": [
            {
                "id": 1,
                "roleName": "ROLE_CUSTOMER",
                "roleDesc": "用户"
            }
        ]
    }
}
```

fail
```
{
    "status": 6,
    "msg": "权限不足，请联系管理员"
}
```

------
#### 10.查询所有用户
**GET /management/users**

> request

```
{
	"id":"4",
	"price":"3999"
}
```

> response

success

```
{
    "status": 0,
    "data": [
        {
            "id": 1,
            "username": "employee",
            "email": "employee@outlook.com",
            "createTime": "2020-08-18T16:20:56.000+0000",
            "updateTime": "2020-08-20T09:48:25.000+0000",
            "roleList": [
                {
                    "id": 1,
                    "roleName": "ROLE_CUSTOMER",
                    "roleDesc": "用户"
                },
                {
                    "id": 2,
                    "roleName": "ROLE_EMPLOYEE",
                    "roleDesc": "员工"
                }
            ]
        },
        {
            "id": 3,
            "username": "jimmy",
            "email": "saulgoodman@gmail.com",
            "createTime": "2020-08-19T23:32:28.000+0000",
            "updateTime": "2020-08-19T23:32:28.000+0000",
            "roleList": [
                {
                    "id": 1,
                    "roleName": "ROLE_CUSTOMER",
                    "roleDesc": "用户"
                }
            ]
        },
        {
            "id": 2,
            "username": "manager",
            "email": "manager@outlook.com",
            "createTime": "2020-08-20T09:58:56.000+0000",
            "updateTime": "2020-08-20T09:58:56.000+0000",
            "roleList": [
                {
                    "id": 3,
                    "roleName": "ROLE_MANAGER",
                    "roleDesc": "经理"
                }
            ]
        }
    ]
}
```

fail
```
{
    "status": 6,
    "msg": "权限不足，请联系管理员"
}
```

------