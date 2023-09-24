# Springboot Advance

## 1. SpringBoot 原理分析

### 1.1 自动配置

#### I. Condition

在Spring4.0新增的调节判断功能，实现***选择性创建Bean操作***。

##### **案例**

在Spring的IOC容器中有一个User的Bean，现要求：

1. 导入Jedis坐标后，加载该Bean；没导入，则不加载。
2. 将类的判断定义改为动态的。判断哪个字节码文件，使用动态指定。

##### **实现 需求1**

1. 创建一个User类

```java
package com.cetacean.domain;

public class User {
}
```

2. 创建一个User Config类，用于创建User Bean。并且增加`@Conditional` 注解，使得在符合某些条件时，才创建Bean。

```java
package com.cetacean.config;

import com.cetacean.condition.ClassCondition;
import com.cetacean.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(ClassCondition.class)		// add condition by ClassCondition
public class UserConfig {
    @Bean															// create Bean
    public User user(){
        return new User();
    }
}
```



##### ***==@Conditional==***

`@Conditional` 注解，包含一个参数:  改参数是由Condition的子类组成的数组。

```
Class<? extends Condition>[] value();
```

`Condition` 是一个接口，包含一个方法：

改方法可以定义匹配条件，根据匹配结果返回boolean值。

````java
boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);
````



3. 导入Jedis依赖 --- maven reload

```xml
		<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>4.3.1</version>
		</dependency>
```



4. 创建一个Condition类，用于构建conditional注解的条件。

```java
package com.cetacean.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // Check whether redis.clients.jedis.Jedis.class file exists.
        boolean flag = true;
        try {
          	// 1. load in bytecode file of jedis.
            Class<?> cls = Class.forName("redis.clients.jedis.Jedis");
        } catch (ClassNotFoundException e) {
          	// 2. If you cannot find the file, change flag to false.
            flag = false;
        }
      	// 3. return flag as result.
        return flag;
    }
}

```

- 当pom.xml中没有导入Jedis依赖时，运行main程序会报错：`no user bean...`
- 反之，运行成功，并且答应user bean的信息。



##### **实现 需求2**

1. 创建ClassOnCondition注解，将字节码文件类型作为注解的参数。

   ```java
   package com.cetacean.condition;
   import org.springframework.context.annotation.Conditional;
   import java.lang.annotation.*;
   
   // Annotation-config : 
   // Target: Set where the annotation is effective. 在变量和方法上生效。
   @Target({ElementType.TYPE, ElementType.METHOD})
   // Retention: Set when to be effective
   @Retention(RetentionPolicy.RUNTIME)
   // Documented: Can be load out into documents.
   @Documented
   // add Conditional annotation to class to inherit its function 
   @Conditional(ClassCondition.class) 
   public @interface ConditionOnClass {
       String[] value();		// To save the dynamic value of bytecode file
   }
   ```

2. 修改User Config类中的注解，替换为自定义注解

   ```java
   package com.cetacean.config;
   
   import com.cetacean.condition.ClassCondition;
   import com.cetacean.condition.ConditionOnClass;
   import com.cetacean.domain.User;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   
   @Configuration
   @ConditionOnClass("redis.clients.jedis.Jedis")	// change the annotation
   public class UserConfig {
       @Bean
       public User user(){
           return new User();
       }
   }
   ```

3. 修改ClassConditon方法


##### ***==Condition接口的 matches 方法==***

```java
boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);
```

- context:  上下问对象。用于获取环境，IOC容器，ClassLoader对象。
- metadata: 注解的元对象。用于获取注解定义的属性值。

```java
package com.cetacean.condition;

public class ClassCondition implements Condition {
    /**
     *
     * @param context 上下文对象。用于获取环境，IOC容器，ClassLoader对象。
     * @param metadata 注解的元对象。用于获取注解定义的属性值。
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // Check whether specific bytecode file exists.
        // 1. Get annotation property value: value
        Map<String, Object> map = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
      // 2. Get all values from map
        String[] value = (String[]) map.get("value");
        boolean flag = true;
        try {
          // 3. Check if all className exits
            for (String className : value) {
                Class<?> cls = Class.forName(className);
            }
        } catch (ClassNotFoundException e) {
            flag = false;
        }
        // 3. return flag as result.
        return flag;

    }
}
```



##### 小结

- 自定义条件
  - 定义条件类：自定义类实现Condition接口，重写matches方法，在matches方法中进行逻辑判断，返回boolean值。matches方法有两个参数：
    - context：上下文对象，可以获取属性值，获取类加载器，获取BeanFactory等。
    - metadata：元数据对象，用于获取注解属性。
  - 判断条件：在初始化Bean时，使用`@Conditional` (条件类.class)注解
- SpringBoot提供的常用条件注解：
  - ConditionalOnProperty：判断配置文件中是否有对应属性和值才初始化Bean。
  - ConditionalOnClass：判断环境中是否有对应的字节码文件（类？）才初始化Bean。
  - ConditonalOnMissing：判断环境中是否有改Bean，没有对应Bean才初始化Bean。



#### II. 切换内置web服务器

SpringBoot的web环境中默认使用tomcat作为内置服务器，并提供四种服务器供我们选择。

> 内置服务器的文件夹：org.springframework.boot.autoconfigure.web.embedded
>
> - 配置文件  EmbeddedWebServerFactoryCustomizerAutoConfiguration
> - Jetty服务器 JettyWebServerFactoryCustomizer
> - Netty服务器 NettyWebServerFactoryCustomizer
> - Tomcat服务器 TomcatWebServerFactoryCustomizer
> - Undertow服务器 UndertowWebServerFactoryCustomizer

##### **实现**

1. 排除tomcat的默认依赖。

   进入pom.xml --- 右键 --- Diagrams --- Show Diagram --- 查看maven依赖关系图

   <img src="./Notepic/image-20230913231307269.png" alt="image-20230913231307269" style="zoom:33%;" />

   搜索 tomcat --- Shift + delete --- 排除依赖，在pom.xml 会新增一段exclusion代码。

   <img src="./Notepic/image-20230913231559981.png" alt="image-20230913231559981" style="zoom:33%;" />

2. 添加新的web服务器依赖。

   ```xml
   		<dependency>
   			<groupId>org.springframework.boot</groupId>
   			<artifactId>spring-boot-starter-web</artifactId>
   			<exclusions>
   				<exclusion>
   					<groupId>org.springframework.boot</groupId>
   					<artifactId>spring-boot-starter-tomcat</artifactId>
   					<!--排除tomcat的依赖-->
   				</exclusion>
   			</exclusions>
   		</dependency>
   
   		<!--引入jetty的依赖-->
   		<dependency>
   			<groupId>org.springframework.boot</groupId>
   			<artifactId>spring-boot-starter-jetty</artifactId>
   		</dependency>
   ```



#### III. @Enable*注解

SpringBoot中提供了多个Enable开头的注解，用于动态启动某些功能。其底层原理是使用@Import注解导入配置类，实现Bean的动态加载。

> SpringBoot 不能直接获取其他模块里定义的Bean。

##### **错误案例**

- 创建springboot-enable 和 springboot-enable-other 两个模块。

- 在springboot-enable-other模块中，添加两个文件。

  ```java
  // Config File
  package com.cetacean.config;
  
  import com.cetacean.domain.User;
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  
  @Configuration
  public class UserConfig {
  
      @Bean
      public User user(){
          return new User();
      }
  }
  
  ```

  ```java
  // Bean File
  package com.cetacean.domain;
  
  public class User {
  }
  
  ```

- 在springboot-enable模块的pom.xml文件中，添加springboot-enable-other的依赖

  ```xml
          <dependency>
              <groupId>com.cetacean</groupId>
              <artifactId>springboot-enable-other</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  ```

- 在spring-enable模块的主文件中，添加测试用例。

  ```java
  @SpringBootApplication
  public class SpringbootEnableApplication {
  
      public static void main(String[] args) {
          ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);
  
          // 1. Get Bean
          Object user = context.getBean("user");
          System.out.println(user);
      }
  }
  
  //RUN ERROR
  //Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'user' available
  ```




##### *@ComponentScan*

扫描范围：当前引导类所在包及其子包



##### 将第三方类的Bean加入当前类IOC

1. 使用 @ComponentScan扫描com.cetacean.config（包的路径）包。

   ```java
   @SpringBootApplication
   //导入springboot-enable-other包中config的路径
   @ComponentScan("com.cetacean.config")	
   public class SpringbootEnableApplication {
     ...
   }
   ```

   

2. 使用@Import注解，加载类。这些类都会被Spring创建，并放入IOC容器。

   ```java
   @SpringBootApplication
   // 导入UserConfig类
   @Import(UserConfig.class)
   public class SpringbootEnableApplication {
     ...
   }
   ```

   

3. 对Import注解进行封装。

   第三方库中对Import注解进行封装，如：在springboot-enable-other的config目录下新建`EnableUser`接口。

   ```java
   package com.cetacean.config;
   
   import org.springframework.context.annotation.Import;
   
   import java.lang.annotation.*;
   
   @Target(ElementType.TYPE)
   @Retention(RetentionPolicy.RUNTIME)
   @Documented
   @Import(UserConfig.class)		// 导入对应类
   public @interface EnableUser {
   }
   ```

   使用注解。

   ```java
   @SpringBootApplication
   @EnableUser
   public class SpringbootEnableApplication {
     ...
   }
   ```

#### IV.@Import注解

@Enable*底层依赖于@Import注解导入一些类，使用@Import导入的类会被Spring加载到IOC容器中。@Import提供4种用法：

- 导入Bean
- 导入配置类
- 导入ImportSelector实现类。一般用于加载配置文件中的类。
- 导入ImportBeanDefinitionRegistrar实现类



##### 导入Bean

```java
@SpringBootApplication
// Import Bean
@Import(User.class)
public class SpringbootEnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);

        // 0. Get Bean (NOT USEFUL, AS NAME MAY NOT BE USER)
        // Object user = context.getBean("user");
        // System.out.println(user);
        
        // 1. Use Bean Class to get Bean. As the name may not be user.
        User bean = context.getBean(User.class);
        System.out.println(bean);

        // 2. To get all key-value of User Bean.
        Map<String, User> beansOfType = context.getBeansOfType(User.class);
        System.out.println(beansOfType);
    }
}
```



##### 导入配置类

被导入的配置类上的@Configuration注解可以不加。

```java
package com.cetacean.config;

// When use import configuration class, this annotation on Config class can be removed.
//@Configuration
public class UserConfig {

    @Bean
    public User user(){
        return new User();
    }
}

```

导入配置类

```java
package com.cetacean.springbootenable;

@SpringBootApplication
// Import config class
@Import(UserConfig.class)
public class SpringbootEnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);

        User bean = context.getBean(User.class);
        System.out.println(bean);
    }
}
```



##### 导入ImportSelector实现类

创建ImportSelector的实现类，可以将导入的包写在配置文件中，通过代码动态导入。

```java
// MyImportSelect.java
package com.cetacean.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
  //复写导入包的方法。
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.cetacean.domain.User","com.cetacean.domain.Role"};
    }
}

```

应用

```java
package com.cetacean.springbootenable;

@SpringBootApplication
// Import ImportSelect class
@Import(MyImportSelector.class)
public class SpringbootEnableApplication {
  ... // Same as above
}
```



##### 导入ImportBeanDefinitionRegistrar实现类

创建MyImportBeanDefinitionRegistrar类

```java
package com.cetacean.config;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(User.class).getBeanDefinition();
        registry.registerBeanDefinition("user",beanDefinition);
    }
}

```

应用

```java
package com.cetacean.springbootenable;

@SpringBootApplication
// Import ImportBeanDefinitionRegistrar class
@Import(MyImportBeanDefinitionRegistrar.class)
public class SpringbootEnableApplication {
  ... // Same as above
}
```



#### V. @EnableAutoConfiguration 注解

- `@EnableAutoConfiguration`注解内部使用`@Import(AutoConfigurationImportSelector.class)`来加载配置类。
- 配置文件：`META_INF/spring.factories`， 改配置文件中定义了大量的配置类。当Springboot应用启动时，会自动加载这些配置类，并初始化Bean。
- 但并非所有的Bean都会被初始化，在配置类中使用Condition来加载满足条件的Bean。



#### VI. SpringBoot 自动配置 案例

##### 案例

​	自定义redis-starter。要求当导入redis坐标时，Spring Boot自动创建Jedis的Bean。

##### 步骤

- 创建 redis-spring-boot-autoconfigure 模块
- 创建 redis-spring-boot-starter 模块，依赖 redis-spring-boot-autoconfigure 的模块
- 在 redid-spring-boot-autoconfigure 模块中初始化Jedis的Bean。并定义META- INF/spring.factories文件
- 在测试模块中引入自定义的redis-starter 依赖，测试获取Jedis的Bean，操作redis

##### 实现

- 创建redis-spring-boot-autoconfigure模块和  redis-spring-boot-starter，让starter模块依赖autoconfigure模块。

  清除不要的目录结构，仅保留src 和 pom.xml 文件。同时，删除main文件的启动类，test文件的测试类。

```xml
//redis-spring-boot-starter/pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="..." xmlns:xsi="..."  xsi:schemaLocation="...">
  	<!-- Omit Basic configs ...-->
  
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
      
        <!-- Import configure-->
        <dependency>
            <groupId>com.cetacean</groupId>
            <artifactId>redis-spring-boot-autoconfigure</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>

    </dependencies>
</project>
```

```xml
//redis-spring-boot-starter/pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="..." xmlns:xsi="..."  xsi:schemaLocation="...">
  	<!-- Omit Basic configs ...-->
  
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <!-- Import Jedis Dependency -->
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
        </dependency>
    </dependencies>
</project>
```

- 在 redid-spring-boot-autoconfigure 模块中初始化Jedis的Bean。并定义META- INF/spring.factories文件

```java
// RedisAutoConfiguration
package com.cetacean.redis.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfiguration {

    /* Return Jedis Bean */
    @Bean
    public Jedis jedis(RedisProperties redisProperties){
        return new Jedis(redisProperties.getHost(),redisProperties.getPort());
    }
}

```



```java
// RedisProperties
package com.cetacean.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "redis")
public class RedisProperties {
    private String host = "localhost";
    private int port = 6379;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int  port) {
        this.port = port;
    }
}
```



```java
// resouces/META-INF/spring.factories
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.cetacean.redis.config.RedisAutoConfiguration
```

- spring-boot-enable里面增加redid-spring-boot-starter的依赖

```xml
    <!-- Self-defined spring starter -->
    <dependency>
        <groupId>com.cetacean</groupId>
        <artifactId>redis-spring-boot-starter</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
```













### 1.2 监听机制

### 1.3 启动流程分析

## 2. SpringBoot 监控

## 3. SpringBoot 项目部署