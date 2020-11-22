package com.leeup.javase.day13.wrapclass;

/**
 自动装箱：把基本类型转换为包装类型
 自动拆箱：把包装类型转换为基本类型
 * @author 李闯
 *
 */
public class Demo4_JDK5 {

	public static void main(String[] args) {
		
		//将基本数据类型包装成对象，即装箱
		int x = 100;
		Integer i = new Integer(x);
		
		//将对象转换为基本数据类型，即拆箱
		int y = i.intValue();
		
		//JDK1.5 之后这个事情就变得特别简单了
		Integer i2 = 100;			//自动装箱，把基本数据类型转换为对象
		int z = i2 + 200;			//i2本身是个引用数据类型，i2中里面记录的应该是地址值，但是i2
									//和200能相加，结果为300，说明它变成了基本数据类型的100
									//这个过程就叫自动拆箱，把对象转换为基本数据类型，变成了
									//100与200相加，其实底层用的也是intValue把i2转换成对应的int值
		System.out.println(z);
		
		Integer i3 = null;
		int a = 3 + 100;			//这样就会出现空指针异常，因为当i3记录null的时候，即没有
									//记录任何一个对象的地址值，这个时候使用i3调用intValue
									//就是使用null调用方法，就会出现空指针异常
	}
}
