package com.leeup.javase.day25.thread2;
/**
 * 
 * @author 李闯
 *
 */
public class Demo2_NotifyAll {

	public static void main(String[] args) {
		
		Printer2 p = new Printer2();
		
		new Thread() {
			public void run () {
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
			public void run () {
				while (true) {
					try {
						p.priint2();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run () {
				while (true) {
					try {
						p.priint3();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}

class Printer2 {
	
	private int flag = 1;
	
	public void priint1() throws Exception {	
		synchronized (this) {
			while (flag !=1) {
				this.wait();			
			}
			System.out.print("我");
			System.out.print("爱");
			System.out.print("祖");
			System.out.print("国");
			System.out.print("\r\n");
			flag = 2; 
//			this.notify ();
			this.notifyAll();
		}
	}
	
	public void priint2() throws InterruptedException {
		synchronized (this) {
			while (flag!=2) {
				this.wait();
			}
			System.out.print("你");
			System.out.print("以");
			System.out.print("为");
			System.out.print("呢");
			System.out.print("\r\n");
			flag = 3;
//			this.notify();
			this.notifyAll();
		}
	}
	
	public void priint3() throws InterruptedException {
		synchronized (this) {
			while (flag!=3) {
				this.wait();			//线程3在此等待，if语句是在哪里等待就在哪里起来
										//while循环是循环判断，每一次都会判断标记，
			}
			System.out.print("s");
			System.out.print("k");
			System.out.print("r");
			System.out.print("W");
			System.out.print("u");
			System.out.print("\r\n");
			flag = 1;
//			this.notify();
			this.notifyAll();
		}
	}
}

