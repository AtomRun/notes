package com.leeup.javase.day16.jdk5;
/**
 * 可变参数的概述和使用
 * @author 李闯
 *
 */
public class Demo3_ChangeableArgs {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55};
//		print(arr);//把数组当作一个参数
		
		print(11,22,33,44,55);//把这些参数传递给print方法, 可变参数可以接收,其实可变参数底层做了封装,会将其封装成数组
		System.out.println("===========");
//		print();
	}
	
	
//	public static void print(int[] arr) {
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//	}
	
	public static void print(int x, int ... arr) {			//可变参数其实就是一个数组
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

