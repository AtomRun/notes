package com.leeup.javase.day09.抽象类;

public class Test1_Animal {

	public static void main(String[] args) {
		Cat1 cat1 = new Cat1("加菲",8);
		System.out.println(cat1.getName()+"/.."+cat1.getName());
		cat1.eat();
		cat1.catchMouse();
		
		Dog dog = new Dog("八公",30);
		System.out.println(dog.getName()+"..."+dog.getAge());
		dog.eat();
		dog.lookHome();
	}
}

/**
 * 抽象方法必须存在于抽象类中
 * @author 李闯
 *
 */
abstract class Animal1 {
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
	public Animal1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Animal1() {
		
	}
	
	abstract public void eat();
}

class Cat1 extends Animal1{

	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	public Cat1(String name, int age) {
		super(name,age);//this.name调用本类或者父类的成员变量， 但是父类中的被私有了，所以我们通过super传给父类
						//通过父类调用
	}
	public Cat1() {
		
	}
	
	public void catchMouse() {
		System.out.println("抓老鼠");
	}
}

class Dog extends Animal1{

	public void eat() {
		System.out.println("狗吃肉");
	}
	
	public Dog(String name, int age) {
		super(name,age);//this.name调用本类或者父类的成员变量， 但是父类中的被私有了，所以我们通过super传给父类
						//通过父类调用
	}
	public Dog() {
		
	}
	
	public void lookHome() {
		System.out.println("看家");
	}
}