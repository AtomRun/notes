### 01 异常的概述和分类
    1. 异常的概述
        * 异常就是Java程序在运行过程中出现的错误。
    2. 异常的分类
        * 通过API查看Throwable
        * Error
            * 服务器宕机,数据库崩溃等
        * Exception
    3. 异常的继承体系
        * Throwable
            * Error	
            * Exception
                * RuntimeException

### 02 JVM默认是如何处理异常的
    1. JVM默认是如何处理异常的
        * main函数收到这个问题时,有两种处理方式:
        1. 自己将该问题处理,然后继续运行
        2. 自己没有针对的处理方式,只有交给调用main的jvm来处理
        * jvm有一个默认的异常处理机制,就将该异常进行处理.
        * 并将该异常的名称,异常的信息.异常出现的位置打印在了控制台上,同时将程序停止运行
    2. 案例演示
        * JVM默认如何处理异常
```java
package com.leeup.javase.day exception;
/**
 * 异常的概述和分类
 * @author 李闯
 *
 */
public class Demo1_Exception {

	public static void main(String[] args) {
//		demo1();
		
		Demo demo = new Demo();
		//除数不能为0 java.lang.ArithmeticException: / by zero
		int x = demo.div(10, 0);
		System.out.println(x);
	}

	private static void demo1() {
		int [] arr = {11,22,33,44,55};
//		arr = null;
		System.out.println(arr[10]);//索引越界异常
	}
}


class Demo{
	
	/**
	 * 除法运算
	 */
	public int div(int a, int b) {
		return a/b;					//10/0被除数为10，除数为0，违背了数学运算法则，抛出异常
									//new ArithmeticException: / by zero
	}
}
```
### 03 try...catch的方式处理异常1
    1. 异常处理的两种方式
        1. try…catch…finally
            * try catch
            * try catch finally
            * try finally 
        2. throws
    2. try...catch处理异常的基本格式
        * try…catch…finally
    3. 案例演示
        * try...catch的方式处理1个异常
        1. try:用来检测异常的
        2. catch:用来捕获异常的
        3. finally:释放资源
```java
package com.leeup.javase.day exception;
/**
 * try...catch的方式处理异常1
 * 
 * 世界上最真情的相依就是你在try我在catch.无论你发什么脾气，我都静静接受，默默处理，备胎精神
 * @author 李闯
 * 当通过tryCATCH将异常处理了，程序会继续执行
 *
 */
public class Demo2_Exception {

	public static void main(String[] args) {
		Demo2 demo2 = new Demo2();
		try {
			int x = demo2.div(10, 0);
			System.out.println(x);
		} catch (ArithmeticException a) {//ArithmeticException a = new ArithmeticException();
			System.out.println("出错了，除数为0了");
		}
		System.out.println("111111111111111111");//有了tryCatch可以继续执行
	}
}

class Demo2{
	
	/**
	 * 除法运算
	 */
	public int div(int a, int b) {
		return a/b;					//10/0被除数为10，除数为0，违背了数学运算法则，抛出异常
									//new ArithmeticException: / by zero
	}
}
```
### 04 try...catch的方式处理异常2
1. 案例演示
	* try...catch的方式处理多个异常
	* JDK7以后处理多个异常的方式及注意事项
```java
package com.leeup.javase.day exception;
/**
 * try...catch的方式处理异常2
 * 安卓，客户端开发，如何处理？try catch
 * eee 服务端开发，一般从底层开发，向上抛
 * try后面如果跟多个catch，那么小的异常放前面，大的异常往后放
 * 根据多态的原理，如果大的放前面，就会将所有的子类对象接收，后面的catch就没有意义了
 * @author 李闯
 *
 */
public class Demo3_Exception {

	public static void main(String[] args) {
//		demo1();
		
		int a =10;
		int b = 0;
		int [] arr = {11,22,33,44,55};
		
		//jdk7如何处理多个异常
		try {
			System.out.println(a/b);
			System.out.println(arr[10]);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {//即可以使用或的方式
			System.out.println("出错了");
		} 
	}

	private static void demo1() {
		int a =10;
		int b = 10;
		int [] arr = {11,22,33,44,55};
		
		try {
			arr = null;
			System.out.println(arr[10]);
		} catch (ArithmeticException e) {
			System.out.println("除数不能为0");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("索引越界了");
		} catch(Exception e) {		//Exception e = new NullPointerException();
			System.out.println("出错了");
		}
	}
}
```
### 05 编译期异常和运行期异常的区别
    1. 编译期异常和运行期异常的区别
        * Java中的异常被分为两大类：编译时异常和运行时异常。
        * 所有的RuntimeException类及其子类的实例被称为运行时异常，其他的异常就是编译时异常
        
        * 编译时异常
            * Java程序必须显示处理，否则程序就会发生错误，无法通过编译
        * 运行时异常
            * 无需显示处理，也可以和编译时异常一样处理
    2. 案例演示
        * 编译期异常和运行期异常的区别
```java
package com.leeup.javase.day exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 编译期异常和运行期异常的区别
 * @author 李闯
 *
 */
public class Demo4_Exception {

	public static void main(String[] args) {
		//编译时异常，也被叫做未雨绸缪异常，即对可能出现的异常做预防准备
		try {
			//如果不处理，编译就不会通过，就是所谓编译期异常，
			//所谓未雨绸缪：在做某些事情的时候要做某些准备
			//编译时异常：在编译某个程序的时候，有可能就会有各种事情发生，比如文件找不到，这样的异常就必须在编译的时候处理
			//如果不处理，编译通不过
			
			
			//运行时异常不处理。也可以编译，但是在运行时会出现异常
			//即程序员犯得错误，需要回来修改代码
			FileInputStream fis = new FileInputStream("xxx.txt");//硬盘这个文件可能是不存在的，有这种可能，所以我们先处理
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

```

### 06 Throwable的几个常见方法
    1. Throwable的几个常见方法
        1. getMessage()
            * 获取异常信息，返回字符串。
        2. toString()
            * 获取异常类名和异常信息，返回字符串。
        3. printStackTrace()
            * 获取异常类名和异常信息，以及异常出现在程序中的位置。返回值void。
    2. 案例演示
        * Throwable的几个常见方法的基本使用
```java
package com.leeup.javase.day19.exception;
/**
 * Throwable的几个常见方法
 * @author 李闯
 *
 */
public class Demo5_ThrownAble {

	public static void main(String[] args) {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			//走到catch中就相当于给e赋了个地址值，因为在上面1/0就创建了一个对象，除0异常对象，
			//这里即变成了：Exception e = new ArithmeticException("/ by Zero");
			System.out.println(e.getMessage());//获取异常信息。。返回字符串
			System.out.println(e.toString());//打印异常类名,异常信息，返回字符串，其实等于System.out.println(e);默认调用toString方法，打印异常类名和异常信息
			e.printStackTrace();				//打印异常类名,异常信息。包括异常出现的位置，JVM默认就用这种方式处理异常的
		}
	}
}

```
### 07 throws的方式处理异常
    1. throws的方式处理异常
        * 定义功能方法时，需要把出现的问题暴露出来让调用者去处理。
        * 那么就通过throws在方法上标识。
    2. 案例演示
        * 举例分别演示编译时异常和运行时异常的抛出
```java
package com.leeup.javase.day19.exception;
/**
 * throws的方式处理异常
 * 编译时异常的抛出：
 * 		必须对其进行处理
 * 运行时异常的抛出：
 * 		可以处理，可以不处理
 * @author 李闯
 *
 */
public class Demo6_Exception {

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		p.setAge(-17);//调用有异常的方法，必须对他进行异常处理
		System.out.println(p.getAge());
	}
}

class Person{
	private String name;
	private int age;
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception {
		if (age > 0 && age<=150) {
			this.age = age;
		}else {
			throw new Exception("年龄非法");//当抛出RuntimeException的收，编译时不需要对他进行处理
//			System.out.println("请回火星吧");
		}
	}
}
```
### 08 throw的概述以及和throws的区别
    1. throw的概述
        * 在功能方法内部出现某种情况，程序不能继续运行，需要进行跳转时，就用throw把异常对象抛出。
    2. 案例演示	
        * 分别演示编译时异常对象和运行时异常对象的抛出
    3. throws和throw的区别
        1. throws
            * 用在方法声明后面，跟的是异常类名
            * 可以跟多个异常类名，用逗号隔开
            * 表示抛出异常，由该方法的调用者来处理
        2. throw
            * 用在方法体内，跟的是异常对象名
            * 只能抛出一个异常对象名
            * 表示抛出异常，由方法体内的语句处理

### 09 finally关键字的特点及作用
    1. finally的特点
        * 被finally控制的语句体一定会执行
        * 特殊情况：在执行到finally之前jvm退出了(比如System.exit(0))
    2. finally的作用
        * 用于释放资源，在IO流操作和数据库操作中会见到
    3. 案例演示
        * finally关键字的特点及作用
```java
package com.leeup.javase.day19.exception;
/**
 * finally关键字的特点及作用
 * @author 李闯
 *
 */
public class Demo7_Finally {

	public static void main(String[] args) {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			System.out.println("除数为0了");
			
			System.exit(0);//退出虚拟机finally不会执行
			return;//即使return finally也会执行
			
			//在return语句执行之前看看有没有finally，执行完成其中的语句，如果有就执行后再彻底返回
		}finally {
			//finally的语句中一定会执行，一般用来关闭资源
			System.out.println("看看我执行了嘛");
		}
	}
}

```
### 10 finally关键字的面试题[其实有点像雷锋和雷锋塔的区别]
    1. 面试题1
        * final,finally和finalize的区别
    2. 面试题2
        * 如果catch里面有return语句，请问finally的代码还会执行吗?如果会，请问是在return前还是return后。
```java
package com.leeup.javase.day19.test;
/**
 * finally关键字的面试题[其实有点像雷锋和雷锋塔的区别]
 *  1. 面试题1
        * final,finally和finalize的区别
        	final
	        	final可以修饰类，修饰的类不能被继承
	        	final可以修饰方法，修饰的方法不能被重写
	        	final可以修饰变量，修饰的变量只能被赋值一次
        	finally
        		是try语句中的一个语句体，不能单独使用，用来释放资源
        	finalize
        		是一个方法
        		当垃圾回收器确定不存在该对象更多的引用的时候，由对象的垃圾回收器调用此方法
    2. 面试题2
        * 如果catch里面有return语句，请问finally的代码还会执行吗?如果会，请问是在return前还是return后。
        	会执行
        	return前
        		return先去执行，建立一个返回路径，再去执行finally，最后return再彻底返回，finally执行完毕，再彻底返回
 * @author 李闯
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Demo demo = new Demo();
		int x = demo.method();
		/**
		 * 结果为30为什么不是40呢？不是说在return之前会查看finally中是否有语句然后执行嘛
		 * 当int x = 10;后就走到了try中，然后x = 20;然后就执行1/0就出异常了。
		 * 就跳到catch中了，catch中x=30;现在x=30了。然后return x;建立了一个返回路径，将30装到了返回路径的箱子中
		 * 然后再看自己有finally语句没有，有就执行，虽然finally中将将x的值改了，但是返回路径中的值并没有改
		 */
		System.out.println(x);
	}
}

class Demo {
	public int method () {
		int x = 10;
		try {
			x =20;
			System.out.println(1/0);
			return x;
		} catch (Exception e) {
			x = 30;
			return x;
		} finally {
			x = 40;
//			return x;				不要再finally中写return语句，因为finaly的作用，是为了释放资源，是肯定会执行的
									//如果在这里面写了返回语句，那么try和catch的结果都会改变，所以这么写就是犯罪啊
		}
	}
}
```
### 11 自定义异常概述和基本使用
    1. 为什么需要自定义异常
        * 举例：人的年龄
    2. 自定义异常概述
        * 继承自Exception
        * 继承自RuntimeException
    3. 案例演示
        * 自定义异常的基本使用
```java
package com.leeup.javase.day19.exception;
/**
 * 自定义异常概述和基本使用
 * 之所以要有自定义异常，因为要看异常名字，但与快速识别问题
 * @author 李闯
 *
 */
public class Demo8_Exception {

}

class AgeOutOfBoundsException extends Exception {//继承RuntimeException就变成了运行时异常

	//重写构造
	public AgeOutOfBoundsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgeOutOfBoundsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
```
### 12 异常的注意事项及如何使用异常处理
    1. 异常注意事项
        1. 子类重写父类方法时，子类的方法必须抛出相同的异常或父类异常的子类。(父亲坏了,儿子不能比父亲更坏)
        2. 如果父类抛出了多个异常,子类重写父类时,只能抛出相同的异常或者是他的子集,子类不能抛出父类没有的异常
        3. 如果被重写的方法没有异常抛出,那么子类的方法绝对不可以抛出异常,如果子类方法内有异常发生,那么子类只能try,不能throws
    2. 如何使用异常处理
        * 原则:如果该功能内部可以将问题处理,用try,如果处理不了,交由调用者处理,这是用throws
        * 区别:
            * 后续程序需要继续运行就try
            * 后续程序不需要继续运行就throws
            
        * 如果JDK没有提供对应的异常，需要自定义异常。

### 13 练习
    1. 键盘录入一个int类型的整数,对其求二进制表现形式
        * 如果录入的整数过大,给予提示,录入的整数过大请重新录入一个整数BigInteger
        * 如果录入的是小数,给予提示,录入的是小数,请重新录入一个整数
        * 如果录入的是其他字符,给予提示,录入的是非法字符,请重新录入一个整数
```java
package com.leeup.javase.day19.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 练习
 * @author 李闯
 *	分析：
 *	1. 创建键盘录入对象
 *	2. 将键盘录入的结果存储在String类型的字符串中，存储int类型中，如果有不符合条件的，直接报错，无法进行后续判断
 *  3. 键盘录入的结果转换成int类型的数据，是正确的还是错误的
 *  4. 正确的直接转换，
 *  5. 错误的要进行判断
 *	
 */
public class Test2 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("请输入一个整数");
		 while(true) {
			 String line = sc.nextLine();			//键盘录入的结果存储在line中
			 try {
				 int num = Integer.parseInt(line);		//将字符串准换为整数
				 System.out.println(Integer.toBinaryString(num));	//将整数转换为二进制
				 break;
			 } catch (Exception e) {
				 try {
					 new BigInteger(line);
					 System.out.println("录入错误，您录入的是一个过大的整数，请重新输入一个整数：");
				} catch (Exception e2) {
					try {
						new BigDecimal(line);
						 System.out.println("录入错误，您录入的是一个小数，请重新输入一个整数：");
					} catch (Exception e1) {
						 System.out.println("录入错误，您录入的是非法字符，请重新输入一个整数：");
					}
				}
				 
			 }
		 }
	}
}

```

### 14. File类的概述和构造方法
    1. File类的概述
        * File更应该叫做一个路径
            * 文件路径或者文件夹路径  
            * 路径分为绝对路径和相对路径
            * 绝对路径是一个固定的路径,从盘符开始
            * 相对路径相对于某个位置,在eclipse下是指当前项目下,在dos下
        * 查看API指的是当前路径
        * 文件和目录路径名的抽象表示形式
    2. 构造方法
        * File(String pathname)：根据一个路径得到File对象
        * File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
        * File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
    3. 案例演示
        * File类的构造方法
```java
package com.leeup.javase.day19.file;

import java.io.File;

/**
 * File类的概述和构造方法
 * @author 李闯
 *
 */
public class Demo1_File {

	public static void main(String[] args) {
//		demo1();
//		demo2();
		
		//封装成file对象的好处，更容易对他进行操作
		File parent = new File("G:\\\\fileTest");
		String child = "fileTest.txt";
		File file = new File(parent,child);
		System.out.println(file.exists());
		System.out.println(parent.exists());
		
	}

	private static void demo2() {
		String parent = "G:\\fileTest";	//父级路径
		String child = "fileTest.txt";	//子级路径
		File file = new File(parent,child);
		System.out.println(file.exists());
	}

	private static void demo1() {
		File file = new File("G:\\fileTest\\fileTest.txt");
		System.out.println(file.exists());	//检测该路径下的文件是否存在
		
		File file2 = new File("xxx.txt");
		System.out.println(file2.exists());	//检测
		
		File file3 = new File("yyy.txt");
		System.out.println(file3.exists());
	}
}

```
### 15. File类的创建功能
    1. 创建功能
        * public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
        * public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
        * public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
    2. 案例演示
        * File类的创建功能

        * 注意事项：
            * 如果你创建文件或者文件夹忘了写盘符路径，那么，默认在项目路径下。
```java
package com.leeup.javase.day19.file;

import java.io.File;
import java.io.IOException;

/**
 * File类的创建功能
 * @author 李闯
 *
 */
public class Demo2_File {

	public static void main(String[] args) throws IOException {
//		demo1();
		File dir1 = new File("aaa");
		System.out.println(dir1.mkdir());
		
		File dir2 = new File("bbb.txt");		//文件夹也是有后缀的
		System.out.println(dir2.mkdir());
		
		File dir3 = new File("ccc\\ddd");
		System.out.println(dir3.mkdirs());		//mkdirs创建多级目录
	}

	private static void demo1() throws IOException {
		File file = new File("yyy.txt");//在当前目录[eclipse目录]如果没有就创建名字为yyy.txt的文件返回true，有就不创建返回false
		System.out.println(file.createNewFile());
		
		File file2 = new File("zzz");
		System.out.println(file2.createNewFile());
	}
}

```
### 16. File类的重命名和删除功能
    1. 重命名和删除功能
        * public boolean renameTo(File dest):把文件重命名为指定的文件路径
        * public boolean delete():删除文件或者文件夹
    2. 重命名注意事项
        * 如果路径名相同，就是改名。
        * 如果路径名不同，就是改名并剪切。
    3. 删除注意事项：
        * Java中的删除不走回收站。
        * 要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
```java
package com.leeup.javase.day19.file;

import java.io.File;

/**
 * File类的重命名和删除功能
 * @author 李闯
 *
 */
public class Demo3_File {

	public static void main(String[] args) {
//		demo1();
		File file1 = new File("yyy.txt");
		System.out.println(file1.delete());
		
		File file2 = new File("aaa");
		System.out.println(file2.delete());
		
		File file3 = new File("ccc");		//如果删除一个文件夹，那么文件夹必须是空的
		System.out.println(file3.delete());
	}

	private static void demo1() {
		File file1 = new File("ooo.txt");
		File file2 = new File("D:\\xxx.txt");
		
		System.out.println(file1.renameTo(file2));
	}
}

```

### 17. File类的判断功能
    1. 判断功能
        * public boolean isDirectory():判断是否是目录
        * public boolean isFile():判断是否是文件
        * public boolean exists():判断是否存在
        * public boolean canRead():判断是否可读
        * public boolean canWrite():判断是否可写
        * public boolean isHidden():判断是否隐藏
    2. 案例演示
        * File类的判断功能
```java
package com.leeup.javase.day19.file;

import java.io.File;

/**
 * File类的判断功能
 * @author 李闯
 *
 */
public class Demo4_FileMethod {

	public static void main(String[] args) {
//		demo1();
		
		//设置是否可读
		File file = new File("zzz");			
		file.setReadable(false);
		System.out.println(file.canRead());		//windows系统认为所有的文件都是可读的，这里的读是使用io读
		file.setWritable(true);
		System.out.println(file.canWrite());	//windows可以设置为不可写
		
		File file2 = new File("aaa.txt");
		System.out.println(file2.isHidden());
	}

	private static void demo1() {
		File dir1 = new File("ccc");
		System.out.println(dir1.isDirectory());	//判断是否是文件夹
		
		
		File dir2 = new File("zzz");
		System.out.println(dir2.isDirectory());
		
		System.out.println(dir1.isFile());		//判断是否是文件
		System.out.println(dir2.isFile());
	}
}

```
### 18. File类的获取功能
    1. 获取功能
        * public String getAbsolutePath()：获取绝对路径
        * public String getPath():获取路径
        * public String getName():获取名称
        * public long length():获取长度。字节数
        * public long lastModified():获取最后一次的修改时间，毫秒值
        * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
        * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组 
    2. 案例演示
        * File类的获取功能
```java
package com.leeup.javase.day19.file;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * File类的获取功能
 * @author 李闯
 *
 */
public class Demo5_FileMethod {

	public static void main(String[] args) {
//		demo1();
		File dir =  new File("G:\\fileTest\\");
		String[] arr = dir.list();		//仅为了获取文件名
		for (String string : arr) {
			System.out.println(string);
		}
		
		File[] subFiles = dir.listFiles();
		for (File file : subFiles) {
			System.out.println(file);	//文件全路径。file重写了toString方法，文件对象
		}
	}

	private static void demo1() {
		File file1 = new File("ccc.txt");
//		System.out.println(file1.getAbsolutePath());	//获取绝对路径
		
		File file2 = new File("E:\\eclipseinst-workspace\\j2se\\ccc.txt");
//		System.out.println(file2.getAbsolutePath());	
//		System.out.println(file1.getPath());//获取构造方法中传入的路径
//		System.out.println(file2.getPath());
		
//		System.out.println(file1.getName());			//获取文件或者文件夹的内容
//		System.out.println(file2.getName());
//		System.out.println(file1.length());				//文件中字符长度
//		System.out.println(file1.lastModified());		//最后一次修改文件的毫秒数.文件的最后修改时间
		
		Date d = new Date(file1.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月 dd日 HH:mm:ss");
		System.out.println(sdf.format(d));
	}
}

```
### 19. 输出指定目录下指定后缀的文件名
    1. 案例演示
        * 需求：判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
```JAVA
package com.leeup.javase.day19.test;

import java.io.File;

/**
 * 输出指定目录下指定后缀的文件名
 * @author 李闯
 *
 */
public class Test3 {

	public static void main(String[] args) {
		File dir = new File("G:\\fileTest");
		
//		String[] arr = dir.list();//获取这个路径下的所有文件或者文件夹
//		for (String string : arr) {	
//			//拿到了该路径下所有文件/文件夹的名字
//			if (string.endsWith(".txt")) {
//				System.out.println(string);
//			}
//		}
		File[] subFiles = dir.listFiles();	//拿到该路径下所有的文件/文件夹对象
		
		for (File subFile : subFiles) {
			if (subFile.isFile() && subFile.getName().endsWith(".txt")) {
				System.out.println(subFile);
			}
		}
	}
}

```
### 20. 文件名称过滤器的概述及使用
    1. 文件名称过滤器的概述
        * public String[] list(FilenameFilter filter)
        * public File[] listFiles(FileFilter filter)
    2. 文件名称过滤器的使用
        * 需求：判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
    3. 源码分析
        * 带文件名称过滤器的list()方法的源码
```java
package com.leeup.javase.day19.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件名称过滤器的概述及使用
 * @author 李闯
 *
 */
public class Demo6_FileMethod {

	public static void main(String[] args) {
		File dir = new File("G:\\fileTest");
		String[] arr = dir.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
//				System.out.println(dir);	//上述路径
//				System.out.println(name);	//文件名字
				File file = new File(dir,name);
				
				return file.isFile() && file.getName().endsWith(".txt");
			}
		});
		for (String string : arr) {
			System.out.println(string);
		}
	}
}

```
