package com.leeup.javase.day14.test;

import java.util.Arrays;

/**
  1. 案例演示
     1. 需求：我有如下一个字符串:"91 27 46 38 50"，请写代码实现最终输出结果是："27 38 46 50 91"
     
     分析：
     1. 将字符串切割成字符串数组，切割成字符串数组，就可以拿到里面的每个字符元素
     2. 将字符串转换为数字并且将其存储在一个等长度的int数组中 [与字符串数组长度相同]
     3. 排序
     4. 将排序后的结果遍历并拼接成一个字符串
 * @author 李闯
 *
 */
public class Test1 {

	public static void main(String[] args) {
		String s = "91 27 46 38 50";
		//1. 将字符串切割成字符串数组
		String[] sArr = s.split(" ");//根据空格切割
		//2. 将字符串转换为数字并且将其存储在一个等长度的int数组中(与字符串数组长度相同)
		int[] arr = new int[sArr.length];
		for (int i = 0; i < arr.length; i++) {
//			arr[i] = sArr[i];		//直接将字符数组元素赋值给int元素不行，需要转换
			arr[i] = Integer.parseInt(sArr[i]);	//将数字字符串转换为数字
		}
		//3.排序
		Arrays.sort(arr);
		//遍历并且拼接字符串,下面这种方式使用String会产生很多垃圾，
		//每次相加，之前的字符串就会变成垃圾
		/**String str = "";
		for (int i = 0; i < arr.length; i++) {
			if (i==arr.length-1) {				//当i等于最大索引
				str = str + arr[i];				//27 38 46 50 91
			}else {
				str = str +arr[i]+" ";			//27 38 46 50 
			}
		}
		System.out.println(str);
		
		*/
		//使用StringBuilder做
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i==arr.length-1) {				
				sb.append(arr[i]);
			}else {
				sb.append(arr[i]+ " ");
			}
		}
		System.out.println(sb);
	}
}
