<template>
    <div class="header">
        <div class="nav-top-bar">
            <div class="container">
                <div class="top-bar-menu">
                    <a href="javascript:;">美剧周边站</a>
                    <a href="javascript:;">Mall</a>
                    <a href="javascript:;">American TV Series</a>
                    <a href="javascript:;">跨境物流服务</a>
                    <a href="javascript:;">Thanks to the Internet</a>
                </div>
                <div class="top-bar-user">
                    <a href="javascript:;" v-if="username">{{username}}</a>
                    <a href="javascript:;" v-if="!username" @click="login">登录</a>
                    <a href="javascript:;" v-if="username" @click="logout">退出</a>
                    <a href="javascript:;" v-if="username" @click="goToOrder">我的订单</a>
                    <a href="javascript:;" v-if="!username" @click="register">注册</a>
                    <a href="javascript:;" class="user-cart" @click="goToCart"><span class="icon-cart"></span>购物车({{cartCount}})</a>
                </div>
            </div>
        </div>
        <div class="nav-top-banner">
            <div class="container">
                <div class="top-banner-logo">
                    <a href="/#/index"></a>
                </div>
                <div class="top-banner-menu">
                    <div class="item-menu">
                        <span>特色专区</span>
                        <div class="children">
                            <ul>
                                <li class="category">
                                    <a href="/#/category/100006" target="_blank">
                                        <div class="category-image">
                                            <img v-lazy="'/imgs/nav-img/nav-breaking-bad.jpg'" alt=""/>
                                        </div>
                                        <div class="category-name">绝命毒师 Breaking Bad</div>
                                    </a>
                                </li>
                                <li class="category">
                                    <a href="/#/category/100007" target="_blank">
                                        <div class="category-image">
                                            <img v-lazy="'/imgs/nav-img/nav-better-call-saul.png'" alt=""/>
                                        </div>
                                        <div class="category-name">风骚律师 Better Call Saul</div>
                                    </a>
                                </li>
                                <li class="category">
                                    <a href="/#/category/100008" target="_blank">
                                        <div class="category-image">
                                            <img v-lazy="'/imgs/nav-img/nav-the-walking-dead.jpg'" alt=""/>
                                        </div>
                                        <div class="category-name">行尸走肉 The Walking Dead</div>
                                    </a>
                                </li>
                                <li class="category">
                                    <a href="/#/category/100009" target="_blank">
                                        <div class="category-image">
                                            <img v-lazy="'/imgs/nav-img/nav-shameless.jpg'" alt=""/>
                                        </div>
                                        <div class="category-name">无耻之徒 Shameless</div>
                                    </a>
                                </li>
                                <li class="category">
                                    <a href="/#/category/100010" target="_blank">
                                        <div class="category-image">
                                            <img v-lazy="'/imgs/nav-img/nav-rick-and-morty.jpg'" alt=""/>
                                        </div>
                                        <div class="category-name">瑞克和莫蒂 Rick And Morty</div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="item-menu">
                        <span>商城精品</span>
                        <div class="children">
                            <ul>
                                <li class="product" v-for="(item, index) in productList" :key="index">
                                    <a v-bind:href="'/#/product/' + item.id" target="_blank">
                                        <div class="product-image">
                                            <img v-lazy="item.mainImage" :alt="item.subtitle"/>
                                        </div>
                                        <div class="product-name">{{item.name}}</div>
                                        <div class="product-price">{{item.price | currency}}</div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="item-menu">
                        <span>Explore</span>
                        <!--<div class="children"></div>-->
                    </div>
                </div>
                <div class="top-banner-search">
                    <div class="wrapper">
                        <input type="text" name="keyword">
                        <a href="javascript:;" @click="goToBackend"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'nav-header',
        data() {
            return {
                productList: []
            }
        },
        computed: {
            username() {
                return this.$store.state.username;
            },
            cartCount() {
                return this.$store.state.cartCount;
            }
        },
        filters: {
            currency(money) {
                if (!money) {
                    return 0.00;
                }
                return '￥' + money.toFixed(2);
            }
        },
        mounted() {
            this.getProductList();
            let params = this.$route.params;
            if (params && params.from === 'login') {
                this.getCartCount();
            }
        },
        methods: {
            login() {
                this.$router.push('/login');
            },
            logout() {
                this.axios.post('/user/logout').then(() => {
                    this.$message.success("退出成功！");
                    this.$cookie.set('userId', '', {expires: '-1'});
                    this.$store.dispatch('saveUsername', '');
                    this.$store.dispatch('saveCartCount', '0');
                });
            },
            register() {
                this.$router.push('/register');
            },
            getProductList() {
                this.axios.get('/products', {
                    params: {
                        pageSize: 5
                    }
                }).then((res) => {
                    this.productList = res.list;
                })
            },
            goToCart() {
                if (this.username === '') {
                    window.location.href = '/#/login';
                } else {
                    this.$router.push('/cart');
                }
            },
            getCartCount() {
                this.axios.get('/carts/products/sum').then((count = 0) => {
                    this.$store.dispatch('saveCartCount', count);
                });
            },
            goToOrder() {
                if (this.username === '') {
                    window.location.href = '/#/login';
                } else {
                    this.$router.push('/order/list');
                }
            },
            goToBackend() {
                if (this.username === '') {
                    window.location.href = '/#/login';
                } else if (this.username !== 'employee' && this.username !== 'manager') {
                    this.$message.warning("Sorry 仅限本站员工查看哦！");
                } else {
                    this.$router.push('/management');
                }
            }
        }
    }
</script>
<style lang="scss">
    @import "./../assets/scss/base.scss";
    @import "./../assets/scss/mixin.scss";
    @import "./../assets/scss/config.scss";

    .header {
        .nav-top-bar {
            height: 39px;
            line-height: 39px;
            background-color: $colorB;
            color: #d5d5d5;

            .container {
                @include flex();

                a {
                    display: inline-block;
                    color: #d5d5d5;
                    margin-right: 17px;
                }

                .user-cart {
                    width: 110px;
                    background-color: $colorA;
                    text-align: center;
                    color: #ffffff;
                    margin-right: 0;

                    .icon-cart {
                        @include backgroundImage(16px, 12px, "/imgs/icon-cart-checked.png");
                        margin-right: 4px;
                    }
                }
            }
        }

        .nav-top-banner {
            .container {
                @include flex();
                height: 112px;
                position: relative;

                .top-banner-menu {
                    display: inline-block;
                    width: 643px;
                    padding-left: 209px;

                    .item-menu {
                        display: inline-block;
                        color: $colorB;
                        font-weight: bold;
                        font-size: 16px;
                        line-height: 112px;
                        margin-right: 20px;

                        span {
                            cursor: pointer;
                        }

                        &:hover {
                            color: $colorA;

                            .children {
                                height: 220px;
                                opacity: 1;
                            }
                        }

                        .children {
                            position: absolute;
                            top: 112px;
                            left: 0;
                            width: 1226px;
                            height: 0;
                            opacity: 0;
                            overflow: hidden;
                            border-top: 1px solid $colorH;
                            box-shadow: 0 7px 6px 0 rgba(0, 0, 0, 0.11);
                            z-index: 10;
                            transition: all .5s;
                            background-color: #ffffff;

                            .category {
                                position: relative;
                                float: left;
                                width: 20%;
                                height: 220px;
                                font-size: 12px;
                                line-height: 12px;
                                text-align: center;

                                a {
                                    display: inline-block;
                                }

                                img {
                                    width: auto;
                                    height: 111px;
                                    margin-top: 26px;
                                }

                                .category-image {
                                    height: 137px;
                                }

                                .category-name {
                                    font-weight: bold;
                                    margin-top: 30px;
                                    color: $colorB;
                                }

                                &:before {
                                    content: ' ';
                                    position: absolute;
                                    top: 28px;
                                    right: 0;
                                    border-left: 1px solid $colorF;
                                    height: 100px;
                                    width: 1px;
                                }

                                &:last-child:before {
                                    display: none;
                                }
                            }

                            .product {
                                position: relative;
                                float: left;
                                width: 20%;
                                height: 220px;
                                font-size: 12px;
                                line-height: 12px;
                                text-align: center;

                                a {
                                    display: inline-block;
                                }

                                img {
                                    width: auto;
                                    height: 111px;
                                    margin-top: 26px;
                                }

                                .product-image {
                                    height: 137px;
                                }

                                .product-name {
                                    font-weight: bold;
                                    margin-top: 19px;
                                    margin-bottom: 8px;
                                    color: $colorB;
                                }

                                .product-price {
                                    font-weight: bold;
                                    color: $colorA;
                                }

                                &:before {
                                    content: ' ';
                                    position: absolute;
                                    top: 28px;
                                    right: 0;
                                    border-left: 1px solid $colorF;
                                    height: 100px;
                                    width: 1px;
                                }

                                &:last-child:before {
                                    display: none;
                                }
                            }
                        }
                    }
                }

                .top-banner-search {
                    width: 319px;

                    .wrapper {
                        height: 50px;
                        border: 1px solid #E0E0E0;
                        display: flex;
                        align-items: center;

                        input {
                            border: none;
                            box-sizing: border-box;
                            border-right: 1px solid #E0E0E0;
                            width: 264px;
                            height: 50px;
                            padding-left: 14px;
                        }

                        a {
                            @include backgroundImage(18px, 18px, "/imgs/icon-statistics.png");
                            width: 36px;
                            height: 36px;
                            margin-left: 8px;
                        }
                    }
                }
            }
        }
    }
</style>