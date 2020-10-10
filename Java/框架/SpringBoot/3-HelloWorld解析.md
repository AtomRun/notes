# HelloWorld解析

## POM文件

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.1.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>

他的父项目是
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.3.1.RELEASE</version>
</parent>
他来管理springBoot中所有的依赖版本
```

## SpringBoot的版本仲裁中心

以后我们导入依赖默认不需要写版本

当然也有没有在dependencies中管理的的依赖，我们就需要写版本号

## 导入的如下依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### spring-boot-starter-web

> sprngBoot场景启动器

其实就是帮我们导入了WEB模块正常运行所需要的依赖。

SpringBoot将所有功能场景都抽取出来，做成一个个的Staters（启动器），当我们导入只需要引入相关场景的所有Stater，版本由SpringBoot自动管理。

# HelloWorld细节

## 入口类

```java
package com.leeup.bootspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootSpringApplication.class, args);
    }
}
```

## @SpringBootApplication

`@SpringBootApplication`:springBoot应用标注在某个类上说明这个类是个SpringBoot的主配置类。SpringBoot就应该运行这个类的`main`方法来启动springBoot应用

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication {
```

### @SpringBootConfiguration

`@SpringBootConfiguration`表示这是一个SpringBoot的配置类，进去看看发现该注解包含如下注解

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringBootConfiguration {
```

`@Configuration`这个注解就是Spring时使用的配置类注解，以前是用XML配置的形式，后来演变为使用一个类来配置Spring相关信息，只需要加上注解`@Configuration`，并且使用`@Bean`来return一个需要加载到容器中的实例，并且配置类也是一个组件

### @EnableAutoConfiguration

> 开启自动配置功能的意思

查看启动类不难发现，我们启动类没有做任何配置，但我们springMVC和应用都能正常使用，包括包扫描之类的功能，这都是因为这个注解

以前我们需要配置的功能，现在都不需要了，SpringBoot自动帮我们配置，**@EnableAutoConfiguration**告诉springBoot开启自动配置功能，这样自动配置才能生效

**我们点击去注解查看一下**

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import(AutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration {
```

#### **@AutoConfigurationPackage**

> 自动配置包

点击注解查看

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(AutoConfigurationPackages.Registrar.class)
public @interface AutoConfigurationPackage {
```

##### @Import(AutoConfigurationPackages.Registrar.class)

Spring的底层注解`@Import`，给容器中导入一个组件，导入哪些组件由AutoConfigurationPackages.Registrar.class类来指定

```java
@Override
public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
    register(registry, new PackageImports(metadata).getPackageNames().toArray(new String[0]));
}
```

其中`register(registry, new PackageImports(metadata).getPackageNames().toArray(new String[0]));`

这里的metadata，即`AnnotationMetadata metadata`注解标注的元信息，即标注的是什么信息，标注在哪里。

`getPackageNames()`获取配置类所在的包名

##### 该注解作用：

将主配置类（@SpringBootApplication标注的类）的所在包机器下面所有子包里面的组件扫描到spring容器中。

#### @Import(AutoConfigurationImportSelector.class)

> 给容器导入后面这个组件

- 翻译：开启自动配置类的选择器

将所有需要导入的组件以全类名的方式返回，这些组件就会被添加到容器中。

会给容器中导入非常多的自动配置类（xxxAutoConfiguration），就是给容器中导入这个场景所需要的所有组件，并配置这些组件。

有了自动配置类，免去了我们手动编写配置注入功能组件的工作。

```java
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
    List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
                                                getBeanClassLoader());
    Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you "
                    + "are using a custom packaging, make sure that file is correct.");
    return configurations;
}
```

`SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),getBeanClassLoader());`

- 其中的loadFactoryNames

```java
public static List<String> loadFactoryNames(Class<?> factoryType, @Nullable ClassLoader classLoader) {
    String factoryTypeName = factoryType.getName();
    return loadSpringFactories(classLoader).getOrDefault(factoryTypeName, Collections.emptyList());
}
```

- 这里的loadSpringFactories方法

```java
private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
    MultiValueMap<String, String> result = cache.get(classLoader);
    if (result != null) {
        return result;
    }

    try {
        Enumeration<URL> urls = (classLoader != null ?
                                 classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
        result = new LinkedMultiValueMap<>();
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            UrlResource resource = new UrlResource(url);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            for (Map.Entry<?, ?> entry : properties.entrySet()) {
                String factoryTypeName = ((String) entry.getKey()).trim();
                for (String factoryImplementationName : StringUtils.commaDelimitedListToStringArray((String) entry.getValue())) {
                    result.add(factoryTypeName, factoryImplementationName.trim());
                }
            }
        }
        cache.put(classLoader, result);
        return result;
    }
    catch (IOException ex) {
        throw new IllegalArgumentException("Unable to load factories from location [" +
                                           FACTORIES_RESOURCE_LOCATION + "]", ex);
    }
}
```

```java
Enumeration<URL> urls = (classLoader != null ?
                         classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
                         ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
```

上面这句是获取一个资源，我们点进资源看看

```java
public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories";
```

SpringBoot在启动的时候从类路径META-INF/spring.factories中获取@EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到容器中，自动配置类就生效了

查看`META-INF/spring.factories`文件可以发现，其中的类都有@Bean组件，在容器启动的时候就自动配置加载到容器中了。