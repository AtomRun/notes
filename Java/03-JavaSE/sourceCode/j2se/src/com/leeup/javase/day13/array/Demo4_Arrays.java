package com.leeup.javase.day13.array;

import java.util.Arrays;

/**
	public static String toString(int[] a)
	public static void sort(int[] a)
	public static int binarySearch(int[] a,int key)
 * @author 李闯
 *
 */
public class Demo4_Arrays {

	public static void main(String[] args) {
		int[] arr = {33,22,11,44,66,55};
		
		//转换成字符串
		System.out.println(Arrays.toString(arr));
		
		//数组排序
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		//二分查找
		int[] arr2 = {11,22,33,44,55,66};
		System.out.println(Arrays.binarySearch(arr2, 22));
		System.out.println(Arrays.binarySearch(arr2, 66));
		System.out.println(Arrays.binarySearch(arr2, 88));//负的插入点-1，为什么是负的插入点呢？因为如果第一位0，则无法判断
		
		/**
		 * Arrays的
		 * toString源码
		 * 
		public static String toString(long[] a) {
        if (a == null)								//如果传入的数组为null
            return "null";							//就返回null
        int iMax = a.length - 1;					//iMax最大索引
        if (iMax == -1)								//如果iMax==-1即length=0,即数组中没有元素
            return "[]";							//返回[]

        StringBuilder b = new StringBuilder();		//StringBuilder线程不安全的，效率高，目前我们都是单线程的
        b.append('[');								//将[添加到字符串缓冲区
        for (int i = 0; ; i++) {					//遍历数组，没有写循环判断语句默认就是true
            b.append(a[i]);							//把第一个元素添加进字符串缓冲区
            if (i == iMax)							//如果i等于最大索引值，即到了 最后一个元素了
                return b.append(']').toString();	//直接返回return方法弹栈结束，，添加]符号添加到字符串缓冲区并且toString转换为字符串
            b.append(", ");							//如果不等于最大索引就将 , 添加到缓冲区
        }
    }
		 */
		
	/**
	 * 
	 * Arrays的
	 * binarySearch0源码
	 * 
	 * private static int binarySearch0(long[] a, int fromIndex, int toIndex,
                                     long key) {
        int low = fromIndex;				//最小索引0
        int high = toIndex - 1;				//最大索引，数组长度-1

        while (low <= high) {				//如果最小索引<= 最大索引，就可以开始循环判断了
            int mid = (low + high) >>> 1;	//求处中间索引值，(最小+最大)/2,向右移动一位就是除以2的1次幂
            long midVal = a[mid];			//通过中间索引获取中间值

            if (midVal < key)				//中间索引对应的值小于查找的值
                low = mid + 1;				//最小索引变化
            else if (midVal > key)			//中间索引对应的值大于查找的值
                high = mid - 1;				//最大索引变化
            else							//即不大也不小
                return mid; // key found	//找到了
        }
        return -(low + 1);  // key not found.//负的插入点减一
    }
	 */
	}
}
