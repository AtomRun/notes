package com.leeup.javase.day22.otherio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.leeup.javase.day22.bean.Person;

/**
 * 对象操作流ObjecOutputStream
 * @author 李闯
 *
 */
public class Demo3_ObjectOutPutStream {

	/**
	 * 序列化，将对象写到文件上
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Person p1 = new Person("张三",23);
		Person p2 = new Person("李四",24);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e.txt"));
		oos.writeObject(p1);
		oos.writeObject(p2);
		
		oos.close();
	}
}
