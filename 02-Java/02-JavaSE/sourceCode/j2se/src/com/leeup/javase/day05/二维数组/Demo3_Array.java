package com.leeup.javase.day05.二维数组;
/**
 * 二维数组格式2
 * 		int[] [] arr = new int [3][];
 * 二维数组格式2的解释
 * 案例展示
 * 		讲解格式，输出数据，并画内存图
 * @author 李闯
 *
 */
public class Demo3_Array {

	public static void main(String[] args) {
		int [] [] arr = new int [3][]; 	//这是一个二维数组，这个二维数组中有三个一维数组，三个一维数组都没有被初始化赋值
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		arr[0] = new int[3];		//相当于第一个一维数组可以存储三个int元素
		arr[1] = new int[5];		//相当于第二个一维数组可以存储五个int元素
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}
}
