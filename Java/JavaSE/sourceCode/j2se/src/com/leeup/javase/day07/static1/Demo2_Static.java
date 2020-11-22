package com.leeup.javase.day07.static1;


public class Demo2_Static {

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.print1();	
		
		Demo.print1();
	}
}

class Demo{
	int num1 = 10;			//静态成员变量
	static int num2 = 20;	//非静态的成员变量
	
	//非静态的成员方法，即可以访问静态的成员，也可以访问非静态的成员
//	public void print1() {
//		System.out.println(num1);
//		System.out.println(num2);
//	}
	
	/**
	 * 为什么静态的不能访问非静态的呢？？
	 * 因为当class一加载到内存中的时候，静态方法或者属性随着类的加载而加载了，
	 * 但是当加载的时候，很有可能并没有创建对象，即非静态的属性值，只有在创建对象的时候才能用。虽然非静态的属性和静态的属性一起被加载进方法区，但是静态的加载了可以直接用
	 * 使用类名直接访问，非静态必须要创建对象，才能调用
	 * 静态方法或者属性值不需要通过new对象也可以调用，优先于对象的存在，在对象还没存在的时候，静态已经存在了
	 */
	
	
	//静态的成员方法
	public static void print1() {
//		System.out.println(num1);	//这里放num1会报错，因为num1是非静态的，静态的成员方法不能访问非静态的属性，会报错
		System.out.println(num2);
		
		/**
		 * 在静态方法中没有this关键字的，为什么？
		 * System.out.println(num1); 这个num1是一个非静态的成员变量，在这里直接写num1，其实就是this.num1，成员变量都是用对象调用的。
		 * this只有创建对象的时候才有值，在类一加载时候，还没创建对象。也有可能一直都不创建对象，即只有静态方法的时候，就可以不用创建对象
		 * 
		 * 类加载不一定就是创建对象，调用静态方法也会类加载，所以静态中不能有this，this就必须要有对象，他才有值
		 */
	}
}