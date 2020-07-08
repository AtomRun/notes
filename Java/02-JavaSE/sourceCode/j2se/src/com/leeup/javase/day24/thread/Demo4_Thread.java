package com.leeup.javase.day24.thread;
/**
 * 匿名内部类实现线程的两种方式
 * @author 李闯
 *
 */
public class Demo4_Thread {

	public static void main(String[] args) {
		new Thread() {							//1. 继承Thread
			public void run() {					//2. 重写run方法
				for (int i = 0; i < 1000; i++) {//3. 将要执行的代码写在run方法中
					System.out.println("aaaaaa");
				}
			}
		}.start();								//4. 开启线程
		
		
		
		new Thread(new Runnable() {				//1. 将runnable的子类对象传递给Thread的构造方法
			public void run() {					//2. 重写run方法
				for (int i = 0; i < 1000; i++) {//3. 将要执行的代码写在run方法中
					System.out.println("bb");	
				}
			}
		}).start();								//4. 开启线程
	}
}
