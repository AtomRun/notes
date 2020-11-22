package com.leeup.javase.day05.数组;
/**
 * 数组元素查找，查找指定元素第一次在数组中出现的索引
 * @author 李闯
 *
 */
public class Demo12_Array {
	
	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55,66,77};
		
		int index = getArrayIndex(arr, 11);
		System.out.println(index);
	}
	/**
	 * 查找元素索引
	 * 1. 返回值类型：int,索引肯定是int类型的
	 * 2.参数列表：1. 数组，根据数组去查找。2. 查找的是哪个元素，值
	 */
	public static int getArrayIndex(int[] arr,int value) {
		
		for (int i = 0; i < arr.length; i++) {	//数组遍历，拿到每个元素
			if (arr[i] == value) {		//数组中的元素与查找的元素匹配
				return i;
			}
		}
		return -1;		//如果没有查找到就返回-1  
	}

}

