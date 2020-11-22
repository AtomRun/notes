package com.leeup.javase.day16.list;

import java.util.LinkedList;

/**
 * LinkedList的特有功能
 * @author 李闯
 *
 */
public class Demo3_LinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst("a");
		list.addFirst("b");
		list.addFirst("c");
		list.addFirst("d");
		list.addLast("e");
		 
//		System.out.println(list.getFirst());
//		System.out.println(list.getLast());
//		System.out.println(list.removeFirst());
//		System.out.println(list.removeLast());
		System.out.println(list.get(1));
		System.out.println(list);
	}
}
