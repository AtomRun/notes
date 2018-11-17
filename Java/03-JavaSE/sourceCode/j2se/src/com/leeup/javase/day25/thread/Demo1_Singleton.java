package com.leeup.javase.day25.thread;

public class Demo1_Singleton {

	public static void main(String[] args) {
//		Singleton s1 = new Singleton();
		
		
		//1
//		Singleton s1 = Singleton.s;		//成员变量被私有了，不能通过类名.调用
//		Singleton.s = null;
//		Singleton s2 = Singleton.s;
//		System.out.println(s1==s2);
		
		//2 
/*		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1==s2);*/
		
		//3
		Singleton s1 = Singleton.s;
		Singleton s2 = Singleton.s;
		System.out.println(s1==s2);
	}
}


class Singleton {  
	//1. 私有构造方法,其他类不能访问该构造方法
	private Singleton() {
		 
	}
	//2. 创建本类对象 
	public static final  Singleton s = new Singleton(); 
	
	
}


/**
 * 饿汉式和懒汉式的区别
 * 1. 饿汉式是空间换时间，即上来就创建对象，把空间给浪费了，节省了时间，想用直接就返回了 
 * 		懒汉式是时间换空间，上来就声明，不去创建，什么时候用，什么时候创建，还要判断，就是浪费了时间(不推荐)
 * 2. 在多线程访问时，饿汉式不会创建多个对象，而懒汉式有可能会创建多个对象
 */


/**
 * 懒汉式
 * 面试中会要求写一个单例的延迟加载模式
 * 两种方式懒汉式较好
 * 因为如果是多线程访问，第一条线程进来发现s==null，条件满足就进来了，但是如果不小心，线程执行权被其他线程拿走了
 * 线程1就在等待了，线程2从外面进来了，这时候s还是null，线程2也在等待。这时候线程1抢回中执行权，就创建了一个对象，返回了s
 * 线程2也抢回了执行权，创建了对象，这样就创建了两次对象，就不是单例设计模式了
 */
/*
class Singleton {  
	//1. 私有构造方法,其他类不能访问该构造方法
	private Singleton() {
		 
	}
	//2. 创建本类对象 
	private static Singleton s; 
	
	//3. 对外提供公共的访问方法
	public static Singleton getInstance() {		//获取实例
		if (s==null) {
			s = new Singleton();
		}
		return s;
	}
}
*/

/**
 * 饿汉式：
 * 	
 * @author 李闯
 *
 */
/*
class Singleton {
	//1. 私有构造方法,其他类不能访问该构造方法
	private Singleton() {
		 
	}
	//2. 创建本类对象
	private static Singleton s = new Singleton(); 
	
	//3. 对外提供公共的访问方法
	public static Singleton getInstance() {		//获取实例
		return s;
	}
}
*/