package com.leeup.javase.day02;
/**
 * 输出2次你好
 * 输出7次你好
 * 输出13次你好
 * @author 李闯 
 *
 */
public class Test1 {
	public static void main(String[] args) {
		for (int i = 1; i <=10; i++) {
			 if (i%3==0) {
//				break;			//两次你好i%3==0第三次时break跳出
//				continue;		//使用continue跳出本次循环，当i的值为3，6，9的时候都满足会跳出，所以会输出7次
				System.out.println("你好");   //10里只有3，6，9能够%3==0,所以额外会输出三次，加上下面十次共13次
			}
			 System.out.println("你好");
		}
	}
}
