package com.leeup.javase.day12.string;
/**
 * String类的概述
 * @author 李闯
 *
 */
public class Demo1_String {

	/**
	 *  1. 字符串字面值"abc"也可以看成一个字符串对象
     *  2. 字符串是常量，一旦被赋值，就不能被改变
	 * @param args
	 */
	public static void main(String[] args) {
		//相当于Person p = new Person();
		String str = "abc"; 			//abc可以看成一个字符串对象
		System.out.println(str);		//打印对象引用的时候，默认会调用toString方法
										//String重写了toString方法，即输出引用字符为abc
		/**
		 * 这里def也是一个对象实例
		 */
		str = "def";					//当把"def"赋值给了str，原来的str就变成了垃圾，
										//即一旦被赋值就不能被改变
		System.out.println(str);
	}
}
