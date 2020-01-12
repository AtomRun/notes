package com.leeup.javase.day06.面向对象;

public class Demo3_Car {
	public static void main(String[] args) {
		Car car = new Car();//创建对象
		
		//调用属性并赋值
		car.color = "red";	//赋值车的颜色
		car.number = 8;		//为车的轮胎数赋值
		
		car.run();
	}

	static class Car {
		/**
		 * 车的属性
		 * 	颜色
		 * 	轮胎数量
		 */
		String color;	//车的颜色
		int number;		//车的轮胎数
		
		/**
		 * 车的行为
		 * 	车运行
		 * 	刹车
		 * 	油门
		 */
		public void run() {	//车运行
			System.out.println(color+"..."+number);
		}
	}
}


