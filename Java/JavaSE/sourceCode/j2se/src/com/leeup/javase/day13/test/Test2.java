package com.leeup.javase.day13.test;

import java.util.Scanner;


/**
 * 使用StringBuffer字符串反转
 * @author 李闯
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
//		//将获取到的字符串转换成StringBuffer对象
//		StringBuffer sb = new StringBuffer(line);
//		sb.reverse();
//		System.out.println(sb);
		
		//使用方法形式
		
		System.out.println(revese(line));
	}
	
	/**
	 * 抽取成方法
	 */
	public static String revese(String line) {
		StringBuffer sb = new StringBuffer(line);
		sb.reverse();
		return sb.toString();
	}
}
