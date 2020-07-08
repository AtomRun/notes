package com.leeup.javase.day24.threadMethod;
/**
 * 加入线程(掌握)
 * @author 李闯
 * join
 */
public class Demo5_Join {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(getName()+"...aaaaaa");
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					if (i==2) {
						try {
//							t1.join();	//有异常，因为t1是一个局部变量，而当前所在是匿名内部类，
//										//匿名内部类要使用所在方法的局部变量的时候，必须用final修饰
							
							t1.join(1);//插队指定时间，时间过了之后，两条线程交替执行
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(getName()+"...bb");
				}
			}
		};
		t1.start();
		t2.start();
	}
}
