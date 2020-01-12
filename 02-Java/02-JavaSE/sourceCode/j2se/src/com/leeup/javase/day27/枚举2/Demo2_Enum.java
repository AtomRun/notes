package com.leeup.javase.day27.枚举2;
/**
 * 枚举类的常见方法
 * @author 李闯
 *
 */
public class Demo2_Enum {

	public static void main(String[] args) {
//		demo1();
		
		Week2 mon = Week2.valueOf(Week2.class,"MON");		//通过字节码获取枚举项
		
		System.out.println(mon);
		
		Week2[] arr = Week2.values();
		for (Week2 week2 : arr) {
			System.out.println(week2);
		}
	}

	private static void demo1() {
		Week2 mon = Week2.MON;
		Week2 tue = Week2.TUE;
		Week2 wed = Week2.WED;
		
		//枚举项都是有编号的
		System.out.println(mon.ordinal());
		System.out.println(tue.ordinal());
		System.out.println(wed.ordinal());
		
		//比较的是编号
		System.out.println(mon.compareTo(tue));
		System.out.println(mon.compareTo(wed));
		System.out.println("==================");
		
		System.out.println(mon.name());//获取实例名称
		System.out.println(mon.toString());	//调用toString方法
	}
}
