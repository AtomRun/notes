package com.leeup.javase.day20.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream
 * @author 李闯
 *
 */
public class Demo2_FileOutPutStream {

	public static void main(String[] args) throws IOException {
		demo1();
		FileOutputStream fos = new FileOutputStream("yyy.txt",true);	//加了true不会删除文件原始内容了
		fos.write(97);
		fos.write(98);
		
		fos.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		//fis在创建对象的时候是如果没有这个文件会帮我们创建出来，如果有这个文件就会先将文件清空，
		FileOutputStream fos = new FileOutputStream("yyy.txt");	//创建字节输出流对象，如果没有就自动创建一个
//		fos.write(97);		//虽然写出的是一个int数，但是到文件上的是一个字节会自动去除前三个八位
//		fos.write(98);
//		fos.write(99);
		fos.write(100);
		fos.close();
	}
}
