package com.leeup.javase.day02.方法;

import java.util.Scanner;

/**
 * 案例展示
 * 		需求:根据键盘录入的行数和列数,在控制台输出星形
 * 方法调用
 * 		单独调用
 * 		输出调用[错误]
 * 		赋值调用[错误]
 * 		
 * 根据情况来看只能使用单独调用最合适
 * 返回值是void的方法,只能单独调用,并不能输出或者
 * @author 李闯
 *
 */
public class Demo3_Method {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.println("请输入行数");
		int row = sc.nextInt();  
		System.out.println("请输入列数");
		int column = sc.nextInt();
		
		getStar(row, column);
	}
	
	/**
	 * 控制台输出矩形星形
	 * 分析:
	 * 	返回值类型:经分析,没有具体的返回值类型,即可使用void
	 * 	参数类型:行与列为int类型参数
	 * 
	 * 
	 */
	public static void getStar(int a,int b) {
		for (int i = 1; i <=a; i++) {
			//行数
			for (int j = 1; j <=b; j++) {
				//列数
				System.out.print("*");
			}
			System.out.println();//内循环结束即换行一次
		}
		return ;//如果返回值类型是void,return可以省略,即使省略系统也会默认给加上,形式是 return;
	}
}
