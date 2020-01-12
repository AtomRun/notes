package com.leeup.javase.day22.otherio;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 内存输出流*****(掌握)
 * @author 李闯
 *
 *FileInputStream 读取中文的时候，出现乱码，
 *解决方案：
 *	1. 字符流读取。
 *	2. ByteArrayOutputStream
 */
public class Demo2_ByteArrayOutPutStream {

	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("e.txt");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();	//在内存中创建了可以增长的内存数组
		int b;
		while ((b = fis.read())!= -1) {
			baos.write(b);											//将读取到的数据逐个写到内存中
		}
		byte[] arr = baos.toByteArray();		//将缓冲区的数据全部获取出来，并赋值给arr数组
		System.out.println(new String(arr));
		System.out.println(baos.toString()); 	//将缓冲区的内容准换字符串，在输出语句中可以省略调用toString方法
		fis.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("e.txt");
		byte[] arr = new byte[3];
		int len;
		while((len = fis.read(arr))!=-1) {
			System.out.println(new String(arr,0,len));
		}
		fis.close();
	}
}
