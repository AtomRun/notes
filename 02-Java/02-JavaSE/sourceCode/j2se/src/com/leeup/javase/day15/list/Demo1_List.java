package com.leeup.javase.day15.list;

import java.util.ArrayList;
import java.util.List;

import com.leeup.javase.day15.bean.Student;

/**
 * List集合存储学生对象并遍历
 * 自定义对象,通过getSet方式遍历集合数据
 * @author 李闯
 *
 */
public class Demo1_List {

	public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add(new Student("张三",23));		//父类引用指向子类对象,通过构造方法初始化数据
		list.add(new Student("李四",24));
		list.add(new Student("王五",25));
		list.add(new Student("赵六",26));
		
		for (int i = 0; i < list.size(); i++) {	
//			System.out.println(list.get(i));			//通过索引获取每个元素
			Student student = (Student) list.get(i);
			System.out.println(student.getName()+"....."+student.getAge());
		}
	}
}
