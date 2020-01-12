package com.leeup.javase.day21.chario;
/**
 * File类(递归)
    * 5的阶乘	
    * 递归：自己调用自己
 * @author 李闯
 *	5!
 *	5 * 4 * 3 * 2 * 1
 *
 *  5 * fun(4)(代表4!)
 *  	4 * fun(3)(代表3!)
 *  		3 * fun(2)(代表2!)
 *  			2 * fun(1)(代表1!)
 *  递归的弊端
 *  	不能调用次数过多，容易导致栈内存溢出
 *  好处：不用知道循环次数
 *  构造方法是否可以递归调用？
 *  	不能使用递归调用
 *  
 *  递归调用是否必须要有返回值？
 *  	不一定，可以有，可以没有 
 */
public class Demo8_DiGui {

	public static void main(String[] args) {
		int result = 1;
		
		for (int i = 1; i <= 5; i++) {
			result = result * i;
		}
		System.out.println(result);
	}
	
	public static int fun(int num) {
		if (num == 1 ) {
			return 1;
		}else {
			return num * fun(num -1);
		}
	}
}
