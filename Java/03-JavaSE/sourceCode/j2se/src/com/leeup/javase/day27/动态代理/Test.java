package com.leeup.javase.day27.动态代理;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		/*
		UserImpl userImpl = new UserImpl();
		userImpl.add();
		userImpl.delete();
		
		System.out.println("分割线");
		MyInvocationHandler m = new MyInvocationHandler(userImpl); 
		User u = (User)Proxy.newProxyInstance(userImpl.getClass().getClassLoader(), 
				userImpl.getClass().getInterfaces(), m);
		u.add();
		u.delete();
		*/
		StudentImpl si = new StudentImpl();
		si.login();
		si.submit();
		System.out.println("================");
		MyInvocationHandler m = new MyInvocationHandler(si); 
		Student s = (Student)Proxy.newProxyInstance(si.getClass().getClassLoader(), 
				si.getClass().getInterfaces(), m);
		
		s.login();
		s.submit();
	}
}
