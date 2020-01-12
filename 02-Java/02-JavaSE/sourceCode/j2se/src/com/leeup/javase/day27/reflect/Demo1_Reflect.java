package com.leeup.javase.day27.reflect;

import com.leeup.javase.day27.bean.Person;

public class Demo1_Reflect {

	public static void main(String[] args) throws ClassNotFoundException {
		Class class1 = Class.forName("com.leeup.javase.day27.bean.Person");
		
		Class class2 = Person.class;
		
		Person person = new Person();
		Class class3 = person.getClass();
		
		System.out.println(class1 == class2);
		System.out.println(class3 == class2);
		System.out.println(class3 == class1);
	}
}
