package com.leeup.javase.day21.chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流的拷贝
 * @author 李闯
 *
 */
public class Demo3_Copy {

	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
		
//		demo3();	
		BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("yyy.txt"));
		
		int c; 
		while ((c =br.read())!=-1) {
			bw.write(c);
		}
		br.close();
		bw.close();
	}

	private static void demo3() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("xxx.txt");
		FileWriter fw = new FileWriter("yyy.txt");
		
		char[] arr = new char[1024*8];
		int len;
		while ((len=fr.read(arr))!=-1) {		//将文件数据读取到字符数组中
			fw.write(arr,0,len);				//将字符数组中的数据写到文件上
		}
		fr.close();
		fw.close();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("xxx.txt");
		FileWriter fw = new FileWriter("zzz.txt");
		
		int c;
		while ((c = fr.read())!=-1) {
			fw.write(c);
		}
		
		fr.close();
		fw.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("743800.png");
		FileWriter fw = new FileWriter("copy743800.png");
		
		int c;
		while ((c = fr.read())!=-1) {
			fw.write(c);
		}
		
		fr.close();
		fw.close();		//writer类中有一个两K的小缓冲区，如果不关流，就会将内容写到缓冲区中，关流。会将缓冲区中的内容写出，即刷新出来再关闭
	}

}
