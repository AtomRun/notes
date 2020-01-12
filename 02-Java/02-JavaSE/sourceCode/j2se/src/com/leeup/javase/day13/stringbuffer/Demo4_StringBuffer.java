package com.leeup.javase.day13.stringbuffer;
/**
 * StringBuffer的替换反转功能
 * @author 李闯
 *
 */
public class Demo4_StringBuffer {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("zhongguo");
		
		sb.replace(0, 3, "lii");		//替换
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);			//字符串被反转了
		
	}
}
