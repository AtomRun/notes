package com.leeup.javase.day08.代码块;
/**
 * 代码块相关知识展示
 * @author 李闯
 *
 */
public class Demo1_Code {
	
	public static void main(String[] args) {

		Student1 s1 = new Student1();		//创建对象测试构造代码块
		System.out.println("===========");
		Student1 s2 = new Student1("张三",23);
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

class Student1{
	
	private String name;
	private int age;
	
	//构造代码块
	{
		study();
		System.out.println("我是构造代码块");
	}
	
	public Student1() {
		System.out.println("我是空参构造");
	}
	
	public Student1(String name,int age) {
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