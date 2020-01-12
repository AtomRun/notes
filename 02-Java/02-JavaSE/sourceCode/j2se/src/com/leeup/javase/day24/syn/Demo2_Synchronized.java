package com.leeup.javase.day24.syn;
/**
 * 同步代码块(掌握)
 * @author 李闯
 *
 */
public class Demo2_Synchronized {

	public static void main(String[] args) {
		Printer2 p = new Printer2();
		
		new Thread() {
			public void run() {
				while (true) {
					p.priint1();
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while (true) {
					p.priint2();
				}
			}
		}.start();
	}
}

class Printer2 {
	Demo1 demo = new Demo1();
	//非静态的同步方法的锁对象是什么？
	//非静态的同步方法的锁对象是this  
	
	//静态的同步方法的锁对象是什么？
	//是该类的字节码对象
	public synchronized void priint1() {		//同步方法只需要在方法上添加synchronized关键字即可 
			System.out.print("我");
			System.out.print("爱");
			System.out.print("祖");
			System.out.print("国");
			System.out.print("\r\n");
	}
	
	public static void priint2() {
		synchronized (Printer2.class) {					
			System.out.print("你");
			System.out.print("以");
			System.out.print("为");
			System.out.print("呢");
			System.out.print("\r\n");
		}
	}
}

class Demo1{
	
}