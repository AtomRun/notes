package com.leeup.javase.day24.threadMethod;
/**
 * 获取名字和设置名字
 * @author 李闯
 *
 */
public class Demo1_Name {

	public static void main(String[] args) {
//		demo1();
		Thread t1 = new Thread() {
			public void run() {
//				this.setName("skrWu");
				System.out.println(this.getName()+"...aaaa");
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
//				this.setName("CanadaPaoKing");
				System.out.println(this.getName()+"...bbbb");
			}
		};
		
		t1.setName("SkrWu");
		t2.setName("Shit");
		t1.start();
		t2.start();
	}

	private static void demo1() {
		//通过构造方法给name赋值
		new Thread("芙蓉姐姐") {
			public void run() {
				System.out.println(this.getName()+"...a");
			}
		}.start();
		 
		new Thread("skrWu") {
			public void run() {
				System.out.println(this.getName()+"...b");
			}
		}.start();
	}
}
