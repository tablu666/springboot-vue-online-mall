<template>
    <div class="no-data">
        <img src="/imgs/no-data.png" alt="">
        <slot name="tips"></slot>
    </div>
</template>
<script>
    export default {
        name: 'no-data'
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config.scss";

    .no-data {
        text-align: center;
        font-size: 20px;
        font-weight: bold;
        color: $colorA;
        margin: 50px 0;

        img {
            width: 210px;
            height: 210px;
        }
    }
</style>