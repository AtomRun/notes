package com.leeup.javase.day02;
/**
 * 1. 求和思想
        1. 求1-100之和
   2. 统计思想
        1. 统计"水仙花数"共有多少个
 * @author 李闯
 *
 */
public class Test1_While {
	public static void main(String[] args) {
		//求和
		int sum = 0;
		int i = 1;
		while(i<=100) {
			sum+=i;			//sum = sum + i
			i++;			//让变量i自增
		}
		System.out.println(sum);
		
		//统计水仙花数
		int count = 0; 		//定义计数器
		int j = 100;        //定义初始化值
		while (i<=999) {
			int ge = i%10;
			int shi =  i/10%10;
			int bai = i/100;
			
			if (i == ge*ge*ge+shi*shi*shi+bai*bai*bai) {
				count ++;
			}
			i++;
		}
		System.out.println(count);
	}
}
