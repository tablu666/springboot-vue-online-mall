<template>
    <div class="category">
        <div class="container">
            <div class="product-box">
                <h2>特色专区 【{{categoryName}}】</h2>
                <div class="line"></div>
                <div class="list-box">
                    <div class="list" v-for="(arr, i) in productList" v-bind:key="i">
                        <div class="item" v-for="(item, j) in arr" v-bind:key="j">
                            <div class="item-img">
                                <img v-lazy="item.mainImage" alt="">
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
    import Modal from "./../components/Modal";
    import ServiceBar from "../components/ServiceBar";

    export default {
        name: 'category',
        components: {
            ServiceBar,
            Modal
        },
        data() {
            return {
                categoryName: '',
                productList: [],
                categoryId: this.$route.params.id,
                showModal: false
            }
        },
        mounted() {
            this.getCategoryName();
            this.getProductList();
        },
        methods: {
            getProductList() {
                this.axios.get('/products', {
                    params: {
                        categoryId: this.categoryId,
                        pageSize: 12
                    }
                }).then((res) => {
                    this.productList = [
                        res.list.slice(0, 3),
                        res.list.slice(3, 6),
                        res.list.slice(6, 9),
                        res.list.slice(9, 12)
                    ];
                });
            },
            getCategoryName() {
                this.axios.get('/categories').then((list)=>{
                    for (let category of list) {
                        if (category.id === 100001) {
                            for (let sub of category.subCategories) {
                                if (sub.id == this.categoryId) {
                                    this.categoryName = sub.name;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                });
            },
            addToCart(id) {
                this.axios.post('/carts',{
                    productId: id,
                    selected: true
                }).then((res)=>{
                    this.showModal = true;
                    this.$store.dispatch('saveCartCount', res.cartTotalQuantity);
                }).catch(()=>{
                    window.location.href = '/#/login'
                });
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

    .category {
        .container {
            .product-box {
                padding: 15px 0 15px;

                .line {
                    height: 0;
                    margin-top: 5px;
                    margin-bottom: 15px;
                    border-top: 1px solid #E5E5E5;
                }

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
    }
</style>