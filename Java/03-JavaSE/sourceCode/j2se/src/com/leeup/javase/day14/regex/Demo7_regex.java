package com.leeup.javase.day14.regex;
/**
 * 正则表达式的分组功能 
 * @author 李闯
 *
 */
public class Demo7_regex {

	public static void main(String[] args) {
//		demo1();
		
//		demo2();
		
		/**
		   2. 替换
		    需求：我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程
		    将字符串还原成:“我要学编程”。
		 */
		String s = "我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程";
		String s2 = s.replaceAll("\\.+", "");
		String s3 = s2.replaceAll("(.)\\1+", "$1");//$1获取到第一组的数据，把整个这串替换掉
		System.out.println(s3);
	}

	private static void demo2() {
		//需求：按照切割：sdqqfgkkkhjppppkl
		String s = "sdqqfgkkkhjppppkl";
		String regex = "(.)\\1+";				//+号代表第一组出现一次到多次
		String [] arr = s.split(regex);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void demo1() {
		//叠词正则，比如：快快乐乐，高高兴兴
		
		String regex = "(.)\\1(.)\\2";		//\\1代表第一组又出现了一次,\\2代表第二组再出现一次
		System.out.println("快快乐乐".matches(regex));
		System.out.println("快乐乐乐".matches(regex));
		
		//叠词 死啦死啦，高兴高兴
		
		String regex2 = "(..)\\1";
		System.out.println("高兴高兴".matches(regex2));
		System.out.println("快快乐乐".matches(regex2));
	}
}
