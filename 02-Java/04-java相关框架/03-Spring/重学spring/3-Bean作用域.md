# Bean的作用域

> 指定Bean是否是单实例，默认是单实例

```xml
<bean id="car" clas="xxx" scope=""></bean>
```

- singleton：单实例（默认）
  - 在容器创建完成之前就已经创建好对象，保存在容器中
  - 任何时间获取，实例相同
- prototype：多实例
  - 容器启动默认不会创建，而是访问到它的时候再创建
  - 每次获取会创建一个新的实例
- request：web环境下，同一次请求创建一个Bean实例
- ssession：web环境下，同一次会话创建一个Bean实例