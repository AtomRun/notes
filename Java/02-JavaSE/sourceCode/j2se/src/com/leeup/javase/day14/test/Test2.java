package com.leeup.javase.day14.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 你来到这个世界多少天案例
 * 第一步：
 * 	1. 将生日字符串和今天字符串存储在String类型的变量中
 *  2. 定义日期格式化对象
 *  3. 将日期字符串转换为日期对象
 *	4. 通过日期对象获取时间毫秒值
 *	5. 将两个时间毫秒值相减除以1000，变成秒，再除以60，变成分钟，再除以60变成小时，再除以24，变成天
 * @author 李闯
 *
 */
public class Test2 {

	public static void main(String[] args) throws ParseException {
		String birthday = "1997年11月14日";
		String today =	"2018年11月2日"; 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		
		Date d1 = sdf.parse(birthday);
		Date d2 = sdf.parse(today);
		
		long time = d2.getTime()-d1.getTime();
		
		System.out.println(time/1000/60/60/24+"天");
		
	}
}
