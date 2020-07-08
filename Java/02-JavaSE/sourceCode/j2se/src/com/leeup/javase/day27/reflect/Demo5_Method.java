package com.leeup.javase.day27.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.leeup.javase.day27.bean.Person;

public class Demo5_Method {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.leeup.javase.day27.bean.Person");
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		Person person = (Person) constructor.newInstance("张三",23);
		
		Method method = clazz.getMethod("eat");			//获取eat方法
		method.invoke(person);
		
		Method method2 = clazz.getMethod("eat", int.class);//获取有参的eat方法
		method2.invoke(person, 10);							
		
	}
}
