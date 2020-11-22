package com.leeup.javase.day24.syn;
/**
 * 同步代码块(掌握)
 * @author 李闯
 *
 */
public class Demo1_Synchronized {

	public static void main(String[] args) {
		Printer p = new Printer();
		
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

class Printer {
	Demo demo = new Demo();
	public void priint1() {
		synchronized (demo) {					//同步代码块，锁机制，锁对象是任意的
			System.out.print("我");
			System.out.print("爱");
			System.out.print("祖");
			System.out.print("国");
			System.out.print("\r\n");
		}
	}
	
	public void priint2() {
		synchronized (demo) {					//锁对象不能用匿名对象，因为匿名对象不是同一个对象
			System.out.print("你");
			System.out.print("以");
			System.out.print("为");
			System.out.print("呢");
			System.out.print("\r\n");
		}
	}
}

class Demo{
	
}