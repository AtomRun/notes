package com.leeup.javase.day24.syn;

public class Demo4_Ticket {

	public static void main(String[] args) {
		MyTicket myTicket = new MyTicket();
		new Thread(myTicket).start();
		new Thread(myTicket).start();
		new Thread(myTicket).start();
		new Thread(myTicket).start();
		
		//多次启动同一个线程是非法的
	}
}


class MyTicket implements Runnable {

	private int tickets = 100;
	
	@Override
	public void run() {
		while (true) {
			synchronized (this) {	//可以使用this。因为锁对象其实就创建了一次，myTicket就相当于this
				if (tickets == 0) {
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"...这是第"+tickets-- + "号票");
			}
		}
	}
	
}