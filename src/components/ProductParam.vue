<template>
    <div class="nav-bar" :class="{'is_fixed':isFixed}">
        <div class="container">
            <div class="product-title">
                iPhone12 Ultra
            </div>
            <div class="product-param">
                <a href="javascript:;">简介</a><span>|</span>
                <a href="javascript:;">参数</a><span>|</span>
                <a href="javascript:;">用户评价</a>
                <slot name="purchase"></slot>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'nav-bar',
        data() {
            return {
                isFixed: false
            }
        },
        mounted() {
            window.addEventListener('scroll', this.initHeight)
        },
        methods: {
            initHeight() {
                let scrollTop = window.pageYOffset
                    || document.documentElement.scrollTop
                    || document.body.scrollTop;
                this.isFixed = scrollTop > 152;
            }
        },
        destroyed() {
            window.removeEventListener('scroll', this.initHeight, false)
        }
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config.scss";
    @import "./../assets/scss/mixin.scss";

    .nav-bar {
        height: 70px;
        line-height: 70px;
        border-top: 1px solid $colorH;
        background-color: $colorG;

        &.is_fixed {
            position: fixed;
            top: 0;
            width: 100%;
            box-shadow: 0 5px 5px $colorA;
        }

        .container {
            @include flex();

            .product-title {
                font-size: $fontH;
                color: $colorB;
                font-weight: bold;
            }

            .product-param {
                font-size: $fontJ;

                span {
                    margin: 0 10px;
                }

                a {
                    color: $colorC;
                }
            }
        }
    }
</style>