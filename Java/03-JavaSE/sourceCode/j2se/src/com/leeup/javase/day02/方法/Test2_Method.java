package com.leeup.javase.day02.方法;
/**
 * 案例展示
 * 		需求:根绝键盘录入的数据输出对应的九九乘法表
 * @author 李闯
 *
 */

import java.util.Scanner;

public class Test2_Method {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("请输入一个1-9之间的整数");
		
		int x = sc.nextInt();
		print99(x);
	}
	
	/**
	 * 输出对应的九九乘法表
	 * 分析
	 * 		1. 返回值类型:void
	 * 		2. 参数列表:只需要一个int数
	 */
	public static void print99(int a) {
		for (int i = 1; i < a; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(j + "*" + i + "=" + (i * j)+"\t");
			}
			System.out.println();
		}
	}
}
