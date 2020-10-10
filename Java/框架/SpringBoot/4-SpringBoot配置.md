# SpringBoot配置

## 配置文件

### 两种配置文件

`application.properties`和`application.yml`

配置文件的作用就是来修改SpringBoot的默认值，因为SpringBoot在底层都有默认值，当我们想要修改就要通过配置文件。

![](https://i.loli.net/2020/07/24/u8fslC7YawrzpOW.png)

配置文件yml还是properties他们都能获取到值;
如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value 
如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties

## PropertySource&lmportResource

@PropertySource 读取指定路径的配置文件

@lmportResource 导入Spring的配置文件，让配置文件里面的内容生效

```java
@lmportResource(locations = {"classpath:beans.xml"})
```

## SpringBoot推荐的给容器中添加组件的方式

> SpringBoot更推荐使用配置类的方式配置类=配置文件

@Configuration指明当前类是一个配置类，就是用来替代之前的xml配置文件

