package com.leeup.javase.day21.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 当我们下载一个试用版软件,没有购买正版的时候,每执行一次就会提醒我们还有多少次使用机会用学过的IO流知识,模拟试用版软件,
 * 试用10次机会,执行一次就提示一次您还有几次机会,如果次数到了提示请购买正版
 * @author 李闯
 * 分析：
 * 1. 创建带缓冲的输入流对象，因为readLine方法，可以保证 数据的原样性
 * 2. 将得到的字符串准换为int数
 * 3. 对int数j进行判断，如果大于0，就将其--写回去，如果不大于零，就提示购买正版
 * 4. 在if判断中要将--的结果打印，并将结果通过输入流写入到文件上
 */
public class Test3 {

	public static void main(String[] args) throws IOException {
		//1 
		BufferedReader br = new BufferedReader(new FileReader("config.txt"));
		//2 
		String line = br.readLine();
		int times = Integer.parseInt(line);		//将数字字符串转换为数字
		//3 
		if (times>0) {
			//4
			System.out.println("您还有"+times--+"次机会");
			FileWriter fw = new FileWriter("config.txt");
			fw.write(times +"");
			fw.close();
		}else {
			System.out.println("您的使用次数已经达到，请购买正版");
		}
		//关闭流
		br.close();
	}
}
