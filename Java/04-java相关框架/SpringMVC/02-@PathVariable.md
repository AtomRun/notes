# @pathVariable

> 路径上可以有占位符: 占位符语法就是可以在任意路径的地方写一 个{变量名}

```java
@RequestMapping("/user/{id}")
public String pathVariableTest(@PathVariable("id") String id){
    sout("xxx"+id);
}
```

