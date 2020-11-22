package com.leeup.javase.day12.test;

import java.util.Scanner;

/**
1. 案例演示
2. 需求：把字符串反转
	1. 举例：键盘录入"abc"		
	2. 输出结果："cba"
	
	分析：
	1. 通过键盘录入获取字符串Scanner
	2. 将字符串转换成字符数组
	3. 倒着遍历字符数组，并在此拼接成字符串
	4. 打印

 * @author 李闯
 *
 */
public class Test6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入字符串");
		String line = scanner.nextLine();		//将键盘录入字符串存储在line中
		char[] arr = line.toCharArray();		//将字符串转换成字符数组
		
		String string = "";
		for (int i = arr.length-1; i >=0 ; i--) {	//倒着遍历字符数组
			string = string+arr[i];				//拼接成字符串
		}
		System.out.println(string);
	}
}
