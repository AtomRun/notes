### 01. 对象数组的概述和使用
    1. 案例演示
        1. 需求：我有5个学生，请把这个5个学生的信息存储到数组中，并遍历数组，获取得到每一个学生信息。
        2. 
            Student[] arr = new Student[5];					//存储学生对象
            arr[0] = new Student("张三", 23);
            arr[1] = new Student("李四", 24);
            arr[2] = new Student("王五", 25);
            arr[3] = new Student("赵六", 26);
            arr[4] = new Student("马哥", 20);
            
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
		
    2. 画图演示
        1. 把学生数组的案例画图讲解
        2. 数组和集合存储引用数据类型,存的都是地址值
![数组存储引用数据类型](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%95%B0%E7%BB%84%E5%AD%98%E5%82%A8%E5%BC%95%E7%94%A8%E6%95%B0%E6%8D%AE%E7%B1%BB%E5%9E%8B.png)
### 02. 集合的由来及集合继承体系图
    1. 集合的由来
        1. 数组长度是固定,当添加的元素超过了数组的长度时需要对数组重新定义,太麻烦,java内部给我们提供了集合类,能存储任意对象,长度是可以改变的,随着元素的增加而增加,随着元素的减少而减少 
    2. 数组和集合的区别
        1. 区别1 : 
            1. 数组既可以存储基本数据类型,又可以存储引用数据类型,基本数据类型存储的是值,引用数据类型存储的是地址值
            2. 集合只能存储引用数据类型(对象)集合中也可以存储基本数据类型,但是在存储的时候会自动装箱变成对象
        2. 区别2:
            1. 数组长度是固定的,不能自动增长
            2. 集合的长度的是可变的,可以根据元素的增加而增长
    3. 数组和集合什么时候用
        1. 如果元素个数是固定的推荐用数组
        2. 如果元素个数不是固定的推荐用集合
    4. 数组的弊端：
        1. 长度固定，但是某些时候例如创建已知固定长度的数组，效率比较高
    5. 集合的弊端：
        1. 某些集合底层使用数组实现的，集合默认长度先为10，长度不够的时候，使用数组的方法扩容1.5倍，将原来的数据复制进来，原来的数组对象就变成垃圾
        2. 所以我们固定的数据用数组，变动的用集合
    6. 集合继承体系图
![集合体系图](https://github.com/AtomRun/notes/blob/master/noteimages/%E9%9B%86%E5%90%88%E4%BD%93%E7%B3%BB%E5%9B%BE.png)

### 03. Collection集合的基本功能测试
    1. 案例演示	
        1. 
            基本功能演示
            
            boolean add(E e)
            boolean remove(Object o)
            void clear()
            boolean contains(Object o)
            boolean isEmpty()
            int size()

    2. 注意:
        1. 
            collectionXxx.java使用了未经检查或不安全的操作.
            注意:要了解详细信息,请使用 -Xlint:unchecked重新编译.
            java编译器认为该程序存在安全隐患
            温馨提示:这不是编译失败,所以先不用理会,等学了泛型你就知道了
```java
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
```
### 04. 集合的遍历之集合转数组遍历
    1. 集合的遍历
        1. 其实就是依次获取集合中的每一个元素。
    2. 案例演示
        1. 把集合转成数组，可以实现集合的遍历
        toArray()
	
		
			Collection coll = new ArrayList();
			coll.add(new Student("张三",23));		//Object obj = new Student("张三",23);
			coll.add(new Student("李四",24));
			coll.add(new Student("王五",25));
			coll.add(new Student("赵六",26));
			
			Object[] arr = coll.toArray();				//将集合转换成数组
			for (int i = 0; i < arr.length; i++) {
				Student s = (Student)arr[i];			//强转成Student
				System.out.println(s.getName() + "," + s.getAge());
			}
```java
package com.leeup.javase.day15.collection;

import java.util.ArrayList;
import java.util.Collection;

import com.leeup.javase.day15.bean.Student;

/**
 * 集合的遍历之集合转数组遍历
 * @author 李闯
 *
 */
public class Demo3_Collection {

	public static void main(String[] args) {
//		demo1();
		Collection collection = new ArrayList<>();		
		collection.add(new Student("李四",24));			//Object obj = new Student("李四",24);
		collection.add(new Student("王五",25));
		collection.add(new Student("赵六",26));
		
		Object[] arr = collection.toArray();			//将集合转换为数组,此时这个数组就提升为了Object数组，多态的弊端，不能使用子类特有的属性和行为
		for (int i = 0; i < arr.length; i++) {
			Student s = (Student) arr[i];				//向下转型
			System.out.println(s.getName()+"...."+s.getAge());
		}
	}

	private static void demo1() {
		Collection collection = new ArrayList<>();
		collection.add("a");
		collection.add("b");
		collection.add("c");
		collection.add("d");
		
		//集合转成数组
		Object[] arr = collection.toArray();//返回值是对象类型的数组
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

```

### 05. Collection集合的带All功能测试
    1. 案例演示

		带All的功能演示
		
		boolean addAll(Collection c)
		boolean removeAll(Collection c)
		boolean containsAll(Collection c)
		boolean retainAll(Collection c)
```java
package com.leeup.javase.day15.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection集合的带All功能测试
 * @author 李闯
 *
 */
public class Demo4_Collection {

	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
		
		Collection c1 = new ArrayList<>();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		
		Collection c2 = new ArrayList<>();
		/**
		 * 取交集abcd,将abcd赋值给c1,c1值没有改变,即false
		 */
		c2.add("a");
		c2.add("b");
		c2.add("c");
		c2.add("d");
		c2.add("e");
		c2.add("f");
		
		/**
		 * 有交集为true,如果调用的集合改变就返回true,如果调用的集合不变就返回false
		 * 没有交集
		 */
		boolean b = c1.retainAll(c2);//取交集
		System.out.println(b);
		System.out.println(c1);
		
	}

	private static void demo3() {
		Collection c1 = new ArrayList<>();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		
		Collection c2 = new ArrayList<>();
		c2.add("a");
		c2.add("b");
		c2.add("b");
		c2.add("z");

		/**
		 * 判断调用的集合是否包含传入的集合，
		 * 有重复的没关系。但是c1中的元素在c2中也要有，有一个没有就为false
		 */
		boolean b = c1.containsAll(c2);
		System.out.println(b);
	}

	private static void demo2() {
		Collection c1 = new ArrayList<>();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		
		Collection c2 = new ArrayList<>();
		c2.add("a");
		c2.add("b");
		c2.add("z");
		
		/**
		 * 删除的是交集，即c1,c2中相同的元素，没有交集即不删，返回false
		 */
		boolean b = c1.removeAll(c2);
		System.out.println(b);
		System.out.println(c1);
	}

	private static void demo1() {
		Collection c1 = new ArrayList<>();
		Collection c2 = new ArrayList<>();
		
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		
		c2.add("a");
		c2.add("b");
		c2.add("c");
		c2.add("d");
		
//		c1.addAll(c2);//将c2每一个元素添加到c1中
		c1.add(c2);//输出结果是[a, b, c, d, [a, b, c, d]] 这样做将c2整个集合当作一个对象添加到c1中了
		System.out.println(c1);
	}
}
```

### 06. 集合的遍历之迭代器遍历
    1. 迭代器概述
        1. 集合是用来存储元素,存储的元素需要查看,那么就需要迭代(遍历) 
    2. 案例演示
	    迭代器的使用
		
			Collection c = new ArrayList();
			c.add("a");
			c.add("b");
			c.add("c");
			c.add("d");
			
			Iterator it = c.iterator();						//获取迭代器的引用
			while(it.hasNext()) {							//集合中的迭代方法(遍历)
				System.out.println(it.next());
			}
			
### 07. Collection存储自定义对象并遍历)
1. 案例演示
	* Collection存储自定义对象并用迭代器遍历
	* 
			Collection c = new ArrayList();
			
			c.add(new Student("张三",23));
			c.add(new Student("李四",24));
			c.add(new Student("王五",25));
			c.add(new Student("赵六",26));
			c.add(new Student("赵六",26));
			
			for(Iterator it = c.iterator();it.hasNext();) {
				Student s = (Student)it.next();						//向下转型
				System.out.println(s.getName() + "," + s.getAge());	//获取对象中的姓名和年龄
			}
			System.out.println("------------------------------");
			Iterator it = c.iterator();								//获取迭代器
			while(it.hasNext()) {									//判断集合中是否有元素
				//System.out.println(((Student)(it.next())).getName() + "," + ((Student)(it.next())).getAge());
				Student s = (Student)it.next();						//向下转型
				System.out.println(s.getName() + "," + s.getAge());	//获取对象中的姓名和年龄
			}
```java
package com.leeup.javase.day15.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.leeup.javase.day15.bean.Student;


/**
 * 集合的遍历之迭代器遍历
 * @author 李闯
 *
 */
public class Demo5_Iterator {

	public static void main(String[] args) {
//		demo1();
		
		/**
		 * 自定义对象迭代
		 */
		Collection c = new ArrayList();
		c.add(new Student("张三",23));		//Object obj = new Student("王五",25);
		c.add(new Student("李四", 24));
		c.add(new Student("王五",25));
		c.add(new Student("赵六",26)); 
		
		//获取迭代器
		Iterator it = c.iterator();
		while (it.hasNext()) {
//			System.out.println(it.next());//调用toString方法
			Student student = (Student) it.next();//向下转型
			System.out.println(student.getName()+"..."+student.getAge());
		}
	}

	private static void demo1() {
		Collection c = new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		
		//对集合中的元素进行迭代(遍历)
		Iterator it = c.iterator();//获取迭代器的引用,可以调用迭代器中的方法
	/*	boolean b1 = it.hasNext();//判断集合中是否有元素,有就返回true
		Object obj1 = it.next();
		System.out.println(b1);
		System.out.println(obj1);
		
		boolean b2 = it.hasNext();
		Object obj2 = it.next();//第二次调用next指针向后移一位,可以得到后面的值
		System.out.println(b1);
		System.out.println(obj2);*/
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
```	

### 08. 迭代器的原理及源码解析
    1. 迭代器原理
        1. 迭代器原理:迭代器是对集合进行遍历,而每一个集合内部的存储结构都是不同的,所以每一个集合存和取都是不一样,那么就需要在每一个类中定义hasNext()和next()方法,这样做是可以的,但是会让整个集合体系过于臃肿,迭代器是将这样的方法向上抽取出接口,然后在每个类的内部,定义自己迭代方式,这样做的好处有二,第一规定了整个集合体系的遍历方式都是hasNext()和next()方法,第二,代码有底层内部实现,使用者不用管怎么实现的,会用即可 
    2. 迭代器源码解析
        1. 在eclipse中ctrl + shift + t找到ArrayList类
        2. ctrl+o查找iterator()方法
        3. 查看返回值类型是new Itr(),说明Itr这个类实现Iterator接口
        4. 查找Itr这个内部类,发现重写了Iterator中的所有抽象方法 

### 09. List集合的特有功能概述和测试
    1. List集合的特有功能概述
        1. void add(int index,E element)
        2. E remove(int index)
        3. E get(int index)
        4. E set(int index,E element)
```java
package com.leeup.javase.day15.list;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合的特有功能概述和测试
 * @author 李闯
 *
 */
public class Demo6_List {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
//		demo4();
		List list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		list.set(1, "z");	//将指定位置的元素修改
		System.out.println(list);
	}

	private static void demo4() {
		List list = new ArrayList();
		list.add(111);
		list.add(222);
		list.add(333);
		
		Object object = list.get(1);//根据索引获取元素,我们可以使用get来遍历List集合,因为索引的值是变化的,但是只能在List中使用,Set中没有索引
		System.out.println(object);
		
		/**
		 * 通过索引遍历List集合
		 */
		for (int i = 0; i < list.size(); i++) {//size为4,索引就是3
			System.out.println(list.get(i));
		}
	}

	private static void demo3() {
		List list = new ArrayList();
		list.add(111);
		list.add(222);
		list.add(333);
//		list.remove(111);//删除的时候不会自动装箱,这里给整数都会被当成索引
	}

	private static void demo2() {
		List list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Object obj = list.remove(1);//通过索引删除元素,将被删除的元素返回
		System.out.println(obj);
		System.out.println(list);
	}

	private static void demo1() {
		//List也是一个接口
		List list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("f");		//index可以小于等于size,并且大于等于0,都不会报异常
//		list.add(1,"e");	//在指定位置添加元素
//		list.add(10,"z");	//java.lang.IndexOutOfBoundsException: 当存储时使用不存在的索引时,会出现索引越界异常
		System.out.println(list);
	}
}

```

### 10. List集合存储学生对象并遍历
    1. 案例演示
	    通过size()和get()方法结合使用遍历。

			List list = new ArrayList();
			list.add(new Student("张三", 18));
			list.add(new Student("李四", 18));
			list.add(new Student("王五", 18));
			list.add(new Student("赵六", 18));
			
			for(int i = 0; i < list.size(); i++) {
				Student s = (Student)list.get(i);
				System.out.println(s.getName() + "," + s.getAge());
			}
```java
package com.leeup.javase.day15.list;

import java.util.ArrayList;
import java.util.List;

import com.leeup.javase.day15.bean.Student;

/**
 * List集合存储学生对象并遍历
 * 自定义对象,通过getSet方式遍历集合数据
 * @author 李闯
 *
 */
public class Demo2_List {

	public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add(new Student("张三",23));		//父类引用指向子类对象,通过构造方法初始化数据
		list.add(new Student("李四",24));
		list.add(new Student("王五",25));
		list.add(new Student("赵六",26));
		
		for (int i = 0; i < list.size(); i++) {	
//			System.out.println(list.get(i));			//通过索引获取每个元素
			Student student = (Student) list.get(i);
			System.out.println(student.getName()+"....."+student.getAge());
		}
	}
}

```

### 11. 并发修改异常产生的原因及解决方案
    1. 案例演示
        需求：我有一个集合，请问，我想判断里面有没有"world"这个元素，如果有，我就添加一个"javaee"元素，请写代码实现。

			List list = new ArrayList();
			list.add("a");
			list.add("b");
			list.add("world");
			list.add("d");
			list.add("e");
			
			/*Iterator it = list.iterator();
			while(it.hasNext()) {
				String str = (String)it.next();
				if(str.equals("world")) {
					list.add("javaee");			//这里会抛出ConcurrentModificationException并发修改异常
				}
			}*/
		
			
    2. ConcurrentModificationException出现
        1. 迭代器遍历，集合修改集合
    3. 解决方案
        1. 迭代器迭代元素，迭代器修改元素(ListIterator的特有功能add)
        2. 集合遍历元素，集合修改元素

			ListIterator lit = list.listIterator();		//如果想在遍历的过程中添加元素,可以用ListIterator中的add方法
			while(lit.hasNext()) {
				String str = (String)lit.next();
				if(str.equals("world")) {
					lit.add("javaee");	
					//list.add("javaee");
				}
			}
```java
package com.leeup.javase.day15.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 并发修改异常产生的原因及解决方案
 * @author 李闯
 *
 */
public class Demo3_List {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");			//Object obj = new String("a");
		list.add("b");
		list.add("world");
		list.add("c");
		list.add("d");
		list.add("e");
		
		/**
		 * java.util.ConcurrentModificationException
		 * 解决方案使用ListIterator
		 */
		/*Iterator iterator = list.iterator();
		while (iterator.hasNext()) {		//判断集合中是否有元素
			String str = (String) iterator.next();//不能直接使用String接收,因为上面将a加入到集合中的时候,会自动类型提升为Object即向上转型
										//现在想要 直接使用String接收,需要强转,向下转型
			if ("world".equals(str)) {
				list.add("javaee");		//遍历的同时在增加元素,这个叫并发修改
			}
		}*/
		ListIterator lit = list.listIterator();//获取list特有的迭代器
		while (lit.hasNext()) {
			String str = (String) lit.next();
			if ("world".equals(str)) {
				lit.add("javaee");
			}
		}
		System.out.println(list);
	}
}
```
### 12. ListIterator
    1. boolean hasNext()是否有下一个
    2. boolean hasPrevious()是否有前一个
    3. Object next()返回下一个元素
    4. Object previous();返回上一个元素
```java
package com.leeup.javase.day15.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator
 * @author 李闯
 *
 */
public class Demo4_ListIterator {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");			
		list.add("b");
		list.add("world");
		list.add("c");
		list.add("d");
		list.add("e");
		
		ListIterator lit = list.listIterator();
		while (lit.hasNext()) {
			System.out.println(lit.next());			//获取元素并且将指针向后移动
		}
		System.out.println("=================");
		while (lit.hasPrevious()) {//指针指向0,判断0前面是否有元素,没有就直接返回false了,不注释前一个while可以遍历出结果是因为,前面的将指针指向了最后一个
			System.out.println(lit.previous());			//获取元素并且将指针向前移动
		}
	}
}
```
### 13. Vector的特有功能
    1. Vector类概述
    2. Vector类特有功能
        1. public void addElement(E obj)
        2. public E elementAt(int index)
        3. public Enumeration elements()
    3. 案例演示	
        Vector的迭代

			Vector v = new Vector();				//创建集合对象,List的子类
			v.addElement("a");
			v.addElement("b");
			v.addElement("c");
			v.addElement("d");
			
			//Vector迭代
			Enumeration en = v.elements();			//获取枚举
			while(en.hasMoreElements()) {			//判断集合中是否有元素
				System.out.println(en.nextElement());//获取集合中的元素
			}

### 14. 数据结构之数组和链表
    1. 数组
        1. 查询快修改也快
        2. 增删慢
    2. 链表
        1. 查询慢,修改也慢
        2. 增删快

### 15. List的三个子类的特点
    1. List的三个子类的特点
 
		ArrayList:
			底层数据结构是数组，查询快，增删慢。
			线程不安全，效率高。
		Vector:
			底层数据结构是数组，查询快，增删慢。
			线程安全，效率低。
		Vector相对ArrayList查询慢(线程安全的)
		Vector相对LinkedList增删慢(数组结构)
		LinkedList:
			底层数据结构是链表，查询慢，增删快。
			线程不安全，效率高。

		Vector和ArrayList的区别
			Vector是线程安全的,效率低
			ArrayList是线程不安全的,效率高
		共同点:都是数组实现的
		ArrayList和LinkedList的区别
			ArrayList底层是数组结果,查询和修改快
			LinkedList底层是链表结构的,增和删比较快,查询和修改比较慢
		共同点:都是线程不安全的
    2. List有三个儿子，我们到底使用谁呢?
		查询多用ArrayList
		增删多用LinkedList
		如果都多ArrayList
### 16. day15总结
把今天的知识点总结一遍。