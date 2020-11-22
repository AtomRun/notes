package com.leeup.javase.day21.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 将文本反转
 * @author 李闯
 *分析：
 *	1.创建输入输出流对象，一定是Buffer的，我们要整行读，需要readLine
 *  2. 创建集合对象，把数据进行临时存储，倒着遍历写出去
 *  3. 将读到的数据，存储在集合中
 *  4. 倒着遍历集合将数据写到文件上
 *  5. 关流
 *  
 *  注意事项：
 *  流对象尽量晚开早关
 */
public class Test1 {

	private void mian() throws IOException {
		//1 
		BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));
		
		//2 
		ArrayList<String> list = new ArrayList<>();
		//3
		String line;
		while ((line = br.readLine())!=null) {
			list.add(line);
		}
		//4
		BufferedWriter bw = new BufferedWriter(new FileWriter("revzzz.txt"));
		for (int i = list.size(); i >=0; i--) {
			bw.write(list.get(i));
			bw.newLine();
		}
		//5 
		br.close();
		bw.close();  
	}
}
