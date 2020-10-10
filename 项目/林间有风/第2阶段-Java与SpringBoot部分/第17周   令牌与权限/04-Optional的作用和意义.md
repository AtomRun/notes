# Optional的作用和意义

1. 用于解决空指针的问题。

```java
@GetMapping("/name/{name}/with_spu")
public Theme getThemeByNameWithSpu(@PathVariable(name = "name") String themeName){
    Optional<Theme> optionalTheme = this.themeService.findByName(themeName);
    return optionalTheme.orElseThrow(()-> new NotFoundException(30003));
}
```

Optional简化代码，让代码更加简洁

## 思想

Optional强制让我们判空

## 意义

给我们提示需要注意空值

## 具体用法

上面其实可以直接返回theme，但是我们使用了optionalTheme，即将theme放到Option中。

Optional会提供额外的方法帮助我们进行判空的操作。这样我们就不需要进行if之类的判空处理

`optionalTheme.orElseThrow`如果optinalTheme不是空，直接返回theme return到前端，如果是空，抛出异常

### 



