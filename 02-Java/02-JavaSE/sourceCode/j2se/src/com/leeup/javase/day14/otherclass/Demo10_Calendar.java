package com.leeup.javase.day14.otherclass;

import java.util.Calendar;

/**
 * Calendar类的add()和set()方法
 * @author 李闯
 *
 */
public class Demo10_Calendar {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 1);//写哪个字段就对哪个字段进行操作，向前-，或者向后+
		calendar.set(Calendar.YEAR, 12);//修改指定字段
		calendar.set(2000, 11, 14);//设置年月日。这里设置的11其实是10，因为 月份从0计算的
	}
}
