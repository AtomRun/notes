package com.leeup.javase.day25.thread2;


/**
 * 等待唤醒机制
 * @author 李闯
 *
 */
public class Demo1_Notify {

	public static void main(String[] args) {
		Printer p = new Printer();
		
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
				//run方法的异常必须处理，因为父类没有抛异常，子类自然不能抛出异常
				while (true) {
					try {
						p.priint2();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}

/**
 * 想让一个方法输出一句，然后另外一个方法输出一句换之前的方法输出，交替
 * 这就涉及到了等待唤醒机制
 * @author 李闯
 *
 */
class Printer {
	
	private int flag = 1;
	
	public void priint1() throws Exception {	
		synchronized (this) {
			if (flag !=1) {
				this.wait();				//当前线程等待
			}
			System.out.print("我");
			System.out.print("爱");
			System.out.print("祖");
			System.out.print("国");
			System.out.print("\r\n");
			flag = 2;
			this.notify();					//随即唤醒单个等待的线程
		}
	}
	
	public void priint2() throws InterruptedException {
		synchronized (this) {
			if (flag!=2) {
				this.wait();
			}
			System.out.print("你");
			System.out.print("以");
			System.out.print("为");
			System.out.print("呢");
			System.out.print("\r\n");
			flag = 1;
			this.notify();
		}
	}
}
