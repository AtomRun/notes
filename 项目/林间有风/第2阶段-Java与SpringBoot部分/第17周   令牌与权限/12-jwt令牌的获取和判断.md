# jwt令牌的获取和判断

1. 如何判断用户的令牌是不是合法的?令牌的校验
   1. 如何校验令牌？判断字符串是不是jwt令牌，是如何判断过期问题？
   2. 如何截取用户的jwt？

## 如何获取用户的令牌

用户在前端将令牌放到http的header中，我们在服务端的拦截http header中的令牌，所以这是一个全局机制的方案，直接在全局的角度将令牌处理。

## 如何校验？

```java
//Claim可以读取到令牌，有两个功能
//1. 验证令牌是不是合法的，合法的话就去读取Claim，并且将数据返回
//2.
public Optional<Map<String, Claim>> getClaims(String token){

    //初始化解析后的jwt
    DecodedJWT decodedJWT;

    //生成的时候选择了算法，解析的时候也需要算法。
    Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);//仍然放入盐，like钥匙
    //解析验证
    JWTVerifier jwtVerifier = JWT.require(algorithm).build();
    try {
        decodedJWT = jwtVerifier.verify(token);
    } catch (JWTVerificationException e) {
        //访问接口都会带jwt，不记录日志了
        //失败
        return Optional.empty();
    }
    return Optional.of(decodedJWT.getClaims());
}
```

