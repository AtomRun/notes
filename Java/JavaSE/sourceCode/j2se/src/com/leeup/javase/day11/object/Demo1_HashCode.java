package com.leeup.javase.day11.object;

import com.leeup.javase.day11.test.Student;

/**
 * hashCode展示
 * @author 李闯
 *
 */
public class Demo1_HashCode {

	public static void main(String[] args) {
		Object object = new Object();
		int hashCode = object.hashCode();//hashCode方法返回值为int,使用int来接收
		System.out.println(hashCode);//输出结果是一个int值
		/**
		 * 创建对象，对象要进内存，进内存需要申请地址值，这个hashCode就是地址值
		 * hahsCode源码方法上的native表示借助本地系统资源帮我们算出hashCode的值
		 */
		
		Student s1 = new Student("张三",23);
		Student s2 = new Student("李四",24);
		
		/**
		 * 每个对象都有自己的hashCode值，不相同
		 */
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
	}
}

