package com.leeup.javase.day05.二维数组;
/**
 * 二维数组的遍历
 * @author 李闯
 *
 */
public class Demo5_Array {

	public static void main(String[] args) {
		/**
		 * 使用嵌套for循环遍历二维数组
		 */
		int[] [] arr = {{1,2,3},{4,5,6},{7,8,9}}; //这是一个二维数组，这个二维数组中的每个大括号都代表一个一维数组
		for (int i = 0; i < arr.length; i++) {//外层循环应该拿到二维数组中的每一个一维数组
			for (int j = 0; j < arr[0].length; j++) {//获取每个一维数组中的元素
				System.out.print(arr[i][j]+" ");	//例如第一次循环即arr[0][0],第二次即arr[0][1]
			}
			System.out.println();
		}
	}
}
