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