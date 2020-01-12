package com.leeup.javase.day17.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 将集合中的重复元素去掉
 * @author 李闯
 *	分析：
 *	1. 创建List集合存储重复元素
 *	2. 单独定义方法去除重复，
 *  3. 打印List集合
 */
public class Test3 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		
		//定义方法去除重复
		getSingle(list); 
		
		//打印List集合
		System.out.println(list);
	}

	/**
	 * 分析：
	 * 去除List集合重复元素
	 * 	1. 创建一个LinkedHashSet
	 *  2. 将List集合中所有的元素添加到LinkedHashSet集合
	 *  3. 将List集合中的元素清除
	 *  4. 把LinkedHashSet集合中的元素添加回List集合中
	 * @param list
	 */
	public static void getSingle(List<String> list) {//改成List不仅可以接收ArrayList还可以接受LinkedList
		//1. 
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		//2.默认LinkedHashSet会对它进行去重
		lhs.addAll(list);
		//3. 
		list.clear();
		list.addAll(lhs);
	}
	
	
}
