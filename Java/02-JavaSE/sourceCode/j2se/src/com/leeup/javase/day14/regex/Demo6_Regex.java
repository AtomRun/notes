package com.leeup.javase.day14.regex;
/**
 * 正则表达式的替换功能
 * 	String类的功能：public String replaceAll(String regex,String replacement)
 * @author 李闯
 *
 */
public class Demo6_Regex {

	public static void main(String[] args) {
		String s1 = "wo1ai2zhongguo";
		String regex = "\\d";		//  \\d代表的是任意数字
		String s2 = s1.replaceAll(regex, "");
		
		System.out.println(s2);
	}
}
