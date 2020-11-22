package com.leeup.javase.day11.object;

import com.leeup.javase.day11.test.Student;

public class Demo3_ToString {

	public static void main(String[] args) {
		Student student = new Student("张三",23);
		String str = student.toString();
		/**
		 * 当Student类中没有重写toString方法的时候
		 * com.leeup.javase.day11.object.test.Student@15db9742
		 * 左边是Student的类名，右边是
		 * 
		 * toString源码中
		 * return getClass().getName() + "@" + Integer.toHexString(hashCode());
		 * 将getClass,getName的内容连接起来了
		 * Integer.toHexString  以十六进制(基数16)无符号整数形式返回一个整数参数的字符串表示形式
		 * 即能将整数转换为16进制以字符串形式返回,在这里就是对hashCode进行转换
		 * 
		 * 这么些没有什么实际意义，其实这是重写了父类的toString方法
		 * 
		 * 
		 * 当Student重写了toString方法的时候
		 * 即输出大家好
		 * 
		 * 真正有意义的toString是在输出的时候将属性值显示出来即
		 * return "我的姓名是" +name + "，我的年龄是"+age
		 * 
		 * toString方法的作用：
		 * 更方便地显示属性值
		 * 而getXxx是为了获取值，可以显示也可以赋值，或者做其他操作
		 */
		
		
		System.out.println(str);
		
		/**
		 * 如果直接打印对象的引用即student会默认调用toString方法
		 */
		System.out.println(student);
	}
}
