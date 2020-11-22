package com.leeup.javase.day13.stringbuffer;/**
 * StringBuffer的添加功能
 * @author 李闯
 * StringBuffer是字符串缓冲区，当new的时候是在对内存创建了一个对象，底层是一个长度为16的
 * 字符数组，当调用添加的方法时，不会再重新创建对象，再不断的向原缓冲区，添加字符，
 *
 */
public class Demo2_StringBuffer {

	public static void main(String[] args) {
		
		//demo1();
		
		StringBuffer sb = new StringBuffer("woai");
		sb.insert(3, "zhongguo");
		System.out.println(sb);
		/**
		 * 指定位置添加，比如上述在索引3处添加，即从二个元素往后分割，从a开始添加insert的内容
		 * 如果没有指定位置的索引，即insert得索引在sb中不存在，就会报索引越界异常
		 */
	}

	private static void demo1() {
		StringBuffer sb = new StringBuffer();
		 StringBuffer sb2 = sb.append(true);
		 StringBuffer sb3 = sb.append("zhongguo");
		 StringBuffer sb4 = sb.append(100);
		 
		 /**
		  * 创建完之后再打印的结果
		  */
		 System.out.println(sb);//直接打印sb，其实就是sb.toString，打印结果为空，	表明StringBuffer重写了toString方法，
		 System.out.println(sb2);
		 System.out.println(sb3);
		 System.out.println(sb4);
		 /**
		  *  三个结果相同，这说明了四个引用指向的是同一个对象， 除了第一次new的时候创建了在堆中的对象
		  *  其他的引用都是指向同一个对象，对同一个对象进行操作。这就为什么说StringBuffer是可变的字符序列
		  *  因为我们操作的是同一个字符序列，而字符串是不变的字符序列，字符串只要赋值后，再次赋值之前的
		  *  就变成了垃圾，但StringBuffer不会变成垃圾，因为StringBuffer是如上例，四个引用指向
		  *  同一个对象 
		  */
	}
}
