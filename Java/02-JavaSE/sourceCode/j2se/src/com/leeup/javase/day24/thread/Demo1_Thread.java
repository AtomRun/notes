package com.leeup.javase.day24.thread;
/**
 * Java程序运行原理和JVM的启动是多线程的吗
 * @author 李闯
 * 证明JVM是多线程的
 */
public class Demo1_Thread {

	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			new Demo();
		}
//		System.out.println(1/0);
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("我是主线程的执行代码");
		}
	}
}

class Demo {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("垃圾被清扫了");
	}
	
}