### 01. Map集合概述和特点
    1. Map接口概述
        * 查看API可以知道：
            * 将键映射到值的对象
            * 一个映射不能包含重复的键
            * 每个键最多只能映射到一个值
    2. Map接口和Collection接口的不同
        * Map是双列的,Collection是单列的
        * Map的键唯一,Collection的子体系Set是唯一的
        * Map集合的数据结构值针对键有效，跟值无关;Collection集合的数据结构是针对元素有效
	
### 02. Map集合的功能概述
    1. Map集合的功能概述
        1. 添加功能
            * V put(K key,V value):添加元素。
                * 如果键是第一次存储，就直接存储元素，返回null
                * 如果键不是第一次存在，就用值把以前的值替换掉，返回以前的值
        2. 删除功能
            * void clear():移除所有的键值对元素
            * V remove(Object key)：根据键删除键值对元素，并把值返回
        3. 判断功能
            * boolean containsKey(Object key)：判断集合是否包含指定的键
            * boolean containsValue(Object value):判断集合是否包含指定的值
            * boolean isEmpty()：判断集合是否为空
        4. 获取功能
            * Set<Map.Entry<K,V>> entrySet():
            * V get(Object key):根据键获取值
            * Set<K> keySet():获取集合中所有键的集合
            * Collection<V> values():获取集合中所有值的集合
        5. 长度功能
            * int size()：返回集合中的键值对的个数
```java
package com.leeup.javase.day18.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Map集合的功能概述
 * @author 李闯
 *
 */
public class Demo1_Map {

	public static void main(String[] args) { 
//		demo1();
		
//		demo2();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);
		
		Collection<Integer> c = map.values();
		System.out.println(c);
		System.out.println(map.size());//一对代表一条记录，四个元素
	}

	private static void demo2() {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);
		
		
		Integer value = map.remove("张三");//根据键删除元素值，返回键对应的值
		System.out.println(value);
		
		System.out.println(map.containsKey("张三"));//判断是否包含张三这个key
		System.out.println(map.containsValue(23));//判断是否包含23这个value
	}

	private static void demo1() {
		Map<String, Integer> map = new HashMap<>();
		Integer i1 = map.put("张三", 23);
		Integer i2 = map.put("李四", 24);
		Integer i3 = map.put("王五", 25);
		Integer i4 = map.put("赵六", 26);
		
		Integer i5 = map.put("张三", 26);
		
		System.out.println(map);
		
		
		/**
		 * 输出结果为null
		 * 因为双列集合是这样的，往里寸的时候，如果没有张三这个键，就把k,v存进去，返回被覆盖的部分，但是由于集合中没有
		 * 被张三23，所以返回是null ，因为覆盖的是null
		 */
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		
		//i5是23，把被覆盖的值返回，即相同的键不存储，键是唯一的，值覆盖
		System.out.println(i5);
	}
}

```

### 03. Map集合的遍历之键找值
    1. 键找值思路：
        * 获取所有键的集合
        * 遍历键的集合，获取到每一个键
        * 根据键找值
    2. 案例演示
        * Map集合的遍历之键找值

                HashMap<String, Integer> hm = new HashMap<>();
                hm.put("张三", 23);
                hm.put("李四", 24);
                hm.put("王五", 25);
                hm.put("赵六", 26);
                
                /*Set<String> keySet = hm.keySet();			//获取集合中所有的键
                Iterator<String> it = keySet.iterator();	//获取迭代器
                while(it.hasNext()) {						//判断单列集合中是否有元素
                    String key = it.next();					//获取集合中的每一个元素,其实就是双列集合中的键
                    Integer value = hm.get(key);			//根据键获取值
                    System.out.println(key + "=" + value);	//打印键值对
                }*/
                
                for(String key : hm.keySet()) {				//增强for循环迭代双列集合第一种方式
                    System.out.println(key + "=" + hm.get(key));
                }
```java
package com.leeup.javase.day18.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的遍历之键找值
 * 通过查看Map集合API发现没有iterator方法，那么双列结合如何迭代呢？
 * @author 李闯
 *
 */
public class Demo2_Iterator {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);
		
		Integer i = map.get("张三");			//get方法，根据键获取值
		System.out.println(i);
		
		//遍历，获取所有的键
	/*	Set<String> keyset = map.keySet();//获取所有键的集合
		
		//
		Iterator<String> it = keyset.iterator();
		while (it.hasNext()) {				//判断集合中是否有元素
			String key = it.next();			//获取每个键
			Integer value = map.get(key);	//根据遍历的每个键位获取值
			System.out.println(key+"="+value);
		}
		*/
		//使用增强for循环遍历
		for (String key : map.keySet()) {	//map.keySet是所有键的集合
			System.out.println(key+"="+map.get(key));
		}
	}
}
```

### 04. Map集合的遍历之键值对对象找键和值
    1. 键值对对象找键和值思路：
        1. 获取所有键值对对象的集合
        2. 遍历键值对对象的集合，获取到每一个键值对对象
        3. 根据键值对对象找键和值
    2. 案例演示
        1. Map集合的遍历之键值对对象找键和值
        
                HashMap<String, Integer> hm = new HashMap<>();
                hm.put("张三", 23);
                hm.put("李四", 24);
                hm.put("王五", 25);
                hm.put("赵六", 26);
                /*Set<Map.Entry<String, Integer>> entrySet = hm.entrySet();	//获取所有的键值对象的集合
                Iterator<Entry<String, Integer>> it = entrySet.iterator();//获取迭代器
                while(it.hasNext()) {
                    Entry<String, Integer> en = it.next();				//获取键值对对象
                    String key = en.getKey();								//根据键值对对象获取键
                    Integer value = en.getValue();							//根据键值对对象获取值
                    System.out.println(key + "=" + value);
                }*/
                
                for(Entry<String,Integer> en : hm.entrySet()) {
                    System.out.println(en.getKey() + "=" + en.getValue());
                }
            
    3. 源码分析

### 05. HashMap集合键是Student值是String的案例
    1. 案例演示
        1. HashMap集合键是Student值是String的案例

### 06. LinkedHashMap的概述和使用)
1. 案例演示
	* LinkedHashMap的特点
		* 底层是链表实现的可以保证怎么存就怎么取

### 07. TreeMap集合键是Student值是String的案例)
1. 案例演示
	* TreeMap集合键是Student值是String的案例

### 08. 统计字符串中每个字符出现的次数)
1. 案例演示
	* 需求：统计字符串中每个字符出现的次数
			String str = "aaaabbbcccccccccc";
			char[] arr = str.toCharArray();						//将字符串转换成字符数组
			HashMap<Character, Integer> hm = new HashMap<>();	//创建双列集合存储键和值
			
			for(char c : arr) {									//遍历字符数组
				/*if(!hm.containsKey(c)) {						//如果不包含这个键
					hm.put(c, 1);								//就将键和值为1添加
				}else {											//如果包含这个键
					hm.put(c, hm.get(c) + 1);					//就将键和值再加1添加进来
				}
				
				//hm.put(c, !hm.containsKey(c) ? 1 : hm.get(c) + 1);
				Integer i = !hm.containsKey(c) ? hm.put(c, 1) : hm.put(c, hm.get(c) + 1);
						}
			
			for (Character key : hm.keySet()) {					//遍历双列集合
				System.out.println(key + "=" + hm.get(key));
			}


### 09. 集合嵌套之HashMap嵌套HashMap)
1. 案例演示
	* 集合嵌套之HashMap嵌套HashMap

### 10. HashMap和Hashtable的区别)
1. 面试题
	* HashMap和Hashtable的区别
		* Hashtable是JDK1.0版本出现的,是线程安全的,效率低,HashMap是JDK1.2版本出现的,是线程不安全的,效率高
		* Hashtable不可以存储null键和null值,HashMap可以存储null键和null值
2. 案例演示	
	* HashMap和Hashtable的区别

### 11. Collections工具类的概述和常见方法讲解)
1. Collections类概述
	* 针对集合操作 的工具类
2. Collections成员方法
* 
		public static <T> void sort(List<T> list)
		public static <T> int binarySearch(List<?> list,T key)
		public static <T> T max(Collection<?> coll)
		public static void reverse(List<?> list)
		public static void shuffle(List<?> list)

### 12. 模拟斗地主洗牌和发牌)
1. 案例演示
	* 模拟斗地主洗牌和发牌，牌没有排序

			//买一副扑克
			String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
			String[] color = {"方片","梅花","红桃","黑桃"};
			ArrayList<String> poker = new ArrayList<>();
			
			for(String s1 : color) {
				for(String s2 : num) {
					poker.add(s1.concat(s2));
				}
			}
			
			poker.add("小王");
			poker.add("大王");
			//洗牌
			Collections.shuffle(poker);
			//发牌
			ArrayList<String> gaojin = new ArrayList<>();
			ArrayList<String> longwu = new ArrayList<>();
			ArrayList<String> me = new ArrayList<>();
			ArrayList<String> dipai = new ArrayList<>();
			
			for(int i = 0; i < poker.size(); i++) {
				if(i >= poker.size() - 3) {
					dipai.add(poker.get(i));
				}else if(i % 3 == 0) {
					gaojin.add(poker.get(i));
				}else if(i % 3 == 1) {
					longwu.add(poker.get(i));
				}else {
					me.add(poker.get(i));
				}
			}
			
			//看牌
			
			System.out.println(gaojin);
			System.out.println(longwu);
			System.out.println(me);
			System.out.println(dipai);

### 13. 模拟斗地主洗牌和发牌并对牌进行排序的原理图解)
1. 画图演示
	* 画图说明排序原理

### 14. 模拟斗地主洗牌和发牌并对牌进行排序的代码实现)
1. 案例演示
	* 模拟斗地主洗牌和发牌并对牌进行排序的代码实现
* 
			//买一副牌
			String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
			String[] color = {"方片","梅花","红桃","黑桃"};
			HashMap<Integer, String> hm = new HashMap<>();			//存储索引和扑克牌
			ArrayList<Integer> list = new ArrayList<>();			//存储索引
			int index = 0;											//索引的开始值
			for(String s1 : num) {
				for(String s2 : color) {
					hm.put(index, s2.concat(s1));					//将索引和扑克牌添加到HashMap中
					list.add(index);								//将索引添加到ArrayList集合中
					index++;
				}
			}
			hm.put(index, "小王");
			list.add(index);
			index++;
			hm.put(index, "大王");
			list.add(index);
			//洗牌
			Collections.shuffle(list);
			//发牌
			TreeSet<Integer> gaojin = new TreeSet<>();
			TreeSet<Integer> longwu = new TreeSet<>();
			TreeSet<Integer> me = new TreeSet<>();
			TreeSet<Integer> dipai = new TreeSet<>();
			
			for(int i = 0; i < list.size(); i++) {
				if(i >= list.size() - 3) {
					dipai.add(list.get(i)); 						//将list集合中的索引添加到TreeSet集合中会自动排序
				}else if(i % 3 == 0) {
					gaojin.add(list.get(i));
				}else if(i % 3 == 1) {
					longwu.add(list.get(i));
				}else {
					me.add(list.get(i));
				}
			}
			
			//看牌
			lookPoker("高进", gaojin, hm);
			lookPoker("龙五", longwu, hm);
			lookPoker("冯佳", me, hm);
			lookPoker("底牌", dipai, hm);
			
		}
		
		public static void lookPoker(String name,TreeSet<Integer> ts,HashMap<Integer, String> hm) {
			System.out.print(name + "的牌是:");
			for (Integer index : ts) {
				System.out.print(hm.get(index) + " ");
			}
			
			System.out.println();
		}
### 15. 泛型固定下边界)
* ? super E

### 16_day18总结
* 把今天的知识点总结一遍。

