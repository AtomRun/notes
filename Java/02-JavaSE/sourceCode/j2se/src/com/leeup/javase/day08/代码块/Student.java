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
