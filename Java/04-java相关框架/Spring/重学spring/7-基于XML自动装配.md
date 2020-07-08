# 基于XML的自动装配

## 之前的手动赋值

```xml
<bean id="car" class="xxxx">
	<property name="CarName" value="宝马"></property>
    <property name="color" value="白色"></property>
</bean>

<!-- 为Person里面的自定义类型的属性赋值-->
<bean id="Person" class="xxxx">
    <property name="car" ref="car"></property>
</bean>
```

## 自动赋值（自动装配）

```xml
<bean id="car" class="xxxx">
	<property name="CarName" value="宝马"></property>
    <property name="color" value="白色"></property>
</bean>

<!-- 为Person里面的自定义类型的属性赋值-->
<bean id="Person" class="xxxx" autowire="byName">
</bean>
```

- autowire="default/no"  不自动装配，不自动为car赋值

- autowire="byName" 按照名字

  - Person中有一个Car属性，以属性名为id去容器中找这个组件，给他赋值，找不到就是Null

- autowire="byType"

  - 以属性类型去容器中查找这个属性
  - 如果容器中有多个相同类型的bean
  - 没找到也是装配为null

- autowire="constructor"

  - 按照构造器赋值，即Person设置一个只有Car的构造器

  1. 先按照有参构造器进行赋值
     1. 先按照参数类型进行装配，发现类型是Car并且容器中正好是Car就注入
     2. 没有就装配Null
     3. 如果按照类型找到了多个，就根据参数的名作为ID继续匹配