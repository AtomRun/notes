package com.leeup.javase.day13.wrapclass;

public class Demo5_Integer {

	public static void main(String[] args) {
		Integer i1 = new Integer(97);
		Integer i2 = new Integer(97);
		System.out.println(i1 == i2);		//false
		System.out.println(i1.equals(i2));	//true
		System.out.println("==========");
		
		/**
		 * Integer重写的euqals方法
		 * 包含相同int值的对象即true
		 * 
	public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return value == ((Integer)obj).intValue();
        }
        return false;
    }
		 */
		Integer i3 = new Integer(197);
		Integer i4 = new Integer(197);
		System.out.println(i3==i4);			//false
		System.out.println(i3.equals(i4));	//true
		System.out.println("==========");
		
		
		Integer i5 = 97;	
		Integer i6 = 97;
		System.out.println(i5==i6);			
		System.out.println(i5.equals(i6));	//true
		System.out.println("==========");
		
		Integer i7 = 197;
		Integer i8 = 197;
		System.out.println(i7==i8);
		System.out.println(i7.equals(i8));	//true
		
		/**
		 * -128-127是byte的取值范围，如果在这个取值范围内，自动装箱就不会新创建
		 * 对象，而是从常量池内获取，如果超过了byte取值范围就会新创建对象
		 * 
		 * 经查看下面部分的Integer源码在JDK1.8中并没有
		   asset IntegerCache.high >= 127; 这段代码
		   
		   public static Integer valueOf(int i){
		   		asset IntegerCache.high >= 127;
			   		if(i>=IntegerCache.low && i<=IntegerCache.high){	//i>=-128 && i<=127
			   			return IntegerCache.cache[i+IntegerCache.low];	//
			   		return new Integer(i);
		   		}
		   }
		 */
	}
}
