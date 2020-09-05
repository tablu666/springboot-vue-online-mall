<template>
    <div class="order-list">
        <order-header title="我的订单">
            <template v-slot:tip>
                <span>东西太少了，再去买点吧！</span>
            </template>
        </order-header>
        <div class="wrapper">
            <div class="container">
                <div class="order-box">
                    <div class="order" v-for="(order,index) in orderList" v-bind:key="index">
                        <div class="order-title">
                            <div class="item-info float-l">
                                {{UTCDateToLocalDate(order.createTime)}}
                                <span>|</span>
                                {{order.shippingVo.receiverName}}
                                <span>|</span>
                                订单号：{{order.orderNo}}
                                <span>|</span>
                                {{order.paymentType === 2 ? '验证码支付' : '其他方式支付'}}
                            </div>
                            <div class="item-money float-r">
                                <span>订单金额：</span>
                                <span class="money">{{order.payment}}</span>
                                <span>元</span>
                            </div>
                        </div>
                        <div class="order-content clearFix">
                            <div class="good-box float-l">
                                <div class="good-list" v-for="(item, i) in order.orderItemVoList" v-bind:key="i">
                                    <div class="good-img">
                                        <img v-lazy="item.productImage" alt="">
                                    </div>
                                    <div class="good-name">
                                        <div class="p-name">{{item.productName}}</div>
                                        <div class="p-money">[{{item.currentUnitPrice}}] x {{item.quantity}}</div>
                                    </div>
                                </div>
                            </div>
                            <div class="good-state float-r" v-if="order.status == 10">
                                <a href="javascript:;" @click="goToPayment(order.orderNo)">{{mapOrderStatus(order.status)}}</a>
                            </div>
                            <div class="good-state float-r" v-else>
                                <a href="javascript:;">{{mapOrderStatus(order.status)}}</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import OrderHeader from './../components/OrderHeader'

    export default {
        name: 'order-list',
        components: {
            OrderHeader
        },
        data() {
            //orderStatus: 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
            return {
                orderList: [],
            }
        },
        mounted() {
            this.getOrderList();
        },
        methods: {
            getOrderList() {
                this.axios.get('/orders').then((res) => {
                    this.orderList = res.list;
                });
            },
            mapOrderStatus(status) {
                let orderStatus;
                switch (status) {
                    case 0:
                        orderStatus = '已取消';
                        break;
                    case 10:
                        orderStatus = '未付款';
                        break;
                    case 20:
                        orderStatus = '已付款';
                        break;
                    case 40:
                        orderStatus = '已发货';
                        break;
                    case 50:
                        orderStatus = '交易成功';
                        break;
                    case 60:
                        orderStatus = '交易关闭';
                        break;
                }
                return orderStatus;
            },
            /**
             * @return {string}
             */
            UTCDateToLocalDate(dateStr) {
                return new Date(dateStr).toISOString().replace(/T/g, " ").replace(/\.[\d]{3}Z/, "");
            },
            goToPayment(orderNo) {
                this.$router.push({
                    path: '/order/payment',
                    query: {orderNo}
                });
            }
        }
    }
</script>
<style lang="scss">
    @import './../assets/scss/config.scss';
    @import './../assets/scss/mixin.scss';

    .order-list {
        .wrapper {
            background-color: #f6f9fa;
            padding-top: 33px;
            padding-bottom: 110px;

            .order-box {
                .order {
                    @include border();
                    background-color: $colorG;
                    margin-bottom: 31px;

                    &:last-child {
                        margin-bottom: 0;
                    }

                    .order-title {
                        @include height(74px);
                        background-color: #ffffff;
                        padding: 0 43px;
                        font-size: 16px;
                        color: $colorC;

                        .item-info {
                            span {
                                margin: 0 9px;
                            }
                        }

                        .money {
                            font-size: 24px;
                            color: $colorB;
                        }
                    }

                    .order-content {
                        padding: 0 43px;

                        .good-box {
                            width: 88%;

                            .good-list {
                                display: flex;
                                align-items: center;
                                height: 145px;

                                .good-img {
                                    width: 112px;

                                    img {
                                        width: 100%;
                                    }
                                }

                                .good-name {
                                    margin-left: 30px;
                                    font-size: 16px;
                                    color: $colorB;

                                    .p-name {
                                        font-weight: bold;
                                        margin-bottom: 5px;
                                    }
                                }
                            }
                        }

                        .good-state {
                            @include height(145px);
                            font-size: 18px;
                            font-weight: 300;
                            color: $colorA;

                            a {
                                color: $colorA;
                            }
                        }
                    }
                }

                .pagination {
                    text-align: right;
                }

                .el-pagination.is-background .el-pager li:not(.disabled).active {
                    background-color: $colorA;
                }

                .el-button--primary {
                    background-color: $colorA;
                    border-color: $colorA;
                }

                .load-more, .scroll-more {
                    text-align: center;
                }
            }
        }
    }
</style>