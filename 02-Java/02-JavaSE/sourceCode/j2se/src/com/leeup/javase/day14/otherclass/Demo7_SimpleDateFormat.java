package com.leeup.javase.day14.otherclass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat类实现日期和字符串的相互转换
 * @author 李闯
 *
 */
public class Demo7_SimpleDateFormat {

	public static void main(String[] args) throws ParseException {
//		demo1();
		
//		demo2();
		
//		demo3();
		
		//将时间字符串转换为日期对象，好处，日期对象有set,get这样的方法，可以获取毫秒值，可以对它进行计算
		//比如有两个字符串，一个是出生的，一个是今天的，将这两个字符串转换为日期对象，就可以求出年龄了
		String str = "2000年08月08日 08:08:08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//与上方str保持一致
		Date d = sdf.parse(str);			//将时间字符串转换为日期对象，这里会出现异常，因为这个字符串可能会"瞎写",如果瞎写的话就转换不了，转换不了就会出错
		System.out.println(d);
	}

	private static void demo3() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(sdf.format(d));
	}

	private static void demo2() {
		Date d = new Date();							//创建日期对象
		SimpleDateFormat sdf = new SimpleDateFormat();	//创建日期格式化类对象
		System.out.println(sdf.format(d));
	}

	private static void demo1() {
		//DateFormat df = new DateFormat();	DateFormat是抽象类不允许实例化
		
		//相当于父类引用指向子类对象，右边的方法返回一个子类对象
		//相当于DateFormat df1 = new SimpleDateFormat();
		DateFormat df1 = DateFormat.getDateInstance();
	}
}

