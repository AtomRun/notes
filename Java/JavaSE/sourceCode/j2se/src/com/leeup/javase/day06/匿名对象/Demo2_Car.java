package com.leeup.javase.day06.匿名对象;
/**
 * 匿名类概述以及优缺点以及使用场景1：调用方法，设置参数
 * @author 李闯
 *
 */
public class Demo2_Car {

	public static void main(String[] args) {
		Car c1 = new Car();		//创建有名字的对象
		c1.run();			
		c1.run();				//想要再调用一次，直接使用c1.run即可
		
		new Car().run();		//匿名对象调用方法
		new Car().run();		//匿名想要调用，必须重新new一次，即再在堆里创建了一个对象，比较占内存
		/**
		 * 匿名对象，只适合对方法的一次调用，因为调用多次会产生多个对象，不如用有名字的对象
		 */

		//匿名对象是否可以调用属性并赋值？有什么意义？
		
		/**
		 * 匿名对象可以调用属性，但是没有意义，因为调用完了就变成了垃圾，
		 * 如果需要赋值，还是要用有名字的对象。
		 * 
		 * 相对有名字的对象，好处就是节省代码，
		 * 但是多次调用不适合，因为匿名对象调用完了就是垃圾，就会被垃圾回收器回收，并且每次调用都会在堆内存中开辟空间放对象
		 * 
		 */
		new Car().color = "red";
		new Car().num = 8;
		new Car().run();		//输出结果为0，因为三个匿名类是三个单独的对象，首先他们的属性值不会共享，
								//然后就是，当color被赋值后，由于没有引用，立即被垃圾回收了。num也是相同，
								//run也是相同的道理，run根据new Car内存中的地址去堆中找两个属性的值，但是值都是默认
								//初始值，故为int默认基本数据类型0，和引用数据类型String的默认初始化值null
	}
}

class Car{
	
	String color;	//颜色
	int num;		//轮胎数
	
	public void run() {
		System.out.println(color+"。。。"+num);
	}
}