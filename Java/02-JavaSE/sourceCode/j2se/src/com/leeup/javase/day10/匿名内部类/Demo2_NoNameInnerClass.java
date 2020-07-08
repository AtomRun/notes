package com.leeup.javase.day10.匿名内部类;

public class Demo2_NoNameInnerClass {

	public static void main(String[] args) {
		Outer1 outer1 = new Outer1();
		outer1.method();
	}
}

interface Inter1 {
	public void show1();
	public void show2();
}

/**
 * 匿名内部类只针对重写一个方法时候使用，多个方法时应使用有名字的方法
 * 匿名内部类不能向下转型，因为没有子类类名 
 * @author 李闯
 *
 */
class Outer1 {
	
	public void method() {
		
		//较为臃肿
		/*new Inter1() {	//实现接口并且重写他的方法
			
			@Override
			public void show2() {
				System.out.println("show2");
			}
			
			@Override
			public void show1() {
				System.out.println("show1");
			}
		}.show1();
		
		new Inter1() {	//实现接口并且重写他的方法
			
			@Override
			public void show2() {
				System.out.println("show2");
			}
			
			@Override
			public void show1() {
				System.out.println("show1");
			}
		}.show2();*/
		
		new Inter1() {	//实现接口并且重写他的方法
			
			@Override
			public void show2() {
				System.out.println("show2");
			}
			
			@Override
			public void show1() {
				System.out.println("show1");
			}
		}.show2();
	}
}