package com.leeup.javase.day08.继承;

public class Demo4_Extends {

	public static void main(String[] args) {
		
		/**
		 * 不同名的变量
		 */
		Son1 son1 = new Son1();
		son1.print();
	}
}

class Father1{
	int num1 = 10;
	int num2 = 30;
}

class Son1 extends Father1{
	int num2 = 20;
	public void print() {
		System.out.println(num1);
		System.out.println(num2);	//当父类也有num2并且值为30时，输出结果还是20，因为就近原则，子类有就不用父类的了。
									//子父类出现了同名的变量只是举例为之，在开发中是不会出现这种情况的，因为子类继承父类
									//是为了使用父类的属性，既然子类中都有了num2属性，就不用在父类中再次定义了
	}
}