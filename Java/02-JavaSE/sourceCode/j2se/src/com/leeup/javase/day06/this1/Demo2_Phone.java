package com.leeup.javase.day06.this1;

public class Demo2_Phone {

	public static void main(String[] args) {
		Phone phone = new Phone();
		
		phone.setBrand("小米");
		phone.setPrice(4999);
		
		System.out.println(phone.getBrand()+"。。。"+phone.getPrice());
		phone.call();
		phone.sendMessage();
		phone.playGame();
	}
}

/**
 * 手机类
 * @author 李闯
 *
 */
class Phone{
	/**
	 * java bean类，实体类，对别的类提供服务，有set/get方法叫做javaBean类，实体类
	 */
	private String brand;
	private int price;
	
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
		return this.price;//this可以省略，你不加系统会默认给你加
	}
	
	public void call() {
		System.out.println("打电话");
	}
	public void sendMessage() {
		System.out.println("发短信");
	}
	public void playGame() {
		System.out.println("玩游戏");
	}
}