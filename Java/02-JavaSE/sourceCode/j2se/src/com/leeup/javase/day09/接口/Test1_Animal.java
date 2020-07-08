package com.leeup.javase.day09.接口;

public class Test1_Animal {

	public static void main(String[] args) {
		Cat cat = new Cat("加菲",8);
		cat.eat();
		cat.sleep();
		
		JumpCat jumpCat = new JumpCat("调高猫",3);
		jumpCat.eat();
		jumpCat.sleep();
		jumpCat.jump();
	}
}

abstract class Animal {
	private String name;
	private int age;
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Animal() {
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
	
	public abstract void eat();
	
	public abstract void sleep();
	
}

//跳高的接口
interface jumping {
	public void jump();
}

class Cat extends Animal {

	
	public Cat() {
	}
	public Cat(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void eat() {
		System.out.println("猫吃鱼");
	}

	@Override
	public void sleep() {
		System.out.println("侧着睡");
	}
	
}

class JumpCat extends Cat implements jumping{
	
	public JumpCat() {
	}
	public JumpCat(String name, int age) {
		super(name, age);
	}

	@Override
	public void jump() {
		System.out.println("猫跳高");
	}
	
}