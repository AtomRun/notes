package com.leeup.javase.day14.otherclass;
/**
 * System类概述
 * @author 李闯
 *
 */
public class Demo3_System {

	public static void main(String[] args) {
		
//		demo1();
		
//		demo2();

//		demo3();
		
		demo4();
		
	}

	private static void demo4() {
		//应用场景：集合的底层是用数组来做的，集合的长度是可变的，
		//比如本来是十个长度的数组，这十个装满了之后，他就再创建一个1.5倍大小的数组
		//即容量为15个长度的数组，然后使用这个方法将原数组的元素拷贝到新数组中来
		int [] src = {11,22,33,44,55};
		int [] dest = new int[8];
		for (int i = 0; i < dest.length; i++) {
			System.out.println(dest[i]);
		}
		//将src的内容拷贝到dest中，使用System的方法
		System.arraycopy(src, 0, dest, 0, src.length);
		for (int i = 0; i < dest.length; i++) {
			System.out.println(dest[i]);
		}
	}

	private static void demo3() {
		long start = System.currentTimeMillis();//一秒等于1000毫秒
		for (int i = 0; i < 1000; i++) {
			System.out.println("***");
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

	private static void demo2() {
		System.exit(0);//非0状态时异常终止，退出jvm
		System.out.println("hahah");//该语句不会输出
	}

	private static void demo1() {
		//为了产生垃圾，使用循环创建多个对象，但是100个对象，垃圾回收机制仍然不会 自动清理，下面我们呼喊他过来回收
		for (int i = 0; i < 100; i++) {
			new Demo();
			System.gc();//运行垃圾回收器，相当于呼喊"保洁阿姨"，即垃圾回收器
		}
	}
}

class Demo {//一个源文件中部允许出现两个public类因为，他会抢占公共资源，

	
	//该方法不是我们手动调用的，当垃圾产生一定数量的时候，它会执行
	@Override
	protected void finalize() throws Throwable {
		System.out.println("垃圾被清扫了");
		
	}
}