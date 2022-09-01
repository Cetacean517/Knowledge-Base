##  数据类型
### 数据类型概述
- typeof() 方法可以判断一个变量的类型(number, string, boolean, funciton, object) 
- 数组的本质是object
- isinstanceof() 方法可以区别数组和对象
- null 也是 Object
### undefined, null, boolean
#### undefined VS null
- `null`是一个表示“空”的对象，转为数值时为`0`；`undefined`是一个表示"此处无定义"的原始值，转为数值时为`NaN`。
- null表示空值，即该处的值现在为空。调用函数时，某个参数未设置任何值，这时就可以传入null，表示该参数为空。
- undefined表示“未定义”

#### boolean
- **空数组（[]）和空对象（{}）对应的布尔值，都是true**
### 数值
#### 概述
- js 底层没有整数类型，都用64位浮点数存储。`1 === 1.0`
- 小数计算可能会有误，精度影响。
- 精度范围：$-2^{53} ~ 2^{53}$ （即可以精确表示15位十进制数）
- 数值范围：$2^{-1023} ~ 2^{1024}$
- 最大值：Number.MAX_VALUE
- 最小值：Number.MIN_VALUE
#### 4 特殊的值
- 正负零通常相等，**在做分母时不相同**。
- **NaN 属于number类型**。
#### 5 与数值相关的全局方法
`parseInt()`
- 字符串转换成Int类型
- 返回值：十进制整数 / NaN
- 支持（2-36）的进制转换

`parseFloat()`
`isNaN()`
`isFinite()`
### 字符串
- 支持数组下标访问；越界后，显示`undefined`；
- 不支持下标修改
- `length` 为固有属性，但是受到语言历史影响，可能部分会默认长度2
- `Base64`转码：`btoa()`方法 和`atob()`方法
> 用于输出不可以打印字符串，变为可打印字符串。
### 对象

## 运算符
### 严格相等运算符

- 数值：同类型 同值（进制表示方式可以不同） 才相等；
- 对象，数组，函数 进行地址比较
- **任何值都和NaN不相等！！** `NaN === NaN // false`
- `undefined` 和 `null` 与自身严格相等。 两个未初始化变量也相等（都为`undefined`)