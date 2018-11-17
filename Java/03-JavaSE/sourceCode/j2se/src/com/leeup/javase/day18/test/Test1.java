package com.leeup.javase.day18.test;

import java.util.HashMap;

/**
 * 统计字符串中每个字符出现的次数
 * @author 李闯
 * 分析：
 * 	1. 定义一个需要被统计字符的字符串
 * 	2. 将字符串转换为字符数组
 * 	3. 定义双列集合，用来存储字符串以及字符串出现的次数
 *  4. 遍历字符数组获取每个字符并将字符存储在双列集合中
 *  5. 存储过程中要做判断：如果集合中不包含这个键，就将该字符当作键，值为1存储，如果集合中包含这个键，值就加1存储 
 *  6. 打印双列集合，获取字符出现的次数
 */
public class Test1 {

	public static void main(String[] args) {
		//1 
		String str = "aaabbbccccccccc";
		//2 
		char [] arr = str.toCharArray();
		//3 如果没有特殊要求，使用HashMap,HashMap是最快的，因为LinkedHashMap底层是使用链表实现的，它能保证怎么存怎么取
		//TreeMap会排序，存和取不一致
		HashMap<Character, Integer> hm = new HashMap<>();
		//4
		for (char c : arr) {
		/*	if (!hm.containsKey(c)) {//如果不包含这个键
				hm.put(c, 1);
			}else {
				hm.put(c, hm.get(c)+1);//包含这个键位，+1存起来
			}
		*/
			//5 使用三元运算符优化
			hm.put(c, !hm.containsKey(c)?1:hm.get(c)+1);
		}
		//6
		for (Character key : hm.keySet()) {	//hm.keySet代表所有键的集合。Character key是每个键位
			System.out.println(key+"="+hm.get(key));//hm.get(key)根据键获取值
		}
	}
}
