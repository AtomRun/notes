package com.leeup.javase.day26.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP传输
 * Send发送
 * @author 李闯
 *
 */
public class Demo1_Send {

	public static void main(String[] args) throws IOException {
		String str = "what are you 弄啥类?";
		
		DatagramSocket socket = new DatagramSocket();			//创建socket相当于创建码头
		DatagramPacket packet = new DatagramPacket(str.getBytes(), 
				str.getBytes().length,InetAddress.getByName("127.0.0.1"),6666);
		//创建Packet相当于集装箱
		socket.send(packet);//发货，即发往其他出去
		
		socket.close(); 	//关闭socket，码头
	}
}

