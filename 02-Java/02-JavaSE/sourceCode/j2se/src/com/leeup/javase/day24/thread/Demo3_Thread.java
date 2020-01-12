package com.leeup.javase.day24.thread;
/**
 * 多线程程序实现的方式2(掌握)
 * @author 李闯
 *
 */
public class Demo3_Thread {

	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();		//4. 创建runnable子类对象
		//Runnable target = mr; 父类引用指向子类对象
		Thread thread = new Thread(mr);			//5. 将其当作参数传递给Thread的构造函数
		thread.start();							//6. 开启线程
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("我是主线程的代码");
		}
		
	}
}

class MyRunnable implements Runnable {			//1. 定义一个类，实现Runnable

	@Override
	public void run() {							//2. 重写run方法
			for (int i = 0; i < 1000; i++) {	//3. 将要执行的代码写在run方法中
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			}
	}
}