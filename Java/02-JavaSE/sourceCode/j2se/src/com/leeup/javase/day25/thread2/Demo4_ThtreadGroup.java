package com.leeup.javase.day25.thread2;
/**
 * ThreadGroup
 * @author 李闯
 *
 */
public class Demo4_ThtreadGroup {

	public static void main(String[] args) {
//		demo1();
		
		ThreadGroup tg = new ThreadGroup("我是一个新的线程组");		//创建新的线程组
		MyRunnable mr = new MyRunnable();						//创建Runnble的子类对象
		
		Thread t1 = new Thread(tg,mr,"张三");						//将线程t1放在组中
		Thread t2 = new Thread(tg,mr,"李四");						//将线程t2放在组中
		
		System.out.println(t1.getThreadGroup().getName());		//获取组名
		System.out.println(t2.getThreadGroup().getName());		
		/**
		 * 变成组的好处就是可以统一设置线程状态例如下
		 */
		tg.setDaemon(true);
	}

	private static void demo1() {
		Thread t1 = new Thread(new MyRunnable(),"张三");
		Thread t2 = new Thread(new MyRunnable(),"李四");
		
		ThreadGroup tg1 = t1.getThreadGroup();
		ThreadGroup tg2 = t2.getThreadGroup();
		
		System.out.println(tg1.getName());//输出结果为main，即默认所有线程都是主线程
		System.out.println(tg2.getName());
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName()+"..."+i);
		}
	}
	
}