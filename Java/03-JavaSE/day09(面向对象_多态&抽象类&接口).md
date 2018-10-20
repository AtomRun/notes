### 1. 多态&抽象类&接口
    1. 多态(polymorphic)概述
        1. 事物存在的多种形态
    2. 多态前提
        1. 要有继承关系
        2. 要有方法重写
        3. 要有父类引用指向子类对象
    3. 案例展示
```java
package com.leeup.javase.day09.多态;

public class Demo1_Polymorphic {

	public static void main(String[] args) {
		Cat cat = new Cat();	//子类引用执行子类对象，这句话可以理解为，猫是一只猫
		cat.eat();
		Animal animal = new Cat();	//父类引用执行子类对象，这句话可以理解为，猫是一只动物
		animal.eat();
	}
}


class Animal{
	public void eat() {
		System.out.println("动物吃饭");
	}
}

class Cat extends Animal {
	public void eat() {
		System.out.println("猫吃鱼");
	}	
}
```

### 2. 多态中的成员访问特点
    1. 多态中的成员访问特点
        1. 成员变量
            1. 编译看左边，运行看右边
        2. 成员方法
            1. 编译看左边，运行看右边
        3. 静态方法
            1. 编译看左边，运行看右边
            2. (静态和类相关，算不上重写，所以访问还是左边的)
        4. 只有非静态的成员方法，编译看左边，运行看右边
    2. 案例展示
        1. 多态中的成员访问特点

### 3. 超人的故事
    1. 案例分析
        1. 通过该案例帮助学生理解多态的现象

### 4. 多态向上转型和向下转型
    1. 案例展示
        1. 详细讲解多态中向上转型和向下转型
        Person p = new SuperMan(); 向上转型
        SuperMan sm = new (SuperMan)p; 向下转型