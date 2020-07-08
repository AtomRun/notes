package com.leeup.javase.day05.数组;
/**
 * 数组中获取最值
 * 
 * @author 李闯
 *
 */
public class Demo9_Array {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55};
		
		int max = getArrMax(arr);
		System.out.println(max);
		
		int min = getArrMin(arr);
		System.out.println(min);
		
		
	}
	
	/**
	 * 获取数组中的最大值
	 */
	public static int getArrMax(int[] arr) {
		
		int max = arr[0];						//max不能为0，因为数组中一旦全都是负数，那么取的最大值即max0了
		for (int i = 1; i < arr.length; i++) {	//从数组中的第二个元素开始遍历
			if (max < arr[i]) {					//如果max记录的值小于数组中的元素
				max = arr[i];					//max记录较大的数
			}
		}
		
		return max;
	}
	
	/**
	 * 获取数组中的最小值
	 */
	public static int getArrMin(int[] arr) {
		
		int min = arr[0];						
		for (int i = 1; i < arr.length; i++) {	
			if (min > arr[i]) {					
				min = arr[i];					
			}
		}
		
		return min;
	}
}
