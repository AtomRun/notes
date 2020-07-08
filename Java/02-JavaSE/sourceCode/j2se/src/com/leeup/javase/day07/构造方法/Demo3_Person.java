package com.leeup.javase.day07.构造方法;

public class Demo3_Person {

	public static void main(String[] args) {
		Person2 p2 = new Person2("张三",21);
		//如果我们想要给张三改名，那么使用如下方法，重新new对象
		/**
		 * 但是这个举动其实不能叫做“改名”，应该叫做“杀人”
		 * 因为一开始p2 new了一个对象叫张三，21岁，又new了个对象叫张天一，21岁，并且将地址值赋值给p2,而之前的
		 * 对象因为没有引用就变成了垃圾，虽然运行结果对的，但是其实是将原对象变成了垃圾[不推荐使用]
		 */
		p2 = new Person2("张天一",21);
		System.out.println(p2.getName()+"..."+p2.getAge());
		
		System.out.println("============================");
		
		Person2 p3 = new Person2();
		p3.setName("李四");
		p3.setAge(12);
		
		p3.setName("李贵");
		/**
		 * p3.setName("李贵");
		 * 这种方式不需要重新创建对象，只是重新修改了属性值，覆盖了原来的属性值
		 */
		System.out.println(p3.getName()+"..."+p3.getAge());
		
		/**
		 * 使用set方式给成员变量赋值和有参构造方法直接传入的值有什么区别？
		 * 构造方法:
		 * 	给属性进行初始化
		 * setXxx方法：
		 * 	修改属性的值
		 * 这两种方式，在开发中使用setXxx更多一些，因为比较灵活
		 */
	}
}

class Person2{
	private String name;
	private int age;
	
	public Person2(){
		
	}
	
	public Person2(String name,int age) {
		this.age = age;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}
