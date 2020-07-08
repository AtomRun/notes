package com.leeup.javase.day06.privatedemo;

public class Demo1_Person {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "张三";		//调用属性并赋值
//		p1.age = 23;		//当age为私有的时候，只能在本类中访问,想要设置值，只能通过set方法
		//如果有人想要设置一些错误的值给age,那么不是private将会直接设置，但是有了private后，设置值必须通过set方法，这时候虽然也可以设置一些错误的值给age，但是
		//我们现在有了get/set方法，可以在方法中写判断语句来阻止这种情况的发生
		p1.setAge(-1);
//		p1.setAge(23);
//		p1.speak();			//调用方法
		
	}
}

class Person{
	String name;	//姓名
	private int age;		//年龄
	
	//设置年龄
	public void setAge(int a) {
		if (a > 0 && a < 200) {
			age = a;//想要设置age的值，设置别人穿过来的参数，赋值给age
		}else {
			System.out.println("您输入的年龄不正确！");
		}
	}
	
	//获取年龄，年龄是int的，所以返回值为int
	public int getAge() {
		return age;
	}

	public void speak() {
		System.out.println(name+"..."+age);
	}
}
