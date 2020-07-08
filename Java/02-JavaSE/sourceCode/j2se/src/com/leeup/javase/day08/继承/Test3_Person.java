package com.leeup.javase.day08.继承;
/**
 * 使用继承前的学生和老师案例
 * @author 李闯
 *
 */
public class Test3_Person {

	public static void main(String[] args) {
		
	}
}

class Student{
	private String name;
	private int age;
	
	public Student() {}
	
	public Student(String name,int age) {
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
	
	public void eat() {
		System.out.println("学生吃饭");
	}
	public void study() {
		System.out.println("学生学习");
	}
}

class Teacher{
		private String name;
		private int age;
		
		public Teacher() {}
		
		public Teacher(String name,int age) {
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
		
		public void eat() {
			System.out.println("老师吃饭");
		}
		public void teach() {
			System.out.println("老师讲课");
		}
}