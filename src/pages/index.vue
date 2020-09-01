<template>
    <div class="index">
        <div class="container">
            <div class="swiper-box">
                <div class="nav-menu">
                    <ul class="menu-wrap">
                        <li class="menu-item">
                            <a href="javascript:;">蓝光珍藏</a>
                            <div class="children">
                                <ul v-for="(item, i) in menuList" v-bind:key="i">
                                    <li v-for="(sub, j) in item" v-bind:key="j">
                                        <a v-bind:href="sub ? '/#/product/' + sub.id : ''">
                                            <img v-bind:src="sub ? sub.mainImage : '/imgs/product/gift-card.jpg'"
                                                 :alt="sub.subtitle">
                                            {{sub? sub.name : '礼品卡'}}
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="menu-item">
                            <a href="javascript:;">数码电子</a>
                            <div class="children">
                                <ul v-for="(item, i) in menuList2" v-bind:key="i">
                                    <li v-for="(sub, j) in item" v-bind:key="j">
                                        <a v-bind:href="sub ? '/#/product/' + sub.id : ''">
                                            <img v-bind:src="sub ? sub.mainImage : '/imgs/product/gift-card.jpg'"
                                                 :alt="sub.subtitle">
                                            {{sub? sub.name : '礼品卡'}}
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="menu-item">
                            <a href="javascript:;">玩偶手办</a>
                            <div class="children">
                                <ul v-for="(item, i) in menuList3" v-bind:key="i">
                                    <li v-for="(sub, j) in item" v-bind:key="j">
                                        <a v-bind:href="sub ? '/#/product/' + sub.id : ''">
                                            <img v-bind:src="sub ? sub.mainImage : '/imgs/product/gift-card.jpg'"
                                                 :alt="sub.subtitle">
                                            {{sub? sub.name : '礼品卡'}}
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="menu-item">
                            <a href="javascript:;">服饰日用</a>
                            <div class="children">
                                <ul v-for="(item, i) in menuList4" v-bind:key="i">
                                    <li v-for="(sub, j) in item" v-bind:key="j">
                                        <a v-bind:href="sub ? '/#/product/' + sub.id : ''">
                                            <img v-bind:src="sub ? sub.mainImage : '/imgs/product/gift-card.jpg'"
                                                 :alt="sub.subtitle">
                                            {{sub? sub.name : '礼品卡'}}
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
                <swiper v-bind:options="swiperOptions">
                    <swiper-slide v-for="(item, index) in slideList" v-bind:key="index">
                        <a v-bind:href="'/#/product/' + item.id"><img v-bind:src="item.img" alt=""/></a>
                    </swiper-slide>
                    <!-- 如果需要分页器 -->
                    <div class="swiper-pagination" slot="pagination"></div>
                    <!-- 如果需要导航按钮 -->
                    <div class="swiper-button-prev" slot="button-prev"></div>
                    <div class="swiper-button-next" slot="button-next"></div>
                </swiper>
            </div>
            <div class="ads-box">
                <a v-bind:href="'/#/product/' + item.id" v-for="(item, index) in adsList" v-bind:key="index">
                    <img v-bind:src="item.img" alt="">
                </a>
            </div>
            <div class="banner">
                <a href="javascript:;">
                    <img src="/imgs/banner-index.jpg" alt="美剧周边站 Dream And Passion">
                </a>
            </div>
            <div class="product-box">
                <h2>手机 Mobile</h2>
                <div class="list-box">
                    <div class="list" v-for="(arr, i) in phoneList" v-bind:key="i">
                        <div class="item" v-for="(item, j) in arr" v-bind:key="j">
                            <span v-if="j%2===0" v-bind:class="{'new-product':j%2===0}">新品</span>
                            <span v-if="j%2!==0" v-bind:class="{'kill-product':j%2!==0}">秒杀</span>
                            <div class="item-img">
                                <img :src="item.mainImage" alt="">
                            </div>
                            <div class="item-info">
                                <h3>{{item.name}}</h3>
                                <p>{{item.subtitle}}</p>
                                <p class="price" @click="addToCart(item.id)">{{item.price}}元</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <service-bar></service-bar>
        <modal title="系统提示"
               confirm-text="查看购物车"
               btn-type="1"
               modal-type="middle"
               v-bind:show-modal="showModal"
               @submit="goToCart"
               @cancel="showModal=false">
            <template v-slot:body>
                <p>商品添加成功！</p>
            </template>
        </modal>
    </div>
</template>
<script>
    import ServiceBar from "./../components/ServiceBar";
    import Modal from "./../components/Modal";
    import {Swiper, SwiperSlide} from 'vue-awesome-swiper';
    import 'swiper/css/swiper.css';

    export default {
        name: 'index',
        components: {
            Swiper,
            SwiperSlide,
            ServiceBar,
            Modal
        },
        data() {
            return {
                swiperOptions: {
                    autoplay: true,
                    loop: true,
                    effect: 'cube',
                    cubeEffect: {
                        slideShadows: true,
                        shadow: true,
                        shadowOffset: 100,
                        shadowScale: 0.6
                    },
                    pagination: {
                        el: '.swiper-pagination',
                        clickable: true
                    },
                    navigation: {
                        nextEl: '.swiper-button-next',
                        prevEl: '.swiper-button-prev',
                    }
                },
                slideList: [
                    {
                        id: '1',
                        img: '/imgs/slider/slide-1.jpg'
                    },
                    {
                        id: '2',
                        img: '/imgs/slider/slide-2.jpg'
                    },
                    {
                        id: '3',
                        img: '/imgs/slider/slide-3.jpg'
                    },
                    {
                        id: '4',
                        img: '/imgs/slider/slide-4.jpg'
                    },
                    {
                        id: '5',
                        img: '/imgs/slider/slide-5.jpg'
                    }
                ],
                menuList: [
                    [], [], []
                ],
                menuList2: [
                    [], [], [],
                ],
                menuList3: [
                    [], [], [],
                ],
                menuList4: [
                    [], [], [],
                ],
                adsList: [
                    {
                        id: 1,
                        img: '/imgs/ads/ads-1.jpg'
                    },
                    {
                        id: 2,
                        img: '/imgs/ads/ads-2.jpg'
                    },
                    {
                        id: 3,
                        img: '/imgs/ads/ads-3.jpg'
                    },
                    {
                        id: 5,
                        img: '/imgs/ads/ads-4.jpg'
                    },
                ],
                phoneList: [],
                showModal: false
            }
        },
        mounted() {
            this.getMenuList();
            this.getMenuList2();
            this.getMenuList3();
            this.getMenuList4();
            this.getPhoneList();
        },
        methods: {
            getMenuList() {
                this.axios.get('/products', {
                    params: {
                        categoryId: 100002
                    }
                }).then((res) => {
                    // let temp = new Array(4);
                    let temp = [];
                    let cnt = 0;
                    let len = this.menuList.length;
                    for (let i = 0; i < len; i++) {
                        let temp2 = [0, 0, 0];
                        for (let j = 0; j < len && cnt < res.list.length; j++) {
                            temp2[j] = res.list[cnt++];
                        }
                        temp[i] = temp2;
                    }
                    this.menuList = temp;
                });
                // console.log(this);
            },
            getMenuList2() {
                this.axios.get('/products', {
                    params: {
                        categoryId: 100003
                    }
                }).then((res) => {
                    let temp = [];
                    let cnt = 0;
                    let len = this.menuList2.length;
                    for (let i = 0; i < len; i++) {
                        let temp2 = [0, 0, 0];
                        for (let j = 0; j < len && cnt < res.list.length; j++) {
                            temp2[j] = res.list[cnt++];
                        }
                        temp[i] = temp2;
                    }
                    this.menuList2 = temp;
                });
            },
            getMenuList3() {
                this.axios.get('/products', {
                    params: {
                        categoryId: 100004
                    }
                }).then((res) => {
                    let temp = [];
                    let cnt = 0;
                    let len = this.menuList3.length;
                    for (let i = 0; i < len; i++) {
                        let temp2 = [0, 0, 0];
                        for (let j = 0; j < len && cnt < res.list.length; j++) {
                            temp2[j] = res.list[cnt++];
                        }
                        temp[i] = temp2;
                    }
                    this.menuList3 = temp;
                });
            },
            getMenuList4() {
                this.axios.get('/products', {
                    params: {
                        categoryId: 100005
                    }
                }).then((res) => {
                    let temp = [];
                    let cnt = 0;
                    let len = this.menuList4.length;
                    for (let i = 0; i < len; i++) {
                        let temp2 = [0, 0, 0];
                        for (let j = 0; j < len && cnt < res.list.length; j++) {
                            temp2[j] = res.list[cnt++];
                        }
                        temp[i] = temp2;
                    }
                    this.menuList4 = temp;
                });
            },
            getPhoneList() {
                this.axios.get('/products', {
                    params: {
                        categoryId: 100012,
                        pageSize: 8
                    }
                }).then((res) => {
                    this.phoneList = [
                        res.list.slice(0, 4),
                        res.list.slice(4, 8)
                    ];
                });
            },
            addToCart() {
                this.showModal = true;
                // this.axios.post('/carts',{
                //     productId: productId,
                //     selected: true
                // }).then(()=>{
                //
                // }).catch(()=>{
                //     this.showModal = true;
                // });
            },
            goToCart() {
                this.$router.push('/cart')
            }
        }
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config.scss";
    @import "./../assets/scss/mixin.scss";

    .index {
        .swiper-box {
            .nav-menu {
                position: absolute;
                width: 200px;
                height: 451px;
                z-index: 9;
                padding: 26px 0;
                background-color: #50505080;
                box-sizing: border-box;

                .menu-wrap {
                    .menu-item {
                        height: 100px;
                        line-height: 100px;

                        a {
                            position: relative;
                            display: block;
                            font-size: 16px;
                            color: #ffffff;
                            padding-left: 30px;

                            &:after {
                                position: absolute;
                                right: 30px;
                                top: 41.5px;
                                content: ' ';
                                @include backgroundImage(10px, 15px, '/imgs/icon-arrow.png');
                            }
                        }

                        &:hover {
                            background-color: $colorA;

                            .children {
                                display: block;
                            }
                        }

                        .children {
                            display: none;
                            width: 1026px;
                            height: 451px;
                            background-color: $colorG;
                            position: absolute;
                            top: 0;
                            left: 200px;
                            border: 1px solid $colorH;

                            ul {
                                display: flex;
                                justify-content: space-between;
                                height: 150px;

                                li {
                                    height: 150px;
                                    line-height: 150px;
                                    flex: 1;
                                    padding-left: 23px;
                                }

                                a {
                                    color: $colorB;
                                    font-size: 12px;
                                }

                                img {
                                    width: 120px;
                                    height: 100px;
                                    vertical-align: middle;
                                    margin-right: 15px;
                                }
                            }
                        }
                    }
                }
            }

            .swiper-container {
                height: 451px;

                .swiper-button-prev {
                    left: 210px;
                }

                img {
                    width: 100%;
                    height: 100%;
                }
            }
        }

        .ads-box {
            @include flex();
            margin-top: 15px;
            margin-bottom: 15px;

            a {
                width: 296px;
                height: 167px;

                img {
                    width: 100%;
                    height: 100%;
                }
            }
        }

        .banner {
            margin-bottom: 50px;

            a {
                img {
                    width: 1226px;
                    height: 130px;
                }
            }
        }

        .product-box {
            padding: 15px 0 15px;

            h2 {
                font-size: $fontF;
                height: 21px;
                line-height: 21px;
                color: $colorB;
                margin-bottom: 15px;
                margin-left: 15px;
            }

            .list-box {
                .list {
                    @include flex();
                    width: 1226px;
                    margin-bottom: 15px;

                    &:last-child {
                        margin-bottom: 0;
                    }

                    .item {
                        width: 296px;
                        height: 310px;
                        text-align: center;

                        span {
                            display: inline-block;
                            width: 67px;
                            height: 24px;
                            line-height: 24px;
                            font-size: 14px;
                            color: #ffffff;

                            &.new-product {
                                background-color: #7ECF68;
                            }

                            &.kill-product {
                                background-color: #E82626;
                            }
                        }

                        .item-img {
                            img {
                                width: 100%;
                                height: 195px;
                            }

                            margin-bottom: 10px;
                        }

                        .item-info {
                            h3 {
                                font-size: 14px;
                                color: $colorB;
                                line-height: 14px;
                                font-weight: bold;
                            }

                            p {
                                color: $colorD;
                                line-height: 13px;
                                margin: 6px auto 13px;
                            }

                            .price {
                                color: $colorA;
                                font-size: 14px;
                                font-weight: bold;
                                cursor: pointer;

                                &:after {
                                    @include backgroundImage(18px, 18px, '/imgs/icon-cart-hover.png');
                                    content: ' ';
                                    margin-left: 5px;
                                    vertical-align: middle;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
</style>