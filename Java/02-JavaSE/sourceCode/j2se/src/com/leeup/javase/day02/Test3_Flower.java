package com.leeup.javase.day02;
/**
 * 控制台输出所有的水仙花数
 * 
 * 水仙花数即一个三位数，其个位数字的立方和等于该数本身
 * 举例153就是一个水仙花数
 * 
 * @author 李闯
 * 153 = 1*1*1 + 5*5*5 + 3*3*3  = 1 + 125 + 27 = 53
 * 分析
 * 1. 100-999之间
 * 2. 获取每一个位数的值，百位，十位，个位
 * 3. 判断各个位上的立方和是否等于这个数，如果等于打印
 */
public class Test3_Flower {

	public static void main(String[] args) {
		for (int i = 100; i <=999; i++) {   //获取100-999之间的数
			int ge = i%10;//				//123 % 10  余3
			int shi = i / 10 % 10; 			//i/10;12  12%10; 2
			int bai = i/10/10 % 10;			//i/10;12  12/10; 1  1%10; 1
			
			if (ge * ge * ge + shi * shi * shi +bai * bai * bai == i) {
				System.out.println(i);
			}
		}
	}
	
}
