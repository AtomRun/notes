package com.leeup.javase.day26.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * TCP协议(掌握)客户端
 * @author 李闯
 *
 */
public class Demo2_Client {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",12345);
		
		/**
		 * 将字节流包装成了字符流
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		/**
		 * readLine是以\r\n为结束标记，所以以后写必须要加换行，但是BufferReder写完内容要调用newLine方法
		 * 但是PrintStream中有一个printLine方法，在写出的时候，可以直接加换行的
		 */
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		System.out.println(br.readLine());
		ps.println("我想好好学习");
		
		ps.println("加油");
		socket.close(); 
		
	}
}
