# Spring Framework

## 1. Getting started with Spring Boot

### 1.1 Introduction to Spring

#### Spring Framework

- Providing comprehensive infrastructural
- OOP Best practices built in
- DRY(Don't Repeat Yourself) Principles

#### Definitions

- **POJO** - Plain old Java Object
  - any class file = attributes + methods (getters + setters + **sth**.)  !!!不只是getter 和setter
- **Java Beans** - Simple objects with only getters and setters
- **Spring Beans** - POJOs configured in the application context.

- **DTOs** (Data Transfer Objects) - state transfer of logical layer

#### Inversion of Control (IOC)

- provides mechanism of dependency injection
- Application Context wraps the Bean Factory
- provides auto-configuration of the Application Context

### 1.2 Introduction to Spring-boot

#### Spring boot Key Aspects

- Embedded tomcat (or others)
- Auto-configuration of Application Context
- Automatic Servlet Mappings
- Database support and Hibernate / JPA dialect
- Automatic Controller Mappings

### 1.3 Creating a Spring Boot Project

1. 登录 https://start.spring.io，完成相关配置。

![image-20220901134653969](Notepic/image-20220901134653969.png)

2. 点击GENERATE，下载文件。
3. 将下载好的文件，移动到任意文件夹。
4. 进入项目文件夹`spring-boot-spring`，`mvn package`构建项目
5. 运行spring-boot 项目：`java -jar target/spring-boot-learning-0.0.1-SNAPSHOT.jar` 

6. 验证：http:localhost:8080

   ![image-20220901143135751](Notepic/image-20220901143135751.png)

### 1.4 Spring Boot Skeleton Project

| Folder                        | Name                          | Annotation                                                   |
| ----------------------------- | ----------------------------- | ------------------------------------------------------------ |
| `src/main/java/com.organize/` | SpringBootLearningApplicaiton | 类名根据配置创建<br />`@SpringBootApplication` : tell the application context, when we run this as a Spring application, to use this as the base for component scanning. |
| `src/main/resources`          | application.properties        | 配置文件                                                     |
| `src/test`                    |                               | 测试文件<br/>`@SpringBootTest` : default test of spring boot （最开始就会运行） |
| `src/test`                    | HELP.md                       | 帮助文件                                                     |
| `src/test`                    | `mvnw` / `mvnw.cmd`           | maven code 用于没有下载maven                                 |
| `src/test`                    | `pom.xml`                     | 依赖配置文件                                                 |

### 1.5 Inversion of Control

- Container maintains your class dependencies
- Objects injected at runtime or startup time
- An object accepts the dependencies for construction instead of constructing them