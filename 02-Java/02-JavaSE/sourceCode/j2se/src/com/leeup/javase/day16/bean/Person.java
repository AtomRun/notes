package com.leeup.javase.day16.bean;

public class Person implements Comparable<Person>{

	private int age;
	private String name;
	public Person() {
	}
	public Person(String name,int age ) {
		this.age = age;
		this.name = name;
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
	@Override
	public boolean equals(Object obj) {
		Person person = (Person)obj;
		return this.name.equals(person.name)&&this.age == person.age;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" +  +age +"]";
	}
	
	//按照姓名长度排序
	@Override
	public int compareTo(Person o) {
		int length = this.name.length() - o.name.length();		//比较长度为主要条件
		int num = length==0?this.name.compareTo(o.name):length;//比比较内容为次要条件
		return num == 0 ? this.age-o.age:num;					//比较年龄为次要条件
	}
	
//	//按照姓名排序
//	@Override
//	public int compareTo(Person o) {
//		//将姓名作为主要条件,年龄是次要条件
//		int num = this.name.compareTo(o.name);
//		return num==0?this.age-o.age:num;
//	}
	

	//按照年龄排序
//	@Override
//	public int compareTo(Person o) {
//		
//		int num = this.age - o.age;
//		return num==0?this.name.compareTo(o.name):num;//年龄是主要条件，this.name.compareTo(o.name) 名字一样也会返回0
//	}
}
