package com.leeup.javase.day09.抽象类;

public class Demo3_葵花宝典 {

	public static void main(String[] args) {
		岳不群 小岳子 = new 岳不群();
		小岳子.自宫(); 
	}
}

/**
 * 葵花宝典声明一种规则，继承他的子类必须要遵守这个规则
 * @author 李闯
 *
 */
abstract class 葵花宝典{
	public abstract void 自宫();//因为并不知道后面的人如何执行这个方法，所以定义为抽象
}

class 岳不群 extends 葵花宝典 {
	public void 自宫() {
		System.out.println("用牙签");
	}
}

class 林平之 extends 葵花宝典{
	public void 自宫() {
		System.out.println("用指甲刀");
	}
}

class 东方不败 extends 葵花宝典{
	public void 自宫() {
		System.out.println("用锤子，不忍直视");
	}
}