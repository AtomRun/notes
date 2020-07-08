# 方法返回值为ModeAndView类型

```java
@RequestMapping("/xxx")
public ModelAndView handle01(){
    //new的时候让你传入一个viewName，即想要跳转到的页面名称
    //视图名是视图解析器最终会帮我们进行拼串到页面的真实地址
	ModelAndView mv =  new ModelAndView("success");
    mv.addObject("msg","你好");
    return  mv;
}
```

- 数据放在request域中

ModelAndView即包含视图信息（页面地址），也包含模型数据（给页面带的数据）

而且数据是放在request作用域中。

## 临时给Session作用域中保存数据的方式

使用一个注解@SessionAttributes，只能标在类上

有两个属性

- Sting[] values() default {}

@SessionAttributes (value="msg") 
给BindingAwareModelMap中或者ModelAndView中保存的数据，同时给session中放一份，value的作用是，只有value(key)为msg的时候才保存到session中。

- Class<?> types() default {}



