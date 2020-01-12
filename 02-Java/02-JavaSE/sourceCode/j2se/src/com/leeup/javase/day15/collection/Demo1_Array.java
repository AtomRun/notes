package com.leeup.javase.day15.collection;

import com.leeup.javase.day15.bean.Student;

public class Demo1_Array {

	public static void main(String[] args) {
		//int [] arr = new int [5]; 创建基本数据类型数组
		Student[] arr = new Student[5];//创建引用数据类型数组

		/**
		 * 数组中存储的不是真正的对象，而是对象的地址值
		 */
		arr[0] = new Student("张三",23);//arr[0] 相当于一个Student类型的变量，创建了 一个学生对象，存储在数组的第一个位置
		arr[1] = new Student("李四",24);
		arr[2] = new Student("王五",25);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			//这里打印arr[i] 相当于打印上面对象的引用，即arr[0],默认会调用他的toStrig方法，
			//这个时候Student类没有重写toString方法，所以就调用了Object类的toString方法
		}
	}
}