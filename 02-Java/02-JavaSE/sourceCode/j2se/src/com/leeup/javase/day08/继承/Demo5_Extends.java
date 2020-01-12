package com.leeup.javase.day08.继承;

public class Demo5_Extends {

	public static void main(String[] args) {
		Son2 s = new Son2();//创建son对象时默认执行无参构造方法，会输出语句，但是父类的无参构造方法输出语句也会执行
							//因为子类中隐藏了一个super();方法
	}
}

class Father2{
	public Father2() {
		System.out.println("Father的构造方法");
	}
}
class Son2 extends Father2{
	
	public Son2(){
		super();			//这是一条语句，如果你不写，系统会默认加上，作用是用来访问父类中的空参构造 
							//因为子类继承父类，可能要使用父类的数据，所以子类初始化之前，要先使用父类构造方法
							//初始化父类
		System.out.println("Son 的构造方法");
	}
}