package com.leeup.javase.day13.wrapclass;
/**
 * String和int类型的相互转换
 * @author 李闯
 *
 */
public class Demo3_Integer {

	public static void main(String[] args) {
		
		demo1();
		/**
		 * 基本数据类型包装类有八种，其中其中都是parseXxx方法，可以将这七种字符串表现形式转换成基本数据类型 
		 */
		String s1 = "true";
		boolean b = Boolean.parseBoolean(s1);
		System.out.println(b);
		
		String s2 = "abc";
//		char c = Character.pa					//char包装类中没有parseXxx方法，因为假设s2是个字符串，转换为字符，c中只能存一个，就装不下了，
												//而且字符串转换为字符不需要这个方法。我们可以通过toCharArray()就可以吧字符串转换为字符数组
	}

	private static void demo1() {
		//int转String
		int i = 100;
		String s1 = i+ "";					//推荐使用
		System.out.println(s1);				//推荐使用
		
		String s2 = String.valueOf(i);
		System.out.println(s2);
		
		Integer i2 = new Integer(i);
		System.out.println(i2.toString());//返回一个表示Integer值的String对象
		
		String s3 = Integer.toString(i);
		System.out.println(s3);
		
		//String转int
		String s = "200";
		Integer i3 = new Integer(s);
		int i4 = i3.intValue();			//将Integer转换成了int数
		
		int i5 = Integer.parseInt(s);
		System.out.println(i5);			//将String转换为int数，推荐使用
	}
}
