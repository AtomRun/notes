package com.leeup.javase.day08.final1;

public class Demo3_Final {

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.print();
	}
}

class Demo{
//	final int num = 10; //显示初始化的时候调用方法输出可以，final修饰的值只能被赋值一次
	final int num;		//默认初始化值0是无效的值，所以这里必须如上显式初始化
	
	
	//如果num不赋值，但是使用构造方法初始化也可以
	public Demo() {
		num = 10;
	}
			
	public void print() {
		System.out.println(num);
	}
}
