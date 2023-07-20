# Spring Boot

## 1. SpringBoot 概述

Spring boot 简化了Spring 的配置方式，基于约定由于配置的思想。提供了快速使用Spring项目的方式。

#### Spring 缺点

- 配置繁琐
- 依赖繁琐

#### SpringBoot 功能

1. ==自动配置==
2. ==起步依赖== ---- 传递依赖
3. 辅助功能 （嵌入式服务器，安全，指标...)



## 2. Springboot 快速入门

> 使用案例快速入门
>
> 官网构建Springboot文档：[这里](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started.installing.java.maven)

案例需求

搭建SpringBoot工程，定义HelloController.hello()方法，返回Hello SpringBoot

案例实现

1. 创建Maven项目

2. 导入SpringBoot起步依赖

   pom.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8" standalone="no"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
     <modelVersion>4.0.0</modelVersion>
     <groupId>org.cetacean</groupId>
     <artifactId>springboot-helloworld</artifactId>
     <version>1.0-SNAPSHOT</version>
   
     <!-- Inherit defaults from Spring Boot 需要继承的父工程 -->
     <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-parent</artifactId>
       <version>2.1.8.RELEASE</version>
     </parent>
   
     <!--    Web 开发的启动依赖-->
     <dependencies>
       <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-web</artifactId>
       </dependency>
     </dependencies>
   
   </project>
   
   ```

3. 定义Controller

   ```java
   // src.java.com.demo.controller
   
   package com.demo.controller;
   
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RestController;
   
   @RestController
   public class HelloController {
   
           @RequestMapping("/hello")
       public String hello(){
           return "hello Spring Boot !";
       }
   }
   ```

   

4. 编写引导类

   ```java
   package com.demo;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   
   /*
   * 引导类 SpringBoot入口*/
   @SpringBootApplication
   public class HelloApplication {
       public static void main(String[] args) {
           SpringApplication.run(HelloApplication.class,args);
       }
   }
   
   ```

   

5. 启动测试

