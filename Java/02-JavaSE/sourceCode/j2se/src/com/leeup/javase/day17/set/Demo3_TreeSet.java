package com.leeup.javase.day17.set;

import java.util.Comparator;
import java.util.TreeSet;

import com.leeup.javase.day16.bean.Person;

/**
 * TreeSet存储Integer类型的元素并遍历
 * 
 * TreeSet集合是用来对元素进行排序的，同样他也可以保证元素的唯一性，
 * 当compareTo方法返回0的时候，几何中只有一个元素
 * 当compareTo方法返回1的时候，集合中怎么存就怎么取
 * 当compareTo方法返回负数的时候，集合中会倒序存储
 * @author 李闯
 *
 */
public class Demo3_TreeSet {

	public static void main(String[] args) {
//		demo1();
//		demo2(); 
//		demo3();
//		demo4();
		
		//需求：将字符串按照长度排序
		TreeSet<String> ts = new TreeSet<>(new CompareByLen());		
											//相当于Compartor c = new CompareByLen();
											//父类引用指向子类对象
		ts.add("aaa");
		ts.add("z");
		ts.add("wc");
		ts.add("nba");
		ts.add("cba");
		System.out.println(ts);
		
	}

	private static void demo4() {
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("zhangsan",23));
		ts.add(new Person("lisi",13));
		ts.add(new Person("wangwu",33));
		ts.add(new Person("zhaoliu",43));
		ts.add(new Person("aaaa",53));
		System.out.println(ts);
	}

	private static void demo3() {
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("张三",23));
		ts.add(new Person("李四",13));
		ts.add(new Person("王五",43));
		ts.add(new Person("赵六",33));//按照字典的排序顺序unicode码表值排序规则
		
		System.out.println(ts);
	}

	private static void demo2() {
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("张三",23));
		ts.add(new Person("李四",13));
		ts.add(new Person("周七",13));
		ts.add(new Person("王五",43));
		ts.add(new Person("赵六",33));
		System.out.println(ts);
	}

	private static void demo1() {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(3);
		treeSet.add(3);
		treeSet.add(3);
		treeSet.add(1);
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(2);

		
		System.out.println(treeSet);
	}
}

class CompareByLen implements Comparator<String>{

	
	@Override
	public int compare(String s1, String s2) {//按照字符串的长度比较
		int num = s1.length() - s2.length();	//长度为 主要条件
		
		return num == 0 ?s1.compareTo(s2):num;	//内容为次要条件
	}

	
}
