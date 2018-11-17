package com.leeup.javase.day12.string;

import com.sun.javafx.binding.StringFormatter;

/**
1. int length():获取字符串的长度。
2. char charAt(int index):获取指定索引位置的字符
3. int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。
4. int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引。
5. int indexOf(int ch,int fromIndex):返回指定字符在此字符串中从指定位置后第一次出现处的索引。
6. int indexOf(String str,int fromIndex):返回指定字符串在此字符串中从指定位置后第一次出现处的索引。
7. lastIndexOf
8. String substring(int start):从指定位置开始截取字符串,默认到末尾。
9. String substring(int start,int end):从指定位置开始到指定位置结束截取字符串。
 * @author 李闯
 *
 */
public class Demo5_StringMethod {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
//		demo4();
		
//		demo5();
		
//		demo6();
		
		//面试题
		String string = "woaizhongguo";
		string.substring(4);
		System.out.println(string);
		/**
		 * String类型一旦初始化就不会被改变，因为string中记录的woaizhongguo
		 * subString会产生新字符串，需要将新的字符串记录
		 * subString中修改的并没有赋值输出，而打印的还是string，这是一个陷阱
		 */
		 
	}

	private static void demo6() {
		String s1 = "zhongguoniubi";
		String s2 = s1.substring(5);
		System.out.println(s2);
		
		String s3 = s1.substring(0, 4);//包含头，不包含尾，左闭右开
		System.out.println(s3);
	}

	private static void demo5() {
		String s1 = "woaizhongguo";
		int index = s1.indexOf('g', 1);	//从指定位置开始向后找
		System.out.println(index);
		
		//从后向前找，第一次出现的字符
		int index2 = s1.lastIndexOf('a');
		System.out.println(index2);
		
		int index3 = s1.lastIndexOf('a', 3);
		System.out.println(index3);
	}

	private static void demo4() {
		String s1 = "zhong";
		
		int index = s1.indexOf("ng");//获取字符串中第一个字符出现的位置
		System.out.println(index);
		
		int index2 = s1.indexOf("a");
		System.out.println(index2);
	}

	private static void demo3() {
		String s1 = "zhongguo";
		int index = s1.indexOf('z');//参数接受的时int类型的，传递char类型的会自动提升
		System.out.println(index);
		
		int index2 = s1.indexOf('i');//如果不存在返回就是-1
		System.out.println(index2);
	}

	private static void demo2() {
		//根据字符索引获取对应位置的字符
		String s1 = "你好啊，哈哈？";
		char c1  = s1.charAt(3);
		System.out.println(c1);
		
		//会出现字符串索引越界异常
		char c2  = s1.charAt(10);
		System.out.println(c2);
	}

	private static void demo1() {
		int [] arr = {11,22,33};
		System.out.println(arr.length);//数组中的length是属性吗，没有括号
		
		String s1 = "zhongguo";
		String s2 = "中,国?";
		System.out.println(s1.length());
		System.out.println(s2.length());//length() 是一个方法，获取的是每一个字符的个数
	}
}
 