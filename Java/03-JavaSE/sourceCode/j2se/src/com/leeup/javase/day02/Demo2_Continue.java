package com.leeup.javase.day02;
/**
 * continue的使用场景
 * 	只能在循环中
 * @author 李闯
 *
 */
public class Demo2_Continue {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 4) {
				continue; //终止本次循环，继续下次循环
			}
			System.out.println("x = "+i);
		}
	}
}
