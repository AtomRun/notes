package com.leeup.javase.day19.exception;
/**
 * 自定义异常概述和基本使用
 * 之所以要有自定义异常，因为要看异常名字，但与快速识别问题
 * @author 李闯
 *
 */
public class Demo8_Exception {

}

class AgeOutOfBoundsException extends Exception {//继承RuntimeException就变成了运行时异常

	//重写构造
	public AgeOutOfBoundsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgeOutOfBoundsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}