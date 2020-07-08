package com.leeup.javase.day12.string;
/**
 * 1. String类的判断功能
		1. boolean equals(Object obj):比较字符串的内容是否相同,区分大小写
		2. boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写
		3. boolean contains(String str):判断大字符串中是否包含小字符串
		4. boolean startsWith(String str):判断字符串是否以某个指定的字符串开头
		5. boolean endsWith(String str):判断字符串是否以某个指定的字符串结尾
		6. boolean isEmpty():判断字符串是否为空。
 * @author 李闯
 *
 */
public class Demo4_StringMethod {

	public static void main(String[] args) {
		demo1();
		
		demo2();
		
		String s1 = "zhongguo";
		String s2 = "";
		String s3 = null;
		System.out.println(s1.isEmpty());
		System.out.println(s2.isEmpty());
		System.out.println(s3.isEmpty());
		/**
		 * NullPointerException 
		 * 引用为空，再使用null调用String的方法，所以他会报异常
		 * 
		 * 空串和null的区别：
		 * "" 是字符串常量，同时也是一个String类的对象，既然是对象当然可以调用String
		 * 类中的方法，
		 * null是空常量，不能调用任何的方法，否则会出现空指针异常，null常量，可以给
		 * 任意的引用数据类型赋值
		 */
	}

	private static void demo2() {
		String s1 = "我爱中国,哈哈";
		String s2 = "中国";
		String s3 = "你以为呢";
		String s4 = "我爱";
		String s5 = "哈哈";
		
		System.out.println(s1.contains(s2));
		System.out.println(s1.contains(s3));//判断是否包含传入的字符串
		System.out.println("============");
		
		System.out.println(s1.startsWith(s4));//判断是否以传入的字符串开头
		System.out.println(s1.startsWith(s5));
		System.out.println("============");
		System.out.println(s1.endsWith(s4));//判断是否以传入的字符串结尾
		System.out.println(s1.endsWith(s5));
		System.out.println("============");
	}

	private static void demo1() {
		String s1 = "lichuang";
		String s2 = "lichuang";
		String s3 = "Lichuang";
		
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));//false，区分大小写
		
		System.out.println("============");
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1.equalsIgnoreCase(s3));//都为true，不区分大小写
		
		System.out.println("============");
	}
}
