package com.leeup.javase.day17.bean;

public class Person {

	private String name;
	private int age;
	public Person() {
	}
	public Person(String name, int age) {
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
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		System.out.println("执行了吗");
		return "Person [name=" + name + ", age=" + age + "]";
	}
//	@Override
//	public boolean equals(Object obj) {
//		Person person = (Person)obj;
//		return this.name == person.name && this.age == person.age;
//	}
//	//重写了hashCode保证了元素唯一了。 并且equals方法也跟着执行了
//	@Override
//	public int hashCode() {
//		final int NUM = 38;
//		return name.hashCode() + age + NUM;
//	}
	
	/**
	 * 为什么是31呢？
	 * 1. 31是一个质数，即能被1和自己本身整除的数，这样的话它的公约数就少了，公约数少了就可以降低重复性
	 * 2. 31这个数既不大也不小 
	 * 3. 31这个数好算，2的5次方-1，2向左移动5位
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)				//this是调用对象，obj是传入对象，如果他们相等说明了两个引用指向同一个对象即自己跟自己比，
			return true;				//直接返回true即可
		if (obj == null)				//传入对象为null，,调用对象肯定不为null，因为调用对象如果为null调用equals方法就会出现空指针了。
			return false;				//直接返回false
		if (getClass() != obj.getClass())//getClass返回对应的字节码对象，比如这里this，classs即Person.class。obj.class传入对象的字节码文件
										//判断两个对象的字节码文件是否是同一个字节码，
			return false;				//如果不是同一个直接返回false
										//走到这里说明，传入的对象肯定是Person对象，肯定是有值的，并且还是同一个字节码文件
		Person other = (Person) obj;	//向下转型 
		if (age != other.age)			//调用对象的年龄不等于传入对象的年龄
			return false;				//返回false
		if (name == null) {				//调用对象的姓名为null
			if (other.name != null)		//传入对象的姓名不为null
				return false;			//返回false
		} else if (!name.equals(other.name))//调用对象姓名不等于传入对象姓名
			return false;				//返回false
		return true;					//返回true
	}
	
	
}
