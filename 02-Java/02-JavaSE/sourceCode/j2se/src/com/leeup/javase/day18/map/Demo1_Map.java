package com.leeup.javase.day18.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Map集合的功能概述
 * @author 李闯
 *
 */
public class Demo1_Map {

	public static void main(String[] args) { 
//		demo1();
		
//		demo2();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);
		
		Collection<Integer> c = map.values();
		System.out.println(c);
		System.out.println(map.size());//一对代表一条记录，四个元素
	}

	private static void demo2() {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);
		
		
		Integer value = map.remove("张三");//根据键删除元素值，返回键对应的值
		System.out.println(value);
		
		System.out.println(map.containsKey("张三"));//判断是否包含张三这个key
		System.out.println(map.containsValue(23));//判断是否包含23这个value
	}

	private static void demo1() {
		Map<String, Integer> map = new HashMap<>();
		Integer i1 = map.put("张三", 23);
		Integer i2 = map.put("李四", 24);
		Integer i3 = map.put("王五", 25);
		Integer i4 = map.put("赵六", 26);
		
		Integer i5 = map.put("张三", 26);
		
		System.out.println(map);
		
		
		/**
		 * 输出结果为null
		 * 因为双列集合是这样的，往里寸的时候，如果没有张三这个键，就把k,v存进去，返回被覆盖的部分，但是由于集合中没有
		 * 被张三23，所以返回是null ，因为覆盖的是null
		 */
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		
		//i5是23，把被覆盖的值返回，即相同的键不存储，键是唯一的，值覆盖
		System.out.println(i5);
	}
}
