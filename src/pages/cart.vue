<template>
    <div class="cart">
        <order-header title="我的购物车">
            <template v-slot:tip>
                <span>温馨提示：虚构产品，下单即表示收货</span>
            </template>
        </order-header>
        <div class="wrapper">
            <div class="container">
                <div class="cart-box">
                    <ul class="cart-item-head">
                        <li class="col-1"><span class="checkbox"
                                                v-bind:class="{'checked':allChecked}"
                                                @click="toggleAll"></span>全选
                        </li>
                        <li class="col-3">商品名称</li>
                        <li class="col-1">单价</li>
                        <li class="col-2">数量</li>
                        <li class="col-1">小计</li>
                        <li class="col-1">操作</li>
                    </ul>
                    <ul class="cart-item-list">
                        <li class="cart-item" v-for="(item, index) in list" v-bind:key="index">
                            <div class="item-check">
                                <span class="checkbox" v-bind:class="{'checked':item.productSelected}"
                                      @click="updateCart(item)"></span>
                            </div>
                            <div class="item-name">
                                <img v-lazy="item.productMainImage" alt="">
                                <span>{{item.productName + ' , ' + item.productSubtitle}}</span>
                            </div>
                            <div class="item-price">{{item.productPrice}}</div>
                            <div class="item-num">
                                <div class="num-box">
                                    <a href="javascript:;" @click="updateCart(item, '-')">-</a>
                                    <span>{{item.quantity}}</span>
                                    <a href="javascript:;" @click="updateCart(item, '+')">+</a>
                                </div>
                            </div>
                            <div class="item-total">{{item.productTotalPrice}}</div>
                            <div class="item-del" @click="delConfirm(item)"></div>
                        </li>
                    </ul>
                </div>
                <div class="order-wrap clearFix">
                    <div class="cart-tip float-l">
                        <a href="/">- 再逛逛 -</a>
                        共<span>{{list.length}}</span>件商品，已选择<span>{{checkedCount}}</span>件
                    </div>
                    <div class="total float-r">
                        总计：<span>{{cartTotalPrice}}</span>元
                        <a href="javascript:;" class="btn" @click="goToOrder">结算</a>
                    </div>
                </div>
            </div>
        </div>
        <service-bar></service-bar>
        <nav-footer></nav-footer>
        <modal title="系统提示"
               confirmText="确认 | 我意已决"
               cancelText="不了 | 再想想"
               btn-type="3"
               modal-type="middle"
               v-bind:show-modal="showModal"
               @submit="deleteProduct(currItem)"
               @cancel="showModal=false">
            <template v-slot:body>
                <p><span style="color:red; font-weight: bold">[WARNING]</span> 是否确认删除？</p>
            </template>
        </modal>
    </div>
</template>
<script>
    import OrderHeader from "../components/OrderHeader";
    import ServiceBar from "../components/ServiceBar";
    import NavFooter from "../components/NavFooter";
    import Modal from "./../components/Modal";

    export default {
        name: 'cart',
        components: {
            OrderHeader,
            ServiceBar,
            NavFooter,
            Modal
        },
        data() {
            return {
                list: [],
                allChecked: false,
                cartTotalPrice: 0,
                checkedCount: 0,
                showModal: false,
                currItem: {}
            }
        },
        mounted() {
            this.getCartList();
        },
        methods: {
            getCartList() {
                this.axios.get('/carts').then((res) => {
                    this.dataHandler(res);
                });
            },
            //全选，全不选
            toggleAll() {
                let url = this.allChecked ? '/carts/unSelectAll' : '/carts/selectAll';
                this.axios.put(url).then((res) => {
                    this.dataHandler(res);
                });
            },
            //获取购物车当前状态
            dataHandler(res) {
                this.list = res.cartProductVoList || [];
                this.allChecked = res.selectedAll;
                this.cartTotalPrice = res.cartTotalPrice;
                this.checkedCount = this.list.filter(item => item.productSelected).length;
            },
            //更新购物车数量，控制单一商品选中状态
            updateCart(item, type) {
                let quantity = item.quantity;
                let selected = item.productSelected;
                if (type == '-') {
                    if (quantity == 1) {
                        return;
                    }
                    quantity--;
                } else if (type == '+') {
                    if (quantity >= item.productStock) {
                        alert("库存不足！");
                        return;
                    }
                    quantity++;
                } else {
                    selected = !item.productSelected;
                }
                this.axios.put(`/carts/${item.productId}`, {
                    quantity,
                    selected
                }).then((res) => {
                    this.dataHandler(res);
                });
            },
            delConfirm(item) {
                this.showModal = true;
                this.currItem = item;
            },
            deleteProduct(item) {
                this.axios.delete(`/carts/${item.productId}`).then((res) => {
                    this.dataHandler(res);
                });
                this.showModal = false;
            },
            goToOrder() {
                let notChecked = this.list.every(item => !item.productSelected);
                if (notChecked) {
                    alert("未选择商品！");
                } else {
                    this.$router.push('/order/confirm');
                }
            }
        }
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config";

    .cart {
        .wrapper {
            background-color: #F5F5F5;
            padding-top: 30px;
            padding-bottom: 114px;

            .cart-box {
                background-color: #ffffff;
                font-size: 14px;
                color: #999999;
                text-align: center;

                .checkbox {
                    display: inline-block;
                    width: 22px;
                    height: 22px;
                    border: 1px solid #E5E5E5;
                    vertical-align: middle;
                    margin-right: 17px;
                    cursor: pointer;

                    &.checked {
                        background: url('/imgs/icon-check.png') $colorA no-repeat center;
                        background-size: 16px 12px;
                        border: none;
                    }
                }

                .cart-item-head {
                    display: flex;
                    height: 79px;
                    line-height: 79px;

                    .col-1 {
                        flex: 1;
                    }

                    .col-2 {
                        flex: 2;
                    }

                    .col-3 {
                        flex: 3;
                    }
                }

                .cart-item-list {
                    .cart-item {
                        display: flex;
                        align-items: center;
                        height: 125px;
                        border-top: 1px solid #E5E5E5;
                        font-size: 16px;

                        .item-check {
                            flex: 1;
                        }

                        .item-name {
                            flex: 3;
                            font-size: 18px;
                            color: #333333;
                            display: flex;
                            align-items: center;

                            img {
                                width: 100px;
                                height: 75px;
                                vertical-align: middle;
                            }

                            span {
                                margin-left: 30px;
                            }
                        }

                        .item-price {
                            flex: 1;
                            color: #333333;
                        }

                        .item-num {
                            flex: 2;

                            .num-box {
                                display: inline-block;
                                width: 150px;
                                height: 40px;
                                line-height: 40px;
                                border: 1px solid #E5E5E5;
                                font-size: 14px;

                                a {
                                    display: inline-block;
                                    width: 50px;
                                    color: #333333;
                                }

                                span {
                                    display: inline-block;
                                    width: 50px;
                                    color: #333333;
                                }
                            }
                        }

                        .item-total {
                            flex: 1;
                            color: $colorA;
                        }

                        .item-del {
                            flex: 1;
                            width: 14px;
                            height: 12px;
                            background: url('/imgs/icon-close.png') no-repeat center;
                            background-size: contain;
                            cursor: pointer;
                        }
                    }
                }
            }

            .order-wrap {
                font-size: 14px;
                color: #666666;
                margin-top: 20px;
                height: 50px;
                line-height: 50px;

                .cart-tip {
                    margin-left: 29px;

                    a {
                        color: $colorB;
                        font-weight: bold;
                        margin-right: 37px;
                    }

                    span {
                        color: $colorA;
                        font-weight: bold;
                        margin: 0 5px;
                    }
                }

                .total {
                    font-size: 14px;
                    color: $colorA;

                    span {
                        font-size: 24px;
                    }

                    a {
                        width: 202px;
                        height: 50px;
                        line-height: 50px;
                        font-size: 18px;
                        margin-left: 37px;
                    }
                }
            }
        }
    }
</style>