package com.leeup.javase.day25.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer(掌握)
 * @author 李闯
 *
 */
public class Demo3_Timer {
	
	public static void main(String[] args) throws Throwable {
		Timer timer = new Timer();
		//在指定时间安排指定任务
		//第一个参数 安排的任务
		//第二个参数执行的时间
		//第三个参数 是过多长时间再重复执行
		timer.schedule(new MyTimerTask(), new Date(118,10,15,10,29,30),3000);
		
		while (true) {
			Thread.sleep(1000);
			System.out.println(new Date());
		}
	}
}

class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("起床背英语单词");
	}
	
}