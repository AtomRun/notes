package com.leeup.javase.day14.regex;
/**
 * 正则表达式的分割功能
 * @author 李闯
 *
 */
public class Demo5_Spilit {

	public static void main(String[] args) {
		String s1 = "金三胖 郭美美 李dayone";
		String s2 = "金三胖.郭美美.李dayone";
		
		String[] arr = s1.split("\\.");
		/**
		 * 在这里.代表任意字符，当s2进来的时候，金就被分割，后面的每个字都会匹配都被分割了，相当于什么都没得到
		 * 如果非要用.分割，我们需要转义即 \\.
		 */
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
