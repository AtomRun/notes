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
```java
package com.leeup.javase.day07.创建对象的步骤;

public class Demo1_Student {

	public static void main(String[] args) {
		Student student = new Student();
		student.show();
	}
}

class Student{
	private String name = "张三";
	private int age = 23;
	
	public Student() {
		name = "李四";
		age = 24;
	}
	public void show() {
		System.out.println("我的名字是"+name+"，我的年龄是"+age);
	}
}
```
![对象创建过程做了哪些事](https://github.com/AtomRun/notes/blob/master/noteimages/%E5%88%9B%E5%BB%BA%E5%AF%B9%E8%B1%A1%E5%86%85%E5%AD%98%E5%9B%BE.png)

### 7. 长方形案例练习
    1. 案例展示
        1. 需求：
            1. 定义一个长方形类，定义求周长和面级的方法
            2. 然后定义一个测试类进行测试
```java
package com.leeup.javase.day07.练习;


public class Test1_Rectangle {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10, 20);
		System.out.println("周长为："+rectangle.getLength());
		System.out.println("面积为："+rectangle.getArea());
	}
}

/**
 * 长方形类
 * @author 李闯
 *
 */
class Rectangle{
	
	private int width;
	private int height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(int width,int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	//求周长方法
	public int getLength() {
		return (width+height) * 2;
	}
	
	//求面积方法
	public int getArea() {
		return width * height;
	}
}
```

### 8. 员工类案例练习
    1. 案例展示
        1. 需求：定义一个员工类Employee
        2. 自己分析出几个成员，然后给出成员变量
            1. 姓名，工号，工资
        3. 构造方法
            1. 空参和有参的
        4. getXxx()和setXxx()方法
        5. 以及一个显示所有成员信息的方法，并测试
            1. work
```java
package com.leeup.javase.day07.练习;
/**
 * 员工
 * @author 李闯
 *
 */
public class Test2_Employee {

	public static void main(String[] args) {
		Employee employee = new Employee("老刘", "FG12343", 4789.0);
		employee.work();
	}
}

class Employee{
	private String name;
	private String id;
	private double salary;
	
	public Employee() {
		
	}
	
	public Employee(String name,String id,Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void work() {
		System.out.println("我的姓名是："+name+"，我的工号是"+id+"，我的工资是"+salary+"，我的工作是敲代码");
	}
}
```
### 9. static关键字及内存图
    1. 案例展示
        1. 通过一个案例引入static关键字
        2. 人类：Person，每个人都有国籍，中国
    2. 画图展示
![static关键字及其内存图](https://github.com/AtomRun/notes/blob/master/noteimages/%E9%9D%99%E6%80%81%E5%86%85%E5%AD%98%E5%9B%BE.png)
```java
package com.leeup.javase.day07.static1;

public class Demo1_Static {

	public static void main(String[] args) {
		Person p1 = new Person();	//创建对象
		/**
		 * 调用属性并赋值
		 * 这里不是私有属性，所以可以直接调用并且赋值，如果是私有属性需要get/set方法来调用赋值了
		 */
		p1.name = "苍老师";//调用姓名属性并且赋值
		p1.country = "日本";//调用国籍属性并且赋值
		
		p1.speak();
		
		Person p2 = new Person();
		p2.name = "小泽老师";
//		p2.country = "日本";
		
		p2.speak();		//如果country加了static,那么p1的country赋值了之后，这个speak输出的country
						//的值也会是日本，因为static修饰的变量值是共享的。
		/**
		 * 
		 * static属性的好处：多个对象共享同一个属性，节约内存
		 */
	}
}

class Person{
	String name;
	static String country; //加了静态之后，属性值都是共享的
	
	//说话的方法
	public void speak() {
		System.out.println("我的名字是"+name+"，我来自于"+country);
	}
}
```

### 10. static关键字的特点
    1. static关键字的特点
        1. 随着类的加载而加载
            1. 因为随着字节码加载的时候进入方法区，静态属性会被同时加载到方法区内静态区[共享区]
        2. 优先于对象存在
            1. 随着字节码加载而加载的，那时候还没创建对象，所以优先于对象存在，即先加载进来静态变量再创建对象
        3. 被类的所有对象共享
            1. 举例：咱们班级的学生应该公用同一个班级的编号
            2. 其实这个特点也是在告诉我们什么时候使用静态？
                1. 如果某个成员变量是被所有对象共享的，那么他就应该定义为静态的
            3. 举例：
                1. 饮水机(用静态修饰)
                2. 水杯(不能用静态修饰)
                3. 总结：共性[所有对象都具备的]用静态，个性[特有的属性]用非静态
        4. 可以通过类名调用
            1. 其实他本是也可以通过对象名调用
            2. 推荐使用类名调用
            3. 静态修饰的内容我们一般称其为：与类相关的，
            4. 静态变量：类变量，静态方法：类方法
        5. 案例展示
```java
		Person.country = "日本";		//静态多了一种调用方式，可以通过类名.属性名。也可以使用对象.  或者类名.
										//推荐使用类名. 因为如果只需要调用静态，就不需要创建对象了
		System.out.println(Person.country);
```
### 11. static的注意事项p
    1. static的注意事项
        1. 在静态方法中是没有this关键字的
            1. 如何理解呢?
                1. 静态是随着类的加载而加载，this是随着对象的创建而存在。
                2. 静态比对象先存在。
        2. 静态方法只能访问静态的成员变量和静态的成员方法
            1. 静态方法：
                1. 成员变量：只能访问静态变量
                2. 成员方法：只能访问静态成员方法
            2. 非静态方法：
                1. 成员变量：可以是静态的，也可以是非静态的
                2. 成员方法：可是是静态的成员方法，也可以是非静态的成员方法。
            3. 简单记：
                1. 静态只能访问静态。
    2. 案例演示
        1. static的注意事项
```java
package com.leeup.javase.day07.static1;


public class Demo2_Static {

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.print1();	
		
		Demo.print1();
	}
}

class Demo{
	int num1 = 10;			//静态成员变量
	static int num2 = 20;	//非静态的成员变量
	
	//非静态的成员方法，即可以访问静态的成员，也可以访问非静态的成员
//	public void print1() {
//		System.out.println(num1);
//		System.out.println(num2);
//	}
	
	/**
	 * 为什么静态的不能访问非静态的呢？？
	 * 因为当class一加载到内存中的时候，静态方法或者属性随着类的加载而加载了，
	 * 但是当加载的时候，很有可能并没有创建对象，即非静态的属性值，只有在创建对象的时候才能用。虽然非静态的属性和静态的属性一起被加载进方法区，但是静态的加载了可以直接用
	 * 使用类名直接访问，非静态必须要创建对象，才能调用
	 * 静态方法或者属性值不需要通过new对象也可以调用，优先于对象的存在，在对象还没存在的时候，静态已经存在了
	 */
	
	
	//静态的成员方法
	public static void print1() {
//		System.out.println(num1);	//这里放num1会报错，因为num1是非静态的，静态的成员方法不能访问非静态的属性，会报错
		System.out.println(num2);
		
		/**
		 * 在静态方法中没有this关键字的，为什么？
		 * System.out.println(num1); 这个num1是一个非静态的成员变量，在这里直接写num1，其实就是this.num1，成员变量都是用对象调用的。
		 * this只有创建对象的时候才有值，在类一加载时候，还没创建对象,所以this.num1 这里得this可能是空值。也有可能一直都不创建对象，即只有静态方法的时候，就可以不用创建对象
		 * 
		 * 类加载不一定就是创建对象，调用静态方法也会类加载，所以静态中不能有this，this就必须要有对象，他才有值
		 */
	}
}
```
### 12. 静态变量和成员变量的区别
    1. 静态变量也叫类变量  成员变量也叫对象变量
    2. 所属不同
        1. 静态变量属于类，所以也称之为类变量
        2. 成员变量属于对象，所以也称为实例变量(对象变量)
    3. 内存中位置不同
        1. 静态变量存储于方法区的静态区
        2. 成员变量存储于堆内存
    4. 内存出现时间不同
        1. 静态变量随着类的加载而加载，随着类的消失而消失
        2. 成员变量随着对象的创建而存在，随着对象的消失而消失
    5. 调用不同
        1. 静态变量可以通过类名调用，也可以通过对象调用
        2. 成员变量只能通过对象名调用

### 13. main方法的格式详细解释
    1. 格式
        1. public static void main(String[] args){}
    2. 针对格式的解释
        1. public被jvm调用，访问权限足够大
        2. static被jvm调用，不用创建对象，直接类名访问
        3. void被jvm调用，不需要给jvm返回值
        4. main一个通用的名称，虽然不是关键字，但是被jvm识别
        5. String[] args 以前用于接收键盘录入的
    3. 案例展示
        1. 通过args接收键盘例如数据
```java
package com.leeup.javase.day07.static1;
//需要通过命令行运行java文件    即javaDemo3_Main 参数 参数 参数 参数
public class Demo3_Main {

	public static void main(String[] args) {
		/**
		 * public：被jvm调用，所以权限要足够大
		 * static：被jvm调用，不需要创建对象，直接类名.调用即可
		 * void：被jvm调用不需要有任何返回值
		 * main：只有这样写，才能被jvm识别，main不是关键字
		 * String[] args：以前是用来接收键盘录入的，而现在可以使用Scanner
		 */
		
		System.out.println(args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
	}
}
```

### 14. 工具类中使用静态
    1. 制作一个工具类
        1. 获取最大值
        2. 数组的遍历
        3. 数组的反转
```java
package com.leeup.javase.day07.文档说明书的制作过程;
/**
 * 数组工具类
 * @author 李闯
 *
 */
public class Array_Tool {
	
	/**
	 * 如果一个类中所有的方法都是静态的，那么需要再多做一步
	 * 即私有构造方法，因为构造方法私有了，其他类就不能创建本类对象了，直接使用类名方式调用方法即可
	 * @param arr
	 * @return
	 */

	//1 获取最大值
	//2 数组的遍历
	//3 数组的反转
	
	private Array_Tool() {
		
	}
	
	public static int getMax(int[] arr) {
		int max = arr[0];//记录第一个元素
		
		for (int i = 1; i < arr.length; i++) {//从第二个元素开始遍历
			if (max<arr[i]) {		//max与数组中其他的元素比较
				max = arr[i];		//记录住较大的
			}
		}
		return max;					//将最大值返回
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {//遍历数组
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void arrRverse(int[] arr) {
		for (int i = 0; i < arr.length/2; i++) {//循环次数是元素个数的一半
			/**
			 * arr[0]与arr[arr.length-1-0]交换
			 * arr[1]与arr[arr.length-1-1]交换
			 * arr[2]与arr[arr.length-1-2]交换
			 */
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
}
```
```java
package com.leeup.javase.day07.文档说明书的制作过程;
/**
 * 数组工具类测试类
 * @author 李闯
 *
 */
public class Demo1_ArrayTool {

	public static void main(String[] args) {
		int[] arr = {11,23,54,546,566,23,654,7,2,45,4};
//		Array_Tool array_Tool = new Array_Tool();
//		int max = array_Tool.getMax(arr);	//获取最值
//		System.out.println(max);
//		System.out.println("==========================");
//		array_Tool.print(arr);				//打印
//		System.out.println("==========================");
//		System.out.println("反转后");
//		array_Tool.arrRverse(arr);			//反转
//		
//		array_Tool.print(arr);
		
		//静态方式调用
		Array_Tool.print(arr);
		System.out.println("==========================");
	}
}
```

### 15. 说明书的制作过程
    1. 对工具类加入文档注释
    2. 通过javadoc命令生成说明书
        1. @author(提取作者内容)
        2. @version(提取版本内容)
        3. javadoc -d 制定的文件目录 -author -version ArrayTool.java
        4. @param 参数名称//形式参数的变量名称@return 函数运行完返回的数据
    3. 私有方法加了文档注释也不会显示在doc中

### 16. 如何使用JDK提供的帮助文档
    1. 找到文档，打开文档
    2. 点击显示，找到索引，出现输入框
    3. 你应该知道你找谁？举例：Scanner
    4. 看这个类的结构(需不需要导入包)
        1. 成员变量  字段
        2. 构造方法  构造方法
        3. 成员方法  方法

### 17. 学习Math类的随机功能
    1. 打开JDK提供的帮助文档学习
    2. Math类概述
        1. 类包含用于执行基本数学运算的方法
    3. Math类特点
        1. 由于Math类在java.lang包下，所以不需要导包
        2. 因为它的成员全部是静态的，所以私有了构造方法
    4. 获取随机数的方法
        1. public static double random(); 返回带正号的double值，该值大于等于0.0，且小于1.0
    5. 我要获取一个1-100之间的随机数，怎么办？
    6. int number = (int)(Math.random()*100)+1;
```java
package com.leeup.javase.day07.文档说明书的制作过程;
/**
 * math类测试
 * @author 李闯
 *
 */
public class Demo2_Math {

	public static void main(String[] args) {
//		double d = Math.random();
//		System.out.println(d);
		//Math.random()会生成大于等于0.0并且小于1.0的伪随机数
		for(int i = 0;i< 10 ; i++) {
			System.out.println(Math.random());
		}
		
		//生成1-100的随机数
		//Math.random() 0.0000000-0.9999999
		//Math.random() * 100  范围就变成了0.0000000 - 99.99999999
		//(int)(Math.random() * 100) 0-99   强转之后小数点全部去掉了
		//(int)(Math.random() * 100)+1
		for(int i = 0;i< 10 ; i++) {
			System.out.println((int)(Math.random() * 100)+1);
		}
	}
}
```

### 18. 猜数字小游戏案例
    1. 案例展示
        1. 需求：猜数字小游戏(数据在1-100之间)
```java
package com.leeup.javase.day07.文档说明书的制作过程;

import java.util.Scanner;

/**
 * 猜数字游戏
 * @author 李闯
 *
 */
public class Test1_GuessNum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个1-100之间的整数");
		int guessNum = (int)(Math.random() * 100)+1;//生成需要猜的数
		
		while(true) {								//要猜很多次，用无限循环
			int resultNum = sc.nextInt();			//大家猜的数
			if (guessNum>resultNum) {				//猜的数小于生成的数
				System.out.println("您猜的数小了");
			}else if (resultNum>guessNum) {
				System.out.println("您猜的数大了");		//猜的数大于生成的数
			}else {
				System.out.println("恭喜您猜中了");		//猜对了
				break;
			}
		}
	}
}
```

### 19. 总结
    1. 今天的知识点总结一遍。