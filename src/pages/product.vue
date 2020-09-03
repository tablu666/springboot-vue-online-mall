<template>
    <div class="product">
        <product-param v-bind:title="product.name">
            <template v-slot:purchase>
                <button class="btn" @click="purchase">立即购买</button>
            </template>
        </product-param>
        <div class="content">
            <div class="item-bg">
                <h2>{{product.name}}</h2>
                <h3>{{product.subtitle}}</h3>
                <div class="price">
                    <span>￥<em>{{product.price}}</em></span>
                </div>
            </div>
            <div class="item-bg-2"></div>
            <div class="item-bg-3"></div>
            <div class="item-bg-4"></div>
        </div>
    </div>
</template>
<script>
    import ProductParam from "../components/ProductParam";

    export default {
        name: 'product',
        components: {
            ProductParam
        },
        data() {
            return {
                product: {}
            }
        },
        mounted() {
            this.getProductInfo();
        },
        methods: {
            getProductInfo() {
                let productId = this.$route.params.id;
                this.axios.get(`/products/${productId}`).then((product) => {
                    this.product = product;
                });
            },
            purchase() {
                let productId = this.$route.params.id;
                this.$router.push(`/detail/${productId}`);
            }
        }
    }
</script>
<style lang="scss">
    @import './../assets/scss/mixin.scss';

    .product {
        button {
            margin-left: 10px;
        }

        .content {
            .item-bg {
                background: url('/imgs/product/product-bg-1.jpg') no-repeat center;
                height: 718px;
                text-align: center;

                h2 {
                    font-size: 80px;
                    padding-top: 55px;
                    color: #f6f9fa;
                }

                h3 {
                    margin-top: 4px;
                    font-size: 24px;
                    letter-spacing: 10px;
                    color: #f6f9fa;

                }

                .price {
                    margin-top: 20px;
                    font-size: 30px;
                    color: #f6f9fa;

                    em {
                        font-style: normal;
                        font-size: 38px;
                    }
                }
            }

            .item-bg-2 {
                background: url('/imgs/product/product-bg-2.png') no-repeat center;
                height: 600px;
            }

            .item-bg-3 {
                background: url('/imgs/product/product-bg-3.jpg') no-repeat center;
                height: 600px;
            }

            .item-bg-4 {
                background: url('/imgs/product/product-bg-4.jpg') no-repeat center;
                height: 600px;
            }
        }
    }
</style>