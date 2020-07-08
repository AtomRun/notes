# 利用AOP和日志监测Service执行时间并报告

## 引入AOP

```xml
<!--        AOP-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

## 配置

```java
package com.leeup.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ServiceLogAspect
 * @Description 监听service执行时间的切面
 * @Author clee
 * @Date 2020/7/2 10:45
 * @Version 1.0
 **/
@Aspect
@Configuration
public class ServiceLogAspect {
    /**
     * aop五种类型
     * 1. 前置通知：方法调用前调用
     * 2. 后置通知：方法正常调用之后调用
     * 3. 环绕通知：方法调用前后，都分别执行的通知
     * 4. 异常通知：如果在方法执行期间发生异常则通知
     * 5. 最终通知：方法调用之后执行，可以理解为finally
     */
    //这里使用环绕通知

    public static final Logger log =
            LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     * 利用AOP使用环绕通知注解@Around，并且要写上切面表达式
     * execution() 代表所有要执行的表达式主体
     * 第一处 * 代表方法返回类型 * 代表所有类型
     * 第二处 包名代表aop要监控的类所在的包
     * 第三处 后面..代表该包以及其子包所有类方法
     * 第四处 * 代表类名，*代表所有的类
     * 第五处 *(..) *代表类中的方法名，后方的(..)代表方法的参数，代表方法可以有任何参数
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.leeup.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //slf4j两个大括号表示两个占位符，.代表某个类的某个方法
        //getClass表示监听的目标类
        //获得类的方法名
        log.info("============= 开始执行 {}.{} =============",
                joinPoint.getClass(),
                joinPoint.getSignature().getName());

        //开始时间，执行之前开始计时
        long beginTime = System.currentTimeMillis();

        //执行目标service
        //object是返回的数据
        Object result = joinPoint.proceed();
        //记录结束时间
        long endTime = System.currentTimeMillis();
        //总共花费的时间
        long takeTime = endTime - beginTime;

        //根据时间判断
        if (takeTime >3000 ){
            //超过300毫秒使用error级别
            log.error("============= 执行结束，耗时{}毫秒 =============",takeTime);
        }else if (takeTime>2000){
            log.warn("============= 执行结束，耗时{}毫秒 =============",takeTime);
        }else {
            log.info("============= 执行结束，耗时{}毫秒 =============",takeTime);
        }
        return result;
    }
}
```

