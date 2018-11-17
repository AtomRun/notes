package com.leeup.javase.day05.二维数组;
/**
 * 参数传递：引用类型的值传递和基本数据类型的值传递
 * @author 李闯
 *
 */
public class Test3_Array {

	public static void main(String[] args) {
			int a = 10;
			int b = 20;
			System.out.println("a:"+a+",b:"+b);
			change(a,b);
			System.out.println("a:"+a+",b:"+b);//基本数据类型，change方法执行完之后，不改变原值，调用完毕之后弹栈，在方法中被改变了的局部变量的值也消失了。
											   //因为没有new对象，所以一切操作都在栈中
			
			int [] arr = {1,2,3,4,5};
			change(arr);
			System.out.println(arr[1]);		   //引用数据类型，arr创建之后会在堆中开辟内存空间用来存放数组得元素值，而方法中的arr是引用了这里的arr，当方法中修改了arr中元素的值的时候
											   //即使弹栈了，arr在堆内存中的数组对象还是存在的，已经被修改的元素值不会消失，还可以通过地址访问
	}
	
	public static void change(int a,int b) {
		System.out.println("a:"+a+",b:"+b);
		a = b;
		b = a+b;
		System.out.println("a:"+a+",b:"+b);
	}
	
	public static void change(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]%2==0) {
				arr[i]*=2;
			}
		}
	}
}
