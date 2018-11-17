package com.leeup.javase.day14.regex;
/**
    1. \d 数字：[0-9]
    2. \D 非数字：[^0-9]
    3. \s 空白字符：[ \t\n\x0B\f\r]	  \t指的是table键，\n指的是会按行，\x0B在dos命令的时候有垂直制表符和水平制表符，\x0B属于垂直制表符
    								\f 翻页，\r回车,\n换行
    4. \S 非空白字符：[^\S]
    5. \s 单词字符：[a-zA-Z_0-9]
    6. \W 非单词字符：[^\W]
 * @author 李闯
 *
 */
public class Demo3_regex {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
//		demo4();
		
//		demo5();
		
//		demo6();
		
		demo7();
	}

	private static void demo7() {
		String regex = "\\W";
		System.out.println("a".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("_".matches(regex));
		System.out.println("+".matches(regex));
		System.out.println("%".matches(regex));
	}

	private static void demo6() {
		String regex = "\\w";
		System.out.println("a".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("_".matches(regex));
		System.out.println("+".matches(regex));
		System.out.println("%".matches(regex));
	}

	private static void demo5() {
		String regex = "\\S";
		System.out.println("a".matches(regex));
		System.out.println(" ".matches(regex));
		System.out.println("	".matches(regex));//tab键
		System.out.println("    ".matches(regex));//四个空格
	}

	private static void demo4() {
		String regex = "\\s";
		System.out.println(" ".matches(regex));
		System.out.println("	".matches(regex));	//一个tab键
		System.out.println("    ".matches(regex));	//四个空格
	}

	private static void demo3() {
		String regex = "\\D";
		System.out.println("a".matches(regex));
		System.out.println("0".matches(regex));
		System.out.println("9".matches(regex));
	}

	private static void demo2() {
		String regex = "\\d";		//反斜线代表转义字符，如果想表示\d的话，需要\\d
		System.out.println("0".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("9".matches(regex));
	}

	private static void demo1() {
		String regex = ".";
		System.out.println("a".matches(regex));
		System.out.println("ab".matches(regex));//代表任意字符，因为只有一个. /所以两个字符不行
	}
}
