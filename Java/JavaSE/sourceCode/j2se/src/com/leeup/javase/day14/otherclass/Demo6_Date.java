package com.leeup.javase.day14.otherclass;

import java.util.Date;

/**
 * Date类的概述和方法使用
 * @author 李闯
 *
 */
public class Demo6_Date {

	public static void main(String[] args) {
//		demo1();
//		
//		demo2();

		/**
		 * 在这里就是构造方法对对象进行初始化
		 * set方法对其值进行修改
		 */
		Date d1 = new Date();
		d1.setTime(1000);//设置毫秒值，改变时间对象
		System.out.println(d1);//1000毫秒等于一秒，输出结果为Thu Jan 01 08:00:01 CST 1970
	}

	private static void demo2() {
		Date d1 = new Date();
		System.out.println(d1.getTime());//通过时间对象获取当前时间的毫秒值
		System.out.println(System.currentTimeMillis());//通过系统类的方法获取当前时间毫秒值
	}

	private static void demo1() {
		Date d1 = new Date();	//没有传参数代表的是当前时间
		System.out.println(d1);
		
		//打印出来08:00是因为电脑时区设置的为东八区
		Date d2 = new Date(0);	//如果构造方法中参数传为0代表的是19701月1日
		System.out.println(d2);//1970-1-1-08:00 
	}
}
