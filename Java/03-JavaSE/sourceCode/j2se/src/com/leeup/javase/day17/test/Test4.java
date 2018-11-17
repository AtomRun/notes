package com.leeup.javase.day17.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * 在一个集合中村除了无序并且重复的字符串，定义一个方法，让其有序(字典顺序)，并且还不能去除重复
 * @author 李闯
 * 分析：
 * 	1. 定义一个List集合，并存储重复的无序的字符串
 *  2. 定义方法对其排序，保留重复
 *	3. 打印List集合
 */
public class Test4 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("aaa");
		list.add("ccc");
		list.add("ddd");
		list.add("fffffff");
		list.add("zhongguo");
		list.add("nihao");
		list.add("bbb");
		list.add("aaa");
		list.add("aaa");
		
		sort(list);
		
		System.out.println(list);
	}

	/**
	 * 创建方法，排序并保留重复
	 * 分析：
	 * 	1. 排序，创建TreeSet集合对象，因为String本身就具备比较功能，但是重复不会保留，所以我们用比较器
	 *  2. 将List集合中所有的元素添加到TreeSet集合中，对其排序，保留重复
	 *  3. 清空List集合
	 *  4. 将TreeSet集合中排好序的元素添加到List集合中
	 * @param list
	 */
	public static void sort(List<String> list) {
		//1
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String s1,String s2) {
				int num = s1.compareTo(s2);//
				return num==0?1:num;
			}
		});
		
		//2 
		ts.addAll(list);
		//3
		list.clear();
		//4
		list.addAll(ts);
	}
}

