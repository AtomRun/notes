package com.leeup.javase.day02;
/**
 * 1. 循环结构while语句的格式： 
        while循环的基本格式：
        while(判断条件语句){  //就相当于for语句中的条件表达式
            循环体语句;       //相当于for语句中的循环体
        } 

        完整格式：

        初始化语句;
        while(判断条件语句){
            循环体语句;
            控制条件语句;
        }
    2. 执行流程
        1. 执行初始化语句
        2. 执行判断条件语句，看其返回值是true还是false
            1. 如果是true，就继续执行
            2. 如果是false，就结束循环
        3. 执行循环语句
        4. 执行控制条件语句
        5. 回到2继续   
 * @author 李闯
 *
 */
public class Demo1_While {
	public static void main(String[] args) {
		int x = 1;
		while (x<=10) {
			System.out.println("x = "+x);
			x++;
			break;
		}
	}
}
