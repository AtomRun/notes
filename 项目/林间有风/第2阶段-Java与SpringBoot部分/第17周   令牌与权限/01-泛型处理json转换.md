# 泛型处理json转换

静态方法中如何获取实例注入？

1. 对注入的属性加上`static`关键字
   1. 这样是不正确的，因为注入的前提就是要对类进行实例化，然而加了static注解就在类实例化之前加载了。
2. 使用如下方法

```java
private static ObjectMapper mapper;
@Autowired
public void setMapper(ObjectMapper mapper){
    GenericAndJson.mapper = mapper;
}
```

当springboot启动的时候，容器就会ObjectMapper注入到setMapper中，这里即方法的注入。

说白了就是ObjecrtMapper实例化之后将其注入到方法中，然后通过方法赋值给static的mapper