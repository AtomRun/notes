package com.leeup.javase.day14.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo8_Pattern {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("a*b");		//获取到正则表达式，这里a*b表明a出现一次或者多次然后就是一个b
		Matcher m = p.matcher("aaaaaab");		//通过刚刚给我的数据，返回一个匹配器，即看这个字符串是否能拿这个正则匹配上
		boolean b = m.matches();				//看是否能匹配上，匹配就返回true,否则就是false
		
		
		System.out.println(b);
		//上面代码其实就是如下
		System.out.println("aaaaab".matches("a*b"));
		
	}
}
