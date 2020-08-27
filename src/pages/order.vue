<template>
    <div>
        <nav-header></nav-header>
        <router-view></router-view>
        <nav-footer></nav-footer>
    </div>
</template>
<script>
    import NavFooter from "../components/NavFooter";
    export default {
        name:'nav-header',
        components: {NavFooter}
    }
</script>