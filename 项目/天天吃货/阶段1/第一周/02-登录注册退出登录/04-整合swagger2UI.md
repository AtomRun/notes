# 整合Swagger2

## 加入依赖

```xml
<!-- swagger2 配置 -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.4.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.4.0</version>
</dependency>
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>swagger-bootstrap-ui</artifactId>
    <version>1.6</version>
</dependency>
```

## 加入配置类

```java
package com.leeup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName Swagger2
 * @Description Swagger配置类
 * @Author clee
 * @Date 2020/7/1 16:22
 * @Version 1.0
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     * 访问地址 http://localhost:8088/swagger-ui.html      原路径
     * 美化后地址 http://localhost:8088/doc.html
     * @return
     */

    // 配置Swagger2核心配置

    //bean，用于被spring加入容器并实例化
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2). //指定api类型为swagger2
                apiInfo(apiInfo())                               //用于定义api文档汇总信息
                .select().apis(RequestHandlerSelectors.
                        basePackage("com.leeup.controller"))        //指定controller包
                .paths(PathSelectors.any())                         //指定哪些，这里是全部
                .build();
    }

//    构建一个新的ApiInfo
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("天天吃货API平台")          //文档页标题
                .contact(new Contact("cLee",
                        "www.leeup.cn",
                        "lcup@foxmail.com"))//文档创作者联系人相关信息
                .description("天天吃货购物平台的API文档")
                .version("1.0.0")   //文档版本号
                .termsOfServiceUrl("https://leeup.cn")  //网站地址
                .build();
    }
}

```

## 修改美化后为中文

### 忽略测试用Controller

- 加入@ApiIgnore注解即可

### 整个controller标题修改

- @Api(value = "登录注册",tags = {"登录注册相关的接口"})

### 方法接口详情notes修改

- @ApiOperation(value = "用户名是否存在",notes = "用户名是否存在", httpMethod = "GET")	

### 参数详解美化

```java
package com.leeup.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserBo
 * @Description 用于接收前端传来的属性值值的BO类
 * @Author clee
 * @Date 2020/7/1 0:22
 * @Version 1.0
 **/
@ApiModel(value = "用户对象BO",description = "从客户端，由用户传入的数据封装在这个实体类中")
public class UserBO {

    @ApiModelProperty(value = "用户名", name="username",example = "cLee",required = true)
    private String username;
    @ApiModelProperty(value = "用户密码", name="password",example = "123123",required = true)
    private String password;
    @ApiModelProperty(value = "用户重复密码", name="confirmPassword",example = "123123",required = true)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
```

