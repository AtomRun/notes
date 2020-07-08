package com.leeup.javase.day26.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端向服务器上传文件
 * @author 李闯
 *
 */
public class Test2_UpdateClient {

	public static void main(String[] args) throws IOException {
		File file = getFile();
		
		Socket socket = new Socket("127.0.0.1", 54321);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println(file.getName());
		
		String result = br.readLine();		//读取存在或者不存在的结果
		if ("存在".equals(result)) {
			System.out.println("您上传的文件已经存在，请不要重复上传");
			socket.close();
			return;
		}
		FileInputStream fis = new FileInputStream(file);		//使用字节流，因为文件类型不明确
		byte[] arr = new byte[8192];
		int len;
		while ((len = fis.read(arr)) != -1) {
//			ps.println(); 会将字节转换为字符串
			ps.write(arr,0,len);		//ps可以写字符串，也可以写字节
		}
		fis.close();
		socket.close();
	}

	private static File getFile() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个文件路径");
		while (true) {
			String line = scanner.nextLine();
			File file = new File(line);
			if (!file.exists()) {
				System.out.println("您录入的文件路径不存在，请重新录入");
			}else if (file.isDirectory()) {
				System.out.println("您录入的是文件夹路径，请输入一个文件路径");
			}else {
				return file;
			}
		}
	}
}
