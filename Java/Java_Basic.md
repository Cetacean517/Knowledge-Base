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



# Spring Boot

### 1. @Retention 和 @Talent

`@Retention` 注解用于指定注解的保留期限，即注解在代码中的生命周期。它接受一个枚举值作为参数，有三个可选的保留期限：

- `RetentionPolicy.SOURCE`: 注解仅在编译期间存在，不会包含在编译后的字节码中，不会在运行时可用。
- `RetentionPolicy.CLASS`: 注解会包含在编译后的字节码中，但在运行时不可用。这是默认的保留期限，如果没有显式指定。
- `RetentionPolicy.RUNTIME`: 注解会包含在编译后的字节码中，并在运行时可用，可以通过反射获取和处理注解。

例如，使用 `@Retention(RetentionPolicy.RUNTIME)` 可以使注解在运行时保留，以便在程序运行期间可以通过反射获取和利用注解的信息。

`@Target` 注解用于指定注解的适用范围，即可以将注解应用于哪些元素上。它也接受一个枚举值或数组作为参数，指定注解可以应用的目标元素类型。一些常见的目标元素包括：

- `ElementType.TYPE`: 类、接口、枚举等类型声明。
- `ElementType.FIELD`: 字段声明。
- `ElementType.METHOD`: 方法声明。
- `ElementType.PARAMETER`: 方法参数声明。
- `ElementType.CONSTRUCTOR`: 构造函数声明。
- `ElementType.LOCAL_VARIABLE`: 局部变量声明。
- `ElementType.ANNOTATION_TYPE`: 注解类型声明。
- `ElementType.PACKAGE`: 包声明。
- `ElementType.TYPE_PARAMETER`: 类型参数声明。
- `ElementType.TYPE_USE`: 类型使用声明。

通过在注解上使用 `@Target` 并指定适当的目标元素，可以限制注解的使用范围，以确保它们只能应用于所需的元素类型。

例如，使用 `@Target(ElementType.FIELD)` 可以将注解限制为仅适用于字段上。

总结：`@Retention` 和 `@Target` 是用于定义注解行为的元注解。`@Retention` 用于指定注解的保留期限（编译期、类加载期或运行时），而 `@Target` 用于指定注解可以应用于哪些元素类型（类、字段、方法等）。

### 2. SpringBoot 自定义注解

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface QuartzJobInfo {

    String jobName();
    String groupName();
    String cronExpression();
    String parameter();
}
```

根据提供的注解定义代码，`@QuartzJobInfo` 是一个自定义注解，具有以下特性：

1. `@Retention(RetentionPolicy.RUNTIME)`：这个注解保留期限被指定为运行时期，意味着 `@QuartzJobInfo` 注解在编译后的字节码中保留，并且可以在运行时通过反射获取注解的信息。
2. `@Target(ElementType.TYPE)`：这个注解的适用范围被限定为类（包括类、接口、枚举等类型声明）。它表示 `@QuartzJobInfo` 注解只能应用于类级别的元素。
3. `@interface QuartzJobInfo`：这个标志了注解的定义开始。该注解被定义为 `@QuartzJobInfo`。
4. 属性定义：在 `@QuartzJobInfo` 注解中定义了四个属性：
   - `jobName()`：用于指定作业名称的属性。该属性为无参数的方法，返回类型为 `String`。
   - `groupName()`：用于指定作业组名称的属性。该属性为无参数的方法，返回类型为 `String`。
   - `cronExpression()`：用于指定 Cron 表达式的属性。该属性为无参数的方法，返回类型为 `String`。
   - `parameter()`：用于指定作业参数的属性。该属性为无参数的方法，返回类型为 `String`。

通过在类上使用 `@QuartzJobInfo` 注解，并提供相应的属性值，可以为该类添加自定义的作业调度相关信息。这些信息可以在运行时通过反射获取，并用于实现定时任务的调度。

#### cronExpression

`cronExpression` 属性被定义为 `"0 8/15 * * * ?"`。这是一个 Cron 表达式，用于指定调度作业的执行时间。解析这个 Cron 表达式，可以得到以下含义：

```
"0 8/15 * * * ?"
```



- `0`: 表示指定了秒数为 0，表示每分钟的第 0 秒开始触发作业。
- `8/15`: 表示从每小时的第 8 分钟开始，每隔 15 分钟触发一次作业。即分钟字段的取值为 8、23、38、53。
- `*`: 表示不限制在任何日期。
- `*`: 表示不限制在任何月份。
- `*`: 表示不限制在任何日期。
- `?`: 在 Quartz 中表示不关心具体的星期几。

综上所述，该 Cron 表达式的含义是在每小时的第 8 分钟开始，每隔 15 分钟触发一次作业，不受日期和月份的限制，也不关心具体的星期几。

因此，当你将 `@QuartzJobInfo` 注解应用于一个类并设置 `cronExpression` 属性为 `"0 8/15 * * * ?"` 时，这个作业会在每小时的第 8 分钟开始，并且每隔 15 分钟触发一次。请注意，这个解释是根据标准的 Cron 表达式规则，具体的行为可能还受到 Quartz 调度框架的配置和环境的影响。



### 3.Entity继承另一个父类Entity绑定的表也会被继承过来

Entity继承另一个父类Entity绑定的表也会被继承过来，且父类绑定表的优先级上也更高一点。

```java
//A.java
@Entity
@Table(...A_Table)
class A(){
    //...
        
}

// B.java
@Entity
@Table(...B_Table)
class B extends A(){
    //...
        
}
```

上例中，B实体继承了A实体，但是由于A实体已经指定了表。就算B重新绑定了表单，已经会传入A的表。



### 4. 反射如果不加条件只能获取非继承的属性

```java
//A.java
class Common(){
    private Integer Id,
    private String name,
     
   	//...getter setter
}

// B.java
@Entity
@Table(...B_Table)
class B extends A(){
    private String sex,
    
    //... sex's getter and setter
        
}

// service.java
@Service
class saveStudent(){
    //... import repo
    B bean = new B();
    B.setId(1);
    B.setName("name");
    B.setSex("female");
    repo.save(B);
}
```

如上例中，实例B继承了A的私有属性和方法，并且没有主动新建自己的。由于java的反射过程不能继承该类继承得来的属性值，因此在存储到数据库的工程中会丢失`id,name`属性的值。



### 5. Get接口：路径参数 vs 普通参数

路径参数

```
/newtest/{type}/{id}
```

目的是用于区分路径，每个路径会有独立的逻辑

普通参数

```
/newtest/page?type=1&id=1
```

目的是仅仅接受参数，用于逻辑。并不需要区分独立的逻辑。可能知识模块的名字，或者一些字段信息等。
