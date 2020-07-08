package com.leeup.javase.day13.array;
/**
 * 数组高级冒泡排序
 * @author 李闯
 *
 */
public class Demo1_Array {

	public static void main(String[] args) {
		int[] arr = {24,69,20,57,13};
		bubbleSort(arr);
		print(arr);
	}
	
	/**
	 * 冒泡排序
	 * 1.返回值类型：void
	 * 2.参数列表：int[] arr
	 * 
	 * 第一次：arr[0]与arr[1],arr[1]与arr[2],arr[2]与arr[3],arr[3]与arr[4]比较4次
	 * 第二次：arr[0]与arr[1],arr[1]与arr[2],arr[2]与arr[3],比较3次
	 * 第三次：arr[0]与arr[1],arr[1]与arr[2],比较2次
	 * 第四次：arr[0]与arr[1],比较1次
	 * 
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length -1; i++) {	//外循环只需要比较arr.length-1次即可
			for (int j = 0; j < arr.length-1 - i; j++) {//-1为了防止数组越界 -i是为了比较次数正确，提高效率
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	/**
	 * 打印数组
	 * 1.  返回值类型:void
	 * 2. 参数列表int[] arr
	 */
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}
