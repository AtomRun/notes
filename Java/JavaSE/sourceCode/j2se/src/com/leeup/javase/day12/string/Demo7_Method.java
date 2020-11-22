package com.leeup.javase.day12.string;
/**
1. String的替换功能及案例演示
	1. String replace(char old,char new)
	2. String replace(String old,String new)
2. String的去除字符串两空格及案例演示
	1. String trim()
3. String的按字典顺序比较两个字符串及案例演示
	1. int compareTo(String str)(暂时不用掌握)
	2. int compareToIgnoreCase(String str)(了解)
 * @author 李闯
 *
 */
public class Demo7_Method {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
//		demo3();
		
		String s1 = "heima";
		String s2 = "HEIMA";
		int num = s1.compareTo(s2);
		System.out.println(num);
	
		int num2 = s1.compareToIgnoreCase(s2);//不区分大小写
		System.out.println(num2);
		/**
		 *         public int compare(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    c1 = Character.toUpperCase(c1);		//将c1字符转成大写
                    c2 = Character.toUpperCase(c2);		//将c2字符转成大写
                    if (c1 != c2) {
                        c1 = Character.toLowerCase(c1);	//将c1字符转成小写
                        c2 = Character.toLowerCase(c2); //将c2字符转成小写
                        if (c1 != c2) {
                            // No overflow because of numeric promotion
                            return c1 - c2;
                        }
                    }
                }
            }
            return n1 - n2;
        }
		 */
		
	}

	private static void demo3() {
		String s1 = "abc";
		String s2 = "bcd";
		
		int num = s1.compareTo(s2);
		System.out.println(num);//输出结果-1 。a值97，b值98，97-98结果-1。如果字符串第一个字符相等，就依次比较后面的
		
		String s3 = "a";
		String s4 = "aaaa";
		int num2 = s3.compareTo(s4);
		System.out.println(num2);//输出杰结果-3，当字符都相等时，按照长度比较
	}

	private static void demo2() {
		String s1 = "   zhong   guo   ";
		String s2 = s1.trim();
		System.out.println(s2);
	}

	private static void demo1() {
		String s1 = "zhongguo";//想把z改成c
		String s2 = s1.replace('z','c');//如果第一个参数在s1字符串中没有的话，输出的结果还是原本的结果
		System.out.println(s2);
		
		String s3 = s1.replace("on", "uo");
		System.out.println(s3);
	}
}
