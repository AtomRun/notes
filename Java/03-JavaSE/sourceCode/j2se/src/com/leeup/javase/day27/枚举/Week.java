package com.leeup.javase.day27.枚举;

public class Week {

	private Week() {}			//私有构造不让其他类创建本类对象
	
	//枚举的第一种方式
	public static final Week MON = new  Week();
	public static final Week TUE = new  Week();
	public static final Week WED = new  Week();
}
