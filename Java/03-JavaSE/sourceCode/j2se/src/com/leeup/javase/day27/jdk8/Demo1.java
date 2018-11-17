package com.leeup.javase.day27.jdk8;


public class Demo1 {

	public static void main(String[] args) {
		/*
		Demo d = new Demo();
		d.print();
		
		Inter.method();
		*/
		
		Demo demo = new Demo();
		demo.run();
	}
}

interface Inter {
	public default void print() {				//必须是default
		System.out.println("Hello World");
	}
	
	public static void method() {				//
		System.out.println("static method");
	}
}

class Demo implements Inter {
	
	public void run() {
		
		int num = 10;
		
		class Inner {
			public void function() {
				System.out.println("fun");
				
//				num = 20;		系统默认会自动加上final
				/**
				 * 1.7 之前不能直接输出,因为局部内部类使用方法中的局部变量必须用方法修饰
				 */
				System.out.println(num);
			}
		}
		Inner inner = new Inner();
		inner.function();
	}
}