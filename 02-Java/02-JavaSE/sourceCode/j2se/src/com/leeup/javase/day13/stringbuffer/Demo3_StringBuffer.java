package com.leeup.javase.day13.stringbuffer;
/**
 * StringBuffer的删除功能
 * @author 李闯
 *
 */
public class Demo3_StringBuffer {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
//		sb.deleteCharAt(5);//如果指定的索引在缓冲区中不存在，也会报字符串。索引越界异常，
		sb.append("zhongguo");
		
//		sb.deleteCharAt(5);//根据索引删除索引位置上对应的字符
//		sb.delete(0,2);		//删除的时候包含头，不包含尾
//		System.out.println(sb);
		
		sb.delete(0, sb.length());//清空缓冲区
		
		System.out.println(sb);
		
		sb = new StringBuffer();	//不要使用这种方式清空缓冲区，原来的会变成垃圾
		
	}
}
