package com.leeup.javase.day10.静态内部类;

public class Demo1_InnerClass {

	public static void main(String[] args) {
		/**
		 * 如何去调用静态的成员内部类的方法
		 * 
		 * Outer.Inner中Outer是一个类名。Outerus.Inner是调用了Inner的一个构造
		 */
		Outer.Inner oInner = new Outer.Inner();
		oInner.method();
		
		/**
		 * 静态内部类的静态方法如何访问
		 */
		Outer.Inner2.print();
	}
}

class Outer{
	static class Inner {
		public void method() {
			System.out.println("method");
		}
	}
	
	static class Inner2{
		public static void print() {
			System.out.println("print");
		}
	}
}
