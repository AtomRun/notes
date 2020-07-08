package com.leeup.javase.day20.stream;
/**
 * 定义小数组
 * 第三种拷贝方式
 * @author 李闯
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4_ArrayCopy {
	
	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
//		demo3();
		
	}

	/**
	 * 拷贝的标准格式，使用小数去拷贝
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void demo3() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("743800.png");
		FileOutputStream fos = new FileOutputStream("copy743800.png");
		
		byte[] arr = new byte[1024 * 8];
		int len;
		while ((len = fis.read(arr))!=-1) {	//如果忘记加arr返回的就不是读取的字节个数，而是字节的码表值
			fos.write(arr,0,len);
		}
		fis.close();
		fos.close();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("xxx.txt");
		FileOutputStream fos = new FileOutputStream("yyy.txt");
		
		byte[] arr = new byte[2];
		int len;
		while ((len = fis.read(arr))!=-1) {
			fos.write(arr,0,len);
		}
		fis.close();
		fos.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("xxx.txt");
		byte[] arr = new byte[2];
		int a = fis.read(arr);	//将文件上的字节读取到字节数组中
		System.out.println(a);	//读到的有效的字节个数
		for (byte b : arr) {	//第一次获取到文件上的a,b
			System.out.println(b);
		}
		
		System.out.println("===============");
		
		int c = fis.read(arr);
		System.out.println(c);
		for (byte b : arr) {
			System.out.println(b);
		}
		fis.close();
	}
}
