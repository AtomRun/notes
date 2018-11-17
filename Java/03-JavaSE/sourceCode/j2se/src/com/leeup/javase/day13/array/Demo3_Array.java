package com.leeup.javase.day13.array;
/**
 * 数组高级二分查找原理图解
 * @author 李闯
 *
 */
public class Demo3_Array {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55,66,77};
		System.out.println(getIndex(arr, 22));
		System.out.println(getIndex(arr, 66));
		System.out.println(getIndex(arr, 88));
		
		int a = 213;
		
		StringBuffer sb = new StringBuffer(a);
		
		System.out.println(sb.toString());
	}
	
	/**
	 * 二分查找的方法
	 * 1. 返回值类型，int
	 * 2. 参数列表，int[] arr,int value
	 */
	
	public static int getIndex(int[] arr,int value) {
		int min = 0;
		int max = arr.length-1;//数组 -1是数组的索引最大值
		int mid = (min+max)/2;//数组中间的位置

		while (arr[mid] !=value) {		//拿到的数不等于中间数再进行循环查找，否则直接返回
			if (arr[mid]<value) {		//当中间值小于要找的值
				min = mid + 1;			//最小的索引改变
			}else if (arr[mid]>value) { //当中间值大雨了要找的值
				max = mid-1;			//最大的索引改变
			}
			mid = (max+min)/2;			//无论最大还是最小改变，中间索引都会随之改变
			if (min>max) {				//如果最小索引大于最大索引，就没有查找的可能性了返回-1
				return -1;
			}
		}
		
		return mid;
	}
}
