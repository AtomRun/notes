package com.leeup.javase.day16.list;

import java.util.LinkedList;

/**
 * 用LinkedList模拟栈数据结构的集合并测试
 * @author 李闯
 *
 */
public class Demo4_LinkedList {

	public static void main(String[] args) {
//		demo1();
		
		Stack stack = new Stack();
		stack.in("a");			//进栈
		stack.in("b");
		stack.in("c");
		stack.in("d");
		
		while(!stack.isEmpty()) {//判断栈结构是否为空
			//不为空弹栈/出栈
			System.out.println(stack.out());
		}
		
	}

	private static void demo1() {
		LinkedList list = new LinkedList();
		
		
		//进栈
		list.addLast("a");
		list.addLast("b");
		list.addLast("c");
		list.addLast("d");
		
		//出栈
//		System.out.println(list.removeLast());
//		System.out.println(list.removeLast());
//		System.out.println(list.removeLast());
//		System.out.println(list.removeLast());
		while (!list.isEmpty()) {//不为空就弹栈
			System.out.println(list.removeLast());
		}
	}
}
