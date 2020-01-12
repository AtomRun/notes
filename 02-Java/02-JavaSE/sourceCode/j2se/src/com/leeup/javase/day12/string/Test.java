package com.leeup.javase.day12.string;


public class Test {

	public static void main(String[] args) {
		new Son().print();
	}
}


class Parent {
	private String value = "parent";
	
	void print() {
		System.out.println(this.value);
	}	
	
}

class Son extends Parent {
	private String value = "son";
	
}