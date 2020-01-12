package com.leeup.javase.day13.test;


/**
 * 将数组中的数据按照指定格式拼接成一个字符串
 * @author 李闯
 *
 *相较于使用String做这道题，就是，使用String会产生垃圾，
 *因为例如String s = "xxx";
 *每次对s进行赋值，之前的s就会变成垃圾而使用StringBuffer只创建一个对象，对一个对象进行操作
 */
public class Test1 {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
		System.out.println(arrayToString(arr));
		
	}
	
	/**
	 * 将数组转换为字符串
	 * 1. 返回值类型 Stringg
	 * 2.参数列表int[] 
	 * 
	 * arrayToString 将数组转换为字符串
	 * array2String 2与to发音yi'yang就用2替换了to,后来就变成了一种书写习惯
	 * 
	 */
	public static String arrayToString(int[] arr) {
		
		//1. 创建StringBuffer缓冲区
		StringBuffer sb = new StringBuffer();	
		sb.append("[");//先将左[添加到缓冲区
		
		//遍历数组
		for (int i = 0; i < arr.length; i++) {
//			sb.append(arr[i]+",");//这样做没有右中括号，采用if判断方式改进
			if (i==arr.length -1) {
				sb.append(arr[i]).append("]");
			}else {
				sb.append(arr[i]).append(",");
			}
		}
		
		return sb.toString();
	}
}
