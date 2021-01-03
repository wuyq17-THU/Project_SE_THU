import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import First from '../views/First.vue'
import OrderT from '../views/OrderT.vue'
import OrderB from '../views/OrderB.vue'
import Test from '../views/test.vue'
import login from '../views/login.vue'
import confirm from '../views/Confirm.vue'
import personal from '../views/Personal.vue'
import manage from '../views/Manage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/first',
    name: 'First',
    component: First
  },
  {
    path: '/ordert',
    name: 'OrderT',
    component: OrderT
  },
  {
    path: '/orderb',
    name: 'Orderb',
    component: OrderB
  },
  {
    path: '/test',
    name: 'test',
    component: Test
  },
  {
    path: '/',
    name: 'login',
    component: login
  },
  {
    path: '/confirm',
    name: 'confirm',
    component: confirm
  },
  {
    path: '/personal',
    name: 'personal',
    component: personal
  },
  {
    path: '/manage',
    name: 'manage',
    component: manage
  },
]

const router = new VueRouter({
  routes
})

export default router
