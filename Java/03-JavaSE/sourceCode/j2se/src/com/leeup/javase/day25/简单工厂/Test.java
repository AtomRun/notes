package com.leeup.javase.day25.简单工厂;
/**
 * 测试类
 * @author 李闯
 *
 */
public class Test {

	public static void main(String[] args) {
//		Dog d = AnimalFactory.createDog();
//		System.out.println(d);
		
		/**
		 * 返回的是Animal我们使用Dog接收，我们需要对其进行强制转换
		 */
		Dog dog = (Dog) AnimalFactory.createAnimal("dog");
		dog.eat();
		
		Cat cat = (Cat) AnimalFactory.createAnimal("cat");
		cat.eat();
		//但是如果有其他的类，例如鸟类，传进来，不匹配的话就返回null,就会出现空指针异常，
		//好处就是：客户端不需要负责对象创建，从而明确各个类的职责，
		//坏处就是：静态工厂负责所有对象的创建，如果有新对象的增加，或者某些对象创建方式不同，就需要不断地修改和维护
	}
}
