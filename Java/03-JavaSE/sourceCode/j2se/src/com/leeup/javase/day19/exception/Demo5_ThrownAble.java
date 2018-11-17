package com.leeup.javase.day19.exception;
/**
 * Throwable的几个常见方法
 * @author 李闯
 *
 */
public class Demo5_ThrownAble {

	public static void main(String[] args) {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			//走到catch中就相当于给e赋了个地址值，因为在上面1/0就创建了一个对象，除0异常对象，
			//这里即变成了：Exception e = new ArithmeticException("/ by Zero");
			System.out.println(e.getMessage());//获取异常信息。。返回字符串
			System.out.println(e.toString());//打印异常类名,异常信息，返回字符串，其实等于System.out.println(e);默认调用toString方法，打印异常类名和异常信息
			e.printStackTrace();				//打印异常类名,异常信息。包括异常出现的位置，JVM默认就用这种方式处理异常的
		}
	}
}
