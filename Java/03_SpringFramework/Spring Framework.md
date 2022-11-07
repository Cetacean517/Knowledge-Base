# Spring Framework

## I. Getting started with Spring Boot

### 1.1 Introduction to Spring

**Spring Framework**

- Providing comprehensive infrastructural
- OOP Best practices built in
- DRY(Don't Repeat Yourself) Principles

**Definitions**

- **POJO** - Plain old Java Object
  - any class file = attributes + methods (getters + setters + **sth**.)  !!!不只是getter 和setter
- **Java Beans** - Simple objects with only getters and setters
- **Spring Beans** - POJOs configured in the application context.

- **DTOs** (Data Transfer Objects) - state transfer of logical layer

**Inversion of Control (IOC)**

- provides mechanism of dependency injection
- Application Context wraps the Bean Factory
- provides auto-configuration of the Application Context



### 1.2 Introduction to Spring-boot

Spring boot Key Aspects

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



### 1.5 Inversion of Control 控制反转

- Container maintains your clash dependencies
- Objects injected at runtime or startup time
- An object accepts the dependencies for construction instead of constructing them

**Traditional Dependency Management**

<img src="Notepic/image-20220929143835800.png" alt="image-20220929143835800" style="zoom:33%;" />

a Main method need to create several classes at first, and config them of a lot depths.

**loC Container Management**

<img src="Notepic/image-20220929150353689.png" alt="image-20220929150353689" style="zoom: 33%;" />

Main --- trigger ---> loC Container, and let loC Container to instantiation (实例化) the class.



### 1.6 Annotations

**What are Annotations**

- Native support in Java
- Metadata for your code
- Often used for compiler or runtime instructions. e.g.`@test`
- Great leverage point for pointcuts.

**Proxies**

- Beans in Bean Factory are proxied 
- Annotations drive proxies
- Annotations are easy extension points, for your own abstracts too
- Methods calling order matters. (important!!! proxy class can only called with internal method/ class local method)



## II. Data Access in Spring

### 2.1 Spring Data

**What is Spring Data?**

- Provides a common set of interfaces, based on JPA
- Provides a common ***naming convention （命名规范）***  
- Provides expected behavior
- Provides Repository and Data Mapping convention(数据映射规范)

**Benefits of Spring Data**

- Remove boilerplate code (模板代码)
- Allows for swapping data sources easier. (from ***POC= proof of concept 概念验证*** to production data)
- Allows to focus on business logic

**Key Components**

- ***Repository Interface*** = *an interface that leverages proxies to build the actual base CRUD methods.*
- ***Entity Object*** = the DTO for the data layer
- ***Data Source*** = auto trigger by Spring



### 2.2 Using an Embedded Database

1. Create sql

   bin -- set `sql` files and `start_postgres.sh`.

2. Add pom dependencies

   Add `jpa`  and `h2database` , version need not to be specify, because the parent pom will take care of it.

   ```xml
   <dependencies>
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-web</artifactId>
       </dependency>
    
       <-->Add two new dependencies </-->   
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-data-jpa</artifactId>
       </dependency>
       <dependency>			
           <groupId>com.h2database</groupId>
           <artifactId>h2</artifactId>
       </dependency>
       ...
   </dependenciestyou
   ```

3. Run maven command, to install dependencies.

4. Add info to application.properties

   ```properties
   logging.level.org.springframework.jdbc.datasource.init.ScriptUtils=debug
   spring.jpa.hibernate.ddl-auto=none
   ```

   - line 1: set log to debug level
   - line 2: avoid hibernate auto clean the schema and data we generate by hand , and auto generate a new schema to take control of it.

    

### 2.3 Spring Data Repositories





### 2.4 Using a remote database





### 2.5 Build an additional repository





