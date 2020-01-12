package com.leeup.javase.day13.stringbuffer;
/**
 * StringBuffer和String的相互转换
 * @author 李闯
 *
 */
public class Demo6_StringBuffer {

	public static void main(String[] args) {
//		demo1();
		
		StringBuffer sb = new StringBuffer("zhonguo");
		
		//通过构造将StringBudffer转为String
		String s1 = new String(sb);
		System.out.println(s1);
		
		//通过toString方法将StringBuffer转换为String
		System.out.println(sb.toString());
		
		//通过截取字符串将StringBuffer转换为String字符串
		String s3 = s1.substring(0, s1.length());
		System.out.println(s3);
		
	}

	private static void demo1() {
		StringBuffer sb1 = new StringBuffer("zhongguo");	//通过构造方法将字符串转换为StringBuffer对象
		System.out.println(sb1);
		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("zhongguo");
		System.out.println(sb2);		//通过append方法将字符串转换为StringBuffer对象
	}
}
