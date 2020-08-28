<template>
    <div class="service">
        <div class="container">
            <ul>
                <li><span class="icon-amusement"></span>本站商品纯属娱乐</li>
                <li><span class="icon-deliver"></span>下单后100年发货</li>
                <li><span class="icon-postage"></span>满99万包邮到火星</li>
                <li><span class="icon-star"></span>star的你真好看！</li>
            </ul>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'service-bar'
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config.scss";
    @import "./../assets/scss/mixin.scss";

    .service {
        padding: 33px 0;
        color: $colorC;
        font-size: 16px;

        li {
            display: inline-block;
            width: 24.9%;
            text-align: center;
            border-right: 1px solid $colorH;

            span {
                display: inline-block;
                width: 20px;
                height: 20px;
                vertical-align: middle;
                margin-right: 8px;
            }

            .icon-amusement {
                @include backgroundImage(20px, 20px, '/imgs/icon-amusement.png');
            }
            .icon-deliver {
                @include backgroundImage(20px, 20px, '/imgs/icon-deliver.png');
            }
            .icon-postage {
                @include backgroundImage(20px, 20px, '/imgs/icon-postage.png');
            }
            .icon-star {
                @include backgroundImage(20px, 20px, '/imgs/icon-star.png');
            }
        }
    }
</style>