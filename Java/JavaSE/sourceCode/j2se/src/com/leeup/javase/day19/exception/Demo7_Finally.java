package com.leeup.javase.day19.exception;
/**
 * finally关键字的特点及作用
 * @author 李闯
 *
 */
public class Demo7_Finally {

	public static void main(String[] args) {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			System.out.println("除数为0了");
			
			System.exit(0);//退出虚拟机finally不会执行
			return;//即使return finally也会执行
			
			//在return语句执行之前看看有没有finally，执行完成其中的语句，如果有就执行后再彻底返回
		}finally {
			//finally的语句中一定会执行，一般用来关闭资源
			System.out.println("看看我执行了嘛");
		}
	}
}
