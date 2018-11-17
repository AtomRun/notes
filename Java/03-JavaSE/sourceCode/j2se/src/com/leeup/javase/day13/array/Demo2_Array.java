package com.leeup.javase.day13.array;
/**
 * 数组高级选择排序原理图解
 * @author 李闯
 *
 */
public class Demo2_Array {

	public static void main(String[] args) {
		int[] arr = {24,69,20,57,13};
		selectSort(arr);
		print(arr);
	}
	
	/**
	 * 选择排序
	 * 1. 返回值类型void
	 * 2. 参数列表int[] arr
	 * 
	 * 第一次：arr[0]分别与arr[1-4]比较，比较4次
	 * 第二次：arr[1]分别与arr[1-3]比较，比较3次
	 * 第三次：arr[2]分别与arr[1-2]比较，比较2次
	 * 第四次：arr[3]分别与arr[4]比较，比较1次
	 */
	
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {	//五个数比较4次，即length-1
			for (int j = i+1; j < arr.length; j++) {	//j=i+1
				if (arr[i]>arr[j]) {
//					int temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
					
					//将重复代码抽取出来成为方法
					swap(arr, i, j);
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
	
	/**
	 * 换位操作
	 * 1. 返回值类型，void
	 * 2. 参数列表int[] arr,int i,int j
	 * 
	 * 如果某个方法，只对本类使用，不想让其他类使用，就可以定义成私有的
	 */
	private static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
