package com.leeup.javase.day13.wrapclass;

public class Demo2_Integer {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);//int最大值
		System.out.println(Integer.MIN_VALUE);//int最小值
		
		Integer i1 = new Integer(100);
		System.out.println(i1);

		Integer i2 = new Integer("100");
		System.out.println(i2);
		
		Integer i3 = new Integer("abc");//出错，数字格式异常，abc	不是数字字符串，转换会报错
	}
}
