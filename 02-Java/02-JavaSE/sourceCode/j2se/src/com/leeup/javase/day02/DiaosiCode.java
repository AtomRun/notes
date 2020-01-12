package com.leeup.javase.day02;
/**
 * 屌丝为了追求女神，写了一段代码示爱，但是女神也会java,改动了一个拒绝了屌丝
 * @author 李闯
 *
 */
public class DiaosiCode {

	public static void main(String[] args) {
		int j = 1;
		while (j<=10000); { 
			//加了分号，那么上面的语句是while语句，下面的并不属于while语句，条件一直满足，一直判断，下面就不会执行
			//即 有分号不能有左大括号，有左大括号不能有分号
			System.out.println("I love you !!!");
			j++;
		}
	}
}
