package com.leeup.javase.day05.数组;
/**
 * 数组查表法[根据键盘录入的索引，查找对应的星期]
 * @author 李闯
 *
 */

import java.util.Scanner;

public class Demo11_Array {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("请输出对应的星期，范围在1-7：");
		int week = scanner.nextInt();
		System.out.println("您输入的转换星期是"+getWeek(week));
	}
	
	/**
	 * 根据索引返回对应的星期
	 * 1. 返回值类型：返回中文类型即char
	 * 2. 参数列表：int
	 */
	public static char getWeek(int week) {
		char[] arr = {',','一','二','三','四','五','六','日'};	//定义了一张星期表
		return arr[week];					//通过索引获取表中的元素
	}
}
