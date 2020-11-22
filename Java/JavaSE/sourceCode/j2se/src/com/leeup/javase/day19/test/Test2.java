package com.leeup.javase.day19.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 练习
 * @author 李闯
 *	分析：
 *	1. 创建键盘录入对象
 *	2. 将键盘录入的结果存储在String类型的字符串中，存储int类型中，如果有不符合条件的，直接报错，无法进行后续判断
 *  3. 键盘录入的结果转换成int类型的数据，是正确的还是错误的
 *  4. 正确的直接转换，
 *  5. 错误的要进行判断
 *	
 */
public class Test2 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("请输入一个整数");
		 while(true) {
			 String line = sc.nextLine();			//键盘录入的结果存储在line中
			 try {
				 int num = Integer.parseInt(line);		//将字符串准换为整数
				 System.out.println(Integer.toBinaryString(num));	//将整数转换为二进制
				 break;
			 } catch (Exception e) {
				 try {
					 new BigInteger(line);
					 System.out.println("录入错误，您录入的是一个过大的整数，请重新输入一个整数：");
				} catch (Exception e2) {
					try {
						new BigDecimal(line);
						 System.out.println("录入错误，您录入的是一个小数，请重新输入一个整数：");
					} catch (Exception e1) {
						 System.out.println("录入错误，您录入的是非法字符，请重新输入一个整数：");
					}
				}
				 
			 }
		 }
	}
}
