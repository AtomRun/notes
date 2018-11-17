package com.leeup.javase.day14.test;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 如何获取任意年份是平年还是闰年
 * @author 李闯
 */
public class Test3 {

	public static void main(String[] args) {
		/**
		 * 分析：
		 * 1. 键盘录入年 Scanner
		 * 2. 创建Calendar对象， 
		 * 3. 通过set方法设置为那一年的3月1号
		 * 4. 将日向前减去1，就变成了二月的最后一天
		 * 5. 判断日是多少天，如果是29天，返回true，否则返回false
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入年份，判断该年份是否是闰年还是平年");
		String line = scanner.nextLine();	//录入数字字符串
		
		
		int year = Integer.parseInt(line);	//将数字字符串转换为字符串
		
		boolean b = getYear(year);
		
		System.out.println(b);
	}

	private static boolean getYear(int year) {
		Calendar calendar = Calendar.getInstance();
		
		//设置为那一年的三月一日
		calendar.set(year,2,1);
		//将日向前减去1
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		//判断是否是29天
		return calendar.get(Calendar.DAY_OF_MONTH)==29;
	}
}

