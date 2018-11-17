package com.leeup.javase.day07.构造方法;

public class Demo4_Student {

	public static void main(String[] args) {
		Student student  = new Student();	//空参数构造创建对象
		student.setName("张三");		//设置姓名
		student.setAge(23);			//设置年龄
		student.show();
		System.out.println("我的姓名是："+student.getName()+"，我的姓名是："+student.getAge());
		
		Student student2 = new Student("李四",24);
		
		student2.show();			//只是为了显示属性值，而getName或者getAge可能是拿到值用来做别的操作
	}
}

class Student{
	
	private String name;
	private int age;
	
	//无参构造
	public Student() {
		
	}
	
	//有参构造
	public Student(String name,int age) {
		this.age = age;
		this.name = name;
	}
	
	//name的set方法
	public void setName(String name) {
		this.name = name;
	}
	//name的get方法
	public String getName() {
		return name;
	}
	
	//age的set方法
	public void setAge(int age) {
		this.age = age;
	}
	
	//age的get方法
	public int getAge() {
		return age;
	}
	
	public void show() {
		System.out.println("我的姓名是："+name+"，我的年龄是："+age);
	}
}