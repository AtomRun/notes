package com.leeup.javase.day24.threadMethod;
/**
 * 礼让线程，让出cpu
 * @author 李闯
 *
 */
public class Demo6_Yield {

	public static void main(String[] args) {
		new MyThread().start();
		new MyThread().start();
	}
}

class MyThread extends Thread {
	public void run() {
		for (int i = 0; i <=1000; i++) {
			if (i%10==0) {
				Thread.yield();		//让出cpu
				System.out.println(getName()+"..."+i);
			}
		}
	}
}
