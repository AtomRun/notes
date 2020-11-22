package com.leeup.javase.day26.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议(掌握) 服务端
 * @author 李闯
 *
 */
public class Demo2_Server {

	public static void main(String[] args) throws IOException {
//		demo1();
		
		ServerSocket server = new ServerSocket(12345);
		
		while (true) {
			new Thread() {
				public void run() {
					try {
						Socket socket = server.accept();				//接收客户端请求，
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						ps.println("欢迎咨询好好学习俱乐部");
						System.out.println(br.readLine());
						ps.println("哈哈哈哈哈哈哈");
						System.out.println(br.readLine());
						
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();;
		}
	}

	private static void demo1() throws IOException {
		ServerSocket server = new ServerSocket(12345);
		
		Socket socket = server.accept();				//接收客户端请求，
		/**
		 * 将字节流包装成了字符流
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		/**
		 * readLine是以\r\n为结束标记，所以以后写必须要加换行，但是BufferReder写完内容要调用newLine方法
		 * 但是PrintStream中有一个printLine方法，在写出的时候，可以直接加换行的
		 */
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		ps.println("欢迎咨询好好学习俱乐部");
		System.out.println(br.readLine());
		ps.println("哈哈哈哈哈哈哈");
		System.out.println(br.readLine());
		
		socket.close();
	}
}
