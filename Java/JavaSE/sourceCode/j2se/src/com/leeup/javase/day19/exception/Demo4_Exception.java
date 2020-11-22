package com.leeup.javase.day19.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 编译期异常和运行期异常的区别
 * @author 李闯
 *
 */
public class Demo4_Exception {

	public static void main(String[] args) {
		//编译时异常，也被叫做未雨绸缪异常，即对可能出现的异常做预防准备
		try {
			//如果不处理，编译就不会通过，就是所谓编译期异常，
			//所谓未雨绸缪：在做某些事情的时候要做某些准备
			//编译时异常：在编译某个程序的时候，有可能就会有各种事情发生，比如文件找不到，这样的异常就必须在编译的时候处理
			//如果不处理，编译通不过
			
			
			//运行时异常不处理。也可以编译，但是在运行时会出现异常
			//即程序员犯得错误，需要回来修改代码
			FileInputStream fis = new FileInputStream("xxx.txt");//硬盘这个文件可能是不存在的，有这种可能，所以我们先处理
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
