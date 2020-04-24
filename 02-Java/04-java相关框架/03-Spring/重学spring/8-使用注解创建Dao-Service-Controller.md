# 注解创建Service/Dao/Controller

## 使用xml配置

- 将bean加入容器很麻烦，如果要spring管理的类很多的话，要写很多很多bean标签

## 使用注解开发

> 通过给bean上添加某些注解，快速的将bean加到IOC容器中

#### Spring的四个注解

某个类上，添加以下任何一个注解都能快速的将该类添加到IOC容器中

- Controller：推荐给控制器层添加
- Service：推荐给业务逻辑层组件添加
- Repository：推荐给Dao层添加，即持久化层
- Components：如果有个WEBUtils想添加，不属于上面任何一层，可以添加

Spring底层不会验证你的注解类是否属于MVC组件

```java
@Conrtroller
public class BookServlet{
    
}
```

```java
@Service
public class BookService{
    
}
```

```java
@Repository
public class BookDao{
    
}
```

## 使用注解快速将组件加入IOC容器的步骤

1. 给要添加的组件上写上面任意一个注解

2. 告诉Spring，自动扫描了加注解的组件，依赖context名称空间

   1. ```xml
      <context:component-scan base-package="xxxx">
      
      </context:component-scan>
      ```

   2. base-package:扫描指定的基础包，把基础包下面所有加了注解的类自动扫描加入IOC容器中

   3. 使用注解添加到IOC容器中的类ID默认是类名首字母小写

3. 要使用注解，一定要导入AOP包

4. 使用注解加入到IOC容器中的组件，和使用配置加入到容器中的组件行为都是默认一样的。

   1. 组件id，默认都是类名首字母小写
   2. 作用域默认都是单例

   ## 修改组件默认的id

   - 直接在注解后跟上@Service("id")

   ## 修改组件默认作用域

   - @Scope("protoType")修改为多实例