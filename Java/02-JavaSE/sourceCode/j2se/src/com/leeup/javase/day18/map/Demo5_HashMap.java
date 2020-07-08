package com.leeup.javase.day18.map;

import java.util.HashMap;

import com.leeup.javase.day18.bean.Student;

/**
 * HashMap集合键是Student值是String的案例
 * @author 李闯
 * 键就是学生对象，代表每个学生
 * 值是字符串对象，代表学生归属地
 * 
 */
public class Demo5_HashMap {

	public static void main(String[] args) {
		HashMap<Student, String> hm = new HashMap<>();
		hm.put(new Student("张三",23),"北京");
		hm.put(new Student("张三",23),"上海");
		hm.put(new Student("李四",23),"广州");
		hm.put(new Student("王五",23),"深圳");
		/**
		 * 这里的键就相当于HashSet中存储的元素，如果是自定义类的对象，必须重写HashCode和equals方法
		 * 因为如果不重写，两个对象算出来的hashCode值是不同的，不一样就不会调用equals方法去比较，自己就存起来了
		 * 为什么这里上海的会覆盖北京的？
		 */
		System.out.print(hm);
		
	}
}
