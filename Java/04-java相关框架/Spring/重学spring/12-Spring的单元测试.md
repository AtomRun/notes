# Spring的单元测试

## 导入Spring的单元测试包

- spring-test-4.0.0.RELEASE.jar

```JAVA
// @ContextConfiguration(locations="xxx")使用这个注解指定spring配置文件位置
// @RunWith()指定用哪种驱动进行单元测试，默认就是junit
// (SpringJUnit4ClassRunner.class)使用Spring的单元测试来执行标了@Test注解的测试方法  
//@Test 只是由JUnit执行的
@ContextConfiguration(locations="xxx")
@RunWith(SpringJUnit4ClassRunner.class)
public class IOCTest{
    
}
```

# 好处

不用ioc.getBean来获取组件，直接@AutoWired自动装配