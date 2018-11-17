package com.leeup.javase.day19.exception;
/**
 * try...catch的方式处理异常1
 * 
 * 世界上最真情的相依就是你在try我在catch.无论你发什么脾气，我都静静接受，默默处理，备胎精神
 * 当通过tryCATCH将异常处理了，程序会继续执行
 * @author 李闯
 *
 */
public class Demo2_Exception {

	public static void main(String[] args) {
		Demo2 demo2 = new Demo2();
		try {
			int x = demo2.div(10, 0);
			System.out.println(x);
		} catch (ArithmeticException a) {//ArithmeticException a = new ArithmeticException();
			System.out.println("出错了，除数为0了");
		}
		System.out.println("111111111111111111");//有了tryCatch可以继续执行
	}
}

class Demo2{
	
	/**
	 * 除法运算
	 */
	public int div(int a, int b) {
		return a/b;					//10/0被除数为10，除数为0，违背了数学运算法则，抛出异常
									//new ArithmeticException: / by zero
	}
}