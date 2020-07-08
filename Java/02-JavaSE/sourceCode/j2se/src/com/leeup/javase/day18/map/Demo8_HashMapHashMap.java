package com.leeup.javase.day18.map;

import java.util.HashMap;

import com.leeup.javase.day18.bean.Student;

/**
 * 集合嵌套之HashMap嵌套HashMap
 * @author 李闯
 * 需求：
 * 	1. 双元课堂有很多基础班
 *  2. 第88期基础班定义成一个双列集合，键是学生对象，值是学生的归属地
 *	3. 第99期基础班定义成一个双列集合，键是学生对象，值是学生的归属地
 *		无论是88还是99都是班级对象，所以为了便于统一管理，希望把这些班级对象添加到双元课堂集合中
 */
public class Demo8_HashMapHashMap {

	public static void main(String[] args) {
		//88期
		HashMap<Student, String> hm88 = new HashMap<>();
		hm88.put(new Student("张三",23), "北京");
		hm88.put(new Student("李四",24), "北京");
		hm88.put(new Student("王五",25), "上海");
		hm88.put(new Student("赵六",23), "广州");
		System.out.println(hm88);
		
		//99期
		HashMap<Student, String> hm99 = new HashMap<>();
		hm99.put(new Student("唐僧",1023), "北京");
		hm99.put(new Student("孙悟空",1024), "北京");
		hm99.put(new Student("猪八戒",1025), "上海");
		hm99.put(new Student("沙和尚",1026), "广州");
		System.out.println(hm99);
		
		//定义双元课堂
		HashMap<HashMap<Student, String>, String> hm = new HashMap<>();
		hm.put(hm88, "第88期基础班");
		hm.put(hm99, "第99期基础班");
		
		//便利双列集合
		for(HashMap<Student, String> h : hm.keySet()) {//HashMap<Student, String> h 每一个班级，hm.keySet() 双列集合对应的键集合
			String value = hm.get(h);					//根据get(h) 根据键对象获取值对象
			//遍历键的双列集合对象
			for(Student key : h.keySet()) {				//h.keySet是获取几何中所有的学生键对象
				String	value2 = h.get(key);	
				
				System.out.println(key+"=="+value2+"=="+value);
			}
		}
	}
}
