<template>
    <transition name="slide">
        <div class="modal" v-show="showModal">
            <div class="mask"></div>
            <div class="model-dialog">
                <div class="modal-header">
                    <span>{{title}}</span>
                    <a href="javascript:;" class="icon-close" v-on:click="$emit('cancel')"></a>
                </div>
                <div class="modal-body">
                    <slot name="body"></slot>
                </div>
                <div class="modal-footer">
                    <a href="javascript:;" class="btn" v-if="btnType==1" v-on:click="$emit('submit')">{{confirmText}}</a>
                    <a href="javascript:;" class="btn" v-if="btnType==2" v-on:click="$emit('cancel')">{{cancelText}}</a>
                    <div class="btn-group" v-if="btnType==3">
                        <a href="javascript:;" class="btn" v-on:click="$emit('submit')">{{confirmText}}</a>
                        <a href="javascript:;" class="btn" v-on:click="$emit('cancel')">{{cancelText}}</a>
                    </div>
                </div>
            </div>
        </div>
    </transition>
</template>
<script>
    export default {
        name: 'modal',
        props: {
            //设定弹框类型
            modalType: {
                type: String,
                default: 'form'
            },
            //设定弹框标题
            title: String,
            //设定按钮：1.确定，2.取消，3.确认&取消
            btnType: String,
            confirmText: {
                type: String,
                default: '确定'
            },
            cancelText: {
                type: String,
                default: '取消'
            },
            showModal: Boolean
        }
    }
</script>
<style lang="scss">
    @import './../assets/scss/config.scss';
    @import './../assets/scss/mixin.scss';
    @import './../assets/scss/modal.scss';
</style>