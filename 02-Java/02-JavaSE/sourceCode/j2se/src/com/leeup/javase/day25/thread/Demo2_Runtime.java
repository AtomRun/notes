package com.leeup.javase.day25.thread;

import java.io.IOException;

/**
 * Runtime类
 * @author 李闯
 *
 */
public class Demo2_Runtime {

	public static void main(String[] args) throws IOException {
		Runtime r = Runtime.getRuntime();			//获取运行时对象
		r.exec("shutdown -s -t 300");				//修改过的
		
		r.exec("showdown -a");						//修改修改后的结果，即单例模式
	}
}
