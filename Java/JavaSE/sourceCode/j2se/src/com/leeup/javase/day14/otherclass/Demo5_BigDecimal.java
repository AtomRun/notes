package com.leeup.javase.day14.otherclass;

import java.math.BigDecimal;

/**
 * BigDecimal类的概述和方法使用
 * @author 李闯
 *
 */
public class Demo5_BigDecimal {

	public static void main(String[] args) {
		//这种方式在开发中不推荐，因为不够精确
		System.out.println(2.0-1.1);
		//结果为0.8999999999999999，因为现在计算机存储的都是二进制形式存储的，
		//二进制存储小数的时候不能直接表现出来，所以他只能无限接近于小数
		
//		BigDecimal bd1 = new BigDecimal(2.0);
//		BigDecimal bd2 = new BigDecimal(1.1);
//		System.out.println(bd1.subtract(bd2));
		
		//通过构造中传入字符串的方式进行运算，开发时推荐
//		BigDecimal bd1 = new BigDecimal("2.0");
//		BigDecimal bd2 = new BigDecimal("1.1");
//		System.out.println(bd1.subtract(bd2));
		
		//这种方式在开发中也是推荐的
		BigDecimal bd1 = BigDecimal.valueOf(2.0);
		BigDecimal bd2 = BigDecimal.valueOf(2.0);
		System.out.println(bd1.subtract(bd2));
		
	}
}
