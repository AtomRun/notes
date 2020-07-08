package com.leeup.javase.day08.继承;
/**
 * 不同名方法和同名方法
 * @author 李闯
 *
 */
public class Demo7_Extends {

	public static void main(String[] args) {
		Son4 s = new Son4();
		s.print();			//当子类出现与父类方法相同时，会自己调用子类的方法，这个叫"重写"
		s.method();
	}
}

class Father4{

	public void print() {
		System.out.println("fu print");
	}
}

class Son4 extends Father4{
	public void method() {
		System.out.println("zi method");
	}
	
	public void print() {			
		super.print();		//依然可以使用super调用父类的方法
		System.out.println("zi print");
	}
}