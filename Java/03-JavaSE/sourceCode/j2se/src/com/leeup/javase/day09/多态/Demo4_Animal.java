package com.leeup.javase.day09.多态;


/**
 * 多态的优点与缺点
 * @author 李闯
 *
 */
public class Demo4_Animal {

	public static void main(String[] args) {
		Cat1 cat1 = new Cat1();
//		cat1.eat();//使用下面方法调用，复用性变化高
		method(new Cat());
		
		//想要多次创建狗，还想使用，Method方法不行
//		method(new Dog());	这样写相当于Cat cat = new Dog();猫类的引用指向狗类的对象，是不对的，
		
		method(new Dog());
		
	}
	/**
	 * 如果还需要这种方法，就还会再一个队伍写一个方法，扩展性太差
	 * 这两个方法可以修改为如下
	 * 只要是传过来的参数是Animal类型的，继承他的类都可以传进来
	 * 这就是多态的好处
	 * 
	 * 开发的时候是很少在创建对象的时候用父类的引用指向子类的对象，直接创建子类对象更方便，可以使用子类中特有的属性和行为
	 * 
	 * 在什么时候使用多态呢？在对象当作参数的时候使用多态最好，因为扩展性强
	 * 
	 * 
	 * 关键字：instanceof 判断前面的引用是否是后面的数据类型
	 * 
	 * @param dog
	 */
	public static void method(Animal1 a) {	//这样就相当于父类引用指向子类对象Animal a = new Dog()之类的
		a.eat();
	}
	
	//所以我们必须还要创建一个这样的方法
	public static void method(Dog dog) {
		dog.eat();
	}
	
	//如果想要创建多个猫，可以写个方法来替代，如下
	public static void method(Cat c) {
		c.eat();
	}
}

class Animal1{
	public void eat() {
		System.out.println("动物吃饭");
	}
}


class Cat1 extends Animal1{
	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	public void catchMouse() {
		System.out.println("抓老鼠");
	}
}

class Dog extends Animal1{
	public void eat() {
		System.out.println("狗吃肉");
	}
	
	public void lookHome() {
		System.out.println("看家");
	}
}