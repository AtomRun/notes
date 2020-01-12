package com.leeup.javase.day25.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author 李闯
 *
 */ 
public class Demo5_Excutors {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);//创建线程池
		pool.submit(new MyRunnable());	//将线程放在池子里并执行
		pool.submit(new MyRunnable());
		
		pool.shutdown();				//执行完之后关闭线程池
	}
}
