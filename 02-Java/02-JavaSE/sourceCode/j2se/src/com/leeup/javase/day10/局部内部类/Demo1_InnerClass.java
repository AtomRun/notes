package com.leeup.javase.day10.局部内部类;

public class Demo1_InnerClass {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method();
	}
}

/**
 * 局部内部类
 * @author 李闯
 *
 */
class Outer {
	/**
	 * 开发中很少见这种情况
	 */
	public void method() {
		
		/**
		 * 当调用本方法时，局部变量的生命周期和方法相同，
		 * 如果局部内部类对象还没有消失想用这个局部变量，就没办法了，
		 * 但是当final修饰的时候会保存在方法区的常量池内，使用即使方法弹栈，常量池的常量还在，可以继续使用
		 */
		int num = 10;
		
		class Inner {
			public void print () {
				System.out.println("Hello World");
				System.out.println(num);
			}
			
		}
		Inner inner = new Inner();
		inner.print();
	}
	
	public void run() {
		/**
		 * 局部内部类相当于局部变量
		 * 局部变量只在方法内有效，所以同理，访问方法中的类，无法直接访问
		 */
//		Inner i = new Inner();
//		i.print
	}
	
}
