## 反射&JDK新特性

### 1. 类的加载概述和加载时机 
    1. 类的加载概述
        1. 当程序要使用某个类时，如果该类还未被加载到内存中，则系统会通过加载，连接，初始化，三步来实现对这个类进行初始化
        2. 加载
            1. 就是指将class文件读入内存，并为之创建一个class对象，任何类被使用时系统都会建立一个Class对象，
        3. 连接
            1. 验证 是否有正确的内部结构，并和其他类协调一致
            2. 准备 负责为类的静态成员分配内存，并设置默认初始化值
            3. 解析 将类的二进制数据中的符号引用替换为直接引用
        4. 初始化 就是我们之前讲过的初始化步骤
    2. 加载时机
        1. 创建类的实例
        2. 访问类的静态变量，或者为静态变量赋值
        3. 调用类的静态方法
        4. 使用反射方式来强制创建某个类或接口对应的java.lang.Class对象
        5. 初始化某个类的子类
        6. 直接使用java.exe命令来运行某个子类

### 2. 类加载器的概述和分类
    1. 类加载器概述
        1. 负责将.class文件加载到内存中，并为之生成对应的class对象，虽然我们不需要关心类加载机制，但是了解了这个机制我们就能更好的理解程序的运行
    2. 类加载器的分类
        1. BootStrap ClassLoader 根类加载器
        2. Extension ClassLoader 扩展类加载器
        3. System ClassLoader 系统类加载器
    3. 类加载器的作用
        1. BootStrap ClassLoader 根类加载器
            1. 也被称为引导类加载器，负责java核心类的加载
            2. 比如System,String等,再JDK中JRE的lib目录下rt.jar文件中
        2. Extension ClassLoader 扩展类加载器
            1. 负责JRE的扩展目录中jar包的加载
            2. 在JDK中JRE的lib目录下ext目录
        3. System ClassLoader 系统类加载器
            1. 负责在JVM启动时加载来自java命令的class文件，以及classpath环境变量所指定的的jar包和类路径

### 3. 反射概述
    1. 反射概述
        1. java反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法
        2. 对于任意一个对象，都能够调用它的任意一个方法和属性
        3. 这种动态获取的信息以及动态调用对象的方法的功能被称为java语言的反射机制
        4. 要想解剖一个类，必须先要获取该类的字节码文件对象
        5. 而解剖使用的就是Class类中的方法，所以要获取到每一个字节码文件对应的Class的对象
    2. 三种方式
        1. Object类的getClass()方法，判断两个对象是否是同一个字节码文件
        2. 静态属性class，锁对象
        3. Class类中静态方法forName(),读取配置文件
    3. 案例展示
        1. 获取class文件对象的三种方式
![反射概述](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E5%8F%8D%E5%B0%84%E6%A6%82%E8%BF%B0.png)

```java
package com.leeup.javase.day27.reflect;

import com.leeup.javase.day27.bean.Person;

public class Demo1_Reflect {

	public static void main(String[] args) throws ClassNotFoundException {
		Class class1 = Class.forName("com.leeup.javase.day27.bean.Person");
		
		Class class2 = Person.class;
		
		Person person = new Person();
		Class class3 = person.getClass();
		
		System.out.println(class1 == class2);
		System.out.println(class3 == class2);
		System.out.println(class3 == class1);
	}
}

```
### 4. class.forName()读取配置文件举例
    1. 榨汁机(Juicer)榨汁的案例
    2. 分别由水果(Fruit)苹果(Appale)香蕉(Banana)桔子(Orange)榨汁(squeeze)

```java
package com.leeup.javase.day27.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 榨汁机(Juicer)榨汁的案例
    2. 分别由水果(Fruit)苹果(Appale)香蕉(Banana)桔子(Orange)榨汁(squeeze)
 * @author 李闯
 *
 */
public class Demo2_Reflect {

	public static void main(String[] args) throws Exception {
		
		//没有用反射，使用了多态
//		Juicer juicer = new Juicer();				//购买榨汁机
//		juicer.run(new Appale());					//向榨汁机中放入苹果
//		juicer.run(new Orange());
		
		//使用反射和配置文件
		BufferedReader br = new BufferedReader(new FileReader("config.prop"));//使用buffredReader可以读整行
		Class clazz = Class.forName(br.readLine());
		Fruit f = (Fruit) clazz.newInstance();	//父类引用指向子类对象  水果的引用指向了苹果对象
		Juicer juicer = new Juicer();
		juicer.run(f);
		
	}
}

interface Fruit {
	public void squeeze();
}

class Appale implements Fruit{
	public void squeeze() {
		System.out.println("榨出一杯苹果汁");
	}
}

class Juicer {
//	public void run(Appale appale) {
//		appale.squeeze();
//	}
//	public void run(Orange orange) {
//		orange.squeeze();
//	}
	
	//改进后代码如下
	public void run(Fruit f) {
		f.squeeze();
	}
}

class Orange  implements Fruit{
	public void squeeze() {
		System.out.println("榨出一杯橘子汁");
	}
}
```

### 5. 通过反射获取带参构造方法并使用
    1. Class类的newInstance()方法是使用该类无参的构造函数创建对象，如果一个类没有无参的构造函数，就不能这样创建了，可以调用Class类的getConstructor(String.class,int.class)方法获取一个指定的构造函数然后再调用Contructor类的newInstance("张三",20)方法创建对象
```java
package com.leeup.javase.day27.reflect;

import java.lang.reflect.Constructor;

/**
 * Class类的newInstance()方法是使用该类无参的构造函数创建对象，如果一个类没有无参的构造函数，
 * 就不能这样创建了，可以调 用Class类的getConstructor(String.class,int.class)方法获取一个指定的构造函数
 * 然后再调用Contructor类的newInstance("张三",20)方法创建对象
 */
import com.leeup.javase.day27.bean.Person;

public class Demo3_Constructor {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.leeup.javase.day27.bean.Person");

		//当Person类中没有无参构造函数就不能这样创建了
//		Person p = (Person) clazz.newInstance();//通过无参构造创建对象
		Constructor c = clazz.getConstructor(String.class,int.class);//获取有参构造
		Person person = (Person) c.newInstance("张三",23);//通过有参构造创建对象
		System.out.println(person);

	}
}

```
### 6. 通过反射获取成员变量并使用
    1. Field
        1. Class.getField(String)方法可以获取类中的指定字段(可见的)。如果是私有的可以用getDeclaedField("name)方法获取，通过set(obj,"李四")方法可以设置指定对象上该字段的值，如果是私有的需要先调用setAccessible(true)访问权限，用获取的指定字段调用get(obj)可以获取制定对象中该字段的值
```java
package com.leeup.javase.day27.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.leeup.javase.day27.bean.Person;

public class Demo4_Field {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.leeup.javase.day27.bean.Person");
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		
		Person person = (Person) constructor.newInstance("张三",23);
		
//		Field f = clazz.getField("name");			//获取姓名字段
//		f.set(person, "李四");						//修改姓名的值
		
		//name是私有的，我们要暴力反射获取字段
		Field f = clazz.getDeclaredField("name");
		f.setAccessible(true);			//去除这个字段的私有权限
		f.set(person, "李四");
		
		System.out.println(person);
	}
}

```
### 7. 通过反射获取方法并使用
    1. Method
        1. Class.getMethod(String,Class...)和Class.getDeclaredMethod(String,Class)方法可以获取类中的指定方法，调用invoke(Object,Object...)可以调用该方法，Class.getMethod("eat") invoke(obj) Class.getMethod("eat",int.class) ivoke(obj,10)
```java
package com.leeup.javase.day27.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.leeup.javase.day27.bean.Person;

public class Demo5_Method {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.leeup.javase.day27.bean.Person");
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		Person person = (Person) constructor.newInstance("张三",23);
		
		Method method = clazz.getMethod("eat");			//获取eat方法
		method.invoke(person);
		
		Method method2 = clazz.getMethod("eat", int.class);//获取有参的eat方法
		method2.invoke(person, 10);							
		
	}
}

```

### 8. 通过反射越过泛型检查
    1. 案例展示
        1. ArrayList<Integer>的一个对象，在这个集合中添加一个字符串数据，如何实现？
```java
package com.leeup.javase.day27.test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * ArrayList<Integer>的一个对象，在这个集合中添加一个字符串数据，如何实现？
 * @author 李闯
 *
 */
public class Test1 {

	public static void main(String[] args) throws Exception {
		
		/**
		 * 泛型只是在编译期有语法检查即限制的，而在运行期，泛型会被擦除掉，即
		 * 生成.class文件后泛型就没了
		 * 但是字节码文件就属于运行期
		 */
		ArrayList<Integer> list = new ArrayList<>();
		list.add(111);
		list.add(222);
		
		Class clazz = Class.forName("java.util.ArrayList");//获取字节码对象
		Method method = clazz.getMethod("add", Object.class);//获取add方法
		method.invoke(list, "你好");
		
		System.out.println(list);
	}
}

```
### 9. 通过反射写一个通用的设置某个对象的某个属性为指定的值
    1. 案例展示
        1. public void setProperty(Object obj,String propertyName,Object value){}，此方法可以将obj对象中名为propertyName的属性的值设置为value
```java
package com.leeup.javase.day27.test;

import java.lang.reflect.Field;

public class Tool {

	//此方法可将obj对象中名为propertyName的属性值设置为value
	public void setProperty(Object obj,String propertyName,Object value) throws Exception {
		Class clazz = obj.getClass();	//获取字节码对象
		Field field = clazz.getDeclaredField(propertyName);	//暴力反射获取字段
		field.setAccessible(true);
		field.set(obj, value);
	}
}

```
```java
package com.leeup.javase.day27.test;
/**
 * 通过反射写一个通用的设置某个对象的某个属性为指定的值
 * @author 李闯
 *
 */
public class Test3 {

	public static void main(String[] args) throws Exception {
		Student student = new Student("张三",23);
		System.out.println(student);
		
		System.out.println("修改后如下：");
		Tool tool = new Tool();
		tool.setProperty(student, "name", "李四");
		System.out.println(student);
	}
}


class Student{
	private String name;
	private int age;
	public Student() {
		super();
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
```
### 10. 反射练习
    1. 已知一个类，定义如下：
        package com.leeup; 
            public class DemoClass {
                public void run (){
                    System.out.println("Welcome to here!");
                }
            }
        1. 写一个Properties格式的配置文件，配置类的完整名称
        2. 写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，用反射的方式运行run方法
```java
package com.leeup.javase.day27.test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("xxx.properties"));		//创建输入流关联文件
		Class clazz = Class.forName(br.readLine());										//读取配置文件中的类名。获取字节码对象
		
		DemoClass dc = (DemoClass) clazz.newInstance();			//通过字节码对象创建对象
		dc.run();
		
	}
}
```

```java
package com.leeup.javase.day27.test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("xxx.properties"));		//创建输入流关联文件
		Class clazz = Class.forName(br.readLine());										//读取配置文件中的类名。获取字节码对象
		
		DemoClass dc = (DemoClass) clazz.newInstance();			//通过字节码对象创建对象
		dc.run();
		
	}
}

```
```java
com.leeup.javase.day27.test.DemoClass
```

### 11. 动态代理的概述和实现
    1. 动态代理概述
        1. 代理：本来应该自己做的事情，请了别人来做，被请的人就是代理对象
        2. 举例：春节回家买票让人代买
        3. 动态代理：在程序运行过程中产生的这个对象，而程序运行过程中产生对象其实就是我们刚才反射讲到的内容，所以，动态代理就是通过反射来生成一个代理
        4. 在java中java.lang.reflect包下提供了一个Proxy类和一个InVocationHandler接口，通过使用这个类和这个接口就可以生成动态代理对象。JDK提供的代理只能针对接口做代理，我们有更强大的代理cglib，Proxy类中的方法创建动态代理类对象
        5. public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
        6. 最终会调用InvocationHandler的方法1
        7. InvocationHandler Object invoke(Object proxy,Method method,Object[] args)
```java
package com.leeup.javase.day27.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{

	private Object target;
	
	public MyInvocationHandler(Object target) {
		this.target = target;
	}	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("权限校验");
		method.invoke(target, args);		//执行被代理target对象的方法
		System.out.println("日志记录");
		return null;
	}

}

```
```java
package com.leeup.javase.day27.动态代理;

public interface Student {

	public void login();
	
	public void submit();
}

```
```java
package com.leeup.javase.day27.动态代理;

public class StudentImpl implements Student{

	@Override
	public void login() {
		System.out.println("登录");
	}

	@Override
	public void submit() {
		System.out.println("提交");
	}

}

```
```java
package com.leeup.javase.day27.动态代理;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		/*
		UserImpl userImpl = new UserImpl();
		userImpl.add();
		userImpl.delete();
		
		System.out.println("分割线");
		MyInvocationHandler m = new MyInvocationHandler(userImpl); 
		User u = (User)Proxy.newProxyInstance(userImpl.getClass().getClassLoader(), 
				userImpl.getClass().getInterfaces(), m);
		u.add();
		u.delete();
		*/
		StudentImpl si = new StudentImpl();
		si.login();
		si.submit();
		System.out.println("================");
		MyInvocationHandler m = new MyInvocationHandler(si); 
		Student s = (Student)Proxy.newProxyInstance(si.getClass().getClassLoader(), 
				si.getClass().getInterfaces(), m);
		
		s.login();
		s.submit();
	}
}

```
```java
package com.leeup.javase.day27.动态代理;

public interface User {

	public void add();
	
	public void delete();
}

```
```java
package com.leeup.javase.day27.动态代理;

public class UserImpl implements User{

	@Override
	public void add() {
		//每次两个功能都要修改源代码,比较麻烦,使用动态代理
//		System.out.println("权限校验");
		System.out.println("添加功能");
//		System.out.println("日志记录");
	}

	@Override
	public void delete() {
//		System.out.println("权限校验");
		System.out.println("删除功能");
//		System.out.println("日志记录");
	}

}

```
### 12. 模板(template)设计模式概述和使用
    1. 模板设计模式概述
        1. 模板方法模式就是定义一个算法的股价，而将具体的算法延迟到子类中来实现
    2. 优点和缺点
        1. 优点
            1. 使用模板方法模式，在定义算法骨架的同时，可以很领过的实现具体的算法，满足用户灵活多变的需求
        2. 缺点
            1. 如果算法股价有修改的话，则需要修改抽象类
```java
package com.leeup.javase.day27.模板方法设计模式;
/**
 * 模板(template)设计模式概述和使用
 * @author 李闯
 *
 */
public class Demo1_Template {

	public static void main(String[] args) {
		Demo demo = new Demo();
		System.out.println(demo.getTime());
	}
}

abstract class getTime {
	public final long getTime() {					//final修饰为了不让子类重写
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		return end - start;
	}

	public abstract void code();
}


class Demo extends getTime {

	@Override
	public void code() {
		int i = 0;
		
		while (i<100000) {
			System.out.println("x");
			i++;
		}
	}
	
}
```
1. 装饰
2. 单例
3. 简单工厂
4. 工厂方法
5. 适配器
6. 模板

### 13. 自己实现枚举类
    1. 枚举概述，
        1. 是将变量的值一一列出来，变量的值只限于列举出来的值得范围内，举例：一周只有七天，一年只有12个月等
    2. 回想单例设计模式：单例类是一个类只有一个实例
        1. 那么多例类就是一个类有多个实例，但不是无限个数得实例，而是有限个数的实例。这才是枚举类
    3. 案例展示
        1. 自己实现枚举类
1. 自动拆装箱
2. 泛型
```java
package com.leeup.javase.day27.枚举;
/**
 * 
 * @author 李闯
 *
 */
public class Demo1_Enum {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		Week3 mon = Week3.MON;
		mon.show();
	}

	private static void demo2() {
		Week2 week2 = Week2.MON;
		System.out.println(week2);
	}

	private static void demo1() {
		Week mon = Week.MON;
		Week tue = Week.TUE;
		Week wed = Week.WED;
		
		
		System.out.println(mon);
		System.out.println(tue);
		System.out.println(wed);
	}
}

```
```java
package com.leeup.javase.day27.枚举;

public class Week {

	private Week() {}			//私有构造不让其他类创建本类对象
	
	//枚举的第一种方式
	public static final Week MON = new  Week();
	public static final Week TUE = new  Week();
	public static final Week WED = new  Week();
}

```
```java
package com.leeup.javase.day27.枚举;

public class Week2 {

	
	//枚举的第二种方式
	public static final Week2 MON = new  Week2("星期一");
	public static final Week2 TUE = new  Week2("星期二");
	public static final Week2 WED = new  Week2("星期三");
	
	private String name;
	private Week2(String name) {
		this.name = name;
	}
}

```
```java
package com.leeup.javase.day27.枚举;

public abstract class Week3 {

	
	//枚举的第三种方式
	public static final Week3 MON = new  Week3("星期一") {		//匿名内部类,父类引用指向子类对象,在这里new一个类小括号大括号就是继承这个类
		public void show() {
			System.out.println("星期一");
		}
	};
	public static final Week3 TUE = new  Week3("星期二"){
		public void show() {
			System.out.println("星期二");
		}
	};
	public static final Week3 WED = new  Week3("星期三"){
		public void show() {
			System.out.println("星期三");
		}
	};
	
	private String name;
	private Week3(String name) {
		this.name = name;
	}
	
	public abstract void show();
}

```
### 14. 通过ENUM实现枚举类
    1. 案例展示
        1. 通过enum实现枚举类
```java
package com.leeup.javase.day27.枚举2;

public class Demo1_Enum {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		Week3 mon = Week3.MON;
		mon.show();
	}

	private static void demo2() {
		Week2 mon = Week2.MON;
		
		
		System.out.println(mon.getName());
	}

	private static void demo1() {
		Week mon = Week.MON;
		System.out.println(mon);		//将实例名字说出来
	}
}

```
```java
package com.leeup.javase.day27.枚举2;

public enum Week {

	MON,TUE,WED;
	
}

```
```java
package com.leeup.javase.day27.枚举2;

public enum Week2 {

	MON("星期一"),TUE("星期二"),WED("星期三");
	
	private String name;
	
	private Week2(String name) {
		this.name = name();
	}

	public String getName() {
		return name;
	}
}

```
```java
package com.leeup.javase.day27.枚举2;

public enum Week3 {

	MON("星期一"){
		public void show() {
			System.out.println("星期一");
		}
	},TUE("星期二"){
		public void show() {
			System.out.println("星期二");
		}
	},WED("星期三"){
		public void show() {
			System.out.println("星期三");
		}
	};
	
	private String name;
	
	private Week3(String name) {
		this.name = name();
	}

	public String getName() {
		return name;
	}
	
	public abstract void show();
}

```

### 15. 枚举的注意事项
    1. 案例展示
        1. 定义枚举类要用关键字enum
        2. 所有枚举类都是enum的子类
        3. 枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的，但是如果枚举类有其他的东西，这个分号不能省略，建议不要省略
        4. 枚举类可以有构造器，但必须是private的，他默认的也是private的
        5. 枚举类也可以有抽象方法，但是枚举项必须重写该方法
        6. 枚举在switch语句中的使用
```java
		Week3 wed = Week3.WED;
		switch (wed) {
		case MON:
			System.out.println("星期一");
			break;
		case TUE:
			System.out.println("星期二");
			break;
		case WED:
			System.out.println("星期三");
			break;
		}
	}

```
### 16. 枚举类的常见方法
    1. 枚举类的常见方法
        1. int ordinal()
        2. int compareTo(E o)
        3. String name()

### 17. JDK7的六个新特性回顾和讲解
    1. 二进制字面量
    2. 数字字面量可以出现下划线
    3. switch语句可以用字符串
    4. 泛型简化，菱形泛型
    5. 异常的多个catch合并，每个异常用或|
    6. try-catch-resources 语句
```java
package com.leeup.javase.day27.jdk7;
/**
 *  1. 二进制字面量
    2. 数字字面量可以出现下划线
    3. switch语句可以用字符串
    4. 泛型简化，菱形泛型
    5. 异常的多个catch合并，每个异常用或|
    6. try-catch-resources 语句		1.7之后,标准的异常处理代码,关流
    
    1000000
 * @author 李闯
 *
 */
public class Demo1_JDK7 {

	public static void main(String[] args) {
		System.out.println(0b110);		//jdk7之前不允许这样表示
		System.out.println(100_000);	//为了看的方便,可以有下划线,输出时不会输出_,只能在数字中使用
		
	}
}

```

### 18. JDK8新特性
    1. 接口中可以定义有方法体的方法。如果是非静态必须用default修饰
    2. 如果是静态的就不用了
    3. 局部内部类在访问他所在方法中的局部变量必须用final修饰，为什么？因为当调用这个方法时，局部变量如果没有用final修饰，它的生命周期和方法的生命周期是一样的，当方法弹栈，这个局部变量也会消失，那么如果局部内部类对象还没有马上消失想用这个局部变量，就没有了，如果用final修饰会在类加载的时候进入常量池，即使方法弹栈，常量池的常量还在，还可以继续使用
```java
package com.leeup.javase.day27.jdk8;


public class Demo1 {

	public static void main(String[] args) {
		/*
		Demo d = new Demo();
		d.print();
		
		Inter.method();
		*/
		
		Demo demo = new Demo();
		demo.run();
	}
}

interface Inter {
	public default void print() {				//必须是default
		System.out.println("Hello World");
	}
	
	public static void method() {				//
		System.out.println("static method");
	}
}

class Demo implements Inter {
	
	public void run() {
		
		int num = 10;
		
		class Inner {
			public void function() {
				System.out.println("fun");
				
//				num = 20;		系统默认会自动加上final
				/**
				 * 1.7 之前不能直接输出,因为局部内部类使用方法中的局部变量必须用方法修饰
				 */
				System.out.println(num);
			}
		}
		Inner inner = new Inner();
		inner.function();
	}
}
```
### 19. 复习