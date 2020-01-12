package com.leeup.javase.day02;
/**
    1. 需求：输出下列形状
    *
	**
	***
	****
	*****
 * @author 李闯
 *
 */
public class Demo2_ForFor {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {  		//外循环决定行数
			for (int j = 0; j <= i; j++) {	//内循环决定列数
				System.out.print("*");
			}
			System.out.println();			//将光标换到下一行的行首
		}
	}
}
