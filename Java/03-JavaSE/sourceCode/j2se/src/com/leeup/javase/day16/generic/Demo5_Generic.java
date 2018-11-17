package com.leeup.javase.day16.generic;

import java.util.ArrayList;

import com.leeup.javase.day16.bean.Person;
import com.leeup.javase.day16.bean.Student;

/**
 * 泛型高级之通配符
 * @author 李闯
 *
 */
public class Demo5_Generic {

	public static void main(String[] args) {
		//前后反省需要一致，但是有时候在做开发的时候，后面不确定接收什么类型，可能是一个方法
		//返回的一个集合，对象，数据类型可能不确定，不确定怎么办呢？在前面加一个问号，问号代表任意类型 
//		List<?> list = new ArrayList<String>();//当右边的泛型不确定时，左边可以指定问号
		
		ArrayList<Person> list1 = new ArrayList<>();
		list1.add(new Person("张三",23));
		list1.add(new Person("李四",24));
		list1.add(new Person("王五",25));
		
		ArrayList<Student> list2 = new ArrayList<>();
		list2.add(new Student("赵六",26));
		list2.add(new Student("周七",27));
		
		
		list1.addAll(list2);//子类集合元素添加到父类元素中
		
		System.out.println(list1);
	}
}
