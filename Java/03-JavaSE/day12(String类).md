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
![String面试题1](https://github.com/AtomRun/notes/blob/master/noteimages/String%E9%9D%A2%E8%AF%95%E9%A2%981.png)

    2. 下面这句话在内存中创建了几个对象?
        1. String s1 = new String("abc");
![Stgring面试题2](https://github.com/AtomRun/notes/blob/master/noteimages/String%E9%9D%A2%E8%AF%95%E9%A2%982.png)
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
![String面试题5](https://github.com/AtomRun/notes/blob/master/noteimages/String%E9%9D%A2%E8%AF%95%E9%A2%985.png)
```java
package com.leeup.javase.day12.string;

import com.leeup.javase.day11.object.test.Student;

public class Demo3_String {

	public static void main(String[] args) {
		
		//1.
		demo1();	

		
		//2. 
		demo2();
		
		//3. 
		demo3();
		
		//4. 
		demo4();
		
		String s1 = "ab";
	    String s2 = "abc";
	    String s3 = s1 + "c";
	    System.out.println(s3 == s2);
	    System.out.println(s3.equals(s2));
	    /**
	     * 任何数据与字符串用+相连接都会产生新的字符串，字符串串联底层是使用
	     * StringBuilder或者StringBuffer类及append方法实现的，是我们字符串的缓冲区
	     * 即a字符串+1,他会先创建一个StringBuilder对象然后将1转成字符串，放到缓冲区中
	     * 转成字符串，之后使用toString方法再将字符串转换回来就变成了a1，
	     * 
	     * 执行步骤：
	     * 主方法进栈，
	     * String s1 = "ab"; 需要在常量池中创建一个"ab",将地址值赋值给s1
	     * String s2 = "abc"; 需要在常量池中创建一个"abc",将地址值赋值给s2
	     * String s3 = s1 + "c"; 这里属于字符串使用加号和其他数据串联，
	     * 这时候需要在堆中创建一个StringBuffer或者StringBuilder对象。通过append
	     * 方法将ab和c加到一起，但是这个StringBuffer对象也是有地址值的，但是将StringBuffer
	     * 的地址值赋值给s3显然不太合理，所以，调用toString方法，将其重新转成String字符串
	     * toString也是有地址值的，并且将其赋值给s3，
	     * 这个时候s3的地址是堆内存的，s1,s2是常量池的，相比较肯定是false
	     */

	}

	private static void demo4() {
        /**
         * s1==s2 true 
         * 因为在java中有常量优化机制，
         * 例如byte b = 3 + 4; 在编译的时候就已经变成7了，判断7在java的取值范围之内，即编译器帮我们做了这些事
         * 所以a、b、c字符串本身都是字符串常量，在编译的时候本身就是字符串常量
         * 即s2拿abc已经存在了所以两者地址值相同为true
         */
		String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2);		
        System.out.println(s1.equals(s2));
	}

	private static void demo3() {
        /**
         * ==比较的是地址值，而s1得地址值是堆内存的地址值，
         * 而s2得地址值是常量池的地址值所以s1==s2为false
         * s1.equals(s2);s1的值和s2的值相等，为true
         */
		String s1 = new String("abc");			
        String s2 = "abc";
        System.out.println(s1 == s2);		
        System.out.println(s1.equals(s2));
	}

	private static void demo2() {
		/**
		 * 执行步骤：
		 * 主方法进栈，
		 * new String("abc");他也会去常量池中查看是否有abc，
		 * 没有就在常量池中创建一个对象存放"abc"并且也拥有一个地址值
		 * 但是这里是有new关键字的，所以在堆中也创建了一个对象并且有自己的地址值，这个时候常量池
		 * 中的abc拷贝了一份副本赋值给了堆中的对象，堆内存中的对象就将地址值赋值给s1 
		 * 在这里常量池中的abc相当于参数，而堆中的abc相当于常量池中的副本
		 */
		String s1 = new String("abc");
	}

	private static void demo1() {
		/**
		 * 执行步骤：
		 * 主方法进栈， "abc" 会进入常量池，常量池中如果没有abc的话， 他会创建一个，如果
		 * 池子中有，他就不创建了，第一次的String s1 = "abc";他发现没有。就在常量池中
		 * 创建了一个并且将地址值赋值给s1，s1通过地址值找到"abc"
		 * String s2 = "abc";也会去常量池里看一下，如果有的话就不创建了，没有就创建
		 * 他发现有的时候，就将地址值赋值给s2，这样的话，就是了两个引用指向同一个对象，记录的是同一个
		 * 地址值。所以s1==s2为true
		 */
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}
```

### 6. String类的判断功能
	1. String类的判断功能
		1. boolean equals(Object obj):比较字符串的内容是否相同,区分大小写
		2. boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写
		3. boolean contains(String str):判断大字符串中是否包含小字符串
		4. boolean startsWith(String str):判断字符串是否以某个指定的字符串开头
		5. boolean endsWith(String str):判断字符串是否以某个指定的字符串结尾
		6. boolean isEmpty():判断字符串是否为空。
```java
package com.leeup.javase.day12.string;
/**
 * 1. String类的判断功能
		1. boolean equals(Object obj):比较字符串的内容是否相同,区分大小写
		2. boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写
		3. boolean contains(String str):判断大字符串中是否包含小字符串
		4. boolean startsWith(String str):判断字符串是否以某个指定的字符串开头
		5. boolean endsWith(String str):判断字符串是否以某个指定的字符串结尾
		6. boolean isEmpty():判断字符串是否为空。
 * @author 李闯
 *
 */
public class Demo4_StringMethod {

	public static void main(String[] args) {
		demo1();
		
		demo2();
		
		String s1 = "zhongguo";
		String s2 = "";
		String s3 = null;
		System.out.println(s1.isEmpty());
		System.out.println(s2.isEmpty());
		System.out.println(s3.isEmpty());
		/**
		 * NullPointerException 
		 * 引用为空，再使用null调用String的方法，所以他会报异常
		 * 
		 * 空串和null的区别：
		 * "" 是字符串常量，同时也是一个String类的对象，既然是对象当然可以调用String
		 * 类中的方法，
		 * null是空常量，不能调用任何的方法，否则会出现空指针异常，null常量，可以给
		 * 任意的引用数据类型赋值
		 */
	}

	private static void demo2() {
		String s1 = "我爱中国,哈哈";
		String s2 = "中国";
		String s3 = "你以为呢";
		String s4 = "我爱";
		String s5 = "哈哈";
		
		System.out.println(s1.contains(s2));
		System.out.println(s1.contains(s3));//判断是否包含传入的字符串
		System.out.println("============");
		
		System.out.println(s1.startsWith(s4));//判断是否以传入的字符串开头
		System.out.println(s1.startsWith(s5));
		System.out.println("============");
		System.out.println(s1.endsWith(s4));//判断是否以传入的字符串结尾
		System.out.println(s1.endsWith(s5));
		System.out.println("============");
	}

	private static void demo1() {
		String s1 = "lichuang";
		String s2 = "lichuang";
		String s3 = "Lichuang";
		
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));//false，区分大小写
		
		System.out.println("============");
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1.equalsIgnoreCase(s3));//都为true，不区分大小写
		
		System.out.println("============");
	}
}
```
### 7. 模拟用户登录
	1. 案例演示
		1. 需求：模拟登录,给三次机会,并提示还有几次。
		2. 用户名和密码都是admin

```java
package com.leeup.javase.day12.test;

import java.util.Scanner;

/**
 * 	1. 案例演示
		1. 需求：模拟登录,给三次机会,并提示还有几次。
		2. 用户名和密码都是admin
		
		分析：
		1. 模拟登录，需要键盘录入，Scanner
		2. 給三次机会，需要循环，for
		3. 并提示有几次，需要判断，if
 * @author 李闯
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	//创建键盘录入对象
		for (int i = 0; i < 3; i++) {
		System.out.println("请输入用户名：");
		String userName = scanner.nextLine();		//键盘录入的用户名存储到userName中
		System.out.println("请输入密码：");
		String userPwd = scanner.nextLine();		//键盘录入的密码存储到userPwd中
		
		//如果是字符串常量和字符串变量比较，通常都是用字符串常量调用方法，将变量当作
		//变量传递，当作空指针异常
			if ("admin".equals(userName) && "admin".equals(userPwd)) {
				System.out.println("恭喜"+userName+"，登录成功");
				break;//登录成功跳出循环
			}else {
				if (i==2) {
					System.out.println("您的错误次数已到上限，请明天再来");
				}else {
					System.out.println("很抱歉，您的用户名或密码错误，您还有"+ (2-i) +"次登录机会");
				}
			}
		}
	}
}
```

### 8. String类的获取功能
	1. String类的获取功能
		1. int length():获取字符串的长度。
		2. char charAt(int index):获取指定索引位置的字符
		3. int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。
		4. int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引。
		5. int indexOf(int ch,int fromIndex):返回指定字符在此字符串中从指定位置后第一次出现处的索引。
		6. int indexOf(String str,int fromIndex):返回指定字符串在此字符串中从指定位置后第一次出现处的索引。
		7. lastIndexOf
		8. String substring(int start):从指定位置开始截取字符串,默认到末尾。
		9.  String substring(int start,int end):从指定位置开始到指定位置结束截取字符串。

```java
package com.leeup.javase.day12.string;

import com.sun.javafx.binding.StringFormatter;

/**
1. int length():获取字符串的长度。
2. char charAt(int index):获取指定索引位置的字符
3. int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。
4. int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引。
5. int indexOf(int ch,int fromIndex):返回指定字符在此字符串中从指定位置后第一次出现处的索引。
6. int indexOf(String str,int fromIndex):返回指定字符串在此字符串中从指定位置后第一次出现处的索引。
7. lastIndexOf
8. String substring(int start):从指定位置开始截取字符串,默认到末尾。
9. String substring(int start,int end):从指定位置开始到指定位置结束截取字符串。
 * @author 李闯
 *
 */
public class Demo5_StringMethod {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
//		demo4();
		
//		demo5();
		
//		demo6();
		
		//面试题
		String string = "woaizhongguo";
		string.substring(4);
		System.out.println(string);
		/**
		 * String类型一旦初始化就不会被改变，因为string中记录的woaizhongguo
		 * subString会产生新字符串，需要将新的字符串记录
		 * subString中修改的并没有赋值输出，而打印的还是string，这是一个陷阱
		 */
		 
	}

	private static void demo6() {
		String s1 = "zhongguoniubi";
		String s2 = s1.substring(5);
		System.out.println(s2);
		
		String s3 = s1.substring(0, 4);//包含头，不包含尾，左闭右开
		System.out.println(s3);
	}

	private static void demo5() {
		String s1 = "woaizhongguo";
		int index = s1.indexOf('g', 1);	//从指定位置开始向后找
		System.out.println(index);
		
		//从后向前找，第一次出现的字符
		int index2 = s1.lastIndexOf('a');
		System.out.println(index2);
		
		int index3 = s1.lastIndexOf('a', 3);
		System.out.println(index3);
	}

	private static void demo4() {
		String s1 = "zhong";
		
		int index = s1.indexOf("ng");//获取字符串中第一个字符出现的位置
		System.out.println(index);
		
		int index2 = s1.indexOf("a");
		System.out.println(index2);
	}

	private static void demo3() {
		String s1 = "zhongguo";
		int index = s1.indexOf('z');//参数接受的时int类型的，传递char类型的会自动提升
		System.out.println(index);
		
		int index2 = s1.indexOf('i');//如果不存在返回就是-1
		System.out.println(index2);
	}

	private static void demo2() {
		//根据字符索引获取对应位置的字符
		String s1 = "你好啊，哈哈？";
		char c1  = s1.charAt(3);
		System.out.println(c1);
		
		//会出现字符串索引越界异常
		char c2  = s1.charAt(10);
		System.out.println(c2);
	}

	private static void demo1() {
		int [] arr = {11,22,33};
		System.out.println(arr.length);//数组中的length是属性吗，没有括号
		
		String s1 = "zhongguo";
		String s2 = "中,国?";
		System.out.println(s1.length());
		System.out.println(s2.length());//length() 是一个方法，获取的是每一个字符的个数
	}
}
```

### 9. 字符串的遍历
	1. 案例演示
		1. 字符串的遍历
```java
package com.leeup.javase.day12.test;

public class Test2 {

	public static void main(String[] args) {
		String string = "zhongguo";
		
		for (int i = 0; i < string.length(); i++) { //通过for循环，获取到字符串的每个字符的索引
			//通过索引获取每个元素
//			char c = string.charAt(i);
//			System.out.println(c);
			
			System.out.println(string.charAt(i));	//通过索引获取每个字符，
		}
	}
}

```

### 10. 统计不同类型字符个数
	1. 案例演示
		1. 需求：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数,其他字符出现的次数。
		2. ABCDEabcd123456!@#$%^
```java
package com.leeup.javase.day12.test;
/**
 * 	1. 案例演示
		1. 需求：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数,其他字符出现的次数。
		2. ABCDEabcd123456!@#$%^
	1. 分析
		字符串都是由字符组成的，而字符的值都是有范围的，例如小a字符到小c字符，ASCII码表，
		通过范围，来判断是否包含该字符，如果包含，就让计数器变量自增
 * @author 李闯
 *
 */
public class Test3 {

	public static void main(String[] args) {
		String string = "ABCDEabcd123456!@#$%^";
		
		//定义计数器
		int big = 0;
		int small = 0;
		int num = 0;
		int other = 0;
		
		//1， 获取每个 字符,通过for循环遍历
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);//通过索引获取每个字符
			//2，判断字符是否在这个范围内
			if (c>='A' && c<= 'Z') {
				//大写字母
				big ++;//如果满足是大写字母，就让其对应的变量自增
			}else if(c >='a' && c<='z') {
				small++;
			}else if(c > '0' && c <= '9') {
				num++;
			}else {
				other++;
			}
		}
		//3，打印每个计数器的结果
		System.out.println("字符串中大写字母有："+big+"个，小写字母有"+small+"个，数字有"+num+"个，其他字符有"
		+other+"个");
	}
}
```

### 11. String类的转换功能
	1. String的转换功能：
		1. byte[] getBytes():把字符串转换为字节数组。
		2. char[] toCharArray():把字符串转换为字符数组。
		3. static String valueOf(char[] chs):把字符数组转成字符串。
		4. static String valueOf(int i):把int类型的数据转成字符串。
			1. 注意：String类的valueOf方法可以把任意类型的数据转成字符串

		5. String toLowerCase():把字符串转成小写。(了解)
		6. String toUpperCase():把字符串转成大写。
		7. String concat(String str):把字符串拼接。
```java
package com.leeup.javase.day12.string;
/**
 * * A:String的转换功能：
	* byte[] getBytes():把字符串转换为字节数组。
	* char[] toCharArray():把字符串转换为字符数组。
	* static String valueOf(char[] chs):把字符数组转成字符串。
	* static String valueOf(int i):把int类型的数据转成字符串。
		* 注意：String类的valueOf方法可以把任意类型的数据转成字符串

	* String toLowerCase():把字符串转成小写。(了解)
	* String toUpperCase():把字符串转成大写。
	* String concat(String str):把字符串拼接。
 * @author 李闯
 *
 */
public class Demo6_StringMethod {
  
	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
		demo4();
	}

	private static void demo4() {
		//都变成大写或者小写
		String s1 = "ZhongGuoJiaYou";
		String s2 = "WoshicHengXuYuan";
		
		String s3 = s1.toLowerCase();
		String s4 = s2.toUpperCase();
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s3+s4);
		
		//字符串拼接,用+号拼接字符串更强大，可以用字符串与任意类型相加，而concat方法调用的和传入的都必须是字符串
		System.out.println(s3.concat(s4));
	}

	private static void demo3() {
		char [] arr = {'a','b','c'};
		String s = String.valueOf(arr);		//底层是由String类的构造方法完成的
		System.out.println(s);
		
		String s2 = String.valueOf(100);
		System.out.println(s2 + 100);
		
		
		Person person = new Person("张三",23);
		System.out.println(person);
		String s3 = String.valueOf(person);//相当于调用了person的toString方法
		System.out.println(s3);
	}

	private static void demo2() {
		//将字符串转换为字符数组
		String s1 = "zhongguo";
		char[] arr = s1.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}

	private static void demo1() {
		String s1 = "abc";
		byte [] arr = s1.getBytes();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");//结果97 98 99，对应的ASCII码表，ASCII码表囊括在其他码表内的
		}
		
		String s2 = "你好你好"; 
		byte[] arr2 = s2.getBytes();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+" ");//一堆负数，通过UTF-8码表[工作空间的默认编码]，将字符串转换成字节数组
			//将我们看得懂的转换为计算机看得懂的
		}
	}
}
```

### 12. 按要求转换字符 链式编程掌握
	1. 案例演示
		1. 需求：把一个字符串的首字母转成大写，其余为小写。(只考虑英文大小写字母字符)
```java
package com.leeup.javase.day12.test;
/**
 * 	1. 案例演示
		1. 需求：把一个字符串的首字母转成大写，其余为小写。(只考虑英文大小写字母字符)
		
	链式编程：只要保证每次调用完方法返回的是对象，就可以继续调用
 * @author 李闯
 *
 */
public class Test4 {
	public static void main(String[] args) {
		String string = "woAiZUguoniNE";
		String s2 = string.substring(0,1).toUpperCase().concat(string.substring(1)
				.toLowerCase());
		System.out.println(s2);
		
	}
}
```

### 13. 把数组转成字符串
	1. 案例演示
		1. 需求：把数组中的数据按照指定个格式拼接成一个字符串
		2. 举例：
				int[] arr = {1,2,3};	
			输出结果：
				"[1, 2, 3]"
```java
package com.leeup.javase.day12.test;
/**
1. 案例演示
	1. 需求：把数组中的数据按照指定个格式拼接成一个字符串
	2. 举例：
			int[] arr = {1,2,3};	
		输出结果：
			"[1, 2, 3]"
			
		分析：
		1. 需要定义一个字符串"["
		2. 遍历数组，获取每一个元素
		3. 用字符串与数组中的元素进行拼接
 * @author 李闯
 *
 */
public class Test5 {

	public static void main(String[] args) {
		int [] arr = {1,2,3};
		String s = "[";	//定义一个字符串用来与数组中元素拼接
		
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length-1) {
				s = s +arr[i]+ "]";
			}else {
				s = s + arr[i] + ", ";		
			}
		}
		System.out.println(s);
	}
}
```

### 14. String类的其他功能
	1. String的替换功能及案例演示
		1. String replace(char old,char new)
		2. String replace(String old,String new)
	2. String的去除字符串两空格及案例演示
		1. String trim()
	3. String的按字典顺序比较两个字符串及案例演示
		1. int compareTo(String str)(暂时不用掌握)
		2. int compareToIgnoreCase(String str)(了解)

```java
package com.leeup.javase.day12.string;
/**
1. String的替换功能及案例演示
	1. String replace(char old,char new)
	2. String replace(String old,String new)
2. String的去除字符串两空格及案例演示
	1. String trim()
3. String的按字典顺序比较两个字符串及案例演示
	1. int compareTo(String str)(暂时不用掌握)
	2. int compareToIgnoreCase(String str)(了解)
 * @author 李闯
 *
 */
public class Demo7_Method {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
		String s1 = "heima";
		String s2 = "HEIMA";
		int num = s1.compareTo(s2);
		System.out.println(num);
	
		int num2 = s1.compareToIgnoreCase(s2);//不区分大小写
		System.out.println(num2);
		/**
		 *         public int compare(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    c1 = Character.toUpperCase(c1);		//将c1字符转成大写
                    c2 = Character.toUpperCase(c2);		//将c2字符转成大写
                    if (c1 != c2) {
                        c1 = Character.toLowerCase(c1);	//将c1字符转成小写
                        c2 = Character.toLowerCase(c2); //将c2字符转成小写
                        if (c1 != c2) {
                            // No overflow because of numeric promotion
                            return c1 - c2;
                        }
                    }
                }
            }
            return n1 - n2;
        }
		 */
		
	}

	private static void demo3() {
		String s1 = "abc";
		String s2 = "bcd";
		
		int num = s1.compareTo(s2);
		System.out.println(num);//输出结果-1 。a值97，b值98，97-98结果-1。如果字符串第一个字符相等，就依次比较后面的
		
		String s3 = "a";
		String s4 = "aaaa";
		int num2 = s3.compareTo(s4);
		System.out.println(num2);//输出杰结果-3，当字符都相等时，按照长度比较
	}

	private static void demo2() {
		String s1 = "   zhong   guo   ";
		String s2 = s1.trim();
		System.out.println(s2);
	}

	private static void demo1() {
		String s1 = "zhongguo";//想把z改成c
		String s2 = s1.replace('z','c');//如果第一个参数在s1字符串中没有的话，输出的结果还是原本的结果
		System.out.println(s2);
		
		String s3 = s1.replace("on", "uo");
		System.out.println(s3);
	}
}
```

### 15. 字符串反转
	1. 案例演示
	2. 需求：把字符串反转
		1. 举例：键盘录入"abc"		
		2. 输出结果："cba"
```java
package com.leeup.javase.day12.test;

import java.util.Scanner;

/**
1. 案例演示
2. 需求：把字符串反转
	1. 举例：键盘录入"abc"		
	2. 输出结果："cba"
	
	分析：
	1. 通过键盘录入获取字符串Scanner
	2. 将字符串转换成字符数组
	3. 倒着遍历字符数组，并在此拼接成字符串
	4. 打印

 * @author 李闯
 *
 */
public class Test6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入字符串");
		String line = scanner.nextLine();		//将键盘录入字符串存储在line中
		char[] arr = line.toCharArray();		//将字符串转换成字符数组
		
		String string = "";
		for (int i = arr.length-1; i >=0 ; i--) {	//倒着遍历字符数组
			string = string+arr[i];				//拼接成字符串
		}
		System.out.println(string);
	}
}

```

### 16. 在大串中查找小串出现的次数思路图解
	1. 画图演示
	2. 需求：统计大串中小串出现的次数
		1. 这里的大串和小串可以自己根据情况给出
![大串中查找小串图解](https://github.com/AtomRun/notes/blob/master/noteimages/%E5%A4%A7%E4%B8%B2%E4%B8%AD%E8%8E%B7%E5%8F%96%E5%B0%8F%E4%B8%B2%E7%9A%84%E6%AC%A1%E6%95%B0.png)

### 17. 在大串中查找小串出现的次数代码实现
	1. 案例演示	
		1. 统计大串中小串出现的次数
```java
package com.leeup.javase.day12.test;
/**
1. 画图演示
2. 需求：统计大串中小串出现的次数
	1. 这里的大串和小串可以自己根据情况给出
 * @author 李闯
 *
 */
public class Test7 {

	public static void main(String[] args) {
		//定义大串
		String max = "woaizhongguo,zhongguoaiwo,wulunzhongguoznemeyang,tadoushiwomendeguojia";
		//定义小串
		String min = "zhongguo";
		
		//定义计数器变量
		int count = 0;
		//定义索引
		int index = 0;
		//定义循环，判断小串是否在大串中出现
		while((index = max.indexOf(min)) != -1) {	//不是-1就表示小串没在大串中出现
			count++;								//计算器自增
			max = max.substring(index + min.length());//对新字符串进行截取
		}
		System.out.println(count);
	}
}

```

### 18. day12总结
	1. 把今天的知识点总结一遍。