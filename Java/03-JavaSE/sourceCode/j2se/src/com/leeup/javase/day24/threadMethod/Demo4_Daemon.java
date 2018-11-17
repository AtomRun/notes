package com.leeup.javase.day24.threadMethod;
/**
 * 守护线程(掌握)
 * @author 李闯
 *
 */
public class Demo4_Daemon {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 2 ; i++) {
					System.out.println(getName()+"...aaaaaaaaaaaa");
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 50 ; i++) {
					System.out.println(getName()+"...bb");
				}
			}
		};
		t2.setDaemon(true);	//当传入true的时候就是意味着设置为守护线程
		t1.start();
		t2.start();
	}
}
