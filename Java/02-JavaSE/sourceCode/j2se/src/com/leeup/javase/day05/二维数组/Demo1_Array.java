package com.leeup.javase.day05.二维数组;
/**
 * 二维数组概述
 * 二维数组格式
 * 		int[] arr = new int[3][2];
 * 二维数组格式1的解释
 * 注意事项
 * 		以下格式也可以表示二维数组
 * 			1. 数据类型 数组名 [ ] [ ] = new 数据类型 [m][n];
 * 			2. 数据类型	[]数组名[] = new 数据类型[m][n];
 * 		注意下面定义的区别
 * 			int x;
 * 			int y;
 * 			int x,y;
 * 
 *   		int [] x;
 *   		int [] y[];
 *   
 *   		int [] x, y[]; 		x是一维数组，y是二维数组
 *   案例展示
 *   	定义二维数组，输出二维数组名称，一维数组名称，一个元素
 * @author 李闯
 *
 */
public class Demo1_Array {
	public static void main(String[] args) {
		int[] [] arr = new int [3][2];
		/**
		 * 这是一个二维数组
		 * 第一个3 代表二维数组中有3个一维数组
		 * 第二个2代表每个一维数组中有2个元素
		 */
//		int[] arr1 [] = new int [3][2];
//		int arr3 [] [] = new int[3][2];
		
		System.out.println(arr);//二维数组
		System.out.println(arr[0]);//二维数组中的第一个一维数组
		System.out.println(arr[0][0]);//二维数组中的第一个一维数组的第一个元素
		
		/**
		 * 输出结果
		 * [[I@15db9742		二维数组的地址值
		    [I@6d06d69c		一维数组的地址值
			0				一维数组的元素值
		 */
	}
}

