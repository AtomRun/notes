package com.leeup.javase.day24.threadMethod;

public class Demo2_CurrentThread {

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println(this.getName()+"////aaaa");
			}
		}.start();;
		
		new Thread(
			new Runnable() {
				
				@Override
				public void run() {
					//获取当前正在执行的线然后再拿到名字
					System.out.println(Thread.currentThread().getName()+"////bbbb");
				}
			}).start();;
		
		Thread.currentThread().setName("我是主线程");
		//卸载主线程中，意味着获取主线程的名字
		System.out.println(Thread.currentThread().getName());
	}

}
