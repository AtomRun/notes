package com.leeup.javase.day12.scanner;

import java.util.Scanner;

/**
 * Scanner类概述和方法介绍
 * @author 李闯
 *
 */
public class Demo1_Scanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	//键盘录入
		
//		int i = scanner.nextInt();					//键盘录入整数，存储在i中
//		System.out.println(i);
		
		if (scanner.hasNextInt()) {	//键盘录入的是int数的话，为true
			int i = scanner.nextInt();
			System.out.println(i);
		}else {
			System.out.println("输入的类型错误");
		}
	}
}
