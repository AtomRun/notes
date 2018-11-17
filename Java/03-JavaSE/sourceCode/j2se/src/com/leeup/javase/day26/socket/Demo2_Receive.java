package com.leeup.javase.day26.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * UDP传输
 * Receive接收
 * @author 李闯
 *
 */
public class Demo2_Receive {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(6666);			//创建socket相当于创建码头
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);//相当于创建集装箱
		while (true) {
			socket.receive(packet);
			byte[] arr = packet.getData();//获取数据，获取数据不是说将有效的获取出来，而是将1024都获取出来，但是
			//会有一些是空的，没存东西的
			int len = packet.getLength();//获取有效的字节个数
			String ip = packet.getAddress().getHostAddress();	//获取IP地址
			int port = packet.getPort();						//获取端口号
			System.out.println(ip+":"+port+":"+new String(arr,0,len));
			
		}
	}
}
