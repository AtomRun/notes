package com.leeup.javase.day10.匿名内部类;


public class Test2_NoNameInnerClass {

	public static void main(String[] args) {
		Outer2.method().show();//每次调用方法还能再进修调用方法就叫链式编程，证明调用方法返回的是对象
		Inter2 inter2 = Outer2.method();//Outer2.method();返回的是一个Inter2我们使用Inter2接收
		inter2.show();//父类引用指向子类对象，编译看Inter2的show方法，运行看的是子类的show方法
	}
}


interface Inter2 { 
	void show();
}
class Outer2 { 
	//补齐代码
	public static Inter2 method(){
		return new Inter2() {		//实现Inter2接口
			
			@Override
			public void show() {
				System.out.println("Hello World");
			}
		};
	}
}
