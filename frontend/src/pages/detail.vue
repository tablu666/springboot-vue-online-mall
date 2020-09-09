<template>
    <div class="detail">
        <product-param :title="product.name"></product-param>
        <div class="wrapper">
            <div class="container clearFix">
                <div class="image">
                    <img :src="product.mainImage" alt="">
                </div>
                <div class="content">
                    <h2 class="item-title">{{product.name}}</h2>
                    <p class="item-info">{{product.subtitle}}</p>
                    <div class="line"></div>
                    <div class="item-addr">
                        <i class="icon-loc"></i>
                        <div class="addr">中国 浙江省 Zhejiang China</div>
                        <div class="stock" v-if="product.stock < 10" style="color: red">库存：{{product.stock}}</div>
                        <div class="stock" v-else>库存：{{product.stock}}</div>
                    </div>
                    <div class="item-version clearFix">
                        <h2>版本 Version</h2>
                        <div class="phone float-l" :class="{'checked':version===1}" @click="version=1">精装版</div>
                        <div class="phone float-r" :class="{'checked':version===2}" @click="version=2">签名限量版</div>
                    </div>
                    <div class="item-color">
                        <h2>包装 Package</h2>
                        <div class="phone checked">
                            <span class="color"></span>
                            环保绿
                        </div>
                    </div>
                    <div class="item-total">
                        <div class="phone-info clearFix">
                            <div class="float-l"><span>{{product.name}}</span> 【{{version===1 ? '精装版' : '签名限量版'}} 环保绿】
                            </div>
                            <div class="float-r">{{product.price}}</div>
                        </div>
                        <div class="phone-total">总计：{{product.price}} 元</div>
                    </div>
                    <div class="btn-group">
                        <a href="javascript:;" class="btn btn-huge float-l" @click="addCart">加入购物车</a>
                    </div>
                </div>
            </div>
        </div>
        <service-bar></service-bar>
    </div>
</template>
<script>
    import ProductParam from './../components/ProductParam'
    import ServiceBar from './../components/ServiceBar';

    export default {
        name: 'detail',
        data() {
            return {
                productId: this.$route.params.id,
                version: 1,
                product: {}
            }
        },
        components: {
            ProductParam,
            ServiceBar
        },
        mounted() {
            this.getProductInfo();
        },
        methods: {
            getProductInfo() {
                this.axios.get(`/products/${this.productId}`).then((product) => {
                    this.product = product;
                });
            },
            addCart() {
                this.axios.post('/carts', {
                    productId: this.productId,
                    selected: true
                }).then((response={cartProductVoList:0})=>{
                    this.$store.dispatch('saveCartCount', response.cartTotalQuantity);
                    this.$router.push('/cart');
                }).catch(()=>{
                    window.location.href = '/#/login'
                });
            }
        }
    }
</script>
<style lang="scss">
    @import './../assets/scss/config.scss';
    @import './../assets/scss/mixin.scss';

    .detail {
        .wrapper {
            .image {
                float: left;
                width: 542px;
                height: 384px;
                margin-top: 5px;

                img {
                    width: 100%;
                    height: 100%;
                }
            }

            .content {
                float: right;
                width: 584px;
                height: 870px;

                .item-title {
                    font-size: 28px;
                    padding-top: 30px;
                    padding-bottom: 16px;
                    height: 26px;
                }

                .item-info {
                    font-size: 14px;
                    height: 36px;
                }

                .line {
                    height: 0;
                    margin-top: 5px;
                    margin-bottom: 15px;
                    border-top: 1px solid #E5E5E5;
                }

                .item-addr {
                    height: 108px;
                    background-color: #FAFAFA;
                    border: 1px solid #E5E5E5;
                    box-sizing: border-box;
                    padding-top: 31px;
                    padding-left: 64px;
                    font-size: 14px;
                    line-height: 14px;
                    position: relative;

                    .icon-loc {
                        position: absolute;
                        top: 27px;
                        left: 34px;
                        @include backgroundImage(20px, 20px, '/imgs/icon-loc.png');
                    }

                    .addr {
                        color: #666666;
                    }

                    .stock {
                        margin-top: 15px;
                        color: $colorA;
                        font-weight: bold;
                    }
                }

                .item-version, .item-color {
                    margin-top: 30px;

                    h2 {
                        font-size: 18px;
                        margin-bottom: 20px;
                    }
                }

                .item-version, .item-color {
                    .phone {
                        width: 287px;
                        height: 50px;
                        line-height: 50px;
                        font-size: 14px;
                        color: #333333;
                        border: 1px solid #E5E5E5;
                        box-sizing: border-box;
                        text-align: center;
                        cursor: pointer;

                        span {
                            color: #666666;
                            margin-left: 15px;
                        }

                        .color {
                            display: inline-block;
                            width: 14px;
                            height: 14px;
                            background-color: #32CD32;
                        }

                        &.checked {
                            border: 1px solid $colorA;
                            color: $colorA;
                        }
                    }
                }

                .item-total {
                    height: 108px;
                    background: #FAFAFA;
                    padding: 24px 33px 29px 30px;
                    font-size: 14px;
                    margin-top: 30px;
                    margin-bottom: 30px;
                    box-sizing: border-box;

                    .phone-info {
                        color: $colorB;

                        span {
                            font-weight: bold;
                        }
                    }

                    .phone-total {
                        font-size: 24px;
                        color: $colorA;
                        margin-top: 14px;
                    }
                }


            }
        }

    }
</style>