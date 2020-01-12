## 正则表达式和常用工具类

### 1. 正则表达式的概述和简单使用
    1. 正则表达式
        1. 是指一个用来描述或者匹配一系列符合某个语法规则的字符串的单个字符串。其实就是一种规则。有自己特殊的应用。
        2. 作用:比如注册邮箱,邮箱有用户名和密码,一般会对其限制长度,这个限制长度的事情就是正则表达式做的
    2. 案例演示
        1. 需求：校验qq号码.
            1. :要求必须是5-15位数字
            2. 2:0不能开头
            3. 3:必须都是数字
        2. 非正则表达式实现
        3. 正则表达式实现
```java
package com.leeup.javase.day regex;

import java.util.Scanner;

/**
1. 需求：校验qq号码.
    1. :要求必须是5-15位数字
    2. :0不能开头
    3. :必须都是数字
    
    校验QQ：
    1. 明确返回值类型boolean
    2. 明确参数列表String qq
    
2. 非正则表达式实现
3. 正则表达式实现
 * @author 李闯
 *
 */
public class Demo1_Regex {

	public static void main(String[] args) {
		
//		System.out.println(check("012135432"));
//		System.out.println(check("a12135432"));
//		System.out.println(check("12135432"));
//		System.out.println(check("1213541231231232"));
		
		String regex = "[1-9]\\d{4,14}";
		System.out.println("12312312".matches(regex));
	}
	
	public static boolean check(String qq) {
		
		boolean flag = true;	//定义标记，如果校验QQ不符合要求，就把flag置为false，符合的话直接返回
		if (qq.length()>=5 && qq.length()<=15) {
			//符合长度要求
			if (!qq.startsWith("0")) {
				//不是以0开头，即符合要求
				char [] arr = qq.toCharArray();		  //将字符串转为字符数组遍历其中的每个字符查看是否都是数字
				for (int i = 0; i < arr.length; i++) {
					char ch = arr[i];				//记录每个字符
					if (!(ch>='0' && ch<= '9')) {
						System.out.println("您的QQ号中含有字母");
						flag =false;
						break;
						//不在0-9范围内，即不是数字
					}
				}
			}else {
				flag = false;
				System.out.println("您的QQ以0开头，不符合QQ标准");
			}
		}else {
			flag = false;
			System.out.println("您的QQ号长度不符合要求");
		}
		
		return flag;
	}
}
```

### 2. 字符类演示
    1. 字符类
        1. [abc] a、b 或 c（简单类） 
        2. [^abc] 任何字符，除了 a、b 或 c（否定） 
        3. [a-zA-Z] a到 z 或 A到 Z，两头的字母包括在内（范围） 
        4. [0-9] 0到9的字符都包括
```java
package com.leeup.javase.day regex;

public class Demo2_Regex {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
//		demo4();
		
//		demo5();
		
//		demo6();
		
//		demo7();
		
	}

	private static void demo7() {
		String regex = "[a-z&&[^m-p]]";
		System.out.println("A".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("m".matches(regex));
		System.out.println("n".matches(regex));
		System.out.println("o".matches(regex));
		System.out.println("p".matches(regex));
		System.out.println("q".matches(regex));
	}

	private static void demo6() {
		String regex = "[a-z&&[^bc]]";
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("e".matches(regex));
		System.out.println("f".matches(regex));
		System.out.println("g".matches(regex));
	}

	private static void demo5() {
		String regex = "[a-z&&[def]]";			//取交集
		System.out.println("a".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("z".matches(regex));
		System.out.println("c".matches(regex));
	}

	private static void demo4() {
		String regex = "[a-d[m-p]]";
		System.out.println("a".matches(regex));
		System.out.println("m".matches(regex));
		System.out.println("n".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("z".matches(regex));
	}

	private static void demo3() {
		String regex = "[a-zA-z]";
		System.out.println("a".matches(regex));
		System.out.println("A".matches(regex));
		System.out.println("z".matches(regex));
		System.out.println("Z".matches(regex));
		System.out.println("1".matches(regex));
		System.out.println("%".matches(regex));
	}

	private static void demo2() {
		String regex = "[^abc]";
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("1".matches(regex));
		System.out.println("%".matches(regex));
		System.out.println("10".matches(regex));//false,[] 代表单个字符，然而10代表字符和0字符
	}

	private static void demo1() {
		String regex = "[abc]";		//[] 代表单个字符
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("1".matches(regex));
		System.out.println("%".matches(regex));
	}
}
```

### 3. 预定义字符类演示
    1. 预定义字符类
        1. . 任何字符。
            1. \d 数字：[0-9]
            2. \D 非数字：[^0-9]
            3. \S 空白字符：[\t\n\x0B\f\r]
            4. \S 非空白字符：[^\S]
            5. \W 单词字符：[a-zA-Z_0-9]
            6. \W 非单词字符：[^\W]
```java
package com.leeup.javase.day regex;
/**
    1. \d 数字：[0-9]
    2. \D 非数字：[^0-9]
    3. \s 空白字符：[ \t\n\x0B\f\r]	  \t指的是table键，\n指的是会按行，\x0B在dos命令的时候有垂直制表符和水平制表符，\x0B属于垂直制表符
    								\f 翻页，\r回车,\n换行
    4. \S 非空白字符：[^\S]
    5. \w 单词字符：[a-zA-Z_0-9]
    6. \W 非单词字符：[^\W]
 * @author 李闯
 *
 */
public class Demo3_regex {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
//		demo4();
		
//		demo5();
		
//		demo6();
		
		demo7();
	}

	private static void demo7() {
		String regex = "\\W";
		System.out.println("a".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("_".matches(regex));
		System.out.println("+".matches(regex));
		System.out.println("%".matches(regex));
	}

	private static void demo6() {
		String regex = "\\w";
		System.out.println("a".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("_".matches(regex));
		System.out.println("+".matches(regex));
		System.out.println("%".matches(regex));
	}

	private static void demo5() {
		String regex = "\\S";
		System.out.println("a".matches(regex));
		System.out.println(" ".matches(regex));
		System.out.println("	".matches(regex));//tab键
		System.out.println("    ".matches(regex));//四个空格
	}

	private static void demo4() {
		String regex = "\\s";
		System.out.println(" ".matches(regex));
		System.out.println("	".matches(regex));	//一个tab键
		System.out.println("    ".matches(regex));	//四个空格
	}

	private static void demo3() {
		String regex = "\\D";
		System.out.println("a".matches(regex));
		System.out.println("0".matches(regex));
		System.out.println("9".matches(regex));
	}

	private static void demo2() {
		String regex = "\\d";		//反斜线代表转义字符，如果想表示\d的话，需要\\d
		System.out.println("0".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("9".matches(regex));
	}

	private static void demo1() {
		String regex = ".";
		System.out.println("a".matches(regex));
		System.out.println("ab".matches(regex));//代表任意字符，因为只有一个. /所以两个字符不行
	}
}
```
### 4. 数量词
    1. Greedy 数量词 
        1. X? X，一次或一次也没有
        2. X* X，零次或多次
        3. X+ X，一次或多次
        4. X{n} X，恰好 n 次 
        5. X{n,} X，至少 n 次 
        6. X{n,m} X，至少 n 次，但是不超过 m 次 
```java
package com.leeup.javase.day regex;


/**
 1. Greedy 数量词 
    1. X? X，一次或一次也没有
    2. X* X，零次或多次
    3. X+ X，一次或多次
    4. X{n} X，恰好 n 次 
    5. X{n,} X，至少 n 次 
    6. X{n,m} X，至少 n 次，但是不超过 m 次 
 * @author 李闯
 *
 */
public class Demo4_Regex {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
//		demo4();
		
//		demo5();
		
		String regex = "[abc]{5,15}";
		System.out.println("abcc".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("abcacabcbba".matches(regex));
		System.out.println("abcacabcbbacac".matches(regex));
 	}

	private static void demo5() {
		String regex = "[abc]{5,}";//最少5次,5次到无穷大
		System.out.println("abcc".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("abcacabcbba".matches(regex));
	}

	private static void demo4() {
		String regex = "[abc]{5}";
		System.out.println("abcac".matches(regex));
		System.out.println("abcacabcbba".matches(regex));
		System.out.println("abca".matches(regex));
	}

	private static void demo3() {
		String regex = "[abc]+";
		System.out.println("".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("abcbabca".matches(regex));
	}

	private static void demo2() {
		String regex = "[abc]*";
		System.out.println("".matches(regex));
		System.out.println("abc".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("ababc".matches(regex));
		System.out.println("abcabcabc".matches(regex));
	}

	private static void demo1() {
		String regex = "[abc]?";
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("".matches(regex));	//一次也没有
	}
}
```
### 5. 正则表达式的分割功能
    1. 正则表达式的分割功能
        1. String类的功能：public String[] split(String regex)
    2. 案例演示
        1. 正则表达式的分割功能
```java
package com.leeup.javase.day regex;
/**
 * 正则表达式的分割功能
 * 通过正则表达式切割字符串
 * @author 李闯
 *
 */
public class Demo5_Spilit {

	public static void main(String[] args) {
		String s1 = "金三胖 郭美美 李dayone";
		String s2 = "金三胖.郭美美.李dayone";
		
		String[] arr = s1.split("\\.");
		/**
		 * 在这里.代表任意字符，当s2进来的时候，金就被分割，后面的每个字都会匹配都被分割了，相当于什么都没得到
		 * 如果非要用.分割，我们需要转义即 \\.
		 */
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

```

### 6. 把给定字符串中的数字排序
    1. 案例演示
        1. 需求：我有如下一个字符串:”91 27 46 38 50”，请写代码实现最终输出结果是：”27 38 46 50 91”
```java
package com.leeup.javase.day test;

import java.util.Arrays;

/**
  1. 案例演示
     1. 需求：我有如下一个字符串:"91 27 46 38 50"，请写代码实现最终输出结果是："27 38 46 50 91"
     
     分析：
     1. 将字符串切割成字符串数组，切割成字符串数组，就可以拿到里面的每个字符元素
     2. 将字符串转换为数字并且将其存储在一个等长度的int数组中 [与字符串数组长度相同]
     3. 排序
     4. 将排序后的结果遍历并拼接成一个字符串
 * @author 李闯
 *
 */
public class Test1 {

	public static void main(String[] args) {
		String s = "91 27 46 38 50";
		//1. 将字符串切割成字符串数组
		String[] sArr = s.split(" ");//根据空格切割
		//2. 将字符串转换为数字并且将其存储在一个等长度的int数组中(与字符串数组长度相同)
		int[] arr = new int[sArr.length];
		for (int i = 0; i < arr.length; i++) {
//			arr[i] = sArr[i];		//直接将字符数组元素赋值给int元素不行，需要转换
			arr[i] = Integer.parseInt(sArr[i]);	//将数字字符串转换为数字
		}
		//3.排序
		Arrays.sort(arr);
		//遍历并且拼接字符串,下面这种方式使用String会产生很多垃圾，
		//每次相加，之前的字符串就会变成垃圾
		/**String str = "";
		for (int i = 0; i < arr.length; i++) {
			if (i==arr.length-1) {				//当i等于最大索引
				str = str + arr[i];				//27 38 46 50 91
			}else {
				str = str +arr[i]+" ";			//27 38 46 50 
			}
		}
		System.out.println(str);
		
		*/
		//使用StringBuilder做
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i==arr.length-1) {				
				sb.append(arr[i]);
			}else {
				sb.append(arr[i]+ " ");
			}
		}
		System.out.println(sb);
	}
}
```

### 7. 正则表达式的替换功能
    1. 正则表达式的替换功能
        1. String类的功能：public String replaceAll(String regex,String replacement)
    2. 案例演示
        1. 正则表达式的替换功能
```java
package com.leeup.javase.day regex;
/**
 * 正则表达式的替换功能
 * 	String类的功能：public String replaceAll(String regex,String replacement)
 * @author 李闯
 *
 */
public class Demo6_Regex {

	public static void main(String[] args) {
		String s1 = "wo1ai2zhongguo";
		String regex = "\\d";		//  \\d代表的是任意数字
		String s2 = s1.replaceAll(regex, "");
		
		System.out.println(s2);
	}
}
```

### 8. 正则表达式的分组功能
    1. 正则表达式的分组功能
        1. 捕获组可以通过从左到右计算其开括号来编号。例如，在表达式 ((A)(B(C))) 中，存在四个这样的组： 

		1     ((A)(B(C))) 
		2     (A 
		3     (B(C)) 
		4     (C) 
	
		组零始终代表整个表达式。
    1. 案例演示
        1. 切割
		    需求：请按照叠词切割： "sdqqfgkkkhjppppkl";
        2. 替换
		    需求：我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程
		    将字符串还原成:“我要学编程”。
```java
package com.leeup.javase.day regex;
/**
 * 正则表达式的分组功能 
 * @author 李闯
 *
 */
public class Demo7_regex {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
		/**
		   2. 替换
		    需求：我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程
		    将字符串还原成:“我要学编程”。
		 */
		String s = "我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程";
		String s2 = s.replaceAll("\\.+", "");
		String s3 = s2.replaceAll("(.)\\1+", "$1");//$1获取到第一组的数据，把整个这串替换掉
		System.out.println(s3);
	}

	private static void demo2() {
		//需求：按照切割：sdqqfgkkkhjppppkl
		String s = "sdqqfgkkkhjppppkl";
		String regex = "(.)\\1+";				//+号代表第一组出现一次到多次
		String [] arr = s.split(regex);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void demo1() {
		//叠词正则，比如：快快乐乐，高高兴兴
		
		String regex = "(.)\\1(.)\\2";		//\\1代表第一组又出现了一次,\\2代表第二组再出现一次
		System.out.println("快快乐乐".matches(regex));
		System.out.println("快乐乐乐".matches(regex));
		
		//叠词 死啦死啦，高兴高兴
		
		String regex2 = "(..)\\1";
		System.out.println("高兴高兴".matches(regex2));
		System.out.println("快快乐乐".matches(regex2));
	}
}
```
### 9. Pattern和Matcher的概述
    1. Pattern和Matcher的概述
    2. 模式和匹配器的典型调用顺序
        1. 通过JDK提供的API，查看Pattern类的说明
        2. 典型的调用顺序是 
            1. Pattern p = Pattern.compile("a*b");
            2. Matcher m = p.matcher("aaaaab");
            3. boolean b = m.matches();
```java
package com.leeup.javase.day14.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo8_Pattern {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("a*b");		//获取到正则表达式，这里a*b表明a出现一次或者多次然后就是一个b
		Matcher m = p.matcher("aaaaaab");		//通过刚刚给我的数据，返回一个匹配器，即看这个字符串是否能拿这个正则匹配上
		boolean b = m.matches();				//看是否能匹配上，匹配就返回true,否则就是false
		
		
		System.out.println(b);
		//上面代码其实就是如下
		System.out.println("aaaaab".matches("a*b"));
		
	}
}
```

### 10. 正则表达式的获取功能
    1. 正则表达式的获取功能
        1. Pattern和Matcher的结合使用
    2. 案例演示
        1. 需求：把一个字符串中的手机号码获取出来
```java
package com.leeup.javase.day14.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  1. 正则表达式的获取功能
        1. Pattern和Matcher的结合使用
    2. 案例演示
        1. 需求：把一个字符串中的手机号码获取出来
 * @author 李闯
 *
 */
public class Demo9_Test {

	public static void main(String[] args) {
		String s = "我的手机号码是18933561234,曾经用过12345678906,还用过19029450000";
		String regex = "1[0-9]\\d{9}";//手机号码的正则表达式
		/*Pattern p = Pattern.compile(regex);	
		Matcher m = p.matcher(s);		
		boolean b = m.matches();
		
		System.out.println(b);*/
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		
//		boolean b = m.find();
//		System.out.println(b);
//		
//		String s1 = m.group();
//		System.out.println(s1);
		
		while (m.find())
			System.out.println(m.group());
	}
}
```

### 11. Math类概述和方法使用
    1. Math类概述
        1. Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。 
    2. 成员方法
        1. public static int abs(int a)
        2. public static double ceil(double a)
        3. public static double floor(double a)\
        4. public static int max(int a,int b) min自学
        5. public static double pow(double a,double b)
        6. public static double random()
        7. public static int round(float a) 参数为double的自学
        8. public static double sqrt(double a)
```java
package com.leeup.javase.day14.otherclass;

public class Demo1_Math {

	public static void main(String[] args) {
		 System.out.println(Math.PI);		//Π
		 System.out.println(Math.abs(-345));//取绝对值
		 //ceil 天花板的意思， 向上取整
		 System.out.println(Math.ceil(12.3));//结果是double数
		 System.out.println(Math.ceil(12.99));
		 
		 //floor 地板，向下取整
		 System.out.println(Math.floor(12.3));//结果是double数
		 System.out.println(Math.floor(12.99));
		 
		 //获取两个值中的最大值
		 System.out.println(Math.max(12, 13));
		 
		 //前面的是底数，后面的数是底数
		 System.out.println(Math.pow(2, 3));//  2.0^3.0
		 
		 //生成0.0到1.0之间的随即小数，包括0.0.不包括1.0
		 System.out.println(Math.random());
		 
		 //四舍五入
		 System.out.println(Math.round(12.3f));
		 System.out.println(Math.round(12.9f));
		 
		 //根号2，根号4
		 System.out.println(Math.sqrt(4));
		 System.out.println(Math.sqrt(2));
	}
}
```

### 12. Random类的概述和方法使用
	1. Random类的概述
		1. 此类用于产生随机数如果用相同的种子创建两个 Random 实例，
		2. 则对每个实例进行相同的方法调用序列，它们将生成并返回相同的数字序列。
	2. 构造方法
		1. public Random()
		2. public Random(long seed)
	3. 成员方法
		1. public int nextInt()
		2. public int nextInt(int n)(重点掌握)

```java
package com.leeup.javase.day14.otherclass;

import java.util.Random;

public class Demo2_Random {

	public static void main(String[] args) {
		Random r = new Random();
		int x = r.nextInt();
//		System.out.println(x);//在int范围内生成的随机数
		System.out.println(r.nextInt(100));//即取0-99之间的随机数，有奥求掌握，生成0-n-1范围内的随机数，包含0不包含n
		
		Random r2 = new Random(1000);//纳秒值
		int a = r2.nextInt();
		int b = r2.nextInt();
		System.out.println(a);
		System.out.println(b);//以上面1000的种子值进行计算而来
		/**
		 * 输出结果a:-1244746321和b:1060493871
		 * 因为在new Random参数中写的是1000，
		 */
		
	}
}
```

### 13. System类的概述和方法使用
	1. System类的概述
		1. System 类包含一些有用的类字段和方法。它不能被实例化。 
	2. 成员方法
		1. public static void gc()
		2. public static void exit(int status)
		3. public static long currentTimeMillis()
		4. pubiic static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
	3. 案例演示
		1. System类的成员方法使用

```java
package com.leeup.javase.day14.otherclass;
/**
 * System类概述
 * @author 李闯
 *
 */
public class Demo3_System {

	public static void main(String[] args) {
		
//		demo1();
		
//		demo2();

//		demo3();
		
		demo4();
		
	}

	private static void demo4() {
		//应用场景：集合的底层是用数组来做的，集合的长度是可变的，
		//比如本来是十个长度的数组，这十个装满了之后，他就再创建一个1.5倍大小的数组
		//即容量为15个长度的数组，然后使用这个方法将原数组的元素拷贝到新数组中来
		int [] src = {11,22,33,44,55};
		int [] dest = new int[8];
		for (int i = 0; i < dest.length; i++) {
			System.out.println(dest[i]);
		}
		//将src的内容拷贝到dest中，使用System的方法
		System.arraycopy(src, 0, dest, 0, src.length);
		for (int i = 0; i < dest.length; i++) {
			System.out.println(dest[i]);
		}
	}

	private static void demo3() {
		long start = System.currentTimeMillis();//一秒等于1000毫秒
		for (int i = 0; i < 1000; i++) {
			System.out.println("***");
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

	private static void demo2() {
		System.exit(0);//非0状态时异常终止，退出jvm
		System.out.println("hahah");//该语句不会输出
	}

	private static void demo1() {
		//为了产生垃圾，使用循环创建多个对象，但是100个对象，垃圾回收机制仍然不会 自动清理，下面我们呼喊他过来回收
		for (int i = 0; i < 100; i++) {
			new Demo();
			System.gc();//运行垃圾回收器，相当于呼喊"保洁阿姨"，即垃圾回收器
		}
	}
}

class Demo {//一个源文件中部允许出现两个public类因为，他会抢占公共资源，

	
	//该方法不是我们手动调用的，当垃圾产生一定数量的时候，它会执行
	@Override
	protected void finalize() throws Throwable {
		System.out.println("垃圾被清扫了");
		
	}
}
```

### 14. BigInteger类的概述和方法使用
	1. BigInteger的概述
		1. 可以让超过Integer范围内的数据进行运算
	2. 构造方法
		1.  public BigInteger(String val)
	3. 成员方法
		1. public BigInteger add(BigInteger val)
		2. public BigInteger subtract(BigInteger val)
		3. public BigInteger multiply(BigInteger val)
		4. public BigInteger divide(BigInteger val)
		5. public BigInteger[] divideAndRemainder(BigInteger val)
```java
package com.leeup.javase.day14.otherclass;

import java.math.BigInteger;

public class Demo4_BigInteger {

	public static void main(String[] args) {
//		Long num = 12343435455647567624L;数据太大，非要存起来怎么办呢？
//		String s = "12343435455647567624";可以使用String但是无法参加运算
		
		//使用BigInteger
		BigInteger bi1 = new BigInteger("100"); 
		BigInteger bi2 = new BigInteger("2");
		System.out.println(bi1.add(bi2));		//相加
		System.out.println(bi1.subtract(bi2));	//相减
		System.out.println(bi1.multiply(bi2));	//相乘
		System.out.println(bi1.divide(bi2));	//相除
		
		BigInteger[] arr = bi1.divideAndRemainder(bi2);//取除数和余数
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

### 15. BigDecimal类的概述和方法使用
	1. BigDecimal的概述
		1. 由于在运算的时候，float类型和double很容易丢失精度，演示案例。
		2. 所以，为了能精确的表示、计算浮点数，Java提供了BigDecimal
		3. 不可变的、任意精度的有符号十进制数。
	2. 构造方法
		1. public BigDecimal(String val)
	3. 成员方法
		1. public BigDecimal add(BigDecimal augend)
		2. public BigDecimal subtract(BigDecimal subtrahend)
		3. public BigDecimal multiply(BigDecimal multiplicand)
		4. public BigDecimal divide(BigDecimal divisor)
	4. 案例演示
		1. BigDecimal类的构造方法和成员方法使用
```java
package com.leeup.javase.day14.otherclass;

import java.math.BigDecimal;

/**
 * BigDecimal类的概述和方法使用
 * @author 李闯
 *
 */
public class Demo5_BigDecimal {

	public static void main(String[] args) {
		//这种方式在开发中不推荐，因为不够精确
		System.out.println(2.0-1.1);
		//结果为0.8999999999999999，因为现在计算机存储的都是二进制形式存储的，
		//二进制存储小数的时候不能直接表现出来，所以他只能无限接近于小数
		
//		BigDecimal bd1 = new BigDecimal(2.0);
//		BigDecimal bd2 = new BigDecimal(1.1);
//		System.out.println(bd1.subtract(bd2));
		
		//通过构造中传入字符串的方式进行运算，开发时推荐
//		BigDecimal bd1 = new BigDecimal("2.0");
//		BigDecimal bd2 = new BigDecimal("1.1");
//		System.out.println(bd1.subtract(bd2));
		
		//这种方式在开发中也是推荐的
		BigDecimal bd1 = BigDecimal.valueOf(2.0);
		BigDecimal bd2 = BigDecimal.valueOf(2.0);
		System.out.println(bd1.subtract(bd2));
		
	}
}
```

### 16. Date类的概述和方法使用
	1. Date类的概述(util包下的Date)
		1. 类 Date 表示特定的瞬间，精确到毫秒。 
	2. 构造方法
		1. public Date()
		2. public Date(long date)
	3. 成员方法
		1. public long getTime()
		2. public void setTime(long time)
```java
package com.leeup.javase.day14.otherclass;

import java.util.Date;

/**
 * Date类的概述和方法使用
 * @author 李闯
 *
 */
public class Demo6_Date {

	public static void main(String[] args) {
//		demo1();
//		
//		demo2();

		/**
		 * 在这里就是构造方法对对象进行初始化
		 * set方法对其值进行修改
		 */
		Date d1 = new Date();
		d1.setTime(1000);//设置毫秒值，改变时间对象
		System.out.println(d1);//1000毫秒等于一秒，输出结果为Thu Jan 01 08:00:01 CST 1970
	}

	private static void demo2() {
		Date d1 = new Date();
		System.out.println(d1.getTime());//通过时间对象获取当前时间的毫秒值
		System.out.println(System.currentTimeMillis());//通过系统类的方法获取当前时间毫秒值
	}

	private static void demo1() {
		Date d1 = new Date();	//没有传参数代表的是当前时间
		System.out.println(d1);
		
		//打印出来08:00是因为电脑时区设置的为东八区
		Date d2 = new Date(0);	//如果构造方法中参数传为0代表的是19701月1日
		System.out.println(d2);//1970-1-1-08:00 
	}
}
```

### 17. SimpleDateFormat类实现日期和字符串的相互转换
	1. DateFormat类的概述
		1. DateFormat 是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化并解析日期或时间。是抽象类，所以使用其子类SimpleDateFormat
	2. SimpleDateFormat构造方法
		1. public SimpleDateFormat()
		2. public SimpleDateFormat(String pattern)
	3. 成员方法
		1. public final String format(Date date)
		2. public Date parse(String source)
```java
package com.leeup.javase.day14.otherclass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat类实现日期和字符串的相互转换
 * @author 李闯
 *
 */
public class Demo7_SimpleDateFormat {

	public static void main(String[] args) throws ParseException {
//		demo1();
		
//		demo2();
		
//		demo3();
		
		//将时间字符串转换为日期对象，好处，日期对象有set,get这样的方法，可以获取毫秒值，可以对它进行计算
		//比如有两个字符串，一个是出生的，一个是今天的，将这两个字符串转换为日期对象，就可以求出年龄了
		String str = "2000年08月08日 08:08:08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//与上方str保持一致
		Date d = sdf.parse(str);			//将时间字符串转换为日期对象，这里会出现异常，因为这个字符串可能会"瞎写",如果瞎写的话就转换不了，转换不了就会出错
		System.out.println(d);
	}

	private static void demo3() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(sdf.format(d));
	}

	private static void demo2() {
		Date d = new Date();							//创建日期对象
		SimpleDateFormat sdf = new SimpleDateFormat();	//创建日期格式化类对象
		System.out.println(sdf.format(d));
	}

	private static void demo1() {
		//DateFormat df = new DateFormat();	DateFormat是抽象类不允许实例化
		
		//相当于父类引用指向子类对象，右边的方法返回一个子类对象
		//相当于DateFormat df1 = new SimpleDateFormat();
		DateFormat df1 = DateFormat.getDateInstance();
	}
}


```

### 18. 你来到这个世界多少天案例
	1. 案例演示
		1. 需求：算一下你来到这个世界多少天?
```java
package com.leeup.javase.day14.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 你来到这个世界多少天案例
 * 第一步：
 * 	1. 将生日字符串和今天字符串存储在String类型的变量中
 *  2. 定义日期格式化对象
 *  3. 将日期字符串转换为日期对象
 *	4. 通过日期对象获取时间毫秒值
 *	5. 将两个时间毫秒值相减除以1000，变成秒，再除以60，变成分钟，再除以60变成小时，再除以24，变成天
 * @author 李闯
 *
 */
public class Test2 {

	public static void main(String[] args) throws ParseException {
		String birthday = "1997年11月14日";
		String today =	"2018年11月2日"; 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		
		Date d1 = sdf.parse(birthday);
		Date d2 = sdf.parse(today);
		
		long time = d2.getTime()-d1.getTime();
		
		System.out.println(time/1000/60/60/24+"天");
		
	}
}

```

### 19. Calendar类的概述和获取日期的方法
	1. Calendar类的概述
		1. Calendar 类是一个抽象类，它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
	2. 成员方法
		1. public static Calendar getInstance()
		2. public int get(int field)
```java
package com.leeup.javase.day14.otherclass;

import java.util.Calendar;

/**
 * Calendar类的概述和获取日期的方法
 * @author 李闯
 *
 */
public class Demo9_Calendar {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();		//父类引用指向子类对象
//		System.out.println(calendar); 
		System.out.println(calendar.getTime());//获取当前系统年月日到毫秒时间
		System.out.println(calendar.get(Calendar.YEAR));//通过字段获取年
		System.out.println(calendar.get(Calendar.MONTH));//为10月。但是当前月份为11月，因为月份是从0开始编号的
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//月中的第几天
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));//星期中的第几天，这里的按照的规则是周日是第一天，周六是最后一天，故今天是周五，输出的是6
		
		
		System.out.println(calendar.get(Calendar.YEAR)+"年"+getNum((calendar.get(Calendar.MONTH)+1))+"月"
		+getNum(calendar.get(Calendar.DAY_OF_MONTH))+"日 "+getWeek(calendar.get(Calendar.DAY_OF_WEEK)));
	}
	
	/**
	 * 将星期存储表中进行查表
	 * 1. 返回值类型String
	 * 2. 参数列表int week
	 */
	public static String getWeek(int week) {
		String[] arr = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		return arr[week];
	}
	
	/**
	 * 如果是个数数字前面补0
	 * 1. 返回值类型String
	 * 2， 参数列表，int，num
	 */
	public static String getNum(int num) {
//		if (num>9) {
//			return ""+num;
//		}else {
//			return "0"+num;
//		}
		
		return num>9?""+num:"0"+num;
	}
	
}
```

### 20. Calendar类的add()和set()方法
	1. 成员方法
		1. public void add(int field,int amount)
		2. public final void set(int year,int month,int date)
	2. 案例演示
		1. Calendar类的成员方法使用
```java
package com.leeup.javase.day14.otherclass;

import java.util.Calendar;

/**
 * Calendar类的add()和set()方法
 * @author 李闯
 *
 */
public class Demo10_Calendar {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 1);//写哪个字段就对哪个字段进行操作，向前+，或者向后-
		calendar.set(Calendar.YEAR, 12);//修改指定字段
		calendar.set(2000, 11, 14);//设置年月日。这里设置的11其实是10，因为 月份从0计算的
	}
}

```

### 21. 如何获取任意年份是平年还是闰年
	1. 案例演示
		1. 需求：键盘录入任意一个年份，判断该年是闰年还是平年
```java
package com.leeup.javase.day14.test;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 如何获取任意年份是平年还是闰年
 * @author 李闯
 */
public class Test3 {

	public static void main(String[] args) {
		/**
		 * 分析：
		 * 1. 键盘录入年 Scanner
		 * 2. 创建Calendar对象， 
		 * 3. 通过set方法设置为那一年的3月1号
		 * 4. 将日向前减去1，就变成了二月的最后一天
		 * 5. 判断日是多少天，如果是29天，返回true，否则返回false
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入年份，判断该年份是否是闰年还是平年");
		String line = scanner.nextLine();	//录入数字字符串
		
		
		int year = Integer.parseInt(line);	//将数字字符串转换为字符串
		
		boolean b = getYear(year);
		
		System.out.println(b);
	}

	private static boolean getYear(int year) {
		Calendar calendar = Calendar.getInstance();
		
		//设置为那一年的三月一日
		calendar.set(year,2,1);
		//将日向前减去1
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		//判断是否是29天
		return calendar.get(Calendar.DAY_OF_MONTH)==29;
	}
}
```
### 22. day14总结
	1. 把今天的知识点总结一遍。