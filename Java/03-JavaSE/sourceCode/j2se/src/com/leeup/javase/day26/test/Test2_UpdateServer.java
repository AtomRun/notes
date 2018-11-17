package com.leeup.javase.day26.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Test2_UpdateServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(54321);
		System.out.println("服务器启动，绑定"+server.getLocalSocketAddress()+"端口号");
		while (true) {
			Socket socket = server.accept();
			new Thread() {
				public void run() {
					try {
						InputStream is = socket.getInputStream();
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						String fileName = br.readLine();
						
						File dir = new File("update");
						dir.mkdir();					//创建文件夹
						File file = new File(dir,fileName);	//封装成file对象，好处就是可以做判断了
						if (file.exists()) {				//如果服务器已经存在这个文件
							ps.println("存在");				//将存在写给客户端
							socket.close();
							return;
						} else {
							ps.println("不存在");
						}
						
						FileOutputStream fos = new FileOutputStream(file);
						byte[] arr = new byte[8192];
						int len;
						while ((len = is.read()) != -1) {
							fos.write(arr, 0, len);
						}
						fos.close();
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
	
}
