package com.leeup.javase.day25.thread2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程程序实现的方式3(了解)
 * @author 李闯
 *
 */
public class Demo6_Callable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/**
		 * 可以抛异常
		 */
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Future<Integer> f1 = pool.submit(new MyCallable(100));
		Future<Integer> f2 = pool.submit(new MyCallable(50));
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		pool.shutdown();
		
	}
}

class MyCallable implements Callable<Integer> {

	private int num;
	public MyCallable(int num) {
		this.num = num;
	}
	
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		return sum;
	}
}