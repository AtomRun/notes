package com.leeup.javase.day27.reflect;

import java.lang.reflect.Constructor;

/**
 * Class类的newInstance()方法是使用该类无参的构造函数创建对象，如果一个类没有无参的构造函数，
 * 就不能这样创建了，可以调 用Class类的getConstructor(String.class,int.class)方法获取一个指定的构造函数
 * 然后再调用Contructor类的newInstance("张三",20)方法创建对象
 */
import com.leeup.javase.day27.bean.Person;

public class Demo3_Constructor {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.leeup.javase.day27.bean.Person");

		//当Person类中没有无参构造函数就不能这样创建了
//		Person p = (Person) clazz.newInstance();//通过无参构造创建对象
		Constructor c = clazz.getConstructor(String.class,int.class);//获取有参构造
		Person person = (Person) c.newInstance("张三",23);//通过有参构造创建对象
		System.out.println(person);

	}
}
