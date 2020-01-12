package com.leeup.javase.day12.scanner;

import java.util.Scanner;


/**
 * Scanner常见方法及问题解决方案
 * @author 李闯
 *
 */
public class Demo2_Scanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//使用nextInt方法
//		System.out.println("请输入第一个整数：");
//		int i = scanner.nextInt();
//		System.out.println("请输入第二个整数：");
//		int j = scanner.nextInt();
//		System.out.println("第一个数为"+i+"，第二个整数为"+j);
		
		//使用nextLine方法
		System.out.println("请输入第一个字符串");
		String line1 = scanner.nextLine();
		System.out.println("请输入第二个字符串");
		String line2 = scanner.nextLine();
		
		System.out.println("第一个字符串为："+line1+"，第二个字符串为"+line2);
		/**
		 * 当第一个输入方式使用nextInt，第二个数的输入方式改成nextLine的时候第一个数输完之后，直接就执行到最后了
		 * nextInt是键盘录入整数的方法，当我们录入10的时候，其实在键盘上录入的是10和\r\n，录入10我们
		 * 要敲一下回车，回车就是\r\n
		 * nextInt只获取10就结束了
		 * nextLine是键盘录入字符串的方法，可以接收任意类型的方法，但是他凭什么能获取一行呢？
		 * 通过\r\n,只要遇到\r\n就证明一行结束。在这里。如果遇到\r\n，nextLine方法直接就结束了
		 * 
		 * 解决方案：
		 * 1. 创建两个scanner接收不同的数据，但是浪费空间
		 * 2. 将键盘录入的都是字符串，即都用nextLine方法门后面我们会学习将整数字符串转换成整数的方法 
		 */
		
	}
}
