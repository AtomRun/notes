package com.leeup.javase.day14.otherclass;

import java.math.BigInteger;

public class Demo4_BigInteger {

	public static void main(String[] args) {
//		Long num = 12343435455647567624L;数据太大，非要存起来怎么办呢？
//		String s = "12343435455647567624";可以使用String但是无法参加运算
		
		//使用BigInteger
		BigInteger bi1 = new BigInteger("100"); 
		BigInteger bi2 = new BigInteger("2");
		System.out.println(bi1.add(bi2));		//相加
		System.out.println(bi1.subtract(bi2));	//相减
		System.out.println(bi1.multiply(bi2));	//相乘
		System.out.println(bi1.divide(bi2));	//相除
		
		BigInteger[] arr = bi1.divideAndRemainder(bi2);//取除数和余数
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
