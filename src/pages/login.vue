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
                        <input type="text" placeholder="请输入用户名">
                    </div>
                    <div class="input">
                        <input type="password" placeholder="请输入密码">
                    </div>
                    <div class="input">
                        <input type="text" placeholder="点击图片更换验证码">
                    </div>
                    <div class="vc">
                        <img :src="vcUrl" @click="updateVerifyCode" alt="">
                    </div>
                    <div class="btn-box">
                        <a href="javascript:;" class="btn">登录</a>
                    </div>
                    <div class="tips">
                        <div class="register">注册成为本站会员</div>
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
                vcUrl: '/api/verifyCode?time=' + new Date()
            }
        },
        methods: {
            updateVerifyCode() {
                this.vcUrl = '/api/verifyCode?time=' + new Date();
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

                    .btn-box {

                        .btn {
                            width: 100%;
                            line-height: 50px;
                            margin-top: 10px;
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
                            color: #999999;
                            font-weight: bold;
                        }
                    }
                }
            }
        }
    }

</style>