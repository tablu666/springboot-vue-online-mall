<template>
    <div>
        <order-header title="我的购物车">
            <template v-slot:tip>
                <span>温馨提示：虚构产品，下单即表示收货</span>
            </template>
        </order-header>
        <nav-footer></nav-footer>
    </div>
</template>
<script>
    import OrderHeader from "../components/OrderHeader";
    import NavFooter from "../components/NavFooter";

    export default {
        name: 'cart',
        components: {
            OrderHeader,
            NavFooter
        }
    }
</script>