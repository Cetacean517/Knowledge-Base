# Spring Boot 2.0 Essential Training

## I. Spring Boot Basics

### 1.1 Booting from the web

- Use web plugin to boot a Spring Boot application.  https://start.spring.io/



### 1.2 Understanding the project

`pom.xml`

- basic information and dependencies.

`BootingWebApplication`

- A class with `@SpringBootApplication` , defines the class as the route package for configuration via component scanning.
- A configuration class and we can put being configuration in the class if we choose. ( 配置类，可以选择把配置放在该类中。)
- When jar file is built, it will point to the main method, and run it.

`resources` folder

- `application properties` : load in properties that you want to stored with the application itself. (导入希望存储在application内部的配置信息，而不是从环境变量中注入。)

`test` file

- `@SpringBootTest`
- Do test in the file.



### 1.3 Auto-configuration

**`@EnableAutoConfiguration`**

- Allows for configuration classes to be scanned dynamically
- Often based off JARs loaded onto class path. ( 基于加载在路径上的Jar包 )
- Driven off of **`spring.factories`**
- **`@AutoConfigureBefore`** and **`AutoConfigureAfter`**

**Conditional Loading** 

- `@ConditionalOnClass`
- `@ConditionalOnBean`
- `@ConditionalOnProperty`
- `@ConditionalOnMissingBean`

**Properties**

- Preconfigured default properties for auto-configuration classes
- **`EnableConfigurationProperties`** specifies with the default property set
- Can always be overridden

**Additional Conditionals**

- Bean, missing bean, class, missing class based, property based
- Application type based
- Resource (or file) based
- Expression based



### 1.4 Configuration in Spring Boot

1.5 Spring Profiles in Boot

1.6 Building Spring Boot applications

1.7 Containerizing Spring Boot applications