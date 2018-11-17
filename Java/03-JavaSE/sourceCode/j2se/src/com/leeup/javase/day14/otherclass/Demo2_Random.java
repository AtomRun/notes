package com.leeup.javase.day14.otherclass;

import java.util.Random;

public class Demo2_Random {

	public static void main(String[] args) {
		Random r = new Random();
		int x = r.nextInt();
//		System.out.println(x);//在int范围内生成的随机数
		System.out.println(r.nextInt(100));//即取0-99之间的随机数，有奥求掌握，生成0-n-1范围内的随机数，包含0不包含n
		
		Random r2 = new Random(1000);//纳秒值
		int a = r2.nextInt();
		int b = r2.nextInt();
		System.out.println(a);
		System.out.println(b);//以上面1000的种子值进行计算而来
		/**
		 * 输出结果a:-1244746321和b:1060493871
		 * 因为在new Random参数中写的是1000，
		 */
		
	}
}
