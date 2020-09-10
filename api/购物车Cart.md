#### 1.购物车List列表

**GET /carts** 

> request

```
无，要求登录
```

> response

success

```

{
    "status": 0,
    "data": {
        "cartProductVoList": [
            {
                "productId": 1,
                "quantity": 2,
                "productName": "Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机",
                "productSubtitle": "iPhone 12，美剧联名款上线。",
                "productMainImage": null,
                "productPrice": 12999,
                "productStatus": 1,
                "productTotalPrice": 25998,
                "productStock": 12,
                "productSelected": true
            },
            {
                "productId": 3,
                "quantity": 1,
                "productName": "瑞克和莫蒂 Rick姥爷UFO迷你版",
                "productSubtitle": "真实还原Rick姥爷座驾细节",
                "productMainImage": null,
                "productPrice": 1299,
                "productStatus": 1,
                "productTotalPrice": 1299,
                "productStock": 2,
                "productSelected": true
            }
        ],
        "selectedAll": true,
        "cartTotalPrice": 27297,
        "cartTotalQuantity": 3
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


#### 2.购物车添加商品

**POST /carts**

> request

```
productId
selected: true
```

商品数量以1累加

> response

success

```
{
    "status": 0,
    "data": {
        "cartProductVoList": [
            {
                "productId": 1,
                "quantity": 2,
                "productName": "Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机",
                "productSubtitle": "iPhone 12，美剧联名款上线。",
                "productMainImage": null,
                "productPrice": 12999,
                "productStatus": 1,
                "productTotalPrice": 25998,
                "productStock": 12,
                "productSelected": true
            },
            {
                "productId": 3,
                "quantity": 1,
                "productName": "瑞克和莫蒂 Rick姥爷UFO迷你版",
                "productSubtitle": "真实还原Rick姥爷座驾细节",
                "productMainImage": null,
                "productPrice": 1299,
                "productStatus": 1,
                "productTotalPrice": 1299,
                "productStock": 2,
                "productSelected": true
            }
        ],
        "selectedAll": true,
        "cartTotalPrice": 27297,
        "cartTotalQuantity": 3
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

#### 3.更新购物车

**PUT /carts/{productId}**

> request

```
quantity //非必填
selected: true //非必填
```

> response

响应同2

success

```
{
    "status": 0,
    "data": {
        "cartProductVoList": [
            {
                "productId": 1,
                "quantity": 2,
                "productName": "Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机",
                "productSubtitle": "iPhone 12，美剧联名款上线。",
                "productMainImage": null,
                "productPrice": 12999,
                "productStatus": 1,
                "productTotalPrice": 25998,
                "productStock": 12,
                "productSelected": true
            },
            {
                "productId": 3,
                "quantity": 1,
                "productName": "瑞克和莫蒂 Rick姥爷UFO迷你版",
                "productSubtitle": "真实还原Rick姥爷座驾细节",
                "productMainImage": null,
                "productPrice": 1299,
                "productStatus": 1,
                "productTotalPrice": 1299,
                "productStock": 2,
                "productSelected": true
            }
        ],
        "selectedAll": true,
        "cartTotalPrice": 27297,
        "cartTotalQuantity": 3
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

#### 4.移除购物车商品

**DELETE /carts/{productId}**

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
        "cartProductVoList": [
            {
                "productId": 3,
                "quantity": 4,
                "productName": "瑞克和莫蒂 Rick姥爷UFO迷你版",
                "productSubtitle": "真实还原Rick姥爷座驾细节",
                "productMainImage": null,
                "productPrice": 1299,
                "productStatus": 1,
                "productTotalPrice": 5196,
                "productStock": 2,
                "productSelected": true
            }
        ],
        "selectedAll": true,
        "cartTotalPrice": 5196,
        "cartTotalQuantity": 4
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

#### 5.全选

**PUT /carts/selectAll**

> request

```
无，要求登录
```

> response

success

同1.购物车List列表

------

#### 6.全不选

**PUT /carts/unSelectAll**

> request

```
无，要求登录
```

> response

success

同1.购物车List列表

------

#### 7.获取购物中所有商品数量总和

**GET /carts/products/sum**

> request

```
无，要求登录
```

> response

```
{
    "status": 0,
    "data": 2
}
```