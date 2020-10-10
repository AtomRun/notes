# jwt全流程

1. code换用户的openid
2. user id -> uid
3. 注册 -> openid写入user表，如果用户注册过了，即第二次进来，user表一定有这个用户的信息，这个时候我们就要查询uid
   1. 查询可以理解为登录
4. uid代表了我们系统的唯一标识，使用openid也可以，但是openid应该有一定安全性不应该传到前端。
5. uid写入jwt令牌中，然后将jwt令牌返回到小程序中