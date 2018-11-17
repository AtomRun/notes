package com.leeup.javase.day18.map;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap的概述和使用
 * @author 李闯
 *
 */
public class Demo6_LinkedHashMap {

	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		lhm.put("张三", 23);
		lhm.put("李四", 24);
		lhm.put("赵六", 26);
		lhm.put("王五", 25);
		
		
		System.out.println(lhm);
	}
}
