package com.leeup.javase.day06.面向对象;

public class Demo2_Person {
	
	public static void main(String[] args) {
		Person person = new Person();
		
		person.speak();
	}
}
	
class Person {
	
	/**
	 * 引用数据类型初始化值都是null
	 * 基本数据类型 整数都是0，小数都是0.0，boolean是flase,char是'/u0000'
	 */
	
	String name;			//成员变量,没有赋值，但是也有默认初始化值，String即null
	
	public void speak(/*int x*/) { //方法声明上，局部变量
		int num = 10; //方法生命周，局部变量,x,num都是局部变量,
					  //如果这里int num不给他初始化值，syso会提示错误，即num没有被初始化
					  //局部变量必须要在使用前初始化才能使用
		System.out.println(name);
		System.out.println(num);
	}
}
