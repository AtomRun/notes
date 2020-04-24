# AOP简单配置

如何将这个类（切面类）中的这些方法（通知方法）动态的在目标方法各个位置切入

1. 导入面向切面的包spring-aspects（基础包）
2. cglib包
3. aopalliance
4. aspectj.weaver三个加强版本

## 好处

1. 即使目标对象没有实现任何接口也能创建动态代理

## 配置

1. 将目标类和切面类（封装了通知方法，即在目标方法执行前后执行的方法），加入到IOC容器中
2. 使用注解将两个类加入到IOC容器
3. 开启spring包扫描
4. 还应该告诉Spring到底哪个是切面类，使用@Aspect注解，告诉Spring你标注的类是切面类
5. 告诉Spring，切面类的方法在何时何地运行
   1. 在执行目标方法执行之前执行
      1. @Before  前置通知
   2. 在目标方法正常执行完成后执行
      1. @After  后置通知
   3. 在目标方法出现异常执行 
      1. @AfterReturning  返回通知
   4. 目标方法结束执行
      1. @AfterThrowing  异常通知
   5. 环绕通知@Around

## 写法

1. @Before("exclution(访问权限符 返回值类型 方法签名)")
2. @After("exclution(访问权限符 返回值类型 方法.*)")
3. @AfterReturnning("exclution(访问权限符 返回值类型 方法.*)")
4. @AfterThrowing("exclution(访问权限符 返回值类型 方法.*)")

## 开启AOP功能

1. 配置文件中开启基于AOP功能

   1. 开启AOP名称空间

   ```xml
   <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
   ```

# 细节

1. IOC容器中保存的是组件的代理对象
2. CGLib为没有接口的组件也能创建代理对象
   1. 实现了接口使用动态代理，
   2. 没有接口Spring会创建一个内部类实现类中的所有方法
3. 切入点表达式写法
   1. 固定格式：execution(访问权限符 返回值类型 方法全类名(参数表))
   2. 通配符
      1. *匹配一个或者多个字符

# @Around 环绕通知

> 上面通知的合体

