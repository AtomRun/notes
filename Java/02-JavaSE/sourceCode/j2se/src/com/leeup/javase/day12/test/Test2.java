package com.leeup.javase.day12.test;

public class Test2 {

	public static void main(String[] args) {
		String string = "zhongguo";
		
		for (int i = 0; i < string.length(); i++) { //通过for循环，获取到字符串的每个字符的索引
			//通过索引获取每个元素
//			char c = string.charAt(i);
//			System.out.println(c);
			
			System.out.println(string.charAt(i));	//通过索引获取每个字符，
		}
	}
}
