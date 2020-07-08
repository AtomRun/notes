# 聚合工程整合springBoot

## 修改dev的Pom

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.leeup</groupId>
    <artifactId>foodie-dev</artifactId>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>foodie-dev-common</module>
        <module>foodie-dev-pojo</module>
        <module>foodie-dev-mapper</module>
        <module>foodie-dev-service</module>
        <module>foodie-dev-api</module>
    </modules>
    <packaging>pom</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.5.RELEASE</version>
        <!--查找顺序：relativePath元素中的地址–>本地仓库–>远程仓库
如为空值将始终从仓库中获取，不从本地路径获取-->
        <relativePath />
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <!--排除相应的jar，springBoot默认使用的日志，我们会整合其他的日志-->
            <exclusions>
                <exclusion>
                <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-logging</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!--springBoot的Web模块-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--springBoot的配置模块，用来解析XML、properties-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>


    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>
    
</project>
```

## Demo测试

### spring Start

```java
package com.leeup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStart {


    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class,args);
    }
}
```

### controller

```java
package com.leeup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello(){
        return "hello World";
    }
}
```

### 结果

![](https://i.loli.net/2020/06/29/bUXuGw5LDloh9Ar.png)