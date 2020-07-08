package com.leeup.javase.day22.otherio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo10_Properties {

	public static void main(String[] args) throws IOException, IOException {
		Properties prop = new Properties();
		System.out.println("读取前"+prop);
		prop.load(new FileInputStream("config.properties"));
		
		prop.setProperty("tel","13020403405");
		
		prop.store(new FileOutputStream("config.properties"), "xxx");//xxx就是对列表的描述 ，如果不传可以传null
		System.out.println("读取后"+prop);
	}
}
