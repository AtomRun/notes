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
