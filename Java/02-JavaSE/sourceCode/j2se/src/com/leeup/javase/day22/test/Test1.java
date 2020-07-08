package com.leeup.javase.day22.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 内存输出流之黑马面试题(掌握)
* 定义一个文件输入流,调用read(byte[] b)方法
* ,将a.txt文件中的内容打印出来(byte数组大小限制为5)
 * @author 李闯
 *
 *分析：
 *	1. read(byte[] b)是字节输入流的方法，应创建FileInputStream,关联a.txt
 *  2. 创建内存输出流，将读到的数据写到内存输出流中
 *	3. 创建字节数组，长度为5
 *  4. 将内存输出流的数据全部转换为字符串打印
 *  5. 关闭输入流
 */
public class Test1 {

	public static void main(String[] args) throws IOException {
		//1
		FileInputStream fis = new FileInputStream("a.txt");
		//2
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//3
		byte[] arr = new byte[5];
		int len;
		while ((len = fis.read(arr))!=-1) {
			baos.write(arr,0,len);
		}
		//4
		System.out.println(baos);  			//系统底层默认帮我们调用toString方法
		
		//5 
		fis.close();
	}
}
