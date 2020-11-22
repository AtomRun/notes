package com.leeup.javase.day07.构造方法;

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