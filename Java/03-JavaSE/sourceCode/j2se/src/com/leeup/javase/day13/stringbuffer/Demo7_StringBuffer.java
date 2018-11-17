package com.leeup.javase.day13.stringbuffer;
/**
 * String和StringBuffer分别作为参数传递
 * @author 李闯
 * 基本数据类型的值传递：不改变其值
 * 引用数组类型的值传递：改变其值
 */
public class Demo7_StringBuffer {

	public static void main(String[] args) {
		String s = "zhongguo";
		System.out.println(s);
		
		change(s);
		System.out.println(s);//输出结果还是zhongguo
		/**
		 * String类虽然算引用数据类型，但是他当作参数传递时，和基本数据类型时一样的
		 * 因为String这个类一旦被赋值初始化就不能被改变
		 */
		System.out.println("分隔符");
		StringBuffer sb = new StringBuffer();
		sb.append("zhongguo");
		System.out.println(sb);
		change(sb);
		System.out.println(sb);
		/**
		 * String和StringBuffer做值传递时是有去别的
		 * String当作参数传递时，和基本数据类型一样，方法弹栈改变的值消失
		 * 
		 * StringBuffer不会，因为StringBuffer是可变的字符序列
		 */
	}

	public static void change(StringBuffer sb) {
		sb.append("woai");
	}

	public static void change(String s) {
		s += "woai";
		//方法一旦弹栈s就消失了
	} 
}
