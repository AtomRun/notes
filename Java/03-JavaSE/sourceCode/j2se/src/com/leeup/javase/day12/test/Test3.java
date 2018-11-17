package com.leeup.javase.day12.test;
/**
 * 	1. 案例演示
		1. 需求：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数,其他字符出现的次数。
		2. ABCDEabcd123456!@#$%^
	1. 分析
		字符串都是由字符组成的，而字符的值都是有范围的，例如小a字符到小c字符，ASCII码表，
		通过范围，来判断是否包含该字符，如果包含，就让计数器变量自增
 * @author 李闯
 *
 */
public class Test3 {

	public static void main(String[] args) {
		String string = "ABCDEabcd123456!@#$%^";
		
		//定义计数器
		int big = 0;
		int small = 0;
		int num = 0;
		int other = 0;
		
		//1， 获取每个 字符,通过for循环遍历
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);//通过索引获取每个字符
			//2，判断字符是否在这个范围内
			if (c>='A' && c<= 'Z') {
				//大写字母
				big ++;//如果满足是大写字母，就让其对应的变量自增
			}else if(c >='a' && c<='z') {
				small++;
			}else if(c > '0' && c <= '9') {
				num++;
			}else {
				other++;
			}
		}
		//3，打印每个计数器的结果
		System.out.println("字符串中大写字母有："+big+"个，小写字母有"+small+"个，数字有"+num+"个，其他字符有"
		+other+"个");
	}
}
