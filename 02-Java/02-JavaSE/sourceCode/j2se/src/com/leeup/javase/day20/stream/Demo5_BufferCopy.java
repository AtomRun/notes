package com.leeup.javase.day20.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedInputStream和BufferOutputStream拷贝
 * @author 李闯
 *
 */
public class Demo5_BufferCopy {

	public static void main(String[] args) throws IOException {
//		demo1();
		
		/**
		 * flush和close方法的区别
		 * 不关流，拷贝的文件可能会比原文件小
		 * close方法
		 * 	具备刷新的方法，在关闭流之前，就会先刷新一次缓冲区，将缓冲区的字节全部都刷新到文件上，close之后不能继续写
		 * flush方法
		 * 	具备刷新的功能，刷完之后，可以继续写
		 */
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("743800.png"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy743800.png"));
		
		int b;
		while ((b = bis.read())!=-1) {
			bos.write(b);
		}
		bos.flush();
		
		bis.close();
		bos.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("743800.png");	//创建输入流对象，关联该文件
		FileOutputStream fos = new FileOutputStream("copy743800.png");	//创建输出流对象，关联拷贝出的文件
		
		BufferedInputStream bis = new BufferedInputStream(fis);	//创建缓冲区对象，对输入流进行包装将他变得更强大
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int b;
		while ((b = bis.read())!=-1) {
			bos.write(b);
		}
		bis.close();
		bos.close();
	}
}
