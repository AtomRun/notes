package com.leeup.javase.day19.exception;
/**
 * try...catch的方式处理异常2
 * 安卓，客户端开发，如何处理？try catch
 * eee 服务端开发，一般从底层开发，向上抛
 * try后面如果跟多个catch，那么小的异常放前面，大的异常往后放
 * 根据多态的原理，如果大的放前面，就会将所有的子类对象接收，后面的catch就没有意义了
 * @author 李闯
 *
 */
public class Demo3_Exception {

	public static void main(String[] args) {
//		demo1();
		
		int a =10;
		int b = 0;
		int [] arr = {11,22,33,44,55};
		
		//jdk7如何处理多个异常
		try {
			System.out.println(a/b);
			System.out.println(arr[10]);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {//即可以使用或的方式
			System.out.println("出错了");
		} 
	}

	private static void demo1() {
		int a =10;
		int b = 10;
		int [] arr = {11,22,33,44,55};
		
		try {
			arr = null;
			System.out.println(arr[10]);
		} catch (ArithmeticException e) {
			System.out.println("除数不能为0");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("索引越界了");
		} catch(Exception e) {		//Exception e = new NullPointerException();
			System.out.println("出错了");
		}
	}
}