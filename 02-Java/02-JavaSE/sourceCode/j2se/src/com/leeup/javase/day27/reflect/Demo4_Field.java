package com.leeup.javase.day27.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.leeup.javase.day27.bean.Person;

public class Demo4_Field {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.leeup.javase.day27.bean.Person");
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		
		Person person = (Person) constructor.newInstance("张三",23);
		
//		Field f = clazz.getField("name");			//获取姓名字段
//		f.set(person, "李四");						//修改姓名的值
		
		//name是私有的，我们要暴力反射获取字段
		Field f = clazz.getDeclaredField("name");
		f.setAccessible(true);			//去除这个字段的私有权限
		f.set(person, "李四");
		
		System.out.println(person);
	}
}
