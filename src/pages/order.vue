<template>
    <div>
        <order-header :title="title">
            <template v-slot:tip>
                <span>{{tip}}</span>
            </template>
        </order-header>
        <router-view></router-view>
        <service-bar></service-bar>
        <nav-footer></nav-footer>
    </div>
</template>
<script>
    import OrderHeader from './../components/OrderHeader';
    import NavFooter from "../components/NavFooter";
    import ServiceBar from "../components/ServiceBar";

    export default {
        name: 'order',
        components: {
            NavFooter,
            OrderHeader,
            ServiceBar,
        },
        data() {
            return {
                title: '',
                tip: '',
            }
        },
        mounted() {
            let url = this.$route.path;
            if (url === '/order/confirm') {
                this.title = '订单确认';
                this.tip = '请仔细核对收货信息';
            } else if (url === '/order/list') {
                this.title = '我的订单';
            } else if (url === '/order/payment') {
                this.title = '订单支付';
                this.tip = '一经支付，概不退货';
            }
        }
    }
</script>