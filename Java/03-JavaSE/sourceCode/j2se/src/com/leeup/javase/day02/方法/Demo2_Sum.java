package com.leeup.javase.day02.方法;
/**
 * 利用方法求两个数的和
 * @author 李闯
 *
 */
public class Demo2_Sum {

	public static void main(String[] args) {
		int result = sum(12, 44); 			//1. 调用add方法，将12，20，分别传递给a,b,这里给的参数就是实际参数 	 
		System.out.println(result);			//4. 方法返回的结果返回给result并输出
//		sum(12, 44); 	//单独调用，一般不建议，有返回值的方法的单独调用,没有意义
		System.out.println(sum(3, 5));  //这样调用是可以,但是如果需要这个结果不推荐这样调用
	}
	
	/**
	 * 求两个整数的和
	 * 1. 整数的和结果还是整数
	 * 2. 有两个未知内容参与运算
	 * 
	 * 如何写方法?
	 * 1. 明确返回值类型，在这里即int
	 * 2. 方法名字，要起到见名知意，即sum
	 * 3. 明确参数列表，这里对两个整数进行运算，即int a ,int b [形式参数，用来接收调用方法时传的值]
	 * 3.1  参数类型即 int
	 * 3.2  参数名即 a,b
	 */
	public static int sum(int a, int b) {	//2. 赋值a = 10, b = 20;
		return a+b;							//3. 执行语句把a,b相加并返回
	}
	
	/**
	 * 使用开饭店：厨师的案例来讲解方法的使用/便利
	 * 
	 * 盘子 [返回类型] 炒菜[方法名](油,调料,米,菜[形式参数，等待实际参数填入]){
	 * 		炒菜的动作[方法体操作语句]
	 * 		return 一盘菜[返回值和返回类型的类型保持一致]
	 * }
	 */
	
	/***
	 * 调用方法
	 * 
	 * //盘子 = 炒菜(地沟油,苏丹红,镉大米,烂白菜[实际参数]);  注：返回值类型是什么，我们就要用什么类型去接收
	 */
}
