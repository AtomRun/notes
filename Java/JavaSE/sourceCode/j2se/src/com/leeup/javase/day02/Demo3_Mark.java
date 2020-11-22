package com.leeup.javase.day02;
/**
 * 
 * @author 李闯
 *
 */
public class Demo3_Mark {

	public static void main(String[] args) {
		outer:for (int i = 1; i <= 10; i++) {  //a就是标号[只要是合法标识符即可]，一般使用标号是多层循环的时候，即想要跳出指定循环
			System.out.println("i = "+ i);
			inner:for (int j = 1; j <=10; j++) {
				System.out.println("j = " + j);
				break outer; //在哪个循环体，就跳出哪个循环体，在这里跳出内循环，跳出内循环没有什么意义，一般是用来跳出外循环
			}
			
			
			System.out.println("大家好");
			http://www.baidu.com  		//在这里是个号，但是//后是一个单行注释，不会执行。这里http: 相当于给这个输出语句做了个标号
			System.out.println("才是真的好");
		}
	}
}
