package com.leeup.javase.day12.test;
/**
 * 	1. 案例演示
		1. 需求：把一个字符串的首字母转成大写，其余为小写。(只考虑英文大小写字母字符)
		
	链式编程：只要保证每次调用完方法返回的是对象，就可以继续调用
 * @author 李闯
 *
 */
public class Test4 {
	public static void main(String[] args) {
		String string = "woAiZUguoniNE";
		String s2 = string.substring(0,1).toUpperCase().concat(string.substring(1)
				.toLowerCase());
		System.out.println(s2);
		
	}
}
