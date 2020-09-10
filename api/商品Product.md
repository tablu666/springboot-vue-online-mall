#### 1.商品列表

**GET /products**

> request

```
categoryId(非必传，子类目的商品也要查出来)
pageNum(default=1)
pageSize(default=10)
```

> response

success

```
{
  "status": 0,
  "data": {
    "pageNum": 1,
    "pageSize": 2,
    "size": 2,
    "startRow": 1,
    "endRow": 2,
    "pages": 2,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 2,
    "total": 3,
    "list": [
      {
        "id": 1,
        "categoryId": 100012,
        "markId": 1,
        "name": "Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机",
        "subtitle": "iPhone 12，美剧联名款上线。",
        "price": 12999.00,
        "status": 1
      },
      {
        "id": 2,
        "categoryId": 100012,
        "markId": 2,
        "name": "16+512G 华为 Mate40 风骚律师 Better Call Saul",
        "subtitle": "华为5G旗舰，震撼来袭。",
        "price": 8999.00,
        "status": 1
      }
    ]
  }
}
```

------

#### 2.商品详情

**GET /products/{productId}**

> request

```
productId
```

> response

success

```
{
  "status": 0,
  "data": {
    "id": 2,
    "categoryId": 100012,
    "markId": 2,
    "name": "16+512G 华为 Mate40 风骚律师 Better Call Saul",
    "subtitle": "华为5G旗舰，震撼来袭。",
    "price": 8999.00,
    "stock": 6,
    "status": 1,
    "createTime": "Aug 17, 2020 10:36:23 PM",
    "updateTime": "Aug 17, 2020 10:36:23 PM"
  }
}
```

fail
```
{
    "status": 13,
    "msg": "该商品已下架或删除"
}
```