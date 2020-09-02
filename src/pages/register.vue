<template>
    <div class="register">
        <div class="container">
            <a href="/#/index"><img src="/imgs/login-logo.png" alt=""></a>
        </div>
        <div class="wrapper">
            <div class="container">
                <div class="register-form">
                    <h3>
                        <span class="checked">注册会员</span>
                    </h3>
                    <div class="input">
                        <input type="text" placeholder="请输入用户名" v-model="registerForm.username">
                        <div class="tips">
                            [ 用户名4到16位，不含特殊字符 ]
                        </div>
                    </div>
                    <div class="input">
                        <input type="password" placeholder="请输入密码" v-model="registerForm.password">
                        <div class="tips">
                            [ 密码25位以内，至少包含英文大小写及数字 ]
                        </div>
                    </div>
                    <div class="input">
                        <input type="text" placeholder="请输入邮箱" v-model="registerForm.email">
                        <div class="tips">
                            [ 请输入国际合法邮箱 ]
                        </div>
                    </div>
                    <div class="btn-box">
                        <a href="javascript:;" class="btn" @click="register">注册</a>
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
        name: 'register',
        components: {
            NavFooter
        },
        data() {
            return {
                registerForm: {
                    username: '',
                    password: '',
                    email: ''
                },
            }
        },
        methods: {
            register() {
                if (this.preCheck()) {
                    this.axios.post('/user/register', this.registerForm).then(() => {
                        alert('注册成功');
                        this.$router.push('/login');
                    });
                }
            },
            preCheck() {
                let username = this.registerForm.username;
                let regUser = /^[a-zA-Z0-9]{4,16}$/;
                if (!regUser.test(username)) {
                    alert("用户名格式有误！");
                    return false;
                }

                let password = this.registerForm.password;
                let regPass = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^]{3,25}$/;
                if (!regPass.test(password)) {
                    alert("密码格式有误！");
                    return false;
                }

                let email = this.registerForm.email;
                let regEmail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                if (!regEmail.test(email)) {
                    alert("邮箱格式有误！");
                    return false;
                }

                return true;
            }
        }
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config.scss";

    .register {

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

                .register-form {
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
                    }

                    .input {
                        display: inline-block;
                        width: 348px;
                        height: 50px;
                        border: 1.5px solid #E5E5E5;
                        margin-bottom: 50px;

                        input {
                            width: 100%;
                            height: 100%;
                            border: none;
                            padding: 18px;
                        }

                        .tips {
                            margin-top: 14px;
                            display: flex;
                            justify-content: space-between;
                            font-size: 12px;
                            color: $colorD;
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
                }
            }
        }
    }

</style>