package com.leeup.javase.day18.map;
/**
 * 解释一下Map.Entry
 * @author 李闯
 *
 */
public class Demo4_Map_MapEntry {

	public static void main(String[] args) {
		
	}
}

interface Inter {
	interface Inter2 {
		public void show();
	}
}

/**
 * 根据这种调用方式可知，
 * 正在封闭接口，Entry是Map的内部接口，这里相当与将键和值封装成了一个键值对象，Entry就相当于一个Person对象
 * 而KV调用就可以使用getKey和getValue来获取了
 * @author 李闯
 *
 */
class Demo implements Inter.Inter2 {

	@Override
	public void show() {
		
	}
	
}