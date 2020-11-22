package com.leeup.javase.day24.threadMethod;
/**
 * 休眠线程(掌握)
 * @author 李闯
 *
 */
public class Demo3_Sleep {

	public static void main(String[] args) throws InterruptedException {
//		demo1();
		new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(getName()+"......aaaaaaaaa");
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(getName()+"......bbbbb");
				}
			}
		}.start();
	}

	private static void demo1() throws InterruptedException {
		for (int i = 20; i > 0 ; i--) {
			Thread.sleep(1000);					//线程睡眠，中断异常
			System.out.println("倒计时"+i+"秒");
		}
	}
}
