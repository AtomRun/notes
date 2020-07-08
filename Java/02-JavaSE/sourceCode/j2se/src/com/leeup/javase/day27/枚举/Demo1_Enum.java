package com.leeup.javase.day27.枚举;
/**
 * 
 * @author 李闯
 *
 */
public class Demo1_Enum {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		Week3 mon = Week3.MON;
		mon.show();
	}

	private static void demo2() {
		Week2 week2 = Week2.MON;
		System.out.println(week2);
	}

	private static void demo1() {
		Week mon = Week.MON;
		Week tue = Week.TUE;
		Week wed = Week.WED;
		
		
		System.out.println(mon);
		System.out.println(tue);
		System.out.println(wed);
	}
}
