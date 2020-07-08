// 配置路由相关信息
import VueRouter from 'vue-router'
import Vue from 'vue'
import About from "../components/About";
import Home from "../components/Home";


// 1. 通过vue.use(插件)，安装插件
Vue.use(VueRouter)

// 2. 创建VueRouter对象
const routes = [
  {
    path:'',
    redirect:'/home'
  },
  {
    path:'/home',
    component:Home
  },{
    path:'/about',
    component:About
  }
]

const router = new VueRouter({
  // 配置路由和组件之间的关系
  routes
})


// 3.将router对象传入到vue实例中
export default router
