import Vue from 'vue'
import Router from './router'
import axios from 'axios'
import VueAxios from "vue-axios";
import VueLazyload from "vue-lazyload";
import VueCookie from 'vue-cookie';
import App from './App.vue'
// import env from './env'

// const mock = true;
// if (mock) {
//     require('./mock/api');
// }

// axios.defaults.baseURL = env.baseURL;
axios.defaults.baseURL = '/api';
axios.defaults.timeout = 8000;

//接口错误拦截
axios.interceptors.response.use(function (response) {
    let res = response.data;
    if (res.status === 0) {
        return res.data;
    } else if (res.status === 10) {
        window.location.href = '/#/login'
    } else {
        alert(res.msg);
        return Promise.reject();
    }
});

Vue.use(VueAxios, axios);
Vue.use(VueCookie);
Vue.use(VueLazyload, {
    loading: '/imgs/loading-svg/loading.svg'
});
Vue.config.productionTip = false;

new Vue({
    router: Router,
    render: h => h(App),
}).$mount('#app');
