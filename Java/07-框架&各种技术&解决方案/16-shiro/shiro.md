### 第一讲 认识shiro
1. 什么是shiro?
    1. Apache Shiro是一强大而灵活的开源安全框架，它干净利落地处理身份认证，授权，企业会话管理和加密。
    2. 它的首要目标是便于使用和理解，目前还增加了多线程并发，缓存的支持。可以完成认证，授权，会话管理，加密，缓存等功能可以说它是一个RBAC式的安全框架。
2. 为什么学习shiro?
    1. 在java的世界中，安全管理框架有spring security 和shiro spring security 主要依赖spring并且相对复杂。当然spring security考虑的安全策略比shiro更加复杂。
    2. shiro相对spring security更简单，而且它比较独立，可以在j2se中使用。还可以在j2ee中使用，并且在分布式集群环境下也可以使用。
3. shiro的结构体系
![image](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%A1%86%E6%9E%B6%26%E5%90%84%E7%A7%8D%E6%8A%80%E6%9C%AFimages/shiro/1.png)
    1. Authentication：认证
        1. 验证用户是否合法，也就是登录
    2. Authorization：授权
        1. 授予谁具有访问某些资源的权限。
    3. Session Management：会话管理
        1. 用户登录，就是一次会话，这个Session Management进行管理登录的主体，并且可以将登录信息进行持久化，不管是什么应用中
    4. Cryptography：加密
        1. 提供了常见的一些加密算法，使得在应用中可以很方便的实现数据安全，并且使用很便捷。
    5. Web support：web应用支持
        1. shiro可以很方便集成到web应用程序中。
    6. Caching：缓存
        1. shi'ro提供了对缓存的支持，支持多种缓存架构，如：ehcache，还支持缓存数据库：如redis
    7. Concurrency：支持多线程并发访问
    8. Testing：支持测试
    9. RunAs：支持一个用户在允许的前提下使用另外一个身份登录
    10. RememberMe：在会话中记住用户的身份，即记住我
4. shiro的架构
![image]()
    1. Subject
        1. Subject即主体，外部应用与subject进行交互，subject记录了当前操作用户，将用户的概念理解为当前操作的主体，可能是一个通过浏览器请求的用户，也可能是一个运行的程序。	
        2. Subject在shiro中是一个接口，接口中定义了很多认证授相关的方法，外部程序通过subject进行认证授，而subject是通过SecurityManager安全管理器进行认证授权
    2. SecurityManager
        1. SecurityManager即安全管理器，对全部的subject进行安全管理，它是shiro的核心，负责对所有的subject进行安全管理。通过SecurityManager可以完成subject的认证、授权等，实质上SecurityManager是通过Authenticator进行认证，通过Authorizer进行授权，通过SessionManager进行会话管理等。
        2. SecurityManager是一个接口，继承了Authenticator, Authorizer, SessionManager这三个接口。
    3. Authenticator
        1. Authenticator即认证器，对用户身份进行认证，Authenticator是一个接口，shiro提供ModularRealmAuthenticator实现类，通过ModularRealmAuthenticator基本上可以满足大多数需求，也可以自定义认证器。
    4. Authorizer
        1. Authorizer即授权器，用户通过认证器认证通过，在访问功能时需要通过授权器判断用户是否有此功能的操作权限。
    5. realm
        1. Realm即领域，相当于datasource数据源，securityManager进行安全认证需要通过Realm获取用户权限数据，比如：如果用户身份数据在数据库那么realm就需要从数据库获取用户身份信息。
        2. 注意：不要把realm理解成只是从数据源取数据，在realm中还有认证授权校验的相关的代码。
    6. sessionManager
        1. sessionManager即会话管理，shiro框架定义了一套会话管理，它不依赖web容器的session，所以shiro可以使用在非web应用上，也可以将分布式应用的会话集中在一点管理，此特性可使它实现单点登录。
    7. SessionDAO
        1. SessionDAO即会话dao，是对session会话操作的一套接口，比如要将session存储到数据库，可以通过jdbc将会话存储到数据库。
    8. CacheManager
        1. CacheManager即缓存管理，将用户权限数据存储在缓存，这样可以提高性能。
    9. Cryptography
        1.  Cryptography即密码管理，shiro提供了一套加密/解密的组件，方便开发。比如提供常用的散列、加/解密等功能。

### 第二讲 认证
#### 基本概念
1. 身份验证
    1. 即在应用中谁能证明他就是他本人。一般提供如他们的身份ID 一些标识信息来表明他就是他本人。如提供身份证，用户名/密码来证明。
    2. 在 shiro 中，用户需要提供principals （身份）和credentials（证明）给shiro，从而应用能验证用户身份：
2. principals
    1. 身份，即主体的标识属性，可以是任何东西，如用户名、邮箱等，唯一即可。
    2. 一个主体可以有多个principals，但只有一个Primary principals，一般是用户名/密码/手机号。
3. credentials
    1. 证明/凭证，即只有主体知道的安全值，如密码/数字证书等。
    2. 最常见的principals和credentials组合就是用户名/密码了。接下来先进行一个基本的身份认证。

#### 认证流程
![image]()
#### 入门程序(用户登录和退出)
1. 创建java工程
2. 加入相关jar
    * commons-beanutils-1.9.2.jar
    * commons-logging-1.2.jar
    * junit-4.10.jar
    * shiro-all-1.2.3.jar
    * slf4j-api-1.7.7.jar
    * log4j-1.2.17.jar
    * slf4j-log4j12-1.7.5.jar
3. log4j.properties 配置文件
```properties
log4j.rootLogger=debug, stdout
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d %p [%c] - %m %n
```
4. 配置shiro环境文件shiro.ini
    1. 通过Shiro.ini配置文件初始化SecurityManager环境。
```properties
[users]
zhangsan=1111
lisi=1111
```
5. 代码实现
```java
//用户登录和退出
	@Test
	public void testAuthenticator(){
		// 构建SecurityManager工厂，IniSecurityManagerFactory可以从ini文件中初始化SecurityManager环境
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//通过工厂获得SecurityManager实例
		SecurityManager securityManager = factory.getInstance();
		//将securityManager设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		//获取subject实例
		Subject subject = SecurityUtils.getSubject();
		//创建用户名,密码身份验证Token
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "1111");
		try {
			//登录，即身份验证
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			//身份认证失败
		}
		//断言用户已经登录
		Assert.assertEquals(true, subject.isAuthenticated()); 
		//退出
		subject.logout();
	}

```

#### 自定义Realm
* Shiro默认使用自带的IniRealm，IniRealm从ini配置文件中读取用户的信息，大部分情况下需要从系统的数据库中读取用户信息，所以需要自定义realm。
1. Realm接口
![image]()
    1. 最基础的是Realm接口，CachingRealm负责缓存处理，AuthenticationRealm负责认证，AuthorizingRealm负责授权，通常自定义的realm继承AuthorizingRealm。
2. 自定义Realm实现
```java
/**
 * 自定义Realm实现
 * @author 邹波
 * @version 1.0
 * @date 2016-1-21
 */
public class UserRealm extends AuthorizingRealm {
	@Override
	public String getName() {
		return "UserRealm";
	}
	//用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//从token中获取身份信息
		String username = (String)token.getPrincipal();
		//根据用户名到数据库中取出用户信息  如果查询不到 返回null
		String password = "1111";//假如从数据库中获取密码为1111
		//返回认证信息 
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());
		return simpleAuthenticationInfo;
	}
	//用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		return null;
	}
}
```
3. 配置Realm
    1. 需要在shiro.ini配置realm注入到securityManager中。
```properties
[main]
#自定义 realm
userRealm=cn.siggy.realm.UserRealm
#将realm设置到securityManager
securityManager.realms=$userRealm
``` 
4. 测试
    1. 同上
#### 散列算法
1. 散列算法一般用于生成数据的摘要信息，是一种不可逆的算法，一般适合存储密码之类的数据，常见的散列算法如MD5、SHA等。一般进行散列时最好提供一个salt（盐），比如加密密码“admin”，产生的散列值是“21232f297a57a5a743894a0e4a801fc3”，可以到一些md5 解密网站很容易的通过散列值得到密码“admin”，即如果直接对密码进行散列相对来说破解更容易，此时我们可以加一些只有系统知道的干扰数据，如用户名和ID（即盐）；这样散列的对象是“密码+用户名+ID”，这样生成的散列值相对来说更难破解。
2. MD5算法
```java
/**
 * 
 * @author 邹波
 * @version 1.0
 * @date 2016-1-21
 */
public class ShiroTest {
	//shiro提供了现成的加密类  Md5Hash
	@Test
	public void testMd5(){
		//MD5加密
		String password = new Md5Hash("1111").toString();
		System.out.println("加密后："+password);
		//加盐  salt  默认一次散列
		String password_salt=new Md5Hash("1111", "siggy").toString();
		System.out.println("加盐后："+password_salt);
		//散列2次
		String password_salt_2 = new Md5Hash("1111", "siggy", 2).toString();
		System.out.println("散列2次："+password_salt_2);
		//使用SimpleHash
		SimpleHash hash = new SimpleHash("MD5", "1111", "siggy", 2);
		System.out.println("simpleHash:"+hash.toString());
	}
}
```
3. 在自定义Realm中使用散列
    1. Realm实现代码
```java
public class UserRealm extends AuthorizingRealm {
	@Override
	public String getName() {
		return "UserRealm";
	}
	//用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//从token中获取身份信息
		String username = (String)token.getPrincipal();
		//根据用户名到数据库中取出用户信息  如果查询不到 返回null
		//按照固定规则加密码结果 ，此密码 要在数据库存储，原始密码 是1111，盐是siggy 2次散列
		String password = "1620d20433da92e2523928e351e90f97";//假如从数据库中获取密码为1111
		//返回认证信息   
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, 
				password, ByteSource.Util.bytes("siggy"),this.getName());
		return simpleAuthenticationInfo;
	}
	//用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		return null;
	}
}

```
4. Realm配置
    1. Shiro.ini 在配置文件中，需指定凭证匹配器
```properties
[main]
#定义凭证匹配器
credentialsMatcher=org.apache.shiro.authc.credential.HashedCredentialsMatcher
#散列算法
credentialsMatcher.hashAlgorithmName=md5
#散列次数
credentialsMatcher.hashIterations=2

#将凭证匹配器设置到realm
userRealm=cn.siggy.realm.UserRealm
userRealm.credentialsMatcher=$credentialsMatcher
securityManager.realms=$userRealm
```
5. 测试
    1. 同上

### 第三讲 授权
* 授权，也叫访问控制，即在应用中控制谁能访问哪些资源（如访问页面/编辑数据/页面操作等）。
* 在授权中需了解的几个关键对象：主体（Subject）、资源（Resource）、权限（Permission）、
角色（Role）。
1. 关键对象介绍
    1. 主体
        1. 主体，即访问应用的用户，在Shiro中使用Subject代表该用户。用户只有授权后才允许访问相应的资源。
    2. 资源
        1. 在应用中用户可以访问的任何东西，比如访问JSP 页面、查看/编辑某些数据、访问某个业务方法、打印文本等等都是资源。用户只要授权后才能访问。
    3. 权限
        1. 安全策略中的原子授权单位，通过权限我们可以表示在应用中用户有没有操作某个资源的权力。即权限表示在应用中用户能不能访问某个资源，如：访问用户列表页面查看/新增/修改/删除用户数据（即很多时候都是CRUD（增查改删）式权限控制）打印文档等等。。。
    4. 角色
        1. 角色代表了操作集合，可以理解为权限的集合，一般情况下我们会赋予用户角色而不是权限，即这样用户可以拥有一组权限，赋予权限时比较方便。典型的如：项目经理、技术总监、CTO、开发工程师等都是角色，不同的角色拥有一组不同的权限。
2. 授权流程
![image]()
    1. 流程如下
        1. 首先调用Subject.isPermitted*/hasRole*接口，其会委托给SecurityManager，而SecurityManager接着会委托给Authorizer
        2. Authorizer是真正的授权者，如果我们调用如isPermitted(“user:view”)，其首先会通过PermissionResolver把字符串转换成相应的Permission实例
        3. 在进行授权之前，其会调用相应的Realm获取Subject相应的角色/权限用于匹配传入的角色/权限
        4. Authorizer会判断Realm的角色/权限是否和传入的匹配，如果有多个Realm，会委托给ModularRealmAuthorizer 进行循环判断，如果匹配如isPermitted*/hasRole*会返回true，否则返回false表示授权失败。
3. 授权方式
    1. Shiro 支持三种方式的授权：
        1. 编程式：通过写if/else 授权代码块完成：
```java
Subject subject = SecurityUtils.getSubject();
if(subject.hasRole(“admin”)) {
//有权限
} else {
//无权限
}
```
        2. 注解式：通过在执行的Java方法上放置相应的注解完成：
```java
@RequiresRoles("admin")
public void hello() {
//有权限
}
```
    没有权限将抛出相应的异常
        3. JSP/GSP 标签：在JSP/GSP 页面通过相应的标签完成：
```java
<shiro:hasRole name="admin">
<!— 有权限—>
</shiro:hasRole>
```
4. 授权实现
    1. 1在ini配置文件配置用户拥有的角色及角色-权限关系（shiro-permission.ini）
```properties
[users]
zhangsan=1111,role1,role2
lisi=1111,role1
[roles]
role1=user:create,user:update
role2=user:create,user:delete
```
    2. 规则：“用户名=密码，角色1，角色2” “角色=权限1，权限2”，即首先根据用户名找到角色，然后根据角色再找到权限；即角色是权限集合；Shiro 同样不进行权限的维护，需要我们通过Realm返回相应的权限信息。只需要维护“用户——角色”之间的关系即可。
    3. 权限字符串的规则是：“资源标识符：操作：资源实例标识符”，意思是对哪个资源的哪个实例具有什么操作，“:”是资源/操作/实例的分割符，权限字符串也可以使用*通配符。
    4. 例子：
        1. 用户创建权限：user:create，或user:create:*
        2. 用户修改实例001的权限：user:update:001
        3. 用户实例001的所有权限：user：*：001
    5. 实现代码
```java
/**
 * 
 * @author 邹波
 * @version 1.0
 * @date 2016-1-21
 */
public class ShiroTest {
	//用户登录和退出
	@Test
	public void testPermission(){
		// 构建SecurityManager工厂，IniSecurityManagerFactory可以从ini文件中初始化SecurityManager环境
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
		//通过工厂获得SecurityManager实例
		SecurityManager securityManager = factory.getInstance();
		//将securityManager设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		//获取subject实例
		Subject subject = SecurityUtils.getSubject();
		//创建用户名,密码身份验证Token
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "1111");
		try {
			//登录，即身份验证
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			//身份认证失败
		}
		// 用户认证状态
		boolean isAuthenticated = subject.isAuthenticated();
		System.out.println("用户认证状态：" + isAuthenticated);
		
		//判断拥有角色：role1
		Assert.assertTrue(subject.hasRole("role1"));
		//判断拥有角色：role1 and role2
		Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));
		//判断拥有角色：role1 and role2 and !role3
		boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
		Assert.assertEquals(true, result[0]);
		Assert.assertEquals(true, result[1]);
		Assert.assertEquals(false, result[2]);
		
		
		//判断拥有权限：user:create
		Assert.assertTrue(subject.isPermitted("user:create"));
		//判断拥有权限：user:update and user:delete
		Assert.assertTrue(subject.isPermittedAll("user:update", "user:delete"));
		//判断没有权限：user:view
		Assert.assertFalse(subject.isPermitted("user:view"));
	}
}
```
5. 自定义Realm实现授权
* 与上边认证自定义realm一样，大部分情况是要从数据库获取权限数据，这里直接实现基于资源的授权。
    1. UserRealm实现代码
```java
/**
 * 自定义Realm实现
 * @author 邹波
 * @version 1.0
 * @date 2016-1-21
 */
public class UserRealm extends AuthorizingRealm {
	@Override
	public String getName() {
		return "UserRealm";
	}
	//用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//从token中获取身份信息
		String username = (String)token.getPrincipal();
		//根据用户名到数据库中取出用户信息  如果查询不到 返回null
		String password = "1111";//假如从数据库中获取密码为1111
		//返回认证信息 
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());
		return simpleAuthenticationInfo;
	}
	//用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//获取身份信息
		String username = (String)principals.getPrimaryPrincipal();
		//根据身份信息获取权限数据
		//模拟
		List<String> permissions = new ArrayList<String>();
		permissions.add("user:save");
		permissions.add("user:delete");
		//将权限信息保存到AuthorizationInfo中
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for(String permission:permissions){
			simpleAuthorizationInfo.addStringPermission(permission);
		}
		return simpleAuthorizationInfo;
	}
}
```
    2. 配置文件
```properties
[main]
#自定义 realm
userRealm=cn.siggy.realm.UserRealm
#将realm设置到securityManager
securityManager.realms=$userRealm
```
    3. 测试代码
```java
/**
 * 自定义Realm实现
 * @author 邹波
 * @version 1.0
 * @date 2016-1-21
 */
public class UserRealm extends AuthorizingRealm {
	@Override
	public String getName() {
		return "UserRealm";
	}
	//用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//从token中获取身份信息
		String username = (String)token.getPrincipal();
		//根据用户名到数据库中取出用户信息  如果查询不到 返回null
		String password = "1111";//假如从数据库中获取密码为1111
		//返回认证信息 
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());
		return simpleAuthenticationInfo;
	}
	//用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//获取身份信息
		String username = (String)principals.getPrimaryPrincipal();
		//根据身份信息获取权限数据
		//模拟
		List<String> permissions = new ArrayList<String>();
		permissions.add("user:save");
		permissions.add("user:update");
		permissions.add("user:delete");
		//将权限信息保存到AuthorizationInfo中
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for(String permission:permissions){
			simpleAuthorizationInfo.addStringPermission(permission);
		}
		return simpleAuthorizationInfo;
	}
}

```
### 第四讲 shiro与项目集成开发
#### 完成springmvc+spring+mybatis整合
#### 整合shiro
1. web.xml中配置shiro的filter
```xml
<!-- shiro过虑器，DelegatingFilterProxy通过代理模式将spring容器中的bean和filter关联起来 -->
	<filter>
		<filter-name>shiroFilter</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
		<!-- 设置true由servlet容器控制filter的生命周期 -->
		<init-param>
			<param-name>targetFilterLifecycle</param-name>
			<param-value>true</param-value>
		</init-param>
		<!-- 设置spring容器filter的bean id，如果不设置则找与filter-name一致的bean-->
		<init-param>
			<param-name>targetBeanName</param-name>
			<param-value>shiroFilter</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>shiroFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

```
2. 在spring中配置shiro
```xml
<!-- web.xml中shiro的filter对应的bean -->
	<!-- Shiro 的Web过滤器 -->
	<bean id="shiroFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">
		<property name="securityManager" ref="securityManager" />
		<!-- loginUrl认证提交地址，如果没有认证将会请求此地址进行认证，请求此地址将由formAuthenticationFilter进行表单认证 -->
		<property name="loginUrl" value="/login.do" />
		<!-- 认证成功统一跳转到index.do，建议不配置，shiro认证成功自动到上一个请求路径 -->
		<property name="successUrl" value="/index.do"/>
		<!-- 通过unauthorizedUrl指定没有权限操作时跳转页面-->
		<property name="unauthorizedUrl" value="/refuse.jsp" />
		<!-- 过虑器链定义，从上向下顺序执行，一般将/**放在最下边 -->
		<property name="filterChainDefinitions">
			<value>
				<!-- /** = authc 所有url都必须认证通过才可以访问-->
				/login.jsp=anon
				/** = authc
				<!-- /** = anon所有url都可以匿名访问 -->
				
			</value>
		</property>
	</bean>

	<!-- securityManager安全管理器 -->
	<bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
			<property name="realm" ref="userRealm" />
	</bean>
	<!-- realm -->
	<bean id="userRealm" class="cn.siggy.realm.UserRealm">
		<!-- 将凭证匹配器设置到realm中，realm按照凭证匹配器的要求进行散列 -->
		<property name="credentialsMatcher" ref="credentialsMatcher"/>
	</bean>
	<!-- 凭证匹配器 -->
	<bean id="credentialsMatcher"
		class="org.apache.shiro.authc.credential.HashedCredentialsMatcher">
		<property name="hashAlgorithmName" value="md5" />
		<property name="hashIterations" value="1" />
	</bean>
```

3. 登录
    1. 原理
        1. Shiro 内置了很多默认的过滤器，比如身份验证、授权等相关的。默认过滤器可以参org.apache.shiro.web.filter.mgt.DefaultFilter中的过滤器：</br>
        过滤器简称                      对应的java类 </br>
* anon|org.apache.shiro.web.filter.authc.AnonymousFilter
* authc|org.apache.shiro.web.filter.authc.FormAuthenticationFilter
* authcBasic|org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter
* perms|org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter
* port|org.apache.shiro.web.filter.authz.PortFilter
* rest|org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter
* roles|org.apache.shiro.web.filter.authz.RolesAuthorizationFilter
* ssl|org.apache.shiro.web.filter.authz.SslFilter
* user|org.apache.shiro.web.filter.authc.UserFilter
* logout|org.apache.shiro.web.filter.authc.LogoutFilter

* anon:例子/admins/**=anon 没有参数，表示可以匿名使用。
* authc:例如/admins/user/**=authc表示需要认证(登录)才能使用，FormAuthenticationFilter是表单认证，没有参数
* 使用FormAuthenticationFilter过虑器实现 ，原理如下：

* 将用户没有认证时，请求loginurl进行认证，用户身份和用户密码提交数据到loginurl
* FormAuthenticationFilter拦截住取出request中的username和password（两个参数名称是可以配置的）
* FormAuthenticationFilter调用realm传入一个token（username和password）
* realm认证时根据username查询用户信息（在Activeuser中存储，包括 userid、usercode、username、menus）。
* 如果查询不到，realm返回null，FormAuthenticationFilter向request域中填充一个参数（记录了异常信息）

    2. 登陆页面
        1. 由于FormAuthenticationFilter的用户身份和密码的input的默认值（username和password），修改页面的账号和密码 的input的名称为username和password
    3. 代码实现
```java
@Controller
public class LoginController {
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest req,Model model){
		String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
		String error = null;
		if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
		error = "用户名/密码错误";
		} else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName))
		{
		error = "用户名/密码错误";
		} else if(exceptionClassName != null) {
		error = "其他错误：" + exceptionClassName;
		}
		model.addAttribute("error", error);
		return "redirect:login.jsp";
	}
}



```