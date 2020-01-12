package com.leeup.javase.day14.otherclass;

public class Demo1_Math {

	public static void main(String[] args) {
		 System.out.println(Math.PI);		//Π
		 System.out.println(Math.abs(-345));//取绝对值
		 //ceil 天花板的意思， 向上取整
		 System.out.println(Math.ceil(12.3));//结果是double数
		 System.out.println(Math.ceil(12.99));
		 
		 //floor 地板，向下取整
		 System.out.println(Math.floor(12.3));//结果是double数
		 System.out.println(Math.floor(12.99));
		 
		 //获取两个值中的最大值
		 System.out.println(Math.max(12, 13));
		 
		 //前面的是底数，后面的数是底数
		 System.out.println(Math.pow(2, 3));//  2.0^3.0
		 
		 //生成0.0到1.0之间的随即小数，包括0.0.不包括1.0
		 System.out.println(Math.random());
		 
		 //四舍五入
		 System.out.println(Math.round(12.3f));
		 System.out.println(Math.round(12.9f));
		 
		 //根号2，根号4
		 System.out.println(Math.sqrt(4));
		 System.out.println(Math.sqrt(2));
	}
}
