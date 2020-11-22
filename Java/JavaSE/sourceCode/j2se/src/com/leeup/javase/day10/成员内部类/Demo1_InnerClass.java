package com.leeup.javase.day10.成员内部类;


public class Demo1_InnerClass {

	public static void main(String[] args) {
		//如何让method方法执行,直接new不行，因为JVM不知道Inner是属于哪个类的Inner，要告诉他是属于Inner的
//		Inner inner = new Inner();
//		inner.method();
		/**
		 * 这里Inner是外部类的成员，把他看成外部类的成员就好了
		 * 要先new Outer对象
		 * 外部类访问内部类成员被必须创建对象，格式就如下
		 */
		Outer.Inner oiInner = new Outer().new Inner();//创建内部类对象
		oiInner.method();
		
	}
}


class Outer {
	
	private int num = 10;
	
	class Inner {
		public void method() {
			System.out.println("Hello World");
			/**
			 * 内部类可以访问外部类的私有成员
			 * 因为内部类相当于外部类的成员方法
			 */
			System.out.println(num);
		}
	}
}