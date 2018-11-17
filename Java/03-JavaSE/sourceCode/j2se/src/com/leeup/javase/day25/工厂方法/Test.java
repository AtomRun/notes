package com.leeup.javase.day25.工厂方法;

public class Test {

	public static void main(String[] args) {
		CatFacory catFacory = new CatFacory();
		DogFactory dogFactory = new DogFactory();
		
		Cat cat = (Cat) catFacory.createAnimal();
		cat.eat();
		Dog dog = (Dog) dogFactory.createAnimal();
		dog.eat();
	}
}
