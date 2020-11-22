package com.leeup.javase.day09.多态;

public class Demo2_Polymorphic {

	public static void main(String[] args) {
		Father father = new Son();		//父类引用指向子类对象
		System.out.println(father.num);	//输出结果是10，因为编译看左边，即父类，运行看左边，即父类
		
		Son son = new Son();
		System.out.println(son.num);//如果本类中有，就不需要父类中的属性了，输出结果20，因为是Son类型
		
		
		Father father2 = new Son();		
		father2.print();			//输出的结果是son
		
		/**
		 * 成员方法
		 * 编译看左边(父类)，运行看右边(子类)
		 * Father father2 = new Son();	
		 * 变异的时候，为了保证编译能够通过，先去父类中找是否有print方法
		 * 如果父类中没有print方法，一定会编译不成功
		 * 但是运行的时候是使用的是子类的方法
		 * 这个也叫动态绑定
		 */
	}
}

class Father{
	int num = 10;
	
	public void print() {
		System.out.println("father");
	}
}

class Son extends Father{
	int num  = 20;
	public void print() {
		System.out.println("son");
	}
}
