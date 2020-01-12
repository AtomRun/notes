package com.leeup.javase.day24.thread;

public class Demo2_Thread {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();		//创建Thread类的子类对象
		myThread.start();						//开启线程
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("我是主线程的代码");
		}
	}
}

class MyThread extends Thread {	//1. 继承Thread
	
	
	//2 重写run方法
	public void run() {
		for (int i = 0; i < 1000; i++) {	//3. 将要执行的代码写在run方法中
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
	}
}