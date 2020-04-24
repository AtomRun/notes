### 01. Map集合概述和特点
    1. Map接口概述
        * 查看API可以知道：
            * 将键映射到值的对象
            * 一个映射不能包含重复的键
            * 每个键最多只能映射到一个值
    2. Map接口和Collection接口的不同
        * Map是双列的,Collection是单列的
        * Map的键唯一,Collection的子体系Set是唯一的
        * Map集合的数据结构算法只针对键有效，跟值无关;Collection集合的数据结构是针对元素有效

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
![根据键获取值](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E6%A0%B9%E6%8D%AE%E9%94%AE%E8%8E%B7%E5%8F%96%E5%80%BC.png)
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
```java
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
			Map.Entry<String, Integer> en = it.next();//父类引用指向子类对象
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

```
```java
package com.leeup.javase.day18.map;
/**
 * 解释一下Map.Entry
 * @author 李闯
 *
 */
public class Map_MapEntry {

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
```
    3. 源码分析
![根据键值对对象获取键和值](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E6%A0%B9%E6%8D%AE%E9%94%AE%E5%80%BC%E5%AF%B9%E8%B1%A1%E8%8E%B7%E5%8F%96.png)
### 05. HashMap集合键是Student值是String的案例
    1. 案例演示
        1. HashMap集合键是Student值是String的案例
```java
package com.leeup.javase.day18.map;

import java.util.HashMap;

import com.leeup.javase.day18.bean.Student;

/**
 * HashMap集合键是Student值是String的案例
 * @author 李闯
 * 键就是学生对象，代表每个学生
 * 值是字符串对象，代表学生归属地
 * 
 */
public class Demp5_HashMap {

	public static void main(String[] args) {
		HashMap<Student, String> hm = new HashMap<>();
		hm.put(new Student("张三",23),"北京");
		hm.put(new Student("张三",23),"上海");
		hm.put(new Student("李四",23),"广州");
		hm.put(new Student("王五",23),"深圳");
		/**
		 * 这里的键就相当于HashSet中存储的元素，如果是自定义类的对象，必须重写HashCode和equals方法
		 * 因为如果不重写，两个对象算出来的hashCode值是不同的，不一样就不会调用equals方法去比较，自己就存起来了
		 * 为什么这里上海的会覆盖北京的？
		 */
		System.out.print(hm);
		
	}
}

```
```java
package com.leeup.javase.day18.bean;
/**
 * Student实体
 * @author 李闯
 *
 */
public class Student {

	private int age;
	private String name;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}

```
### 06. LinkedHashMap的概述和使用
    1. 案例演示
        * LinkedHashMap的特点
            * 底层是链表实现的可以保证怎么存就怎么取
```java
package com.leeup.javase.day18.map;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap的概述和使用
 * @author 李闯
 *
 */
public class Demo6_LinkedHashMap {

	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		lhm.put("张三", 23);
		lhm.put("李四", 24);
		lhm.put("赵六", 26);
		lhm.put("王五", 25);
		
		
		System.out.println(lhm);
	}
}

```

### 07. TreeMap集合键是Student值是String的案例
1. 案例演示
	* TreeMap集合键是Student值是String的案例
```java
package com.leeup.javase.day18.map;

import java.util.Comparator;
import java.util.TreeMap;

import com.leeup.javase.day18.bean.Student;


/**
 * TreeMap集合键是Student值是String的案例
 * @author 李闯
 *
 */
public class Demo7_TreeMap {

	public static void main(String[] args) {
//		demo1();
		
		//匿名内部类方式
		TreeMap<Student, String> tm = new TreeMap<>(new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				int num = s1.getName().compareTo(s2.getName());//按照姓名比较
				return num==0?s1.getAge() - s2.getAge():num;
			}
		});
		tm.put(new Student("张三",23), "北京");
		tm.put(new Student("李四",13), "上海");
		tm.put(new Student("王五",33), "广州");
		tm.put(new Student("赵六",26), "深圳");
		
		/**
		 * Student需要重写Comparable接口
		 */
		System.out.println(tm);
	}

	private static void demo1() {
		TreeMap<Student, String> tm = new TreeMap<>();
		tm.put(new Student("张三",23), "北京");
		tm.put(new Student("李四",13), "上海");
		tm.put(new Student("王五",33), "广州");
		tm.put(new Student("赵六",26), "深圳");
		
		/**
		 * Student需要重写Comparable接口
		 */
		System.out.println(tm);
	}
}
```
### 08. 统计字符串中每个字符出现的次数
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
```java
package com.leeup.javase.day18.test;

import java.util.HashMap;

/**
 * 统计字符串中每个字符出现的次数
 * @author 李闯
 * 分析：
 * 	1. 定义一个需要被统计字符的字符串
 * 	2. 将字符串转换为字符数组
 * 	3. 定义双列集合，用来存储字符串以及字符串出现的次数
 *  4. 遍历字符数组获取每个字符并将字符存储在双列集合中
 *  5. 存储过程中要做判断：如果集合中不包含这个键，就将该字符当作键，值为1存储，如果集合中包含这个键，值就加1存储 
 *  6. 打印双列集合，获取字符出现的次数
 */
public class Test1 {

	public static void main(String[] args) {
		//1 
		String str = "aaabbbccccccccc";
		//2 
		char [] arr = str.toCharArray();
		//3 如果没有特殊要求，使用HashMap,HashMap是最快的，因为LinkedHashMap底层是使用链表实现的，它能保证怎么存怎么取
		//TreeMap会排序，存和取不一致
		HashMap<Character, Integer> hm = new HashMap<>();
		//4
		for (char c : arr) {
		/*	if (!hm.containsKey(c)) {//如果不包含这个键
				hm.put(c, 1);
			}else {
				hm.put(c, hm.get(c)+1);//包含这个键位，+1存起来
			}
		*/
			//5 使用三元运算符优化
			hm.put(c, !hm.containsKey(c)?1:hm.get(c)+1);
		}
		//6
		for (Character key : hm.keySet()) {	//hm.keySet代表所有键的集合。Character key是每个键位
			System.out.println(key+"="+hm.get(key));//hm.get(key)根据键获取值
		}
	}
}

```

### 09. 集合嵌套之HashMap嵌套HashMap
    1. 案例演示
        * 集合嵌套之HashMap嵌套HashMap
```java
package com.leeup.javase.day18.map;

import java.util.HashMap;

import com.leeup.javase.day18.bean.Student;

/**
 * 集合嵌套之HashMap嵌套HashMap
 * @author 李闯
 * 需求：
 * 	1. 双元课堂有很多基础班
 *  2. 第88期基础班定义成一个双列集合，键是学生对象，值是学生的归属地
 *	3. 第99期基础班定义成一个双列集合，键是学生对象，值是学生的归属地
 *		无论是88还是99都是班级对象，所以为了便于统一管理，希望把这些班级对象添加到双元课堂集合中
 */
public class Demo8_HashMapHashMap {

	public static void main(String[] args) {
		//88期
		HashMap<Student, String> hm88 = new HashMap<>();
		hm88.put(new Student("张三",23), "北京");
		hm88.put(new Student("李四",24), "北京");
		hm88.put(new Student("王五",25), "上海");
		hm88.put(new Student("赵六",23), "广州");
		System.out.println(hm88);
		
		//99期
		HashMap<Student, String> hm99 = new HashMap<>();
		hm99.put(new Student("唐僧",1023), "北京");
		hm99.put(new Student("孙悟空",1024), "北京");
		hm99.put(new Student("猪八戒",1025), "上海");
		hm99.put(new Student("沙和尚",1026), "广州");
		System.out.println(hm99);
		
		//定义双元课堂
		HashMap<HashMap<Student, String>, String> hm = new HashMap<>();
		hm.put(hm88, "第88期基础班");
		hm.put(hm99, "第99期基础班");
		
		//便利双列集合
		for(HashMap<Student, String> h : hm.keySet()) {//HashMap<Student, String> h 每一个班级，hm.keySet() 双列集合对应的键集合
			String value = hm.get(h);					//根据get(h) 根据键对象获取值对象
			//遍历键的双列集合对象
			for(Student key : h.keySet()) {				//h.keySet是获取几何中所有的学生键对象
				String	value2 = h.get(key);	
				
				System.out.println(key+"=="+value2+"=="+value);
			}
		}
	}
}
```

### 10. HashMap和Hashtable的区别
    1. 面试题
        * HashMap和Hashtable的区别
            * Hashtable是JDK1.0版本出现的,是线程安全的,效率低,HashMap是JDK1.2版本出现的,是线程不安全的,效率高
            * Hashtable不可以存储null键和null值,HashMap可以存储null键和null值
    2. 案例演示	
        * HashMap和Hashtable的区别
```java
package com.leeup.javase.day18.map;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * HashMap和Hashtable的区别
 * 面试题
 * @author 李闯
 * 	共同点：
 * 		1. 底层都是使用哈希算法
 * 		2. 都是双列集合
 * 	不同点：
 * 		1. HashMap是线程不安全的，效率高，JDK1.2版本
 * 		   HashTable线程安全的，效率低，JDK1.0版本
 * 		2. HashMap可以存储null键和null值
 * 		   HashTable不可以存储null键位和null值
 * 		
 *
 */
public class Demo9_HashTable {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put(null, 32);
		hm.put("lisi", null);
		System.out.println(hm);
		
		//不可以存储null键和null值
		Hashtable<String, Integer> ht = new Hashtable<>();
		ht.put(null, 32);
		ht.put("lisi", null);
		System.out.println(ht);
	}
}
```

### 11. Collections工具类的概述和常见方法讲解
    1. Collections类概述
        * 针对集合操作 的工具类
    2. Collections成员方法
    * 
            public static <T> void sort(List<T> list)
            public static <T> int binarySearch(List<?> list,T key)
            public static <T> T max(Collection<?> coll)
            public static void reverse(List<?> list)
            public static void shuffle(List<?> list)
```java
package com.leeup.javase.day18.collections;

import java.util.ArrayList;
import java.util.Collections;


/**
 *11. Collections工具类的概述和常见方法讲解
    1. Collections类概述
        * 针对集合操作 的工具类
    2. Collections成员方法
 * @author 李闯
 *
 */
public class Demo1_Collections {

	public static void main(String[] args) {
//		demo1();
//		demo2();
		
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("f");
		list.add("g");
		System.out.println(Collections.max(list));		//根据默认排序结果获取集合中的最大值
		Collections.reverse(list);
		System.out.println(list);						//反转集合
		
		Collections.shuffle(list);
		System.out.println(list);						//随即置换元素位置。可以用来洗牌
	}

	private static void demo2() {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("f");
		list.add("g");
		
		System.out.println(Collections.binarySearch(list, "c"));
		System.out.println(Collections.binarySearch(list, "b"));
	}

	private static void demo1() {
		ArrayList<String> list = new ArrayList<>();
		list.add("c");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("d");
		
		System.out.println(list);
		Collections.sort(list);
		//重复的时候会保留并且排序
		System.out.println(list);
	}
}

```
### 12. 模拟斗地主洗牌和发牌
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
```java
package com.leeup.javase.day18.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 模拟斗地主洗牌和发牌
 * @author 李闯
 *	分析：
 *	1. 卖一副扑克，其实就是自己创建一个集合对象，将扑克牌存储进去
 *	2. 洗牌
 *	3. 发牌
 *  4. 看牌
 */
public class Test2 {

	public static void main(String[] args) {
		String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] color = {"方片","梅花","红桃","黑桃"};
		
		ArrayList<String> poker = new ArrayList<>();
		
		//拼接字符串，花色和数字
		for (String s1 : color) {
			for (String s2 : num) {
				poker.add(s1.concat(s2));	//concat连接两个字符串
			}
		}
		poker.add("小王");
		poker.add("大王");
		//洗牌
		Collections.shuffle(poker);
		ArrayList<String> gaojin = new ArrayList<>();
		ArrayList<String> longwu = new ArrayList<>();
		ArrayList<String> me = new ArrayList<>();
		ArrayList<String> dipai = new ArrayList<>();
		for(int i =0;i<poker.size();i++) {
			if (i>=poker.size()-3) {
				dipai.add(poker.get(i));//将三张底牌存储在底牌集合中
			}else if (i % 3 ==0) {		//等于0的都给高进
				gaojin.add(poker.get(i));
			}else if (i % 3 ==1) {
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
	}
}

```
### 13. 模拟斗地主洗牌和发牌并对牌进行排序的原理图解
1. 画图演示
	* 画图说明排序原理
![斗地主](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E6%96%97%E5%9C%B0%E4%B8%BB.png)
### 14. 模拟斗地主洗牌和发牌并对牌进行排序的代码实现
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
```java
package com.leeup.javase.day18.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * 
 * @author 李闯
 *
 */
public class Test3 {

	public static void main(String[] args) {
		String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] color = {"方片","梅花","红桃","黑桃"};
		HashMap<Integer, String> hm = new HashMap<>();	//存储索引和扑克牌
		ArrayList<Integer> list = new ArrayList<>();	//存储索引
		int index = 0;									//索引值
		
		//拼接扑克牌并将索引和扑克牌存储在hashMap集合中
		for(String s1 : num) {					//获取数字
			for(String s2 : color) {			//获取颜色
				hm.put(index, s2.concat(s1));	//将颜色和数字拼接
				list.add(index);				//将索引0-51添加到list集合
				index++;						//索引增加，遍历索引的牌
			}
		}
		//将小王添加到双列集合中
		hm.put(index,"小王");
		list.add(index);						//将52索引添加到集合中
		index++;
		hm.put(index, "大王");					
		list.add(index);						//将53索引添加到集合中
		
		//洗牌
		Collections.shuffle(list);
		//发牌
		TreeSet<Integer> gaojin = new TreeSet<>();
		TreeSet<Integer> longwu = new TreeSet<>();
		TreeSet<Integer> me = new TreeSet<>();
		TreeSet<Integer> dipai = new TreeSet<>();
		
		for(int i = 0; i<list.size(); i++) {
			if (i>=list.size()-3) {
				dipai.add(list.get(i));			//将三张底牌存储在底牌集合中
			}else if (i%3==0) {
				gaojin.add(list.get(i));
			}else if (i%3==1) {
				longwu.add(list.get(i));
			}else{
				me.add(list.get(i));
			}
		}
		
		//看牌
		lookPoker(hm, gaojin, "高进");
		lookPoker(hm, longwu, "龙武");
		lookPoker(hm, me, "我");
		lookPoker(hm, dipai, "底牌");
	}
	/**
	 * 看牌
	 * 	1. 返回值类型void
	 * 	2. 参数列表：HashMap 放的是键和值的关系，TreeSet 存的所有索引，String name 到底是谁的牌
	 */
	public static void lookPoker
	(HashMap<Integer, String> hm,TreeSet<Integer> ts,String name) {
		System.out.println(name+"的牌是：");
		for (Integer i : ts) {		//拿到了健集合的所有的键，i代表每个键
			System.out.print(hm.get(i)+" ");//根据键获取值
		}
		System.out.println();
	}
}

```
### 15. 泛型固定下边界
	* ? super E
```java
package com.leeup.javase.day18.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import com.leeup.javase.day18.bean.BaseStudent;
import com.leeup.javase.day18.bean.Student;

/**
 * 泛型固定下边界
 *? super E
 * @author 李闯
 *泛型固定上边界
 *? extends E
 */
public class Demo2_Genric {

	public static void main(String[] args) {
//		demo1();
		
		TreeSet<Student> ts1 = new TreeSet<>(new CompareByAge());
		ts1.add(new Student("张三",33));
		ts1.add(new Student("李四",13));
		ts1.add(new Student("王五",23));
		ts1.add(new Student("赵六",43));
		
//		System.out.printl n(ts1);
		
		TreeSet<BaseStudent> ts2 = new TreeSet<>(new CompareByAge());
		ts2.add(new BaseStudent("张三",33));
		ts2.add(new BaseStudent("李四",13));
		ts2.add(new BaseStudent("王五",23));
		ts2.add(new BaseStudent("赵六",43));
		
		System.out.println(ts2);
		
	}

	private static void demo1() {
		//? extends E
		ArrayList<Student> list1 = new ArrayList<>();
		list1.add(new Student("张三",23));
		list1.add(new Student("李四",24));
		
		ArrayList<BaseStudent> list2 = new ArrayList<>();
		list2.add(new BaseStudent("王五",25));
		list2.add(new BaseStudent("赵六",26));
		
		list1.addAll(list2);//将子类对象添加到父类的集合中去
	}
}

class CompareByAge implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		int num = s1.getAge() - s2.getAge();
		return num == 0 ? s1.getName().compareTo(s2.getName()) : num;
	}
}
```
### 16_day18总结
	* 把今天的知识点总结一遍。
```java
package com.leeup.javase.day18.collections;
/**
 * Collection
 * 		List(存取有序，有索引，可以重复)
 * 			ArrayList
 * 				底层是数组实现的，线程不安全的，查询和修改快，增加删除慢
 * 			LinkedList
 * 				底层是链表实现的，线程不安全的，增加和删除比较快，查找和修改比较慢
 * 			Vector
 * 				底层是数组实现的，线程安全的，无论增删改查都慢
 * 			如果查找和修改多，使用ArrayList
 * 			如果增加和删除多，使用LinkedList
 * 			如果都多，使用ArrayList
 * 		Set(存取无序，无索引，不可以重复)
 * 			HashSet
 * 				底层是Hash算法实现的
 * 				LinkedHashSet
 * 					底层是链表实现的，但是也可以保证元素唯一和HashSet原理一样
 * 			TreeSet
 * 				底层是二叉树算法实现
 * 			一般在开发的时候不需要对存储的元素排序，所以在开发的时候，大多用HashSet,HashSet的效率比较高
 * 			TreeSet在面试的时候比较多，比如问有几种排序方式，和几种排序方式的区别
 * 		Map()
 * 			HashMap
 * 				底层针对键来说是Hash算法
 * 				LinkedHashMap
 * 					底层是链表，也是针对键
 * 			TreeMap
 * 				底层是二叉树算法，针对键
 * 			开发中用HashMao比较多，
 * 			单列集合如果存储的是重复的元素，优先考虑ArrayList，如果不需要重复的元素，优先考虑HashSet.
 * 			双列集合优先考虑HashMap,付费需要对键进行排序。在考虑TreeMap
 * 				
 * @author 李闯
 *
 */
public class Demo3_Collection {

	public static void main(String[] args) {
		
	}
}

```
