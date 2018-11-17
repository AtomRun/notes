package com.leeup.javase.day18.map;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * HashMap和Hashtable的区别
 * 面试题
 * @author 李闯
 * 	共同点：
 * 		1. 底层都是使用哈希算法
 * 		2. 都是双列集合
 * 	不同点：
 * 		1. HashMap是线程不安全的，效率高，JDK1.2版本
 * 		   HashTable线程安全的，效率低，JDK1.0版本
 * 		2. HashMap可以存储null键和null值
 * 		   HashTable不可以存储null键位和null值
 * 		
 *
 */
public class Demo9_HashTable {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put(null, 32);
		hm.put("lisi", null);
		System.out.println(hm);
		
		//不可以存储null键和null值
		Hashtable<String, Integer> ht = new Hashtable<>();
		ht.put(null, 32);
		ht.put("lisi", null);
		System.out.println(ht);
	}
}
