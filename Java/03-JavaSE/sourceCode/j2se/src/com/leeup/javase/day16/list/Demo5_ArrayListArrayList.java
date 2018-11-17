package com.leeup.javase.day16.list;

import java.util.ArrayList;

import com.leeup.javase.day16.bean.Person;

/**
 * 集合嵌套之ArrayList嵌套ArrayList
 * @author 李闯
 *
 */
public class Demo5_ArrayListArrayList {

	public static void main(String[] args) {
		ArrayList<ArrayList<Person>> list = new ArrayList<>();
		
		ArrayList<Person> first = new ArrayList<>();//创建第一个班级
		first.add(new Person("张三",23));
		first.add(new Person("李四",24));
		first.add(new Person("王五",25));
		
		ArrayList<Person> second = new ArrayList<>();
		second.add(new Person("赵六",26));
		second.add(new Person("周七",27));
		second.add(new Person("丘八",28));
		
		//将班级添加到学科集合中
		list.add(first);
		list.add(second);
		
		//遍历学科集合
		for (ArrayList<Person> a:list) {
			for (Person p : a) {
				System.out.println(p);
			}
		}
	}
}
