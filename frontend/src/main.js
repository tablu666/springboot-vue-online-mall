import Vue from 'vue'
import Router from './router'
import axios from 'axios'
import VueAxios from "vue-axios";
import VueLazyload from "vue-lazyload";
import VueCookie from 'vue-cookie';
import {Message} from "element-ui";
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
import App from './App.vue'

// const mock = true;
// if (mock) {
//     require('./mock/api');
// }

axios.defaults.baseURL = '/api';
axios.defaults.timeout = 8000;

//接口错误拦截
axios.interceptors.response.use(function (response) {
    let res = response.data;
    let path = location.hash;
    if (res.status === 0) {
        return res.data;
    } else if (res.status === 10) {
        if (path !== '#/index'
            && !path.startsWith('#/product')
            && !path.startsWith('#/detail')
            && !path.startsWith('#/category')) {
            window.location.href = '/#/login'
        }
        return Promise.reject(res);
    } else {
        Message.warning(res.msg);
        return Promise.reject(res);
    }
}, (error) => {
    let res = error.response;
    Message.error(res.data.message);
    return Promise.reject(error);
});

Vue.use(VueAxios, axios);
Vue.use(VueCookie);
Vue.use(VueLazyload, {
    loading: '/imgs/loading-svg/loading.svg'
});
Vue.component(Message.name, Message);
Vue.prototype.$message = Message;
Vue.config.productionTip = false;

new Vue({
    store: store,
    router: Router,
    render: h => h(App),
}).$mount('#app');
