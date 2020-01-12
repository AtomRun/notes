package com.leeup.javase.day12.test;
/**
1. 案例演示
	1. 需求：把数组中的数据按照指定个格式拼接成一个字符串
	2. 举例：
			int[] arr = {1,2,3};	
		输出结果：
			"[1, 2, 3]"
			
		分析：
		1. 需要定义一个字符串"["
		2. 遍历数组，获取每一个元素
		3. 用字符串与数组中的元素进行拼接
 * @author 李闯
 *
 */
public class Test5 {

	public static void main(String[] args) {
		int [] arr = {1,2,3};
		String s = "[";	//定义一个字符串用来与数组中元素拼接
		
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length-1) {
				s = s +arr[i]+ "]";
			}else {
				s = s + arr[i] + ", ";		
			}
		}
		System.out.println(s);
	}
}
