package com.leeup.javase.day25.工厂方法;

public class CatFacory implements Factory{

	@Override
	public Animal createAnimal() {
		return new Cat();
	}
}
