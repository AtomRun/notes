package com.leeup.javase.day07.构造方法;
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
