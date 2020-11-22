package com.leeup.javase.day19.file;

import java.io.File;

/**
 * File类的重命名和删除功能
 * @author 李闯
 *
 */
public class Demo3_File {

	public static void main(String[] args) {
//		demo1();
		File file1 = new File("yyy.txt");
		System.out.println(file1.delete());
		
		File file2 = new File("aaa");
		System.out.println(file2.delete());
		
		File file3 = new File("ccc");		//如果删除一个文件夹，那么文件夹必须是空的
		System.out.println(file3.delete());
	}

	private static void demo1() {
		File file1 = new File("ooo.txt");
		File file2 = new File("D:\\xxx.txt");
		
		System.out.println(file1.renameTo(file2));
	}
}
