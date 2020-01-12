package com.leeup.javase.day27.test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * ArrayList<Integer>的一个对象，在这个集合中添加一个字符串数据，如何实现？
 * @author 李闯
 *
 */
public class Test1 {

	public static void main(String[] args) throws Exception {
		
		/**
		 * 泛型只是在编译期有语法检查即限制的，而在运行期，泛型会被擦除掉，即
		 * 生成.class文件后泛型就没了
		 * 但是字节码文件就属于运行期
		 */
		ArrayList<Integer> list = new ArrayList<>();
		list.add(111);
		list.add(222);
		
		Class clazz = Class.forName("java.util.ArrayList");//获取字节码对象
		Method method = clazz.getMethod("add", Object.class);//获取add方法
		method.invoke(list, "你好");
		
		System.out.println(list);
	}
}
