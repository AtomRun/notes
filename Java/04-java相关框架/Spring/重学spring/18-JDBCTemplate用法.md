# SpringJDBCTemplate

## 配置数据源

```xml
<!-- 导入外部配置文件 -->
<context:property-placeholder location="classpath:db.properties" />

<!-- 测试数据源 -->
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
	<property name="user" value="${jdbc.user}"></property>
    <property name="password" value=""></property>
    <property name="jdbcUrl" value=""></property>
    <property name="driverClass" value=""></property>
</bean>
```

## 测试1

```java
public class Test {
    
    ApplicationContext ioc = new ClassPathXmlApplicationContext("xxxx.xml");
    
    @Test
    public void test(){
        DataSource bean = ioc.getBean(DataSource.class);
        Connection connection = bean.getConnection();
    }
    
}
```

# 测试修改

```xml
<!-- 导入外部配置文件 -->
<context:property-placeholder location="classpath:db.properties" />

<!-- 测试数据源 -->
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
	<property name="user" value="${jdbc.user}"></property>
    <property name="password" value=""></property>
    <property name="jdbcUrl" value=""></property>
    <property name="driverClass" value=""></property>
</bean>

<bean id="jdbcTemplate" class="com.springframework.jdbc.core.jdbcTemplate">
	<constructor-arg name="dataSource" ref="dataSource"></constructor-arg>
</bean>
```

```java
public class Test {
    
    ApplicationContext ioc = new ClassPathXmlApplicationContext("xxxx.xml");
    JdbcTemplate jdbcTemplate = ioc.getBean("JdbcTemplate.class");
    
    
    @Test
    public void test1(){
        
        //DataSource datasource = ioc.getBean("DataSource.class");
        //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource)
        //不使用自己new的方式，而是将上面的组件交给Spring来管理，当容器启动的时候，Spring自动将DataSource和JdbcTemplate实例创建出来，我们再取出来
        Sring sql = "UPDATE employee SET salary = ? where emp_id = ?"
        int update = jdbcTemplate.update(sql,1300.00,5);
        System.out.println("更新员工"+update);
    }
    
}
```

# 测试批量插入

```java
public class Test {
    
    ApplicationContext ioc = new ClassPathXmlApplicationContext("xxxx.xml");
    JdbcTemplate jdbcTemplate = ioc.getBean("JdbcTemplate.class");
    
    
    @Test
    public void test3(){
		String sql = "INSERT INTO EMPLOYEE(EMP_NAME,SALARY) VALUES(?,?)";
        //List<Object[]>
        //List的长度就是sql语句要执行的次数
        //object[] 每次执行要用的参数
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new Object[]{"张三",998.43})
        batchArgs.add(new Object[]{"李四",1243.234})
        batchArgs.add(new Object[]{"王五",234.234})
        batchArgs.add(new Object[]{"赵六",53.35})
        jdbcTemplate.batchUpdate(sql,batchArgs);
        int[] is = jdbcTemplate.batchUpdate(sql,batchArgs);
        for(int i :is){
            System.out.println(i);
        }
    }
}
```

# 查询记录并封装成java对象

```java
public class Employee {
    private Integer empId;
    private String empName;
    private Double salary;
  
    //getset
}
```

```java
//javaBean要和数据库字段名一致，否则没法完成封装
//jdbcTemplate 方法进行了区分
// 查询集合：jdbcTemplate.query()
// 查询单个对象:jdbcTemplate.queryForObject()
@Test
public void test4(){
    String sql = "SELECT EMPID,EMPNAME,SALARY FROM EMPLOYEE WHERE EMPID = ?"
    //中间参数，每行记录和JavaBean的属性如何映射
    Employee employee = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Employee.class),5);
    //如果查询没结果，会报错
}
```

# 查询集合

```java
@Test
public void test5(){
    String sql = "SELECT EMPID,EMPNAME,SALARY FROM EMPLOYEE WHERE SALARY > ?";
    //封装成List，集合里面元素的类型
	List<Employee> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Employee.class),4000);
    for(Employee emp:lis){
        System.out.println(emp);
    }
}
```

# 查询最大SALARY

```java
//查询无论是返回单个数据还是单个对象，都调用queryForObject
@Test
public void test6(){
    String sql = "SELECT max(SALARY) from employee";
    
	Double dle = jdbcTemplate.queryForObject(sql,Double.class);
    System.out.println(dle);
}
```

# 使用具名参数插入

```xml
<bean id="namedJdbcTemplate" calss="org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate">
	<constructor-arg name="dataSource" ref="dataSource">
</bean>
```

```java
// 带？是占位符
// 具名参数：带有名字的参数，参数不用占位符，而是一个变量名
	//语法格式： :参数名
// Spring有一个支持具名参数的JdbcTemplate即NamedPrameterJdbcTemplate
//去IOC容器配置一个即可
NamedParameterJdbcTemplate named = ioc.getBean("NamedParameterJdbcTemplate.class");

@Test
public void test7(){
    String sql = "INSERT INTO employee(empname,salary) VALUES (:employee,:salary)";
    //将所有带有具名参数的值都放在Map中
    Map<Sting,Object> paramMap = new HashMap<>(); 
    paramMap.put("empname","王八");
    paramMap.put("salary",9892.54);
 	int update  = named.update(sql,paramMap)
    System.out.println(update);
}
```

# 重复实验7传入对象

```java
NamedParameterJdbcTemplate named = ioc.getBean("NamedParameterJdbcTemplate.class");

@Test
public void test8(){
    String sql = "INSERT INTO employee(empname,salary) VALUES (:employee,:salary)";
    Employee employee = new Employee
    employee.setEmpName("xxx");
    employee.setSalary(9989.87);
    //SqlParameterSource 具名参数，参数的值从javaBean找
 	int update  = named.update(sql,new BeanPropertySqlParameterSource(employee));
    System.out.println(update);
}
```

# BookDao使用

```java
@Repository
public class EmployeeDao {
    @AutoWired
    JdbcTemplate jdbcTemplate;
    public void saveEmployee(Employee employee){
        String sql = "INSERT INTO employee(empName,salary) VALUES(?,?)";
        jdbcTemplate.update(sql,employee.getEmpName,employee.getSalary);
    }
}
```

## 使用

```java
@Test
public void test09(){
	EmployeeDao dao = ioc.getBean(EmployeeDao.class);
    Employee employee = new Employee
    employee.setEmpName("xxx");
    employee.setSalary(9989.87)
    dao.saveEmployee(employee);
}
```

