package com.leeup.javase.day27.模板方法设计模式;
/**
 * 模板(template)设计模式概述和使用
 * @author 李闯
 *
 */
public class Demo1_Template {

	public static void main(String[] args) {
		Demo demo = new Demo();
		System.out.println(demo.getTime());
	}
}

abstract class getTime {
	public final long getTime() {					//final修饰为了不让子类重写
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		return end - start;
	}

	public abstract void code();
}


class Demo extends getTime {

	@Override
	public void code() {
		int i = 0;
		
		while (i<100000) {
			System.out.println("x");
			i++;
		}
	}
	
}