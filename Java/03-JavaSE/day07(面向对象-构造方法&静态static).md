## 面向对象-构造方法&静态static

### 1. 构造方法Constructor概述和格式
    1. 构造方法的概述和作用
        1. 给对象的数据(属性)进行初始化
    2. 构造方法格式特点
        1. 方法名与类名相同(大小也要与类名一致)
        2. 没有返回值类型，连void也没有
        3. 没有具体的返回值return
```java
package com.leeup.javase.day07;
/**
 * 构造方法概述和作用
 * @author 李闯
 *
 */
public class Demo1_Constructor {

	public static void main(String[] args) {
		Person person = new Person();	//在一创建对象的时候，系统就帮我们调用了构造方法，这里没传参数即调用的[无参构造构造方法]
//		person.Person();				//构造方法不能用对象调用
		person.show();	
		
		Person person2 = new Person();  
		person2.show(); 
	}
}

class Person{
	
	private String name;
	private int age;
	
	//构造方法
	public Person() {
//		System.out.println("Hello World");
//		return;							//构造方法也是有return语句的，格式是return;
		
		name = "张三";
		age = 23;
	}
	
	public void show() {
		System.out.println(name+"..."+age);
	}
}
```

### 2. 构造方法的重载及注意事项
    1. 案例展示
        1. 构造方法的重载
        2. 重载：方法名相同，与返回值类型无关(构造方法没有返回值)，只看参数列表
    2. 构造方法注意事项
        1. 如果我们没有给出构造方法，系统将自动提供一个无参构造方法
        2. 如果我们给出了构造方法，系统将不再提供默认的无参构造方法
            1. 注意：这个时候，如果我们还想使用无参构造方法，就必须自己给出，建议永远自己给出无参构造方法
```java
package com.leeup.javase.day07;

public class Demo2_Person {

	public static void main(String[] args) {
		Person1 p1 = new Person1();//执行空参数构造
		p1.show();
		
		System.out.println("==================");
		/**
		 * 有参数的构造方法，可以给对象中的属性进行初始化
		 */
		Person1 p2 = new Person1("张三",23);//有参数的构造方法
		p2.show();
		
		System.out.println("==================");
		
		Person1 p3 = new Person1("李四",24);//有参数的构造方法
		p3.show();
		
		
	}
}

/**
 * 如果没给出Person对象构造方法，系统默认会创建一个无参数的构造方法
 * 但是如果给了Person对象有参构造方法的时候，系统就不会给你默认的无参构造方法了，所以它直接找有参构造发现不匹配就会报错。
 * 这时候如果想使用无参构造创建对象，就必须写一个无参构造，否则只能使用有参构造创建对象了
 * @author 李闯
 *
 */
class Person1{
	private String name;
	
	private int age;
	
	public Person1(){
		System.out.println("空参数的构造方法");
	}
	
	public Person1(String name, int age) {
		/**
		 * 给两个参数，调用方法的时候也要有两个参数
		 */
		this.name = name;
		this.age = age;
		System.out.println("有两个参数的构造方法");
	}
	
	public void show() {
		System.out.println(name+"..."+age);
	}
}
```

### 3. 给成员变量赋值的两种方式的区别
    1. setXxx()方法
        1. 修改属性值
    2. 构造方法
        1. 给对象属性进行初始化
```java
package com.leeup.javase.day07;

public class Demo3_Person {

	public static void main(String[] args) {
		Person2 p2 = new Person2("张三",21);
		//如果我们想要给张三改名，那么使用如下方法，重新new对象
		/**
		 * 但是这个举动其实不能叫做“改名”，应该叫做“杀人”
		 * 因为一开始p2 new了一个对象叫张三，21岁，又new了个对象叫张天一，21岁，并且将地址值赋值给p2,而之前的
		 * 对象因为没有引用就变成了垃圾，虽然运行结果对的，但是其实是将原对象变成了垃圾[不推荐使用]
		 */
		p2 = new Person2("张天一",21);
		System.out.println(p2.getName()+"..."+p2.getAge());
		
		System.out.println("============================");
		
		Person2 p3 = new Person2();
		p3.setName("李四");
		p3.setAge(12);
		
		p3.setName("李贵");
		/**
		 * p3.setName("李贵");
		 * 这种方式不需要重新创建对象，只是重新修改了属性值，覆盖了原来的属性值
		 */
		System.out.println(p3.getName()+"..."+p3.getAge());
		
		/**
		 * 使用set方式给成员变量赋值和有参构造方法直接传入的值有什么区别？
		 * 构造方法:
		 * 	给属性进行初始化
		 * setXxx方法：
		 * 	修改属性的值
		 * 这两种方式，在开发中使用setXxx更多一些，因为比较灵活
		 */
	}
}

class Person2{
	private String name;
	private int age;
	
	public Person2(){
		
	}
	
	public Person2(String name,int age) {
		this.age = age;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}
```

### 4. 学生类的代码及测试
    1. 案例展示
        1. 一个标准代码的最终版
        2. 学生类
            1. 成员变量：
                1. name，age
            2. 构造方法
                1. 无参：带两个参
            3. 成员方法
                1. getXxx()/setXxx()
                2. show():输出该类的所有成员变量值
    2. 给成员变量赋值： 
        1. setXxx()方法
        2. 构造方法
    3. 输出成员变量值的方式
        1. 通过getXxx()分别获取然后拼接
        2. 通过调用show()方法搞定
```java
package com.leeup.javase.day07.构造方法;

public class Demo4_Student {

	public static void main(String[] args) {
		Student student  = new Student();	//空参数构造创建对象
		student.setName("张三");		//设置姓名
		student.setAge(23);			//设置年龄
		
		student.show();
		System.out.println("我的姓名是："+student.getName()+"，我的姓名是："+student.getAge());
		
		Student student2 = new Student("李四",24);
		
		student2.show();			//只是为了显示属性值，而getName或者getAge可能是拿到值用来做别的操作
	}
}

class Student{
	
	private String name;
	private int age;
	
	//无参构造
	public Student() {
		
	}
	
	//有参构造
	public Student(String name,int age) {
		this.age = age;
		this.name = name;
	}
	
	//name的set方法
	public void setName(String name) {
		this.name = name;
	}
	//name的get方法
	public String getName() {
		return name;
	}
	
	//age的set方法
	public void setAge(int age) {
		this.age = age;
	}
	
	//age的get方法
	public int getAge() {
		return age;
	}
	
	public void show() {
		System.out.println("我的姓名是："+name+"，我的年龄是："+age);
	}
}
```

### 5. 手机类的代码及测试
    1. 案例展示
        1. 模仿学生类，完成手机类代码
```java
package com.leeup.javase.day07.构造方法;

public class Demo5_Phone {

	public static void main(String[] args) {
		Phone p1 = new Phone();
		p1.setBrand("小米");
		p1.setPrice(4000);
		System.out.println("我的品牌是"+p1.getBrand()+"，我的价格是"+p1.getPrice());
		
		
		Phone p2 = new Phone("苹果",9000);
		p2.show();
	}
}

class Phone{
	//成员变量
	private String brand;
	private int price;
	
	//无参构造
	public Phone(){
		
	}
	
	//有参构造
	public Phone(String brand,int price) {
		this.brand = brand;
		this.price = price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void show() {
		System.out.println("我的品牌是"+brand+"，我的价格是"+price);
	}
}
```

### 6. 创建一个对象的步骤
    1. 画图演示
        1. 画图说明一个对象的创建过程做了哪些事情?
            1. Student s = new Student();
            2. Student.class加载进内存
            3. 声明一个Student类型引用s
            4. 在堆内存创建对象,
            5. 给对象中属性默认初始化值
            6. 属性进行显示初始化
            7. 构造方法进栈,对对象中的属性赋值,构造方法弹栈
            8. 将对象的地址值赋值给s


![对象创建过程做了哪些事]