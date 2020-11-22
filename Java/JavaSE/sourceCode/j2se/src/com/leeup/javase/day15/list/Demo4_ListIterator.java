package com.leeup.javase.day15.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator
 * @author 李闯
 *
 */
public class Demo4_ListIterator {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");			
		list.add("b");
		list.add("world");
		list.add("c");
		list.add("d");
		list.add("e");
		
		ListIterator lit = list.listIterator();
		while (lit.hasNext()) {
			System.out.println(lit.next());			//获取元素并且将指针向后移动
		}
		System.out.println("=================");
		while (lit.hasPrevious()) {//指针指向0,判断0前面是否有元素,没有就直接返回false了,不注释前一个while可以遍历出结果是因为,前面的将指针指向了最后一个
			System.out.println(lit.previous());			//获取元素并且将指针向前移动
		}
	}
}
