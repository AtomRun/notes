package com.leeup.javase.day09.多态;

public class Test {

	public static void main(String[] args) {
		String s1 = "123";
		String s2 = "123";
		String s3 = "abc";
		String s4 = "abc";
		
		System.out.println(s1.equals(s2));
		System.out.println(s1+s3);
		System.out.println((s1+s3) == (s2+s4));
	}
}
