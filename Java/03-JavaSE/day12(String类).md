## String类

### 1. Scanner的概述和方法介绍
    1. Scanner的概述
    2. Scanner的构造方法原理
        1. Scanner(InputOutStream source)
        2. System类下有一个静态的字段
            1. public static final InputStream in; 标准的输入流，对应着键盘录入
    3. 一般方法：
        1. hashNextXxx() 判断是否还有下一个输入项，其中Xxx可以是Int,Double等，如果需要判断是否包含下一个字符串，可以省略Xxx
        2. nextXxx() 获取下一个输入项。Xxx的含义和上个方法中的Xxx相同，默认情况下，Scanner使用空格回车等作为分隔符
```java
package com.leeup.javase.day12.scanner;

import java.util.Scanner;

/**
 * Scanner类概述和方法介绍
 * @author 李闯
 *
 */
public class Demo1_Scanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	//键盘录入
		
//		int i = scanner.nextInt();					//键盘录入整数，存储在i中
//		System.out.println(i);
		
		if (scanner.hasNextInt()) {	//键盘录入的是int数的话，为true
			int i = scanner.nextInt();
			System.out.println(i);
		}else {
			System.out.println("输入的类型错误");
		}
	}
}
```

### 2. Scanner获取数据出现的小问题及解决方案
    1. 两个常用的方法
        1. public int nextInt() 获取一个int类型的值
        2. public String nextLine() 获取一个String类型的值
    2. 案例展示
        1. 先展示获取多个int值，多个String值得情况
        2. 再展示获取int值，然后获取String值出现问题
        3. 问题解决方案
            1. 第一种：先获取一个数值后，再创建一个新的键盘录入对象获取字符串
            2. 第二种：把所有的数据先按照字符串获取，然后要什么，你就对应转换为什么(后面讲)

```java
package com.leeup.javase.day12.scanner;

import java.util.Scanner;


/**
 * Scanner常见方法及问题解决方案
 * @author 李闯
 *
 */
public class Demo2_Scanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//使用nextInt方法
//		System.out.println("请输入第一个整数：");
//		int i = scanner.nextInt();
//		System.out.println("请输入第二个整数：");
//		int j = scanner.nextInt();
//		System.out.println("第一个数为"+i+"，第二个整数为"+j);
		
		//使用nextLine方法
		System.out.println("请输入第一个字符串");
		String line1 = scanner.nextLine();
		System.out.println("请输入第二个字符串");
		String line2 = scanner.nextLine();
		
		System.out.println("第一个字符串为："+line1+"，第二个字符串为"+line2);
		/**
		 * 当第一个输入方式使用nextInt，第二个数的输入方式改成nextLine的时候第一个数输完之后，直接就执行到最后了
		 * nextInt是键盘录入整数的方法，当我们录入10的时候，其实在键盘上录入的是10和\r\n，录入10我们
		 * 要敲一下回车，回车就是\r\n
		 * nextInt只获取10就结束了
		 * nextLine是键盘录入字符串的方法，可以接收任意类型的方法，但是他凭什么能获取一行呢？
		 * 通过\r\n,只要遇到\r\n就证明一行结束。在这里。如果遇到\r\n，nextLine方法直接就结束了
		 * 
		 * 解决方案：
		 * 1. 创建两个scanner接收不同的数据，但是浪费空间
		 * 2. 将键盘录入的都是字符串，即都用nextLine方法门后面我们会学习将整数字符串转换成整数的方法 
		 */
	}
}
```

### 3. String类的概述
    1. String类的概述
        1. 通过JDK提供的API，查看String类的说明
        2. 可以看到这样的两句话
            1. 字符串字面值"abc"也可以看成一个字符串对象
            2. 字符串是常量，一旦被赋值，就不能被改变
```java
package com.leeup.javase.day12.string;
/**
 * String类的概述
 * @author 李闯
 *
 */
public class Demo1_String {

	/**
	 *  1. 字符串字面值"abc"也可以看成一个字符串对象
     *  2. 字符串是常量，一旦被赋值，就不能被改变
	 * @param args
	 */
	public static void main(String[] args) {
		//相当于Person p = new Person();
		String str = "abc"; 			//abc可以看成一个字符串对象
		System.out.println(str);		//打印对象引用的时候，默认会调用toString方法
										//String重写了toString方法，即输出引用字符为abc
		/**
		 * 这里def也是一个对象实例
		 */
		str = "def";					//当把"def"赋值给了str，原来的str就变成了垃圾，
										//即一旦被赋值就不能被改变
		System.out.println(str);
	}
}
```
### 4. String类的构造方法
    1. 常见构造方法
        1. public String(); 空构造
        2. public String(byte[] bytes); 把字节数组转成字符串
        3. public String(byte[] bytes,int index,int length); 把字节数组的一部分转成字符串
        4. public String(char[] value); 把字符数组转成字符串
        5. public String(char[] value,int index,int count); 把字符数组的一部分转成字符串
        6. public String(String original); 把字符串常量值转成字符串
    2. 案例展示
        1. 演示String类的常见构造方法
```java
package com.leeup.javase.day12.string;
/**
 *  1. public String(); 空构造
    2. public String(byte[] bytes); 把字节数组转成字符串
    3. public String(byte[] bytes,int index,int length); 把字节数组的一部分转成字符串
    4. public String(char[] value); 把字符数组转成字符串
    5. public String(char[] value,int index,int count); 把字符数组的一部分转成字符串
    6. public String(String original); 把字符串常量值转成字符串
 * @author 李闯
 *
 */
public class Demo2_StringCon {

	public static void main(String[] args) {
		//1
		String s1 = new String();//空构造，就是创建一个空字符串
		System.out.println(s1); //空构造默认输出的结果也是空串
		
		//2
		byte[] arr1 = {97,98,99};
		String s2 = new String(arr1);//解码，将计算机读得懂的转换成我们读得懂的
		System.out.println(s2);//输出结果为abc，97，98，99,对应的ASCII表的数值码
		
		//3
		byte[] arr2 = {97,98,99,100,101,102};//把字节数组的一部分转成字符串
		String s3 = new String(arr2,2,3); 
		System.out.println(s3);
		
		//4
		char[] arr3 = {'a','b','c','d','e'};//将字符数组转换成字符串
		String s4 = new String(arr3);
		System.out.println(arr3);
		
		//5
		String s5 = new String(arr3,1,3);//把字符数组的一部分转成字符串
		System.out.println(s5);
		
		//6.
		String s6 = new String("hello");//把字符串常量值转成字符串
		System.out.println(s6);
	}
}
```

### 5. String类的常见面试题
    1. 判断定义为String类型的s1和s2是否相等
        1. String s1 = "abc";
        2. String s2 = "abc";
        3. System.out.println(s1 == s2); 
        4. System.out.println(s1.equals(s2)); 		
    2. 下面这句话在内存中创建了几个对象?
        1. String s1 = new String("abc");			
    3. 判断定义为String类型的s1和s2是否相等
        1. String s1 = new String("abc");			
        2. String s2 = "abc";
        3. System.out.println(s1 == s2);		
        4. System.out.println(s1.equals(s2));
    4. 判断定义为String类型的s1和s2是否相等
        1. String s1 = "a" + "b" + "c";
        2. String s2 = "abc";
        3. System.out.println(s1 == s2);		
        4. System.out.println(s1.equals(s2));
    5. 判断定义为String类型的s1和s2是否相等
        1. String s1 = "ab";
        2. String s2 = "abc";
        3. String s3 = s1 + "c";
        4. System.out.println(s3 == s2);
        5. System.out.println(s3.equals(s2));