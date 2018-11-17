package com.leeup.javase.day10.匿名内部类;

public class Test1_NoNameInnerClass {

	//如何调用PersonDemo中的method方法
	public static void main(String[] args) {
		PersonDemo personDemo = new PersonDemo();
//		personDemo.method(new Student());
		//使用匿名内部类如何做到？
		personDemo.method(new Person() {//继承Person类并且重写抽象类中的方法
			/**
			 * 匿名内部类在开发中的应用，当作参数传递(本质把匿名内部类看作一个对象)
			 */
			@Override
			public void show() {
				System.out.println("show");
			}
		});
	}
}

//这里写抽象了类，接口都行
abstract class Person {
	public abstract void show();
}

class PersonDemo {
	public void method(Person p) {		//Person p = new Student();
		
		p.show();
	}
}

class Student extends Person {

	@Override
	public void show() {
		System.out.println("show");
	}
	
}