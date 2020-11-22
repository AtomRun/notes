package com.leeup.javase.day14.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  1. 正则表达式的获取功能
        1. Pattern和Matcher的结合使用
    2. 案例演示
        1. 需求：把一个字符串中的手机号码获取出来
 * @author 李闯
 *
 */
public class Demo9_Test {

	public static void main(String[] args) {
		String s = "我的手机号码是18933561234,曾经用过12345678906,还用过19029450000";
		String regex = "1[0-9]\\d{9}";//手机号码的正则表达式
		/*Pattern p = Pattern.compile(regex);	
		Matcher m = p.matcher(s);		
		boolean b = m.matches();
		
		System.out.println(b);*/
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		
//		boolean b = m.find();
//		System.out.println(b);
//		
//		String s1 = m.group();
//		System.out.println(s1);
		
		while (m.find())
			System.out.println(m.group());
	}
}
