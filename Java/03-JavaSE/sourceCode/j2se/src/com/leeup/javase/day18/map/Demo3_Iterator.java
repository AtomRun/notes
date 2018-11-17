package com.leeup.javase.day18.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map集合的遍历之键值对对象找键和值,根据键值对对象，获取键和值
 * @author 李闯
 *
 */
public class Demo3_Iterator {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);
		
		//map.Entry说明Entry是Map的内部接口，将键和值封装成了Entry对象，并存储在Set集合中
		//即将map.put("张三", 23); 这里的 "张三", 23 变成了一个对象，Entry对象，存储到Set集合中了
		//存进去就可以拿到每个对象了
		//map.entrySet(); 键值对对象的集合
		//Set<Map.Entry<String, Integer>> 键值对对象
	/*	Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		//获取每个对象
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while (it.hasNext()) {
			//获取每个entry对象，再根据对象获取他的key和value
			Map.Entry<String, Integer> en = it.next();	//父类引用指向子类对象
		//  Entry<String, Integer> en = it.next(); 		//直接获取子类对象
			String key = en.getKey();		//根据键值对对象获取键
			Integer value = en.getValue();	//根据键值对对象获取值
			System.out.println(key+"="+value);
		}
	*/
		//使用增强for循环
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}
