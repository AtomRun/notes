package com.leeup.javase.day15.collection;

import java.util.ArrayList;
import java.util.Collection;

import com.leeup.javase.day15.bean.Student;

/**
 * 集合的遍历之集合转数组遍历
 * @author 李闯
 *
 */
public class Demo3_Collection {

	public static void main(String[] args) {
//		demo1();
		Collection collection = new ArrayList<>();		
		collection.add(new Student("李四",24));			//Object obj = new Student("李四",24);
		collection.add(new Student("王五",25));
		collection.add(new Student("赵六",26));
		
		Object[] arr = collection.toArray();			//将集合转换为数组,此时这个数组就提升为了Object数组，多态的弊端，不能使用子类特有的属性和行为
		for (int i = 0; i < arr.length; i++) {
			Student s = (Student) arr[i];				//向下转型
			System.out.println(s.getName()+"...."+s.getAge());
		}
	}

	private static void demo1() {
		Collection collection = new ArrayList<>();
		collection.add("a");
		collection.add("b");
		collection.add("c");
		collection.add("d");
		
		//集合转成数组
		Object[] arr = collection.toArray();//返回值是对象类型的数组
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
