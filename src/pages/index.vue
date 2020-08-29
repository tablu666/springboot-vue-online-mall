<template>
    <div class="index">
        <div class="container">
            <div class="swiper-box">
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
            <div class="ads-box"></div>
            <div class="banner"></div>
            <div class="product-box"></div>
        </div>
        <service-bar></service-bar>
    </div>
</template>
<script>
    import ServiceBar from "./../components/ServiceBar";
    import {Swiper, SwiperSlide} from 'vue-awesome-swiper';
    import 'swiper/css/swiper.css';

    export default {
        name: 'index',
        components: {
            Swiper,
            SwiperSlide,
            ServiceBar
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
                        clickable:true
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
                ]
            }
        }
    }
</script>
<style lang="scss">
    .index {
        .swiper-box {
            .swiper-container {
                height: 451px;

                img {
                    width: 100%;
                    height: 100%;
                }
            }
        }
    }
</style>