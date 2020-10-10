# SpringBoot发现机制和思想

`GlobalExceptionAdvice`现在处理了未知异常，也就是通用exception，还处理了HttpException

但是后面参数校验的时候，由于springBoot内置校验机制，判断校验失败的时候，会抛出另外的异常，并不是HTTP Exception，但是参数校验事实上是一种JSR的规范。

## 发现机制

在其它语言的web框架中，可能controller需要注册，但是spring boot中的controller为什么没有进行注册，我们访问了就直接知道要执行哪个方法呢？

原理就是注解的作用，springBoot启动的时候扫描了注解就知道你的类的作用

## 思想

以前我们是主动注册给spring，告诉spring我哪些类是干嘛的，需要加载。

但是现在的spring是自己发现，通过扫描注解，现在方法相反了，而且简化了这种样板式的注册代码