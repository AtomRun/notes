package com.leeup.javase.day19.file;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * File类的获取功能
 * @author 李闯
 *
 */
public class Demo5_FileMethod {

	public static void main(String[] args) {
//		demo1();
		File dir =  new File("G:\\fileTest\\");
		String[] arr = dir.list();		//仅为了获取文件名
		for (String string : arr) {
			System.out.println(string);
		}
		
		File[] subFiles = dir.listFiles();
		for (File file : subFiles) {
			System.out.println(file);	//文件全路径。file重写了toString方法，文件对象
		}
	}

	private static void demo1() {
		File file1 = new File("ccc.txt");
//		System.out.println(file1.getAbsolutePath());	//获取绝对路径
		
		File file2 = new File("E:\\eclipseinst-workspace\\j2se\\ccc.txt");
//		System.out.println(file2.getAbsolutePath());	
//		System.out.println(file1.getPath());//获取构造方法中传入的路径
//		System.out.println(file2.getPath());
		
//		System.out.println(file1.getName());			//获取文件或者文件夹的内容
//		System.out.println(file2.getName());
//		System.out.println(file1.length());				//文件中字符长度
//		System.out.println(file1.lastModified());		//最后一次修改文件的毫秒数.文件的最后修改时间
		
		Date d = new Date(file1.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月 dd日 HH:mm:ss");
		System.out.println(sdf.format(d));
	}
}
