package com.leeup.javase.day15.list;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合的特有功能概述和测试
 * @author 李闯
 *
 */
public class Demo2_List {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
//		demo4();
		List list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		list.set(1, "z");	//将指定位置的元素修改
		System.out.println(list);
	}

	private static void demo4() {
		List list = new ArrayList();
		list.add(111);
		list.add(222);
		list.add(333);
		
		Object object = list.get(1);//根据索引获取元素,我们可以使用get来遍历List集合,因为索引的值是变化的,但是只能在List中使用,Set中没有索引
		System.out.println(object);
		
		/**
		 * 通过索引遍历List集合
		 */
		for (int i = 0; i < list.size(); i++) {//size为4,索引就是3
			System.out.println(list.get(i));
		}
	}

	private static void demo3() {
		List list = new ArrayList();
		list.add(111);
		list.add(222);
		list.add(333);
//		list.remove(111);//删除的时候不会自动装箱,这里给整数都会被当成索引
	}

	private static void demo2() {
		List list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Object obj = list.remove(1);//通过索引删除元素,将被删除的元素返回
		System.out.println(obj);
		System.out.println(list);
	}

	private static void demo1() {
		//List也是一个接口
		List list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("f");		//index可以小于等于size,并且大于等于0,都不会报异常
//		list.add(1,"e");	//在指定位置添加元素
//		list.add(10,"z");	//java.lang.IndexOutOfBoundsException: 当存储时使用不存在的索引时,会出现索引越界异常
		System.out.println(list);
	}
}
