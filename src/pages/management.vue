<template>
    <div class="management">
        <div class="container">
            <div class="ads-box">
                <a href="javascript:;" @click="showModal=true">
                    <p>订单管理</p>
                    <img v-lazy="'/imgs/oms/oms-order.png'" alt="">
                </a>
                <a v-bind:href="'/#/seller'">
                    <p>权限管理</p>
                    <img v-lazy="'/imgs/oms/oms-role.jpg'" alt="">
                </a>
                <a v-bind:href="'/#/seller'">
                    <p>商品管理</p>
                    <img v-lazy="'/imgs/oms/oms-product.jpg'" alt="">
                </a>
                <a v-bind:href="'/#/seller'">
                    <p>用户管理</p>
                    <img v-lazy="'/imgs/oms/oms-user.jpg'" alt="">
                </a>
            </div>
        </div>
        <modal title="系统提示"
               btn-type="1"
               :show-modal="showModal"
               confirmText="去订单列表"
               @cancel="showModal=false"
               @submit="goToOrderManagement">
            <template v-slot:body><p>查看本站所有订单数据？</p></template>
        </modal>
    </div>
</template>
<script>
    import Modal from "../components/Modal";

    export default {
        name: 'management',
        components: {
            Modal
        },
        data() {
            return {
                showModal: false,
            }
        },
        methods: {
            goToOrderManagement() {
                let username = this.$store.state.username;
                if (username !== 'employee' && username !== 'management') {
                    this.$message.warning("Sorry 仅限本站员工查看哦！");
                    return;
                }
                this.$router.push('/seller');
            }
        }
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config.scss";
    @import "./../assets/scss/mixin.scss";

    .management {
        margin-bottom: 120px;

        .container {
            .ads-box {
                @include flex();
                margin-top: 40px;

                a {
                    width: 296px;
                    height: 167px;
                    text-align: center;

                    p {
                        font-size: 18px;
                        font-weight: bold;
                        color: $colorA;
                        margin-bottom: 20px;
                    }

                    img {
                        width: 100%;
                        height: 100%;
                    }
                }
            }
        }
    }

</style>