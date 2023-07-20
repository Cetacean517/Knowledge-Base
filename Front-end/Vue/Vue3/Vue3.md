# Vue3

## 组合式API

**1. 基本概念**

组合式API：*逻辑一致代码收集在一起*。

- 本质是`setup`函数，等价于Vue2中的`Created()` 和 `Beforecreated()` 钩子。
- 在组件创建之前执行，不使用this

```typescript
setup(){
    const msg = "vue3";
    console.log(msg)
}
```

**2. 在模板的使用方法**

- 接受`props`和`context`参数。
- 将setup中的内容暴露给模板

TypeScript

```js
<script>
    setup(){
        let msg = "vue3";
        function changeMsg(){
            msg="name";
            console.log(msg)
        }
        return{
            msg,
            changeMsg
        }
    }
</script>
```

Html

```html
<Html>
    <h1>{{msg}}</h1>
    <button @click="changeMsg">click</button>
</Html>
```

> 效果：
>
> 在console.log中 msg = name, 但是HTML页面中仍显示vue3.
>
> 原因：
>
> 当前数据绑定的方式，并非是响应式的。

**3. ref 响应式数据绑定**

- 利用ref()函数实现响应式数据；返回含`value`属性的对象。
- html模板会自动解析value值。

```typescript
setup(){
    let counter = ref(0);
    function changeCounter(){
        counter.value++;
    }
    return{
        counter, changeCounter
    }
}
```

```html
<Html>
    <!-- 会自动解析出counter.value -->
    <h1>{{counter}}</h1>
    <button @click="changeCounter">click</button>
</Html>
```



## PC端 窗口自适应

```cmd
npm install --save postcss-px-to-viewport
```



## 图片懒加载 --- 组件懒加载

每次加载5条数据

**思路**

判断组件是否进入到视口区域，只有进入视口区域后才发送网络请求

1. 如何判断是否进入视口区域
   - 判断距离
   - vueUse 监听 api

2. img.src = url --- 对于组件来说，再加后需要自动拉去数据。

**实现步骤**

1. 指令
2. 实现懒加载的核心逻辑

```js
//main.js 准备自定义指令
import {creatApp} from 'vue'
import App from './App.vue'

// 全局指令注册
const app = creatApp(App)
app.directive('img-lazy',{
    // 指令挂载后自动执行
    mounted(el, binding){
        // el:指令挂载到的元素 dom img
        // binding: value 指令等于后面表达式的值
        console.log(el,binding.value)
        // 图片懒加载的核心逻辑
        
    }
})

app.mount('#app')
```

