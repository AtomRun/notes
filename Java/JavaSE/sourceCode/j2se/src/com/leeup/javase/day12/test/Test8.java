package com.leeup.javase.day12.test;

import java.util.Scanner;

/**
   3. 从键盘录入一个字符串，统计该串中有大写字母、小写字母、数字各有多少个。
举例:
	Hello12345World
	大写 : 2个
	小写 : 8个
	数字 : 5个
 * @author 李闯
 *
 */
public class Test8 {

	public static void main(String[] args) {
		int big = 0;
		int small = 0;
		int num = 0;
		int other = 0;
		
		System.out.println("请输入一串字符");
		
		Scanner scanner = new Scanner(System.in);
		String all = scanner.nextLine();
		for (int i = 0; i < all.length(); i++) {
			char c = all.charAt(i);
			if (c>='A' && c<='Z') {
				// 大写字母
				big++;
			}else if (c>='a' && c<='z') {
				//小写字母
				small++;
			}else if (c>='0' && c<= '9') {
				//数字
				num++;
			}else {
				//其他字符
				other++;
			}
		}
		System.out.println("您输入的字符中大写字母有"+big+"个，小写字母有"+small+"个，数字字符有"+num+"个，其他字符有"+other+"个");
	}
}
