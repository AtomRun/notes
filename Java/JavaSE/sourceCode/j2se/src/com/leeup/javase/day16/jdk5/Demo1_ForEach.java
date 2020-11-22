package com.leeup.javase.day16.jdk5;

import java.util.ArrayList;
import java.util.Iterator;

import com.leeup.javase.day16.bean.Person;

/**
 * 增强for的概述和使用也就是ForEach
 * 底层依赖的是迭代器即，Iterator
 * @author 李闯
 *
 */
public class Demo1_ForEach {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		
		//普通for循环进行删除[注意：索引要--]
		for (int i = 0; i < list.size(); i++) {
			if ("b".equals(list.get(i))) {
				
				list.remove(i--);//通过索引删除元素,删除一次就--是因为，当删除了数组中的元素的时候，数组下面的
				//元素会顶替上面的元素上来，但是i依旧还会+1，所以就会出现漏删的情况，所以--就会让指针回去一次了
			}
		}
		System.out.println(list);
		
		//迭代器删除
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			if ("b".equals(it.next())) {
//				list.remove("b");//这样会出现并发修改异常，因为集合告诉迭代器有五个元素，然后迭代器迭代的过程中，使用了list.remove("b"); 删除了一个，现在变成了4个
								//这个时候就是迭代过程中集合进行了修改，出现了并发修改异常,所以不能用集合的删除方法,因为迭代过程中修改会出现异常
				it.remove();//使用自身的
			}
		}
		
		//迭代器的另外一种写法
		for (Iterator<String> it2 = list.iterator(); it2.hasNext();) {
			if ("b".equals(it2.next())) {//next指针自动向后,所以没有写循环后的操作表达式
				it2.remove();
			}
		}
		System.out.println(list);
		
		//增强for循环,不能删除,只能遍历,因为只能调用集合的remove方法,而调用remove方法删除,会出现并发修改异常
		for (String string : list) {
			if ("b".equals(string)) {
				list.remove("b");
			}
		}
		System.out.println(list);
	}
	
	

	private static void demo2() {
		/**
		 * ArrayList存储字符串和自定义对象并遍历增强for版
		 */
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("张三",23));
		list.add(new Person("李四",24));
		list.add(new Person("王五",25));
		list.add(new Person("赵六",26));
		
		for (Person person : list) {
			System.out.println(person);
		}
	}

	private static void demo1() {
		int[] arr = {11,22,33,44,55};
		
		//遍历数组
		//快捷键fore
		for (int i : arr) {
			System.out.println(i);
		}
		
		//遍历集合
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
