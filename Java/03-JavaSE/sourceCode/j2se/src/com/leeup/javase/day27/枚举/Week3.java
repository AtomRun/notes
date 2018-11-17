package com.leeup.javase.day27.枚举;

public abstract class Week3 {

	
	//枚举的第三种方式
	public static final Week3 MON = new  Week3("星期一") {		//匿名内部类,父类引用指向子类对象,在这里new一个类小括号大括号就是继承这个类
		public void show() {
			System.out.println("星期一");
		}
	};
	public static final Week3 TUE = new  Week3("星期二"){
		public void show() {
			System.out.println("星期二");
		}
	};
	public static final Week3 WED = new  Week3("星期三"){
		public void show() {
			System.out.println("星期三");
		}
	};
	
	private String name;
	private Week3(String name) {
		this.name = name;
	}
	
	public abstract void show();
}
