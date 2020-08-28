import Vue from 'vue'
import Router from './router'
import axios from 'axios'
import VueAxios from "vue-axios";
import App from './App.vue'
// import env from './env'

const mock = true;
if (mock) {
    require('./mock/api');
}

// axios.defaults.baseURL = env.baseURL;
axios.defaults.baseURL = '/api';
axios.defaults.timeout = 8000;

//接口错误拦截
axios.interceptors.response.use(function (response) {
    let res = response.data;
    if (res.status === 0) {
        return res.data;
    } else if (res.status === 10) {
        window.location.href = '/#/login';
    } else {
        alert(res.msg);
    }
});

Vue.use(VueAxios, axios);
Vue.config.productionTip = false;

new Vue({
    router: Router,
    render: h => h(App),
}).$mount('#app');
