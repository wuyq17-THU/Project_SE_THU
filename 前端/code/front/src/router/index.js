import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import First from '../views/First.vue'
import OrderT from '../views/OrderT.vue'
import OrderB from '../views/OrderB.vue'

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
    path: '/',
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
]

const router = new VueRouter({
  routes
})

export default router
