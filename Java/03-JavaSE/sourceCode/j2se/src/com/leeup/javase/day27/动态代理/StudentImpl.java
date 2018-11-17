package com.leeup.javase.day27.动态代理;

public class StudentImpl implements Student{

	@Override
	public void login() {
		System.out.println("登录");
	}

	@Override
	public void submit() {
		System.out.println("提交");
	}

}
