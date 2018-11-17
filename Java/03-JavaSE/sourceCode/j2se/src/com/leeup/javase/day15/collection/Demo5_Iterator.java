package com.leeup.javase.day15.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.leeup.javase.day15.bean.Student;


/**
 * 集合的遍历之迭代器遍历
 * @author 李闯
 *
 */
public class Demo5_Iterator {

	public static void main(String[] args) {
//		demo1();
		
		/**
		 * 自定义对象迭代
		 */
		Collection c = new ArrayList();
		c.add(new Student("张三",23));		//Object obj = new Student("王五",25);
		c.add(new Student("李四", 24));
		c.add(new Student("王五",25));
		c.add(new Student("赵六",26)); 
		
		//获取迭代器
		Iterator it = c.iterator();
		while (it.hasNext()) {
//			System.out.println(it.next());//调用toString方法
			Student student = (Student) it.next();//向下转型
			System.out.println(student.getName()+"..."+student.getAge());
		}
	}

	private static void demo1() {
		Collection c = new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		
		//对集合中的元素进行迭代(遍历)
		Iterator it = c.iterator();//获取迭代器的引用,可以调用迭代器中的方法
	/*	boolean b1 = it.hasNext();//判断集合中是否有元素,有就返回true
		Object obj1 = it.next();
		System.out.println(b1);
		System.out.println(obj1);
		
		boolean b2 = it.hasNext();
		Object obj2 = it.next();//第二次调用next指针向后移一位,可以得到后面的值
		System.out.println(b1);
		System.out.println(obj2);*/
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
