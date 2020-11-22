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
