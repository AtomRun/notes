package com.leeup.javase.day10.匿名内部类;

public class Demo1_NoNameInnerClass {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method();
	}
}

interface Inter{
	public void print();
}

/**
 * 有名字的内部类
 * @author 李闯
 *
 */
class Outer {
	class Inner implements Inter{

		@Override
		public void print() {
			System.out.println("print");
		}
	}
	public void method() {
		Inner inner = new Inner();
		inner.print();
		
		/**
		 * 代表Inter的子类对象 
		 */
		new Inner().print();
		
		/**
		 * 匿名内部类与局部内部类相同，都存在于方法中
		 */
		new Inter() {	//实现Inter接口，必须要重写接口中的方法
			 
			@Override
			public void print() {
				System.out.println("print2");
			}
		}.print();;
		
	}
}