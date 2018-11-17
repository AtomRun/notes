package com.leeup.javase.day14.regex;

public class Demo2_Regex {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
//		demo4();
		
//		demo5();
		
//		demo6();
		
//		demo7();
		
	}

	private static void demo7() {
		String regex = "[a-z&&[^m-p]]";
		System.out.println("A".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("m".matches(regex));
		System.out.println("n".matches(regex));
		System.out.println("o".matches(regex));
		System.out.println("p".matches(regex));
		System.out.println("q".matches(regex));
	}

	private static void demo6() {
		String regex = "[a-z&&[^bc]]";
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("e".matches(regex));
		System.out.println("f".matches(regex));
		System.out.println("g".matches(regex));
	}

	private static void demo5() {
		String regex = "[a-z&&[def]]";			//取交集
		System.out.println("a".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("z".matches(regex));
		System.out.println("c".matches(regex));
	}

	private static void demo4() {
		String regex = "[a-d[m-p]]";
		System.out.println("a".matches(regex));
		System.out.println("m".matches(regex));
		System.out.println("n".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("z".matches(regex));
	}

	private static void demo3() {
		String regex = "[a-zA-z]";
		System.out.println("a".matches(regex));
		System.out.println("A".matches(regex));
		System.out.println("z".matches(regex));
		System.out.println("Z".matches(regex));
		System.out.println("1".matches(regex));
		System.out.println("%".matches(regex));
	}

	private static void demo2() {
		String regex = "[^abc]";
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("1".matches(regex));
		System.out.println("%".matches(regex));
		System.out.println("10".matches(regex));//false,[] 代表单个字符，然而10代表字符和0字符
	}

	private static void demo1() {
		String regex = "[abc]";		//[] 代表单个字符
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("1".matches(regex));
		System.out.println("%".matches(regex));
	}
}
