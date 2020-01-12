package com.leeup.javase.day07.练习;
/**
 * 员工
 * @author 李闯
 *
 */
public class Test2_Employee {

	public static void main(String[] args) {
		Employee employee = new Employee("老刘", "FG12343", 4789.0);
		employee.work();
	}
}

class Employee{
	private String name;
	private String id;
	private double salary;
	
	public Employee() {
		
	}
	
	public Employee(String name,String id,Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
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
	
	public void work() {
		System.out.println("我的姓名是："+name+"，我的工号是"+id+"，我的工资是"+salary+"，我的工作是敲代码");
	}
}
