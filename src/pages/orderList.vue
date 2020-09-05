<template>
    <div class="order-list">
        <order-header title="我的订单">
            <template v-slot:tip>
                <span>东西太少了，再去买点吧！</span>
            </template>
        </order-header>
    </div>
</template>
<script>
    import OrderHeader from "../components/OrderHeader";

    export default {
        name: 'order-list',
        components: {
            OrderHeader
        }
    }
</script>