# SpringBoot启动流程

## 一行完成启动

```java
package com.leeup.springbootsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootscApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootscApplication.class, args);
    }
}
```

## 启动过程

### 框架初始化

- 配置资源加载器
- 配置PrimarySources
- 应用环境检测
- 配置应用初始化器
- 配置应用监听器

### 框架启动

- 计时器开始计时，对框架启动时间计时
- Headless模式赋值
- 发送ApplicationStartingEvent
- 配置环境模块
- 发送ApplicationEnvironmentPrepareEvent
- 打印Banner
- 创建上下文对象
- 创建失败分析器，如果启动失败，会打印失败原因
- 关联SpringBoot组件与上下文对象
- 发送ApplicationInitializedEvent
- 加载Sources到Context
- 发送ApplicationPrepareEvent
- 刷新上下文
- 计时器停止
- 发送ApplicaionStarteredEvent

### 自动化装配

- 收集配置文件中的配置工厂类
- 加载组件工厂
- 注册组件内定义Bean

