package com.leeup.javase.day16.jdk5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Arrays工具类的asList()方法的使用
 * 数组转换成集合
 * @author 李闯
 *
 */
public class Demo4_AsList {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
		//集合转为数组,加泛型的方法
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		/**
		 * 当集合转换数组时,数组的长度如果小于等于集合的size[集合的元素个数]
		 * 转换后的数组长度等于集合的size,如果数组的长度大于size分配的数组长度就和你指定的长度一样
		 */
		String[] arr = list.toArray(new String[1]);
		
		for (String string : arr) {
			System.out.println(string);
		}
		
	}

	private static void demo2() {
		int[] arr = {11,22,33,44,55};
		List<int[] > list = Arrays.asList(arr);//泛型是int数据类型的
		System.out.println(list);//输出结果  [[I@15db9742] 地址值 相当于把整个数组当成一个对象去存储 
								//因为数组中存储的是基本数据类型int,整个对象是个数组是个引用数据类型,而集合
								//只能存储基本数据类型,所以把整个数组看成一个对象存储到list集合
		
		//想将数组转换为集合,数组必须是引用数据类型,即使用包装类定义数组
		Integer[] arr1 = {11,22,33,44,55};
		List<Integer> list1 = Arrays.asList(arr1);
		System.out.println(list1);
	}

	private static void demo1() {
		String[] arr= {"a","b","c"};
		List<String> list = Arrays.asList(arr);		//将数组转换成集合
		System.out.println(list);
		
//		list.add("d");	不能添加
		System.out.println(list);//java.lang.UnsupportedOperationException  不支持更改的异常
		//数组虽然能转集合,但是不支持这种操作,数组转换成集合虽然不能增加huo'zhe减少元素,但是可以使用集合的思想
		//操作数组,也就是说可以使用其他集合中的方法,即除了增加或者减少的方法都可以使用
	}
}
