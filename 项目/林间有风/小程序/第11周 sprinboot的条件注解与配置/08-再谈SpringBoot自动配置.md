# 再谈SpringBoot自动配置/装配

## 0. 举例

假如你要使用第三方库，那你需要哪些步骤呢？例如小程序项目中的nodejs

1. 安装
2. 引用组件

spring boot中

1. pom中依赖
2. import

**自动装配是什么？**

## 1.原理

springboot加载类的规则，**springBoot SDK**

1. Component、Configure
2. 加载第三方SDK

### @SpringBootApplication

springBoot配置类

### @EnableAutoConfiguration

springBoot核心自动配置类，就是为了加载Bean，将Bean放到容器中。这个注解以configuration结尾，说明是一个配置类。

为什么需要@EnableAutoConfiguration？我们自己使用@Configuration，是我们自己在处理自己的业务类。

而@EnableAutoConfiguration是为了让我们加载第三方SDK，即通过maven依赖的包。

`EnableAutoConfiguration`中有个`@Import(AutoConfigurationImportSelector.class)`，而这个类中有个方法

```java
@Override
public String[] selectImports(AnnotationMetadata annotationMetadata) {
    if (!isEnabled(annotationMetadata)) {
        return NO_IMPORTS;
    }
    AutoConfigurationEntry autoConfigurationEntry = getAutoConfigurationEntry(annotationMetadata);
    return StringUtils.toStringArray(autoConfigurationEntry.getConfigurations());
}
```

这个方法，就是加载第三方库的配置类，加载`spring.factories`，在spring Boot启动时，就开启容器实例化这些类

`EnableAutoConfiguration`可以称为模块装配，通过我们自己组合。

### SPI机制

Service Provider Interface

## 2.为什么要用？解决了什么问题？

解决了，将这些bean加入到容器中，即如何发现bean，加入到IOC容器中的问题

# 总结

这么多都是为了OCP，即是为了解决变化带来的问题