package com.leeup.javase.day14.otherclass;

import java.util.Calendar;

/**
 * Calendar类的概述和获取日期的方法
 * @author 李闯
 *
 */
public class Demo9_Calendar {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();		//父类引用指向子类对象
//		System.out.println(calendar); 
		System.out.println(calendar.getTime());//获取当前系统年月日到毫秒时间
		System.out.println(calendar.get(Calendar.YEAR));//通过字段获取年
		System.out.println(calendar.get(Calendar.MONTH));//为10月。但是当前月份为11月，因为月份是从0开始编号的
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//月中的第几天
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));//星期中的第几天，这里的按照的规则是周日是第一天，周六是最后一天，故今天是周五，输出的是6
		
		
		System.out.println(calendar.get(Calendar.YEAR)+"年"+getNum((calendar.get(Calendar.MONTH)+1))+"月"
		+getNum(calendar.get(Calendar.DAY_OF_MONTH))+"日 "+getWeek(calendar.get(Calendar.DAY_OF_WEEK)));
	}
	
	/**
	 * 将星期存储表中进行查表
	 * 1. 返回值类型String
	 * 2. 参数列表int week
	 */
	public static String getWeek(int week) {
		String[] arr = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		return arr[week];
	}
	
	/**
	 * 如果是个数数字前面补0
	 * 1. 返回值类型String
	 * 2， 参数列表，int，num
	 */
	public static String getNum(int num) {
//		if (num>9) {
//			return ""+num;
//		}else {
//			return "0"+num;
//		}
		
		return num>9?""+num:"0"+num;
	}
	
}

