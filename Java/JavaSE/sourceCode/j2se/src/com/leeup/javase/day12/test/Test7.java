package com.leeup.javase.day12.test;
/**
1. 画图演示
2. 需求：统计大串中小串出现的次数
	1. 这里的大串和小串可以自己根据情况给出
 * @author 李闯
 *
 */
public class Test7 {

	public static void main(String[] args) {
		//定义大串
		String max = "woaizhongguo,zhongguoaiwo,wulunzhongguoznemeyang,tadoushiwomendeguojia";
		//定义小串
		String min = "zhongguo";
		
		//定义计数器变量
		int count = 0;
		//定义索引
		int index = 0;
		//定义循环，判断小串是否在大串中出现
		while((index = max.indexOf(min)) != -1) {	//不是-1就表示小串没在大串中出现
			count++;								//计算器自增
			max = max.substring(index + min.length());//对新字符串进行截取
		}
		System.out.println(count);
	}
}
