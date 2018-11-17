package com.leeup.javase.day22.otherio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 序列流(了解)
 * @author 李闯
 *
 */
public class Demo1_SequenceInputStream {

	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
		FileInputStream fis1 = new FileInputStream("a.txt");
		FileInputStream fis2 = new FileInputStream("b.txt");
		FileInputStream fis3 = new FileInputStream("c.txt");
		
		Vector<FileInputStream> v = new Vector<>();		//创建集合对象
		v.add(fis1);									//将流对象存储进来
		v.add(fis2);
		v.add(fis3);
		
		Enumeration<FileInputStream> en = v.elements();	
		SequenceInputStream sis = new SequenceInputStream(en);//将枚举中的输入流整合成一个
		FileOutputStream fos = new FileOutputStream("d.txt");
		int b;
		while ((b=sis.read())!=-1) {
			fos.write(b);
		}
		sis.close();
		fos.close();
	}


	private static void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis1 = new FileInputStream("a.txt");
		FileInputStream fis2 = new FileInputStream("b.txt");
		
		SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
		FileOutputStream fos = new FileOutputStream("c.txt");
		
		int b;
		while ((b = sis.read())!=-1) {
			fos.write(b);
		}
		sis.close();		//sis关闭的时候会将构造方法中传入的流对象都关闭
		fos.close();
	}

	
	/**
	 * 使用字节流方式
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis1 = new FileInputStream("a.txt");
		FileOutputStream fos = new FileOutputStream("c.txt");
		
		int b1;
		while ((b1 = fis1.read())!=-1) {
			fos.write(b1);
		}
		fis1.close();
		FileInputStream fis2 = new FileInputStream("b.txt");
		int b2;
		while ((b2 = fis2.read())!=-1) {
			fos.write(b2);
		}
		fis2.close();
		fos.close();
	}
}
