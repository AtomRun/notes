package com.leeup.javase.day27.枚举2;

public class Demo1_Enum {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
//		demo3();
		
		Week3 wed = Week3.WED;
		switch (wed) {
		case MON:
			System.out.println("星期一");
			break;
		case TUE:
			System.out.println("星期二");
			break;
		case WED:
			System.out.println("星期三");
			break;
		}
	}

	private static void demo3() {
		Week3 mon = Week3.MON;
		mon.show();
	}

	private static void demo2() {
		Week2 mon = Week2.MON;
		
		
		System.out.println(mon.getName());
	}

	private static void demo1() {
		Week mon = Week.MON;
		System.out.println(mon);		//将实例名字说出来
	}
}
