package com.leeup.javase.day16.bean;


//在创建对象的时候给Q赋值，
public class Tool<Q> {

	private Q q;

	public Object getObj() {
		return q;
	}

	public void setObj(Q q) {
		this.q = q;
	}
	
	//方法的泛型最好是与类的泛型一致，如果不一致，需要在方法上声明该泛型，意思就是调用方法的时候具体指定泛型方法的类型
	public<T> void show(T t) {
		System.out.println(t);
	}
	
	//静态方法随着类的加载而加载，在加载的时候可能还没创建对象呢，那么Q就没值，
	//所以静态方法必须声明自己的泛型,同，上面Tool<Q>在创建对象的时候被赋值
	//下面的W在调用静态方法的时候被赋值， 所以W就是在方法上声明一个自己的泛型
	public static<W> void print(W w) {
		System.out.println(w);
	}

}
