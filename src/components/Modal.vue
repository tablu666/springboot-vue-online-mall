<template>
    <div class="modal" v-show="showModal">
        <div class="mask"></div>
        <div class="model-dialog">
            <div class="modal-header">
                <span>标题</span>
                <a href="javascript:;" class="icon-close"></a>
            </div>
            <div class="modal-body">
                <slot name="body"></slot>
            </div>
            <div class="modal-footer">
                <a href="javascript:;" class="btn">确定</a>
                <a href="javascript:;" class="btn">取消</a>
            </div>
        </div>
    </div>
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
            //设定按钮：1.确定，2.取消，3.确认取消
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