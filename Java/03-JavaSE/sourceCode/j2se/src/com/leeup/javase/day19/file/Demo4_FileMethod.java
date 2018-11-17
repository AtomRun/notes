package com.leeup.javase.day19.file;

import java.io.File;

/**
 * File类的判断功能
 * @author 李闯
 *
 */
public class Demo4_FileMethod {

	public static void main(String[] args) {
//		demo1();
		
		//设置是否可读
		File file = new File("zzz");			
		file.setReadable(false);
		System.out.println(file.canRead());		//windows系统认为所有的文件都是可读的，这里的读是使用io读
		file.setWritable(true);
		System.out.println(file.canWrite());	//windows可以设置为不可写
		
		File file2 = new File("aaa.txt");
		System.out.println(file2.isHidden());
	}

	private static void demo1() {
		File dir1 = new File("ccc");
		System.out.println(dir1.isDirectory());	//判断是否是文件夹
		
		
		File dir2 = new File("zzz");
		System.out.println(dir2.isDirectory());
		
		System.out.println(dir1.isFile());		//判断是否是文件
		System.out.println(dir2.isFile());
	}
}
