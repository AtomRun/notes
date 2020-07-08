# 为何不使用@EnableTransactionManagement就能使用事务?



## 为什么没有在启动类上写@EnableTransactionManagement注解，而是在service上使用注解就能进行事务管理呢？

## 自动装配

 ### @EnableTransactionManagement注解

在之前的spring.facotories中会有如下声明，自动装配，即spring容器启动时会自动加载该类到容器中

```xml
org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration
```

