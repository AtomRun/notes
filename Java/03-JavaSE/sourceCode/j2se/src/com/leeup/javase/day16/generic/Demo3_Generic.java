package com.leeup.javase.day16.generic;

import com.leeup.javase.day16.bean.Student;
import com.leeup.javase.day16.bean.Tool;
import com.leeup.javase.day16.bean.Work;

/**
 * 泛型的由来
 * @author 李闯
 *
 */
public class Demo3_Generic {

	public static void main(String[] args) {
//		demo1();
		Tool<String> t = new Tool<>();
//		t.show("abc");
		t.show(true);
	}

	private static void demo1() {
		Tool<Student> t = new Tool();//创建工具类对象
		t.setObj(new Student("张三",23));
		
		Work work = (Work) t.getObj();	//向下转型
		
		/**
		 * 泛型没出现的时候会出现类似这种类型转换的问题，
		 * java推出泛型是用来解决安全问题的
		 */
		System.out.println(work);
	}
}
