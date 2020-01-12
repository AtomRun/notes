package com.leeup.javase.day10.成员内部类;


public class Demo2_InnerClass {

	public static void main(String[] args) {
		/**
		 * 当内部类私有的时候，这种访问方式不行，没办法根据父类new子类
		 */
//		Outer1.Inner oiInner = new Outer1().new Inner();
		/**
		 * 成员内部类被私有的时候，可以使用这种方式调用 
		 */
		Outer1 outer1 = new Outer1();
		outer1.print();
		
	}
}


class Outer1 {
	
	private int num = 10;
	
	private class Inner {
		public void method() {
			System.out.println(num);
		}
	}
	public void print() {
		/**
		 * 内部类相当于外部类的成员，即使是私有的，也是可以访问的
		 */
		Inner inner = new Inner();
		inner.method();
	}
}