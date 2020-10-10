# 禁止jpa生成物理外键

在一方增加一个注解，使用废弃的属性

```java
@ForeignKey(name="null")
```

但是这个注解已经被替换掉去掉了。

在多方增加注解

```java
@JoinColumn(foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false,updatable = false,name = "bannerId")
```

但是会发现是上面这个注解是无效的，仍然会产生外键，纵然可以使用也不会推荐，因为，太长太难用了

## 期望，总体配置关闭外键

直接不用模型生成，没想到吧！哈哈哈哈哈哈哈