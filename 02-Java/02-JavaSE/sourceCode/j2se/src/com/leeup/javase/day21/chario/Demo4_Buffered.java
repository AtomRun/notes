package com.leeup.javase.day21.chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * readLine()和newLine()方法
 * @author 李闯
 * newLine与\r\n的区别
 * newLine是跨平台的方法
 * \r\n只支持windows
 *
 */
public class Demo4_Buffered {

	public static void main(String[] args) throws IOException {
//		demo1();
		BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("aaa.txt"));
		String line;
		while ((line = br.readLine())!=null) {
			bw.write(line);
//			bw.newLine();						//写出回车换行符、
			bw.write("\r\n");
			System.out.println(line);
		}
		br.close();
		bw.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
		String line;
		while ((line = br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
	}
}
