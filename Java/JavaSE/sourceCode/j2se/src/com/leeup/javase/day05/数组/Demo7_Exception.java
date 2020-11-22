package com.leeup.javase.day05.数组;
/**
 * 数组操作的两个常见问题越界和空指针
 * 案例展示
 * 	ArrayIndexOutOfBoundsException:数组索引越界异常
 * 		原因：你访问了不存在的索引
 * 	NullPointerException:空指针异常
 * 		原因：数组已经不存在指向堆内存了，而你还用数组名去访问
 * 		int[] arr = {1,2,3};
 * 	 	arr = null;
 * 		System.out.println(arr[0]);
 * @author 李闯
 *
 */
public class Demo7_Exception {

	public static void main(String[] args) {
		int[] arr = new int[4];
		System.out.println(arr[5]);//当访问数组中不存在的索引会出现异常，数组索引越界异常
		
		arr = null;//本来是将数组的地址赋值给arr了，但是现在将null将地址覆盖了，那么arr就没有记录数组实体的地址了，再调用会出现空指针异常
		System.out.println(arr);
	}
}
