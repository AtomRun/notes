package com.leeup.javase.day15.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 并发修改异常产生的原因及解决方案
 * @author 李闯
 *
 */
public class Demo3_List {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");			//Object obj = new String("a");
		list.add("b");
		list.add("world");
		list.add("c");
		list.add("d");
		list.add("e");
		
		/**
		 * java.util.ConcurrentModificationException
		 * 解决方案使用ListIterator
		 */
		/*Iterator iterator = list.iterator();
		while (iterator.hasNext()) {		//判断集合中是否有元素
			String str = (String) iterator.next();//不能直接使用String接收,因为上面将a加入到集合中的时候,会自动类型提升为Object即向上转型
										//现在想要 直接使用String接收,需要强转,向下转型
			if ("world".equals(str)) {
				list.add("javaee");		//遍历的同时在增加元素,这个叫并发修改
			}
		}*/
		ListIterator lit = list.listIterator();//获取list特有的迭代器
		while (lit.hasNext()) {
			String str = (String) lit.next();
			if ("world".equals(str)) {
				lit.add("javaee");
			}
		}
		System.out.println(list);
	}
}
