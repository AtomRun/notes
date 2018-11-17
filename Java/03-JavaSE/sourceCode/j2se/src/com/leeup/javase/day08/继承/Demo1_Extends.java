package com.leeup.javase.day08.继承;

public class Demo1_Extends {

	public static void main(String[] args) {
		/**
		 * 猫合狗继承了动物类之后，将猫和狗本身的属性代码和方法代码注释掉
		 * 依旧可以使用属性和方法[即可以通过父类拿到父类的属性和方法]
		 */
		Cat cat = new Cat();
		cat.color = "白色";
		cat.leg = 4;
		cat.eat();
		cat.sleep();
		
		System.out.println("颜色"+cat.color+"，腿个数"+cat.leg);
	}
}


class Animal{
	String color;
	int leg;
	
	public void eat() {
		System.out.println("吃饭");
	}
	
	public void sleep() {
		System.out.println("睡觉");
	}
}

/**
 * 两个子类，猫和狗，相似的地方太多，他们有一个共同的父类，动物类
 * 
 * @author 李闯
 *
 */
class Cat extends Animal{
//	String color;
//	int leg;
//	
//	public void eat() {
//		System.out.println("吃饭");
//	}
//	
//	public void sleep() {
//		System.out.println("睡觉");
//	}
}

class Dog extends Animal{
//	String color;
//	int leg;
//	
//	public void eat() {
//		System.out.println("吃饭");
//	}
//	
//	public void sleep() {
//		System.out.println("睡觉");
//	}
}
