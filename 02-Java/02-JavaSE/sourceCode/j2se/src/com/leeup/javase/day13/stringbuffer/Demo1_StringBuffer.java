package com.leeup.javase.day13.stringbuffer;
/**
   1. StringBuffer的构造方法
    1. public StringBuffer(); 无参构造方法
    2. public StringBuffer(int capacity); 指定容量的字符串缓冲区对象
    3. public StringBuffer(String str); 指定字符串内容的字符串缓冲区对象
2. StringBuffer的方法
    1. public int capacity(); 返回当前容量。理论值，
    2. public int length(); 返回长度(字符数)。 实际值
 * @author 李闯
 *
 */
public class Demo1_StringBuffer {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.length());//长度为0，因为sb中没有任何元素，这个length代表的是容器中的字符个数[实际值]
		System.out.println(sb.capacity());//结果16，是StringBuffer的初始容量[理论值]，容器大小
		
		StringBuffer sb2 = new StringBuffer(10);
		System.out.println(sb2.length());
		System.out.println(sb2.capacity());//结果为10，即为我们定义的大小
		
		StringBuffer sb3 = new StringBuffer("zhongguo");
		System.out.println(sb3.length());	// 结果为8，即存入的字符串元素长度
		System.out.println(sb3.capacity());	//结果为24，其实是字符串的length加上初始容量的大小
		//即不占用初始容量的大小，还对初始容量进行扩充
		
	}
}
