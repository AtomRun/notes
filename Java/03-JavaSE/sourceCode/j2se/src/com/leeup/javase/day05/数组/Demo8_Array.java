package com.leeup.javase.day05.数组;
/**
 * 数组的遍历
 * 案例展示
 * 	数组的遍历：就是依次输出数组中的每一个元素
 * 	数组的属性：arr.length 就是数组的长度
 * 	数组的最大索引：arr.length - 1;	
 * @author 李闯
 *
 */
public class Demo8_Array {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55};
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);  直接输出方法复用性不高
		
		
		for (int i = 0; i <= 4; i++) { //如果不知道数组中的确切长度，就不能使用类似i<=4这种，所以可以使用 arr.length属性，代表的数组的长度
			System.out.println(arr[i]);
		}
		
		System.out.println(arr.length);//长度为5，数组的长度如果是5，那么数组的索引就是数组的长度-1即4

		
		/**
		 * 调用遍历数组的方法
		 */
		int [] arr2 = {3,4,5};
		printArr(arr2);
	}
	/**
	 * 将遍历数组封装成方法
	 * 分析：
	 * 返回值：只是对数组的元素进行打印，不需要任何返回值即void
	 * 参数列表：数组，int[] arr
	 */
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
