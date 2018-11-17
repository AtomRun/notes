package com.leeup.javase.day07.文档说明书的制作过程;
/**
 * 数组工具类
 * @author 李闯
 *
 */
public class Array_Tool {
	
	/**
	 * 如果一个类中所有的方法都是静态的，那么需要再多做一步
	 * 即私有构造方法，因为构造方法私有了，其他类就不能创建本类对象了，直接使用类名方式调用方法即可
	 * @param arr
	 * @return
	 */

	//1 获取最大值
	//2 数组的遍历
	//3 数组的反转
	
	private Array_Tool() {
		
	}
	
	public static int getMax(int[] arr) {
		int max = arr[0];//记录第一个元素
		
		for (int i = 1; i < arr.length; i++) {//从第二个元素开始遍历
			if (max<arr[i]) {		//max与数组中其他的元素比较
				max = arr[i];		//记录住较大的
			}
		}
		return max;					//将最大值返回
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {//遍历数组
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void arrRverse(int[] arr) {
		for (int i = 0; i < arr.length/2; i++) {//循环次数是元素个数的一半
			/**
			 * arr[0]与arr[arr.length-1-0]交换
			 * arr[1]与arr[arr.length-1-1]交换
			 * arr[2]与arr[arr.length-1-2]交换
			 */
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
}
