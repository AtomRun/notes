package com.leeup.javase.day13.wrapclass;
/**
 * 包装类
  byte    Byte
  short   Short
  int     Integer
  long    Long
  float   Float
  double  Double
  char    Character
  boolean Boolean
 * @author 李闯
 *
 */
public class Demo1_Integer {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(60));//转换成2进制
		System.out.println(Integer.toOctalString(60));
		System.out.println(Integer.toHexString(60));
		
		
	}
}
