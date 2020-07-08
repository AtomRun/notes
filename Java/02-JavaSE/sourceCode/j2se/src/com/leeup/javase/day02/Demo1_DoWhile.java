package com.leeup.javase.day02;
/**
 * do_while执行流程
 * 在控制台输出数据1-10
 * @author 李闯
 *
 */
public class Demo1_DoWhile {

	public static void main(String[] args) {
		int i = 1;
		do {
			System.out.println("i = "+i);
			i++;
		} while (i<=10);
	}
}
