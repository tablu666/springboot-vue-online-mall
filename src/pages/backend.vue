<template>
    <div>
        <order-header title="后台管理">
            <template v-slot:tip>
                <span>太阳每天都是新的！</span>
            </template>
        </order-header>
        <router-view></router-view>
        <service-bar></service-bar>
        <nav-footer></nav-footer>
    </div>
</template>
<script>
    import NavFooter from "../components/NavFooter";
    import ServiceBar from "../components/ServiceBar";
    import OrderHeader from "../components/OrderHeader";

    export default {
        name: 'backend',
        components: {
            OrderHeader,
            NavFooter,
            ServiceBar
        }
    }
</script>