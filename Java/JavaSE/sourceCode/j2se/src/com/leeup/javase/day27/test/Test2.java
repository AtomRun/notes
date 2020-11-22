package com.leeup.javase.day27.test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("xxx.properties"));		//创建输入流关联文件
		Class clazz = Class.forName(br.readLine());										//读取配置文件中的类名。获取字节码对象
		
		DemoClass dc = (DemoClass) clazz.newInstance();			//通过字节码对象创建对象
		dc.run();
		
	}
}
