package com.leeup.javase.day25.thread2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3_ReentrantLock {

	public static void main(String[] args) {
		Printer3 p = new Printer3();
		
		new Thread() {
			public void run() {
				while (true) {
					try {
						p.priint1();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while (true) {
					try {
						p.priint2();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while (true) {
					try {
						p.priint3();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
class Printer3 {
	private ReentrantLock r = new ReentrantLock();
	
	private Condition c1 = r.newCondition();
	private Condition c2 = r.newCondition();
	private Condition c3 = r.newCondition();
	
	private int flag = 1;
	
	public void priint1() throws Exception {
		r.lock(); 					//获取锁
			if (flag !=1) {
				c1.await();
			}
			System.out.print("我");
			System.out.print("爱");
			System.out.print("祖");
			System.out.print("国");
			System.out.print("\r\n");
			flag = 2; 
//			this.notify ();
			c2.signal();
			
		r.unlock(); 	 		//释放锁
	}
	
	public void priint2() throws InterruptedException {
		r.lock(); 					//获取锁
		if (flag!=2) {
				c2.await();
			}
			System.out.print("你");
			System.out.print("以");
			System.out.print("为");
			System.out.print("呢");
			System.out.print("\r\n");
			flag = 3;
//			this.notify();
			c3.signal();
			r.unlock(); 	 		//释放锁
	}
	
	public void priint3() throws InterruptedException {
		r.lock(); 					//获取锁
		if (flag!=3) {
				c3.await();
			}
			System.out.print("s");
			System.out.print("k");
			System.out.print("r");
			System.out.print("W");
			System.out.print("u");
			System.out.print("\r\n");
			flag = 1;
//			this.notify();
			c1.signal();
			r.unlock(); 	 		//释放锁
	}
}

