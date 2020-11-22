package com.leeup.javase.day08.继承;

public class Test5_Animal {

	public static void main(String[] args) {
		Cat1 cat1 = new Cat1("黄色", 4);
		System.out.println(cat1.getColor()+"..."+cat1.getLeg());
		cat1.eat();
		cat1.catchMouse();
		
		Dog1 dog1 = new Dog1("黑色",4);
		System.out.println(dog1.getColor()+"..."+dog1.getLeg());
		dog1.eat();
		dog1.lookHome();
	}
}

class Animal1{
	private String color;
	private int leg;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getLeg() {
		return leg;
	}
	public void setLeg(int leg) {
		this.leg = leg;
	}
	public Animal1(String color, int leg) {
		this.color = color;
		this.leg = leg;
	}
	public Animal1() {
	}
	public void eat() {
		System.out.println("吃饭");
	}
}

class Cat1 extends Animal1{
	public Cat1(){
		
	}
	
	public Cat1(String color,int leg) {
		super(color,leg); 
	}
	
	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	public void catchMouse() {
		System.out.println("抓老鼠");
	}
}

class Dog1 extends Animal1{
	public Dog1(){
		
	}
	
	public Dog1(String color,int leg) {
		super(color,leg); 
	}
	
	public void eat() {
		System.out.println("狗吃肉");
	}
	
	public void catchMouse() {
		System.out.println("抓老鼠");
	}

	public void lookHome() {
		System.out.println("狗看家");
	}
}