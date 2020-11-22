package com.leeup.javase.day11.object;

import com.leeup.javase.day11.test.Student;

/**
 * euqals方法，比较两个对象是否相等
 * @author 李闯
 *
 */
public class Demo4_Equals {

	public static void main(String[] args) {
		Student s1 = new Student("张三",23);
		Student s2 = new Student("张三",23);
		
		boolean b = s1.equals(s2);
		/**
		 *     public boolean equals(Object obj) {
         *			return (this == obj);
    	 *		}
    	 * 即调用的的对象和传入的对象进行比较，s1调用的时候就是将地址值传给了this,s2传进来的时候j即将地址值
    	 * 赋值给了obj,所以就是s1与s2比较
		 * 结果是false因为euqals比较的是地址值
		 * 
		 * Object中的equals方法是比较对象地址值的，没有什么意义，我们需要重写他
		 * 因为在开发中我们通常比较的是对象的属性值，我们认为相同属性是同一个对象，这样我们就需要重写equals方法
		 * 我们在Student类中重写euqals方法
		 */
		System.out.println(b);
		
		
		//根据地址值判断两个对象是否相等，不相等
		System.out.println(s1 == s2);
		
		//重写equals之后比较的是对象中的属性值
		
	}


}
