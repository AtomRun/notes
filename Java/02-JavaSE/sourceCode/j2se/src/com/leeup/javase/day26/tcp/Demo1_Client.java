package com.leeup.javase.day26.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP协议(掌握)客户端
 * @author 李闯
 *
 */
public class Demo1_Client {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",12345);
		InputStream is = socket.getInputStream();	//获取客户端输入流
		OutputStream os = socket.getOutputStream();	//获取客户端输出流
		
		byte[] arr = new byte[1024];
		
		int len = is.read(arr);						//读取服务器发过来的数据
		
		System.out.println(new String(arr,0,len));	//将数据转换为字符串并打印
		
		os.write("学习挖掘机技术哪家强，中国山东找蓝翔".getBytes());	//客户端向服务器写数据
		
		socket.close(); 
		
	}
}
