package com.leeup.javase.day01;
/**
 * 数据类型
 * @author 李闯
 *
 */
public class Demo3_DataType01 {

	
	public static void main(String[] args) {
		//整数类型
		byte b = 10; //占一个字节，- 128-127
		short s = 20;//占两个字节
		int i = 30;  //占四个字节，java中整数默认的数据类型就是int类型
		//System.out.println(10);这个10就是默认的int类型
		long x = 40; //占八个字节,如果long后加L标识最好加大L，因为小l太像1了
		
		//浮点类型
		float f = 23.3F;//占四个字节，小数默认类型为double类型，如果大的数据类型放到小的数据类型中，会损失精度
		double d = 33.4;//八个字节,小数默认的数据类型是double类型的
		System.out.println(f);
		System.out.println(d);
		
		//字符类型
		char c = 'a'; //占两个字节
		System.out.println(c);
		
		//布尔类型
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1);
		System.out.println(b2);
	}
}
