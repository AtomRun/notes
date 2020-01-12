package com.leeup.javase.day17.test;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 使用Scanner从键盘读取一行输入，去掉其中重复字符，打印出不同的那些字符
 * @author 李闯
 * 
 * 分析：
 * 	1. 创建Scanner对象
 *  2. 创建HashSet对象
 *	3. 将字符存储，去掉重复
 *  4. 将字符串转换为字符数组，获取每个字符存储在HashSet集合中，自动去除重复
 *  5. 遍历HashSet，打印每个字符
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一行字符串");
		
		HashSet<Character> hs = new HashSet<>();
		
		String line = scanner.nextLine();
		char[] arr = line.toCharArray();
		//将每个字符存储到HashSet集合中，遍历字符串数组
		for (char c : arr) {
			hs.add(c);
		}
		//遍历HashSet，打印每个字符
		for (Character c:hs) {
			System.out.println(c);
		}
	}
}
