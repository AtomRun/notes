package com.leeup.javase.day25.简单工厂;
/**
 * 动物工厂
 * 工作就是用来创建对象
 * @author 李闯
 *
 */
public class AnimalFactory {

	/**
	 * 这种方法不太好，因为如果动物很多，就很复杂
	 * 服用性太差
	 * @return
	 */
//	public static Dog createDog() {
//		return new Dog();
//	}
//	
//	public static Cat createCat() {
//		return new Cat();
//	}
//	
	/**
	 * 改进
	 */
	public static Animal createAnimal(String name) {
		if ("dog".equals(name)) {
			return new Dog();
		}else if ("cat".equals(name)) {
			return new Cat();
		}else {
			return null;
		}
	}
}
