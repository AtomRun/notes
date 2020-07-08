# String&Long源码阅读

> 劳动是一切知识的源泉。——陶铸

## String

### 不变性

经常听人说，HashMap的key建议使用使用不可变类，比如String这种不可变类，这里的不可变指的是，类的值一旦被初始化，就不能被修改了，如果再次修改，将会是新的类，我们写个demo来演示一下。

```java
String s = "hello";
s = "world 
```

代码上来看，好像s的值被修改了，但是从debug日志来看，其实是s的内存地址被修改了，也就是说s="world"这个看似简单的赋值，其实是将之前的s的引用指向了新的String

![图片描述](http://img1.sycdn.imooc.com/5d5fc04a0001c6a508840096.png)![图片描述](http://img1.sycdn.imooc.com/5d5fc06400019cc210540090.png)