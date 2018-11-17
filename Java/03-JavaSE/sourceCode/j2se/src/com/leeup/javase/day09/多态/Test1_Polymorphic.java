package com.leeup.javase.day09.多态;

public class Test1_Polymorphic {

	public static void main(String[] args) {
		Fu f = new Zi();
//		f.method();//左边没有method方法
		f.show();		//编译看左边，运行看右边，如果子类中有show方法，会执行子类的show
						//但是如果子类中没有该方法，执行的是父类的show方法
	}
}


class Fu {
	public void show() {
		System.out.println("Fu show");
	}
}

class Zi extends Fu{
//	public void show() {
//		System.out.println("Zi Show");
//	}
	public void method() {
		System.out.println("Zi method");
	}
}