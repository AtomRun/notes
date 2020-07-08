package com.leeup.javase.day25.适配器;
/**
 * 适配器模式
 * @author 李闯
 *
 */
public class Demo1_Adapter {

}

interface 和尚 {
	public void 打坐();
	public void 念经();
	public void 撞钟();
	public void 习武();
}

abstract class 天罡星 implements 和尚 {		//声明成抽象的原因是，不想让其他类创建本类对象，因为创建也没有意义，方法都是空的

	@Override
	public void 打坐() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 念经() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 撞钟() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 习武() {
		// TODO Auto-generated method stub
		
	}
}

class 鲁智深 extends 天罡星 {
	public void 习武() {
		System.out.println("倒拔垂杨柳");
		System.out.println("拳打镇关西");
		System.out.println("大闹野猪林");
		System.out.println(".......");
	}
}