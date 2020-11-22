package com.leeup.javase.day09.多态;

public class Demo1_Polymorphic {

	public static void main(String[] args) {
		Cat cat = new Cat();	//子类引用执行子类对象，这句话可以理解为，猫是一只猫
		cat.eat();
		Animal animal = new Cat();	//父类引用执行子类对象，这句话可以理解为，猫是一只动物
		animal.eat();
	}
}


class Animal{
	public void eat() {
		System.out.println("动物吃饭");
	}
}

class Cat extends Animal {
	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	
}