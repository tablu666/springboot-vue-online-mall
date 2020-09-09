<template>
    <div class="user">
        <div class="wrapper">
            <div class="container">
                <div class="user-box">
                    <loading v-if="loading"></loading>
                    <div class="user" v-for="(user,index) in userList" v-bind:key="index">
                        <div class="user-title">
                            <div class="item-info float-l">
                                <span>id:</span>{{user.id}}
                                <span>|</span>
                                <span>用户名：</span>{{user.username}}
                                <span>|</span>
                                <span>邮箱：</span>{{user.email}}
                            </div>
                            <div class="item-time float-r">
                                <span>创建时间：</span>{{UTCDateToLocalDate(user.createTime)}}
                            </div>
                        </div>
                        <div class="user-content clearFix">
                            <div class="role-box float-l">
                                <div class="role-list" v-for="(role, i) in user.roleList" v-bind:key="i">
                                    <div class="role-img">
                                        <img v-lazy="'/imgs/oms/role-rick.jpg'" v-if="index%2===0" alt="">
                                        <img v-lazy="'/imgs/oms/role-morty.jpeg'" v-if="index%2!==0" alt="">
                                    </div>
                                    <div class="role-name">
                                        <div class="r-name">{{role.roleName}}</div>
                                        <div class="r-desc">{{role.roleDesc}}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <no-data v-if="!loading && userList.length == 0">
                        <template slot="tips">
                            <p>{{msg}}</p>
                        </template>
                    </no-data>
                </div>
                <div class="statistics float-r">
                    <p>用户数量：{{userList.length}}</p>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import Loading from "./../components/Loading";
    import NoData from "./../components/NoData";

    export default {
        name: 'user',
        components: {
            Loading,
            NoData
        }, data() {
            return {
                userList: [],
                loading: true,
                msg: ''
            }
        },
        mounted() {
            this.getUserList();
        },
        methods: {
            getUserList() {
                this.axios.get('/management/users').then((res) => {
                    this.loading = false;
                    this.userList = res;
                }).catch((res) => {
                    this.loading = false;
                    this.msg = res.msg;
                });
            },
            /**
             * @return {string}
             */
            UTCDateToLocalDate(dateStr) {
                return new Date(dateStr).toISOString().replace(/T/g, " ").replace(/\.[\d]{3}Z/, "");
            }
        }
    }
</script>
<style lang="scss">
    @import './../assets/scss/config.scss';
    @import './../assets/scss/mixin.scss';
    @import "./../assets/scss/element-variables.scss";

    .user {
        .wrapper {
            background-color: #f6f9fa;
            padding-top: 33px;
            padding-bottom: 110px;

            .user-box {
                .user {
                    @include border();
                    background-color: $colorG;
                    margin-bottom: 31px;

                    &:last-child {
                        margin-bottom: 0;
                    }

                    .user-title {
                        @include height(74px);
                        background-color: #ffffff;
                        padding: 0 43px;
                        font-size: 14px;
                        color: $colorB;

                        .item-info {
                            span {
                                margin: 0 9px;
                            }
                        }

                        .item-time {
                            span {
                                font-weight: bold;
                            }
                        }
                    }

                    .user-content {
                        padding: 0 43px;

                        .role-box {
                            width: 88%;

                            .role-list {
                                display: flex;
                                align-items: center;
                                height: 112px;

                                .role-img {
                                    width: 66px;

                                    img {
                                        width: 100%;
                                    }
                                }

                                .role-name {
                                    margin-left: 30px;
                                    font-size: 14px;
                                    color: $colorA;

                                    .r-name {
                                        font-weight: bold;
                                        margin-bottom: 5px;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            .statistics {
                p {
                    margin-top: 32px;
                    font-size: 16px;
                    font-weight: bold;
                    color: $colorA;
                }
            }
        }
    }
</style>