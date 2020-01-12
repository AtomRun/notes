package com.leeup.javase.day21.chario;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流FileWriter
 * @author 李闯
 *
 */
public class Demo2_FileWriter {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("yyy.txt");
		fw.write("大家好，吃饭了吗？");
		
		fw.close();
	}
}
