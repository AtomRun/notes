package com.leeup.javase.day18.map;

import java.util.Comparator;
import java.util.TreeMap;

import com.leeup.javase.day18.bean.Student;


/**
 * TreeMap集合键是Student值是String的案例
 * @author 李闯
 *
 */
public class Demo7_TreeMap {

	public static void main(String[] args) {
//		demo1();
		
		//匿名内部类方式
		TreeMap<Student, String> tm = new TreeMap<>(new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				int num = s1.getName().compareTo(s2.getName());//按照姓名比较
				return num==0?s1.getAge() - s2.getAge():num;
			}
		});
		tm.put(new Student("张三",23), "北京");
		tm.put(new Student("李四",13), "上海");
		tm.put(new Student("王五",33), "广州");
		tm.put(new Student("赵六",26), "深圳");
		
		/**
		 * Student需要重写Comparable接口
		 */
		System.out.println(tm);
	}

	private static void demo1() {
		TreeMap<Student, String> tm = new TreeMap<>();
		tm.put(new Student("张三",23), "北京");
		tm.put(new Student("李四",13), "上海");
		tm.put(new Student("王五",33), "广州");
		tm.put(new Student("赵六",26), "深圳");
		
		/**
		 * Student需要重写Comparable接口
		 */
		System.out.println(tm);
	}
}
