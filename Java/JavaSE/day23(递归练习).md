## 递归相关练习

### 1. 统计文件夹大小
    1. 从键盘接收一个文件夹路径，统计该文件夹大小
```JAVA
package com.leeup.javase.day23.test;

import java.io.File;
import java.util.Scanner;


/***
 * 从键盘接收一个文件夹路径，统计该文件夹大小
 * @author 李闯
 * 分析：
 * 从键盘接收一个文件夹路径
 * 	1. 创建键盘录入对象
 * 	2. 定义一个无限循环
 *  3. 将键盘录入的结果存储并封装成file对象
 *  4. 对file对象进行判断
 *  5. 将文件夹路径对象进行返回
 * 统计该文件夹大小
 * 	1. 定义一个求和变量
 *  2. 获取该文件夹下所有的文件和文件夹 listFiles();
 *  3. 遍历数组
 *  4. 判断是文件就计算大小并累加
 *  5. 判断是文件夹，递归调用
 *
 */
public class Test1 {

	public static void main(String[] args) {
//		File dir = getDir();
//		System.out.println(getFileLength(dir));		//直接获取文件夹的结果是0
		
		File dir1 = new File("E:\\Note\\notes\\Java");
		System.out.println(getFileLength(dir1));
	}
	
	/**
	 * 统计该文件夹大小
	 * 1. 返回值类型，Long
	 * 2. 参数列表 File dir
	 */ 
	public static long getFileLength(File dir) {
		//1 
		long len = 0;
		//2
		File[] subFiles = dir.listFiles();//获取该文件夹下的所有的文件和文件夹
		//3 
		for (File subfile : subFiles) {
			if (subfile.isFile()) {
				len = len + subfile.length();
			}else if (subfile.isDirectory()) {
				getFileLength(subfile);
			}
		}
		return len;
	}
	
	/**
	 * 从键盘接收一个文件夹路径
	 * 1. 返回值类型File
	 * 2. 参数列表无
	 */
	public static File getDir(){
		//1.  
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个文件夹路径");
		//2
		while (true) {
			//3
			String line = scanner.nextLine();
			File dir = new File(line);
			//4 
			if (!dir.exists()) {
				System.out.println("您录入的文件夹路径不存在，请输入一个正确的文件夹路径");
			} else if (dir.isFile()) {
				System.out.println("您输入的是一个文件路径，请输入一个文件夹路径");
			}else {
				//5
				return dir;
			}
		}
	}
}
```

### 2. 从键盘接收一个文件夹路径，删除该文件夹
```java
package com.leeup.javase.day23.test;

import java.io.File;

/**
 * 从键盘接收一个文件夹路径，删除该文件夹
 * 
 * 删除该文件夹
 * 分析：
 * 	1. 获取该文件夹下的所有文件和文件夹
 *  2. 遍历数组
 *  3. 判断是文件直接删除
 *  4. 如果是文件夹，递归调用
 *  5. 循环结束后。把空文件夹删除
 */
public class Test2 {

	public static void main(String[] args) {
		File dir = Test1.getDir();		//获取文件夹路径
		deleteFile(dir);
	}
	
	/**
	 * 删除该文件夹
	 * 1. 返回值类型void
	 * 2. 参数列表File dir
	 */
	public static void deleteFile(File dir){
		//1. 
		File[] subFiles = dir.listFiles();
		//2
		for (File file : subFiles) {
			//3.
			if (file.isFile()) {
				file.delete();
			}else {
				//4.
				deleteFile(file);
			}
		}
		//5
		dir.delete();
	}
}

```
### 3. 从键盘接收两个文件夹路径，把其中一个文件夹中(包含内容)拷贝到另一个文件夹中

### 4. 从和键盘接收一个文件夹路径，把文件夹中的所有文件以及文件夹的名字按层级打印，例如：
    aaa是文件夹，里面有bbb.txt，ccc.txt，ddd.txt这些文件，有eee这样的文件夹，eee中有fff.txt和ggg.txt，打印出层级来
    aaa
        bbb.txt
        ccc.txt

    eee
        fff.txt
        ggg.txt
    
### 5. 斐波那契数列
    1. 不死神兔
    2. 故事从西元1202年说起，话说有一位意大利青年，名叫斐波那契
    3. 在他的一部著作中提出了一个有趣的问题：假设一对刚出生的小兔一个月后就能长成大兔，再过一个月就能生一对小兔，一年内没有发生死亡
    4. 问：一对刚出生的兔子，一年内繁殖成对少对兔子？
    5. 1 1 2 3 5 8 13

### 6. 1000的阶乘和所有零和尾部零的个数
    1. 需求：求出1000的阶乘所有零和尾部零的个数，不用递归做

### 7. 1000的阶乘尾部零的个数
    1. 需求：”求出1000的阶乘尾部零的个数，用递归做

### 8. 约瑟夫环
    1. 幸运数字