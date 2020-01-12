package com.leeup.javase.day27.bean;

public class Person {

	private int age;
	private String name;
	public Person() {
		super();
	}
	public Person(String name,int age) {
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())		//判断调用对象和传入对象的字节码文件是否是同一个
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public void eat() {
		System.out.println("今天吃了一顿金钱豹");
	}
	
	public void eat(int num) {
		System.out.println("今天吃了"+num+"顿金钱豹");
	}
}

