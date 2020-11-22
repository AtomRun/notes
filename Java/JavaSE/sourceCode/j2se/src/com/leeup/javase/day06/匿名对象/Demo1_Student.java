package com.leeup.javase.day06.匿名对象;

public class Demo1_Student {
	
	public static void main(String[] args) {
		print(10);		//直接调用
		
		Student s = new Student();//创建对象，并将对象的地址值赋给s
		
		print(s);
	}
	
	public static void print(int x) {	//基本数据类型作为形式参数
		System.out.println(x);
	}
	
	public static void print(Student s) {	//引用数据类型当作形式参数
		/**
		 * 接收引用数据类型必须要给它一个地址值
		 * 基本类型参数给的是值
		 */
		
		s.name="张三";
		s.age=23;
		s.speak();
	}
}
/**
 * 方法的参数名是public void print (Studen s){}//print (new Student());
 * 如果你看到了一个方法的形式参数是一个类类型(引用类型),这里需要的是类的对象
 */

class Student{
	
	String name;	//姓名
	int age;		//年龄
	
	public void speak() {
		System.out.println(name+"..."+age);
	}
}
