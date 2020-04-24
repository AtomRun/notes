# 网络编程

### 01. 网络编程概述(了解)
    1. 计算机网络
        * 是指将地理位置不同的具有独立功能的多台计算机及其外部设备，通过通信线路连接起来，在网络操作系统，网络管理软件及网络通信协议的管理和协调下，实现资源共享和信息传递的计算机系统。
    2. 网络编程
        * 就是用来实现网络互连的不同计算机上运行的程序间可以进行数据交换。


### 02. 网络编程三要素之IP概述(掌握)
    * 每个设备在网络中的唯一标识
    * 每台网络终端在网络中都有一个独立的地址，我们在网络中传输数据就是使用这个地址。 
    * ipconfig：查看本机IP192.168.12.42
    * ping：测试连接192.168.40.62
    * 本地回路地址：127.0.0.1 255.255.255.255是广播地址
    * IPv4：4个字节组成，4个0-255。大概42亿，30亿都在北美，亚洲4亿。2011年初已经用尽。 
    * IPv6：8组，每组4个16进制数。
    * 1a2b:0000:aaaa:0000:0000:0000:aabb:1f2f
    * 1a2b::aaaa:0000:0000:0000:aabb:1f2f
    * 1a2b:0000:aaaa::aabb:1f2f
    * 1a2b:0000:aaaa::0000:aabb:1f2f
    * 1a2b:0000:aaaa:0000::aabb:1f2f

### 03. 网络编程三要素之端口号概述(掌握)
    * 每个程序在设备上的唯一标识
    * 每个网络程序都需要绑定一个端口号，传输数据的时候除了确定发到哪台机器上，还要明确发到哪个程序。
    * 端口号范围从0-65535
    * 编写网络应用就需要绑定一个端口号，尽量使用1024以上的，1024以下的基本上都被系统程序占用了。
    * 常用端口
        * mysql: 3306
        * oracle: 1521
        * web: 80
        * tomcat: 8080
        * QQ: 4000
        * feiQ: 2425

### 04. 网络编程三要素协议(掌握)
    * 为计算机网络中进行数据交换而建立的规则、标准或约定的集合。
    * UDP
        * 面向无连接，数据不安全，速度快。不区分客户端与服务端。
    * TCP
    　　* 面向连接（三次握手），数据安全，速度略低。分为客户端和服务端。
       * 三次握手: 客户端先向服务端发起请求, 服务端响应请求, 传输数据


### 05. Socket通信原理图解(了解)
    1. Socket套接字概述：
        * 网络上具有唯一标识的IP地址和端口号组合在一起才能构成唯一能识别的标识符套接字。
        * 通信的两端都有Socket。
        * 网络通信其实就是Socket间的通信。
        * 数据在两个Socket间通过IO流传输。
        * Socket在应用程序中创建，通过一种绑定机制与驱动程序建立关系，告诉自己所对应的IP和port。

### 06. UDP传输(了解)
    1. 发送Send
        * 创建DatagramSocket, 随机端口号
        * 创建DatagramPacket, 指定数据, 长度, 地址, 端口
        * 使用DatagramSocket发送DatagramPacket
        * 关闭DatagramSocket
    2. 接收Receive
        * 创建DatagramSocket, 指定端口号
        * 创建DatagramPacket, 指定数组, 长度
        * 使用DatagramSocket接收DatagramPacket
        * 关闭DatagramSocket
        * 从DatagramPacket中获取数据
    3. 接收方获取ip和端口号
        * String ip = packet.getAddress().getHostAddress();
        * int port = packet.getPort();
```java
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
public class Demo1_Receive {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(6666);			//创建socket相当于创建码头
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);//相当于创建集装箱
		socket.receive(packet);
		
		
		byte[] arr = packet.getData();//获取数据，获取数据不是说将有效的获取出来，而是将1024都获取出来，但是
		//会有一些是空的，没存东西的
		int len = packet.getLength();//获取有效的字节个数
		System.out.println(new String(arr,0,len));
		socket.close();
	}
}

```

```java
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


```
### 07. UDP传输优化
    * 接收端Receive
    * 
            DatagramSocket socket = new DatagramSocket(6666);						//创建socket相当于创建码头
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);		//创建packet相当于创建集装箱
            
            while(true) {
                socket.receive(packet);												//接收货物
                byte[] arr = packet.getData();
                int len = packet.getLength();
                String ip = packet.getAddress().getHostAddress();
                System.out.println(ip + ":" + new String(arr,0,len));
            }
    * 发送端Send
    
            DatagramSocket socket = new DatagramSocket();		//创建socket相当于创建码头
            Scanner sc = new Scanner(System.in);
            
            while(true) {
                String str = sc.nextLine();
                if("quit".equals(str))
                    break;
                DatagramPacket packet = 							//创建packet相当于创建集装箱
                        new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
                socket.send(packet);			//发货
            }
            socket.close();
### 08. UDP传输多线程
* A发送和接收在一个窗口完成

		public class Demo3_MoreThread {

			/**
			 * @param args
			 */
			public static void main(String[] args) {
				new Receive().start();
				
				new Send().start();
			}
		
		}
	
		class Receive extends Thread {
			public void run() {
				try {
					DatagramSocket socket = new DatagramSocket(6666);					//创建socket相当于创建码头
					DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);	//创建packet相当于创建集装箱
					
					while(true) {
						socket.receive(packet);												//接收货物
						byte[] arr = packet.getData();
						int len = packet.getLength();
						String ip = packet.getAddress().getHostAddress();
						System.out.println(ip + ":" + new String(arr,0,len));
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
	
		class Send extends Thread {
			public void run() {
				try {
					DatagramSocket socket = new DatagramSocket();		//创建socket相当于创建码头
					Scanner sc = new Scanner(System.in);
					
					while(true) {
						String str = sc.nextLine();
						if("quit".equals(str))
							break;
						DatagramPacket packet = 							//创建packet相当于创建集装箱
								new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
						socket.send(packet);			//发货
					}
					socket.close();
				}  catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}

```java
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
```
### 09. UDP聊天图形化界面


### 10. UDP聊天发送功能


### 11. UDP聊天记录功能


### 12. UDP聊天清屏功能


### 13. UDP聊天震动功能


### 14. UDP聊天快捷键和代码优化	

### 15. UDP聊天生成jar文件

### 16. TCP协议(掌握)
* 1.客户端
	* 创建Socket连接服务端(指定ip地址,端口号)通过ip地址找对应的服务器
	* 调用Socket的getInputStream()和getOutputStream()方法获取和服务端相连的IO流
	* 输入流可以读取服务端输出流写出的数据
	* 输出流可以写出数据到服务端的输入流
* 2.服务端
	* 创建ServerSocket(需要指定端口号)
	* 调用ServerSocket的accept()方法接收一个客户端请求，得到一个Socket
	* 调用Socket的getInputStream()和getOutputStream()方法获取和客户端相连的IO流
	* 输入流可以读取客户端输出流写出的数据
	* 输出流可以写出数据到客户端的输入流
```java
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

```
```java
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
public class Demo2_Server {

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

```
### 17. TCP协议代码优化
* 客户端

		Socket socket = new Socket("127.0.0.1", 9999);		//创建Socket指定ip地址和端口号
		InputStream is = socket.getInputStream();			//获取输入流
		OutputStream os = socket.getOutputStream();			//获取输出流
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		PrintStream ps = new PrintStream(os);
		
		System.out.println(br.readLine());
		ps.println("我想报名就业班");
		System.out.println(br.readLine());
		ps.println("爷不学了");
		socket.close();
* 服务端

		ServerSocket server = new ServerSocket(9999);	//创建服务器
		Socket socket = server.accept();				//接受客户端的请求
		InputStream is = socket.getInputStream();		//获取输入流
		OutputStream os = socket.getOutputStream();		//获取输出流
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		PrintStream ps = new PrintStream(os);
		
		ps.println("欢迎咨询传智播客");
		System.out.println(br.readLine());
		ps.println("报满了,请报下一期吧");
		System.out.println(br.readLine());
		server.close();
		socket.close();

### 18. 服务端是多线程的(掌握)
	ServerSocket server = new ServerSocket(9999);	//创建服务器
		while(true) {
			final Socket socket = server.accept();				//接受客户端的请求
			new Thread() {
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						ps.println("欢迎咨询传智播客");
						System.out.println(br.readLine());
						ps.println("报满了,请报下一期吧");
						System.out.println(br.readLine());
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}

### 19. 练习
    * 客户端向服务器写字符串(键盘录入),服务器(多线程)将字符串反转后写回,客户端再次读取到是反转后的字符串  
```java
package com.leeup.javase.day26.test;
/**
 * 客户端向服务器写字符串(键盘录入),服务器(多线程)将字符串反转后写回,客户端再次读取到是反转后的字符串
 * @author 李闯
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Test1_Client {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		Socket socket = new Socket("127.0.0.1", 54321);		//创建客户端，指定IP地址和端口号
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));	//获取输入流
		PrintStream ps = new PrintStream(socket.getOutputStream());								//获取输出流
		
		ps.println(scanner.nextLine());				//将字符串写到服务器
		
		System.out.println(br.readLine());			//将反转后的结果读出来
		
		socket.close();
	}
}

```
```java
package com.leeup.javase.day26.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1_Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(54321);
		
		System.out.println("服务器启动，绑定54321端口");
		
		while (true) {
			Socket socket = server.accept();//接收客户端的请求
			
			new Thread() {					//开启一条线程
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));	//获取输入流
						PrintStream ps = new PrintStream(socket.getOutputStream());	//获取输出流
						
						String line = br.readLine();								//将客户端写过来的数据读取出来
						line = new StringBuilder(line).reverse().toString();		//链式编程将字符串先转成StringBuilder,然后反转，再转换为字符串
						ps.println(line);											//反转后写回去
						
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}								
				}
			}.start();;
		}
	}
}

```
### 20. 练习
    * 客户端向服务器上传文件
```java
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

```
```java
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

```
### 21_day26总结
* 把今天的知识点总结一遍。