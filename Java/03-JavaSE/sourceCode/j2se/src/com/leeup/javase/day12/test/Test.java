package com.leeup.javase.day12.test;

import java.util.Scanner;

/**
 * 	1. 案例演示
		1. 需求：模拟登录,给三次机会,并提示还有几次。
		2. 用户名和密码都是admin
		
		分析：
		1. 模拟登录，需要键盘录入，Scanner
		2. 給三次机会，需要循环，for
		3. 并提示有几次，需要判断，if
 * @author 李闯
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	//创建键盘录入对象
		for (int i = 0; i < 3; i++) {
		System.out.println("请输入用户名：");
		String userName = scanner.nextLine();		//键盘录入的用户名存储到userName中
		System.out.println("请输入密码：");
		String userPwd = scanner.nextLine();		//键盘录入的密码存储到userPwd中
		
		//如果是字符串常量和字符串变量比较，通常都是用字符串常量调用方法，将变量当作
		//变量传递，当作空指针异常
			if ("admin".equals(userName) && "admin".equals(userPwd)) {
				System.out.println("恭喜"+userName+"，登录成功");
				break;//登录成功跳出循环
			}else {
				if (i==2) {
					System.out.println("您的错误次数已到上限，请明天再来");
				}else {
					System.out.println("很抱歉，您的用户名或密码错误，您还有"+ (2-i) +"次登录机会");
				}
			}
		}
	}
}
