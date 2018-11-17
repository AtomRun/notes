package com.leeup.javase.day26.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo3_MoreThread {

	public static void main(String[] args) throws IOException {
		new Receive().start();
		
		new Send().start();
	}
}


class Receive extends Thread {
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(6666);
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
			} catch (IOException e) {
			e.printStackTrace();
			}
	}
}

class Send extends Thread {
	public void run() {
		try {
			Scanner sc = new Scanner(System.in);
			DatagramSocket socket = new DatagramSocket();
			
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
			}catch (IOException e) {
			e.printStackTrace();
		}
	}
}