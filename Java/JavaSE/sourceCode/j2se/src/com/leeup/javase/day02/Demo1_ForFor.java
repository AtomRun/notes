package com.leeup.javase.day02;
/**
 * for循环嵌套
 * 需求：输出一个4行5列的星星(*)图案
 * 	如图：
 * 		*****
 * 		*****
 * 		*****
 * 		*****
 * 
 * 注意：System.out.println("*");和System.out.print("*");的区别
 * 区别，println 每次输出之后后买能自动加个换行，print不加换行，
 * @author 李闯
 *
 */
public class Demo1_ForFor {

	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {			//外循环

			System.out.println("i = "+ i);
			for (int j = 1; j <= 3; j++) {		//内循环
				System.out.println("j = "+ j);
			}
		
		}
		
		for (int i = 1; i <= 4; i++) {			//外循环决定行数
			for (int j = 0; j <= 5; j++) {		//内循环决定列数
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
