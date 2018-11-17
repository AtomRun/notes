package com.leeup.javase.day02;
/**
 * 控制跳转语句return语句和break区别
 * @author 李闯
 *
 */
public class Demo4_Return {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i==4) {
				System.out.println(i);
//				break;  //i==4时循环结束了,代码继续向下执行 ,循环结束了会被输出
				return; //用来返回方法，将主方法返回了，停止了，在break和return后有代码时体现较为明显
			}
		}
		System.out.println("循环结束了");
	}
}
