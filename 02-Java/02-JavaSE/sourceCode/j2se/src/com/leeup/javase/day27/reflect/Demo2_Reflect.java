package com.leeup.javase.day27.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 榨汁机(Juicer)榨汁的案例
    2. 分别由水果(Fruit)苹果(Appale)香蕉(Banana)桔子(Orange)榨汁(squeeze)
 * @author 李闯
 *
 */
public class Demo2_Reflect {

	public static void main(String[] args) throws Exception {
		
		//没有用反射，使用了多态
//		Juicer juicer = new Juicer();				//购买榨汁机
//		juicer.run(new Appale());					//向榨汁机中放入苹果
//		juicer.run(new Orange());
		
		//使用反射和配置文件
		BufferedReader br = new BufferedReader(new FileReader("config.prop"));//使用buffredReader可以读整行
		Class clazz = Class.forName(br.readLine());
		Fruit f = (Fruit) clazz.newInstance();	//父类引用指向子类对象  水果的引用指向了苹果对象
		Juicer juicer = new Juicer();
		juicer.run(f);
		
	}
}

interface Fruit {
	public void squeeze();
}

class Appale implements Fruit{
	public void squeeze() {
		System.out.println("榨出一杯苹果汁");
	}
}

class Juicer {
//	public void run(Appale appale) {
//		appale.squeeze();
//	}
//	public void run(Orange orange) {
//		orange.squeeze();
//	}
	
	//改进后代码如下
	public void run(Fruit f) {
		f.squeeze();
	}
}

class Orange  implements Fruit{
	public void squeeze() {
		System.out.println("榨出一杯橘子汁");
	}
}