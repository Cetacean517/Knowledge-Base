# Java Basic Tools

#### 1. Java 安装两个版本的jdk 配置

[link](https://blog.csdn.net/zc19921215/article/details/107647700#:~:text=%E9%A1%B9%E7%9B%AE%E4%B8%AD%E5%88%86%E5%88%AB%E4%BD%BF%E7%94%A8%E5%88%B0,%E8%B5%B7%E6%9D%A5%E5%B0%B1%E5%BE%88%E6%96%B9%E4%BE%BF%E4%BA%86%E3%80%82)

1 . 准备两个版本的jdk我的两个jdk路径为：

> C:\Program Files\Java\jdk1.8.0_71
>
> C:\Program Files\Java\jdk1.11.2

2 . 添加或者修改环境变量:

> **2.1 JAVA_HOME8(新增)**
>
>   C:\Program Files\Java\jdk1.8.0_71
> **2.2 JAVA_HOME11(新增)**
>
>   C:\Program Files\Java\jdk1.11.2
>
> **2.3 JAVA_HOME** **(新增)**
>
>   // 此处JAVA_HOME设置即为你更换jdk版本是所要修改的地方
>
>   %JAVA_HOME8%
>
> **2.4 CLASSPATH路径最后面增加如下内容:** 
>
>   .;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;
>
> **2.5 Path路径在\**最前面\**增加如下内容:**
>
>  %JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;
>
>  一定要在最前面增加

3 . 查看版本是否更换成功

> 新开一个CMD窗口，命令行中输入：
>
>   java -version  



# Java Knowledge (Daily)

## 1. Java 内存结构

1. 栈 Stack：
   - 存储方法的局部变量。**运行方法一定在栈中。**
   - 局部变量：方法对的参数 / 方法体内的变量。
   - 作用域：一旦超出作用域，立即从栈中消失。
2. 堆 Heap：
   - **存储new 申请得到的东西。**
   - 地址值：16进制；堆内数据均有默认值。

| 类型     | 默认值   |
| -------- | -------- |
| 整数     | 0        |
| 浮点数   | 0.0      |
| 字符     | "\u0000" |
| 布尔     | false    |
| 引用类型 | null     |

3. 方法区 Method Area：存储.class相关信息，包含方法的信息。
4. 本地方法栈 Native Method Stack：与OS相关。
5. 寄存器 pc Register：与CPU相关。



## 2. Default Initialize 默认初始化

**1. 类的成员变量的初始化：有默认值**

| 类型     | 默认值                                                       |
| -------- | ------------------------------------------------------------ |
| 整数     | 0                                                            |
| 浮点数   | 0.0                                                          |
| 字符     | "\u0000"                                                     |
| 布尔     | false                                                        |
| 引用类型 | null                                                         |
| 数组     | int[] a;                      //声明,没有初始化默认值是null<br />int[] a=new int[5];   //初始化为默认值,int型为0 |

**2. 局部变量，必须显示初始化。**

**3. 二维数组的默认初始化**

**（1）初始化方式一：int\[ ][ ]arr=new int\[6][8]**

​	外层元素的初始化值：地址值  `arr[0]`

​	内层元素的初始化值：与一维数组初始化情况相同 `arr[0][0]`

**（2）初始化方式二：**

​	外层元素的初始化值：null 

​	内层元素的初始化值：不能调用，调用报错

# Data Structure

## 1. ArrayList<E> 可变长数组

支持泛型。

$>$ JDK 1.5自动装箱：基本类型 ---> 包装类型  ; 自动拆箱: 包装类型 --> 基本类型

| 基本类型 | 包装类（引用类型，位于java.lang) |
| -------- | -------------------------------- |
| byte     | Byte                             |
| short    | Short                            |
| int      | **Integer**                      |
| long     | Long                             |
| float    | Float                            |
| double   | Double                           |
| char     | **Character**                    |
| boolean  | Boolean                          |

直接打印：输出内容

常用方法：add(),	get(),	remove() [ 返回删除内容 ],	size() [ 返回元素个数 ]

遍历集合

```java
for (int i = 0; i < list.size(); i++) {
    System.out,println(list.get(i))
}
```



## 2. 栈 Stack类

| 序号 | 方法描述                                                     |
| :--- | :----------------------------------------------------------- |
| 1    | boolean empty()  <br />测试堆栈是否为空。                    |
| 2    | Object peek( ) <br />查看堆栈顶部的对象，但不从堆栈中移除它。 |
| 3    | Object pop( ) <br />移除堆栈顶部的对象，并作为此函数的值返回该对象。 |
| 4    | Object push(Object element) <br />把项压入堆栈顶部。         |
| 5    | int search(Object element) <br />返回对象在堆栈中的位置，以 1 为基数。 |

## 3. MAP 集合

#### 常用子类

HashMap : 哈希表；存取顺序不一致

LinkedHashMap：哈希表 + 链表；存取顺序一致

Hashtable：key + value 都不能为null；单线程 (properties仍在用)

#### 常用方法

put ( key, value ) : key重复，返回新的value；key 不重复，返回空。

get ( key )：获取value；没有值，返回空。

remove (key)：删除value

contiansKey(key)：判断键值是否存在，返回boolean.

keySet()：遍历

entrySet()：遍历

#### 遍历Map类型

1. KeySet方法：

迭代器方法

```java
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("aa",11);
        map.put("bb",22);
        map.put("cc",33);

        // 1. 获取key集合
        Set<String> keySet = map.keySet();
        // 2. 遍历集合获取值
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            Integer value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
```

增强for循环

```java
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("aa",11);
        map.put("bb",22);
        map.put("cc",33);

        // 使用增强for循环
        for(String key:map.keySet()){
            Integer value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
```

2. EntrySet 遍历键值对：

   entrySet(); getKey(); getValue()

#### 自定义存储类型

Map集合必须保证key是唯一的：

- 作为KEY的元素，必须重写hashCode方法和equals方法（保证key唯一）

