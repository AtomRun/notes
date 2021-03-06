## StringBuffer和数组排序

### 1. StringBuffer类的概述
    1. StringBuffer类概述
        1. 通过JDK提供的API，查看StringBuffer类的说明
        2. 线程安全的可变字符序列
            1. 线程安全较慢，就像门有锁，每次进屋要判断门锁没锁一样
            2. 线程不安全较快，无需判断门的状态
    2. StringBuffer和String的区别
        1. String是一个不可变的字符序列
        2. StringBuffer是一个可变的字符序列

### 2. StringBuffer类的构造方法
    1. StringBuffer的构造方法
        1. StringBuffer同步的，线程安全的，速度较慢
        2. StringBuilder不同步的，线程不安全的，速度较快
        3. public StringBuffer(); 无参构造方法
        4. public StringBuffer(int capacity); 指定容量的字符串缓冲区对象
        5. public StringBuffer(String str); 指定字符串内容的字符串缓冲区对象
    2. StringBuffer的方法
        1. public int capacity(); 返回当前容量。理论值，
        2. public int length(); 返回长度(字符数)。 实际值
    3. 案例展示
        1. 构造方法和长度方法的使用

```java
package com.leeup.javase.day13.stringbuffer;
/**
   1. StringBuffer的构造方法
    1. public StringBuffer(); 无参构造方法
    2. public StringBuffer(int capacity); 指定容量的字符串缓冲区对象
    3. public StringBuffer(String str); 指定字符串内容的字符串缓冲区对象
2. StringBuffer的方法
    1. public int capacity(); 返回当前容量。理论值，
    2. public int length(); 返回长度(字符数)。 实际值
 * @author 李闯
 *
 */
public class Demo1_StringBuffer {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.length());//长度为0，因为sb中没有任何元素，这个length代表的是容器中的字符个数[实际值]
		System.out.println(sb.capacity());//结果16，是StringBuffer的初始容量[理论值]，容器大小
		
		StringBuffer sb2 = new StringBuffer(10);
		System.out.println(sb2.length());
		System.out.println(sb2.capacity());//结果为10，即为我们定义的大小
		
		StringBuffer sb3 = new StringBuffer("zhongguo");
		System.out.println(sb3.length());	// 结果为8，即存入的字符串元素长度
		System.out.println(sb3.capacity());	//结果为24，其实是字符串的length加上初始容量的大小
		//即不占用初始容量的大小，还对初始容量进行扩充
	}
}
```
### 3. StringBuffer的添加功能
    1. StringBuffer的添加功能
        1. public StringBuffer append(String str);
            1. 可以任意类型数组添加到字符串缓冲区中，并返回字符串缓冲区本身
        2. public StringBuffer insert(int offset,String str);
            1. 在指定位置把任意类型的数据插入到字符串缓冲区中，并返回字符串缓冲区本身
```java
package com.leeup.javase.day13.stringbuffer;/**
 * StringBuffer的添加功能
 * @author 李闯
 * StringBuffer是字符串缓冲区，当new的时候是在对内存创建了一个对象，底层是一个长度为16的
 * 字符数组，当调用添加的方法时，不会再重新创建对象，再不断的向原缓冲区，添加字符，
 *
 */
public class Demo2_StringBuffer {

	public static void main(String[] args) {
		
		//demo1();
		
		StringBuffer sb = new StringBuffer("woai");
		sb.insert(3, "zhongguo");
		System.out.println(sb);
		/**
		 * 指定位置添加，比如上述在索引3处添加，即从二个元素往后分割，从a开始添加insert的内容
		 * 如果没有指定位置的索引，即insert得索引在sb中不存在，就会报索引越界异常
		 */
	}

	private static void demo1() {
		StringBuffer sb = new StringBuffer();
		 StringBuffer sb2 = sb.append(true);
		 StringBuffer sb3 = sb.append("zhongguo");
		 StringBuffer sb4 = sb.append(100);
		 
		 /**
		  * 创建完之后再打印的结果
		  */
		 System.out.println(sb);//直接打印sb，其实就是sb.toString，打印结果为空，	表明StringBuffer重写了toString方法，
		 System.out.println(sb2);
		 System.out.println(sb3);
		 System.out.println(sb4);
		 /**
		  *  三个结果相同，这说明了四个引用指向的是同一个对象， 除了第一次new的时候创建了在堆中的对象
		  *  其他的引用都是指向同一个对象，对同一个对象进行操作。这就为什么说StringBuffer是可变的字符序列
		  *  因为我们操作的是同一个字符序列，而字符串是不变的字符序列，字符串只要赋值后，再次赋值之前的
		  *  就变成了垃圾，但StringBuffer不会变成垃圾，因为StringBuffer是如上例，四个引用指向
		  *  同一个对象 
		  */
	}
}
```
### 4. StringBuffer的删除功能
    1. StringBuffer的删除功能
        1. public StringBuffer deleteCharAt(int index);
            1. 删除指定位置的字符，并返回本身
        2. public StringBuffer delete(int start,int end);
            1. 删除从指定位置开始指定位置结束的内容，并返回本身
```java
package com.leeup.javase.day13.stringbuffer;
/**
 * StringBuffer的删除功能
 * @author 李闯
 *
 */
public class Demo3_StringBuffer {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
//		sb.deleteCharAt(5);//如果指定的索引在缓冲区中不存在，也会报字符串。索引越界异常，
		sb.append("zhongguo");
		
//		sb.deleteCharAt(5);//根据索引删除索引位置上对应的字符
//		sb.delete(0,2);		//删除的时候包含头，不包含尾
//		System.out.println(sb);
		
		sb.delete(0, sb.length());//清空缓冲区
		
		System.out.println(sb);
		
		sb = new StringBuffer();	//不要使用这种方式清空缓冲区，原来的会变成垃圾
		
	}
}
```

### 5. StringBuffer的替换和翻转功能
    1. StringBuffer的替换功能
        1. public StringBuffer replace(int start,int end,String str);
            1. 从start开始到end用str替换
    2. StringBuffer的翻转功能
        1. public StringBuffer reverse();
            1. 字符串反转
```java
package com.leeup.javase.day13.stringbuffer;
/**
 * StringBuffer的替换反转功能
 * @author 李闯
 *
 */
public class Demo4_StringBuffer {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("zhongguo");
		
		sb.replace(0, 3, "lii");		//替换
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);			//字符串被反转了
		
	}
}
```
### 6. StringBuffer的截取功能
    1. StringBuffer的截取功能
        1. public String subString(int start);
            1. 从指定位置截取到末尾
        2. public String subString(int start,int end);
    2. 注意事项
        1. 注意：返回值类型不再是StringBuffer本身
```java
package com.leeup.javase.day13.stringbuffer;
/**
 * StringBuffer的截取功能
 * @author 李闯
 *
 */
public class Demo5_StringMethod {

	public static void main(String[] args) {
		StringBuffer  sb = new StringBuffer("woaizhongguo");
		String str = sb.substring(4);	//默认从索引到元素的末尾
		System.out.println(str);
		/**
		 * 截取完之后产生了 新的字符串记录，原sb并没有改变
		 */
		System.out.println(sb);
		
		String str2 = sb.substring(4, 7);
		System.out.println(str2);
		
	}
}
```

### 7. StringBuffer和String的相互转换
    1. String->StringBuffer
        1. 通过构造方法
        2. 通过append方法
    2. StringBuffer->String
        1. 通过构造方法
        2. 通过toString方法
        3. 通过subString(0,length);

```java
package com.leeup.javase.day13.stringbuffer;
/**
 * StringBuffer和String的相互转换
 * @author 李闯
 *
 */
public class Demo6_StringBuffer {

	public static void main(String[] args) {
//		demo1();
		
		StringBuffer sb = new StringBuffer("zhonguo");
		
		//通过构造将StringBudffer转为String
		String s1 = new String(sb);
		System.out.println(s1);
		
		//通过toString方法将StringBuffer转换为String
		System.out.println(sb.toString());
		
		//通过截取字符串将StringBuffer转换为String字符串
		String s3 = s1.substring(0, s1.length());
		System.out.println(s3);
		
	}

	private static void demo1() {
		StringBuffer sb1 = new StringBuffer("zhongguo");	//通过构造方法将字符串转换为StringBuffer对象
		System.out.println(sb1);
		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("zhongguo");
		System.out.println(sb2);		//通过append方法将字符串转换为StringBuffer对象
	}
}
```

## 8. 把数组转成字符串
    1. 需求：把数组中的数据按照指定格式拼接成一个字符串
        1. 举例：
            int [] arr = {1,2,3};
        2. 输出结果
            "[1,2,3]"
        3. 使用StringBuffer的功能实现
```java
package com.leeup.javase.day13.test;


/**
 * 将数组中的数据按照指定格式拼接成一个字符串
 * @author 李闯
 *
 *相较于使用String做这道题，就是，使用String会产生垃圾，
 *因为例如String s = "xxx";
 *每次对s进行赋值，之前的s就会变成垃圾而使用StringBuffer只创建一个对象，对一个对象进行操作
 */
public class Test1 {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
		System.out.println(arrayToString(arr));
		
	}
	
	/**
	 * 将数组转换为字符串
	 * 1. 返回值类型 Stringg
	 * 2.参数列表int[] 
	 * 
	 * arrayToString 将数组转换为字符串
	 * array2String 2与to发音yi'yang就用2替换了to,后来就变成了一种书写习惯
	 * 
	 */
	public static String arrayToString(int[] arr) {
		
		//1. 创建StringBuffer缓冲区
		StringBuffer sb = new StringBuffer();	
		sb.append("[");//先将左[添加到缓冲区
		
		//遍历数组
		for (int i = 0; i < arr.length; i++) {
//			sb.append(arr[i]+",");//这样做没有右中括号，采用if判断方式改进
			if (i==arr.length -1) {
				sb.append(arr[i]).append("]");
			}else {
				sb.append(arr[i]).append(",");
			}
		}
		
		return sb.toString();
	}
}
```

### 9. 字符串反转
    1. 案例展示
        1. 需求：把字符串反转
            1. 举例：键盘录入： "abc"
            2. 输出结果："cba"
            3. 使用StringBuffer的功能实现
```java
package com.leeup.javase.day13.test;

import java.util.Scanner;


/**
 * 使用StringBuffer字符串反转
 * @author 李闯
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
//		//将获取到的字符串转换成StringBuffer对象
//		StringBuffer sb = new StringBuffer(line);
//		sb.reverse();
//		System.out.println(sb);
		
		//使用方法形式
		
		System.out.println(revese(line));
	}
	
	/**
	 * 抽取成方法
	 */
	public static String revese(String line) {
		StringBuffer sb = new StringBuffer(line);
		sb.reverse();
		return sb.toString();
	}
}
```

### 10. StringBuffer和StringBuilder的区别
    1. StringBuilder的概述
        1. 通过查看API了解一下StringBuilder类
    2. 面试题
        1. String,StringBuilder,StringBuffer的区别
        2. StringBuffer和StringBuilder的区别
            1. StringBuffer是jdk1.0版本的，是线程安全的，效率比较低
            2. StringBuilder是jdk1.5版本的，是线程不安全全的，效率比较高
    
        3. String和StringBuffer,StringBuilder的区别
            1. String是一个不可变的字符序列
            2. StringBuffer和StringBuilder是可变的字符序列

### 11. String和StringBuffer分别作为参数传递
    1. 形式参数的问题
        1. String作为参数传递
    2.  案例展示
        1.  String和StringBuffer分别作为参数传递问题
```java
package com.leeup.javase.day13.stringbuffer;
/**
 * String和StringBuffer分别作为参数传递
 * @author 李闯
 * 基本数据类型的值传递：不改变其值
 * 引用数组类型的值传递：改变其值
 */
public class Demo7_StringBuffer {

	public static void main(String[] args) {
		String s = "zhongguo";
		System.out.println(s);
		
		change(s);
		System.out.println(s);//输出结果还是zhongguo
		/**
		 * String类虽然算引用数据类型，但是他当作参数传递时，和基本数据类型时一样的
		 * 因为String这个类一旦被赋值初始化就不能被改变
		 */
		System.out.println("分隔符");
		StringBuffer sb = new StringBuffer();
		sb.append("zhongguo");
		System.out.println(sb);
		change(sb);
		System.out.println(sb);
		/**
		 * String和StringBuffer做值传递时是有去别的
		 * String当作参数传递时，和基本数据类型一样，方法弹栈改变的值消失
		 * 
		 * StringBuffer不会，因为StringBuffer是可变的字符序列
		 */
	}

	public static void change(StringBuffer sb) {
		sb.append("woai");
	}

	public static void change(String s) {
		s += "woai";
		//方法一旦弹栈s就消失了
	} 
}
```

### 12. 数组高级冒泡排序原理图解
    1. 画图展示
        1.  需求：
            1.  数组元素：{24,69,80,57,13}
            2.  请对数组元素进行排序
            3. 冒泡排序
                1. 相邻元素两两比较，大的往后放，第一次完毕，最大值出现在了最大索引处
![数组高级冒泡排序原理图解](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E6%95%B0%E7%BB%84%E9%AB%98%E7%BA%A7%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%E5%8E%9F%E7%90%86%E5%9B%BE%E8%A7%A3.png)
### 13. 数组高级冒泡排序以及代码实现
    1. 案例展示
        1. 数组高级冒泡排序代码
```java
package com.leeup.javase.day13.array;
/**
 * 数组高级冒泡排序
 * @author 李闯
 *
 */
public class Demo1_Array {

	public static void main(String[] args) {
		int[] arr = {24,69,20,57,13};
		bubbleSort(arr);
		print(arr);
	}
	
	/**
	 * 冒泡排序
	 * 1.返回值类型：void
	 * 2.参数列表：int[] arr
	 * 
	 * 第一次：arr[0]与arr[1],arr[1]与arr[2],arr[2]与arr[3],arr[3]与arr[4]比较4次
	 * 第二次：arr[0]与arr[1],arr[1]与arr[2],arr[2]与arr[3],比较3次
	 * 第三次：arr[0]与arr[1],arr[1]与arr[2],比较2次
	 * 第四次：arr[0]与arr[1],比较1次
	 * 
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length -1; i++) {	//外循环只需要比较arr.length-1次即可
			for (int j = 0; j < arr.length-1 - i; j++) {//-1为了防止数组越界 -i是为了比较次数正确，提高效率
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	/**
	 * 打印数组
	 * 1.  返回值类型:void
	 * 2. 参数列表int[] arr
	 */
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}
```
### 14. 数组高级选择排序原理图解
    1. 画图演示
        1. 需求：
            1. 数组元素：{24,69,20,57,13}
            2. 请对数组元素进行排序
            3. 选择排序
                1. 从0索引开始，依次和后面元素比较，小的往前放，第一次完毕，最小值出现在了最小索引处
![数组高级选择排序原理图解](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E6%95%B0%E7%BB%84%E9%AB%98%E7%BA%A7%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F%E5%8E%9F%E7%90%86%E5%9B%BE%E8%A7%A3.png)
### 15. 数组高级选择排序代码实现
    1. 案例展示
        1. 数组高级选择排序代码
```java
package com.leeup.javase.day13.array;
/**
 * 数组高级选择排序原理图解
 * @author 李闯
 *
 */
public class Demo2_Array {

	public static void main(String[] args) {
		int[] arr = {24,69,20,57,13};
		selectSort(arr);
		print(arr);
	}
	
	/**
	 * 选择排序
	 * 1. 返回值类型void
	 * 2. 参数列表int[] arr
	 * 
	 * 第一次：arr[0]分别与arr[1-4]比较，比较4次
	 * 第二次：arr[1]分别与arr[1-3]比较，比较3次
	 * 第三次：arr[2]分别与arr[1-2]比较，比较2次
	 * 第四次：arr[3]分别与arr[4]比较，比较1次
	 */
	
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {	//五个数比较4次，即length-1
			for (int j = i+1; j < arr.length; j++) {	//j=i+1
				if (arr[i]>arr[j]) {
//					int temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
					
					//将重复代码抽取出来成为方法
					swap(arr, i, j);
				}
			}
		}
	}
	
	/**
	 * 打印数组
	 * 1.  返回值类型:void
	 * 2. 参数列表int[] arr
	 */
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	/**
	 * 换位操作
	 * 1. 返回值类型，void
	 * 2. 参数列表int[] arr,int i,int j
	 * 
	 * 如果某个方法，只对本类使用，不想让其他类使用，就可以定义成私有的
	 */
	private static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
```
### 16. 数组高级二分查找原理图解
    1. 画图展示
        1. 二分查找
        2. 前提：数组元素有序
![数组高级二分查找原理图解](https://github.com/AtomRun/notes/blob/master/00-noteimages/%E6%95%B0%E7%BB%84%E9%AB%98%E7%BA%A7%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E5%8E%9F%E7%90%86%E5%9B%BE%E8%A7%A3.png)

### 17. 数组高级二分查找代码实现及注意事项
    1. 案例展示
        1. 数组高级二分查找代码
    2. 注意事项
        1. 如果数组无序，就不能使用二分查找
            1. 因为如果你排序了，但是你排序的时候已经改变了最原始的索引。
```java
package com.leeup.javase.day13.array;
/**
 * 数组高级二分查找原理图解
 * @author 李闯
 *
 */
public class Demo3_Array {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55,66,77};
		System.out.println(getIndex(arr, 22));
		System.out.println(getIndex(arr, 66));
		System.out.println(getIndex(arr, 88));
	}
	
	/**
	 * 二分查找的方法
	 * 1. 返回值类型，int
	 * 2. 参数列表，int[] arr,int value
	 */
	
	public static int getIndex(int[] arr,int value) {
		int min = 0;
		int max = arr.length-1;//数组长度-1是数组的索引最大值
		int mid = (min+max)/2;//数组中间的位置

		while (arr[mid] !=value) {		//拿到的数不等于中间数再进行循环查找，否则直接返回
			if (arr[mid]<value) {		//当中间值小于要找的值
				min = mid + 1;			//最小的索引改变
			}else if (arr[mid]>value) { //当中间值大雨了要找的值
				max = mid-1;			//最大的索引改变
			}
			mid = (max+min)/2;			//无论最大还是最小改变，中间索引都会随之改变
			if (min>max) {				//如果最小索引大于最大索引，就没有查找的可能性了返回-1
				return -1;
			}
		}
		
		return mid;
	}
}

```

### 18. Arrays类的概述和方法使用
    1. Arrays类概述
        1. 针对数组进行操作的工具类。
        2. 提供了排序，查找等功能
    2. 成员方法
        1. public static String toString(int[] a)
        2. public static void sort(int[] a)
        3. public static int binarySearch(int[] a,int key)
```java
package com.leeup.javase.day13.array;

import java.util.Arrays;

/**
	public static String toString(int[] a)
	public static void sort(int[] a)
	public static int binarySearch(int[] a,int key)
 * @author 李闯
 *
 */
public class Demo4_Arrays {

	public static void main(String[] args) {
		int[] arr = {33,22,11,44,66,55};
		
		//转换成字符串
		System.out.println(Arrays.toString(arr));
		
		//数组排序
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		//二分查找
		int[] arr2 = {11,22,33,44,55,66};
		System.out.println(Arrays.binarySearch(arr2, 22));
		System.out.println(Arrays.binarySearch(arr2, 66));
		System.out.println(Arrays.binarySearch(arr2, 88));//负的插入点-1，为什么是负的插入点呢？因为如果第一位0，则无法判断
		
		/**
		 * Arrays的
		 * toString源码
		 * 
		public static String toString(long[] a) {
        if (a == null)								//如果传入的数组为null
            return "null";							//就返回null
        int iMax = a.length - 1;					//iMax最大索引
        if (iMax == -1)								//如果iMax==-1即length=0,即数组中没有元素
            return "[]";							//返回[]

        StringBuilder b = new StringBuilder();		//StringBuilder线程不安全的，效率高，目前我们都是单线程的
        b.append('[');								//将[添加到字符串缓冲区
        for (int i = 0; ; i++) {					//遍历数组，没有写循环判断语句默认就是true
            b.append(a[i]);							//把第一个元素添加进字符串缓冲区
            if (i == iMax)							//如果i等于最大索引值，即到了 最后一个元素了
                return b.append(']').toString();	//直接返回return方法弹栈结束，，添加]符号添加到字符串缓冲区并且toString转换为字符串
            b.append(", ");							//如果不等于最大索引就将 , 添加到缓冲区
        }
    }
		 */
		
	/**
	 * 
	 * Arrays的
	 * binarySearch0源码
	 * 
	 * private static int binarySearch0(long[] a, int fromIndex, int toIndex,
                                     long key) {
        int low = fromIndex;				//最小索引0
        int high = toIndex - 1;				//最大索引，数组长度-1

        while (low <= high) {				//如果最小索引<= 最大索引，就可以开始循环判断了
            int mid = (low + high) >>> 1;	//求处中间索引值，(最小+最大)/2,向右移动一位就是除以2的1次幂
            long midVal = a[mid];			//通过中间索引获取中间值

            if (midVal < key)				//中间索引对应的值小于查找的值
                low = mid + 1;				//最小索引变化
            else if (midVal > key)			//中间索引对应的值大于查找的值
                high = mid - 1;				//最大索引变化
            else							//即不大也不小
                return mid; // key found	//找到了
        }
        return -(low + 1);  // key not found.//负的插入点减一
    }
	 */
	}
}
```
### 19. 基本类型包装类的概述
    1. 为什么会有基本类型包装类
        1. 将基本数据类型封装成对象的好处在于可以在对象中定义更多的功能方法操作该数据
    2. 常用操作
        1. 常用的操作之一：用于基本数据类型与字符串之间的转换
    3. 基本类型和包装类的对应
        1. byte    Byte
        2. short   Short
        3. int     Integer
        4. long    Long
        5. float   Float
        6. double  Double
        7. char    Character
        8. boolean Boolean

### 20. Integer类的概述和构造方法
    1. Integer类的概述
        1. 通过JDK提供的API，查看Integer类的说明
        2. Integer类在对象中包装了一个基本类型int的值
        3. 该类还提供了多个方法，能在int类型和String类型之间相互转换，
        4. 还提供了处理int类型时非常有用的一些常量和方法
    2. 构造方法
        1. public Integer(int value)
        2. public Integer(String s)
    3. 案例展示
        1. 使用构造方法创建对象
```java
package com.leeup.javase.day13.wrapclass;

public class Demo2_Integer {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);//int最大值
		System.out.println(Integer.MIN_VALUE);//int最小值
		
		Integer i1 = new Integer(100);
		System.out.println(i1);

		Integer i2 = new Integer("100");
		System.out.println(i2);
		
		Integer i3 = new Integer("abc");//出错，数字格式异常，abc	不是数字字符串，转换会报错
	}
}

```
### 21. String和int类型的相互转换
    1. int -> String
        1. 和""进行进阶
        2. public static String valueOf(int i)
        3. int -> Integer -> String(Integer类的toString方法())
        4. public static String toString(int i )(Integer类的静态方法)
    2. String -> int
        1. String -> Integer -> int
            1. public static int paraseInt(String s) 
```java
package com.leeup.javase.day13.wrapclass;
/**
 * String和int类型的相互转换
 * @author 李闯
 *
 */
public class Demo3_Integer {

	public static void main(String[] args) {
		
		demo1();
		/**
		 * 基本数据类型包装类有八种，其中其中都是parseXxx方法，可以将这七种字符串表现形式转换成基本数据类型 
		 */
		String s1 = "true";
		boolean b = Boolean.parseBoolean(s1);
		System.out.println(b);
		
		String s2 = "abc";
//		char c = Character.pa					//char包装类中没有parseXxx方法，因为假设s2是个字符串，转换为字符，c中只能存一个，就装不下了，
												//而且字符串转换为字符不需要这个方法。我们可以通过toCharArray()就可以吧字符串转换为字符数组
	}

	private static void demo1() {
		//int转String
		int i = 100;
		String s1 = i+ "";					//推荐使用
		System.out.println(s1);				//推荐使用
		
		String s2 = String.valueOf(i);
		System.out.println(s2);
		
		Integer i2 = new Integer(i);
		System.out.println(i2.toString());//返回一个表示Integer值的String对象
		
		String s3 = Integer.toString(i);
		System.out.println(s3);
		
		//String转int
		String s = "200";
		Integer i3 = new Integer(s);
		int i4 = i3.intValue();			//将Integer转换成了int数
		
		int i5 = Integer.parseInt(s);
		System.out.println(i5);			//将String转换为int数，推荐使用
	}
}
```

### 22. JDK5新特性
    1. JDK5的新特性
        1. 自动装箱：把基本类型转换为包装类型
        2. 自动拆箱：把包装类型转换为基本类型
    2. 案例展示
        1. JDK5的新特性自动装箱和拆箱
        2. Integer i1 = 100;
        3. i1 += 200;
    3. 注意事项
        1. 在使用前，Integer x = null;代码就会出现NullPointerException
        2. 建议先判断是否为null，然后再使用
```java
package com.leeup.javase.day13.wrapclass;

/**
 自动装箱：把基本类型转换为包装类型
 自动拆箱：把包装类型转换为基本类型
 * @author 李闯
 *
 */
public class Demo4_JDK5 {

	public static void main(String[] args) {
		
		//将基本数据类型包装成对象，即装箱
		int x = 100;
		Integer i = new Integer(x);
		
		//将对象转换为基本数据类型，即拆箱
		int y = i.intValue();
		
		//JDK1.5 之后这个事情就变得特别简单了
		Integer i2 = 100;			//自动装箱，把基本数据类型转换为对象
		int z = i2 + 200;			//i2本身是个引用数据类型，i2中里面记录的应该是地址值，但是i2
									//和200能相加，结果为300，说明它变成了基本数据类型的100
									//这个过程就叫自动拆箱，把对象转换为基本数据类型，变成了
									//100与200相加，其实底层用的也是intValue把i2转换成对应的int值
		System.out.println(z);
		
		Integer i3 = null;
		int a = 3 + 100;			//这样就会出现空指针异常，因为当i3记录null的时候，即没有
									//记录任何一个对象的地址值，这个时候使用i3调用intValue
									//就是使用null调用方法，就会出现空指针异常
	}
}
```

### 23. Integer的面试题

```java
package com.leeup.javase.day13.wrapclass;

public class Demo5_Integer {

	public static void main(String[] args) {
		Integer i1 = new Integer(97);
		Integer i2 = new Integer(97);
		System.out.println(i1 == i2);		//false
		System.out.println(i1.equals(i2));	//true
		System.out.println("==========");
		
		/**
		 * Integer重写的euqals方法
		 * 包含相同int值的对象即true
		 * 
	public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return value == ((Integer)obj).intValue();
        }
        return false;
    }
		 */
		Integer i3 = new Integer(197);
		Integer i4 = new Integer(197);
		System.out.println(i3==i4);			//false
		System.out.println(i3.equals(i4));	//true
		System.out.println("==========");
		
		
		Integer i5 = 97;	
		Integer i6 = 97;
		System.out.println(i5==i6);			
		System.out.println(i5.equals(i6));	//true
		System.out.println("==========");
		
		Integer i7 = 197;
		Integer i8 = 197;
		System.out.println(i7==i8);
		System.out.println(i7.equals(i8));	//true
		
		/**
		 * -128-127是byte的取值范围，如果在这个取值范围内，自动装箱就不会新创建
		 * 对象，而是从常量池内获取，如果超过了byte取值范围就会新创建对象
		 * 
		 * 经查看下面部分的Integer源码在JDK1.8中并没有
		   asset IntegerCache.high >= 127; 这段代码
		   
		   public static Integer valueOf(int i){
		   		asset IntegerCache.high >= 127;
			   		if(i>=IntegerCache.low && i<=IntegerCache.high){	//i>=-128 && i<=127
			   			return IntegerCache.cache[i+IntegerCache.low];	//
			   		return new Integer(i);
		   		}
		   }
		 */
	}
}
```