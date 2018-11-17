package com.leeup.javase.day26.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * UDP传输
 * Send发送
 * @author 李闯
 *
 */
public class Demo2_Send {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		DatagramSocket socket = new DatagramSocket();			//创建socket相当于创建码头
		
		while (true) {
			String line = sc.nextLine();
			if ("quit".equals(line)) {
				break;
			}
			DatagramPacket packet = new DatagramPacket(line.getBytes(), 
					line.getBytes().length,InetAddress.getByName("127.0.0.1"),6666);
			//创建Packet相当于集装箱
			socket.send(packet);//发货，即发往其他出去
		}
		
		socket.close(); 	//关闭socket，码头
	}
}

