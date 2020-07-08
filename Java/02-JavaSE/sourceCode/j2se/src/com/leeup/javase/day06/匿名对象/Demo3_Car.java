package com.leeup.javase.day06.匿名对象;
/**
 *匿名类概述使用场景2：作为参数使用
 * @author 李闯
 *
 */
public class Demo3_Car {
	
	public static void main(String[] args) {
//		Car c1 = new Car();
		//c1.color = "red";
		//c1.num = 8;
		//c1.run();
//		method(c1);
		
		method(new Car());
		
//		Car c2 = new Car();
//		method(c2);
		
		method(new Car());		//匿名对象可以当作参数传递，这里相当于把new Car的地址值赋值给了方法中的 cc
								//cc可以拿到地址值对属性进行赋值
	}
	
	//抽取方法，提高代码复用性
	public static void method(Car cc) {
		cc.color = "Red";
		cc.num = 8;
		cc.run();
	}
}

//class Car{
//	String color;	//颜色
//	int num;		//轮胎数
//	
//	public void run() {
//		System.out.println(color+"...."+num);
//	}
//}
