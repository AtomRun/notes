package com.leeup.javase.day10.静态内部类;
/**
 * 要求使用已知的变量，在控制台输出30，20，10
 * @author 李闯
 *
 */
public class Test1_InnerClass {

	public static void main(String[] args) {
		Outer1.Inner oInner = new Outer1().new Inner();
		oInner.show();
	}
}
/**
 * 内部类之所以能获取外部类的成员，是因为，他们能获取到外部类的引用 外部类名.this
 * @author 李闯
 *
 */
class Outer1 {
	public int num = 10;
	class Inner {
		public int num = 20;
		public void show() {
			int num = 30;
			System.out.println(num);//就近原则直接给num即可
			System.out.println(this.num);//调用本类的num
			System.out.println(Outer1.this.num);//Outer1相当于限定了，告诉你是哪个类下的，即Outer下的this.num
		}
	}
}