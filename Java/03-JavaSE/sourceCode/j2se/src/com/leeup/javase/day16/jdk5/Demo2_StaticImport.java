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
