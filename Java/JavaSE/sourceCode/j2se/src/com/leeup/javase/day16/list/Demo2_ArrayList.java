package com.leeup.javase.day16.list;

import java.util.ArrayList;
import java.util.Iterator;

import com.leeup.javase.day16.bean.Person;

/**
 * 去除ArrayList中重复自定义对象元素
 * @author 李闯
 *
 */
@SuppressWarnings("all")
public class Demo2_ArrayList {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();//创建集合对象
		list.add(new Person("张三",23));
		list.add(new Person("张三",23));
		list.add(new Person("李四",24));
		list.add(new Person("李四",24));
		list.add(new Person("李四",24));
		list.add(new Person("李四",24));
		
//		ArrayList newList = getSingle(list);		//调用方法，去除重复
//		System.out.println(newList);
		
		/**
		 * remove方法底层也依赖equals方法
		 */
		list.remove(new Person("张三",23));
		System.out.println(list);
	}
	

	public static ArrayList getSingle(ArrayList list) {
		ArrayList newList = new ArrayList();		
		Iterator it = list.iterator();			
		while (it.hasNext()) {	
			Object obj = it.next();		
			/**
			 * contains判断是否包含，方法底层依赖的是equals方法
			 */
			if (!newList.contains(obj)) {
				newList.add(obj);				
			}
		}
		return newList;
	}
}
