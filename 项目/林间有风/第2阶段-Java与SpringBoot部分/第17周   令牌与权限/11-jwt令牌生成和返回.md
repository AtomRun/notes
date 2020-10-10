# jwt令牌生成和返回

## controller

```java
@RequestMapping("token")
@RestController
public class TokenController {

    @Autowired
    private WxAuthenticationService wxAuthenticationService;

    @PostMapping("")
    public Map<String,String> getToken(@RequestBody @Validated TokenGetDTO userData) {
        Map<String,String> map = new HashMap<>();
        String token = null;
        //校验用户数据，生成token
        switch (userData.getType()) {
            case USER_WX:
                token = wxAuthenticationService.code2Session(userData.getAccount());
                break;
            case USER_EMAIL:
                //todo
            default:
                throw new NotFoundException(10003);
        }
        //哪怕是’单一字符串也要返回map，返回之后前端得到的是js对象，不然前端不好处理。
        map.put("token",token);
        return map;
    }
}
```

## service

```java
@Service
public class WxAuthenticationService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UserRepository userRepository;

    //读取配置文件
    @Value("${wx.code2session}")
    private String code2SessionUrl;
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.appsecret}")
    private String appsecret;

    public String code2Session(String code){
        //小程序提供的code
        //1. 验证用户身份，去微信验证code是否合法
            //1.1 三个参数，1 code码，2 微信小程序appid 3 微信小程序app secret

        //拼接
        String url = MessageFormat.format(this.code2SessionUrl,this.appid,this.appsecret,code);
        //调用微信服务器
        //后端发送http请求
        RestTemplate restTemplate = new RestTemplate();
        //获取微信返回的数据
        String sessionText = restTemplate.getForObject(url, String.class);
        //根据微信返回结果进行反序列化，将字符串变成类


        Map<String,Object> session = new HashMap<>();
        //使用另一种方式map&object的方式
        try {
            session = mapper.readValue(sessionText,Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return this.registerUser(session);
        //2. 返回jwt的令牌并且返回controller
    }

    private String registerUser(Map<String,Object> session){
        String openid = (String) session.get("openid");
        if (openid== null){
            throw new ParameterException(20004);
        }
        //判断用户是登录还是注册，即用户是否生成了这种记录，所以我们要去数据库查询，使用openid查询
        //如果查到了就是注册过，这里就不用查询，直接发jwt令牌，如果没法有我们就写入一条数据

        Optional<User> userOptional = userRepository.findUserByOpenid(openid);
        //为什么不使用optional?
            //如果user为空我们执行jwt序列化，
            //如果不存在，我们调用repo写入user，无论如何都要执行逻辑orElseThrow只会一端执行业务逻辑。但我们需要两端
            //所以这里最适合isPresentOfElse(consumer,runnable)
        if (userOptional.isPresent()){
            //todo 有这个user，直接返回jwt令牌
            return JwtToken.makeToken(userOptional.get().getId());
        }

        //todo 没有这个user，将user存储到数据库后再返回jwt令牌
        User user = User.builder()
                .openid(openid)
                .build();
        userRepository.save(user);
        //保存后获取用户id
        Long uid = user.getId();
        return JwtToken.makeToken(uid);
    }

}

```

### component

```java
@Component
public class JwtToken {

    //static的参数，在类加载前实例化，不能使用@Value获取值，所以要使用setJwtKey方式设置参数
    private static String jwtKey;

    private static Integer expiredTimeIn;

    private static Integer defaultScope = 8;

    @Value("${missu.security.jwt-key}")
    public void setJwtKey(String jwtKey){
        JwtToken.jwtKey = jwtKey;
    }

    @Value("${missu.security.token-expired-in}")
    public void setExpiredTimeIn(Integer expiredTimeIn){
        JwtToken.expiredTimeIn = expiredTimeIn;
    }

    public static String makeToken(Long uid){
        return getToken(uid,defaultScope);
    }

    public static String makeToken(Long uid,Integer scope){
        //scope 就是之前的scopeLevel权限分级的数数字，即也写入到jwt令牌中
        //其实我们判断一个用户是否有访问某个接口的权限，就是拿令牌中的scope和访问api的scope来比较。
        return getToken(uid,scope);
    }

    //私有方法用来写生成jwt主逻辑
    private static String getToken(Long uid,Integer scope){
        //使用第三方库，例如
        //1. jjwt
        //2. auth0
            //java提供的jwt很复杂，需要了解相关概念。
            //这里是生成令牌的过程，还有一个验证令牌的过程

        //生成令牌
        //1. 选择算法
        //传入一个随机字符串，类似盐，要足够的复杂和随机性
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);

        //获取时间
        Map<String, Date> map = JwtToken.calculateExpiredIssues();
        //2. 生成
        return JWT.create()
                //名字和值
                .withClaim("uid",uid)
                .withClaim("scope",scope)
                //设置过期时间
                .withExpiresAt(map.get("expiredTime"))
                //设置签发事件
                .withIssuedAt(map.get("now"))
                //算法
                .sign(algorithm);

    }
    //设置过期时间的转换
    private static Map<String, Date> calculateExpiredIssues(){
        Map<String,Date> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        //当前时间+过期时间
        calendar.add(Calendar.SECOND,JwtToken.expiredTimeIn);
        map.put("now",now);
        map.put("expiredTime",calendar.getTime());
        return map;
    }
}
```

## yml

```yaml
# jwt配置
missu:
  security:
    jwt-key: cleeeeee
    token-expired-in: 86400000
```

