package com.leeup.javase.day06.面向对象;

public class Demo1_Student {
	

	public static void main(String[] args) {
		//创建对象的格式 类型 对象名 = new 类名();
		//对象名：其实就是合法的标识符，如果是一个单词则所有字母小写，如果是多个单词。从第二个单词开始，首字母大写
		Student student = new Student();
		student.name="张三";
		student.age=21;
		
		System.out.println(student.name+"..."+student.age);
		student.study();
		student.sleep();
		
	}
}
class Student {
	/**
	 * 学生类
	 */

	/**
	 * 属性：成员变量
	 */
	String name;//姓名
	int age;//年龄
	String gender;//性别
	
	
	/**
	 * 行为：成员方法
	 */
	public void study() {
		System.out.println("学生学习");
	}
	
	public void sleep() {
		System.out.println("学生睡觉");
	}
}
