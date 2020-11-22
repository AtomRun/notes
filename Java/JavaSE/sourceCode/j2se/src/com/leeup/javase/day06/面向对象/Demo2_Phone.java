package com.leeup.javase.day06.面向对象;

public class Demo2_Phone {
	
	public static void main(String[] args) {
		
		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.brand="小米";
		mobilePhone.price=1999;
		
		System.out.println(mobilePhone.brand+"..."+mobilePhone.price);
		
		mobilePhone.call();
		mobilePhone.sendMessage();
		mobilePhone.playGame();
	}

	static class MobilePhone {
		/**
		 * 手机类
		 */

		/**
		 * 属性：成员变量
		 */
		String brand;
		int price;
		
		/**
		 * 行为：成员方法
		 */
		public void call() {
			System.out.println("手机打电话");
		}
		
		public void sendMessage() {
			System.out.println("手机发消息");
		}
		
		public void playGame() {
			System.out.println("手机玩游戏");
		}
	}
}
