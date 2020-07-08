package com.leeup.javase.day09.抽象类;

public class Test3_Employee {

	public static void main(String[] args) {
		Coder coder = new Coder("张小龙","007",8000);
		coder.work();
		
		Manager manager = new Manager("雷军","9527",50000,2000);
		manager.work();
	}
}

abstract class Employee {
	private String name;
	private String id;
	private double salary;
	
	public Employee() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String name, String id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public abstract void work(); 
}

class Coder extends Employee {
	
	public Coder() {
	}
	
	public Coder(String name, String id, double salary) {
		super(name, id, salary);
	}

	@Override
	public void work() {
		System.out.println("我的姓名是"+this.getName()+"，我的工号是"+this.getId()+
				"，我的工资是"+this.getSalary()+"，我的工作是敲代码");
		
	}
	
}

class Manager extends Employee {
	
	private int bouns;//奖金
	
	public Manager() {
	}
	
	public Manager(String name, String id, double salary,int bonus) {
		super(name, id, salary);
		this.bouns = bonus;
	}
	
	@Override
	public void work() {
		System.out.println("我的姓名是"+this.getName()+"，我的工号是"+this.getId()+
				"，我的工资是"+this.getSalary()+"我的奖金是"+bouns+"，我的工作是管理");
		
	}
}