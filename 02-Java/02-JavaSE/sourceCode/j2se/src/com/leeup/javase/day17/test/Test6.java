package com.leeup.javase.day17.test;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 程序启动后，可以从键盘输入接收多个整数,直到输入quit时结束输入，把所有输入的整数倒叙排列打印
 * @author 李闯
 * 分析：
 * 	1. Scanner键盘录入
 *  2. 创建TreeSet集合对象，TreeSet传入比较器
 *  3. 无限循环不断地接收整数吗，遇到quit退出， 因为退出是quit，键盘录入的时候都以字符串的形式
 *  4. 判断是quit就退出，不是就将其转换为Integer并添加到集合中
 *  5. 遍历TreeSet集合并打印每个元素
 */
public class Test6 {

	public static void main(String[] args) {
		//1 
		Scanner sc = new Scanner(System.in);
		
		//2  
		TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
//				int num = i2 -i1;//自动拆箱。Integer转为 int进行计算
				int num = i2.compareTo(i1);
				return num==0?1:num;
			}
		});
		//3 
		while (true) {
			String line = sc.nextLine();
			if ("quit".equals(line)) {
				break;
			}
			Integer i = Integer.parseInt(line);
			ts.add(i);
		}
		//5 
		for (Integer integer : ts) {
			System.out.println(integer);
		}
	}
}
