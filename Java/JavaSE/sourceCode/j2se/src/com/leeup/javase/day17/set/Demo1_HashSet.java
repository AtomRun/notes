package com.leeup.javase.day17.set;

import java.util.HashSet;

import com.leeup.javase.day17.bean.Person;

/**
 * HashSet存储字符串并遍历
 * Set集合无索引，不可以存储重复，无序(存取顺序不一致，)
 * @author 李闯
 *
 */
public class Demo1_HashSet {

	public static void main(String[] args) {
//		demo1();
		
		HashSet hs = new HashSet<>();
		hs.add(new Person("张三",24));
		hs.add(new Person("张三",24));
		hs.add(new Person("李四",24));
		hs.add(new Person("李四",24));
		hs.add(new Person("李四",24));
		hs.add(new Person("李四",24));
		
		System.out.println(hs);//结果为6，因为这里的对象每个对象都有单独的地址值，所以，都会被存进来，
									  //如果想让hashset认为同姓名同年龄是一个人需要重写equals方法
		
	}

	private static void demo1() {
		HashSet<String> hs = new HashSet<>();	//创建hashSet对象
		boolean b1 = hs.add("a");
		boolean b2 = hs.add("a");				//当向set集合中存储重复元素的时候，返回为false
		hs.add("b");
		hs.add("c");
		hs.add("d");
		
		System.out.println(hs);					//hashSet的继承体系中有重写toString方法
		System.out.println(b1);
		System.out.println(b2);
		
		for (String string : hs) {				//只要能用迭代器迭代的就可以使用增强for循环遍历
			System.out.println(string);
		}
	}
}
