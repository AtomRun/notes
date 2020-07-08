package com.leeup.javase.day23.test;

import java.io.File;
import java.util.Scanner;


/***
 * 从键盘接收一个文件夹路径，统计该文件夹大小
 * @author 李闯
 * 分析：
 * 从键盘接收一个文件夹路径
 * 	1. 创建键盘录入对象
 * 	2. 定义一个无限循环
 *  3. 将键盘录入的结果存储并封装成file对象
 *  4. 对file对象进行判断
 *  5. 将文件夹路径对象进行返回
 * 统计该文件夹大小
 * 	1. 定义一个求和变量
 *  2. 获取该文件夹下所有的文件和文件夹 listFiles();
 *  3. 遍历数组
 *  4. 判断是文件就计算大小并累加
 *  5. 判断是文件夹，递归调用
 *
 */
public class Test1 {

	public static void main(String[] args) {
//		File dir = getDir();
//		System.out.println(getFileLength(dir));		//直接获取文件夹的结果是0
		
		File dir1 = new File("E:\\Note\\notes\\Java");
		System.out.println(getFileLength(dir1));
	}
	
	/**
	 * 统计该文件夹大小
	 * 1. 返回值类型，Long
	 * 2. 参数列表 File dir
	 */ 
	public static long getFileLength(File dir) {
		//1 
		long len = 0;
		//2
		File[] subFiles = dir.listFiles();//获取该文件夹下的所有的文件和文件夹
		//3 
		for (File subfile : subFiles) {
			if (subfile.isFile()) {
				len = len + subfile.length();
			}else if (subfile.isDirectory()) {
				getFileLength(subfile);
			}
		}
		return len;
	}
	
	/**
	 * 从键盘接收一个文件夹路径
	 * 1. 返回值类型File
	 * 2. 参数列表无
	 */
	public static File getDir(){
		//1.  
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个文件夹路径");
		//2
		while (true) {
			//3
			String line = scanner.nextLine();
			File dir = new File(line);
			//4 
			if (!dir.exists()) {
				System.out.println("您录入的文件夹路径不存在，请输入一个正确的文件夹路径");
			} else if (dir.isFile()) {
				System.out.println("您输入的是一个文件路径，请输入一个文件夹路径");
			}else {
				//5
				return dir;
			}
		}
	}
}
