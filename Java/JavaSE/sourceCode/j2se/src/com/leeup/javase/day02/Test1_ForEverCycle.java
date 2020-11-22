package com.leeup.javase.day02;
/**
 * 无限循环
 * @author 李闯
 *
 */
public class Test1_ForEverCycle {

	public static void main(String[] args) {
		
		//while语句的无限循环
		while (true) {
			System.out.println("hello world");
		}
		//System.out.println("hello world"); //因为上面的语句是无限循环，一直执行，而这条语句永远都执行不到，所以这条语句不允许被书写
	//但无限循环可以使用控制语句，满足某种语句跳出循环，没有满足就一直循环	
		
		//for语句的无限循环
//		for(;;) {
//			System.out.println("Hello World");
//		}
	}
}
