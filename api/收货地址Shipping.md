#### 1.添加地址

**POST /shippings**


> request

```
receiverName=奥利给
receiverMobile=13966666666
receiverProvince=浙江省
receiverCity=杭州市
receiverDistrict=西湖区
receiverAddress=菜鸟驿站
receiverZip=310012
```

> response

success

```
{
	"status": 0,
	"msg": "新建地址成功",
	"data": {
		"shippingId": 4
	}
}
```

fail
```
{
    "status": -1,
    "msg": "新建地址失败"
}
```

------


#### 2.删除地址

**DELETE /shippings/{shippingId}**

> request

```
shippingId
```

> response

success

```
{
    "status": 0,
    "msg": "删除地址成功"
}
```

fail
```
{
    "status": -1,
    "msg": "删除地址失败"
}
```

------


#### 3.更新地址

**PUT /shippings/{shippingId}**

> request

```
receiverName=大宝剑
receiverMobile=15088888888
receiverProvince=上海市
receiverCity=上海市
receiverDistrict=浦东新区
receiverAddress=菜鸟驿站
receiverZip=200120
```

> response

success

```
{
    "status": 0,
    "msg": "更新地址成功"
}
```

fail
```
{
    "status": -1,
    "msg": "更新地址失败"
}
```

------


#### 4.获取地址

**GET /shippings**


> request

```
无
```

> response

success

```
{
    "status": 0,
    "data": {
        "total": 1,
        "list": [
            {
                "id": 7,
                "userId": 3,
                "receiverName": "大宝剑",
                "receiverMobile": "15088888888",
                "receiverProvince": "上海市",
                "receiverCity": "上海市",
                "receiverDistrict": "浦东新区",
                "receiverAddress": "菜鸟驿站",
                "receiverZip": "200120",
                "createTime": "2020-08-24T13:40:27.000+0000",
                "updateTime": "2020-08-24T13:40:27.000+0000"
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
    "msg": "未登录，请先登录"
}
```

------
