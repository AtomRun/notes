# spec返回格式修改

```java
private List<Spec> specs;
```

直接这么写，idea会提示，List<Spec>不是基本类型，无法和数据库的字段进行对应。

## 单体JSON对象映射处理

处理

```java
private Map<String,Object> test;
```

### 编写工具类

假设需要jpa自动调用我们的类完成序列化和反序列化的过程，我们需要实现一个接口

```java
public class MapAndJson implements AttributeConverter<Map<String,Object>,String> {

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        return null;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        return null;
    }
}

```

方法1. 将模型字段转换为数据库的字段

方法2. 将数据库字段转换为实体属性

可以理解为get/set

### 将其转换为String，所以要做序列化操作

使用jackson的库，依赖注入进来

```java
@Autowired
private ObjectMapper mapper;
```

### 最终结果

```java
public class MapAndJson implements AttributeConverter<Map<String,Object>,String> {


    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @SneakyThrows
    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        Map<String,Object> t = mapper.readValue(s, HashMap.class);
        return t;
    }
}

```

### 使用

```java
@Convert(converter =  MapAndJson.class)
private Map<String,Object> test;

}
```



# 对spec下手

```java
private List<Object> specs;
```

## 创建ListAndJson list转json类

```java
public class ListAndJson implements AttributeConverter<List<Object>,String> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(List<Object> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public List<Object> convertToEntityAttribute(String s) {
        if (s==null){
            return null;
        }
        try {
            return mapper.readValue(s,List.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
```

