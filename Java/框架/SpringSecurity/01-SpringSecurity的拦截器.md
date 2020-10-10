# SpringSecurity的过滤器

## threadLocal

threadLocal中存放的值是线程中共享的，线程中互斥的，目的是让某些参数在线程中共享，避免使用参数传递，这样处理之后能够优雅解决某些线程并发问题。

使用threadLocal的时候在线程结束的时候，一定要将当前threadLocal里面的信息移除，threadLocal提供了remove方法，只需要调用即可

### ThreadLocalMap

## 权限拦截

### SecurityContextPersistenceFilter

### LogOutFilter

只处理注销请求，销毁用户session，清空securityContextHolder，重定向到注销页面

### AbstractAuthticationProcessingFilter

通过用户名和密码判断用户

### DefaultLoginPageGenneratingFilter

生成默认登录页

### BasicAuthenticationFilter

进行Basic验证