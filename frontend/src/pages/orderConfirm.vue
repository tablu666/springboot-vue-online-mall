<template>
    <div class="order-confirm">
        <order-header title="订单确认">
            <template v-slot:tip>
                <span>请仔细核对收货信息</span>
            </template>
        </order-header>
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
             style="position: absolute; width: 0px; height: 0px; overflow: hidden;">
            <defs>
                <symbol id="icon-add" viewBox="0 0 31 32">
                    <title>add</title>
                    <path d="M30.745 15.152h-14.382v-14.596c0-0.308-0.243-0.557-0.543-0.557s-0.543 0.249-0.543 0.557v14.596h-14.665c-0.3 0-0.543 0.249-0.543 0.557s0.243 0.557 0.543 0.557h14.665v15.177c0 0.307 0.243 0.557 0.543 0.557s0.543-0.249 0.543-0.557v-15.177h14.382c0.3 0 0.543-0.249 0.543-0.557s-0.243-0.557-0.543-0.557z"
                          class="path1"></path>
                </symbol>
                <symbol id="icon-edit" viewBox="0 0 32 32">
                    <title>edit</title>
                    <path d="M28.287 8.51l-4.805-4.806 0.831-0.831c0.472-0.472 1.086-0.777 1.564-0.777 0.248 0 0.452 0.082 0.622 0.253l3.143 3.144c0.539 0.54 0.133 1.529-0.524 2.186l-0.831 0.831zM26.805 9.992l-1.138 1.138-4.805-4.806 1.138-1.138 4.805 4.806zM24.186 12.612l-14.758 14.762-4.805-4.806 14.758-14.762 4.805 4.806zM7.379 28.288l-4.892 1.224 1.223-4.894 3.669 3.67zM31.123 4.011l-3.143-3.144c-0.567-0.567-1.294-0.867-2.103-0.867-1.036 0-2.174 0.52-3.045 1.391l-20.429 20.436c-0.135 0.134-0.23 0.302-0.276 0.487l-2.095 8.385c-0.089 0.355 0.017 0.736 0.276 0.995 0.198 0.198 0.461 0.307 0.741 0.307 0.085 0 0.171-0.010 0.254-0.031l8.381-2.096c0.185-0.047 0.354-0.142 0.487-0.276l20.43-20.436c1.409-1.41 2.042-3.632 0.524-5.15v0z"
                          class="path1"></path>
                </symbol>
                <symbol id="icon-del" viewBox="0 0 32 32">
                    <title>delete</title>
                    <path d="M11.355 4.129v-2.065h9.29v2.065h-9.29zM6.194 29.935v-23.742h19.613v23.742h-19.613zM30.968 4.129h-8.258v-3.097c0-0.569-0.463-1.032-1.032-1.032h-11.355c-0.569 0-1.032 0.463-1.032 1.032v3.097h-8.258c-0.569 0-1.032 0.463-1.032 1.032s0.463 1.032 1.032 1.032h3.097v24.774c0 0.569 0.463 1.032 1.032 1.032h21.677c0.569 0 1.032-0.463 1.032-1.032v-24.774h3.097c0.569 0 1.032-0.463 1.032-1.032s-0.463-1.032-1.032-1.032v0z"
                          class="path1"></path>
                    <path d="M10.323 9.806c-0.569 0-1.032 0.463-1.032 1.032v14.452c0 0.569 0.463 1.032 1.032 1.032s1.032-0.463 1.032-1.032v-14.452c0-0.569-0.463-1.032-1.032-1.032z"
                          class="path2"></path>
                    <path d="M16 9.806c-0.569 0-1.032 0.463-1.032 1.032v14.452c0 0.569 0.463 1.032 1.032 1.032s1.032-0.463 1.032-1.032v-14.452c0-0.569-0.463-1.032-1.032-1.032z"
                          class="path3"></path>
                    <path d="M21.677 9.806c-0.569 0-1.032 0.463-1.032 1.032v14.452c0 0.569 0.463 1.032 1.032 1.032s1.032-0.463 1.032-1.032v-14.452c0-0.569-0.463-1.032-1.032-1.032z"
                          class="path4"></path>
                </symbol>
            </defs>
        </svg>
        <div class="wrapper">
            <div class="container">
                <div class="order-box">
                    <div class="item-address">
                        <h2 class="addr-title">收货地址</h2>
                        <div class="addr-list clearFix">
                            <div class="addr-info" :class="{'checked':index == checkIndex}" @click="checkIndex=index" v-for="(item,index) in shippingList" v-bind:key="index">
                                <h2>{{item.receiverName}}</h2>
                                <div class="phone">{{item.receiverMobile}}</div>
                                <div class="street">{{item.receiverProvince +' '+item.receiverCity + ' ' +
                                    item.receiverDistrict}}<br>{{item.receiverAddress}}
                                </div>
                                <div class="action">
                                    <a href="javascript:;" class="float-l" @click="delShipping(item)">
                                        <svg class="icon icon-del">
                                            <use xlink:href="#icon-del"></use>
                                        </svg>
                                    </a>
                                    <a href="javascript:;" class="float-r" @click="updateShippingModal(item)">
                                        <svg class="icon icon-edit">
                                            <use xlink:href="#icon-edit"></use>
                                        </svg>
                                    </a>
                                </div>
                            </div>
                            <div class="addr-add" @click="openShippingModal">
                                <div class="icon-add"></div>
                                <div>添加新地址</div>
                            </div>
                        </div>
                    </div>
                    <div class="item-good">
                        <h2>商品</h2>
                        <ul>
                            <li v-for="(item,index) in selectedCartList" v-bind:key="index">
                                <div class="good-name">
                                    <img v-lazy="item.productMainImage" alt="">
                                    <span>{{item.productName + ' 【' + item.productSubtitle}}】</span>
                                </div>
                                <div class="good-price">[{{item.productPrice}}] x {{item.quantity}}</div>
                                <div class="good-total">{{item.productTotalPrice}}元</div>
                            </li>
                        </ul>
                    </div>
                    <div class="item-shipping">
                        <h2>配送方式</h2>
                        <span>虚拟发货</span>
                    </div>
                    <div class="item-invoice">
                        <h2>订单备注</h2>
                        <a href="javascript:;">去外包装</a>
                        <a href="javascript:;">不要商品</a>
                        <a href="javascript:;">不要配件</a>
                    </div>
                    <div class="detail">
                        <div class="item">
                            <span class="item-name">商品件数：</span>
                            <span class="item-val">{{productNum}}件</span>
                        </div>
                        <div class="item">
                            <span class="item-name">商品总价：</span>
                            <span class="item-val">{{totalPrice}}元</span>
                        </div>
                        <div class="item">
                            <span class="item-name">优惠活动：</span>
                            <span class="item-val">0元</span>
                        </div>
                        <div class="item">
                            <span class="item-name">运费：</span>
                            <span class="item-val">0元</span>
                        </div>
                        <div class="item-total">
                            <span class="item-name">总费用：</span>
                            <span class="item-val">{{totalPrice}}元</span>
                        </div>
                    </div>
                    <div class="btn-group">
                        <a href="/#/cart" class="btn btn-default btn-large">返回购物车</a>
                        <a href="javascript:;" class="btn btn-large" @click="orderSubmit">下单</a>
                    </div>
                </div>
            </div>
        </div>
        <modal title="系统提示"
               btn-type="1"
               :show-modal="showDelModal"
               @cancel="showDelModal=false"
               @submit="submitShipping">
            <template v-slot:body><p>确认删除该地址嘛？</p></template>
        </modal>
        <modal title="系统提示"
               btnType="1"
               :showModal="showEditModal"
               @cancel="showEditModal=false"
               @submit="submitShipping">
            <template v-slot:body>
                <div class="edit-wrap">
                    <div class="item">
                        <input type="text" class="input" placeholder="收件人" v-model="currItem.receiverName">
                        <input type="text" class="input" placeholder="手机号码" v-model="currItem.receiverMobile">
                    </div>
                    <div class="item">
                        <select name="province" v-model="currItem.receiverProvince">
                            <option value="浙江省">浙江省</option>
                            <option value="山东省">山东省</option>
                            <option value="重庆市">重庆市</option>
                        </select>
                        <select name="city" v-model="currItem.receiverCity">
                            <option value="宁波市">宁波市</option>
                            <option value="青岛市">青岛市</option>
                            <option value="重庆市">重庆市</option>
                        </select>
                        <select name="district" v-model="currItem.receiverDistrict">
                            <option value="鄞州区">鄞州区</option>
                            <option value="海曙区">海曙区</option>
                            <option value="崂山区">崂山区</option>
                            <option value="李沧区">李沧区</option>
                            <option value="沙坪坝区">沙坪坝区</option>
                            <option value="九龙坡区">九龙坡区</option>
                        </select>
                    </div>
                    <div class="item">
                        <textarea name="street" v-model="currItem.receiverAddress"></textarea>
                    </div>
                    <div class="item">
                        <input type="text" class="input" placeholder="邮编" v-model="currItem.receiverZip">
                    </div>
                </div>
            </template>
        </modal>
    </div>
</template>
<script>
    import Modal from './../components/Modal';
    import OrderHeader from "../components/OrderHeader";

    export default {
        name: 'order',
        components: {
            Modal,
            OrderHeader
        },
        data() {
            return {
                shippingList: [],
                selectedCartList: [],
                totalPrice: 0,
                productNum: 0,
                currItem: {},
                userAction: '',//用户行为：1-添加 2-删除 3-更新,
                showDelModal: false,
                showEditModal: false,
                checkIndex: 0
            }
        },
        mounted() {
            this.getShippingList();
            this.getSelectedCartList();
        },
        methods: {
            getShippingList() {
                this.axios.get('/shippings').then((res) => {
                    this.shippingList = res.list;
                });
            },
            getSelectedCartList() {
                this.axios.get('/carts').then((res) => {
                    let list = res.cartProductVoList;
                    this.totalPrice = res.cartTotalPrice;
                    this.selectedCartList = list.filter(item => item.productSelected);
                    this.selectedCartList.map(item => {
                        this.productNum += item.quantity;
                    });
                });
            },
            delShipping(item) {
                this.currItem = item;
                this.userAction = 2;
                this.showDelModal = true;
            },
            submitShipping() {
                let item = this.currItem;
                let action = this.userAction;
                let method, url;
                let params = {};

                if (action == 1) {
                    method = 'post';
                    url = '/shippings';
                } else if (action == 2) {
                    method = 'delete';
                    url = `/shippings/${item.id}`;
                } else if (action == 3) {
                    method = 'put';
                    url = `/shippings/${item.id}`;
                }
                //删除或更新地址
                if (action == 1 || action == 3) {
                    let {
                        receiverName, receiverMobile, receiverProvince,
                        receiverCity, receiverDistrict, receiverAddress, receiverZip
                    } = item;
                    let errorMsg;
                    if (!receiverName) {
                        errorMsg = "收件人为空！";
                    } else if (!receiverMobile || !/^1([34578])\d{9}$/.test(receiverMobile)) {
                        errorMsg = "手机号码格式有误！";
                    } else if (!receiverProvince) {
                        errorMsg = "省份为空！";
                    } else if (!receiverCity) {
                        errorMsg = "城市为空！";
                    } else if (!receiverDistrict) {
                        errorMsg = "地区为空！";
                    } else if (!receiverAddress) {
                        errorMsg = "收货地址为空！";
                    } else if (!/^[0-9]{6}$/.test(receiverZip)) {
                        errorMsg = "请填写有效邮编！";
                    }
                    if (errorMsg) {
                        this.$message.error(errorMsg);
                        return;
                    }
                    params = {
                        receiverName,
                        receiverMobile,
                        receiverProvince,
                        receiverCity,
                        receiverDistrict,
                        receiverAddress,
                        receiverZip
                    }
                }
                this.axios[method](url, params).then(() => {
                    this.closeModal();
                    this.getShippingList();
                    this.$message.success("操作成功！");
                });
            },
            openShippingModal() {
                this.currItem = {};
                this.userAction = 1;
                this.showEditModal = true;
            },
            updateShippingModal(item) {
                this.currItem = item;
                this.userAction = 3;
                this.showEditModal = true;
            },
            closeModal() {
                this.currItem = {};
                this.userAction = '';
                this.showDelModal = false;
                this.showEditModal = false;
            },
            orderSubmit() {
                let shipping = this.shippingList[this.checkIndex];
                if (!shipping) {
                    this.$message.error("没有地址就送到火星咯！");
                    return;
                }
                this.axios.post("/orders", {
                    shippingId: shipping.id
                }).then((res)=>{
                    this.$router.push({
                        path: '/order/payment',
                        query: {
                            orderNo: res.orderNo
                        }
                    })
                });
            }
        }
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config.scss";

    .order-confirm {
        .wrapper {
            background-color: #f6f9fa;
            padding-top: 30px;
            padding-bottom: 84px;

            .order-box {
                background-color: #ffffff;
                padding-left: 40px;
                padding-bottom: 40px;

                .addr-title {
                    font-size: 20px;
                    color: #333333;
                    font-weight: 200;
                    margin-bottom: 21px;
                }

                .item-address {
                    padding-top: 38px;

                    .addr-list {
                        .addr-info, .addr-add {
                            box-sizing: border-box;
                            float: left;
                            width: 271px;
                            height: 180px;
                            border: 1px solid #E5E5E5;
                            margin-right: 15px;
                            padding: 15px 24px;
                            font-size: 14px;
                            color: #757575;
                        }

                        .addr-info {
                            cursor: pointer;

                            h2 {
                                height: 27px;
                                font-size: 18px;
                                font-weight: 300;
                                color: #333;
                                margin-bottom: 10px;
                            }

                            .street {
                                height: 50px;
                            }

                            .action {
                                height: 50px;
                                line-height: 50px;

                                .icon {
                                    width: 20px;
                                    height: 20px;
                                    fill: #666666;
                                    vertical-align: middle;

                                    &:hover {
                                        fill: $colorA;
                                    }
                                }
                            }

                            &.checked {
                                border: 2px solid $colorA;
                            }
                        }

                        .addr-add {
                            text-align: center;
                            color: #999999;
                            cursor: pointer;

                            .icon-add {
                                width: 30px;
                                height: 30px;
                                border-radius: 50%;
                                background: url('/imgs/icon-add.png') #E0E0E0 no-repeat center;
                                background-size: 14px;
                                margin: 45px auto 10px;
                            }
                        }
                    }
                }

                .item-good {
                    margin-top: 34px;
                    border-bottom: 1px solid #E5E5E5;
                    padding-bottom: 12px;

                    h2 {
                        border-bottom: 1px solid #E5E5E5;
                        padding-bottom: 5px;
                        font-size: 20px;
                    }

                    li {
                        display: flex;
                        align-items: center;
                        height: 120px;
                        line-height: 120px;
                        margin-top: 10px;
                        font-size: 16px;
                        color: $colorB;

                        .good-name {
                            flex: 5;

                            img {
                                width: 100px;
                                height: 83px;
                                vertical-align: middle;
                            }

                            span {
                                margin-left: 20px;
                            }
                        }

                        .good-price {
                            flex: 2;
                        }

                        .good-total {
                            padding-right: 44px;
                            color: $colorA;
                        }
                    }
                }

                .item-shipping, .item-invoice {
                    margin-top: 31px;
                    line-height: 20px;

                    h2 {
                        display: inline-block;
                        margin-right: 66px;
                        font-size: 20px;
                        width: 80px;
                    }

                    span, a {
                        font-size: 16px;
                        color: $colorA;
                        margin-right: 23px;
                    }
                }

                .detail {
                    padding: 50px 44px 33px 0;
                    border-bottom: 1px solid #f5f5f5;
                    text-align: right;
                    font-size: 16px;
                    color: #666666;

                    .item-val {
                        color: $colorA;
                    }

                    .item {
                        line-height: 15px;
                        margin-bottom: 12px;
                    }

                    .item-val {
                        display: inline-block;
                        width: 100px;
                    }

                    .item-total {
                        font-weight: bold;

                        .item-val {
                            font-size: 24px;
                        }
                    }

                }

                .btn-group {
                    margin-top: 37px;
                    text-align: right;
                }
            }
        }

        .edit-wrap {
            font-size: 14px;

            .item {
                margin-bottom: 15px;

                .input {
                    display: inline-block;
                    width: 283px;
                    height: 40px;
                    line-height: 40px;
                    padding-left: 15px;
                    border: 1px solid #E5E5E5;

                    & + .input {
                        margin-left: 14px;
                    }
                }

                select {
                    height: 40px;
                    line-height: 40px;
                    border: 1px solid #E5E5E5;
                    margin-right: 15px;
                }

                textarea {
                    height: 62px;
                    width: 100%;
                    padding: 13px 15px;
                    box-sizing: border-box;
                    border: 1px solid #E5E5E5;
                }
            }
        }
    }
</style>