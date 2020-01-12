package com.leeup.javase.day22.otherio;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机访问流概述和读写数据(了解)
 * @author 李闯
 *
 */
public class Demo8_RandomAccessFile {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("g.txt", "rw");
		int x = raf.read();
		System.out.println(x);
		
		raf.seek(10);			//在指定位置设置指针
		raf.write(98);
		raf.close();
	}
}
