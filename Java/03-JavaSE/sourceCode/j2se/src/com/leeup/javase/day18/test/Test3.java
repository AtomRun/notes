package com.leeup.javase.day18.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * 
 * @author 李闯
 *
 */
public class Test3 {

	public static void main(String[] args) {
		String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] color = {"方片","梅花","红桃","黑桃"};
		HashMap<Integer, String> hm = new HashMap<>();	//存储索引和扑克牌
		ArrayList<Integer> list = new ArrayList<>();	//存储索引
		int index = 0;									//索引值
		
		//拼接扑克牌并将索引和扑克牌存储在hashMap集合中
		for(String s1 : num) {					//获取数字
			for(String s2 : color) {			//获取颜色
				hm.put(index, s2.concat(s1));	//将颜色和数字拼接
				list.add(index);				//将索引0-51添加到list集合
				index++;						//索引增加，遍历索引的牌
			}
		}
		//将小王添加到双列集合中
		hm.put(index,"小王");
		list.add(index);						//将52索引添加到集合中
		index++;
		hm.put(index, "大王");					
		list.add(index);						//将53索引添加到集合中
		
		//洗牌
		Collections.shuffle(list);
		//发牌
		TreeSet<Integer> gaojin = new TreeSet<>();
		TreeSet<Integer> longwu = new TreeSet<>();
		TreeSet<Integer> me = new TreeSet<>();
		TreeSet<Integer> dipai = new TreeSet<>();
		
		for(int i = 0; i<list.size(); i++) {
			if (i>=list.size()-3) {
				dipai.add(list.get(i));			//将三张底牌存储在底牌集合中
			}else if (i%3==0) {
				gaojin.add(list.get(i));
			}else if (i%3==1) {
				longwu.add(list.get(i));
			}else{
				me.add(list.get(i));
			}
		}
		
		//看牌
		lookPoker(hm, gaojin, "高进");
		lookPoker(hm, longwu, "龙武");
		lookPoker(hm, me, "我");
		lookPoker(hm, dipai, "底牌");
	}
	/**
	 * 看牌
	 * 	1. 返回值类型void
	 * 	2. 参数列表：HashMap 放的是键和值的关系，TreeSet 存的所有索引，String name 到底是谁的牌
	 */
	public static void lookPoker
	(HashMap<Integer, String> hm,TreeSet<Integer> ts,String name) {
		System.out.println(name+"的牌是：");
		for (Integer i : ts) {		//拿到了健集合的所有的键，i代表每个键
			System.out.print(hm.get(i)+" ");//根据键获取值
		}
		System.out.println();
	}
}
