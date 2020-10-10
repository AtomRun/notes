# 使用@AutoWired自动注入

```java
@Reponsity
public class BookDao{
    public void save(){
        sout("我保存啦");
    }
}
```

```java
@Service
public class BookService{
    
    @AutoWired
 	private BookDao bookDao;   
    
    public void save(){
        bookDao.save();
    }
}
```

```java
@Conrtroller
public class BookServlet{
    
    //自动装配，自动为这个属性赋值
    @AutoWired
 	private BookService bookService;
    
    public void save(){
        bookService.save();
    }
}
```

## @AutoWired

- Spring会自动为这个属性赋值

## HOW?

#### 以被@AutoWired注解的Private BookService bookSerivice为例

1. 先按照类型去容器中找到对应的组件相当于下面的

```java
bookService = ioc.getBean(BookService.class)
```

- 找到一个，赋值
- 没找到：抛出异常
- 找到多个，假设BookServiceExt 继承了BookService，依旧装配上，变量名作为ID注入
  - 按照Servlet中定义的@AutoWired修饰的BookService的具体名字来注入
  - 按照变量名id继续匹配：BookService(bookService)、BookServiceExt(bookServiceExt)
  - 如果没找到，即Servlet声明的Service变量名在容器中没找到，就会报错
    - 在Servlet声明Service的变量上使用@Qulifier("xxxx")：指定一个名字作为ID，不使用变量名
- @AutoWired(required=false)
  - 设置找不到自动装配为null