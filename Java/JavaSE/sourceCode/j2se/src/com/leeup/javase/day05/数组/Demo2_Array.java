package com.leeup.javase.day05.数组;
/**
 * 数组的初始化
 * @author 李闯
 *
 * 整数类型：byte short int long 默认初始化值都是0 
 * 浮点类型：float double 默认初始化值都是0.0
 *布尔类型：boolean 默认初始化值flase
 *字符类型：char 默认初始化值是'\u0000' 
 *类型char在内存中占两个字节，是16个二进制位，\u0000 每个0其实代表的是16进制的0，4个0就是代表16个二进制位
 */
public class Demo2_Array {

	public static void main(String[] args) {
		int[] arr = new int[5];	//数组的动态初始化，相当于在内存中开辟连续的5块空间，用来存储int类型的5个值
		System.out.println(arr[0]);//输出结果是0，这个值是系统给出默认初始化值，整数类型的都是0
		
		arr[0] = 10;
		System.out.println(arr[0]); 
		
		System.out.println(arr);	//[I@15db9742  [半个中括号代表一维数组，几个就代表几维,I代表int类型的，@是分隔符，固定的，后面的是地址符，hashCode的地址，是16进制表现形式 。 
									//所以这里打印的是数组的地址值，它创建了数组对象后就把地址值告诉了arr，arr就可以去访问里面的0，1，2索引
		
		
		
		int[] ars = {10}; 
		System.out.println(ars[0]);
		 
	}
}
