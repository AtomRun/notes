package com.leeup.javase.day18.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的遍历之键找值
 * 通过查看Map集合API发现没有iterator方法，那么双列结合如何迭代呢？
 * @author 李闯
 *
 */
public class Demo2_Iterator {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);
		
		Integer i = map.get("张三");			//get方法，根据键获取值
		System.out.println(i);
		
		//遍历，获取所有的键
	/*	Set<String> keyset = map.keySet();//获取所有键的集合
		
		//
		Iterator<String> it = keyset.iterator();
		while (it.hasNext()) {				//判断集合中是否有元素
			String key = it.next();			//获取每个键
			Integer value = map.get(key);	//根据遍历的每个键位获取值
			System.out.println(key+"="+value);
		}
		*/
		//使用增强for循环遍历
		for (String key : map.keySet()) {	//map.keySet是所有键的集合
			System.out.println(key+"="+map.get(key));
		}
	}
}
