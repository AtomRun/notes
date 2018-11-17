package com.leeup.javase.day09.抽象类;

public class Demo1_Abstract {

	public static void main(String[] args) {
//		Animal animal = new Animal();//抽象类不能被实例化
		
		Animal animal = new Cat();//如果非要用实例化，就声明一个animal指向cat，即使用子类对他进行实例化
		animal.eat();
		
		/**
		 * 为什么不能被实例化呢？
		 * 因为如果aniimal可以被实例化，就意味着它可以调用eat方法，但是eat方法是抽象方法
		 * 你调用抽象方法是没有意义的，他没有具体的方法实现，所以抽象类是不允许被实现的
		 * 
		 * 
		 * 抽象类的子类，要么自身是抽象类要么强制重写父类中的所有抽象方法
		 * 
		 * 一般用的都是将抽象类中的所有方法进行重写
		 */
	}
}

abstract class Animal{				//抽象类
	
	/**
	 * 什么时候把方法定义成抽象的呢？
	 * 当你不知道他具体是怎么实现的，那你就把它定义成抽象的
	 * 
	 * 比如动物吃，你不了解具体吃什么，有肉食动物，草食动物，所以定义吃是抽象的，其实动物也是抽象的
	 */
	public abstract void eat();		//抽象方法，没有方法体，直接加分号
}

class Cat extends Animal{
	public void eat() {
		System.out.println("猫吃鱼");
	}
}