<template>
    <div>
        <order-header></order-header>
        <router-view></router-view>
        <nav-footer></nav-footer>
    </div>
</template>
<script>
    import OrderHeader from './../components/OrderHeader'
    import NavFooter from "../components/NavFooter";

    export default {
        name: 'order',
        components: {
            NavFooter,
            OrderHeader
        }
    }
</script>