package com.leeup.javase.day16.list;
/**
 * 去除ArrayList中重复字符串元素方式
 * @author 李闯
 *
 */

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("all")
public class Demo1_ArrayList {

	
	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		
		ArrayList newList = getSingle(list);
		System.out.println(newList);
		
		
	}
	
	/**
	 * 创建新集合,将重复元素去掉
	 * 1. 明确返回值类型返回 ArrayList
	 * 2. 明确参数列表  集合ArrayList
	 * 
	 * 分析:
	 * 	1. 创建新集合
	 *  2. 根据传入的集合(老集合)获取迭代器
	 *  3. 遍历老集合
	 *  4. 判断通过新集合判断是否包含老集合中的元素,如果包含就不添加到新集合中,如果不包含就添加进去
	 */ 
	public static ArrayList getSingle(ArrayList list) {
		ArrayList newList = new ArrayList();		//1. 创建新集合
		Iterator it = list.iterator();			//2. 根据传入的集合(老集合)获取迭代器
		while (it.hasNext()) {					//3. 遍历老集合
			Object obj = it.next();				//记录住每一个元素
			if (!newList.contains(obj)) {
				newList.add(obj);				//如果新集合中不包含老集合中元素,就将元素添加到新集合中
			}
		}
		return newList;
	}
}
