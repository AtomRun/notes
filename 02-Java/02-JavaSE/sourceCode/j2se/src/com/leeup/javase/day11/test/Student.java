package com.leeup.javase.day11.test;

public class Student {

	private String name;
	private int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Student() {
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
	
	@Override
	public String toString() {
//		return "大家好";
		return "我的姓名是" +name + "，我的年龄是"+age;
	}
	//重写equals方法
	@Override
	public boolean equals(Object obj) {
		//我们想比较对象中的属性值，那就是比较Student的name和age是否相同
		//如果都相同，我们就认为这两个对象"相同"，但是这是我们认为的，并不是同一个对象
		
		//String的equals此字符串与 指定的对象比较，当且仅仅当该参数不为null，并且是与此对象表示相同字符序列
		//的String对象时，结果才为true
		
		Student student = (Student)obj;
		return this.name.equals(student.name) && this.age == student.age  ;//基本数据类型不能调用方法的
	}
	
}
