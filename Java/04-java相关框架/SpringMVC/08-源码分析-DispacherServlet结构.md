# SpringMVC的拦截所有请求的前端控制器

## 前端控制器

> DispacherServlet

DispacherServlet继承了FrameworkServlet

类结构图如下

![](https://i.loli.net/2020/05/19/sqDgMaQj1pSZICw.png)

### 发送请求

![](https://i.loli.net/2020/05/19/oQ8Ye4qLilvZfgI.png)

## 运行流程

### 确定方法每个参数的值

**标注解**:保存注解的信息;最终得到这个注解应该对应解析的值

**没标注解**:

看是否是原生API ;

看是否是Model或者是Map , XXXX

都不是,看是否是简单类型; paramName ;

给attrName赋值; attrName (参数标了@ModelAttribute(")就是指定的,没标就是"" )

1. 确定自定义类型参数:
   1. attrName使用参数的类型首字母小写;或者使用之前@ModelAttribute(")的值
   2. 先看隐含模型中有每个这个attrName作为key对应的值;如果有就从隐含模型中获取并赋值
   3. 看是否是@SessionAttributes(value= "haha") ;标注的属性,如果是从session中拿;
      如果拿不到就会抛异常;
   4. 不是@SessionAttributes标注的 ,利用反射创建一个对象;

1. 拿到之前创建好的对象,使用数据绑定器(WebDataBinder)将请求中的每个数据绑定到这个对象中;