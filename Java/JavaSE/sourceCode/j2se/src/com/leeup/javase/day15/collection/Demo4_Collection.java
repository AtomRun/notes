package com.leeup.javase.day15.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection集合的带All功能测试
 * @author 李闯
 *
 */
public class Demo4_Collection {

	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
		
		Collection c1 = new ArrayList<>();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		
		Collection c2 = new ArrayList<>();
		/**
		 * 取交集abcd,将abcd赋值给c1,c1值没有改变,即false
		 */
		c2.add("a");
		c2.add("b");
		c2.add("c");
		c2.add("d");
		c2.add("e");
		c2.add("f");
		
		/**
		 * 有交集为true,如果调用的集合改变就返回true,如果调用的集合不变就返回false
		 * 没有交集
		 */
		boolean b = c1.retainAll(c2);//取交集
		System.out.println(b);
		System.out.println(c1);
		
	}

	private static void demo3() {
		Collection c1 = new ArrayList<>();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		
		Collection c2 = new ArrayList<>();
		c2.add("a");
		c2.add("b");
		c2.add("b");
		c2.add("z");

		/**
		 * 判断调用的集合是否包含传入的集合，
		 * 有重复的没关系。但是c1中的元素在c2中也要有，有一个没有就为false
		 */
		boolean b = c1.containsAll(c2);
		System.out.println(b);
	}

	private static void demo2() {
		Collection c1 = new ArrayList<>();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		
		Collection c2 = new ArrayList<>();
		c2.add("a");
		c2.add("b");
		c2.add("z");
		
		/**
		 * 删除的是交集，即c1,c2中相同的元素，没有交集即不删，返回false
		 */
		boolean b = c1.removeAll(c2);
		System.out.println(b);
		System.out.println(c1);
	}

	private static void demo1() {
		Collection c1 = new ArrayList<>();
		Collection c2 = new ArrayList<>();
		
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		
		c2.add("a");
		c2.add("b");
		c2.add("c");
		c2.add("d");
		
//		c1.addAll(c2);//将c2每一个元素添加到c1中
		c1.add(c2);//输出结果是[a, b, c, d, [a, b, c, d]] 这样做将c2整个集合当作一个对象添加到c1中了
		System.out.println(c1);
	}
}
