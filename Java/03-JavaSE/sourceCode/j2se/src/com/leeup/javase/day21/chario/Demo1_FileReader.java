package com.leeup.javase.day21.chario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符流FileReader
 * @author 李闯
 *
 */
public class Demo1_FileReader {

	public static void main(String[] args) throws IOException {
		
//		demo1();
		FileReader fr = new FileReader("xxx.txt");
		int c;
		while((c = fr.read())!=-1) {		//通过项目默认的码表，一次读取一个字符
			System.out.print((char)(c));
		}
		fr.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		//基本版
		FileReader fr = new FileReader("xxx.txt");
		int x = fr.read();
		System.out.println(x);
		char c = (char) x;
		System.out.println(c);
		fr.close();
	}
}
