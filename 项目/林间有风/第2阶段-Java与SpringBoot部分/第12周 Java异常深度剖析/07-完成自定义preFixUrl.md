# 完成preFixUrl

 ## 首先

```yaml
# 指定api是是所有controller的根包
missyou.api-package: com.leeup.missyou.api
```

## 读取配置

```java
@Value("${missyou.api-package}")
private String apiPackagePath;
```

## 获取前缀

```java
//修改路由信息
private String getPrefix(Class<?> handleType){
    String packageName = handleType.getPackage().getName();
    String dotPath = packageName.replaceAll(this.apiPackagePath,"");
    return dotPath.replace(".","/");
}
```

## 修改路径

RequestMappingInfo有一个静态方法专门用来合并URL

```java
@Override
protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
    RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
    if (mappingInfo != null){
        String prefix = this.getPrefix(handlerType);
        return RequestMappingInfo.paths(prefix).build().combine(mappingInfo);
    }
    return mappingInfo;
```

获取处理后的prefix，然后使用RequestMppingInfo进行拼接，paths是获取的prefix，combine拼接上我们原有的，然后return

RequestMappingInfo提供了一个方法，给我们用来合并URL