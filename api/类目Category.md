#### 1.所有类目

**GET /categories**

> request

无需登录

> response


success
```
{
    "status": 0,
    "data": [
        {
            "id": 100001,
            "parentId": 0,
            "name": "特色专区",
            "sortOrder": 5,
            "subCategories": [
                {
                    "id": 100006,
                    "parentId": 100001,
                    "name": "绝命毒师",
                    "sortOrder": 5,
                    "subCategories": []
                },
                {
                    "id": 100007,
                    "parentId": 100001,
                    "name": "风骚律师",
                    "sortOrder": 4,
                    "subCategories": []
                },
                {
                    "id": 100008,
                    "parentId": 100001,
                    "name": "行尸走肉",
                    "sortOrder": 3,
                    "subCategories": []
                },
                {
                    "id": 100009,
                    "parentId": 100001,
                    "name": "无耻之徒",
                    "sortOrder": 2,
                    "subCategories": []
                },
                {
                    "id": 100010,
                    "parentId": 100001,
                    "name": "瑞克和莫蒂",
                    "sortOrder": 1,
                    "subCategories": []
                }
            ]
        },
        {
            "id": 100002,
            "parentId": 0,
            "name": "蓝光珍藏",
            "sortOrder": 4,
            "subCategories": []
        },
        {
            "id": 100003,
            "parentId": 0,
            "name": "数码电子",
            "sortOrder": 3,
            "subCategories": [
                {
                    "id": 100011,
                    "parentId": 100003,
                    "name": "电脑",
                    "sortOrder": 5,
                    "subCategories": []
                },
                {
                    "id": 100012,
                    "parentId": 100003,
                    "name": "手机",
                    "sortOrder": 4,
                    "subCategories": []
                },
                {
                    "id": 100013,
                    "parentId": 100003,
                    "name": "手表",
                    "sortOrder": 3,
                    "subCategories": []
                },
                {
                    "id": 100014,
                    "parentId": 100003,
                    "name": "音箱",
                    "sortOrder": 2,
                    "subCategories": []
                },
                {
                    "id": 100015,
                    "parentId": 100003,
                    "name": "配件",
                    "sortOrder": 1,
                    "subCategories": [
                        {
                            "id": 100022,
                            "parentId": 100015,
                            "name": "手机壳",
                            "sortOrder": 1,
                            "subCategories": []
                        }
                    ]
                }
            ]
        },
        {
            "id": 100004,
            "parentId": 0,
            "name": "玩偶手办",
            "sortOrder": 2,
            "subCategories": [
                {
                    "id": 100016,
                    "parentId": 100004,
                    "name": "大型",
                    "sortOrder": 3,
                    "subCategories": []
                },
                {
                    "id": 100017,
                    "parentId": 100004,
                    "name": "迷你",
                    "sortOrder": 2,
                    "subCategories": []
                },
                {
                    "id": 100018,
                    "parentId": 100004,
                    "name": "限定",
                    "sortOrder": 1,
                    "subCategories": []
                }
            ]
        },
        {
            "id": 100005,
            "parentId": 0,
            "name": "服饰日用",
            "sortOrder": 1,
            "subCategories": [
                {
                    "id": 100019,
                    "parentId": 100005,
                    "name": "衣服",
                    "sortOrder": 3,
                    "subCategories": []
                },
                {
                    "id": 100020,
                    "parentId": 100005,
                    "name": "裤子",
                    "sortOrder": 2,
                    "subCategories": []
                },
                {
                    "id": 100021,
                    "parentId": 100005,
                    "name": "其他",
                    "sortOrder": 1,
                    "subCategories": []
                }
            ]
        }
    ]
}
```