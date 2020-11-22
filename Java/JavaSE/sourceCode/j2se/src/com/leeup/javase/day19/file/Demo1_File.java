package com.leeup.javase.day19.file;

import java.io.File;

/**
 * File类的概述和构造方法
 * @author 李闯
 *
 */
public class Demo1_File {

	public static void main(String[] args) {
//		demo1();
//		demo2();
		
		//封装成file对象的好处，更容易对他进行操作
		File parent = new File("G:\\\\fileTest");
		String child = "fileTest.txt";
		File file = new File(parent,child);
		System.out.println(file.exists());
		System.out.println(parent.exists());
		
	}

	private static void demo2() {
		String parent = "G:\\fileTest";	//父级路径
		String child = "fileTest.txt";	//子级路径
		File file = new File(parent,child);
		System.out.println(file.exists());
	}

	private static void demo1() {
		File file = new File("G:\\fileTest\\fileTest.txt");
		System.out.println(file.exists());	//检测该路径下的文件是否存在
		
		File file2 = new File("xxx.txt");
		System.out.println(file2.exists());	//检测
		
		File file3 = new File("yyy.txt");
		System.out.println(file3.exists());
	}
}
