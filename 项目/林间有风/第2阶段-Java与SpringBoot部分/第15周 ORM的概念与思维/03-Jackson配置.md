# Jackson配置

## 让序列化返回的字段使用_连接符

即snake_case形式，默认驼峰形式

```yml
jackson:
  property-naming-strategy: SNAKE_CASE
```

## 让返回到前端的时间格式是时间戳格式

默认是如下标准时间格式

```json 
create_time": "2020-08-24T03:48:16.158+00:00
```

转换为时间戳格式就是格林威治时间1970到现在的时间秒的总和，使用如下配置

```yml
jackson:
    serialization:
      WRITE_DATES_AS_TIMESTAMPS: true
```

## 向前端不返回某个字段

使用@JsonIgnore

```java
@JsonIgnore
private Date createTime;
@JsonIgnore
private Date updateTime;
@JsonIgnore
private Date deleteTime;
```



