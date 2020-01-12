package com.leeup.javase.day21.chario;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineNumberReader
 * @author 李闯
 *
 */
public class Demo5_LineNumberReader {

	public static void main(String[] args) throws IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader("zzz.txt"));
		
		String line;
		lnr.setLineNumber(100);
		while ((line = lnr.readLine())!=null) {
			System.out.println(lnr.getLineNumber()+line);
		}
		lnr.close();
	}
}
