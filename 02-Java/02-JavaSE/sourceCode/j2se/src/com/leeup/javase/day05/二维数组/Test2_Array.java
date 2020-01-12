package com.leeup.javase.day05.二维数组;
/**
 *     1. 案例展示
        1. 需求:公司年销售额求和
        2. 某公司按照季度和月份统计的数据如下：单位(万元)
        3. 第一季度：22,66,44
        4. 第二季度：77,33,88
        5. 第三季度：25,45,65
        6. 第四季度：11,66,99
 * @author 李闯
 *
 */
public class Test2_Array {

	public static void main(String[] args) {
		int[] [] arr = {{22,66,44},{77,33,88},{25,45,65},{11,66,99}};
		 
		int sum = 0;//定义变量记录每次相加的结果
		
		for (int i = 0; i < arr.length; i++) {	//获取每个一维数组
			for (int j = 0; j < arr[i].length; j++) {	//获取每个一维数组的元素
				sum += arr[i][j];				//累加
			}
		}
		System.out.println(sum);
	}
}
