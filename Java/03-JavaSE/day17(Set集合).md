## Set集合

### 1. HashSet存储字符串并遍历
    1. Set集合概述及其特点
        1. 通过API查看
    2. 案例展示
        1. HashSet存储字符串并遍历
```java
package com.leeup.javase.day17.set;

import java.util.HashSet;

/**
 * HashSet存储字符串并遍历
 * Set集合无索引，不可以存储重复，无序(存取顺序不一致，)
 * @author 李闯
 *
 */
public class Demo1_HashSet {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();	//创建hashSet对象
		boolean b1 = hs.add("a");
		boolean b2 = hs.add("a");				//当向set集合中存储重复元素的时候，返回为false
		hs.add("b");
		hs.add("c");
		hs.add("d");
		
		System.out.println(hs);					//hashSet的继承体系中有重写toString方法
		System.out.println(b1);
		System.out.println(b2);
		
		for (String string : hs) {				//只要能用迭代器迭代的就可以使用增强for循环遍历
			System.out.println(string);
		}
		
	}
}
```

### 2. HashSet存储自定义对象保障元素唯一性
    1. 案例展示
        1. 存储自定义对象，并保证元素唯一性
    2. 重写hashCode()方法和equals()方法
```java
package com.leeup.javase.day17.set;

import java.util.HashSet;

import com.leeup.javase.day17.bean.Person;

/**
 * HashSet存储字符串并遍历
 * Set集合无索引，不可以存储重复，无序(存取顺序不一致，)
 * @author 李闯
 *
 */
public class Demo1_HashSet {

	public static void main(String[] args) {
//		demo1();
		
		HashSet hs = new HashSet<>();
		hs.add(new Person("张三",23));
		hs.add(new Person("张三",23));
		hs.add(new Person("李四",24));
		hs.add(new Person("李四",24));
		hs.add(new Person("李四",24));
		hs.add(new Person("李四",24));
		
		System.out.println(hs);//结果为6，因为这里的对象每个对象都有单独的地址值，所以，都会被存进来，
									  //如果想让hashset认为同姓名同年龄是一个人需要重写equals方法
		
	}

	private static void demo1() {
		HashSet<String> hs = new HashSet<>();	//创建hashSet对象
		boolean b1 = hs.add("a");
		boolean b2 = hs.add("a");				//当向set集合中存储重复元素的时候，返回为false
		hs.add("b");
		hs.add("c");
		hs.add("d");
		
		System.out.println(hs);					//hashSet的继承体系中有重写toString方法
		System.out.println(b1);
		System.out.println(b2);
		
		for (String string : hs) {				//只要能用迭代器迭代的就可以使用增强for循环遍历
			System.out.println(string);
		}
	}
}

```
```java
package com.leeup.javase.day17.bean;

public class Person {

	private int age;
	private String name;
	public Person() {
	}
	public Person(String name,int age ) {
		this.age = age;
		this.name = name;
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
	@Override
	public boolean equals(Object obj) {
		Person person = (Person)obj;
		return this.name.equals(person.name)&&this.age == person.age;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" +  +age +"]";
	}
	
	//重写了hashCode保证了元素唯一了。 并且equals方法也跟着执行了
	@Override
	public int hashCode() {
		return 10;
	}
	
}
```

### 3. HashSet存储自定义对象保证元素唯一性图解及代码优化
    1. 画图展示
        1. 画图说明比较过程
    2. 代码优化
        1. 为了减少比较，优化hashCode()代码写法
        2. 最终版就是自动生成即可
```java
package com.leeup.javase.day17.bean;

public class Person {

	private String name;
	private int age;
	public Person() {
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		System.out.println("执行了吗");
		return "Person [name=" + name + ", age=" + age + "]";
	}
//	@Override
//	public boolean equals(Object obj) {
//		Person person = (Person)obj;
//		return this.name == person.name && this.age == person.age;
//	}
//	//重写了hashCode保证了元素唯一了。 并且equals方法也跟着执行了
//	@Override
//	public int hashCode() {
//		final int NUM = 38;
//		return name.hashCode() + age + NUM;
//	}
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
		Person other = (Person) obj;
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

### 4. HashSet如何保证元素惟一性的原理
    1. HashSet原理
        1. 我们使用Set集合都是需要去掉重复元素的，如果在存储的时候逐个equals()方法比较，效率较低，哈希算法提高了去重复的效率，降低了使用equals()方法的次数
        2. 当HashSet调用add()方法存储对象的时候，先调用对象的hashCode()方法得到一个哈希值，然后在集合中查找是否有哈希值相同的对象
            1. 如果没有哈希值相同的对象就直接存入结婚
            2. 如果有哈希值相同的对象，就和哈希值相同的对象逐个进行equals()比较，比较结果false就存入，true则不存
    2. 将自定义类的对象存入HashSet去重复
        1. 类中必须重写hashCode()和equals()方法
        2. hashCode()：属性相同的对象返回值必须相同，属性不同的返回值尽量不同(提高效率)。
        3. equals()：属性相同返回true，属性不同返回false，返回false的时候存储
```java
	/**
	 * 为什么是31呢？
	 * 1. 31是一个质数，即能被1和自己本身整除的数，这样的话它的公约数就少了，公约数少了就可以降低重复性
	 * 2. 31这个数既不大也不小 
	 * 3. 31这个数好算，2的5次方-1，2向左移动5位
	 */
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
		if (this == obj)				//this是调用对象，obj是传入对象，如果他们相等说明了两个引用指向同一个对象即自己跟自己比，
			return true;				//直接返回true即可
		if (obj == null)				//传入对象为null，,调用对象肯定不为null，因为调用对象如果为null调用equals方法就会出现空指针了。
			return false;				//直接返回false
		if (getClass() != obj.getClass())//getClass返回对应的字节码对象，比如这里this，classs即Person.class。obj.class传入对象的字节码文件
										//判断两个对象的字节码文件是否是同一个字节码，
			return false;				//如果不是同一个直接返回false
										//走到这里说明，传入的对象肯定是Person对象，肯定是有值的，并且还是同一个字节码文件
		Person other = (Person) obj;	//向下转型 
		if (age != other.age)			//调用对象的年龄不等于传入对象的年龄
			return false;				//返回false
		if (name == null) {				//调用对象的姓名为null
			if (other.name != null)		//传入对象的姓名不为null
				return false;			//返回false
		} else if (!name.equals(other.name))//调用对象姓名不等于传入对象姓名
			return false;				//返回false
		return true;					//返回true
	}
```
### 5. LinkedHashSet的概述和使用
    1. LinkedHashSet的特点
    2. 案例展示
        1. LinkedHashSet的特点
            1. 可以保证怎么存就怎么取
```java
package com.leeup.javase.day17.set;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet的概述和使用
 * @author 李闯
 * 底层是链表实现的，是Set集合中唯一一个能保证怎么存就怎么取的集合对象
 * 因为是HashSet的子类，所以也是保证元素唯一的，与HashSet的原理一样
 *
 */
public class Demo2_LinkedHashSet {

	public static void main(String[] args) {
		LinkedHashSet lhs = new LinkedHashSet<>();
		lhs.add("a");
		lhs.add("a");
		lhs.add("a");
		lhs.add("a");
		lhs.add("b");
		lhs.add("c");
		lhs.add("d");
		
		System.out.println(lhs);
	}
}
```

### 6. 产生10个1-20之间的随机数要求随机数不能重复
    1. 案例展示
        1. 需求：编写一个程序，获取10个1-20的随机数，要求随机数不能重复。并把最终的随机数输出到控制台

```java
package com.leeup.javase.day17.test;

import java.util.HashSet;
import java.util.Random;

/**
 *  产生10个1-20之间的随机数要求随机数不能重复
 * @author 李闯
 * 分析：
 * 	1. 有Random类，创建随机数对象
 *  2. 需要存储10个随机数，而且不能重复，所以我们使用HashSet集合 需要重复使用List集合，不需要重复使用Set集合
 *	3. 如果HashSet的size小于10，就可以不断的存储，如果大于等于10j就停止存储
 *  4. 通过Random中的nextInt(n)方法获取1到20之间的随机数 ，并将这些随机数存储在HashSet集合中
 *  5. 遍历HashSet
 */
public class Test1 {

	public static void main(String[] args) {
		Random random = new Random();
		HashSet<Integer> hs = new HashSet<>();
		while (hs.size()<10) {
			hs.add(random.nextInt(20)+1);//20即随即范围0-19所以我们再加一
			
		}
		//遍历HashSet
		for (Integer integer : hs) {
			System.out.println(integer);
		}
	}
}
```
### 7. 使用Scanner从键盘读取一行输入，去掉其中重复字符，打印出不同的那些字符
    1. aaaabbbcccddd

```java
package com.leeup.javase.day17.test;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 使用Scanner从键盘读取一行输入，去掉其中重复字符，打印出不同的那些字符
 * @author 李闯
 * 
 * 分析：
 * 	1. 创建Scanner对象
 *  2. 创建HashSet对象
 *	3. 将字符存储，去掉重复
 *  4. 将字符串转换为字符数组，获取每个字符存储在HashSet集合中，自动去除重复
 *  5. 遍历HashSet，打印每个字符
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一行字符串");
		
		HashSet<Character> hs = new HashSet<>();
		
		String line = scanner.nextLine();
		char[] arr = line.toCharArray();
		//将每个字符存储到HashSet集合中，遍历字符串数组
		for (char c : arr) {
			hs.add(c);
		}
		//遍历HashSet，打印每个字符
		for (Character c:hs) {
			System.out.println(c);
		}
	}
}
```

###  8. 将集合中的重复元素去掉
```java
package com.leeup.javase.day17.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 将集合中的重复元素去掉
 * @author 李闯
 *	分析：
 *	1. 创建List集合存储重复元素
 *	2. 单独定义方法去除重复，
 *  3. 打印List集合
 */
public class Test3 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		
		//定义方法去除重复
		getSingle(list); 
		
		//打印List集合
		System.out.println(list);
	}

	/**
	 * 分析：
	 * 去除List集合重复元素
	 * 	1. 创建一个LinkedHashSet
	 *  2. 将List集合中所有的元素添加到LinkedHashSet集合
	 *  3. 将List集合中的元素清除
	 *  4. 把LinkedHashSet集合中的元素添加回List集合中
	 * @param list
	 */
	public static void getSingle(List<String> list) {//改成List不仅可以接收ArrayList还可以接受LinkedList
		//1. 
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		//2.默认LinkedHashSet会对它进行去重
		lhs.addAll(list);
		//3. 
		list.clear();
		list.addAll(lhs);
	}
}
```

### 9. TreeSet存储Integer类型的元素并遍历
    1. 案例展示
        1. TreeSet存储Integer类型元素并遍历
```java
package com.leeup.javase.day17.set;

import java.util.TreeSet;

/**
 * TreeSet存储Integer类型的元素并遍历
 * 
 * TreeSet集合是用来对元素进行排序的，同样他也可以保证元素的唯一性，
 * @author 李闯
 *
 */
public class Demo3_TreeSet {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(3);
		treeSet.add(3);
		treeSet.add(3);
		treeSet.add(1);
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(2);

		
		System.out.println(treeSet);
	}
}

```
### 10. TreeSet存储自定义对象
    1. 案例展示
        1. 存储Person对象
```java
package com.leeup.javase.day17.set;

import java.util.TreeSet;

import com.leeup.javase.day16.bean.Person;

/**
 * TreeSet存储Integer类型的元素并遍历
 * 
 * TreeSet集合是用来对元素进行排序的，同样他也可以保证元素的唯一性，
 * 当compareTo方法返回0的时候，几何中只有一个元素
 * 当compareTo方法返回1的时候，集合中怎么存就怎么取
 * 当compareTo方法返回负数的时候，集合中会倒序存储
 * @author 李闯
 *
 */
public class Demo3_TreeSet {

	public static void main(String[] args) {
//		demo1();
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("张三",23));
		ts.add(new Person("李四",13));
		ts.add(new Person("王五",43));
		ts.add(new Person("赵六",33));
		System.out.println(ts); 
	}

	private static void demo1() {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(3);
		treeSet.add(3);
		treeSet.add(3);
		treeSet.add(1);
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(2);

		
		System.out.println(treeSet);
	}
}
```
### 11. TreeSet保证元素唯一和自然排序的原理和图解
    1. 画图展示
        1. TreeSet保证元素和自然排序的原理和图解
```java
	public static void main(String[] args) {
//		demo1();
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("张三",23));
		ts.add(new Person("李四",13));
		ts.add(new Person("周七",13));
		ts.add(new Person("王五",43));
		ts.add(new Person("赵六",33));
		System.out.println(ts); 
	}
```
```java
package com.leeup.javase.day16.bean;

public class Person implements Comparable<Person>{

	private int age;
	private String name;
	public Person() {
	}
	public Person(String name,int age ) {
		this.age = age;
		this.name = name;
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
	@Override
	public boolean equals(Object obj) {
		Person person = (Person)obj;
		return this.name.equals(person.name)&&this.age == person.age;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" +  +age +"]";
	}
	
	
	@Override
	public int compareTo(Person o) {
		
		int num = this.age - o.age;
		return num==0?this.name.compareTo(o.name):num;//年龄是主要条件，this.name.compareTo(o.name) 名字一样也会返回0
	}
}
```

### 12. TreeSet存储自定义对象并遍历练习1
    1. 案例展示
        1. TreeSe存储自定义对象并遍历练习(按照姓名排序)
```java
	public static void main(String[] args) {
//		demo1();
//		demo2(); 
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("张三",23));
		ts.add(new Person("李四",13));
		ts.add(new Person("王五",43));
		ts.add(new Person("赵六",33));//按照字典的排序顺序unicode码表值排序规则
		
		System.out.println(ts);
	}
```

```java
	//按照姓名排序
	@Override
	public int compareTo(Person o) {
		//将姓名作为主要条件,年龄是次要条件
		int num = this.name.compareTo(o.name);
		return num==0?this.age-o.age:num;
	}
```
### 13. TreeSet存储自定义对象并遍历练习2
    1. 案例展示
        1. TreeSe存储自定义对象并遍历练习(按照姓名长度排序)
```java
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("zhangsan",23));
		ts.add(new Person("lisi",13));
		ts.add(new Person("wangwu",33));
		ts.add(new Person("zhaoliu",43));
		ts.add(new Person("aaaa",53));
		System.out.println(ts);
```

```java
	//按照姓名长度排序
	@Override
	public int compareTo(Person o) {
		int length = this.name.length() - o.name.length();		//比较长度为主要条件
		int num = length==0?this.name.compareTo(o.name):length;//比比较内容为次要条件
		return num == 0 ? this.age-o.age:num;					//比较年龄为次要条件
	}
```
### 14. TreeSet保证元素唯一和比较排序的原理及代码实现
```java
		//需求：将字符串按照长度排序
		TreeSet<String> ts = new TreeSet<>(new CompareByLen());		
											//相当于Compartor c = new CompareByLen();
											//父类引用指向子类对象
		ts.add("aaa");
		ts.add("z");
		ts.add("wc");
		ts.add("nba");
		ts.add("cba");
		System.out.println(ts);
```
```java
class CompareByLen implements Comparator<String>{

	
	@Override
	public int compare(String s1, String s2) {//按照字符串的长度比较
		int num = s1.length() - s2.length();	//长度为 主要条件
		
		return num == 0 ?s1.compareTo(s2):num;	//内容为次要条件
	}

	
}

```

### 15. TreeSet原理
	1. 特点
		1. TreeSet是用来排序的，可以指定一个顺序，对象存入之后会按照指定的顺序排列
	2. 使用方式
		1. 自然顺序(Comparable)
			1. TreeSet类的add()方法中会把存入的对象提升为Comparable类型
			2. 调用对象的ComparableTo()方法和集合中的对象作比较
			3. 根据compareTo()方法返回的结果进行存储
		2. 比较器顺序(Comparator)
			1. 创建TreeSet的时候可以指定一个Comparator
			2. 如果传入了Comparator的子类对象，那么TreeSet就会按照比较器中的顺序排序
			3. add()方法内部会自动调用Comparator接口中的compare()方法进行排序
			4. 调用的对象是Compare方法的第一个参数，集合中的对象是Compare方法的第二个参数
		3. 两种方式的区别
			1. TreeSet构造函数什么都不传，默认按照类中Comparable的顺序(没有报错ClassCastException)
			2. TreeSet如果传入Comparator，就优先按照Comparator

### 16.练习1
	1. 在一个集合中村除了无序并且重复的字符串，定义一个方法，让其有序(字典顺序)，并且还不能去除重复
```java
package com.leeup.javase.day17.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * 在一个集合中村除了无序并且重复的字符串，定义一个方法，让其有序(字典顺序)，并且还不能去除重复
 * @author 李闯
 * 分析：
 * 	1. 定义一个List集合，并存储重复的无序的字符串
 *  2. 定义方法对其排序，保留重复
 *	3. 打印List集合
 */
public class Test4 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("aaa");
		list.add("ccc");
		list.add("ddd");
		list.add("fffffff");
		list.add("zhongguo");
		list.add("nihao");
		list.add("bbb");
		list.add("aaa");
		list.add("aaa");
		
		sort(list);
		
		System.out.println(list);
	}

	/**
	 * 创建方法，排序并保留重复
	 * 分析：
	 * 	1. 排序，创建TreeSet集合对象，因为String本身就具备比较功能，但是重复不会保留，所以我们用比较器
	 *  2. 将List集合中所有的元素添加到TreeSet集合中，对其排序，保留重复
	 *  3. 清空List集合
	 *  4. 将TreeSet集合中排好序的元素添加到List集合中
	 * @param list
	 */
	public static void sort(List<String> list) {
		//1
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String s1,String s2) {
				int num = s1.compareTo(s2);//比较内容为朱涛条件
				return num==0?1:num;//保留重复
			}
		});
		
		//2 
		ts.addAll(list);
		//3
		list.clear();
		//4
		list.addAll(ts);
	}
}
```

### 18. 练习2
	1. 从键盘接收一个字符串，程序对其中所有字符进行排序，例如键盘输入：hellozhongguo程序打印：排序后的数
```java
package com.leeup.javase.day17.test;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 从键盘接收一个字符串，程序对其中所有字符进行排序，例如键盘输入：hellozhongguo程序打印：排序后的数
 * 分析：
 * 	1. 键盘录入Scanner
 * 	2. 将字符串转换为字符数组
 * 	3. 定义TreeSet集合，传入比较器对字符排序并保留重复
 * 	4. 遍历字符数组，将每个字符数组存储在TreeSet集合中
 * 	5. 遍历TreeSet集合，打印每个字符
 * @author 李闯
 *
 */
public class Test5 {

	public static void main(String[] args) {
		//1 
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串");
		String line = sc.nextLine();
		
		//2
		char [] arr = line.toCharArray();
		
		//3 
		TreeSet<Character> ts = new TreeSet<>(new Comparator<Character>() {

			@Override
			public int compare(Character c1, Character c2) {
//				int num = c1 - c2;			//自动拆箱
				int num = c1.compareTo(c2);
				return num==0?1:num;
			} 
		});
		
		//4 
		for (char c : arr) {
			ts.add(c);		//自动装箱
		}
		
		//5 
		for (Character character : ts) {
			System.out.print(character);
		}
	}
}
```

### 19. 练习3
	1. 程序启动后，可以从键盘输入接收多个整数,直到输入quit时结束输入，把所有输入的整数倒叙排列打印

```java
package com.leeup.javase.day17.test;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 程序启动后，可以从键盘输入接收多个整数,直到输入quit时结束输入，把所有输入的整数倒叙排列打印
 * @author 李闯
 * 分析：
 * 	1. Scanner键盘录入
 *  2. 创建TreeSet集合对象，TreeSet传入比较器
 *  3. 无限循环不断地接收整数吗，遇到quit退出， 因为退出是quit，键盘录入的时候都以字符串的形式
 *  4. 判断是quit就退出，不是就将其转换为Integer并添加到集合中
 *  5. 遍历TreeSet集合并打印每个元素
 */
public class Test6 {

	public static void main(String[] args) {
		//1 
		Scanner sc = new Scanner(System.in);
		
		//2  
		TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
//				int num = i2 -i1;//自动拆箱。Integer转为 int进行计算
				int num = i2.compareTo(i1);
				return num==0?1:num;
			}
		});
		//3 
		while (true) {
			String line = sc.nextLine();
			if ("quit".equals(line)) {
				break;
			}
			Integer i = Integer.parseInt(line);
			ts.add(i);
		}
		//5 
		for (Integer integer : ts) {
			System.out.println(integer);
		}
	}
}

```

### 练习4
	1. 案例展示
		1. 需求：键盘录入5个学生信息(姓名，语文成绩，数学成绩，英语成绩)，按照总分从高到低输出到控制台
```java
package com.leeup.javase.day17.test;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

import com.leeup.javase.day17.bean.Student;

/**
 * 键盘录入5个学生信息(姓名，语文成绩，数学成绩，英语成绩)，按照总分从高到低输出到控制台
 * @author 李闯
 * 分析：
 * 	1. 定义一个学生类
 *  	成员变量：姓名，语文成绩，数学成绩，英语成绩，总成绩[算出来的]
 *  	成员方法：空参，有参构造，有参构造的参数分别是姓名，语文成绩，数学成绩，英语成绩
 *  		toString方法：在遍历集合中的Student对象打印对象引用的时候会显示属性值
 *  2. 键盘录入Scanner
 *  3. 创建TreeSet集合对象，在TreeSet的构造函数中传入比较器，按照总分比较
 *  4. 录入五个学生，所以以集合中的学生个数为判断条件，如果size是小于5的，就进行存储
 *  5. 将录入的字符串切割会返回一个字符串数组，将字符串数组中从第二个元素准换成int
 *  6. 将转换后的结果封装成Student对象，将Student添加到TreeSet集合当中
 *  7. 遍历TreeSet集合，打印每个Student对象
 */
public class Test7 {

	public static void main(String[] args) {
		//2 
		Scanner sc = new Scanner(System.in);
		System.out.println("请输学生成绩格式是：姓名，语文成绩，数学成绩，英语成绩");
		
		//3 
		TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				int num = s2.getSum() - s1.getSum();
				return num==0?1:num;
			}
		});
		//4 
		while (ts.size() < 5) {
			//5 
			String line = sc.nextLine();
			String[] arr = line.split(",");
			int chinese = Integer.parseInt(arr[1]);
			int math = Integer.parseInt(arr[2]);
			int english = Integer.parseInt(arr[3]);
			
			//6
			ts.add(new Student(arr[0], chinese, math, english));
		}
			//7 
			System.out.println("排序后的学生信息：");
			for (Student s : ts) {
				System.out.println(s);
			}
	}
}
```
```java
package com.leeup.javase.day17.bean;
/**
 * Student实体类
 * @author 李闯
 *
 */
public class Student {

	private String name;
	private int chinese;
	private int math;
	private int english;
	private int sum;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int chinese, int math, int english) {
		super();
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		this.sum = this.chinese+this.math+this.english;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getSum() {
		return sum;
	}
	@Override
	public String toString() {
		return name+","+chinese+","+math+","+english+","+sum;
	}
}

```