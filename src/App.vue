<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: 'App',
        components: {},
        data() {
            return {
            }
        },
        mounted() {
            this.getUser();
            this.getCartCount();
        },
        methods:{
            getUser() {
                this.axios.get('/user/profile').then((user)=>{
                    this.$store.dispatch('saveUsername', user.username);
                });
            },
            getCartCount() {
                this.axios.get('/carts/products/sum').then((count)=>{
                    this.$store.dispatch('saveCartCount', count);
                });
            }
        }
    }
</script>

<style lang="scss">
    @import "./assets/scss/reset.scss";
    @import './assets/scss/config.scss';
    @import './assets/scss/button.scss';
</style>
