package com.leeup.javase.day21.test;

import java.io.File;
import java.util.Scanner;

/**
 * 需求:从键盘输入接收一个文件夹路径,打印出该文件夹下所有的.java文件名
 * @author 李闯
 * 分析：
 * 	1. 从键盘接收一个文件夹路径
 * 		如果录入的是不存在的，给与提示
 * 		如果是文件路径，给予提示
 * 		如果是文件夹路径，给予提示
 *  2. 打印出该文件夹下所有的.java文件名
 *  	获取到该文件夹路径下的所有的文件和文件夹，存储在File数组中
 *  	遍历数组，对每一个文件或者文件夹做判断，如果是文件并且后缀是.java的，就打印
 *  	如果是文件夹，就递归调用
 *  	
 */
public class Test5 {

	public static void main(String[] args) {
		File dir = getDir();
		printJavaFile(dir);
	}
	/**
	 * 获取键盘录入的文件夹路径
	 * 1. 返回值类型是File
	 * 2. 不需要有参数
	 */
	public static File getDir() {
		Scanner sc = new Scanner(System.in);		//创建键盘录入对象
		System.out.println("请输入一个文件夹路径");
		while (true) {
			String line = sc.nextLine();		//将键盘录入的文件夹路径存储
			File dir = new File(line);			//封装成file对象
			if (!dir.exists()) {
				System.out.println("您录入的文件夹路径不存在，请重新录入！");
			} else if (dir.isFile()) {
				System.out.println("您录入的是文件路径，请重新录入文件夹路径");
			} else{
				return dir;
			}
		}
		/**
		 * 获取文件夹路径下的所有.java文件
		 * 1. 返回值类型 void
		 * 2. 参数列表File dir
		 */
	}
	public static void printJavaFile(File dir) {
		File[] subFiles = dir.listFiles();
		for (File file : subFiles) {
			if (file.isFile() && file.getName().endsWith(".java")) {
				System.out.println(file);
			}else if (file.isDirectory()) {
				printJavaFile(file);
			}
		}
	}
}
