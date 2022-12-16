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

