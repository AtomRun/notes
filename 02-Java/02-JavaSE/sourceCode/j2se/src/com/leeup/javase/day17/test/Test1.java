package com.leeup.javase.day17.test;

import java.util.HashSet;
import java.util.Random;

/**
 *  产生10个1-20之间的随机数要求随机数不能重复
 * @author 李闯
 * 分析：
 * 	1. 有Random类，创建随机数对象
 *  2. 需要存储10个随机数，而且不能重复，所以我们使用HashSet集合 需要重复使用List集合，不需要重复使用Set集合
 *	3. 如果HashSet的size小于10，就可以不断的存储，如果大于等于10j就停止存储
 *  4. 通过Random中的nextInt(n)方法获取1到20之间的随机数 ，并将这些随机数存储在HashSet集合中
 *  5. 遍历HashSet
 */
public class Test1 {

	public static void main(String[] args) {
		Random random = new Random();
		HashSet<Integer> hs = new HashSet<>();
		while (hs.size()<10) {
			hs.add(random.nextInt(20)+1);//20即随即范围0-19所以我们再加一
			
		}
		//遍历HashSet
		for (Integer integer : hs) {
			System.out.println(integer);
		}
	}
}
