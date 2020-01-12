## day08面向对象_继承&方法

### 1. 代码块的概述和分类
    1. 代码块概述
        1. 在java中，使用{}括起来的代码被称为代码块
    2. 代码块分类
        1. 根据其位置和声明得不同，可以分为局部代码块，构造代码块，静态代码块，同步代码块(多线程讲解)
    3. 常见代码块的应用
        1. 局部代码块
            1. 在方法中出现，限定变量生命周期，及早释放，提高内存利用率
        2. 构造代码块(初始化块)
            1. 在类中方法外出现，多个构造方法中相同的代码块存放到一起，每次调用构造都执行，并且在构造方法前执行
        3. 静态代码块
            1. 在类中方法外出现，加上static修饰
            2. 在类中方法外出现，并加上static修饰，用于给类进行初始化，在类加载的时候就执行，并且只执行一次
            3. 一般用于加载驱动
```java
package com.leeup.javase.day08.代码块;
/**
 * 代码块相关知识展示
 * @author 李闯
 *
 */
public class Demo1_Code {
	
	public static void main(String[] args) {

		Student s1 = new Student();		//创建对象测试构造代码块
		System.out.println("===========");
		Student s2 = new Student("张三",23);
		//创建一次对象，构造代码块会跟着执行一次
		//构造代码块会跟构造函数一起执行，无论执行的是哪个构造函数，他都会优先去执行构造代码块，再执行构造函数
		//实际用途：例如学生，每个学生都具备一个方法，学习，每个学生都要具备学习的方法，即然每次创建学生
		//都要先走构造代码块，再走构造方法，那么我们在构造代码块中调用学生学习的方法即可
		//开发中并不常用
		
		
		//局部代码块
		{
			/**
			 * 这个范围内定义的变量x，不在该大括号范围内不能调用，这里的语句执行完毕，
			 * x就会被释放掉，如同for语句定义的i值
			 * 
			 */
			int x = 10;
			System.out.println(x);
		}
	}
	//静态代码块优先于主方法执行的，
	static {
		System.out.println("我在主方法类中的静态代码块");
	}
}

class Student{
	
	private String name;
	private int age;
	
	//构造代码块
	{
		study();
		System.out.println("我是构造代码块");
	}
	
	public Student() {
		System.out.println("我是空参构造");
	}
	
	public Student(String name,int age) {
		System.out.println("我是有参构造");
		this.age = age;
		this.name = name;
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
	
	public void study() {
		System.out.println("学生学习");
	}
	
	//静态代码块
	/**
	 * 随着类的加载而加载，只会执行一次
	 * 作用：用来给类进行初始化，一般用来加载驱动[比如一个程序启动起来程序只需要启动一次就可以了]
	 * 
	 */
	static {
		System.out.println("我是静态代码块");
	}	
}
```

### 2. 代码块的面试题
```java
package com.leeup.javase.day08.代码块;
/**
 * 代码块相关面试题
 * 问：输出的结果是什么？
 * @author 李闯
 *
 */
public class Student {

	static {
		System.out.println("Student 静态代码块");
	}
	{
		System.out.println("Student 构造代码块");
	}
	public Student() {
		System.out.println("Student 构造方法");
	}
}

class Demo2_Student{
	static {
		System.out.println("Demo2_Student 静态代码块");
	}
	
	public static void main(String[] args) {
		System.out.println("我是main方法");
		Student s1 = new Student();
		
		Student s2 = new Student();
	}
}
```
### 3. 继承案例展示
    1. 继承(extends)
        1. 让类与类之间产生关系，子父级关系
    2. 继承案例展示
        1. 动物类，猫类，狗类
        2. 定义两个属性(颜色，腿的个数)两个功能(吃饭睡觉)
    3. 案例展示
        1. 使用继承前
    4. 案例展示
        1. 使用继承后
```java
package com.leeup.javase.day08.继承;

public class Demo1_Extends {

	public static void main(String[] args) {
		/**
		 * 猫合狗继承了动物类之后，将猫和狗本身的属性代码和方法代码注释掉
		 * 依旧可以使用属性和方法[即可以通过父类拿到父类的属性和方法]
		 */
		Cat cat = new Cat();
		cat.color = "白色";
		cat.leg = 4;
		cat.eat();
		cat.sleep();
		
		System.out.println("颜色"+cat.color+"，腿个数"+cat.leg);
	}
}


class Animal{
	String color;
	int leg;
	
	public void eat() {
		System.out.println("吃饭");
	}
	
	public void sleep() {
		System.out.println("睡觉");
	}
}

/**
 * 两个子类，猫和狗，相似的地方太多，他们有一个共同的父类，动物类
 * 
 * @author 李闯
 *
 */
class Cat extends Animal{
//	String color;
//	int leg;
//	
//	public void eat() {
//		System.out.println("吃饭");
//	}
//	
//	public void sleep() {
//		System.out.println("睡觉");
//	}
}

class Dog extends Animal{
//	String color;
//	int leg;
//	
//	public void eat() {
//		System.out.println("吃饭");
//	}
//	
//	public void sleep() {
//		System.out.println("睡觉");
//	}
}
```

### 4. 继承的好处和弊端
    1. 继承的好处
        1. 提高的代码的复用性
            1. 即大量属性方法定义在父类中，子类中不需要单独定义了，即提高了代码复用性
        2. 提高了代码的维护性
            1. 如果有一个动物共同的属性或者方法，直接在父类中定义，不需要一个个为子类定义，就是实现了共享属性/方法
        3. 让类与类之间产生了关系，是多态的前提
            1. 多态的前提就是必须要有多态，没有继承就没有多态
    2. 继承的弊端
        1. 类的耦合性增强了
            1. 就是类与类之间的紧密度增强了
            2. 两个类非常紧密，父类随意增加一个属性，子类就多了一个属性，有的时候是期望这样的，有的时候并不期望。即父类的变化影响了子类的变化
        2. 开发的原则：高内聚，低耦合
        3. 耦合：类与类的关系
        4. 内聚：就是自己完成某件事的能力

### 5. java中类的继承特点
    1. java中类的继承特点
        1. java中只支持单继承，不支持多继承(一个儿子只能有一个爹)
            1. 有些语言支持多继承，格式extends 类1，类2，...
        2. java支持多层继承(继承体系)
            1. 例如DemoB继承DemoA,DemoC继承DemoB
    2. 案例展示
        1. java中类的继承特点
            1. 如果想用这个体系的所有功能用最底层的类创建对象
                1. 如果想使用一个继承体系中所有方法，应使用最底层的类创建对象，即上面例子的DemoC类，如果用DemoA创建的对象，只能使用DemoA中的方法，即子类可以使用父类的的东西，但父类不允许使用子类的东西。
            2. 如果想看这个体系的共性功能，看最顶层的类
                1. 即DemoA中的方法是所有继承他的类共有的

### 6. 继承的注意事项和什么时候使用继承
	1. 继承的注意事项
		1. 子类只能继承父类的所有非私有的成员(成员方法和成员变量)
		2. 子类不能继承父类的构造方法，但是可以通过super关键字去访问父类构造方法
		3. 构造方法与类名一致，所以自己是自己的构造方法，是用来给本类创建对象使用的，不可能把构造方法继承下来
		4. 不要为了部分功能去继承
			1. 不能因为项目经理与程序员有几个共性属性就项目经理继承程序员或者程序员继承项目经理，应该将共性抽取出来为员工或者职员
		5. 项目经理  姓名 工号 工资 奖金
		6. 程序员    姓名 工号 工资
	2. 什么时候使用继承
		1. 继承其实体现的是一种关系："is a"。
			1. Person
				1. Student
				2. Teacher
			2. 水果
				1. 苹果
				2. 香蕉
				3. 橘子
		2. 采用假设法子
			1. 如果有两个类A,B，只有他们符合A是B的一种，或者是B是A的一种，就可以考虑使用继承。
```java
package com.leeup.javase.day08.继承;

public class Demo3_Extends {

	public static void main(String[] args) {
		Son son = new Son();
		son.show();
	}
}

class Father{
	private String name;
	/**
	 * show方法定义为privte的时候，子类无法访问
	 */
	public void show() {
		System.out.println("Hello World");
	}
}

class Son extends Father{
	
}
```
### 7. 继承中成员变量的关系
	1. 案例展示
		1. 不同名的变量
		2. 同命的变量
```java
package com.leeup.javase.day08.继承;

public class Demo4_Extends {

	public static void main(String[] args) {
		
		/**
		 * 不同名的变量
		 */
		Son1 son1 = new Son1();
		son1.print();
	}
}

class Father1{
	int num1 = 10;
	int num2 = 30;
}

class Son1 extends Father1{
	int num2 = 20;
	public void print() {
		System.out.println(num1);
		System.out.println(num2);	//当父类也有num2并且值为30时，输出结果还是20，因为就近原则，子类有就不用父类的了。
									//子父类出现了同名的变量只是举例为之，在开发中是不会出现这种情况的，因为子类继承父类
									//是为了使用父类的属性，既然子类中都有了num2属性，就不用在父类中再次定义了
	}
}
```

### 8. this和super的区别和应用
	1. this和super都代表什么
		1. this：代表当前对象的引用，谁来调用我，我就代表谁
		2. super：代表当前对象父类的引用
	2. this和super的使用区别
		1. 调用成员变量
			1. this.成员变量 调用本类的成员变量，也可以调用父类的成员变量
			2. super.成员变量 调用父类的成员变量
		2. 调用构造方法
			1. this(...) 调用本类的构造方法
			2. super(...) 调用父类的构造方法
		3. 调用成员方法
			1. this.成员方法 调用本类的成员方法。也可以调用父类的方法
			2. super.成员方法 调用父类的成员方法

### 9. 继承中构造方法的关系
	1. 案例展示
		1. 子类中所有的构造方法默认都会访问父类中空参数的构造方法
	2. 为什么呢？
		1. 因为子类会继承父类中的数据，可能还会使用父类中的数据
		2. 所以，子类初始化之前，一定要先完成父类数据的初始化
		3. 其实:
			1. 每一个构造方法的第一条语句默认都是：super() Object类最顶层的父类
```java
package com.leeup.javase.day08.继承;

public class Demo5_Extends {

	public static void main(String[] args) {
		Son2 s = new Son2();//创建son对象时默认执行无参构造方法，会输出语句，但是父类的无参构造方法输出语句也会执行
							//因为子类中隐藏了一个super();方法
	}
}

class Father2{
	public Father2() {
		System.out.println("Father的构造方法");
	}
}
class Son2 extends Father2{
	
	public Son2(){
		super();			//这是一条语句，如果你不写，系统会默认加上，作用是用来访问父类中的空参构造 
							//因为子类继承父类，可能要使用父类的数据，所以子类初始化之前，要先使用父类构造方法,即先初始化父类，再初始化子类
		System.out.println("Son 的构造方法");
	}
}
```

### 10. 继承中构造方法的注意事项
	1. 案例演示
		1. 父类没有无参构造方法,子类怎么办?
		2. super解决
		3. this解决
	2. 注意事项
		1. super(…)或者this(….)必须出现在构造方法的第一条语句上，即一个方法中只会存在一个super或者this

### 11. 继承中的面试题
	1. 案例展示
		1. 看程序写结果1
```java
		class Fu{
			public int num = 10;
			public Fu(){
				System.out.println("fu");
			}
		}
		class Zi extends Fu{
			public int num = 20;
			public Zi(){
				System.out.println("zi");
			}
			public void show(){
				int num = 30;
				System.out.println(num);
				System.out.println(this.num);
				System.out.println(super.num);
			}
		}
		class Test1_Extends {
			public static void main(String[] args) {
				Zi z = new Zi();
				z.show();
			}
		}
```
		看程序写结果2
```java
class Test2_Extends {
	public static void main(String[] args) {
		Zi z = new Zi();
	}
	/*
	1,jvm调用了main方法,main进栈
	2,遇到Zi z = new Zi();会先将Fu.class和Zi.class分别加载进内存,再创建对象,当Fu.class加载进内存
	父类的静态代码块会随着Fu.class一起加载,当Zi.class加载进内存,子类的静态代码块会随着Zi.class一起加载
	第一个输出,静态代码块Fu,第二个输出静态代码块Zi
	3,走Zi类的构造方法,因为java中是分层初始化的,先初始化父类,再初始化子类,所以先走的父类构造,但是在执行
	父类构造时,发现父类有构造代码块,构造代码块是优先于构造方法执行的所以
	第三个输出构造代码块Fu,第四个输出构造方法Fu
	4,Fu类初始化结束,子类初始化,第五个输出的是构造代码块Zi,构造方法Zi
	*/
}
class Fu {
	static {
		System.out.println("静态代码块Fu");
	}

	{
		System.out.println("构造代码块Fu");
	}

	public Fu() {
		System.out.println("构造方法Fu");
	}
}

class Zi extends Fu {
	static {
		System.out.println("静态代码块Zi");
	}

	{
		System.out.println("构造代码块Zi");
	}

	public Zi() {
		System.out.println("构造方法Zi");
	}
}
```

### 12. 继承中成员方法关系
	1. 案例演示
		1. 不同名的方法
		2. 同名的方法
```java
package com.leeup.javase.day08.继承;
/**
 * 不同名方法和同名方法
 * @author 李闯
 *
 */
public class Demo7_Extends {

	public static void main(String[] args) {
		Son4 s = new Son4();
		s.print();			//当子类出现与父类方法相同时，会自己调用子类的方法，这个叫"重写"
		s.method();
	}
}

class Father4{

	public void print() {
		System.out.println("fu print");
	}
}

class Son4 extends Father4{
	public void method() {
		System.out.println("zi method");
	}
	
	public void print() {			
		super.print();		//依然可以使用super调用父类的方法
		System.out.println("zi print");
	}
}
```
### 13. 方法重写概述及其应用
	1. 什么是方法重写
		1. 重写：子父类出现了一模一样的方法(注意：返回值类型可以是子父类，这个我们学完面向对象讲)
	2. 方法重写的应用
		1. 当子类需要父类的功能，而功能主体子类有自己的特有内容时，可以重写父类中的方法，这样，即沿袭了父类的功能，又定义了子类特有的内容
	3. 案例展示
		1. 定义一个手机类
```java
class Demo7_Phone {
	public static void main(String[] args) {
		Ios8 i = new Ios8();
		i.siri();
		i.call();
	}
}

/*
B:方法重写的应用：
	* 当子类需要父类的功能，而功能主体子类有自己特有内容时，可以重写父类中的方法。这样，即沿袭了父类的功能，又定义了子类特有的内容。
	ios7系统 siri speak English
	ios8系统 siri 说中文
*/

class Ios7 {
	public void call() {
		System.out.println("打电话");
	}

	public void siri() {
		System.out.println("speak English");
	}
}

class Ios8 extends Ios7 {
	public void siri() {
		
		System.out.println("说中文");
		super.siri();
	}
}
```

### 14. 方法重写的注意事项
	1. 方法重写的注意事项
		1. 父类中私有方法不能被重写
			1. 因为父类私有方法子类根本就无法继承
		2. 子类重写父类方法时，访问权限不能更低
			1. 最好就一致
			2. 子类是为了比父类更加强大，所以访问权限应该比父类更大，功能更大，不然直接访问父类就好了。
		3. 父类静态方法，子类也必须通过静态方法进行重写
			1. 其实这个算不上方法重写，但是现象确实如此，至于为什么算不上方法重写，多态中我会讲解(静态只能覆盖静态)
		4. 子类重写父类方法的时候，最好声明一模一样
	2. 案例展示
		1. 方法重写注意事项 

### 15. 方法重写的面试题
	1. 方法重写的面试题
		1. Override和Overload的区别?Overload能改变返回值类型吗?
		2. overload可以改变返回值类型,只看参数列表
		3. 方法重写：子类中出现了和父类中方法声明一模一样的方法。与返回值类型有关,返回值是一致(或者是子父类)的
		4. 方法重载：本类中出现的方法名一样，参数列表不同的方法。与返回值类型无关。
		5. 子类对象调用方法的时候：
		6. 先找子类本身，再找父类。

### 16. 使用继承前的学生和老师案例
	1. 案例展示
		1. 使用继承前的学生和老师案例
		2. 属性：姓名，年龄
		3. 行为：吃饭
		4. 老师特有的方法：讲课
		5. 学生特有的方法：学习

### 17. 使用继承后的学生和老师案例
	1. 案例演示
		1. 使用继承后的学生和老师案例

### 18. 猫狗案例分析,实现及测试
	1. 猫狗案例分析
	2. 案例演示
		1. 猫狗案例继承版
		2. 属性:毛的颜色,腿的个数
		3. 行为:吃饭
		4. 猫特有行为:抓老鼠catchMouse
		5. 狗特有行为:看家lookHome
```java
package com.leeup.javase.day08.继承;

public class Test5_Animal {

	public static void main(String[] args) {
		Cat1 cat1 = new Cat1("黄色", 4);
		System.out.println(cat1.getColor()+"..."+cat1.getLeg());
		cat1.eat();
		cat1.catchMouse();
		
		Dog1 dog1 = new Dog1("黑色",4);
		System.out.println(dog1.getColor()+"..."+dog1.getLeg());
		dog1.eat();
		dog1.lookHome();
	}
}

class Animal1{
	private String color;
	private int leg;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getLeg() {
		return leg;
	}
	public void setLeg(int leg) {
		this.leg = leg;
	}
	public Animal1(String color, int leg) {
		this.color = color;
		this.leg = leg;
	}
	public Animal1() {
	}
	public void eat() {
		System.out.println("吃饭");
	}
}

class Cat1 extends Animal1{
	public Cat1(){
		
	}
	
	public Cat1(String color,int leg) {
		super(color,leg); 
	}
	
	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	public void catchMouse() {
		System.out.println("抓老鼠");
	}
}

class Dog1 extends Animal1{
	public Dog1(){
		
	}
	
	public Dog1(String color,int leg) {
		super(color,leg); 
	}
	
	public void eat() {
		System.out.println("狗吃肉");
	}
	
	public void catchMouse() {
		System.out.println("抓老鼠");
	}

	public void lookHome() {
		System.out.println("狗看家");
	}
}
```

### 19. final关键字修饰类,方法以及变量的特点)(掌握)
	1. final概述
		1. final是最终的
		2. final作用:
			1. 定义一些固定的值，统一声明比较好
		3. 通常会增加两个修饰符
			1. piblic staic final double PI = 3.14
	2. final修饰特点
		1. 修饰类，类不能被继承
		2. 修饰变量，变量就变成了常量，只能被赋值一次
		3. 修饰方法，方法不能被重写
	3. 案例演示
		1. final修饰特点
```java
package com.leeup.javase.day08.final1;

public class Demo1_Final {

	public static void main(String[] args) {
		Son son = new Son();
		son.print();
	}
}

//class Father{
//	public/*final*/ void print() {				//加了final关键字的方法不能被重写,
//												//final修饰的类，不能被继承
//												//修饰变量，变量就变成了常量，只能被赋值一次
//		System.out.println("访问底层数据资源");
//	}
//}

class Son /*extends Father*/{
	final int NUM =10;//常量命名规范，如果是一个单词，所有字母大写，每个单词都大写，中间用下划线隔开
	public void print() {
//		NUM = 20;	//当变量为final修饰的时候，num就变成了常量，不能被修改
		System.out.println(NUM);
	}
}
```

###08.20_面向对象(final关键字修饰局部变量)(掌握)
	1. 案例演示
		1. 方法内部或者方法声明上都演示一下(了解)
	2. 基本类型，是值不能被改变
	3. 引用类型，是地址值不能被改变,对象中的属性可以改变
```java
package com.leeup.javase.day08.final1;

public class Demo2_Final {

	public static void main(String[] args) {
		final int NUM = 10;
//		NUM = 20;	无法修改常量的值，即基本数据类型值不能被改变
		final Person person = new Person("张三",23);
//		person = new Person("李四",24);	同样地址值也不可以被修改,但是对象的属性值是可以被修改的
		person.setName("李四");
		person.setAge(24);
		System.out.println(person.getName()+"..."+person.getAge());
		
		method(20);
	}
	
	public static void method(final int x) {		//方法生命上使用final修饰
		System.out.println(x);
	}
	
}

class Person{
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String name,int age) {
		this.age = age;
		this.name = name;
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
}
```

###08.21_面向对象(final修饰变量的初始化时机)(掌握)
	1. final修饰变量的初始化时机
		1. 显示初始化 
	2. 在对象构造完毕前即可
```java
package com.leeup.javase.day08.final1;

public class Demo3_Final {

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.print();
	}
}

class Demo{
//	final int num = 10; //显示初始化的时候调用方法输出可以，final修饰的值只能被赋值一次
	final int num;		//默认初始化值0是无效的值，所以这里必须如上显式初始化
	
	
	//如果num不赋值，但是使用构造方法初始化也可以
	public Demo() {
		num = 10;
	}
			
	public void print() {
		System.out.println(num);
	}
}
```
###08.22_day08总结
	1. 把今天的知识点总结一遍。