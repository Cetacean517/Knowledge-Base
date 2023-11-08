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



### 2.2. 几个注意事项

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



## 4. 路由的query参数

1. 传递参数

```vue
<!-- 跳转并携带query参数，to的字符串写法 -->
<router-link :to="`/home/message/detail?id=${m.id}&title=${m.title}`">{{ m.title }}</router-link>

<!-- 跳转并携带query参数，to的对象写法 -->
<router-link :to="{
    path:'/home/message/detail',
    query:{
        id: m.id,
        title: m.title
    }
}">
      {{ m.title }}
</router-link>
```

2. 接收参数

```vue
$route.query.id
$route.query.title
```



## 5. 命名路由

1. 作用：简化路由的跳转。

2. 如何使用

   1. 给路由命名。

   ```json
   {
     path:'/demo',
     component: Demo,
     children: [
       {
         path: 'test',
         component: Test,
         children: [
           {
             name: 'hello'		//给路由命名
             path: 'welcome',
             component: Hello,
           }
         ]
       }
     ]
   }
   ```

   2. 简化跳转

   ```vue
   <!-- 简化前，需要写完整的路径 -->
   <router-link to="/demo/test/welcome">跳转</router-link>
   
   <!-- 简化后，直接通过名字跳转 -->
   <router-link to="{name:'hello'}">跳转</router-link>
   
   <!-- 简化写法配合传递参数 -->
   <router-link
          :to="{
               name:'hello',
               query:{
               		id: 666,
               		title: '你好'
               	}
               }"
   >跳转</router-link>
   ```

   

   ## 6.路由的Params参数

   1. 配置路由，声明接受params参数

   ```json
   {
       path:'/home',
       component:Home,
       children: [
           {
               path: 'news',
               component: News
           },
           {
               path:'message',
               component: Message,
               children:[
                   {
                       name:'DetailName',
                       path:'detail/:id/:title',//使用占位符声明接受params参数
                       component: Detail
                   }
               ]
           }
         ]
   }
   }
   ```

   2. 传递参数

   ```vue
   <!-- 跳转并携带params参数，to的字符串写法 -->
   <router-link :to="/home/message/${m.id}/${m.title}/你好">跳转</router-link>
   
   <!-- 跳转并携带params参数，to的对象写法 -->
   <router-link
                :to="{
                     name:'DetailName',		// path配置项不可用
                     params:{
                     	id:m.id,
                     	title:m.title
                     }
                     }"
                >跳转</router-link>
   ```

   > ⚠️特别注意：路由携带params参数时，若使用to的对象写法，则不能使用path配置项，必须使用name配置！！

3. 接收参数

   ```js
   $route.query.id
   $route.query.title
   ```



## 7. 路由的props参数

1. 作用：让路由组件更方便的收到参数

2. router.js配置内容

   1. 第一种写法：props值为对象，改对象中所有的key-value的组合最终都会通过props传给Detail组件

      ```js
      {
        name:'DetailName',
        path:'detail',
        component: Detail,
        
        // 第一种写法：props值为对象，改对象中所有的key-value的组合最终都会通过props传给Detail组件
        props:{a:900}
      }
      ```

   2. 第二种写法：props值为布尔值，布尔值为true，则把路由收到的所有params参数通过props传给Detail组件

      ```js
      {
        name:'DetailName',
        path:'detail/:id',
        component: Detail,
        
        // 第二种写法：props值为布尔值，布尔值为true，则把路由收到的所有params参数通过props传给Detail组件
        props:true
      }
      ```

   3. 第三种写法：props值为函数，该函数返回的对象中每一组key-value都会通过props传给Detail组件。

      ```js
      {
        name:'DetailName',
        path:'detail',
        component: Detail,
        
        // 第三种写法：props值为函数，该函数返回的对象中每一组key-value都会通过props传给Detail组件
        props($route){
          return {
          	id:route.query.id,
          	title:route.query.title
        	}
        }
      }
      ```

      

3. 接收参数

   ```vue
   <template>
   	<ul>
       <li>ID: {{id}}</li>
       <li>TITLE: {{title}}</li>
     </ul>
   </template>
   
   <script>
   	export default{
       props:['id','title']
     }
   </script>
   ```




## 8.`<ROUTER-LINK>`的replace属性

1. 作用：控制路由跳转时操作浏览器历史记录的模式。

2. 浏览器的历史记录有两种写入方式：分别是`push`和`replace`。

   - `push`：追加历史记录。

   - `replace`：替换**当前**记录。(即栈顶记录，路由回退的过程类似出入栈。)

   路由跳转时候默认为`push`。

3. 如何开启`replace`模式：`<router-link replace ... ...>News</router-link>`



## 9. 编程式路由导航

1. 作用：不借助`<router-link>`实现路由跳转，让路由跳转更加灵活。

2. 具体编码

```js
// $router的两个API
this.$router.push({
	name: 'Detail',
  params:{
    id:m.id,
    title:m.title
  }
})

this.$router.replace({
	name: 'Detail',
  params:{
    id:m.id,
    title:m.title
  }
})

// 前进
this.$router.forward()

// 后退
this.$router.back()

// 前进or后退，前进用x, 后退用-x,
this.$router.go()
```

<<<<<<< HEAD


=======
>>>>>>> 0c19d0a5c71ad8b16a3636e6d0cf1924357cdc67
## 10.缓存路由组件

1. 作用：让不展示的路由组件保持挂载，不被销毁。
2. 具体编码
   - 在内容的展示区包裹keep-alive组件。
   - 不加include默认所有内容，增加之后指定组件名。

```vue
<!-- 缓存一个路由组件 -->
<keep-alive include="News">
	<router-view></router-view>
</keep-alive>

<!-- 缓存多个路由组件 -->
<<<<<<< HEAD
<keep-alive include="['News','Message']">
	<router-view></router-view>
</keep-alive>
=======
<keep-alive :include="['News','Message']"></keep-alive>
>>>>>>> 0c19d0a5c71ad8b16a3636e6d0cf1924357cdc67
```



## 11. 两个新的生命周期钩子
<<<<<<< HEAD

1. 作用：路由组件独有的两个钩子，用于捕获路由组件的激活状态。
2. 具体名字
   1. activated 	路由组件被激活时触发
   2. deactivated    路由组件失活时触发

```vue
activated(){
	// ...
}
deactivated(){
	// ...
}
```



## 12. 路由守卫

1. 作用：对路由进行权限控制。
2. 分类：全局守卫，独享守卫，组件内守卫

### 12.1 全局守卫

#### a. 前置路由守卫

案例1：判断localStorage里面school =atguigu, 才显示News 和Messages的内容。

```js
//router.js
// 全局前置路由守卫 --- 初始化的时候被调用、每次路由切换之前被调用
router.beforeEach((to, from, next)=>{
  // console.log(to,from)
  if(to.path === '/home/news' || to.path === '/home/message'){ //权限控制规则
    if(localStorage.getItem('school' === 'atguigu')){
      next()
    }else{
      alert('name error, don not have auth to check it.')
    }
  }else{
    next()
  }
})

export default router
```

#### b. meta配置项

案例2：优化多个权限校验，使用meta配置项，添加元数据。

 ```js
 //router.js
 const router = new VueRouter({
   routes:[
 		// ...
     {
       name:'zhuye',
       path:'/home',
       component:Home,
       meta: {isAuth: true}
     }
   ]
 })
 
 router.beforeEach((to, from, next)=>{
   if(to.meta.isAuth){	//判断是否需要鉴权
     if(localStorage.getItem('school' === 'atguigu')){	//权限控制规则
       next() //放行
     }else{
       alert('name error, don not have auth to check it.')
     }
   }else{
     next() //放行
   }
 })
 
 export default router
 ```

#### c. 后置路由守卫

案例：进入新页面后，替换页签的名字，内容是meta.title.

```js
//router.js
const router = new VueRouter({
  routes:[
    {
      name:'guanyu',
      path:'/about',
      component:About,
      meta:{title:'about'}	//配置title
    },
    {
      name:'zhuye',
      path:'/home',
      component:Home,
      meta: {isAuth: true, title:'home'}
    },
    //...
  ]
})

// 全局后置路由守卫 --- 初始化的时候被调用、每次路由切换之后被调用
router.afterEach((to, from)=>{
  if(to.meta.title){
      document.title = to.meta.title 	//修改放夜title
  }else{
    document.title = 'vue_test'
  }
})
```
