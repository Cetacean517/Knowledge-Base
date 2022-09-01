# Java Basic

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



