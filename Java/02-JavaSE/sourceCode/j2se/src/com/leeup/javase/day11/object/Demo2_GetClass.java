package com.leeup.javase.day11.object;

import com.leeup.javase.day11.test.Student;

public class Demo2_GetClass {

	public static void main(String[] args) {
		Student s = new Student();
		Class clazz = s.getClass();//返回值是Class我们使用Class接收,获取该对象的字节码文件
		//s.getClass 等于 new Class()
		String name = clazz.getName();//获取类名
	}
}
