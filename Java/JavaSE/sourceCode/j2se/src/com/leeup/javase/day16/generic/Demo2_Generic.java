package com.leeup.javase.day16.generic;

import java.util.ArrayList;
import java.util.Iterator;

import com.leeup.javase.day16.bean.Person;

/**
 * ArrayList存储字符串和自定义对象并遍历泛型版
 * @author 李闯
 *
 */
public class Demo2_Generic {

	public static void main(String[] args) {
		
//		demo1();
		
		//向集合中添加自定义对象
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("张三",23));
		list.add(new Person("李四",24));
		list.add(new Person("王五",25));
		list.add(new Person("赵六", 26));
		
		Iterator<Person> it = list.iterator();
		while (it.hasNext()) {
			Person person = it.next();
			System.out.println(person.getName()+"///"+person.getAge());
		}
	}

	private static void demo1() {
		//向集合中添加String字符串
		ArrayList<String> list = new ArrayList<>();		//创建集合对象
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
