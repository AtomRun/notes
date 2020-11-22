package com.leeup.javase.day02;
/**
 * 控制台输出九九乘法表
 * @author 李闯
 * 1 * 1 = 1
 * 1 * 2 = 2  2 * 2 = 4
 * 1 * 3 = 3  2 * 3 = 6  3 * 3 = 9
 * 
 */
public class Demo3_For99 {

	public static void main(String[] args) {
		  for (int i = 1; i <= 9; i++) {   //行数
			for (int j = 1; j <= i; j++) { //列数
				System.out.print(j + "*" + i +"="+(i*j)+'\t');
			}
			System.out.println();
		}
	}
}
