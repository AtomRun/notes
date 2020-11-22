package com.leeup.javase.day19.test;
/**
 * finally关键字的面试题[其实有点像雷锋和雷锋塔的区别]
 *  1. 面试题1
        * final,finally和finalize的区别
        	final
	        	final可以修饰类，修饰的类不能被继承
	        	final可以修饰方法，修饰的方法不能被重写
	        	final可以修饰变量，修饰的变量只能被赋值一次
        	finally
        		是try语句中的一个语句体，不能单独使用，用来释放资源
        	finalize
        		是一个方法
        		当垃圾回收器确定不存在该对象更多的引用的时候，由对象的垃圾回收器调用此方法
    2. 面试题2
        * 如果catch里面有return语句，请问finally的代码还会执行吗?如果会，请问是在return前还是return后。
        	会执行
        	return前
        		return先去执行，建立一个返回路径，再去执行finally，最后return再彻底返回，finally执行完毕，再彻底返回
 * @author 李闯
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Demo demo = new Demo();
		int x = demo.method();
		/**
		 * 结果为30为什么不是40呢？不是说在return之前会查看finally中是否有语句然后执行嘛
		 * 当int x = 10;后就走到了try中，然后x = 20;然后就执行1/0就出异常了。
		 * 就跳到catch中了，catch中x=30;现在x=30了。然后return x;建立了一个返回路径，将30装到了返回路径的箱子中
		 * 然后再看自己有finally语句没有，有就执行，虽然finally中将将x的值改了，但是返回路径中的值并没有改
		 */
		System.out.println(x);
	}
}

class Demo {
	public int method () {
		int x = 10;
		try {
			x =20;
			System.out.println(1/0);
			return x;
		} catch (Exception e) {
			x = 30;
			return x;
		} finally {
			x = 40;
//			return x;				不要再finally中写return语句，因为finaly的作用，是为了释放资源，是肯定会执行的
									//如果在这里面写了返回语句，那么try和catch的结果都会改变，所以这么写就是犯罪啊
		}
	}
}