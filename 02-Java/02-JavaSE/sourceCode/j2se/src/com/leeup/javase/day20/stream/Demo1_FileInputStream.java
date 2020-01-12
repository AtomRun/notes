package com.leeup.javase.day20.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream
 * @author 李闯
 *
 */
public class Demo1_FileInputStream {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
//		demo1();
		
		FileInputStream fis = new FileInputStream("xxx.txt");
		int b;
		while ((b=fis.read())!=-1) {
			System.out.println(b);
		}
		fis.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("xxx.txt"); //创建流对象，即开启流
		int x = fis.read();				//从硬盘上，读取1个字节
		System.out.println(x);			//关流释放资源
		
		int y = fis.read();
		System.out.println(y);
		
		int z = fis.read();
		System.out.println(z);
		
		int a = fis.read();
		System.out.println(a);//第四个字符不存在输出结果为-1，即文件结束的标记为-1。好处就是，我们在读的时候只要不是-1就可以不断的读，可以作为循环的结束条件
		
		int b = fis.read();
		System.out.println(b);//第五个字符不存在输出结果为-1
		fis.close();
	}
}
