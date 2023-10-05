# Vue Router

## 1. 相关理解

### 1.1 Vue-router的理解

1. `Vue-router`是Vue的一个插件库，专门用于实现SPA（Single Page Web Application）应用。



### 1.2 对SPA应用的理解

1. 单页Web应用，称为SPA（Single Page Web Application）应用。
2. 整个应用==只有一个完整的页面==。
3. 点击页面中的导航链接==不会刷新==页面，只会进行页面的==局部更新==。
4. 数据需要通过ajax请求获取。



### 1.3 路由的理解

1. 什么是路由？
   - 路由（route)就是一组key-value的映射关系。
   - `key`是路径，`value`可能是函数（function）或者是组件（component）。
2. 路由分类
   - 后端路由
     - 理解：value是函数，用于处理客户端提交的请求。
     - 工作过程：服务器接收到一个请求的时候，根据请求路径找到匹配的函数来处理请求，返回相应数据。
   - 前端路由
     - 理解：value是组件，用于展示页面内容。
     - 工作过程：当浏览器的路径发生改变时，对应的组件就会显示。（图示如下）

<img src="./Notepic/Screenshot 2023-09-30 at 14.30.52.png" alt="Screenshot 2023-09-30 at 14.30.52" style="zoom: 20%;" />



## 2. [基本路由](https://github.com/Cetacean517/vue-advance/tree/master/27_src_%E8%B7%AF%E7%94%B1%E7%9A%84%E5%9F%BA%E6%9C%AC%E4%BD%BF%E7%94%A8)

### 2.1 基本路由实现

1. 安装vue-router, 命令npm i vue-router

   **⚠️注意**

   - Vue2仅支持vue-router3版本，npm i vue-router@3;
   - Vue3仅支持vue-router4版本。

2. 应用插件**==Vue.use(VueRouter)==**

```js
import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'

Vue.config.productionTip = false

Vue.use(VueRouter)		// 应用插件

new Vue({
	el:"#app",
	render:h => h(App),
	router:router
})
```

3. 编写router配置项

```js
import VueRouter from 'vue-router'			// 引入VueRouter
import About from '../components/About'	// 路由组件
import Home from '../components/Home'		// 路由组件

// 创建router实例对象，去管理一组一组的路由规则
const router = new VueRouter({
  routes:[
    {
      path:'/about',
      component:About
    },
    {
      path:'/home',
      component:Home
    }
  ]
})

//暴露router
export default router
```

4. 实现切换

<rotuer-link></router-link>浏览器会被替换成a标签active-class可以配置高粱样式。

```vue
<router-link active-class="active" to="/about">About</router-link>
```

5. 指定展示位`<router-view></router-view>`



### 2.2 几个注意事项

1. 前端组件可以分为：路由组件和一般组件

   - 路由组件：根据路由切换调用。

   - 一般组件：通过<XXXX/>标签自主调用。

2. 通过切换，“隐藏”的路由组件，默认是被销毁掉的，需要的时候再去挂载。
3. 每个组件都有自己的`route`属性，里面存储着自己的路由信息。
4. 整个应用只有一个router，可以通过组件的`router`熟悉获取到。



## 3. [嵌套（多级）路由](https://gitee.com/cetacean517/vue-advance/tree/master/28_src_%E5%A4%9A%E7%BA%A7%E8%B7%AF%E7%94%B1)

1. 配置路由规则，使用children配置项：

```js
// router.js
import About from ...
import Home from ...
import News from ...

routes:[
  {
    path:"/about",
    component:About,
  },
  {
    path:"/home",
    component:Home,
    children:[						// 通过children配置子级路由
      {
        path:'news',			// 此处一定不要写：/news
    		component:News	
      },
      {
        path:'message',		// 此处一定不要写：/message
    		component:Message	
      }
    ]
  },
]
```

2. 跳转（要写完整路径）

```vue
<router-link to="/home/news"> News <router-link>
```









