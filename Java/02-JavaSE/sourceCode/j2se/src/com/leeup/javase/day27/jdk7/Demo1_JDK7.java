package com.leeup.javase.day27.jdk7;
/**
 *  1. 二进制字面量
    2. 数字字面量可以出现下划线
    3. switch语句可以用字符串
    4. 泛型简化，菱形泛型
    5. 异常的多个catch合并，每个异常用或|
    6. try-catch-resources 语句		1.7之后,标准的异常处理代码,关流
    
    1000000
 * @author 李闯
 *
 */
public class Demo1_JDK7 {

	public static void main(String[] args) {
		System.out.println(0b110);		//jdk7之前不允许这样表示
		System.out.println(100_000);	//为了看的方便,可以有下划线,输出时不会输出_,只能在数字中使用
		
	}
}
