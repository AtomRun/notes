package com.leeup.javase.day09.抽象类;


public class Test2_Teacher {

	public static void main(String[] args) {
		BaseTeacher baseTeacher = new BaseTeacher("老孙",18);
		baseTeacher.teach();
}
}

abstract class Teacher {
	private String name;
	private int age;
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
	public Teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Teacher() {
		
	}
	
	abstract public void teach();
}

class BaseTeacher extends Teacher{

	@Override
	public void teach() {
		System.out.println("我的姓名是："+this.getName()+"，我的年龄是"+this.getAge()+"，讲的内容是java基础");
	}
	public BaseTeacher(String name, int age) {
		super(name, age);
	}
	
	public BaseTeacher() {
	}
}

