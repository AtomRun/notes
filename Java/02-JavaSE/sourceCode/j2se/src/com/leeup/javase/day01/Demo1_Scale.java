package com.leeup.javase.day01;
/**
   * 进制
 * @author 李闯
 *
 */
public class Demo1_Scale {
	/**
	    1. 输出不同进制表现100的数据
        2. 0b100
        3. 0100
        4. 100
        5. 0x100
	 */
	public static void main(String[] args) {
		System.out.println(0b100);  //4         二进制表示形式前面加0b(b可大写可小写)
		System.out.println(0100);   //64      八进制表示形式前面加0
		System.out.println(100);    //100
		System.out.println(0x100);  //256   十六进制表示形式前面加0x(x可大写可小写)
	}
}
