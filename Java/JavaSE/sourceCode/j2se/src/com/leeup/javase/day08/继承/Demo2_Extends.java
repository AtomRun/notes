package com.leeup.javase.day08.继承;

public class Demo2_Extends {

}

class DemoA{
	public void show() {
		System.out.println("DemoA");
	}
}
class DemoB extends DemoA{
	public void show() {
		System.out.println("DemoB");
	}
}

/**
 * 为什么不支持多继承呢？
 * 多继承有安全隐患，如果c同时继承的ab的话，这意味着c可以拿到两个show方法，但是这两个show方法的语句体是不同的
 * 
 * @author 李闯
 *
 */
class DemoC extends DemoB{
	public void print() {
		System.out.println("DemoC");
	}
}