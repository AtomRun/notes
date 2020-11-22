package com.leeup.javase.day19.exception;
/**
 * throws的方式处理异常
 * 编译时异常的抛出：
 * 		必须对其进行处理
 * 运行时异常的抛出：
 * 		可以处理，可以不处理
 * @author 李闯
 *
 */
public class Demo6_Exception {

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		p.setAge(-17);//调用有异常的方法，必须对他进行异常处理
		System.out.println(p.getAge());
	}
}

class Person{
	private String name;
	private int age;
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception {
		if (age > 0 && age<=150) {
			this.age = age;
		}else {
			throw new Exception("年龄非法");//当抛出RuntimeException的收，编译时不需要对他进行处理
//			System.out.println("请回火星吧");
		}
	}
}