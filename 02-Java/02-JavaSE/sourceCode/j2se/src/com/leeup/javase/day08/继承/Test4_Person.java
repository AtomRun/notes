package com.leeup.javase.day08.继承;
/**
 * 使用继承后的学生和老师案例
 * @author 李闯
 *
 */
public class Test4_Person {

}

class Person{
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
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
	
	public void eat() {
		System.out.println("吃饭");
	}
}

class Student1 extends Person{
	public Student1() {
		
	}
	public Student1(String name,int age) {
		super(name,age);
	}
	public void study() {
		System.out.println("学生学习");
	}
}