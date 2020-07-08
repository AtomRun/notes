package com.leeup.javase.day09.多态;

public class Demo3_SuperMan {

	public static void main(String[] args) {
		Person person = new SuperMan();	//超人乔装成一个人，父类引用指向子类对象，超人提升为了人
		System.out.println(person.name);//体现出的特征是父类类型的特征(属性)，访问成员变量即编译运行都看左边
		person.谈生意();//编译看左边(父类)，运行看右边(子类)。
//		person.fly();		//编译的时候看父类，父类中没有fly方法，编译出错
		SuperMan man = (SuperMan)person;//向下转型，将person转换为超人
		man.fly();	//这样就可以调用fly方法了 
		/**
		 * 多态的弊端，不能使用子类特有的属性和行为
		 */
		
	}
}

class Person{
	String name = "john";
	
	public void 谈生意() {
		System.out.println("谈生意");
	}
}


class SuperMan extends Person {
	String name = "superMan";
	
	public void 谈生意() {
		System.out.println("谈几个亿的大生意");
	}
	
	public void fly() {
		System.out.println("飞出去救人");
	}
}