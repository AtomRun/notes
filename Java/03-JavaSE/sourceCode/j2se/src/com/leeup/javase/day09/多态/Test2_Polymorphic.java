package com.leeup.javase.day09.多态;

public class Test2_Polymorphic {

	public static void main(String[] args) {
		A a = new B();
		a.show();	//编译看左边，运行看右边，虽然B中没有重写show方法，但是从A中继承了show方法，B继承的
					//show方法中调用了show2而B中的show2输出的是爱，故结果是爱
	}
}

class A{
	public void show() {
		show2();
	}
	public void show2() {
		System.out.println("我");
	}
}


class B extends A {
	public void show2() {
		System.out.println("爱");
	}
}

class C extends B{
	
	public void show() {
		super.show();
	}
	
	public void show2() {
		System.out.println("你");
	}
}