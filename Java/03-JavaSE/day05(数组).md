## 数组

### 1. 数组概述和定义格式说明
    1. 为什么要有数组？
        1. 为了存储同种数据类型的多个值
    2. 数组概念
        1. 数组是存储同一种数据类型多个元素的集合。也可以看成是一个容器
        2. 数组既可以存储基本数据类型，也可以存储引用数据类型
    3. 数组定义格式
        数据类型[] 数组名 = new 数据类型[数组的长度]

### 2. 数组的初始化动态初始化
    1. 什么是数组的初始化
    2. 如何对象数组进行初始化
        1. 动态初始化 只指定长度，由系统给出初始值
            1. int arr = new int [5];
        2. 静态初始化 给出初始值，由系统决定长度
    3. 动态初始化的格式：
        1. 数据类型[] 数组名 = new 数据类型[数组的长度];
    4. 案例展示
        1. 对数组的解释
        2. 输出数组名称和数组元素
```java
package com.leeup.javase.day05.数组;
/**
 * 数组的初始化
 * @author 李闯
 *
 * 整数类型：byte short int long 默认初始化值都是0 
 * 浮点类型：float double 默认初始化值都是0.0
 * 布尔类型：boolean 默认初始化值flase
 * 字符类型：char 默认初始化值是'\u0000' 
 * 类型char在内存中占两个字节，是16个二进制位，\u0000 每个0其实代表的是16进制的0，4个0就是代表16个二进制位
 */
public class Demo2_Array {

	public static void main(String[] args) {
		int[] arr = new int[5];	//数组的动态初始化，相当于在内存中开辟连续的5块空间，用来存储int类型的5个值
		System.out.println(arr[0]);//输出结果是0，这个值是系统给出默认初始化值，整数类型的都是0
		
		arr[0] = 10;
		System.out.println(arr[0]); 
		
		System.out.println(arr);	//[I@15db9742  [半个中括号代表一维数组，几个就代表几维,I代表int类型的，@是分隔符，固定的，后面的是地址符，hashCode的地址，是16进制表现形式 。 
		                                //所以这里打印的是数组的地址值，它创建了数组对象后就把地址值告诉了arr，arr就可以去访问里面的0，1，2索引
	}
}
```

### 3. java中的内存分配以及堆和栈的区别
    1. 栈
        1. 存储局部变量
            1. 局部变量：定义在方法声明上和方法中的变量
    2. 堆
        1. 存储new出来的数组或者对象[new对象也称实例化对象]
    3. 方法区
        1. 面向对象部分讲解
    4. 本地方法区
        1. 和系统相关
    5. 寄存器
        1. 给CPU使用

### 4. 数组的内存图解1  int[] arr2 = new int[5] 
    1. 每次程序编译运行时，main方法会以栈帧的形式被压进栈底，主方法压进栈后，方法中声明了一个 int[] arr2的引用，同时在堆内存中创建了五个连续的内存空间索引为0，1，2，3，4。int数组会赋予其默认初始化值为0,且赋予一个地址。若使用了静态初始化方式创建数组就显式初始化默认值将默认值0改变为静态初始化数组时定义的元素的值。然后再进行赋值将数组在堆中的地址赋值给arr2，当通过arr2[0]找数组中的元素时，arr2会通过堆赋值给它的地址再通过索引拿到值。

### 5. 数组的内存图解2

### 6. 数组的内存图解3

### 7. 数组中的"三个引用，两个数组"
```java
package com.leeup.javase.day05.数组;
/**
 * 三个引用，两个数组
 * @author 李闯
 *
 */
public class Demo5_Array {

	public static void main(String[] args) {
		int[] arr1 = new int[3];
		int[] arr2 = new int[5];
		int[] arr3 = arr2;
		
		System.out.println(arr1);
		System.out.println(arr2);
		System.out.println(arr3);
		
		arr1[0] = 10;
		arr1[1] = 20;
		
		arr2[1] = 30;
		
		arr3[1] = 40;
		arr3[2] = 50;
		
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		System.out.println("===============");
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
		System.out.println(arr2[3]);
		System.out.println(arr2[4]);
		System.out.println("===============");
		System.out.println(arr3[0]);
		System.out.println(arr3[1]);
		System.out.println(arr3[2]);
		System.out.println(arr3[3]);
		System.out.println(arr3[4]);
		
	}
}
```

### 8. 数组的静态初始化
    1. 静态初始化的格式：
        1. 格式：数据类型 [ ] 数组名 = new 数据类型[]{元素1,元素2,...};
    2. 简化格式：
        1. 数据类型[ ] 数据名 = new {元素1，元素2,...};
    3. 案例展示
        1. 对数组的解释
        2. 输出数组名称和数组元素
    4. 画图展示
        1. 一个数组 
```java
package com.leeup.javase.day05.数组;
/**
 * 静态初始化的格式：
 * 	格式：数据类型 [ ] 数组名 = new 数据类型[]{元素1,元素2,...};
 * 	简化格式：
 * 		数据类型[ ] 数据名 = new {元素1，元素2,...};
 * 	案例展示
 * 		对数组的解释
 * 		输出数组名称和数组元素
 * 	画图展示
 * 		一个数组  
 * 
 * 动态初始化：int [] arr = new int[5];
 * 
 * 静态初始化：int [] arr1 = new int[] {12,35,24,53,4};//一次性定义完整个数组引用+实体[静态初始化的方式]
 * 或者：int [] arr1;//单独定义数组引用
 * arr1 = new int {123,234,245,3};//单独定义数组实体
 * 或者静态初始化简化方式：arr2 = new int[] {123,35,234,65};
 * 
 * @author 李闯
 *
 */
public class Demo6_Array {
	public static void main(String[] args) {
		//数据类型 [ ] 数组名 = new 数据类型[]{元素1,元素2,...};
		int [] arr = new int[] {11,22,33,44,55};//1. 数组长度取决于元素的个数
		int [] arr2 = {11,22,33,44,55};//2. 静态初始化简写方式
		
		/**
		 * 两者的区别：如下例子
		 * 1.可以先声明后赋值
		 * 2.必须写在一行
		 */
		
		int [] arr3;		//声明数组引用
		arr3 = new int[] {11,22,33,44,55} ; //声明数组实体
		
		/**
		 * 创建数组时不能动态初始化，静态初始化相结合
		 */
	}
}
```

### 9. 数组操作的两个常见问题越界和空指针
    1. 案例展示
        1. ArrayIndexOutOfBoundsException:数组索引越界异常
            1. 原因：你访问了不存在的索引 
        2. NullPointerException:空指针异常
            1. 原因：数组已经不存在指向堆内存了，而你还用数组名去访问
            int[] arr = {1,2,3};
            arr = null;
            System.out.println(arr[0]);
```java
package com.leeup.javase.day05.数组;
/**
 * 数组操作的两个常见问题越界和空指针
 * 案例展示
 * 	ArrayIndexOutOfBoundsException:数组索引越界异常
 * 		原因：你访问了不存在的索引
 * 	NullPointerException:空指针异常
 * 		原因：数组已经不存在指向堆内存了，而你还用数组名去访问
 * 		int[] arr = {1,2,3};
 * 	 	arr = null;
 * 		System.out.println(arr[0]);
 * @author 李闯
 *
 */
public class Demo7_Exception {

	public static void main(String[] args) {
		int[] arr = new int[4];
		System.out.println(arr[5]);//当访问数组中不存在的索引会出现异常，数组索引越界异常
		
		arr = null;//本来是将数组的地址赋值给arr了，但是现在将null将地址覆盖了，那么arr就没有记录数组实体的地址了，再调用会出现空指针异常
		System.out.println(arr);
	}
}
```

### 10. 数组的操作1遍历[就是依次输出数组中的每一个元素]
    1. 数组的遍历
        1. 案例展示
            1. 数组的遍历：就是依次输出数组中的每一个元素
            2. 数组的属性：arr.length 就是数组的长度
            3. 数组的最大索引：arr.length - 1;
        2. 案例展示
            1. 使用方法封装遍历数组
```java
package com.leeup.javase.day05.数组;
/**
 * 数组的遍历
 * 案例展示
 * 	数组的遍历：就是依次输出数组中的每一个元素
 * 	数组的属性：arr.length 就是数组的长度
 * 	数组的最大索引：arr.length - 1;	
 * @author 李闯
 *
 */
public class Demo8_Array {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55};
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);  直接输出方法复用性不高
		
		
		for (int i = 0; i <= 4; i++) { //如果不知道数组中的确切长度，就不能使用类似i<=4这种，所以可以使用 arr.length属性，代表的数组的长度
			System.out.println(arr[i]);
		}
		
		System.out.println(arr.length);//长度为5，数组的长度如果是5，那么数组的索引就是数组的长度-1即4

		
		/**
		 * 调用遍历数组的方法
		 */
		int [] arr2 = {3,4,5};
		printArr(arr2);
	}
	/**
	 * 将遍历数组封装成方法
	 * 分析：
	 * 返回值：只是对数组的元素进行打印，不需要任何返回值即void
	 * 参数列表：数组，int[] arr
	 */
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
```
### 11. 数组的操作2获取最值[最大最小值]
```java
    package com.leeup.javase.day05.数组;
/**
 * 数组中获取最值
 * 
 * @author 李闯
 *
 */
public class Demo9_Array {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55};
		
		int max = getArrMax(arr);
		System.out.println(max);
		
		int min = getArrMin(arr);
		System.out.println(min);
		
		
	}
	
	/**
	 * 获取数组中的最大值
	 */
	public static int getArrMax(int[] arr) {
		
		int max = arr[0];						//max不能为0，因为数组中一旦全都是负数，那么取的最大值即max0了
		for (int i = 1; i < arr.length; i++) {	//从数组中的第二个元素开始遍历
			if (max < arr[i]) {					//如果max记录的值小于数组中的元素
				max = arr[i];					//max记录较大的数
			}
		}
		
		return max;
	}
	
	/**
	 * 获取数组中的最小值
	 */
	public static int getArrMin(int[] arr) {
		
		int min = arr[0];						
		for (int i = 1; i < arr.length; i++) {	
			if (min > arr[i]) {					
				min = arr[i];					
			}
		}
		
		return min;
	}
}
```
### 12. 数组的操作3元素反转[即数组第一个元素的值与最后一个交换，第二个与倒数第二个交换，偶数个可以全部交换]
```java
package com.leeup.javase.day05.数组;
/**
 * 数组元素反转
 * 即数组第一个元素的值与最后一个交换，第二个与倒数第二个交换，偶数个可以全部交换
 * 奇数个中间的不变
 * 所以即 数组长度/2  就知道了交换的循环次数
 * @author 李闯
 *
 */
public class Demo10_Array {

	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55};
		
		reverseArray(arr);
		getArrPrint(arr);
	}
	
	/**
	 * 数组元素反转
	 * 
	 */
	public static void reverseArray(int[] arr) {
		
		for (int i = 0; i < arr.length/2;  i++) {
			//arr[0] 和 arr[arr.length-1-0]交换
			//arr[1] 和 arr[arr.length-1-1]交换
			//arr[2] 和 arr[arr.length-1-2]交换
			
			int temp = arr[i];
			arr[i] = arr[arr.length-1 - i];
			arr[arr.length-1 - i] = temp;
		}
	}
	/**
	 * 数组遍历
	 */
	public static void getArrPrint(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```
### 13. 数组的操作4查表法[根据键盘录入的索引，查找对应的星期]
```java
package com.leeup.javase.day05.数组;
/**
 * 数组查表法[根据键盘录入的索引，查找对应的星期]
 * @author 李闯
 *
 */

import java.util.Scanner;

public class Demo11_Array {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("请输出对应的星期，范围在1-7：");
		int week = scanner.nextInt();
		System.out.println("您输入的转换星期是"+getWeek(week));
	}
	
	/**
	 * 根据索引返回对应的星期
	 * 1. 返回值类型：返回中文类型即char
	 * 2. 参数列表：int
	 */
	public static char getWeek(int week) {
		char[] arr = {',','一','二','三','四','五','六','日'};	//定义了一张星期表
		return arr[week];					//通过索引获取表中的元素
	}
}
```

### 14. 数组的操作5基本查找[查找指定元素第一次在数组中出现的索引]
```java
package com.leeup.javase.day05.数组;
/**
 * 数组元素查找，查找指定元素第一次在数组中出现的索引
 * @author 李闯
 *
 */
public class Demo12_Array {
	
	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55,66,77};
		
		int index = getArrayIndex(arr, 11);
		System.out.println(index);
	}
	/**
	 * 查找元素索引
	 * 1. 返回值类型：int,索引肯定是int类型的
	 * 2.参数列表：1. 数组，根据数组去查找。2. 查找的是哪个元素，值
	 */
	public static int getArrayIndex(int[] arr,int value) {
		
		for (int i = 0; i < arr.length; i++) {	//数组遍历，拿到每个元素
			if (arr[i] == value) {		//数组中的元素与查找的元素匹配
				return i;
			}
		}
		return -1;		//如果没有查找到就返回-1  
	}

}
```

### 15. 二维数组概述和格式1的讲解
    1. 二维数组概述
    2. 二维数组格式
        1. int[] arr = new int[3][2];
    3. 二维数组格式1的解释
    4. 注意事项
        1. 以下格式也可以表示二维数组
            1. 数据类型 数组名 [ ] [ ] = new 数据类型 [m][n];
            2. 数据类型	[]数组名[] = new 数据类型[m][n];
        2. 注意下面定义的区别
  			int x;
  			int y;
  			int x,y;
  
    		int [] x;
    		int [] y[];
    
    		int [] x, y[]; 		x是一维数组，y是二维数组
    5. 案例展示
        1. 定义二维数组，输出二维数组名称，一维数组名称，一个元素
```java
package com.leeup.javase.day05.二维数组;
/**
 * 二维数组概述
 * 二维数组格式
 * 		int[] arr = new int[3][2];
 * 二维数组格式1的解释
 * 注意事项
 * 		以下格式也可以表示二维数组
 * 			1. 数据类型 数组名 [ ] [ ] = new 数据类型 [m][n];
 * 			2. 数据类型	[]数组名[] = new 数据类型[m][n];
 * 		注意下面定义的区别
 * 			int x;
 * 			int y;
 * 			int x,y;
 * 
 *   		int [] x;
 *   		int [] y[];
 *   
 *   		int [] x, y[]; 		x是一维数组，y是二维数组
 *   案例展示
 *   	定义二维数组，输出二维数组名称，一维数组名称，一个元素
 * @author 李闯
 *
 */
public class Demo1_Array {
	public static void main(String[] args) {
		int[] [] arr = new int [3][2];
		/**
		 * 这是一个二维数组
		 * 第一个3 代表二维数组中有3个一维数组
		 * 第二个2代表每个一维数组中有2个元素
		 */
//		int[] arr1 [] = new int [3][2];
//		int arr3 [] [] = new int[3][2];
		
		System.out.println(arr);//二维数组
		System.out.println(arr[0]);//二维数组中的第一个一维数组
		System.out.println(arr[0][0]);//二维数组中的第一个一维数组的第一个元素
		
		/**
		 * 输出结果
		 * [[I@15db9742		二维数组的地址值
		    [I@6d06d69c		一维数组的地址值
			0				一维数组的元素值
		 */
	}
}
```

### 16. 画图讲解二维数组名称，一维数组名称，一个元素的值的问题
    ![Loading](https://raw.githubusercontent.com/AtomRun/notes/master/noteimages/%E4%BA%8C%E4%BD%8D%E6%95%B0%E7%BB%84%E5%86%85%E5%AD%98%E5%9B%BE.png)