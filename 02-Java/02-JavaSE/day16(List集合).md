### 01. 去除ArrayList中重复字符串元素方式
    1. 案例演示
        1. 需求：ArrayList去除集合中字符串的重复值(字符串的内容相同)
        2. 思路：创建新集合方式
    
    		/**
    		 *  A:案例演示
    		 * 需求：ArrayList去除集合中字符串的重复值(字符串的内容相同)
    		 * 思路：创建新集合方式
    		 */
    		public static void main(String[] args) {
    			ArrayList list = new ArrayList();
    			list.add("a");
    			list.add("a");
    			list.add("b");
    			list.add("b");
    			list.add("b");
    			list.add("c");
    			list.add("c");
    			list.add("c");
    			list.add("c");
    			
    			System.out.println(list);
    			ArrayList newList = getSingle(list);
    			System.out.println(newList);
    		}
    	
    		/*
    		 * 去除重复
    		 * 1,返回ArrayList
    		 * 2,参数列表ArrayList
    		 */
    		public static ArrayList getSingle(ArrayList list) {
    			ArrayList newList = new ArrayList();			//创建一个新集合
    			Iterator it = list.iterator();					//获取迭代器
    			while(it.hasNext()) {							//判断老集合中是否有元素
    				String temp = (String)it.next();			//将每一个元素临时记录住
    				if(!newList.contains(temp)) {				//如果新集合中不包含该元素
    					newList.add(temp);						//将该元素添加到新集合中
    				}
    			}
    			return newList;									//将新集合返回
    		}
```java
package com.leeup.javase.day16.list;
/**
 * 去除ArrayList中重复字符串元素方式
 * @author 李闯
 *
 */

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("all")
public class Demo1_ArrayList {

	
	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		
		ArrayList newList = getSingle(list);
		System.out.println(newList);
		
		
	}
	
	/**
	 * 创建新集合,将重复元素去掉
	 * 1. 明确返回值类型返回 ArrayList
	 * 2. 明确参数列表  集合ArrayList
	 * 
	 * 分析:
	 * 	1. 创建新集合
	 *  2. 根据传入的集合(老集合)获取迭代器
	 *  3. 遍历老集合
	 *  4. 判断通过新集合判断是否包含老集合中的元素,如果包含就不添加到新集合中,如果不包含就添加进去
	 */ 
	public static ArrayList getSingle(ArrayList list) {
		ArrayList newList = new ArrayList();		//1. 创建新集合
		Iterator it = list.iterator();			//2. 根据传入的集合(老集合)获取迭代器
		while (it.hasNext()) {					//3. 遍历老集合
			Object obj = it.next();				//记录住每一个元素
			if (!newList.contains(obj)) {
				newList.add(obj);				//如果新集合中不包含老集合中元素,就将元素添加到新集合中
			}
		}
		return newList;
	}
}
```
### 02. 去除ArrayList中重复自定义对象元素 
    1. 案例演示
        1. 需求：ArrayList去除集合中自定义对象元素的重复值(对象的成员变量值相同)
    2. 注意事项
        1. 重写equals()方法的
```java
package com.leeup.javase.day16.list;

import java.util.ArrayList;
import java.util.Iterator;

import com.leeup.javase.day16.bean.Person;

/**
 * 去除ArrayList中重复自定义对象元素
 * @author 李闯
 *
 */
@SuppressWarnings("all")
public class Demo2_ArrayList {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();//创建集合对象
		list.add(new Person("张三",23));
		list.add(new Person("张三",23));
		list.add(new Person("李四",24));
		list.add(new Person("李四",24));
		list.add(new Person("李四",24));
		list.add(new Person("李四",24));
		
//		ArrayList newList = getSingle(list);		//调用方法，去除重复
//		System.out.println(newList);
		
		/**
		 * remove方法底层也依赖equals方法
		 */
		list.remove(new Person("张三",23));
		System.out.println(list);
	}
	

	public static ArrayList getSingle(ArrayList list) {
		ArrayList newList = new ArrayList();		
		Iterator it = list.iterator();			
		while (it.hasNext()) {	
			Object obj = it.next();		
			/**
			 * contains判断是否包含，方法底层依赖的是equals方法
			 */
			if (!newList.contains(obj)) {
				newList.add(obj);				
			}
		}
		return newList;
	}
}
```

### 03. LinkedList的特有功能
    1. LinkedList类概述
    2. LinkedList类特有功能
        1. public void addFirst(E e)及addLast(E e)
        2. public E getFirst()及getLast()
        3. public E removeFirst()及public E removeLast()
        4. public E get(int index);
```java
package com.leeup.javase.day16.list;

import java.util.LinkedList;

/**
 * LinkedList的特有功能
 * @author 李闯
 *
 */
public class Demo3_LinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst("a");
		list.addFirst("b");
		list.addFirst("c");
		list.addFirst("d");
		list.addLast("e");
		 
//		System.out.println(list.getFirst());
//		System.out.println(list.getLast());
//		System.out.println(list.removeFirst());
//		System.out.println(list.removeLast());
		System.out.println(list.get(1));
		System.out.println(list);
	}
}

```
### 04. 栈和队列数据结构
    1. 栈
        1. 先进后出 
    2. 队列
        1. 先进先出

### 05. 用LinkedList模拟栈数据结构的集合并测试
    1. 案例演示
        1. 需求：请用LinkedList模拟栈数据结构的集合，并测试
        2. 创建一个类将Linked中的方法封装
    
    		public class Stack {
    			private LinkedList list = new LinkedList();		//创建LinkedList对象
    			
    			public void in(Object obj) {
    				list.addLast(obj);							//封装addLast()方法
    			}
    			
    			public Object out() {
    				return list.removeLast();					//封装removeLast()方法
    			}
    			
    			public boolean isEmpty() {
    				return list.isEmpty();						//封装isEmpty()方法
    			}
    		}
```java
package com.leeup.javase.day16.list;

import java.util.LinkedList;

/**
 * 用LinkedList模拟栈数据结构的集合并测试
 * @author 李闯
 *
 */
public class Demo4_LinkedList {

	public static void main(String[] args) {
//		demo1();
		
		Stack stack = new Stack();
		stack.in("a");			//进栈
		stack.in("b");
		stack.in("c");
		stack.in("d");
		
		while(!stack.isEmpty()) {//判断栈结构是否为空
			//不为空弹栈/出栈
			System.out.println(stack.out());
		}
		
	}

	private static void demo1() {
		LinkedList list = new LinkedList();
		
		
		//进栈
		list.addLast("a");
		list.addLast("b");
		list.addLast("c");
		list.addLast("d");
		
		//出栈
//		System.out.println(list.removeLast());
//		System.out.println(list.removeLast());
//		System.out.println(list.removeLast());
//		System.out.println(list.removeLast());
		while (!list.isEmpty()) {//不为空就弹栈
			System.out.println(list.removeLast());
		}
	}
}

```

### 06. 泛型概述和基本使用
    1. 泛型概述
    2. 泛型好处
        1. 提高安全性(将运行期的错误转换到编译期) 
        2. 省去强转的麻烦
    3. 泛型基本使用
        1. <>中放的必须是引用数据类型 
    4. 泛型使用注意事项
        1. 前后的泛型必须一致,或者后面的泛型可以省略不写(1.7的新特性菱形泛型)  
```java
package com.leeup.javase.day16.generic;

import java.util.ArrayList;
import java.util.Iterator;

import com.leeup.javase.day16.bean.Person;

/**
 * 泛型概述和基本使用
 * @author 李闯
 *
 */
@SuppressWarnings("all")
public class Demo1_Generic {

	
	public static void main(String[] args) {
//		demo1();
		//int[] arr = new byte[5]  这种是错误的
//		ArrayList<Object> list = new ArrayList<Person>();//前后泛型定义数据类型要一致，与数组定义数据类型相同
		
//		ArrayList<Object> list = new ArrayList<>();			//1.7版本的新特性，菱形泛型，即前面泛型写了，后面可以不用写，<>像一个菱形
		ArrayList<Object> list = new ArrayList<>(); 		//泛型最好不要定义成Object，没有意义，因为Object是任何类的父类，引用数据类型的父类
		list.add("aaa");
		list.add(true);
		
	}

	private static void demo1() {
		ArrayList<Person> list = new ArrayList<Person>();
//		list.add(110);
//		list.add(true);
		list.add(new Person("张三",23));
		list.add(new Person("李四",24 ));
		
		Iterator<Person> it = list.iterator();
		
		/**
		 *  java.lang.ClassCastException 类型转换异常
		 */
		while(it.hasNext()) {
//			System.out.println(it.next());
			
			
			/**
			 * it.next方法只能调用一次，如果调用多次会将指针向后移动多次
			 */
//			System.out.println(it.next().getName()+"...."+it.next().getAge());
			
			Person person = it.next();//向下转型
			System.out.println(person.getName()+"..."+person.getAge());
		}
	}
}

```

### 07. ArrayList存储字符串和自定义对象并遍历泛型版
    1. 案例演示
        1. ArrayList存储字符串并遍历泛型版
```java
package com.leeup.javase.day16.generic;

import java.util.ArrayList;
import java.util.Iterator;

import com.leeup.javase.day16.bean.Person;

/**
 * ArrayList存储字符串和自定义对象并遍历泛型版
 * @author 李闯
 *
 */
public class Demo2_Generic {

	public static void main(String[] args) {
		
//		demo1();
		
		//向集合中添加自定义对象
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("张三",23));
		list.add(new Person("李四",24));
		list.add(new Person("王五",25));
		list.add(new Person("赵六", 26));
		
		Iterator<Person> it = list.iterator();
		while (it.hasNext()) {
			Person person = it.next();
			System.out.println(person.getName()+"///"+person.getAge());
		}
	}

	private static void demo1() {
		//向集合中添加String字符串
		ArrayList<String> list = new ArrayList<>();		//创建集合对象
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
```

### 08. 泛型的由来 
    1. 案例演示
        1. 泛型的由来:通过Object转型问题引入
        2. 早期的Object类型可以接收任意的对象类型，但是在实际的使用中，会有类型转换的问题。也就存在这隐患，所以Java提供了泛型来解决这个安全问题。
```java
package com.leeup.javase.day16.generic;

import com.leeup.javase.day16.bean.Student;
import com.leeup.javase.day16.bean.Tool;
import com.leeup.javase.day16.bean.Work;

/**
 * 泛型的由来
 * @author 李闯
 *
 */
public class Demo3_Generic {

	public static void main(String[] args) {
		Tool t = new Tool();//创建工具类对象
		t.setObj(new Student("张三",23));
		
		Work work = (Work) t.getObj();	//向下转型
		
		/**
		 * 泛型没出现的时候会出现类似这种类型转换的问题，
		 * java推出泛型是用来解决安全问题的
		 */
		System.out.println(work);
	}
}
```

### 09. 泛型类的概述及使用 
    1. 泛型类概述<T>
        1. 把泛型定义在类上
    2. 定义格式
        1. public class 类名<泛型类型1,…>
    3. 注意事项	
        1. 泛型类型必须是引用类型
    4. 案例演示
        1. 泛型类的使用

### 10. 泛型方法的概述和使用 
    1. 泛型方法概述
        1. 把泛型定义在方法上
    2. 定义格式	
        1. public <泛型类型> 返回类型 方法名(泛型类型 变量名)
    3. 案例演示
        1. 泛型方法的使用
```java
package com.leeup.javase.day16.bean;


//在创建对象的时候给Q赋值，
public class Tool<Q> {

	private Q q;

	public Object getObj() {
		return q;
	}

	public void setObj(Q q) {
		this.q = q;
	}
	
	//方法的泛型最好是与类的泛型一致，如果不一致，需要在方法上声明该泛型，意思就是调用方法的时候具体指定泛型方法的类型
	public<T> void show(T t) {
		System.out.println(t);
	}
	
	//静态方法随着类的加载而加载，在加载的时候可能还没创建对象呢，那么Q就没值，
	//所以静态方法必须声明自己的泛型,同，上面Tool<Q>在创建对象的时候被赋值
	//下面的W在调用静态方法的时候被赋值， 所以W就是在方法上声明一个自己的泛型
	public static<W> void print(W w) {
		System.out.println(w);
	}

}
```

### 11. 泛型接口的概述和使用 
    1. 泛型接口概述
        1. 把泛型定义在接口上
    2. 定义格式	
        1. public interface 接口名<泛型类型>
    3. 案例演示
        1. 泛型接口的使用
```java
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
```

### 12. 泛型高级之通配符 
    1. 泛型通配符<?>
        1. 任意类型，如果没有明确，那么就是Object以及任意的Java类了
    2. ? extends E
        1. 向下限定，E及其子类
    3. ? super E
        1. 向上限定，E及其父类
```java
package com.leeup.javase.day16.generic;

import java.util.ArrayList;

import com.leeup.javase.day16.bean.Person;
import com.leeup.javase.day16.bean.Student;

/**
 * 泛型高级之通配符
 * @author 李闯
 *
 */
public class Demo5_Generic {

	public static void main(String[] args) {
		//前后反省需要一致，但是有时候在做开发的时候，后面不确定接收什么类型，可能是一个方法
		//返回的一个集合，对象，数据类型可能不确定，不确定怎么办呢？在前面加一个问号，问号代表任意类型 
//		List<?> list = new ArrayList<String>();//当右边的泛型不确定时，左边可以指定问号
		
		ArrayList<Person> list1 = new ArrayList<>();
		list1.add(new Person("张三",23));
		list1.add(new Person("李四",24));
		list1.add(new Person("王五",25));
		
		ArrayList<Student> list2 = new ArrayList<>();
		list2.add(new Student("赵六",26));
		list2.add(new Student("周七",27));
		
		
		list1.addAll(list2);//子类集合元素添加到父类元素中
		
		System.out.println(list1);
	}
}
```


### 13. 增强for的概述和使用
    1. 增强for概述
        1. 简化数组和Collection集合的遍历
    2. 格式：
    
    	for(元素数据类型 变量 : 数组或者Collection集合) {
    		使用变量即可，该变量就是元素
    	}
    3. 案例演示
        1. 数组，集合存储元素用增强for遍历
    4. 好处
        1. 简化遍历
```java
package com.leeup.javase.day16.jdk5;

import java.util.ArrayList;

/**
 * 增强for的概述和使用也就是ForEach
 * @author 李闯
 *
 */
public class Demo1_ForEach {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55};
		
		//遍历数组
		//快捷键fore
		for (int i : arr) {
			System.out.println(i);
		}
		
		//遍历集合
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
```

### 14. ArrayList存储字符串和自定义对象并遍历增强for版
    1. 案例演示
        1. ArrayList存储字符串并遍历增强for版
    
    		ArrayList<String> list = new ArrayList<>();
    		list.add("a");
    		list.add("b");
    		list.add("c");
    		list.add("d");
    		
    		for(String s : list) {
    			System.out.println(s);
    		}
```java
package com.leeup.javase.day16.jdk5;

import java.util.ArrayList;

import com.leeup.javase.day16.bean.Person;

/**
 * 增强for的概述和使用也就是ForEach
 * 底层依赖的是迭代器即，Iterator
 * @author 李闯
 *
 */
public class Demo1_ForEach {

	public static void main(String[] args) {
//		demo1();
		
		/**
		 * ArrayList存储字符串和自定义对象并遍历增强for版
		 */
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("张三",23));
		list.add(new Person("李四",24));
		list.add(new Person("王五",25));
		list.add(new Person("赵六",26));
		
		for (Person person : list) {
			System.out.println(person);
		}
	}

	private static void demo1() {
		int[] arr = {11,22,33,44,55};
		
		//遍历数组
		//快捷键fore
		for (int i : arr) {
			System.out.println(i);
		}
		
		//遍历集合
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
```
### 15. 三种迭代的能否删除
    1. 普通for循环,可以删除,但是索引要--
    2. 迭代器,可以删除,但是必须使用迭代器自身的remove方法,否则会出现并发修改异常
    3. 增强for循环不能删除
```java
package com.leeup.javase.day16.jdk5;

import java.util.ArrayList;
import java.util.Iterator;

import com.leeup.javase.day16.bean.Person;

/**
 * 增强for的概述和使用也就是ForEach
 * 底层依赖的是迭代器即，Iterator
 * @author 李闯
 *
 */
public class Demo1_ForEach {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		
		//普通for循环进行删除[注意：索引要--]
		for (int i = 0; i < list.size(); i++) {
			if ("b".equals(list.get(i))) {
				
				list.remove(i--);//通过索引删除元素,删除一次就--是因为，当删除了数组中的元素的时候，数组下面的
				//元素会顶替上面的元素上来，但是i依旧还会+1，所以就会出现漏删的情况，所以--就会让指针回去一次了
			}
		}
		System.out.println(list);
		
		//迭代器删除
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			if ("b".equals(it.next())) {
//				list.remove("b");//这样会出现并发修改异常，因为集合告诉迭代器有五个元素，然后迭代器迭代的过程中，使用了list.remove("b"); 删除了一个，现在变成了4个
								//这个时候就是迭代过程中集合进行了修改，出现了并发修改异常,所以不能用集合的删除方法,因为迭代过程中修改会出现异常
				it.remove();//使用自身的
			}
		}
		
		//迭代器的另外一种写法
		for (Iterator<String> it2 = list.iterator(); it2.hasNext();) {
			if ("b".equals(it2.next())) {//next指针自动向后,所以没有写循环后的操作表达式
				it2.remove();
			}
		}
		System.out.println(list);
		
		//增强for循环,不能删除,只能遍历,因为只能调用集合的remove方法,而调用remove方法删除,会出现并发修改异常
		for (String string : list) {
			if ("b".equals(string)) {
				list.remove("b");
			}
		}
		System.out.println(list);
	}
	
	

	private static void demo2() {
		/**
		 * ArrayList存储字符串和自定义对象并遍历增强for版
		 */
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("张三",23));
		list.add(new Person("李四",24));
		list.add(new Person("王五",25));
		list.add(new Person("赵六",26));
		
		for (Person person : list) {
			System.out.println(person);
		}
	}

	private static void demo1() {
		int[] arr = {11,22,33,44,55};
		
		//遍历数组
		//快捷键fore
		for (int i : arr) {
			System.out.println(i);
		}
		
		//遍历集合
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
```

### 16. 静态导入的概述和使用 
    1. 静态导入概述
        1. 是导入类中的静态方法
    2. 格式：
        1. import static 包名….类名.方法名;
        2. 可以直接导入到方法的级别
    3. 注意事项
        1. 方法必须是静态的,如果有多个同名的静态方法，容易不知道使用谁?
    这个时候要使用，必须加前缀。由此可见，意义不大，所以一般不用，但是要能看懂。
    开发不用，但是要能看懂
```java
package com.leeup.javase.day16.jdk5;

import static java.util.Arrays.sort;//静态导入

/**
 * 静态导入的概述和使用
 * @author 李闯
 *
 */
public class Demo2_StaticImport {

	public static void main(String[] args) {
		int[] arr ={11,22,33,44,55};
//		Arrays.sort(arr);//前缀可以省略掉,但是不推荐使用,因为容易造成跃度困难
		sort(arr);
		
	}
}
```

### 17. 可变参数的概述和使用
    1. 可变参数概述
        1. 定义方法的时候不知道该定义多少个参数
    2. 格式
        1. 修饰符 返回值类型 方法名(数据类型…  变量名){}
    3. 注意事项：
        1. 这里的变量其实是一个数组
        2. 如果一个方法有可变参数，并且有多个参数，那么，可变参数肯定是最后一个
```java
package com.leeup.javase.day16.jdk5;
/**
 * 可变参数的概述和使用
 * @author 李闯
 *
 */
public class Demo3_ChangeableArgs {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55};
//		print(arr);//把数组当作一个参数
		
		print(11,22,33,44,55);//把这些参数传递给print方法, 可变参数可以接收,其实可变参数底层做了封装,会将其封装成数组
		System.out.println("===========");
//		print();
	}
	
	
//	public static void print(int[] arr) {
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//	}
	
	public static void print(int x, int ... arr) {			//可变参数其实就是一个数组
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

```
### 18. Arrays工具类的asList()方法的使用
    1. 案例演示
        1. Arrays工具类的asList()方法的使用
        2. Collection中toArray(T[] a)泛型版的集合转数组
```java
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
```
### 19. 集合嵌套之ArrayList嵌套ArrayList
    1. 案例演示
    	1. 集合嵌套之ArrayList嵌套ArrayList
    1. 案例：
    	1. 我们学科，学科又分为若干个班级
    	2. 整个学科一个大集合
    	3. 若干个班级分为每一个小集合
```java
package com.leeup.javase.day16.list;

import java.util.ArrayList;

import com.leeup.javase.day16.bean.Person;

/**
 * 集合嵌套之ArrayList嵌套ArrayList
 * @author 李闯
 *
 */
public class Demo5_ArrayListArrayList {

	public static void main(String[] args) {
		ArrayList<ArrayList<Person>> list = new ArrayList<>();
		
		ArrayList<Person> first = new ArrayList<>();//创建第一个班级
		first.add(new Person("张三",23));
		first.add(new Person("李四",24));
		first.add(new Person("王五",25));
		
		ArrayList<Person> second = new ArrayList<>();
		second.add(new Person("赵六",26));
		second.add(new Person("周七",27));
		second.add(new Person("丘八",28));
		
		//将班级添加到学科集合中
		list.add(first);
		list.add(second);
		
		//遍历学科集合
		for (ArrayList<Person> a:list) {
			for (Person p : a) {
				System.out.println(p);
			}
		}
	}
}
```
### 20_day16总结
* 把今天的知识点总结一遍。