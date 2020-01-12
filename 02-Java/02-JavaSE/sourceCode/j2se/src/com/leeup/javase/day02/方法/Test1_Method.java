package com.leeup.javase.day02.方法;

import java.util.Scanner;

/**
 * 1. 案例展示
 * 	需求:键盘接收两个数据,返回两个数中的较大值
 * 2. 案例展示
 * 	需求:键盘录入两个数据,比较两个数是否相等
 * @author 李闯
 *
 */
public class Test1_Method {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//1. 创建键盘录入对象
		
		System.out.println("请输入第一个整数!");
		int x = sc.nextInt();				//2. 键盘录入的值存储在x中
		System.out.println("请输入第二个整数!");
		int y = sc.nextInt();
		
		int max = getMax(x, y);
		System.out.println("您输入的的最大值为"+max);
		
		
		boolean b =isEquals(x, y);
		System.out.println(b == true?"您输入的两个数相同":"您输入的两个数不同");
	}
	
	/**
	 * 方法返回两个整数值中的较大值
	 * 分析
	 * 1. 明确返回值类型 int 
	 * 2. 明确参数列表,两个int整数
	 */
	public static int getMax(int a,int b) {
		return a > b ? a:b;
	}
	
	/**
	 * 方法比较两个数是否相等
	 * 分析:
	 * 1. 明确返回值类型 boolean
	 * 2. 明确参数列表,两个int类型
	 */
	public static boolean isEquals(int a,int b) {
		return a == b;//a==b 即true,a!=b 即false
	}
}
