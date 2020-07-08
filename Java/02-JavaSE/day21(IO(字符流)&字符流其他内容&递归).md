### 01. 字符流FileReader
    1. 字符流是什么
        * 字符流是可以直接读写字符的IO流
        * 字符流读取字符, 就要先读取到字节数据, 然后转为字符. 如果要写出字符, 需要把字符转为字节再写出.    
    2. FileReader
        * FileReader类的read()方法可以按照字符大小读取
    
            FileReader fr = new FileReader("aaa.txt");				//创建输入流对象,关联aaa.txt
            int ch;
            while((ch = fr.read()) != -1) {							//将读到的字符赋值给ch
                System.out.println((char)ch);						//将读到的字符强转后打印
            }
            
            fr.close();												//关流 
```java
package com.leeup.javase.day21.chario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符流FileReader
 * @author 李闯
 *
 */
public class Demo1_FileReader {

	public static void main(String[] args) throws IOException {
		
//		demo1();
		FileReader fr = new FileReader("xxx.txt");
		int c;
		while((c = fr.read())!=-1) {		//通过项目默认的码表，一次读取一个字符
			System.out.print((char)(c));
		}
		fr.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		//基本版
		FileReader fr = new FileReader("xxx.txt");
		int x = fr.read();
		System.out.println(x);
		char c = (char) x;
		System.out.println(c);
		fr.close();
	}
}

```
### 02. 字符流FileWriter
    * FileWriter类的write()方法可以自动把字符转为字节写出
    
            FileWriter fw = new FileWriter("aaa.txt");
            fw.write("aaa");
            fw.close();
```java
package com.leeup.javase.day21.chario;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流FileWriter
 * @author 李闯
 *
 */
public class Demo2_FileWriter {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("yyy.txt");
		fw.write("大家好，吃饭了吗？");
		
		fw.close();
	}
}

```
### 03. 字符流的拷贝
	FileReader fr = new FileReader("a.txt");
	FileWriter fw = new FileWriter("b.txt");
	
	int ch;
	while((ch = fr.read()) != -1) {
		fw.write(ch);
	}
	
	fr.close();
	fw.close();
```java
package com.leeup.javase.day21.chario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流的拷贝
 * @author 李闯
 *
 */
public class Demo3_Copy {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("xxx.txt");
		FileWriter fw = new FileWriter("zzz.txt");
		
		int c;
		while ((c = fr.read())!=-1) {
			fw.write(c);
		}
		
		fr.close();
		fw.close();		//writer类中有一个两K的小缓冲区，如果不关流，就会将内容写到缓冲区中，关流。会将缓冲区中的内容写出，即刷新出来再关闭
	}

}

```
### 04. 什么情况下使用字符流
    * 字符流也可以拷贝文本文件, 但不推荐使用. 因为读取时会把字节转为字符, 写出时还要把字符转回字节.
    * 程序需要读取一段文本, 或者需要写出一段文本的时候可以使用字符流
    * 读取的时候是按照字符的大小读取的,不会出现半个中文
    * 写出的时候可以直接将字符串写出,不用转换为字节数组
![什么情况下使用字符流](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E5%AD%97%E7%AC%A6%E6%B5%81%E5%92%8C%E5%AD%97%E8%8A%82%E6%B5%81%E5%93%AA%E4%B8%AA%E6%8B%B7%E8%B4%9D%E7%BA%AF%E6%96%87%E6%9C%AC%E6%9B%B4%E5%A5%BD.png)

### 05. 字符流是否可以拷贝非纯文本的文件
    * 不可以拷贝非纯文本的文件
    * 因为在读的时候会将字节转换为字符,在转换过程中,可能找不到对应的字符,就会用?代替,写出的时候会将字符转换成字节写出去
    * 如果是?,直接写出,这样写出之后的文件就乱了,看不了了  

### 06. 自定义字符数组的拷贝)
*	
	​	
		FileReader fr = new FileReader("aaa.txt");			//创建字符输入流,关联aaa.txt
	​	FileWriter fw = new FileWriter("bbb.txt");			//创建字符输出流,关联bbb.txt
	​	
		int len;
		char[] arr = new char[1024*8];						//创建字符数组
		while((len = fr.read(arr)) != -1) {					//将数据读到字符数组中
			fw.write(arr, 0, len);							//从字符数组将数据写到文件上
		}
		
		fr.close();											//关流释放资源
		fw.close();	
```java
        FileReader fr = new FileReader("xxx.txt");
    FileWriter fw = new FileWriter("yyy.txt");
    
    char[] arr = new char[1024*8];
    int len;
    while ((len=fr.read(arr))!=-1) {		//将文件数据读取到字符数组中
        fw.write(arr,0,len);				//将字符数组中的数据写到文件上
    }
    fr.close();
    fw.close();	
```
### 07. 带缓冲的字符流
* BufferedReader的read()方法读取字符时会一次读取若干字符到缓冲区, 然后逐个返回给程序, 降低读取文件的次数, 提高效率
* BufferedWriter的write()方法写出字符时会先写到缓冲区, 缓冲区写满时才会写到文件, 降低写文件的次数, 提高效率
* 
		BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));	//创建字符输入流对象,关联aaa.txt
		BufferedWriter bw = new BufferedWriter(new FileWriter("bbb.txt"));	//创建字符输出流对象,关联bbb.txt
		
		int ch;				
		while((ch = br.read()) != -1) {		//read一次,会先将缓冲区读满,从缓冲去中一个一个的返给临时变量ch
			bw.write(ch);					//write一次,是将数据装到字符数组,装满后再一起写出去
		}
		
		br.close();							//关流
		bw.close();  


### 08. readLine()和newLine()方法
* BufferedReader的readLine()方法可以读取一行字符(不包含换行符号)
* BufferedWriter的newLine()可以输出一个跨平台的换行符号"\r\n"
* 
		BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("bbb.txt"));
		String line;
		while((line = br.readLine()) != null) {
			bw.write(line);
			//bw.write("\r\n");					//只支持windows系统
			bw.newLine();						//跨平台的
		}
		
		br.close();
		bw.close(); 
```java
package com.leeup.javase.day21.chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * readLine()和newLine()方法
 * @author 李闯
 * newLine与\r\n的区别
 * newLine是跨平台的方法
 * \r\n只支持windows
 *
 */
public class Demo4_Buffered {

	public static void main(String[] args) throws IOException {
//		demo1();
		BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("aaa.txt"));
		String line;
		while ((line = br.readLine())!=null) {
			bw.write(line);
//			bw.newLine();						//写出回车换行符、
			bw.write("\r\n");
			System.out.println(line);
		}
		br.close();
		bw.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
		String line;
		while ((line = br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
	}
}

```
### 09. 将文本反转
* 将一个文本文档上的文本反转,第一行和倒数第一行交换,第二行和倒数第二行交换
```java
package com.leeup.javase.day21.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 将文本反转
 * @author 李闯
 *分析：
 *	1.创建输入输出流对象，一定是Buffer的，我们要整行读，需要readLine
 *  2. 创建集合对象，把数据进行临时存储，倒着遍历写出去
 *  3. 将读到的数据，存储在集合中
 *  4. 倒着遍历集合将数据写到文件上
 *  5. 关流
 *  
 *  注意事项：
 *  流对象尽量晚开早关
 */
public class Test1 {

	private void mian() throws IOException {
		//1 
		BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));
		
		//2 
		ArrayList<String> list = new ArrayList<>();
		//3
		String line;
		while ((line = br.readLine())!=null) {
			list.add(line);
		}
		//4
		BufferedWriter bw = new BufferedWriter(new FileWriter("revzzz.txt"));
		for (int i = list.size(); i >=0; i--) {
			bw.write(list.get(i));
			bw.newLine();
		}
		//5 
		br.close();
		bw.close();  
	}
}

```
### 10. LineNumberReader
    * LineNumberReader是BufferedReader的子类, 具有相同的功能, 并且可以统计行号
        * 调用getLineNumber()方法可以获取当前行号
        * 调用setLineNumber()方法可以设置当前行号
    * 
            LineNumberReader lnr = new LineNumberReader(new FileReader("aaa.txt"));
            String line;
            lnr.setLineNumber(100);									//设置行号
            while((line = lnr.readLine()) != null) {
                System.out.println(lnr.getLineNumber() + ":" + line);//获取行号
            }
            
            lnr.close(); 
```JAVA
package com.leeup.javase.day21.chario;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineNumberReader
 * @author 李闯
 *
 */
public class Demo5_LineNumberReader {

	public static void main(String[] args) throws IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader("zzz.txt"));
		
		String line;
		lnr.setLineNumber(100);
		while ((line = lnr.readLine())!=null) {
			System.out.println(lnr.getLineNumber()+line);
		}
		lnr.close();
	}
}

```
### 11. 装饰设计模式


		interface Coder {
			public void code();
		}
		
		class Student implements Coder {
		
			@Override
			public void code() {
				System.out.println("javase");
				System.out.println("javaweb");
			}
			
		}
		
		class HeiMaStudent implements Coder {
			private Student s;						//获取到被包装的类的引用
			public HeiMaStudent(Student s) {		//通过构造函数创建对象的时候,传入被包装的对象
				this.s = s;
			}
			@Override
			public void code() {					//对其原有功能进行升级
				s.code();
				System.out.println("数据库");
				System.out.println("ssh");
				System.out.println("安卓");
				System.out.println(".....");
			}
			
		} 

### 12. 使用指定的码表读写字符
    * FileReader是使用默认码表读取文件, 如果需要使用指定码表读取, 那么可以使用InputStreamReader(字节流,编码表)
    * FileWriter是使用默认码表写出文件, 如果需要使用指定码表写出, 那么可以使用OutputStreamWriter(字节流,编码表)
    * 
            BufferedReader br = 									//高效的用指定的编码表读
                    new BufferedReader(new InputStreamReader(new FileInputStream("UTF-8.txt"), "UTF-8"));
            BufferedWriter bw = 									//高效的用指定的编码表写
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream("GBK.txt"), "GBK"));
            int ch;
            while((ch = br.read()) != -1) {
                bw.write(ch);
            }
            
            br.close();
            bw.close();
### 13. 转换流图解
    * 画图分析转换流
    ![转换流](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E8%BD%AC%E6%8D%A2%E6%B5%81.png)
### 14. 获取文本上字符出现的次数
    * 获取一个文本上每个字符出现的次数,将结果写在times.txt上
```java
package com.leeup.javase.day21.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * 获取一个文本上每个字符出现的次数,将结果写在times.txt上
 * @author 李闯
 *分析：
 *	1. 创建带缓冲的输入流对象
 *	2. 创建双列集合对象，HashMap或者TreeMap
 *  3. 将读到的字符存储在双列集合中，存储的时候要做判断，如果不包含这个键，就将键和1存储，如果包含这个键，就将该键和1存储
 *  4. 关闭输入流
 *  5. 创建输出流对象
 *  6. 遍历集合将集合中的内容写道times.txt中
 *  7. 关闭输出流
 */
public class Test2 {

	public static void main(String[] args) throws IOException {
		//1
		BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
		//2 
		TreeMap<Character, Integer> tm = new TreeMap<>();
		//3 
		int ch;
		while ((ch = br.read())!= -1) {
			char c = (char) ch; 		//强制类型准换
//			if (!tm.containsKey(c)) {
//				tm.put(c,1);
//			}else {
//				tm.put(c, tm.get(c)+1);
//			}
			tm.put(c, !tm.containsKey(c)?1:tm.get(c)+1);
		}
		//4
		br.close();
		//5
		BufferedWriter bw = new BufferedWriter(new FileWriter("times.txt"));
		for (Character key : tm.keySet()) {
			switch (key) {
			case '\t':
				bw.write("\\t"+"="+tm.get(key));
				bw.newLine();
				break;

			case '\n':
				bw.write("\\n"+"="+tm.get(key));
				bw.newLine();
				break;
				
			case '\r':
				bw.write("\\r"+"="+tm.get(key));
				bw.newLine();
				break;
				
			default :
				bw.write(key+"="+tm.get(key));
				break;
			}
			bw.newLine();
		}
		bw.close();
	}
}

```
### 15. 试用版软件
    * 当我们下载一个试用版软件,没有购买正版的时候,每执行一次就会提醒我们还有多少次使用机会用学过的IO流知识,模拟试用版软件,试用10次机会,执行一次就提示一次您还有几次机会,如果次数到了提示请购买正版
```java
package com.leeup.javase.day21.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 当我们下载一个试用版软件,没有购买正版的时候,每执行一次就会提醒我们还有多少次使用机会用学过的IO流知识,模拟试用版软件,
 * 试用10次机会,执行一次就提示一次您还有几次机会,如果次数到了提示请购买正版
 * @author 李闯
 * 分析：
 * 1. 创建带缓冲的输入流对象，因为readLine方法，可以保证 数据的原样性
 * 2. 将得到的字符串准换为int数
 * 3. 对int数j进行判断，如果大于0，就将其--写回去，如果不大于零，就提示购买正版
 * 4. 在if判断中要将--的结果打印，并将结果通过输入流写入到文件上
 */
public class Test3 {

	public static void main(String[] args) throws IOException {
		//1 
		BufferedReader br = new BufferedReader(new FileReader("config.txt"));
		//2 
		String line = br.readLine();
		int times = Integer.parseInt(line);		//将数字字符串转换为数字
		//3 
		if (times>0) {
			//4
			System.out.println("您还有"+times--+"次机会");
			FileWriter fw = new FileWriter("config.txt");
			fw.write(times +"");
			fw.close();
		}else {
			System.out.println("您的使用次数已经达到，请购买正版");
		}
		//关闭流
		br.close();
	}
}

```
### 16_File类(递归)
    * 5的阶乘	
```java
package com.leeup.javase.day21.chario;
/**
 * File类(递归)
    * 5的阶乘	
    * 递归：自己调用自己
 * @author 李闯
 *	5!
 *	5 * 4 * 3 * 2 * 1
 *
 *  5 * fun(4)(代表4!)
 *  	4 * fun(3)(代表3!)
 *  		3 * fun(2)(代表2!)
 *  			2 * fun(1)(代表1!)
 *  递归的弊端
 *  	不能调用次数过多，容易导致栈内存溢出
 *  好处：不用知道循环次数
 *  构造方法是否可以递归调用？
 *  	不能使用递归调用
 *  
 *  递归调用是否必须要有返回值？
 *  	不一定，可以有，可以没有 
 */
public class Demo8_DiGui {

	public static void main(String[] args) {
		int result = 1;
		
		for (int i = 1; i <= 5; i++) {
			result = result * i;
		}
		System.out.println(result);
	}
	
	public static int fun(int num) {
		if (num == 1 ) {
			return 1;
		}else {
			return num * fun(num -1);
		}
	}
}

```
### 17_File类(练习)
    * 需求:从键盘输入接收一个文件夹路径,打印出该文件夹下所有的.java文件名
```java
package com.leeup.javase.day21.test;

import java.io.File;
import java.util.Scanner;

/**
 * 需求:从键盘输入接收一个文件夹路径,打印出该文件夹下所有的.java文件名
 * @author 李闯
 * 分析：
 * 	1. 从键盘接收一个文件夹路径
 * 		如果录入的是不存在的，给与提示
 * 		如果是文件路径，给予提示
 * 		如果是文件夹路径，给予提示
 *  2. 打印出该文件夹下所有的.java文件名
 *  	获取到该文件夹路径下的所有的文件和文件夹，存储在File数组中
 *  	遍历数组，对每一个文件或者文件夹做判断，如果是文件并且后缀是.java的，就打印
 *  	如果是文件夹，就递归调用
 *  	
 */
public class Test5 {

	public static void main(String[] args) {
		File dir = getDir();
		printJavaFile(dir);
	}
	/**
	 * 获取键盘录入的文件夹路径
	 * 1. 返回值类型是File
	 * 2. 不需要有参数
	 */
	public static File getDir() {
		Scanner sc = new Scanner(System.in);		//创建键盘录入对象
		System.out.println("请输入一个文件夹路径");
		while (true) {
			String line = sc.nextLine();		//将键盘录入的文件夹路径存储
			File dir = new File(line);			//封装成file对象
			if (!dir.exists()) {
				System.out.println("您录入的文件夹路径不存在，请重新录入！");
			} else if (dir.isFile()) {
				System.out.println("您录入的是文件路径，请重新录入文件夹路径");
			} else{
				return dir;
			}
		}
		/**
		 * 获取文件夹路径下的所有.java文件
		 * 1. 返回值类型 void
		 * 2. 参数列表File dir
		 */
	}
	public static void printJavaFile(File dir) {
		File[] subFiles = dir.listFiles();
		for (File file : subFiles) {
			if (file.isFile() && file.getName().endsWith(".java")) {
				System.out.println(file);
			}else if (file.isDirectory()) {
				printJavaFile(file);
			}
		}
	}
}

```
### 18. 总结
    * 1.会用BufferedReader读取GBK码表和UTF-8码表的字符
    * 2.会用BufferedWriter写出字符到GBK码表和UTF-8码表的文件中
    * 3.会使用BufferedReader从键盘读取一行
