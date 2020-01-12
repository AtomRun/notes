package com.leeup.javase.day02;

/**
 * 水仙花数有多少个
 * 分析：
 * 1. 需要有一个变量记录住水仙花数的个数
 * 2. 获取到所有的三位数
 * 3. 判断是不是水仙花数
 * 4. 如果满足条件是水仙花数，计数器就自增
 * @author 李闯
 *
 */
public class Test3_FlowerCount {

	public static void main(String[] args) {
		int count = 0;
		
		for (int i = 100; i <= 999; i++) {
			int ge  = i%10;
			int shi = i/10%10;
			int bai = i/10/10%10;
			
			if (i == ge * ge * ge + shi * shi * shi + bai * bai * bai) {
				count +=1;
			}
		}
		System.out.println(count);
	}
}
