package com.leeup.javase.day08.继承;

public class Demo6_Extends {

	public static void main(String[] args) {
		Son3 s1 = new Son3();
		System.out.println("===================");
		Son3 s2 = new Son3("张三",23);
	}
}


class Father3{
	private String name;
	private int age;
	
	public Father3() {
		System.out.println("Father 空参构造");
	}

	public Father3(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Father 有参构造");
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
	
}

class Son3 extends Father3{
	public Son3() {
		System.out.println("Son 空参构造");
	}
	
	public Son3(String name,int age) {
		System.out.println("Son有参构造");
	}
}