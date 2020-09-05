import Vue from 'vue'
import Router from 'vue-router'
import Home from './pages/home'
import Login from './pages/login'
import Index from './pages/index'
import Product from './pages/product'
import Detail from './pages/detail'
import Cart from './pages/cart'
import Order from './pages/order'
import OrderConfirm from './pages/orderConfirm'
import OrderList from './pages/orderList'
import OrderPayment from './pages/orderPayment'
import Seller from './pages/seller'
import Management from './pages/management'
import Register from './pages/register'
import Category from './pages/category'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
            redirect: '/index',
            children: [
                {
                    path: '/index',
                    name: 'index',
                    component: Index
                }, {
                    path: '/product/:id',
                    name: 'product',
                    component: Product
                }, {
                    path: '/detail/:id',
                    name: 'detail',
                    component: Detail
                }, {
                    path: '/seller',
                    name: 'seller',
                    component: Seller
                }, {
                    path: '/management',
                    name: 'management',
                    component: Management
                }, {
                    path: '/category/:id',
                    name: 'category',
                    component: Category
                }
            ]
        },
        {
            path: '/login',
            name: 'login',
            component: Login,
        },
        {
            path: '/register',
            name: 'register',
            component: Register
        },
        {
            path: '/cart',
            name: 'cart',
            component: Cart
        },
        {
            path: '/order',
            name: 'order',
            component: Order,
            children: [
                {
                    path: 'list',
                    name: 'order-list',
                    component: OrderList
                }, {
                    path: 'confirm',
                    name: 'order-confirm',
                    component: OrderConfirm
                }, {
                    path: 'payment',
                    name: 'order-payment',
                    component: OrderPayment
                }
            ]
        }
    ]
});