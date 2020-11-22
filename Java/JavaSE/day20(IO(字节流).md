### 01. IO流概述及其分类
    1. 概念
        * IO流用来处理设备之间的数据传输
        * Java对数据的操作是通过流的方式
        * Java用于操作流的类都在IO包中
        * 流按流向分为两种：输入流，输出流。
        * 流按操作类型分为两种：
            * 字节流 : 字节流可以操作任何数据,因为在计算机中任何数据都是以字节的形式存储的
            * 字符流 : 字符流只能操作纯字符数据，比较方便。
    2 .IO流常用父类
        * 字节流的抽象父类：
            * InputStream 
            * OutputStream
        * 字符流的抽象父类：
            * Reader 
            * Writer		
    3 .IO程序书写
        * 使用前，导入IO包中的类
        * 使用时，进行IO异常处理
        * 使用后，释放资源

### 02. FileInputStream
    1. read()一次读取一个字节
    
            FileInputStream fis = new FileInputStream("aaa.txt");	//创建一个文件输入流对象,并关联aaa.txt
            int b;													//定义变量,记录每次读到的字节
            while((b = fis.read()) != -1) {							//将每次读到的字节赋值给b并判断是否是-1
                System.out.println(b);								//打印每一个字节
            }
            
            fis.close();											//关闭流释放资源
```java
package com.leeup.javase.day20.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream
 * @author 李闯
 *
 */
public class Demo1_FileInputStream {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
//		demo1();
		
		FileInputStream fis = new FileInputStream("xxx.txt");
		int b;
		while ((b=fis.read())!=-1) {
			System.out.println(b);
		}
		fis.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("xxx.txt"); //创建流对象，即开启流
		int x = fis.read();				//从硬盘上，读取1个字节
		System.out.println(x);			//关流释放资源
		
		int y = fis.read();
		System.out.println(y);
		
		int z = fis.read();
		System.out.println(z);
		
		int a = fis.read();
		System.out.println(a);//第四个字符不存在输出结果为-1，即文件结束的标记为-1。好处就是，我们在读的时候只要不是-1就可以不断的读，可以作为循环的结束条件
		
		int b = fis.read();
		System.out.println(b);//第五个字符不存在输出结果为-1
		fis.close();
	}
}

```
### 03. read()方法返回值为什么是int
    1. read()方法读取的是一个字节,为什么返回是int,而不是byte
    
            因为字节输入流可以操作任意类型的文件,比如图片音频等,这些文件底层都是以二进制形式的存储的,如果每次读取都返回byte,有可能在读到中间的时候遇到111111111
            那么这11111111是byte类型的-1,我们的程序是遇到-1就会停止不读了,后面的数据就读不到了,所以在读取的时候用int类型接收,如果11111111会在其前面补上
            24个0凑足4个字节,那么byte类型的-1就变成int类型的255了这样可以保证整个数据读完,而结束标记的-1就是int类型

### 04. FileOutputStream
    1. write()一次写出一个字节
    
            FileOutputStream fos = new FileOutputStream("bbb.txt");	//如果没有bbb.txt,会创建出一个
            //fos.write(97);						//虽然写出的是一个int数,但是在写出的时候会将前面的24个0去掉,所以写出的是一个byte
            fos.write(98);
            fos.write(99);
            fos.close();
```java
package com.leeup.javase.day20.stream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream
 * @author 李闯
 *
 */
public class Demo2_FileOutPutStream {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("yyy.txt");	//创建字节输出流对象，如果没有就自动创建一个
		fos.write(97);		//虽然写出的是一个int数，但是到文件上的是一个字节会自动去除前三个八位
		fos.write(98);
		fos.write(99);
		
		fos.close();
	}
}

```
### 05. FileOutputStream追加
    1. 案例演示
          FileOutputStream的构造方法写出数据如何实现数据的追加写入
     
            FileOutputStream fos = new FileOutputStream("bbb.txt",true);	//如果没有bbb.txt,会创建出一个
            //fos.write(97);						//虽然写出的是一个int数,但是在写出的时候会将前面的24个0去掉,所以写出的一个byte
            fos.write(98);
            fos.write(99);
            fos.close();

### 06. 拷贝图片
* FileInputStream读取
* FileOutputStream写出

		FileInputStream fis = new FileInputStream("致青春.mp3");	//创建输入流对象,关联致青春.mp3
		FileOutputStream fos = new FileOutputStream("copy.mp3");//创建输出流对象,关联copy.mp3
		
		int b;
		while((b = fis.read()) != -1) {
			fos.write(b);
		}
		
		fis.close();
		fos.close();
```java
package com.leeup.javase.day20.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 拷贝图片
 * @author 李闯
 *
 */
public class Demo3_Copy {

	public static void main(String[] args) throws IOException {
//		demo1();
		
		
		/**
		 * 当拷贝内容比较大的时候，比较耗费时间，因为读取文件需要一个字节一个字节的读取，次数太多，
		 * 而写文件同样需要相应的次数，即一个字节一个字节写
		 */
		FileInputStream fis = new FileInputStream("743800.png");		
		FileOutputStream fos = new FileOutputStream("copy743800.png");
		
		int b;
		while ((b  = fis.read()) != -1) {		
			fos.write(b);					
		}
		fis.close();							
		fos.close();
		
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("1.jpg");		//创建输入流对象,关联1.jpg
		FileOutputStream fos = new FileOutputStream("copy.jpg");//创建输出流对象，关联copy.jpg
		
		int b;
		while ((b  = fis.read()) != -1) {		//不断的读取每个字节，
			fos.write(b);						//将每个字节写出
		}
		fis.close();							//关流释放资源
		fos.close();
	}
}
```

### 07. 拷贝音频文件画原理图
    1. 案例演示
        * 字节流一次读写一个字节复制音频
    * 弊端:效率太低
![拷贝音频文件画原理图](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E6%8B%B7%E8%B4%9D%E9%9F%B3%E9%A2%91%E6%96%87%E4%BB%B6%E7%94%BB%E5%8E%9F%E7%90%86%E5%9B%BE.png)

### 08. 字节数组拷贝之available()方法
    1. 案例演示
        * int read(byte[] b):一次读取一个字节数组
        * write(byte[] b):一次写出一个字节数组
        * available()获取读的文件所有的字节个数
    * 弊端:有可能会内存溢出 
        
            FileInputStream fis = new FileInputStream("致青春.mp3");
            FileOutputStream fos = new FileOutputStream("copy.mp3");
            byte[] arr = new byte[fis.available()];					//根据文件大小做一个字节数组
            fis.read(arr);											//将文件上的所有字节读取到数组中
            fos.write(arr);											//将数组中的所有字节一次写到了文件上
            fis.close();
            fos.close();
```java
package com.leeup.javase.day20.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 拷贝图片
 * @author 李闯
 *
 */
public class Demo3_Copy {

	public static void main(String[] args) throws IOException {
		//第一种拷贝
//		demo1();
		
		
//		demo2();
		
		//第二种拷贝
		/**
		 * 开发中并不推荐使用
		 * 因为，如果拷贝的文件很大的情况下，还要创建等量大小的数组，
		 * 可能会导致内存溢出
		 */
		FileInputStream fis = new FileInputStream("743800.png");		
		FileOutputStream fos = new FileOutputStream("copy743800.png");
		
//		int len = fis.available();
//		System.out.println(len);
		
		byte[] arr = new byte[fis.available()];	//创建和文件大小一样的字节数组
		fis.read(arr);		//将文件上的字节读取到内存当中
		fos.write(arr);		//将字节数组中的字节数据写到文件上
		
		fis.close();
		fos.close();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		/**
		 * 当拷贝内容比较大的时候，比较耗费时间，因为读取文件需要一个字节一个字节的读取，次数太多，
		 * 而写文件同样需要相应的次数，即一个字节一个字节写
		 */
		FileInputStream fis = new FileInputStream("743800.png");		
		FileOutputStream fos = new FileOutputStream("copy743800.png");
		
		int b;
		while ((b  = fis.read()) != -1) {		
			fos.write(b);					
		}
		fis.close();							
		fos.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("1.jpg");		//创建输入流对象,关联1.jpg
		FileOutputStream fos = new FileOutputStream("copy.jpg");//创建输出流对象，关联copy.jpg
		
		int b;
		while ((b  = fis.read()) != -1) {		//不断的读取每个字节，
			fos.write(b);						//将每个字节写出
		}
		fis.close();							//关流释放资源
		fos.close();
	}
}

```
### 09. 定义小数组
    * write(byte[] b)
    * write(byte[] b, int off, int len)写出有效的字节个数
```java
package com.leeup.javase.day20.stream;
/**
 * 定义小数组
 * 第三种拷贝方式
 * @author 李闯
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4_ArrayCopy {
	
	public static void main(String[] args) throws IOException {
//		demo1();
		FileInputStream fis = new FileInputStream("xxx.txt");
		FileOutputStream fos = new FileOutputStream("yyy.txt");
		
		byte[] arr = new byte[2];
		int len;
		while ((len = fis.read(arr))!=-1) {
			fos.write(arr,0,len);
		}
		fis.close();
		fos.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("xxx.txt");
		byte[] arr = new byte[2];
		int a = fis.read(arr);	//将文件上的字节读取到字节数组中
		System.out.println(a);	//读到的有效的字节个数
		for (byte b : arr) {	//第一次获取到文件上的a,b
			System.out.println(b);
		}
		
		System.out.println("===============");
		
		int c = fis.read(arr);
		System.out.println(c);
		for (byte b : arr) {
			System.out.println(b);
		}
		fis.close();
	}
}

```

### 10. 定义小数组的标准格式
    1. 案例演示
        * 字节流一次读写一个字节数组复制图片和视频
            FileInputStream fis = new FileInputStream("致青春.mp3");
            FileOutputStream fos = new FileOutputStream("copy.mp3");
            int len;
            byte[] arr = new byte[1024 * 8];					//自定义字节数组
            
            while((len = fis.read(arr)) != -1) {
                //fos.write(arr);
                fos.write(arr, 0, len);							//写出字节数组写出有效个字节个数
            }
            
            fis.close();
            fos.close();
```java
	/**
	 * 拷贝的标准格式，使用小数去拷贝
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void demo3() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("743800.png");
		FileOutputStream fos = new FileOutputStream("copy743800.png");
		
		byte[] arr = new byte[1024 * 8];
		int len;
		while ((len = fis.read(arr))!=-1) {	//如果忘记加arr返回的就不是读取的字节个数，而是字节的码表值
			fos.write(arr,0,len);
		}
		fis.close();
		fos.close();
	}
```
### 11. BufferedInputStream和BufferOutputStream拷贝
    1. 缓冲思想
        * 字节流一次读写一个数组的速度明显比一次读写一个字节的速度快很多，
        * 这是加入了数组这样的缓冲区效果，java本身在设计的时候，
        * 也考虑到了这样的设计思想(装饰设计模式后面讲解)，所以提供了字节缓冲区流
    2. BufferedInputStream
        * BufferedInputStream内置了一个缓冲区(数组)
        * 从BufferedInputStream中读取一个字节时
        * BufferedInputStream会一次性从文件中读取8192个, 存在缓冲区中, 返回给程序一个
        * 程序再次读取时, 就不用找文件了, 直接从缓冲区中获取
        * 直到缓冲区中所有的都被使用过, 才重新从文件中读取8192个
    3. BufferedOutputStream
        * BufferedOutputStream也内置了一个缓冲区(数组)
        * 程序向流中写出字节时, 不会直接写到文件, 先写到缓冲区中
        * 直到缓冲区写满, BufferedOutputStream才会把缓冲区中的数据一次性写到文件里
    4. 拷贝的代码 
    
            FileInputStream fis = new FileInputStream("致青春.mp3");			//创建文件输入流对象,关联致青春.mp3
            BufferedInputStream bis = new BufferedInputStream(fis);			//创建缓冲区对fis装饰
            FileOutputStream fos = new FileOutputStream("copy.mp3");		//创建输出流对象,关联copy.mp3
            BufferedOutputStream bos = new BufferedOutputStream(fos);		//创建缓冲区对fos装饰
            
            int b;
            while((b = bis.read()) != -1) {		
                bos.write(b);
            }
            
            bis.close();						//只关装饰后的对象即可
            bos.close();
        
    5. 小数组的读写和带Buffered的读取哪个更快?
        * 定义小数组如果是8192个字节大小和Buffered比较的话
        * 定义小数组会略胜一筹,因为读和写操作的是同一个数组
        * 而Buffered操作的是两个数组
```java
package com.leeup.javase.day20.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedInputStream和BufferOutputStream拷贝
 * @author 李闯
 *
 */
public class BufferCopy {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("743800.png");	//创建输入流对象，关联该文件
		FileOutputStream fos = new FileOutputStream("copy743800.png");	//创建输出流对象，关联拷贝出的文件
		
		BufferedInputStream bis = new BufferedInputStream(fis);	//创建缓冲区对象，对输入流进行包装将他变得更强大
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int b;
		while ((b = bis.read())!=-1) {
			bos.write(b);
		}
		bis.close();
		bos.close();
	}
}

```
![BufferedInputStream和BufferOutputStream拷贝](https://github.com/AtomRun/notes/blob/master/00-noteimages/BufferedInputStream%E5%92%8CBufferOutputStream%E6%8B%B7%E8%B4%9D.png)

### 12. flush和close方法的区别
    * flush()方法
        * 用来刷新缓冲区的,刷新后可以再次写出 
    * close()方法
        * 用来关闭流释放资源的的,如果是带缓冲区的流对象的close()方法,不但会关闭流,还会再关闭流之前刷新缓冲区,关闭后不能再写出 
```java
		/**
		 * flush和close方法的区别
		 * 不关流，拷贝的文件可能会比原文件小
		 * close方法
		 * 	具备刷新的方法，在关闭流之前，就会先刷新一次缓冲区，将缓冲区的字节全部都刷新到文件上，close之后不能继续写
		 * flush方法
		 * 	具备刷新的功能，刷完之后，可以继续写
		 */
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("743800.png"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy743800.png"));
		
		int b;
		while ((b = bis.read())!=-1) {
			bos.write(b);
		}
		bos.flush();
		
		bis.close();
		bos.close();
```
### 13. 字节流读写中文
    * 字节流读取中文的问题
        * 字节流在读中文的时候有可能会读到半个中文,造成乱码 
    * 字节流写出中文的问题
        * 字节流直接操作的字节,所以写出中文必须将字符串转换成字节数组 
        * 写出回车换行 write("\r\n".getBytes());
```java
package com.leeup.javase.day20.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/***
 * 字节流读写中文
 * @author 李闯
 *
 */
public class Demo6_Chinese {

	public static void main(String[] args) throws IOException {
//		demo1(); 
		FileOutputStream fos = new FileOutputStream("zzz.txt");
		fos.write("我读书少，你别骗我".getBytes());
		fos.write("\r\n".getBytes());
		fos.close();
 	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("yyy.txt");
		byte[] arr = new byte[3];
		int len;
		while ((len = fis.read(arr))!=-1) {
			System.out.println(new String(arr,0,len));
		}
		fis.close();
	}
}

```
### 14. 流的标准处理异常代码1.6版本及其以前
    * try finally嵌套
    
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream("aaa.txt");
                fos = new FileOutputStream("bbb.txt");
                int b;
                while((b = fis.read()) != -1) {
                    fos.write(b);
                }
            } finally {
                try {
                    if(fis != null)
                        fis.close();
                }finally {
                    if(fos != null)
                        fos.close();
                }
            }

### 15. 流的标准处理异常代码1.7版本
    * try close
    
            try(
                FileInputStream fis = new FileInputStream("aaa.txt");
                FileOutputStream fos = new FileOutputStream("bbb.txt");
                MyClose mc = new MyClose();
            ){
                int b;
                while((b = fis.read()) != -1) {
                    fos.write(b);
                }
            }
    * 原理
        * 在try()中创建的流对象必须实现了AutoCloseable这个接口,如果实现了,在try后面的{}(读写代码)执行后就会自动调用,流对象的close方法将流关掉 
```java
package com.leeup.javase.day20.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author 李闯
 *
 */
public class Demo7_TryFinally {

	public static void main(String[] args) throws IOException {
//		demo1();
		
		/**
		 * 1.7版本
		 * 
		 */
			try(
					//当流对象写在try的小括号中的时候，在执行大括号中的读写完成之后，会自动调用关闭的方法，
					//try小括号中只能写具有自动关闭的功能对象
					//InputStream继承了Closeable实现了AutoCloseable中有一个close方法
					//想要写自己的对象，必须实现AutoCloseable接口，重写close方法
					FileInputStream fis = new FileInputStream("xxx.txt");
					FileOutputStream fos = new FileOutputStream("yyy.txt");
					MyClose mc = new MyClose();
			){
				int b;
				while ((b = fis.read())!=-1) {
					fos.write(b);
				}
			}
			
	//		fis.close();
	//		fos.close();
	}

	/**
	 * 1.6
	 * @throws IOException
	 */
	private static void demo1() throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("xxx.txt");
			fos =  new FileOutputStream("yyy.txt");
			
			int b;
			while ((b = fis.read())!=-1) {
				fos.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if (fis!=null)
						fis.close();
				} finally {
					if (fos!=null)  
						fos.close();
				}
		}
	}
}


class MyClose implements AutoCloseable{
	public void close() {
		System.out.println("我关了");
	}
}
```
### 16. 图片加密
    * 给图片加密
    
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.jpg"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("b.jpg"));
            
            int b;
            while((b = bis.read()) != -1) {
                bos.write(b ^ 123);
            }
            
            bis.close();
            bos.close();
```java
package com.leeup.javase.day20.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片加密
 * @author 李闯
 *
 */
public class Test1 {

	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("743800.png"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy743800.png"));
		
		int b;
		while ((b = bis.read()) !=-1) {
			bos.write(b ^ 123); //一个数字异或两次就是自己本身，所以异或的数就相当于密码一样，当
		}
		bis.close();
		bos.close();
	}
}

```
### 17. 拷贝文件
    * 在控制台录入文件的路径,将文件拷贝到当前项目下
    
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个文件路径");
            String line = sc.nextLine();				//将键盘录入的文件路径存储在line中
            File file = new File(line);					//封装成File对象
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file.getName());
            
            int len;
            byte[] arr = new byte[8192];				//定义缓冲区
            while((len = fis.read(arr)) != -1) {
                fos.write(arr,0,len);
            }
            
            fis.close();
            fos.close();
```java
package com.leeup.javase.day20.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


/**
 * 在控制台录入文件的路径,将文件拷贝到当前项目下
 * @author 李闯
 *	分析：
 *	1. 判断录入的是不是文件，如果是就存储并拷贝，所以要定义方法，对键盘录入的路径进行判断，如果是文件就返回
 *  2. 在主方法中接收该文件
 *  3. 读和写该文件
 */
public class Test2 {

	public static void main(String[] args) throws IOException {
		File file = getFile();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getName()));
		
		
		int b;
		while ((b = bis.read())!=-1) {
			bos.write(b);
		}
		bis.close();
		bos.close();
	}
	
	/**
	 * 定义一个方法，获取键盘录入的文件路径，并封装成File对象返回
	 * 	1. 返回值类型 File
	 *  2. 参数列表无
	 */
	public static File getFile() {
		Scanner scanner = new Scanner(System.in);	//创建键盘录入对象
	
		while (true) {
			String line = scanner.nextLine();			//接收键盘录入路径
			File file = new File(line);				//封装成file对象可以对其做一系列判断
			if (!file.exists()) {
				System.out.println("您录入的文件路径不存在，请重新录入");
			} else if (file.isDirectory()) {
				System.out.println("您录入的文件夹路径不正确，请重新录入");
			}else {
				return file;
			}
		}
	}
}

```
### 18. 录入数据拷贝到文件
    * 将键盘录入的数据拷贝到当前项目下的text.txt文件中,键盘录入数据当遇到quit时就退出
    
            Scanner sc = new Scanner(System.in);
            FileOutputStream fos = new FileOutputStream("text.txt");
            System.out.println("请输入:");
            while(true) {
                String line = sc.nextLine();
                if("quit".equals(line))
                    break;
                fos.write(line.getBytes());
                fos.write("\r\n".getBytes());
            }
            
            fos.close();
### 19_day 总结
* 把今天的知识点总结一遍。