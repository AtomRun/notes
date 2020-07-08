# Spring管理连接池

## 引用外部属性文件

> spring管理的组件默认都是单实例

- 单实例的好处，整个系统默认只有一个实例对象，用来管理连接池十分适合
- 一个项目一个连接池，连接池中有很多连接

## 使用Spring为我们创建连接处对象，并且默认是单例

```xml
<bean id="dataSource" class="xxxx">
    <property name="user" value="xxx"></property>
    <property name="password" value="xxx"></property>
    <property name="jdbcUrl" value="xxx"></property>
    <property name="driverClass" value="xxx"></property>
</bean>
```

```java
//容器中拿到连接池
DataSource ds = (DataSource)ioc.getBean("dataSource")
    
//根据类型获取，还可以获取到这个类型下的实现子类
DataSource bean = ioc.getBean(DataSource.class)    
```

## Spring引入外部文件

```properties

username=root
password=1232345
jdbcUrl=xxx
driverClass=xxx
```

- username是spring中一个key的关键字，为了防止关键字冲突，可以为这些字段加上jdbc前缀字段

```xml
<context:property-placeHolder location=""/>
```

- 使用该标签的location指定引入的properties文件
  - 固定写法classpath：表示引入类路径下的资源
  - 使用${key}可以动态取出文件中的值