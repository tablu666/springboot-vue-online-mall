<template>
    <div class="order-header">
        <div class="container clearFix">
            <div class="top-banner-logo">
                <a href="/#/index"></a>
            </div>
            <div class="title">
                <h2>{{title}}
                    <slot name="tip"></slot>
                </h2>
            </div>
            <div class="username">
                <a href="javascript:;">{{username}}</a>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'order-header',
        props: {
            title: String
        },
        computed: {
            username() {
                return this.$store.state.username;
            }
        }
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config";

    .order-header {
        padding: 30px 0;
        border-bottom: 2px solid $colorA;

        .top-banner-logo {
            float: left;
        }

        .title, .username {
            display: inline-block;
            height: 55px;
            line-height: 55px;
            margin-left: 54px;
        }

        .title {
            float: left;
            margin-left: 54px;

            h2 {
                font-size: 28px;
                color: $colorB;
            }

            span {
                font-size: 14px;
                margin-left: 17px;
                color: #999999;
                font-weight: 200;
            }
        }

        .username {
            float: right;

            a {
                color: #666666;
                font-size: 16px;
            }
        }
    }
</style>