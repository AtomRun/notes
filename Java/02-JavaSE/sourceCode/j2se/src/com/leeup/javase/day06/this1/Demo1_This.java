package com.leeup.javase.day06.this1;
/**
 * this关键字
 * @author 李闯
 *
 */
public class Demo1_This {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("张三");
		p1.setAge(23);
		System.out.println(p1.getName()+"..."+p1.getAge());
		
		Person p2 = new Person();
		p2.setName("李四");
		p2.setAge(24);
		/**
		 * 当创建p1对象时，this代表的是p1对象
		 * 当创建p2对象时，this代表的是p2对象
		 * 
		 * 即谁来调用this，this就是代表哪个对象，也是用来区分当局部变量和成员变量重名时的问题
		 */
		
		System.out.println(p2.getName()+"..."+p2.getAge());
	}
}

class Person{
	private String name;	//姓名
	private int age;		//年龄
	
	//设置年龄
	public void setAge(int age) {
		if (age > 0 && age < 200) {
//			age = age;		//若是写成这样age = age 其实就是局部变量重新给自己赋值了一次。并不会改变成员变量的值
			this.age = age;	//this关键字里记录的其实就是当前对象在内存堆中的地址值，这里this.age 其实就是main方法中new的p1.age
		}else {
			System.out.println("您输入的年龄不正确！");
		}
	}
	
	//获取年龄，年龄是int的，所以返回值为int
	public int getAge() {
		return age;
	}
	
	//设置姓名
	public void setName(String name) {
//		name = name;		//当这样写的时候，输出的结果为 null,0,因为方法有就近原则，当我们形式参数为name赋值给name的时候，
							//就近原则这里就是name形式参数，再给局部变量重新赋值了一次，所以，成员变量的值没有改变
		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
