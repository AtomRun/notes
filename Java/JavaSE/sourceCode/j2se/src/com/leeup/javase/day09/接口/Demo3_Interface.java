package com.leeup.javase.day09.接口;

public class Demo3_Interface {

	public static void main(String[] args) {
		
	}
}

interface InterA {
	public abstract void printA();
}

interface InterB {
	public abstract void printB();
}

/**
 * 可以选择多实现也可以多实现
 * 如果两个接口中方法相同，实现的类中只用写一个方法实现即可，相当于重写了两个，因为接口中是没有方法体的
 * @author 李闯
 * 
 */
class DemoA implements InterA,InterB{		//implements 关键字只用写一次
	
	//重写方法
	@Override
	public void printA() {
		
	}

	@Override
	public void printB() {
		
	}
} 
/**
 * 接口之间不能实现,但是可以多继承或者单继承，
 * @author 李闯
 *
 */
interface InterC extends InterB,InterA{
	
}