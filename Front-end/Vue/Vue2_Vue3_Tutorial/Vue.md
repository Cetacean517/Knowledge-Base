# Vue 核心

https://www.yuque.com/cessstudy/kak11d/hfeef2

## 4. [el 与 data的两种写法](https://github.com/Cetacean517/vue-learning/blob/master/04_el%E5%92%8Cdata%E7%9A%84%E4%B8%A4%E7%A7%8D%E5%86%99%E6%B3%95/el%E5%92%8Cdata%E4%B8%A4%E7%A7%8D%E5%86%99%E6%B3%95.html)

对象式

```vue
// 对象式
data:{
 	...
}
```

函数式

```vue
// 函数式
data:function(){
	return{
		name: "cc"
	}
}
===========等价的==============
data(){
	return{
		name: "cc"
	}
}
```



## 5. [MVVM 模型](https://github.com/Cetacean517/vue-learning/blob/master/05_MVVM%E6%A8%A1%E5%9E%8B/mvvm%E6%A8%A1%E5%9E%8B.html)

vue 的差插值语法中可包含的内容：Vue实例中的所有内容

<img src="./Notepic/Screenshot 2023-09-07 at 21.14.13.png" alt="Screenshot 2023-09-07 at 21.14.13" style="zoom: 33%;" />

 (包括__proto__中的所有$xxx属性)![image-20230907211551592](./Notepic/image-20230907211551592.png)

## 6.数据代理

## 7. 事件处理

### 7.1[事件的基本使用](https://github.com/Cetacean517/vue-learning/blob/master/07_%E4%BA%8B%E4%BB%B6%E5%A4%84%E7%90%86/%E4%BA%8B%E4%BB%B6%E5%A4%84%E7%90%86%E7%9A%84%E5%9F%BA%E6%9C%AC%E4%BD%BF%E7%94%A8.html)

1. 使用`v-on:xxx` 或 `@xxx` 绑定事件，其中xxx是事件名。
2. 事件的回调需要配置在methods对象中，最终会在vm上。
3. methods中配置的函数，不要使用箭头函数！否则this就不是vm了。
4. methods中配置的函数，都是被Vue所管理的函数，this的指向是vm或组件实例对象。
5. `@click="demo"` 和 `@click="demo($event)"`效果一致，但后者可以传参。



### 7.2 [事件修饰符](https://github.com/Cetacean517/vue-learning/blob/master/07_%E4%BA%8B%E4%BB%B6%E5%A4%84%E7%90%86/%E4%BA%8B%E4%BB%B6%E4%BF%AE%E9%A5%B0.html)

1. prevent: 组织默认事件【常用】。

   对于绑定了点击事件的<a>标签，可以阻止点击完默认跳转。

2. stop：阻止事件冒泡【常用】。

3. once：事件只触发一次【常用】。

4. capture：使用事件的捕获模式。

5. self：只有event.target是当前操作的元素时才触发事件。

6. passive：事件的默认行为立即执行，无需等待事件回调执行完毕。



### 7.3 [键盘事件](https://github.com/Cetacean517/vue-learning/blob/master/07_%E4%BA%8B%E4%BB%B6%E5%A4%84%E7%90%86/%E9%94%AE%E7%9B%98%E4%BA%8B%E4%BB%B6.html)





