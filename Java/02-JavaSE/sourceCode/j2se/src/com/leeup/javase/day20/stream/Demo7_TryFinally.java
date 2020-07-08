package com.leeup.javase.day20.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author 李闯
 *
 */
public class Demo7_TryFinally {

	public static void main(String[] args) throws IOException {
//		demo1();
		
		/**
		 * 1.7版本
		 * 
		 */
			try(
					//当流对象写在try的小括号中的时候，在执行大括号中的读写完成之后，会自动调用关闭的方法，
					//try小括号中只能写具有自动关闭的功能对象
					//InputStream继承了Closeable实现了AutoCloseable中有一个close方法
					//想要写自己的对象，必须实现AutoCloseable接口，重写close方法
					FileInputStream fis = new FileInputStream("xxx.txt");
					FileOutputStream fos = new FileOutputStream("yyy.txt");
					MyClose mc = new MyClose();
			){
				int b;
				while ((b = fis.read())!=-1) {
					fos.write(b);
				}
			}
			
	//		fis.close();
	//		fos.close();
	}

	/**
	 * 1.6
	 * @throws IOException
	 */
	private static void demo1() throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("xxx.txt");
			fos =  new FileOutputStream("yyy.txt");
			
			int b;
			while ((b = fis.read())!=-1) {
				fos.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if (fis!=null)
						fis.close();
				} finally {
					if (fos!=null)  
						fos.close();
				}
		}
	}
}


class MyClose implements AutoCloseable{
	public void close() {
		System.out.println("我关了");
	}
}