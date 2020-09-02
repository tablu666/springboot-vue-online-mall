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
                    </div>
                    <div class="input">
                        <input type="password" placeholder="请输入密码" v-model="registerForm.password">
                    </div>
                    <div class="input">
                        <input type="text" placeholder="请输入邮箱" v-model="registerForm.email">
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
                userId: '',
                res: {}
            }
        },
        methods: {
            register() {
                this.axios.post('/user/register', this.registerForm).then(() => {
                    alert('注册成功');
                    this.$router.push('/login');
                });
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
                            margin-top: 5px;
                            font-size: 16px;
                        }
                    }
                }
            }
        }
    }

</style>