<template>
    <div class="login">
        <div class="container">
            <a href="/#/index"><img src="/imgs/login-logo.png" alt=""></a>
        </div>
        <div class="wrapper">
            <div class="container">
                <div class="login-form">
                    <h3>
                        <span class="checked">账号登录</span><span class="separate-line">|</span><span>扫码登录</span>
                    </h3>
                    <div class="input">
                        <input type="text" placeholder="请输入用户名" v-model="loginForm.username">
                    </div>
                    <div class="input">
                        <input type="password" placeholder="请输入密码" v-model="loginForm.password">
                    </div>
                    <div class="input">
                        <input type="text" placeholder="点击图片更换验证码" v-model="loginForm.code">
                    </div>
                    <div class="vc">
                        <img :src="vcUrl" @click="updateVerifyCode" alt="">
                        <div class="remember">
                            <span>保持登录</span><input type="checkbox" v-model="checked">
                        </div>
                    </div>
                    <div class="btn-box">
                        <a href="javascript:;" class="btn" @click="login">登录</a>
                    </div>
                    <div class="tips">
                        <div class="register" @click="register">注册成为本站[会员]</div>
                    </div>
                </div>
            </div>
        </div>
        <nav-footer></nav-footer>
    </div>
</template>
<script>
    import NavFooter from "../components/NavFooter";

    export default {
        name: 'login',
        components: {
            NavFooter
        },
        data() {
            return {
                loginForm: {
                    username: '',
                    password: '',
                    code: ''
                },
                checked: true,
                userId: '',
                res: {},
                vcUrl: '/api/verifyCode?time=' + new Date()
            }
        },
        methods: {
            updateVerifyCode() {
                this.vcUrl = '/api/verifyCode?time=' + new Date();
            },
            login() {
                this.axios.post('/user/login', this.loginForm).then((user) => {
                    if (user) {
                        if (this.checked) {
                            this.$cookie.set('userId', user.id, {expires: '1M'});
                        }
                        this.$store.dispatch('saveUsername', user.username);
                        this.res = user;
                        this.$router.push({
                            name: 'index',
                            params: {
                                from: 'login'
                            }
                        });
                    } else {
                        this.vcUrl = '/api/verifyCode?time=' + new Date();
                    }
                }).catch(() => {
                    this.vcUrl = '/api/verifyCode?time=' + new Date();
                });
            },
            register() {
                this.$router.push('/register');
            }
        }
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config.scss";

    .login {

        & > .container {
            height: 113px;

            img {
                width: auto;
                height: 100%;
            }

        }

        .wrapper {
            background: url('/imgs/login-background.jpg') no-repeat center;

            .container {
                height: 576px;

                .login-form {
                    box-sizing: border-box;
                    padding-left: 31px;
                    padding-right: 31px;
                    width: 410px;
                    height: 510px;
                    background-color: #ffffff;
                    position: absolute;
                    bottom: 29px;
                    right: 0;

                    h3 {
                        line-height: 23px;
                        font-size: 24px;
                        text-align: center;
                        margin: 40px auto 49px;

                        .checked {
                            color: $colorA;
                        }

                        .separate-line {
                            margin: 0 32px;
                        }
                    }

                    .input {
                        display: inline-block;
                        width: 348px;
                        height: 50px;
                        border: 1px solid #E5E5E5;
                        margin-bottom: 20px;

                        input {
                            width: 100%;
                            height: 100%;
                            border: none;
                            padding: 18px;
                        }
                    }

                    .vc {
                        img {
                            cursor: pointer;
                        }

                        .remember {
                            margin-top: 10px;
                            width: 348px;
                            line-height: 30px;

                            span {
                                display: inline-block;
                                color: #999999;
                                font-weight: bold;
                                font-size: 14px;
                                margin-right: 5px;
                            }
                        }
                    }

                    .btn-box {

                        .btn {
                            width: 100%;
                            line-height: 50px;
                            margin-top: 5px;
                            font-size: 16px;
                        }
                    }

                    .tips {
                        margin-top: 14px;
                        display: flex;
                        justify-content: space-between;
                        font-size: 14px;
                        cursor: pointer;

                        .register {
                            color: red;
                            font-weight: bold;
                        }
                    }
                }
            }
        }
    }

</style>