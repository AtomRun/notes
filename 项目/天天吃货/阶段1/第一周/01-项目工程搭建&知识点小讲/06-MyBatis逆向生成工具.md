# MyBatis逆向生成工具

> mybatis-gennerator

```yaml
############################################################
# # mybatis mapper 配置 #
############################################################
# 通用 Mapper 配置
mapper:
  mappers: com.leeup.my.mapper.MyMapper
  not-empty: false # 再进行数据库操作，判断表达式，username!=null，是否追加username!=''，它会帮我们自动追加，这里建议自己写
  identity: MYSQL

```



## 注意

逆向工程的代码生成方式是追加式的，而不是覆盖式的，假设连续执行两次逆向，在xml中会生成两遍id为BaseResultMap的代码，造成重复和报错。