package com.leeup.javase.day09.接口;

public class Demo1_Interface {

	public static void main(String[] args) {
//		Inter inter = new Inter();//接口不能实例化，和抽象类相同，因为方法都是抽象的，调用没有意义
		Inter inter = new Demo();//父类引用指向子类对象，继承是亲爹，接口是干爹
		inter.print();
	}
}


interface Inter {
	//定义方法
	public abstract void print();//接口中的方法都是抽象的
}

class Demo implements Inter{	//或者让方法进行抽象，不推荐，建议重写所有方法

	@Override
	public void print() {
		//接口中的抽象方法也需要被重写
	}
	
}