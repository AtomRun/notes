package com.leeup.javase.day16.generic;

import java.util.ArrayList;
import java.util.Iterator;

import com.leeup.javase.day16.bean.Person;

/**
 * 泛型概述和基本使用
 * @author 李闯
 *
 */
@SuppressWarnings("all")
public class Demo1_Generic {

	
	public static void main(String[] args) {
//		demo1();
		//int[] arr = new byte[5]  这种是错误的
//		ArrayList<Object> list = new ArrayList<Person>();//前后泛型定义数据类型要一致，与数组定义数据类型相同
		
//		ArrayList<Object> list = new ArrayList<>();			//1.7版本的新特性，菱形泛型，即前面泛型写了，后面可以不用写，<>像一个菱形
		ArrayList<Object> list = new ArrayList<>(); 		//泛型最好不要定义成Object，没有意义，因为Object是任何类的父类，引用数据类型的父类
		list.add("aaa");
		list.add(true);
		
	}

	private static void demo1() {
		ArrayList<Person> list = new ArrayList<Person>();
//		list.add(110);
//		list.add(true);
		list.add(new Person("张三",23));
		list.add(new Person("李四",24 ));
		
		Iterator<Person> it = list.iterator();
		
		/**
		 *  java.lang.ClassCastException 类型转换异常
		 */
		while(it.hasNext()) {
//			System.out.println(it.next());
			
			
			/**
			 * it.next方法只能调用一次，如果调用多次会将指针向后移动多次
			 */
//			System.out.println(it.next().getName()+"...."+it.next().getAge());
			
			Person person = it.next();//向下转型
			System.out.println(person.getName()+"..."+person.getAge());
		}
	}
}
