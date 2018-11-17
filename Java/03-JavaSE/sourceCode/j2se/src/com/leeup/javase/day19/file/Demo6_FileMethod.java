package com.leeup.javase.day19.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件名称过滤器的概述及使用
 * @author 李闯
 *
 */
public class Demo6_FileMethod {

	public static void main(String[] args) {
		File dir = new File("G:\\fileTest");
		String[] arr = dir.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
//				System.out.println(dir);	//上述路径
//				System.out.println(name);	//文件名字
				File file = new File(dir,name);
				
				return file.isFile() && file.getName().endsWith(".txt");
			}
		});
		for (String string : arr) {
			System.out.println(string);
		}
	}
}
