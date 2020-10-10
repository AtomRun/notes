# LocalUser的设计

当我们想直接获取userId，但是不能使用前端直接明文发送的方式来获取，我们如何获取呢？

```java
public class LocalUser {

    //如何保存多用户？使用threadLocal
    private static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

    //静态变量无法保证多用户的信息，因为static的信息是共享的。
    //多线程操作同一个变量不安全，因为我们是取出单用户的id放到了static中，并不是从数据库中拿出来的。
    //private static User user;

    //设置user
    public static void setUser(User user, Integer scope){
        //LocalUser.user = user;
        HashMap<String, Object> map = new HashMap<>();
        map.put("user",user);
        map.put("scope",scope);
        LocalUser.threadLocal.set(map);
    }

    //获取用户
    public static User getUser(){
        //1. 获取userModel的好处就避免了频繁查询数据库，
        //2. 直接返回uid不会那么方便，每次获取user都需要查询数据库，但是占用内存比较小
        Map<String, Object> map = LocalUser.threadLocal.get();
        User user = (User) map.get("user");
        return user;
    }
    public static Integer getScope() {
        //1. 获取userModel的好处就避免了频繁查询数据库，
        //2. 直接返回uid不会那么方便，每次获取user都需要查询数据库，但是占用内存比较小
        Map<String, Object> map = LocalUser.threadLocal.get();
        Integer scope = (Integer) map.get("scope");
        return scope;
    }

    //清除资源，不能一直添加不释放，不然就一直越来越多
    public static void clear(){
        LocalUser.threadLocal.remove();
    }
}
```

## 调用方法

```java
@Component
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IUserService userService;

    public PermissionInterceptor() {
        super();
    }


    //请求进入controller之前回调的函数
    //boolean值表达的是，校验token如果不通过就不放行，那就返回false
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截器逻辑
        //1. 获取到请求的token
        //2. 验证token
        //3. 如果访问的公开的api，验证不通过也允许访问。
        //4. 非公开的API访问的方式，token合法没有过期，
        //5. token中的scope能够读取出来。比较scope和level的大小，即有没有权限访问

        Optional<Object> scopeLevel = this.getScopeLevel(handler);
        if (!scopeLevel.isPresent()){
            //scopeLevel不存在的情况
            //如果当前API是公开API，后面获取令牌对比的过程就没必要进行了
            return true;
        }

        //获取前端的token，使用request
        String bearerToken = request.getHeader("Authorization");//前端约定放到header，这个字符串是键
        if (StringUtils.isEmpty(bearerToken)){
            //没有令牌,前面的判断如果是公共API直接返回true了，但是如果执行到这，说明没有token还想访问私有API，直接抛出异常
            throw new UnAuthenticatedException(10004);
        }
        //有token的情况
        if (!bearerToken.startsWith("Bearer")){
            throw new UnAuthenticatedException(10004);
        }
        String tokens[] = bearerToken.split(" ");//去掉关键字后的token，取出真正的token
        if (!(tokens.length == 2)){
            throw new UnAuthenticatedException(10004);
        }
        //确定了不是空，前面也有关键字，就可以提取了
        String token = tokens[1];
        //解析token
        Optional<Map<String, Claim>> optionalMap = JwtToken.getClaims(token);
        //处理claims是空的情况
        Map<String,Claim> map = optionalMap.orElseThrow(
                ()-> new UnAuthenticatedException(10004));
        boolean valid = this.hasPermission((ScopeLevel) scopeLevel.get(),map);

        //pre的时候调用
        if (valid){
            this.setToThreadLocal(map);
        }
        return valid;
    }

    //springboot渲染页面之前给我们一个修改modelAndView的机会
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    //获取用户uid，再将uid传入service对象查询后写入到localUser类中
    //因为这是拦截器，每当有请求发送就会拦截并且执行
    private void setToThreadLocal(Map<String,Claim> map){
        Long uid  = map.get("uid").asLong();
        Integer scope = map.get("scope").asInt();
        User user = userService.getUserById(uid);
        //localUser
        LocalUser.setUser(user,scope);
    }

    //主要用于清理资源，
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //执行完毕清理
        LocalUser.clear();
        super.afterCompletion(request, response, handler, ex);
    }
}
```