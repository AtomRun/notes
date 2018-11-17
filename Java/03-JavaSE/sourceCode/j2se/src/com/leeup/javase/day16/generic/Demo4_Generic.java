package com.leeup.javase.day16.generic;
/**
 * 泛型接口的概述和使用
 * @author 李闯
 *
 */
public class Demo4_Generic {

}

interface Inter<T> {
	public void show(T t);
}

/**
 * 推荐使用这种，
 * 因为本来实现一个类就是为了拓展一个功能，但是没有必要实现接口的时候给自己添加一个泛型，
 * 不是什么类都需要泛型的。加了泛型有时候也很麻烦的，每次创建对象的时候还要去指定一个泛型
 * 没有必要在实现接口的时候给自己类加泛型
 * @author 李闯
 *
 * @param <T>
 */
//class Demo implements Inter<String>{
//
//	@Override
//	public void show(String t) {
//		System.out.println(t);
//	}
//	
//}

class Demo<T> implements Inter<T> {

	@Override
	public void show(T t) {
		
	}
	
}