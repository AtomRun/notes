package com.leeup.javase.day17.test;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 从键盘接收一个字符串，程序对其中所有字符进行排序，例如键盘输入：hellozhongguo程序打印：排序后的数
 * 分析：
 * 	1. 键盘录入Scanner
 * 	2. 将字符串转换为字符数组
 * 	3. 定义TreeSet集合，传入比较器对字符排序并保留重复
 * 	4. 遍历字符数组，将每个字符数组存储在TreeSet集合中
 * 	5. 遍历TreeSet集合，打印每个字符
 * @author 李闯
 *
 */
public class Test5 {

	public static void main(String[] args) {
		//1 
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串");
		String line = sc.nextLine();
		
		//2
		char [] arr = line.toCharArray();
		
		//3 
		TreeSet<Character> ts = new TreeSet<>(new Comparator<Character>() {

			@Override
			public int compare(Character c1, Character c2) {
//				int num = c1 - c2;			//自动拆箱
				int num = c1.compareTo(c2);
				return num==0?1:num;
			} 
		});
		
		//4 
		for (char c : arr) {
			ts.add(c);		//自动装箱
		}
		
		//5 
		for (Character character : ts) {
			System.out.print(character);
		}
	}
}
