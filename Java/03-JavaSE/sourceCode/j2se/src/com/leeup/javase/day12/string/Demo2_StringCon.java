package com.leeup.javase.day12.string;
/**
 *  1. public String(); 空构造
    2. public String(byte[] bytes); 把字节数组转成字符串
    3. public String(byte[] bytes,int index,int length); 把字节数组的一部分转成字符串
    4. public String(char[] value); 把字符数组转成字符串
    5. public String(char[] value,int index,int count); 把字符数组的一部分转成字符串
    6. public String(String original); 把字符串常量值转成字符串
 * @author 李闯
 *
 */
public class Demo2_StringCon {

	public static void main(String[] args) {
		//1
		String s1 = new String();//空构造，就是创建一个空字符串
		System.out.println(s1); //空构造默认输出的结果也是空串
		
		//2
		byte[] arr1 = {97,98,99};
		String s2 = new String(arr1);//解码，将计算机读得懂的转换成我们读得懂的
		System.out.println(s2);//输出结果为abc，97，98，99,对应的ASCII表的数值码
		
		//3
		byte[] arr2 = {97,98,99,100,101,102};//把字节数组的一部分转成字符串
		String s3 = new String(arr2,2,3); 
		System.out.println(s3);
		
		//4
		char[] arr3 = {'a','b','c','d','e'};//将字符数组转换成字符串
		String s4 = new String(arr3);
		System.out.println(arr3);
		
		//5
		String s5 = new String(arr3,1,3);//把字符数组的一部分转成字符串
		System.out.println(s5);
		
		//6.
		String s6 = new String("hello");//把字符串常量值转成字符串
		System.out.println(s6);
	}
}
