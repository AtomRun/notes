package com.leeup.javase.day20.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片加密
 * @author 李闯
 *
 */
public class Test1 {

	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("743800.png"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy743800.png"));
		
		int b;
		while ((b = bis.read()) !=-1) {
			bos.write(b ^ 123); //一个数字异或两次就是自己本身，所以异或的数就相当于密码一样，当
		}
		bis.close();
		bos.close();
	}
}
