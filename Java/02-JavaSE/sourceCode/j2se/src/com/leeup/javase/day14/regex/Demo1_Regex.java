package com.leeup.javase.day14.regex;


/**
1. 需求：校验qq号码.
    1. :要求必须是5-15位数字
    2. :0不能开头
    3. :必须都是数字
    
    校验QQ：
    1. 明确返回值类型boolean
    2. 明确参数列表String qq
    
2. 非正则表达式实现
3. 正则表达式实现
 * @author 李闯
 *
 */
public class Demo1_Regex {

	public static void main(String[] args) {
		
//		System.out.println(check("012135432"));
//		System.out.println(check("a12135432"));
//		System.out.println(check("12135432"));
//		System.out.println(check("1213541231231232"));
		
		String regex = "[1-9]\\d{4,14}";
		System.out.println("12312312".matches(regex));
	}
	
	public static boolean check(String qq) {
		
		boolean flag = true;	//定义标记，如果校验QQ不符合要求，就把flag置为false，符合的话直接返回
		if (qq.length()>=5 && qq.length()<=15) {
			//符合长度要求
			if (!qq.startsWith("0")) {
				//不是以0开头，即符合要求
				char [] arr = qq.toCharArray();		  //将字符串转为字符数组遍历其中的每个字符查看是否都是数字
				for (int i = 0; i < arr.length; i++) {
					char ch = arr[i];				//记录每个字符
					if (!(ch>='0' && ch<= '9')) {
						System.out.println("您的QQ号中含有字母");
						flag =false;
						break;
						//不在0-9范围内，即不是数字
					}
				}
			}else {
				flag = false;
				System.out.println("您的QQ以0开头，不符合QQ标准");
			}
		}else {
			flag = false;
			System.out.println("您的QQ号长度不符合要求");
		}
		
		return flag;
	}
}
