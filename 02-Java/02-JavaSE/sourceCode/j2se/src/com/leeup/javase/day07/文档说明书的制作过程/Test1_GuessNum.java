package com.leeup.javase.day07.文档说明书的制作过程;

import java.util.Scanner;

/**
 * 猜数字游戏
 * @author 李闯
 *
 */
public class Test1_GuessNum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个1-100之间的整数");
		int guessNum = (int)(Math.random() * 100)+1;//生成需要猜的数
		
		while(true) {								//要猜很多次，用无限循环
			int resultNum = sc.nextInt();			//大家猜的数
			if (guessNum>resultNum) {				//猜的数小于生成的数
				System.out.println("您猜的数小了");
			}else if (resultNum>guessNum) {
				System.out.println("您猜的数大了");		//猜的数大于生成的数
			}else {
				System.out.println("恭喜您猜中了");		//猜对了
				break;
			}
		}
	}
}
