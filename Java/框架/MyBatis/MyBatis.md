# MyBatis

# MyBatis的反射工具箱

运行时拿到任何Java对象的属性和方法

## Reflector的核心流程

```java
private final Class<?> type;
private final String[] readablePropertyNames;
private final String[] writablePropertyNames;
private final Map<String, Invoker> setMethods = new HashMap<>();
private final Map<String, Invoker> getMethods = new HashMap<>();
private final Map<String, Class<?>> setTypes = new HashMap<>();
private final Map<String, Class<?>> getTypes = new HashMap<>();
private Constructor<?> defaultConstructor;
```

1. 用type字段记录传入的Class对象
2. 通过反射拿到Class类的全部构造方法，并进行遍历
3. 读取Class类的getter方法
4. 读取Class类的setter方法
5. 读取Class中没有getter/setter方法的字段，生成对应的invoker对象。
6. 根据前三步构造的getMethods/setMethods集合的keySet初始化readablePropertyNames/writeablePropertyNames集合
7. 遍历构造的readablePropertyNames/writeablePropertyNames集合