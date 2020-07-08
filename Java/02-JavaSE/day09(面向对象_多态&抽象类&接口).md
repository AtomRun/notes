### 1. 多态&抽象类&接口
    1. 多态(polymorphic)概述
        1. 事物存在的多种形态
    2. 多态前提
        1. 要有继承关系
        2. 要有方法重写
        3. 要有父类引用指向子类对象
    3. 案例展示
```java
package com.leeup.javase.day09.多态;

public class Demo1_Polymorphic {

	public static void main(String[] args) {
		Cat cat = new Cat();	//子类引用指向子类对象，这句话可以理解为，猫是一只猫
		cat.eat();
		Animal animal = new Cat();	//父类引用指向子类对象，这句话可以理解为，猫是一只动物
		animal.eat();
	}
}


class Animal{
	public void eat() {
		System.out.println("动物吃饭");
	}
}

class Cat extends Animal {
	public void eat() {
		System.out.println("猫吃鱼");
	}	
}
```

### 2. 多态中的成员访问特点之成员变量
    1. 成员变量
        1. 编译看左边(父类)，运行看左边(父类)。
```java
package com.leeup.javase.day09.多态;

public class Demo2_Polymorphic {

	public static void main(String[] args) {
		Father father = new Son();		//父类引用指向子类对象
		System.out.println(father.num);	//输出结果是10，因为编译看左边，即父类，运行看左边，即父类
		
		Son son = new Son();
		System.out.println(son.num);//如果本类中有，就不需要父类中的属性了，输出结果20，因为是Son类型
	}
}

class Father{
	int num = 10;
	
}

class Son extends Father{
	int num  = 20;
}
```
![多态中的成员变量](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E5%A4%9A%E6%80%81%E4%B8%AD%E7%9A%84%E6%88%90%E5%91%98%E5%8F%98%E9%87%8F.png)

### 3. 多态中的成员访问特点之成员方法
    1. 成员方法
        1. 编译看左边(父类)，运行看右边(子类)。
```java
package com.leeup.javase.day09.多态;

public class Demo2_Polymorphic {

	public static void main(String[] args) {
		Father father = new Son();		//父类引用指向子类对象
		System.out.println(father.num);	//输出结果是10，因为编译看左边，即父类，运行看左边，即父类
		
		Son son = new Son();
		System.out.println(son.num);//如果本类中有，就不需要父类中的属性了，输出结果20，因为是Son类型
		
		
		Father father2 = new Son();		
		father2.print();			//输出的结果是son
		
		/**
		 * 成员方法
		 * 编译看左边(父类)，运行看右边(子类)
		 * Father father2 = new Son();	
		 * 变异的时候，为了保证编译能够通过，先去父类中找是否有print方法
		 * 如果父类中没有print方法，一定会编译不成功
		 * 但是运行的时候是使用的是子类的方法
		 * 这个也叫动态绑定
		 */
	}
}

class Father{
	int num = 10;
	
	public void print() {
		System.out.println("father");
	}
}

class Son extends Father{
	int num  = 20;
	public void print() {
		System.out.println("son");
	}
}
```
![多态中的成员方法](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E5%A4%9A%E6%80%81%E4%B8%AD%E7%9A%84%E6%88%90%E5%91%98%E6%96%B9%E6%B3%95.png)

### 4. 多态中的成员访问特点之静态方法
    1. 静态方法[之前说过静态方法不叫重写]
        1. 编译看左边(父类)，运行看左边(父类)。
        2. (静态和类相关，算不上重写，所以访问还是左边的)
        3. 只有非静态的成员方法，编译看左边，运行看右边
### 5. 超人的故事
    1. 案例分析
        1. 通过该案例帮助学生理解多态的现象

### 6. 多态向上转型和向下转型
    1. 案例展示
        1. 详细讲解多态中向上转型和向下转型
        Person p = new SuperMan(); 向上转型
        SuperMan sm = new (SuperMan)p; 向下转型
    2. 例如父类引用指向子类对象，就是向上转型 对应基本类型的小类型转大类型
    3. 例如基本类型的强制转换，将大类型转换为小类型，为向下转型

### 7. 多态的好处和弊端
    1. 多态的好处
        1. 提高了代码的维护性(继承保证)
        2. 提高了代码的扩展性(由多态保证)
    2. 案例展示
        1. 多态的好处
        2. 可以当作形式参数，可以接收任意子类对象
    3. 多态的弊端
        1. 不能使用子类的特有属性和行为
    4. 案例展示
        1. method(Animal a)
        2. method(Cat c)
```java
package com.leeup.javase.day09.多态;


/**
 * 多态的优点与缺点
 * @author 李闯
 *
 */
public class Demo4_Animal {

	public static void main(String[] args) {
		Cat1 cat1 = new Cat1();
//		cat1.eat();//使用下面方法调用，复用性变化高
		method(new Cat());
		
		//想要多次创建狗，还想使用，Method方法不行
//		method(new Dog());	这样写相当于Cat cat = new Dog();猫类的引用指向狗类的对象，是不对的，
		
		method(new Dog());
		
	}
	/**
	 * 如果还需要这种方法，就还会再一个队伍写一个方法，扩展性太差
	 * 这两个方法可以修改为如下
	 * 只要是传过来的参数是Animal类型的，继承他的类都可以传进来
	 * 这就是多态的好处
	 * 
	 * 开发的时候是很少在创建对象的时候用父类的引用指向子类的对象，直接创建子类对象更方便，可以使用子类中特有的属性和行为
	 * 
	 * 在什么时候使用多态呢？在对象当作参数的时候使用多态最好，因为扩展性强
	 * 
	 * 
	 * 关键字：instanceof 判断前面的引用是否是后面的数据类型
	 * 
	 * @param dog
	 */
	public static void method(Animal1 a) {	//这样就相当于父类引用指向子类对象Animal a = new Dog()之类的
		a.eat();
	}
	
	//所以我们必须还要创建一个这样的方法
	public static void method(Dog dog) {
		dog.eat();
	}
	
	//如果想要创建多个猫，可以写个方法来替代，如下
	public static void method(Cat c) {
		c.eat();
	}
}

class Animal1{
	public void eat() {
		System.out.println("动物吃饭");
	}
}


class Cat1 extends Animal1{
	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	public void catchMouse() {
		System.out.println("抓老鼠");
	}
}

class Dog extends Animal1{
	public void eat() {
		System.out.println("狗吃肉");
	}
	
	public void lookHome() {
		System.out.println("看家");
	}
}
```
### 8. 多态中的题目分析题
```java
package com.leeup.javase.day09.多态;

public class Test1_Polymorphic {

	public static void main(String[] args) {
		Fu f = new Zi();
//		f.method();//左边没有method方法
		f.show();		//编译看左边，运行看右边，如果子类中有show方法，会执行子类的show
						//但是如果子类中没有该方法，执行的是父类的show方法
	}
}


class Fu {
	public void show() {
		System.out.println("Fu show");
	}
}

class Zi extends Fu{
//	public void show() {
//		System.out.println("Zi Show");
//	}
	public void method() {
		System.out.println("Zi method");
	}
}
```
```java
package com.leeup.javase.day09.多态;

public class Test2_Polymorphic {

	public static void main(String[] args) {
		A a = new B();
		a.show();	//编译看左边，运行看右边，虽然B中没有重写show方法，但是从A中继承了show方法，B继承的
					//show方法中调用了show2而B中的show2输出的是爱，故结果是爱
	}
}

class A{
	public void show() {
		show2();
	}
	public void show2() {
		System.out.println("我");
	}
}


class B extends A {
	public void show2() {
		System.out.println("爱");
	}
}

class C extends B{
	
	public void show() {
		super.show();
	}
	
	public void show2() {
		System.out.println("你");
	}
}
```

### 9. 抽象类的概述及其特点
    1. 抽象类概述
        1. 抽象就是看不懂的
    2. 抽象类特点
        1. 抽象类和抽象方法必须用abstract关键字修饰
            1. abstract class 类名{}
            2. public abstract void eat();
        2. 抽象类不一定有抽象方法，有抽象方法的类一定是抽象类或者是接口
        3. 抽象类不能实例化，那么抽象类如何实例化呢？
            1. 按照多态的方式，由具体的子类实例化。其实这也是多态的一种，抽象类多态
        4. 抽象类的子类
            1. 要么是抽象类
            2. 要么重写抽象类中的所有抽象方法
    3. 案例展示
        1. 抽象类特点
        2. 抽象类和抽象方法必须用abstract关键字修饰
            1. abstract class 类名 {}
            2. public abstract void eat();
        3. 抽象类不一定有抽象方法，有抽象方法的类一定是抽象类或者是接口
        4. 抽象类不能实例化那么，抽象类如何实例化呢?
            1. 按照多态的方式，由具体的子类实例化。其实这也是多态的一种，抽象类多态。
        5. 抽象类的子类
            1. 要么是抽象类
            2. 要么重写抽象类中的所有抽象方法
```java
package com.leeup.javase.day09.抽象类;

public class Demo1_Abstract {

	public static void main(String[] args) {
//		Animal animal = new Animal();//抽象类不能被实例化
		
		Animal animal = new Cat();//如果非要用实例化，就声明一个animal指向cat，即使用子类对他进行实例化
		animal.eat();
		
		/**
		 * 为什么不能被实例化呢？
		 * 因为如果aniimal可以被实例化，就意味着它可以调用eat方法，但是eat方法是抽象方法
		 * 你调用抽象方法是没有意义的，他没有具体的方法实现，所以抽象类是不允许被实现的
		 * 
		 * 
		 * 抽象类的子类，要么自身是抽象类要么强制重写父类中的所有抽象方法
		 * 
		 * 一般用的都是将抽象类中的所有方法进行重写
		 */
	}
}

abstract class Animal{				//抽象类
	
	/**
	 * 什么时候把方法定义成抽象的呢？
	 * 当你不知道他具体是怎么实现的，那你就把它定义成抽象的
	 * 
	 * 比如动物吃，你不了解具体吃什么，有肉食动物，草食动物，所以定义吃是抽象的，其实动物也是抽象的
	 */
	public abstract void eat();		//抽象方法，没有方法体，直接加分号
}

class Cat extends Animal{
	public void eat() {
		System.out.println("猫吃鱼");
	}
}
```

### 10. 抽象类的成员特点
    1. 抽象类的成员特点
        1. 成员变量：既可以是变量，也可以是常量。abstract是否可以修饰成员变量？不能修饰成员变量
            1. 为什么不能修饰：因为变量无法抽象，他的值要么引用数据类型，都是固定的， 类似颜色。
        2. 构造方法：有
            1. 用于子类访问父类数据的初始化
        3. 成员方法：既可以是抽象的，也可以是非抽象的
    2. 案例展示

### 11. 葵花宝典
    1. 案例展示
        1. 抽象类的作用
```java
package com.leeup.javase.day09.抽象类;

public class Demo3_葵花宝典 {

	public static void main(String[] args) {
		岳不群 小岳子 = new 岳不群();
		小岳子.自宫(); 
	}
}

/**
 * 葵花宝典声明一种规则，继承他的子类必须要遵守这个规则
 * @author 李闯
 *
 */
abstract class 葵花宝典{
	public abstract void 自宫();//因为并不知道后面的人如何执行这个方法，所以定义为抽象
}

class 岳不群 extends 葵花宝典 {
	public void 自宫() {
		System.out.println("用牙签");
	}
}

class 林平之 extends 葵花宝典{
	public void 自宫() {
		System.out.println("用指甲刀");
	}
}

class 东方不败 extends 葵花宝典{
	public void 自宫() {
		System.out.println("用锤子，不忍直视");
	}
}
```

### 12. 抽象类练习猫狗案例
    1. 案例演示
        1. 具体事物：猫，狗
        2. 共性：姓名，年龄，吃饭
        3. 猫的特性:抓老鼠
        4. 狗的特性:看家
```java
package com.leeup.javase.day09.抽象类;

public class Test1_Animal {

	public static void main(String[] args) {
		Cat1 cat1 = new Cat1("加菲",8);
		System.out.println(cat1.getName()+"/.."+cat1.getName());
		cat1.eat();
		cat1.catchMouse();
		
		Dog dog = new Dog("八公",30);
		System.out.println(dog.getName()+"..."+dog.getAge());
		dog.eat();
		dog.lookHome();
	}
}

/**
 * 抽象方法必须存在于抽象类中
 * @author 李闯
 *
 */
abstract class Animal1 {
	private String name;
	private int age;
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
	public Animal1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Animal1() {
		
	}
	
	abstract public void eat();
}

class Cat1 extends Animal1{

	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	public Cat1(String name, int age) {
		super(name,age);//this.name调用本类或者父类的成员变量， 但是父类中的被私有了，所以我们通过super传给父类
						//通过父类调用
	}
	public Cat1() {
		
	}
	
	public void catchMouse() {
		System.out.println("抓老鼠");
	}
}

class Dog extends Animal1{

	public void eat() {
		System.out.println("狗吃肉");
	}
	
	public Dog(String name, int age) {
		super(name,age);//this.name调用本类或者父类的成员变量， 但是父类中的被私有了，所以我们通过super传给父类
						//通过父类调用
	}
	public Dog() {
		
	}
	
	public void lookHome() {
		System.out.println("看家");
	}
}
```

### 13. 抽象类练习老师案例
    1. 案例演示
        1. 具体事物：基础班老师，就业班老师
        2. 共性：姓名，年龄，讲课。
        3. 具体事物:基础班学生,就业班学生
        4. 共性:姓名,年龄,学习

```java
package com.leeup.javase.day09.抽象类;


public class Test2_Teacher {

	public static void main(String[] args) {
		BaseTeacher baseTeacher = new BaseTeacher("老孙",18);
		baseTeacher.teach();
}
}

abstract class Teacher {
	private String name;
	private int age;
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
	public Teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Teacher() {
		
	}
	
	abstract public void teach();
}

class BaseTeacher extends Teacher{

	@Override
	public void teach() {
		System.out.println("我的姓名是："+this.getName()+"，我的年龄是"+this.getAge()+"，讲的内容是java基础");
	}
	public BaseTeacher(String name, int age) {
		super(name, age);
	}
	
	public BaseTeacher() {
	}
}
```

### 14.抽象类练习员工案例
    1. 案例演示
        1. 假如我们在开发一个系统时需要对程序员类进行设计，程序员包含3个属性：姓名、工号以及工资。
        2. 经理，除了含有程序员的属性外，另为还有一个奖金属性。
        3. 请使用继承的思想设计出程序员类和经理类。要求类中提供必要的方法进行属性访问。
```java
package com.leeup.javase.day09.抽象类;

public class Test3_Employee {

	public static void main(String[] args) {
		Coder coder = new Coder("张小龙","007",8000);
		coder.work();
		
		Manager manager = new Manager("雷军","9527",50000,2000);
		manager.work();
	}
}

abstract class Employee {
	private String name;
	private String id;
	private double salary;
	
	public Employee() {
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

	public Employee(String name, String id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public abstract void work(); 
}

class Coder extends Employee {
	
	public Coder() {
	}
	
	public Coder(String name, String id, double salary) {
		super(name, id, salary);
	}

	@Override
	public void work() {
		System.out.println("我的姓名是"+this.getName()+"，我的工号是"+this.getId()+
				"，我的工资是"+this.getSalary()+"，我的工作是敲代码");
		
	}
	
}

class Manager extends Employee {
	
	private int bouns;//奖金
	
	public Manager() {
	}
	
	public Manager(String name, String id, double salary,int bonus) {
		super(name, id, salary);
		this.bouns = bonus;
	}
	
	@Override
	public void work() {
		System.out.println("我的姓名是"+this.getName()+"，我的工号是"+this.getId()+
				"，我的工资是"+this.getSalary()+"我的奖金是"+bouns+"，我的工作是管理");
		
	}
}
```

### 15. 抽象类中的面试题
    1. 面试题1
        1. 一个抽象类如果没有抽象方法，可不可以定义为抽象类?如果可以，有什么意义?
        2. 可以
        3. 这么做目的只有一个,就是不让其他类创建本类对象,交给子类完成
    2. 面试题2
        1. abstract不能和哪些关键字共存
            1. static 如果可以和static共存的话，static修饰的方法有个特点就是类名.方法，但是类名.抽象方法是没有意义的，因为抽象方法没有方法体
            2. final 被abstract 修饰的方法强制子类重写，而被final修饰的不让子类重写，所以他俩是矛盾的
            3. private 被abstract是为了让子类看到并强制重写，而被private修饰的不让子类访问，所以他俩也是矛盾的

### 16. 接口的概述及其特点
    1. 接口概述
        1. 从狭义的角度讲就是java中的interface
        2. 从广义的角度讲对外提供规则的都是接口
    2. 接口特点
        1. 接口用关键字interface表示
            1. interface 接口名{}
        2. 类实现接口用implements表示
            1. class 类名 implements 接口名 {}
        3. 接口不能实例化
            1. 那么，接口如何实例化呢？
            2. 按照多态的方式来实例化
        4. 接口的子类
            1. 可以是抽象类，但是意义不大
            2. 可以是具体类，要重写接口中的所有抽象方法(推荐方案)
    3. 案例展示
        1. 接口特点
```java
package com.leeup.javase.day09.接口;

public class Demo1_Interface {

	public static void main(String[] args) {
//		Inter inter = new Inter();//接口不能实例化，和抽象类相同，因为方法都是抽象的，调用没有意义
		Inter inter = new Demo();//父类引用指向子类对象，继承是亲爹，接口是干爹
		inter.print();
	}
}


interface Inter {
	//定义方法
	public abstract void print();//接口中的方法都是抽象的
}

class Demo implements Inter{	//或者让方法进行抽象，不推荐，建议重写所有方法

	@Override
	public void print() {
		//接口中的抽象方法也需要被重写
	}
	
}
```

### 17. 接口的成员特点
    1. 接口成员特点
        1. 成员变量：只能是常量，并且是静态的并公共的
            1. 默认修饰符：public static final
                1. 三个关键字可以互相交换位置[不写默认系统会给]
            2. 建议：自己手动给出
    2. 案例展示
        1. 接口成员特点
 ```java
 package com.leeup.javase.day09.接口;

public class Demo2_Interface {

	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		demo1.print();
		System.out.println(Inter1.num);//可以通过类名.调用，说明他是final并且static的
	}
}

interface Inter1 {
	/**
	 * 接口中没有构造方法，
	 * 接口中的成员方法，只能是抽象的，并且不能有方法体
	 */
	
	public void print();	//前面默认加上abstract,并且默认为系统默认访问权限public
	
	public static final int num = 10;//接口中定义的变量都是常量,不加final修饰，系统也会默认加上
}

class Demo1 /*extends Object */implements Inter1 { //一个类不写继承任何类，默认继承object类
	public void print() {
		System.out.println(num);
	}
	
	public Demo1() {
		super();
	}
}
 ```

 ### 18. 类与类,类与接口,接口与接口的关系
    1. 类与类,类与接口,接口与接口的关系
        1. 类与类：
            1. 继承关系,只能单继承,可以多层继承。
    2. 类与接口：
        1. 实现关系,可以单实现,也可以多实现。
            1. 并且还可以在继承一个类的同时实现多个接口。
    3. 接口与接口：
        1. 继承关系,可以单继承,也可以多继承。
    4. 案例演示
        1. 类与类,类与接口,接口与接口的关系
```java
package com.leeup.javase.day09.接口;

public class Demo3_Interface {

	public static void main(String[] args) {
		
	}
}

interface InterA {
	public abstract void printA();
}

interface InterB {
	public abstract void printB();
}

/**
 * 可以选择多实现也可以多实现
 * 如果两个接口中方法相同，实现的类中只用写一个方法实现即可，相当于重写了两个，因为接口中是没有方法体的
 * @author 李闯
 * 
 */
class DemoA implements InterA,InterB{		//implements 关键字只用写一次
	
	//重写方法
	@Override
	public void printA() {
		
	}

	@Override
	public void printB() {
		
	}
} 
/**
 * 接口之间不能实现,但是可以多继承或者单继承，
 * @author 李闯
 *
 */
interface InterC extends InterB,InterA{
	
}
```

### 19. 抽象类和接口的区别
    1. 成员区别
        1. 抽象类：
            1. 成员变量：可以变量，也可以常量
            2. 构造方法：有
            3. 成员方法：可以抽象，也可以非抽象
        2. 接口：
            1. 成员变量：只可以常量
            2. 成员方法：只可以抽象
    2. 关系区别
        1. 类与类
            1. 继承，单继承
    3. 类与接口
        1. 实现，单实现，多实现
    4. 接口与接口
        1. 继承，单继承，多继承
    5. 设计理念区别
        1. 抽象类 被继承体现的是：”is a”的关系。抽象类中定义的是该继承体系的共性功能。
        2. 接口 被实现体现的是：”like a”的关系。接口中定义的是该继承体系的扩展功能。

### 20. 猫狗案例加入跳高功能分析及其代码实现
    1. 案例演示
        1. 动物类：姓名，年龄，吃饭，睡觉。
        2. 猫和狗
        3. 动物培训接口：跳高

### 21. day09总结
    1. 把今天的知识点总结一遍。