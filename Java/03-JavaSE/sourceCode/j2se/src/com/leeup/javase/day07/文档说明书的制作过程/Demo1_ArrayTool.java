package com.leeup.javase.day07.文档说明书的制作过程;
/**
 * 数组工具类测试类
 * @author 李闯
 *
 */
public class Demo1_ArrayTool {

	public static void main(String[] args) {
		int[] arr = {11,23,54,546,566,23,654,7,2,45,4};
//		Array_Tool array_Tool = new Array_Tool();
//		int max = array_Tool.getMax(arr);	//获取最值
//		System.out.println(max);
//		System.out.println("==========================");
//		array_Tool.print(arr);				//打印
//		System.out.println("==========================");
//		System.out.println("反转后");
//		array_Tool.arrRverse(arr);			//反转
//		
//		array_Tool.print(arr);
		
		//静态方式调用
		Array_Tool.print(arr);
		System.out.println("==========================");
	}
}
