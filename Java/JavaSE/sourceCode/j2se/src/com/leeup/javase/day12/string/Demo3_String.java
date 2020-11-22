package com.leeup.javase.day12.string;


public class Demo3_String {

	public static void main(String[] args) {
		
		//1.
		demo1();	

		
		//2. 
		demo2();
		
		//3. 
		demo3();
		
		//4. 
		demo4();
		
		String s1 = "ab";
	    String s2 = "abc";
	    String s3 = s1 + "c";
	    System.out.println(s3 == s2);
	    System.out.println(s3.equals(s2));
	    /**
	     * 任何数据与字符串用+相连接都会产生新的字符串，字符串串联底层是使用
	     * StringBuilder或者StringBuffer类及append方法实现的，是我们字符串的缓冲区
	     * 即a字符串+1,他会先创建一个StringBuilder对象然后将1转成字符串，放到缓冲区中
	     * 转成字符串，之后使用toString方法再将字符串转换回来就变成了a1，
	     * 
	     * 执行步骤：
	     * 主方法进栈，
	     * String s1 = "ab"; 需要在常量池中创建一个"ab",将地址值赋值给s1
	     * String s2 = "abc"; 需要在常量池中创建一个"abc",将地址值赋值给s2
	     * String s3 = s1 + "c"; 这里属于字符串使用加号和其他数据串联，
	     * 这时候需要在堆中创建一个StringBuffer或者StringBuilder对象。通过append
	     * 方法将ab和c加到一起，但是这个StringBuffer对象也是有地址值的，但是将StringBuffer
	     * 的地址值赋值给s3显然不太合理，所以，调用toString方法，将其重新转成String字符串
	     * toString也是有地址值的，并且将其赋值给s3，
	     * 这个时候s3的地址是堆内存的，s1,s2是常量池的，相比较肯定是false
	     */

	}

	private static void demo4() {
        /**
         * s1==s2 true 
         * 因为在java中有常量优化机制，
         * 例如byte b = 3 + 4; 在编译的时候就已经变成7了，判断7在java的取值范围之内，即编译器帮我们做了这些事
         * 所以a、b、c字符串本身都是字符串常量，在编译的时候本身就是字符串常量
         * 即s2拿abc已经存在了所以两者地址值相同为true
         */
		String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2);		
        System.out.println(s1.equals(s2));
	}

	private static void demo3() {
        /**
         * ==比较的是地址值，而s1得地址值是堆内存的地址值，
         * 而s2得地址值是常量池的地址值所以s1==s2为false
         * s1.equals(s2);s1的值和s2的值相等，为true
         */
		String s1 = new String("abc");			
        String s2 = "abc";
        System.out.println(s1 == s2);		
        System.out.println(s1.equals(s2));
	}

	private static void demo2() {
		/**
		 * 执行步骤：
		 * 主方法进栈，
		 * new String("abc");他也会去常量池中查看是否有abc，
		 * 没有就在常量池中创建一个对象存放"abc"并且也拥有一个地址值
		 * 但是这里是有new关键字的，所以在堆中也创建了一个对象并且有自己的地址值，这个时候常量池
		 * 中的abc拷贝了一份副本赋值给了堆中的对象，堆内存中的对象就将地址值赋值给s1 
		 * 在这里常量池中的abc相当于参数，而堆中的abc相当于常量池中的副本
		 */
		String s1 = new String("abc");
	}

	private static void demo1() {
		/**
		 * 执行步骤：
		 * 主方法进栈， "abc" 会进入常量池，常量池中如果没有abc的话， 他会创建一个，如果
		 * 池子中有，他就不创建了，第一次的String s1 = "abc";他发现没有。就在常量池中
		 * 创建了一个并且将地址值赋值给s1，s1通过地址值找到"abc"
		 * String s2 = "abc";也会去常量池里看一下，如果有的话就不创建了，没有就创建
		 * 他发现有的时候，就将地址值赋值给s2，这样的话，就是了两个引用指向同一个对象，记录的是同一个
		 * 地址值。所以s1==s2为true
		 */
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}
