package com.leeup.javase.day19.exception;
/**
 * 异常的概述和分类
 * @author 李闯
 *
 */
public class Demo1_Exception {

	public static void main(String[] args) {
//		demo1();
		
		Demo demo = new Demo();
		//除数不能为0 java.lang.ArithmeticException: / by zero
		int x = demo.div(10, 0);
		System.out.println(x);
	}

	private static void demo1() {
		int [] arr = {11,22,33,44,55};
//		arr = null;
		System.out.println(arr[10]);//索引越界异常
	}
}


class Demo{
	
	/**
	 * 除法运算
	 */
	public int div(int a, int b) {
		return a/b;					//10/0被除数为10，除数为0，违背了数学运算法则，抛出异常
									//new ArithmeticException: / by zero
	}
}