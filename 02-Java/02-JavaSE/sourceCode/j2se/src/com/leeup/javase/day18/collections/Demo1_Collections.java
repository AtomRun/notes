package com.leeup.javase.day18.collections;

import java.util.ArrayList;
import java.util.Collections;


/**
 *11. Collections工具类的概述和常见方法讲解
    1. Collections类概述
        * 针对集合操作 的工具类
    2. Collections成员方法
 * @author 李闯
 *
 */
public class Demo1_Collections {

	public static void main(String[] args) {
//		demo1();
//		demo2();
		
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("f");
		list.add("g");
		System.out.println(Collections.max(list));		//根据默认排序结果获取集合中的最大值
		Collections.reverse(list);
		System.out.println(list);						//反转集合
		
		Collections.shuffle(list);
		System.out.println(list);						//随即置换元素位置。可以用来洗牌
	}

	private static void demo2() {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("f");
		list.add("g");
		
		System.out.println(Collections.binarySearch(list, "c"));
		System.out.println(Collections.binarySearch(list, "b"));
	}

	private static void demo1() {
		ArrayList<String> list = new ArrayList<>();
		list.add("c");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("d");
		
		System.out.println(list);
		Collections.sort(list);
		//重复的时候会保留并且排序
		System.out.println(list);
	}
}
