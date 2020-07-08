package com.leeup.javase.day05.数组;
/**
 * 数组元素反转
 * 即数组第一个元素的值与最后一个交换，第二个与倒数第二个交换，偶数个可以全部交换
 * 奇数个中间的不变
 * 所以即 数组长度/2  就知道了交换的循环次数
 * @author 李闯
 *
 */
public class Demo10_Array {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55};
		
		reverseArray(arr);
		getArrPrint(arr);
	}
	
	/**
	 * 数组元素反转
	 * 
	 */
	public static void reverseArray(int[] arr) {
		
		for (int i = 0; i < arr.length/2;  i++) {
			//arr[0] 和 arr[arr.length-1-0]交换    
			//arr[1] 和 arr[arr.length-1-1]交换
			//arr[2] 和 arr[arr.length-1-2]交换
			
			int temp = arr[i];
			arr[i] = arr[arr.length-1 - i];
			arr[arr.length-1 - i] = temp;
		}
	}
	/**
	 * 数组遍历
	 */
	public static void getArrPrint(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
