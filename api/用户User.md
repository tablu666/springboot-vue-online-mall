#### 1.登录

**POST /user/login**

> request

Content-Type: application/json

```
{
	"username":"jimmy",
	"password":"123",
	"code":"ab48"
}
```
> response

fail
```
{
    "status": 1,
    "msg": "验证码错误"
}

{
	"status": 2,
    "msg": "用户名或密码错误"
}
```

success
```
{
    "status": 0,
    "data": {
        "id": 3,
        "username": "jimmy",
        "email": "saulgoodman@gmail.com",
        "createTime": "Aug 20, 2020 7:32:28 AM",
        "updateTime": "Aug 20, 2020 7:32:28 AM"
    }
}
```

-------

#### 2.注册
**POST /user/register**

> request

```
{
	"username":"jimmy",
	"password":"123",
	"email":"saulgoodman@gmail.com"
}
```


> response

success
```
{
    "status": 0,
    "msg": "注册成功"
}
```


fail
```
{
    "status": 3,
    "msg": "用户名已存在"
}

{
    "status": 4,
    "msg": "邮箱已存在"
}
```


#### 3.当前用户信息
**GET /user/profile**

> request

```
无参数
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
        "updateTime": "2020-08-19T23:32:28.000+0000"
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


#### 4.退出
**POST /user/logout**

> request

```
无
```

> response

success

```
{
    "status": 0,
    "msg": "退出成功"
}
```

fail
```
{
    "status": -1,
    "msg": "服务端异常"
}
```
