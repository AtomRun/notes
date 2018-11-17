package com.leeup.javase.day07.static1;

public class Demo1_Static {

	public static void main(String[] args) {
		Person p1 = new Person();	//创建对象
		/**
		 * 调用属性并赋值
		 * 这里不是私有属性，所以可以直接调用并且赋值，如果是私有属性需要get/set方法来调用赋值了
		 */
		p1.name = "苍老师";//调用姓名属性并且赋值
		p1.country = "日本";//调用国籍属性并且赋值
		
		p1.speak();
		
		Person p2 = new Person();
		p2.name = "小泽老师";
//		p2.country = "日本";
		
		p2.speak();		//如果country加了static,那么p1的country赋值了之后，这个speak输出的country
						//的值也会是日本，因为static修饰的变量值是共享的。
		/**
		 * 
		 * static属性的好处：多个对象共享同一个属性，节约内存
		 */
		
		Person.country = "日本";			//静态多了一种调用方式，可以通过类名.属性名。也可以使用对象.  或者类名.
										//推荐使用类名. 因为如果只需要调用静态，就不需要创建对象了
		System.out.println(Person.country);
	}
}

class Person{
	String name;
	static String country; //加了静态之后，属性值都是共享的
	
	//说话的方法
	public void speak() {
		System.out.println("我的名字是"+name+"，我来自于"+country);
	}
}