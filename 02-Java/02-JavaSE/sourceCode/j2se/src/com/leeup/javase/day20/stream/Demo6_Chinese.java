package com.leeup.javase.day20.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/***
 * 字节流读写中文
 * @author 李闯
 *
 */
public class Demo6_Chinese {

	public static void main(String[] args) throws IOException {
//		demo1(); 
		FileOutputStream fos = new FileOutputStream("zzz.txt");
		fos.write("我读书少，你别骗我".getBytes());
		fos.write("\r\n".getBytes());
		fos.close();
 	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("yyy.txt");
		byte[] arr = new byte[3];
		int len;
		while ((len = fis.read(arr))!=-1) {
			System.out.println(new String(arr,0,len));
		}
		fis.close();
	}
}
