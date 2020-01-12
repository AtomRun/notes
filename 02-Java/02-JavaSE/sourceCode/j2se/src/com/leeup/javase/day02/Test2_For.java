package com.leeup.javase.day02;
/**
 * 求出1-10之间的数据之和
 * 求出1-100之间的偶数和
 * 求出1-100之间的奇数和
 * @author 李闯
 *
 */
public class Test2_For {

	public static void main(String[] args) {
		
		int sum = 0;
		
//		for (int i = 1; i <=10; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
		
//		for (int i = 1; i <= 100; i++) {
//			if (i%2==0) {
//				sum +=i;
//			}
//		}
//		System.out.println(sum);
		
//		for (int i = 1; i <= 100; i++) {
//			if (i%2!=0) {
//				sum +=i;
//			}
//		}
//		System.out.println(sum);
		
		//奇数和
		for (int i = 1; i <= 100; i+=2) {
			sum += i;
			System.out.println(sum);
		}
		System.out.println(sum);

	}
}
