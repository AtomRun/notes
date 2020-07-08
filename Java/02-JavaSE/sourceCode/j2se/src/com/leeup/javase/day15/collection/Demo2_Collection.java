package com.leeup.javase.day15.collection;

import java.util.ArrayList;
import java.util.Collection;

import com.leeup.javase.day15.bean.Student;

/**
 * Collection集合的基本功能测试
 * @author 李闯
 *
 */
@SuppressWarnings("all")
public class Demo2_Collection {

	public static void main(String[] args) {
//		demo1();
		Collection c = new ArrayList<>();	//父类引用指向子类对象
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		
//		c.remove("b");			//删除指定元素
//		c.clear();				//清空集合
//		System.out.println(c.contains("b"));//判断是否包含某个元素值
		System.out.println(c.isEmpty());	//判断集合是否为空
		System.out.println(c.size());		//获取元素的个数
		System.out.println(c);
		
	}

	private static void demo1() {
		Collection c = new ArrayList<>();	//父类引用指向子类对象
		
		/**
		 * add方法如果是List集合，一直都返回true，因为List集合中可以存储重复元素的，如果是Set集合
		 * 存储重复元素的时候，就会返回false
		 * 
		 * ArrayList的父类的父类重写了toString方法，所以在打印对象引用的时候，输出的结果
		 * 不是Object类中的toString结果
		 */
		boolean b1 = c.add("abc");//参数可以放任意对象
		boolean b2 = c.add(true);//添加的时候自动装箱，基本数据类型转换为对象，即new Boolean(true); 即将true封装成对象添加到集合中了
		boolean b3 = c.add(100);//原理同上
		boolean b4 = c.add(new Student("张三",23));//将自定义对象添加进来同样是父类引用指向子类对象
		boolean b5 = c.add("abc");
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		
		
		/**
		 * AbstractCollection 重写了toString方法，ArrayList的toSting继承于AbstractCollection
		 */
		System.out.println(c);
	}
}
