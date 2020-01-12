package com.leeup.javase.day16.list;

import java.util.LinkedList;

public class Stack {

	private LinkedList list = new LinkedList();
	
	
	/**
	 * 模拟进栈方法，即封装addLast方法
	 */
	public void in(Object obj) {
		list.add(obj);
	}
	
	/**
	 * 模拟出栈，封装removeLast方法
	 */
	public Object out() {
		return list.removeLast();
	}
	
	/**
	 * 模拟栈结构是否为空
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
}
