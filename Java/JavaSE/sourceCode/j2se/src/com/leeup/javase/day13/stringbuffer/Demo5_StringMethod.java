package com.leeup.javase.day13.stringbuffer;
/**
 * StringBuffer的截取功能
 * @author 李闯
 *
 */
public class Demo5_StringMethod {

	public static void main(String[] args) {
		StringBuffer  sb = new StringBuffer("woaizhongguo");
		String str = sb.substring(4);	//默认从索引到元素的末尾
		System.out.println(str);
		/**
		 * 截取完之后产生了 新的字符串记录，原sb并没有改变
		 */
		System.out.println(sb);
		
		String str2 = sb.substring(4, 7);
		System.out.println(str2);
		
	}
}
