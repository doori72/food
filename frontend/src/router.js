
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"
import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"
import ReviewManager from "./components/listers/ReviewCards"
import ReviewDetail from "./components/listers/ReviewDetail"

import FoodCookingManager from "./components/listers/FoodCookingCards"
import FoodCookingDetail from "./components/listers/FoodCookingDetail"

import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"

import NoticeManager from "./components/listers/NoticeCards"
import NoticeDetail from "./components/listers/NoticeDetail"

import CustomerManager from "./components/listers/CustomerCards"
import CustomerDetail from "./components/listers/CustomerDetail"

import MypageView from "./components/MypageView"
import MypageViewDetail from "./components/MypageViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },
            {
                path: '/reviews',
                name: 'ReviewManager',
                component: ReviewManager
            },
            {
                path: '/reviews/:id',
                name: 'ReviewDetail',
                component: ReviewDetail
            },

            {
                path: '/foodCookings',
                name: 'FoodCookingManager',
                component: FoodCookingManager
            },
            {
                path: '/foodCookings/:id',
                name: 'FoodCookingDetail',
                component: FoodCookingDetail
            },

            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },

            {
                path: '/notices',
                name: 'NoticeManager',
                component: NoticeManager
            },
            {
                path: '/notices/:id',
                name: 'NoticeDetail',
                component: NoticeDetail
            },

            {
                path: '/customers',
                name: 'CustomerManager',
                component: CustomerManager
            },
            {
                path: '/customers/:id',
                name: 'CustomerDetail',
                component: CustomerDetail
            },

            {
                path: '/mypages',
                name: 'MypageView',
                component: MypageView
            },
            {
                path: '/mypages/:id',
                name: 'MypageViewDetail',
                component: MypageViewDetail
            },


    ]
})
