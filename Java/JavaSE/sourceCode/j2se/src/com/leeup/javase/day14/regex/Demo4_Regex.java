package com.leeup.javase.day14.regex;


/**
 1. Greedy 数量词 
    1. X? X，一次或一次也没有
    2. X* X，零次或多次
    3. X+ X，一次或多次
    4. X{n} X，恰好 n 次 
    5. X{n,} X，至少 n 次 
    6. X{n,m} X，至少 n 次，但是不超过 m 次 
 * @author 李闯
 *
 */
public class Demo4_Regex {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
//		demo4();
		
//		demo5();
		
		String regex = "[abc]{5,15}";
		System.out.println("abcc".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("abcacabcbba".matches(regex));
		System.out.println("abcacabcbbacac".matches(regex));
 	}

	private static void demo5() {
		String regex = "[abc]{5,}";//最少5次,5次到无穷大
		System.out.println("abcc".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("abcacabcbba".matches(regex));
	}

	private static void demo4() {
		String regex = "[abc]{5}";
		System.out.println("abcac".matches(regex));
		System.out.println("abcacabcbba".matches(regex));
		System.out.println("abca".matches(regex));
	}

	private static void demo3() {
		String regex = "[abc]+";
		System.out.println("".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("abcbabca".matches(regex));
	}

	private static void demo2() {
		String regex = "[abc]*";
		System.out.println("".matches(regex));
		System.out.println("abc".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("ababc".matches(regex));
		System.out.println("abcabcabc".matches(regex));
	}

	private static void demo1() {
		String regex = "[abc]?";
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("".matches(regex));	//一次也没有
	}
}
