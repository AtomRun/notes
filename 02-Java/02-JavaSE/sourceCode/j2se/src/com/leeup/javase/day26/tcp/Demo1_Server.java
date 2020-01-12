package com.leeup.javase.day26.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议(掌握) 服务端
 * @author 李闯
 *
 */
public class Demo1_Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		
		Socket socket = server.accept();				//接收客户端请求，
		
		InputStream is = socket.getInputStream();	//获取客户端输入流
		OutputStream os = socket.getOutputStream();	//获取客户端输出流
		
		os.write("百度一下，你就知道".getBytes());		//服务器向客户端写出数据
		
		byte[] arr = new byte[1024];
		int len = is.read(arr);
		System.out.println(new String(arr,0,len));
	}
}
