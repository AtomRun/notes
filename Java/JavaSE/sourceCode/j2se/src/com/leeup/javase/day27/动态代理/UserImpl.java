package com.leeup.javase.day27.动态代理;

public class UserImpl implements User{

	@Override
	public void add() {
		//每次两个功能都要修改源代码,比较麻烦,使用动态代理
//		System.out.println("权限校验");
		System.out.println("添加功能");
//		System.out.println("日志记录");
	}

	@Override
	public void delete() {
//		System.out.println("权限校验");
		System.out.println("删除功能");
//		System.out.println("日志记录");
	}

}
