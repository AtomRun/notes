# Spring&SpringMVC&SpringBoot关系

## SSM时代

其实是两个框架的几个即，Spring+MyBatis，Spring MVC是Spring的一个模块

SpringBoot是Spring Framework的应用

# SpringBoot相对于Spring的核心优势是什么？

1. 自动配置

## 自动配置解决了什么问题?

1. 解决了繁杂的xml配置
2. 开箱即用

## IOC的具体实现

1. 将对象加入到容器中，使用依赖注入获取实例

## 抽象意义

2. 将控制权交给用户
3. 实现灵活的OCP

# SpringBoot基础的编程模式

`@AutoWired`

## sterotype annotatinos 模式注解

`@Compoent` 这个类会被springBoot扫描到加入容器中 				组件、类、bean 类的实例化new

`@Autowired`这个类会将容器中的实例注入到声明的类/接口中

`@Service` `@Controller` `@Repository` 				这三者都是根据`@Component`实现的，只是语义不同

`@Configuration`				灵活的将一组bean加入容器中，告诉spring这是一个配置类

# 为什么Controller好像没有被调用就能使用？

`@RestController`注解中还是加入了`@component`，所以还是会加入到IOC容器中，SpringBoot中自动添加到路由中

# IOC容器是在什么时候实例化bean并且注入呢

在springBoot启动时就创建了，并且注入到代码片段中，这是默认的机制，使用@Lazy可以让一个bean缓慢实例化，但是由于一个类依赖@Lazy的类，那么这个类被实例化的时候@Lazy的类还是会被实例化

# 成员变量注入/Setter注入/构造注入

# 一个接口多个实现

像平常那样的写法有什么意义呢？

例如一个Controller：A、一个Inteface：B，一个实现类B1

A依赖private B b ，注入BI，使用B1的方法

## 问题

这样写的原因是，我们未来要考虑更方便的切换实现类，现在只有一个实现类B1，可能未来会有很多实现类B2/B3，这个时候就要考虑变化了。

但是当我们controller中B B1或者B B2的时候,我们调用方法的时候（假设B1/B2中的方法有相同名字的），我们调用的是B1还是B2呢

## 取决于接口声明时候的语句即B B1还是B B2？

如果是B1，B1.method就是B1的方法，反之即然。变量的声明对调用的方法有影响

## 注入方式

1. byType，`这个是默认的注入形式`

例如要注入一个B类型的类进去，那么spring会去容器中寻找所有实现了B的对象并且注入进去，但是当B有多个实现的时候，Spring会根据字段名进行推断

2. byName

寻找B的实现bean->找不到任何bean/找到一个bean，直接注入/找到很多个，并不一定会报错，后续会根据字段名字推断，例如B B1/B B2。->如果按类型没找到，按字段找也没有，就会报错。所以可以根据不同名字的字段，注入不同的bean

- 上面这两种形式都是Spring自动实现的，我们也可以自己设置，在字段上加入`@Qualifier("xxx")`，xxx就是要注入的bean名，可以理解为主动注入

# 对于程序变化的解决方案

1. 多个类实现了同一个接口，这就是策略模式。
2. 一个类，通过更改类的属性，来达到对应变化，也可以理解为修改配置文件。

