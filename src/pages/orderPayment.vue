<template>
    <div class="order-payment">
        <div class="wrapper">
            <div class="container">
                <div class="order-wrap">
                    <div class="item-order">
                        <div class="icon-success"></div>
                        <div class="order-info">
                            <h2>订单已提交！该付款啦~</h2>
                            <p>请在<span>5分钟</span>内完成支付, 超时后其实也没什么影响 :D</p>
                            <p>收货信息：{{shippingInfo}}</p>
                        </div>
                        <div class="order-total">
                            <p>订单金额：<span>{{totalPrice}}</span>元</p>
                            <p>订单详情<em class="icon-down" :class="{'up':showDetail}"
                                       @click="showDetail=!showDetail"></em></p>
                        </div>
                    </div>
                    <div class="item-detail" v-if="showDetail">
                        <div class="item">
                            <div class="detail-title">订单号：</div>
                            <div class="detail-info theme-color">{{orderNo}}</div>
                        </div>
                        <div class="item">
                            <div class="detail-title">收货信息：</div>
                            <div class="detail-info">{{shippingInfo}}</div>
                        </div>
                        <div class="item good">
                            <div class="detail-title">商品名称：</div>
                            <div class="detail-info">
                                <ul>
                                    <li v-for="(item,index) in orderDetail" :key="index">
                                        <img v-lazy="item.productImage"/>{{item.productName}}
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="item">
                            <div class="detail-title">订单备注：</div>
                            <div class="detail-info">去外包装 不要商品 不要配件</div>
                        </div>
                    </div>
                </div>
                <div class="item-pay">
                    <h3>选择以下支付方式付款</h3>
                    <div class="pay-way">
                        <p>验证码支付</p>
                        <div class="pay pay-verifyCode">
                            <img :src="vcUrl" @click="updateVerifyCode" alt="">
                        </div>
                    </div>
                    <div class="input">
                        <input type="text" placeholder="请输入验证码" v-model="code">
                        <div class="tips">
                            [ 输入验证码下单，立省百分百！ ]
                        </div>
                    </div>
                    <a href="javascript:;" class="btn btn-large float-r" @click="payOrder">支付</a>
                </div>
            </div>
        </div>
    </div>
</template>
<script>

    export default {
        name: 'order-payment',
        data() {
            return {
                orderNo: this.$route.query.orderNo,
                orderDetail: [],
                shippingInfo: '',
                totalPrice: 0,
                code: '',
                vcUrl: '/api/verifyCode?time=' + new Date(),
                showDetail: false,
            }
        },
        mounted() {
            this.getOrderDetail();
        },
        methods: {
            getOrderDetail() {
                this.axios.get(`/orders/${this.orderNo}`).then((res) => {
                    let shipping = res.shippingVo;
                    this.shippingInfo = `${shipping.receiverName} ${shipping.receiverMobile} ${shipping.receiverProvince} ${shipping.receiverCity} ${shipping.receiverDistrict} ${shipping.receiverAddress}`;
                    this.orderDetail = res.orderItemVoList;
                    for (let orderUnit of this.orderDetail) {
                        this.totalPrice += orderUnit.totalPrice;
                    }
                });
            },
            updateVerifyCode() {
                this.vcUrl = '/api/verifyCode?time=' + new Date();
            },
            payOrder() {
                if (this.preCheck()) {
                    this.axios.post("/orders/payment", {
                        orderNo: this.orderNo,
                        code: this.code
                    }).then(() => {
                        this.$message.success("支付成功！");
                        this.goToOrderList();
                    }).catch(() => {
                        this.updateVerifyCode();
                    });
                } else {
                    this.updateVerifyCode();
                }
            },
            preCheck() {
                let code = this.code;
                let regCode = /^\w{4}$/;
                if (!regCode.test(code)) {
                    this.$message.error("验证码格式有误！");
                    return false;
                }
                return true;
            },
            goToOrderList() {
                this.$router.push('/order/list');
            }
        }
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config.scss";

    .order-payment {
        .wrapper {
            background-color: #f6f9fa;
            padding-top: 30px;
            padding-bottom: 61px;

            .order-wrap {
                padding: 62px 50px;
                background-color: #ffffff;
                font-size: 14px;
                margin-bottom: 30px;

                .item-order {
                    display: flex;
                    align-items: center;

                    .icon-success {
                        width: 90px;
                        height: 90px;
                        border-radius: 50%;
                        background: url('/imgs/smile.png') #80c58a no-repeat center;
                        background-size: 60px;
                        margin-right: 40px;
                    }

                    .order-info {
                        margin-right: 248px;

                        h2 {
                            font-size: 24px;
                            color: $colorB;
                            margin-bottom: 20px;
                        }

                        p {
                            color: $colorB;

                            span {
                                font-weight: bold;
                                color: $colorA;
                            }
                        }
                    }

                    .order-total {
                        & > p:first-child {
                            margin-bottom: 30px;
                        }

                        span {
                            font-size: 28px;
                            color: $colorA;
                        }

                        .icon-down {
                            display: inline-block;
                            width: 14px;
                            height: 10px;
                            background: url('/imgs/icon-down.png') no-repeat center;
                            background-size: contain;
                            margin-left: 9px;
                            transition: all .5s;
                            cursor: pointer;

                            &.up {
                                transform: rotate(180deg);
                            }
                        }

                        .icon-up {
                            transform: rotate(180deg);
                        }
                    }
                }

                .item-detail {
                    border-top: 1px solid #D7D7D7;
                    padding-top: 47px;
                    padding-left: 130px;
                    font-size: 14px;
                    margin-top: 45px;

                    .item {
                        margin-bottom: 19px;

                        .detail-title {
                            float: left;
                            width: 100px;
                        }

                        .detail-info {
                            display: inline-block;

                            li {
                                margin-bottom: 14px;
                            }

                            img {
                                width: 80px;
                                vertical-align: middle;
                                margin-right: 24px;
                            }
                        }
                    }
                }
            }

            .item-pay {
                padding: 26px 50px 72px;
                background-color: #ffffff;

                h3 {
                    font-size: 20px;
                    font-weight: bold;
                    color: $colorA;
                    padding-bottom: 24px;
                    border-bottom: 1px solid #D7D7D7;
                    margin-bottom: 26px;
                }

                .pay-way {
                    font-size: 18px;

                    .pay {
                        display: inline-block;
                        width: 188px;
                        height: 64px;
                        border: 1px solid #D7D7D7;
                        cursor: pointer;
                    }

                    .pay-verifyCode {
                        background-size: 103px 38px;
                        margin-top: 19px;

                        img {
                            position: relative;
                            top: 50%;
                            left: 50%;
                            transform: translate(-50%, -50%);
                        }
                    }
                }

                .input {
                    display: inline-block;
                    width: 188px;
                    height: 38px;
                    border: 1px solid #D7D7D7;
                    margin-top: 10px;

                    input {
                        width: 100%;
                        height: 100%;
                        border: none;
                        padding: 18px;
                    }

                    .tips {
                        margin-top: 14px;
                        display: flex;
                        justify-content: space-between;
                        font-size: 12px;
                        color: $colorA;
                    }
                }
            }


        }
    }
</style>