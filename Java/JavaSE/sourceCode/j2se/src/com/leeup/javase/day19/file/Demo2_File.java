package com.leeup.javase.day19.file;

import java.io.File;
import java.io.IOException;

/**
 * File类的创建功能
 * @author 李闯
 *
 */
public class Demo2_File {

	public static void main(String[] args) throws IOException {
//		demo1();
		File dir1 = new File("aaa");
		System.out.println(dir1.mkdir());
		
		File dir2 = new File("bbb.txt");		//文件夹也是有后缀的
		System.out.println(dir2.mkdir());
		
		File dir3 = new File("ccc\\ddd");
		System.out.println(dir3.mkdirs());		//mkdirs创建多级目录
	}

	private static void demo1() throws IOException {
		File file = new File("yyy.txt");//在当前目录[eclipse目录]如果没有就创建名字为yyy.txt的文件返回true，有就不创建返回false
		System.out.println(file.createNewFile());
		
		File file2 = new File("zzz");
		System.out.println(file2.createNewFile());
	}
}
