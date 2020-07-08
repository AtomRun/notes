package com.leeup.javase.day20.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 拷贝图片
 * @author 李闯
 *
 */
public class Demo3_Copy {

	public static void main(String[] args) throws IOException {
		
//		demo1();
		
		
//		demo2();
		
		//第二种拷贝
		/**
		 * 开发中并不推荐使用
		 * 因为，如果拷贝的文件很大的情况下，还要创建等量大小的数组，
		 * 可能会导致内存溢出
		 */
		FileInputStream fis = new FileInputStream("743800.png");		
		FileOutputStream fos = new FileOutputStream("copy743800.png");
		
//		int len = fis.available();
//		System.out.println(len);
		
		byte[] arr = new byte[fis.available()];	//创建和文件大小一样的字节数组
		fis.read(arr);		//将文件上的字节读取到内存当中
		fos.write(arr);		//将字节数组中的字节数据写到文件上
		
		fis.close();
		fos.close();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		/**
		 * 当拷贝内容比较大的时候，比较耗费时间，因为读取文件需要一个字节一个字节的读取，次数太多，
		 * 而写文件同样需要相应的次数，即一个字节一个字节写
		 */
		FileInputStream fis = new FileInputStream("743800.png");		
		FileOutputStream fos = new FileOutputStream("copy743800.png");
		
		int b;
		while ((b  = fis.read()) != -1) {		
			fos.write(b);					
		}
		fis.close();							
		fos.close();
	}

	//第一种拷贝
	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("1.jpg");		//创建输入流对象,关联1.jpg
		FileOutputStream fos = new FileOutputStream("copy.jpg");//创建输出流对象，关联copy.jpg
		
		int b;
		while ((b  = fis.read()) != -1) {		//不断的读取每个字节，
			fos.write(b);						//将每个字节写出
		}
		fis.close();							//关流释放资源
		fos.close();
	}
}
