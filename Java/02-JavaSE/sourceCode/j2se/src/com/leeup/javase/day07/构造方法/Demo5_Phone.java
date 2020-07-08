package com.leeup.javase.day07.构造方法;

public class Demo5_Phone {

	public static void main(String[] args) {
		Phone p1 = new Phone();
		p1.setBrand("小米");
		p1.setPrice(4000);
		System.out.println("我的品牌是"+p1.getBrand()+"，我的价格是"+p1.getPrice());
		
		
		Phone p2 = new Phone("苹果",9000);
		p2.show();
	}
}

class Phone{
	//成员变量
	private String brand;
	private int price;
	
	//无参构造
	public Phone(){
		
	}
	
	//有参构造
	public Phone(String brand,int price) {
		this.brand = brand;
		this.price = price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void show() {
		System.out.println("我的品牌是"+brand+"，我的价格是"+price);
	}
}
