package com.leeup.javase.day07.创建对象的步骤;

public class Demo1_Student {

	public static void main(String[] args) {
		Student student = new Student();
		student.show();

		
		boolean b = true;

		if(b=false) //true == false;  //b
			System.out.println("a");
		else if(b)
			System.out.println("b");
		else if(!b)
			System.out.println("c");
		else
			System.out.println("d");
	}
}

class Student{
	private String name = "张三";
	private int age = 23;
	
	public Student() {
		name = "李四";
		age = 24;
	}
	public void show() {
		System.out.println("我的名字是"+name+"，我的年龄是"+age);
	}
}