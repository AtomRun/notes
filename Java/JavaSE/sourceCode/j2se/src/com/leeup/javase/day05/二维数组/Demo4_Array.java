package com.leeup.javase.day05.二维数组;

public class Demo4_Array {

	public static void main(String[] args) {
		int[] [] arr = {{1,2,3},{4,5,6},{7,8,9}}; //这是一个二维数组，这个二维数组中的每个大括号都代表一个一维数组
		System.out.println(arr);		//[[I@15db9742	二维数组的地址值
		System.out.println(arr[0]);		//[I@6d06d69c	一维数组的地址
		System.out.println(arr[0][0]);	//1				一维数组的元素值
	
	}
}
