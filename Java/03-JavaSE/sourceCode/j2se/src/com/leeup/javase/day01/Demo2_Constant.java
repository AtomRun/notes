package com.leeup.javase.day01; 
/**
   * 常量
 * @author 李闯
 *
 */
public class Demo2_Constant {

	public static void main(String[] args) {
		/*
		 * 字面值常量的分类
		字符串常量        使用双引号括起来的内容
		整数常量          所有整数
		小数常量          所有小数
		字符常量          用单引号括起来的内容，里面只能放单个数字，单个字符，单个符号
		布尔常量          较为特殊，只有true和false
		空常量            null [数组部分讲解]
		 * */
		System.out.println("abc");//[字符串常量]
		System.out.println(123);  //[整数常量]
		System.out.println(12.3); //[小数常量]
		System.out.println('1');  //[字符常量，里面只能放单个数字，单个字符，单个符号，单引号中必须必须放的是单个字符。''中什么不妨也不可以，因为代表不了任何字符，代表空格可以]
		System.out.println(true); //[布尔类型,只有两个值，true和false]
		System.out.println(false);
	}
}
