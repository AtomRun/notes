package com.leeup.javase.day08.继承;

public class Demo3_Extends {

	public static void main(String[] args) {
		Son son = new Son();
		son.show();
	}
}

class Father{
	private String name;
	/**
	 * show方法定义为privte的时候，子类无法访问
	 */
	public void show() {
		System.out.println("Hello World");
	}
}

class Son extends Father{
	
}
