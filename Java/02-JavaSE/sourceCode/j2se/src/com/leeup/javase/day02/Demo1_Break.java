package com.leeup.javase.day02;
/**
 * break 的使用场景
 * 	只能在switch和循环中
 * @author 李闯
 *
 */
public class Demo1_Break {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 4) {
				break; //跳出循环
			}
			System.out.println("x = "+i);
		}
	}
}
