package com.leeup.javase.day19.test;

import java.io.File;

/**
 * 输出指定目录下指定后缀的文件名
 * @author 李闯
 *
 */
public class Test3 {

	public static void main(String[] args) {
		File dir = new File("G:\\fileTest");
		
//		String[] arr = dir.list();//获取这个路径下的所有文件或者文件夹
//		for (String string : arr) {	
//			//拿到了该路径下所有文件/文件夹的名字
//			if (string.endsWith(".txt")) {
//				System.out.println(string);
//			}
//		}
		File[] subFiles = dir.listFiles();	//拿到该路径下所有的文件/文件夹对象
		
		for (File subFile : subFiles) {
			if (subFile.isFile() && subFile.getName().endsWith(".txt")) {
				System.out.println(subFile);
			}
		}
	}
}
