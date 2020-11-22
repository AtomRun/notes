package com.leeup.javase.day02;
/**
 * 三种循环结构的不同
 * @author 李闯
 *
 */
public class Demo2_Defferent {

	public static void main(String[] args) {
		/**
		 * do while 和 while的区别
		 * do while 至少会执行一次，但是while和for一样必须先拍判断条件是否成立，再执行循环体
		 */
		int i = 11;
		do {
			System.out.println(i);
			i++;
		} while (i<=10);
		
		System.out.println("=========分割线=========");
		
		int j = 11;
		while (j<=10) {
			System.out.println(j);
			j++;
		}
		
		for (int d = 1; d < 10; d++) {
			System.out.println(d);
		}
		//System.out.println(d);for语句在执行完之后，里面的变量会被释放掉，在这里在使用d就使用不到了
		System.out.println("=========分割线=========");
		
		int d = 1;
		while (d<=10) {
			System.out.println(d);
			d++;
		}
		System.out.println("=========分割线=========");
		System.out.println(d);	//while语句在执行后，初始化变量还可以继续使用。
 	}
}
