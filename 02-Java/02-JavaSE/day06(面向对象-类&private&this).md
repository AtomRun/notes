## 面向对象
### 1. 面向对象概述
    1. 面向过程思想概述
        1. 第一步
        2. 第二步
    2. 面向对象思想概述
        1. 找对象(第一步，第二步)
    3. 举例
        1. 买煎饼果子
        2. 洗衣服

![面向对象概述](https://github.com/AtomRun/notes/blob/master/00-noteimages/Object-oriented%20overview.png)

    4. 面向对象思想特点
        1. 是一种更符合我们思想习惯的思想
        2. 可以将复杂的事情简单化
            1. 对我来说简单化，但是对对象来说复杂了。但是好在这个对象创建了之后可以一直为我服务或者其他人服务。对象中的方法可以不断的复用
        3. 将我们从执行者变成了指挥者
            1. 角色发生了转换
    5. 面向对象开始
        1. 就是不断地创建对象，使用对象，指挥对象做事情
    6. 面向对象设计
        1. 其实就是在管理和维护对象之间的关系
    7. 面向对象特征
        1. 封装(encapsulation)
        2. 继承(inheritance)
        3. 多态(polymorphism)

### 2. 类与对象概述
    1. 我们学习编程是为了什么
        1. 为了把我们日常生活中的事物用学习语言描述出来
    2. 我们如何描述现实世界事物
        1. 属性：就是该事物的描述信息(事物身上的名词)
        2. 行为：就是该事物能够做什么(事物身上的动词)
    3. java中最基本的单位是类，java中用class描述事物也是如此
        1. 成员变量：就是事物的属性
        2. 成员方法：就是事物的行为
    4. 定义类其实就是定义类的成员(成员变量和成员方法)
        1. 成员变量：和以前定义变量是一样的，只不过位置发生了改变，在类中，方法外
        2. 成员方法：和以前定义方法是一样的，只不过是把static去掉，后面再详细讲解static的作用
    5. 类和对象的概念
        1. 类：是一组相关属性和行为的集合
        2. 对象：是该事物的具体体现
        3. 举例
            1. 类：学生
            2. 对象：具体的某个学生就是一个对象
        4. 可以理解为
            1. 类是创建对象的模板，通过类的模板，创建形形色色的对象。例如：人是一个类，通过这个类可以创建实际的对象，例如小明，小红。即类是定义好的一个模板，通过这个模板可以创建实质的对象
            2. 对象是类实例化(new)产生的，实例化就是new，实例就是对象
            3. 对象：现实中实实在在存在的物体[即理解为类的填充]
            4. 类：对整个物体的整体的描述的集合

### 3. 学生类的定义
    1. 学生事物
    2. 学生类
    3. 案例展示
        1. 属性：姓名，年龄，性别
        2. 型位：学习，睡觉

### 4. 手机类的定义
    1. 模仿学生类
        1. 属性：品牌(brand),价格(price)
        2. 行为：打电话(call),发信息(sendMessage),玩游戏(playGame)

### 5. 学生类的使用
    1. 文件名问题
        1. 在一个java文件中写两个类：一个基本的类，一个测试类
        2. 建议：文件名称和测试类名称一致
    2. 如何使用对象
        1. 创建对象并使用
        2. 格式：类名 对象名 = new 类名();
    3. 如何使用成员变量呢？
        1. 对象名.变量名
    4. 如何使用成员方法呢?
        1. 对象名.方法名(...)

### 6. 手机类的使用
    1. 学生自己完成
        1. 模仿学生类，让学生自己完成

### 7. 一个对象的内存图
    1. 画图演示
        1. 一个对象 
![一个对象的内存图](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E4%B8%80%E4%B8%AA%E5%AF%B9%E8%B1%A1%E7%9A%84%E5%86%85%E5%AD%98%E5%9B%BE.png)

### 8. 二个对象的内存图
    1. 画图演示
        1. 二个不同的对象
![两个对象的内存图](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E4%B8%A4%E4%B8%AA%E5%AF%B9%E8%B1%A1%E7%9A%84%E5%86%85%E5%AD%98%E5%9B%BE.png)

### 9. 三个引用两个对象的内存图
    1. 画图演示
        1. 三个引用，有两个对象的引用指向同一个地址
![三个引用两个对象内存图](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E4%B8%89%E4%B8%AA%E5%BC%95%E7%94%A8%E4%B8%A4%E4%B8%AA%E5%AF%B9%E8%B1%A1%E5%86%85%E5%AD%98%E5%9B%BE.png)

### 10. 成员变量和局部变量的区别
    1. 在类中的位置不同
        1. 成员变量：在类中方法外
        2. 局部变量：在方法中定义或者方法声明上
    2. 在内存中的位置不同
        1. 成员变量：在堆内存中(成员变量属于堆内存，对象进入堆内存)
        2. 局部变量：在栈内存(局部变量属于方法，方法进栈内存)
    3. 生命周期不同
        1. 成员变量：随着对象的创建而存在，随着对象的消失而消失
        2. 局部变量：随着方法的调用而存在，随着方法的调用完毕而消失
    4. 初始化值不同
        1. 成员变量：有默认初始化值
        2. 局部变量：没有默认初始化值，必须定义，赋值，然后才能使用
    5. 注意事项
        1. 局部变量名称可以和成员变量名称一样，在方法使用的时候，采用的是就近原则。
        2. 基本数据类型变量包括哪些：byte,short,int,long,float,double,boolean,char
        3. 引用数据类型包括哪些：数组，类，接口，枚举

```java
package com.leeup.javase.day06.面向对象;

public class Demo2_Person {
	
	public static void main(String[] args) {
		Person person = new Person();
		
		person.speak();
	}
}
	
class Person {
	
	/**
	 * 引用数据类型初始化值都是null
	 * 基本数据类型 整数都是0，小数都是0.0，boolean是flase,char是'/u0000'
	 */
	
	String name;			//成员变量,没有赋值，但是也有默认初始化值，String即null
	
	public void speak(/*int x*/) { //方法声明上，局部变量
		int num = 10; //方法生命周期，局部变量,x,num都是局部变量,
					  //如果这里int num不给他初始化值，syso会提示错误，即num没有被初始化
					  //局部变量必须要在使用前初始化才能使用
		System.out.println(name);
		System.out.println(num);
	}
}
```

### 11. 方法的形式参数是类名的时候如何调用
    1. 方法的参数名是public void print (Studen s){}//print (new Student());
        1. 如果你看到了一个方法的形式参数是一个类类型(引用类型),这里需要的是类的对象
```java
package com.leeup.javase.day06.匿名对象;

public class Demo1_Student {
	
	public static void main(String[] args) {
		print(10);		//直接调用
		
		Student s = new Student();//创建对象，并将对象的地址值赋给s
		
		print(s);
	}
	
	public static void print(int x) {	//基本数据类型作为形式参数
		System.out.println(x);
	}
	
	public static void print(Student s) {	//引用数据类型当作形式参数
		/**
		 * 接收引用数据类型必须要给它一个地址值
		 * 基本类型参数给的是值
		 */
		
		s.name="张三";
		s.age=23;
		s.speak();
	}
}
/**
 * 方法的参数名是public void print (Studen s){}//print (new Student());
 * 如果你看到了一个方法的形式参数是一个类类型(引用类型),这里需要的是类的对象
 */

class Student{
	
	String name;	//姓名
	int age;		//年龄
	
	public void speak() {
		System.out.println(name+"..."+age);
	}
}
```
### 12. 匿名对象的概述和应用
    1. 什么是匿名对象
        1. 没有名字的对象
    2. 匿名对象应用场景
        1. 调用方法，仅仅只调用一次的时候
            1. 那么这种匿名调用有什么好处吗？
                1. 节省代码
            2. 注意：调用很多次的时候不适合。匿名对象调用完毕就是垃圾。可以被垃圾回收器回收。
        2. 匿名对象可以作为实际参数传递
    3. 案例展示
        1. 匿名对象应用场景
```java
package com.leeup.javase.day06.匿名对象;
/**
 * 匿名类概述以及优缺点以及使用场景1：调用方法，设置参数
 * @author 李闯
 *
 */
public class Demo2_Car {

	public static void main(String[] args) {
		Car c1 = new Car();		//创建有名字的对象
		c1.run();			
		c1.run();				//想要再调用一次，直接使用c1.run即可
		
		new Car().run();		//匿名对象调用方法
		new Car().run();		//匿名想要调用，必须重新new一次，即再在堆里创建了一个对象，比较占内存
		/**
		 * 匿名对象，只适合对方法的一次调用，因为调用多次会产生多个对象，不如用有名字的对象
		 */

		//匿名对象是否可以调用属性并赋值？有什么意义？
		
		/**
		 * 匿名对象可以调用属性，但是没有意义，因为调用完了就变成了垃圾，
		 * 如果需要赋值，还是要用有名字的对象。
		 * 
		 * 相对有名字的对象，好处就是节省代码，
		 * 但是多次调用不适合，因为匿名对象调用完了就是垃圾，就会被垃圾回收器回收，并且每次调用都会在堆内存中开辟空间放对象
		 * 
		 */
		new Car().color = "red";
		new Car().num = 8;
		new Car().run();		//输出结果为0，因为三个匿名类是三个单独的对象，首先他们的属性值不会共享，
								//然后就是，当color被赋值后，由于没有引用，立即被垃圾回收了。num也是相同，
								//run也是相同的道理，run根据new Car内存中的地址去堆中找两个属性的值，但是值都是默认
								//初始值，故为int默认基本数据类型0，和引用数据类型String的默认初始化值null
	}
}

class Car{
	
	String color;	//颜色
	int num;		//轮胎数
	
	public void run() {
		System.out.println(color+"。。。"+num);
	}
}
```
```java
package com.leeup.javase.day06.匿名对象;
/**
 *匿名类概述使用场景2：作为参数使用
 * @author 李闯
 *
 */
public class Demo3_Car {
	
	public static void main(String[] args) {
//		Car c1 = new Car();
		//c1.color = "red";
		//c1.num = 8;
		//c1.run();
//		method(c1);
		
		method(new Car());
		
//		Car c2 = new Car();
//		method(c2);
		
		method(new Car());		//匿名对象可以当作参数传递，这里相当于把new Car的地址值赋值给了方法中的 cc
								//cc可以拿到地址值对属性进行赋值
	}
	
	//抽取方法，提高代码复用性
	public static void method(Car cc) {
		cc.color = "Red";
		cc.num = 8;
		cc.run();
	}
}

class Car{
	String color;	//颜色
	int num;		//轮胎数
	
	public void run() {
		System.out.println(color+"...."+num);
	}
}
```

### 13. 封装的概述
    1. 封装概述
        1. 是指隐藏对象的属性和实现细节，进对外提供公共访问方式。
    2. 封装的好处
        1. 隐藏了实现细节，提供公共的访问方式
        2. 提高了代码的复用性
        3. 提高安全性

### 14. private关键字的概述和特点
    1. 人类赋值年龄的问题
    2. private关键字特点
        1. 是一个权限修饰符
        2. 可以修饰成员变量和成员方法
        3. 被其修饰的成员只能在本类中被访问
    3. 案例展示
        1. 封装和private的应用
        2. 把成员变量用private来修饰
        3. 提供对应的getXxx()和setXxx()方法
        4. private仅仅是封装的一种体现形式，不能说封装就是私有
```java
package com.leeup.javase.day06.匿名对象;

public class Demo1_Person {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "张三";		//调用属性并赋值
//		p1.age = 23;		//当age为私有的时候，只能在本类中访问,想要设置值，只能通过set方法
		//如果有人想要设置一些错误的值给age,那么不是private将会直接设置，但是有了private后，设置值必须通过set方法，这时候虽然也可以设置一些错误的值给age，但是
		//我们现在有了get/set方法，可以在方法中写判断语句来阻止这种情况的发生
		p1.setAge(-1);
//		p1.setAge(23);
//		p1.speak();			//调用方法
		
	}
}

class Person{
	String name;	//姓名
	private int age;		//年龄
	
	//设置年龄
	public void setAge(int a) {
		if (a > 0 && a < 200) {
			age = a;//想要设置age的值，设置别人穿过来的参数，赋值给age
		}else {
			System.out.println("您输入的年龄不正确！");
		}
	}
	
	//获取年龄，年龄是int的，所以返回值为int
	public int getAge() {
		return age;
	}

	public void speak() {
		System.out.println(name+"..."+age);
	}
}
```

### 15. this关键字的概述和应用
    1. this关键字的特点
        1. 代表当前对象的引用
    2. 案例展示
        1. this的应用场景
        2. 用来区分成员变量和局部变量重名
```java
package com.leeup.javase.day06.this1;
/**
 * this关键字
 * @author 李闯
 *
 */
public class Demo1_This {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("张三");
		p1.setAge(23);
		System.out.println(p1.getName()+"..."+p1.getAge());
		
		Person p2 = new Person();
		p2.setName("李四");
		p2.setAge(24);
		/**
		 * 当创建p1对象时，this代表的是p1对象
		 * 当创建p2对象时，this代表的是p2对象
		 * 
		 * 即谁来调用this，this就是代表哪个对象，也是用来区分当局部变量和成员变量重名时的问题
		 */
		
		System.out.println(p2.getName()+"..."+p2.getAge());
	}
}

class Person{
	private String name;	//姓名
	private int age;		//年龄
	
	//设置年龄
	public void setAge(int age) {
		if (age > 0 && age < 200) {
//			age = age;		//若是写成这样age = age 其实就是局部变量重新给自己赋值了一次。并不会改变成员变量的值
			this.age = age;	//this关键字里记录的其实就是当前对象在内存堆中的地址值，这里this.age 其实就是main方法中new的p1.age
		}else {
			System.out.println("您输入的年龄不正确！");
		}
	}
	
	//获取年龄，年龄是int的，所以返回值为int
	public int getAge() {
		return age;
	}
	
	//设置姓名
	public void setName(String name) {
//		name = name;		//当这样写的时候，输出的结果为 null,0,因为方法有就近原则，当我们形式参数为name赋值给name的时候，
							//就近原则这里就是name形式参数，再给局部变量重新赋值了一次，所以，成员变量的值没有改变
		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
```

### 16. 手机类代码及其测试
    1. 学生练习
        1. 请把手机类写成一个标准类，然后创建对象测试功能
```java
package com.leeup.javase.day06.this1;

public class Demo2_Phone {

	public static void main(String[] args) {
		Phone phone = new Phone();
		
		phone.setBrand("小米");
		phone.setPrice(4999);
		
		System.out.println(phone.getBrand()+"。。。"+phone.getPrice());
		phone.call();
		phone.sendMessage();
		phone.playGame();
	}
}

/**
 * 手机类
 * @author 李闯
 *
 */
class Phone{
	/**
	 * java bean类，实体类，对别的类提供服务，有set/get方法叫做javaBean类，实体类
	 */
	private String brand;
	private int price;
	
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
		return this.price;//this可以省略，你不加系统会默认给你加
	}
	
	public void call() {
		System.out.println("打电话");
	}
	public void sendMessage() {
		System.out.println("发短信");
	}
	public void playGame() {
		System.out.println("玩游戏");
	}

```


### 17. day06总结
    1. 今天的知识总结梳理一遍