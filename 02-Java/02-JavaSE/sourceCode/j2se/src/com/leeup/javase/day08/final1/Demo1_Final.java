package com.leeup.javase.day08.final1;

public class Demo1_Final {

	public static void main(String[] args) {
		Son son = new Son();
		son.print();
	}
}

//class Father{
//	public/*final*/ void print() {				//加了final关键字的方法不能被重写,
//												//final修饰的类，不能被继承
//												//修饰变量，变量就变成了常量，只能被赋值一次
//		System.out.println("访问底层数据资源");
//	}
//}

class Son /*extends Father*/{
	final int NUM =10;//常量命名规范，如果是一个单词，所有字母大写，每个单词都大写，中间用下划线隔开
	public void print() {
//		NUM = 20;	//当变量为final修饰的时候，num就变成了常量，不能被修改
		System.out.println(NUM);
	}
}