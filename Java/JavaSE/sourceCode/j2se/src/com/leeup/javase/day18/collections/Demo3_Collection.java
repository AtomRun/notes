package com.leeup.javase.day18.collections;
/**
 * Collection
 * 		List(存取有序，有索引，可以重复)
 * 			ArrayList
 * 				底层是数组实现的，线程不安全的，查询和修改快，增加删除慢
 * 			LinkedList
 * 				底层是链表实现的，线程不安全的，增加和删除比较快，查找和修改比较慢
 * 			Vector
 * 				底层是数组实现的，线程安全的，无论增删改查都慢
 * 			如果查找和修改多，使用ArrayList
 * 			如果增加和删除多，使用LinkedList
 * 			如果都多，使用ArrayList
 * 		Set(存取无序，无索引，不可以重复)
 * 			HashSet
 * 				底层是Hash算法实现的
 * 				LinkedHashSet
 * 					底层是链表实现的，但是也可以保证元素唯一和HashSet原理一样
 * 			TreeSet
 * 				底层是二叉树算法实现
 * 			一般在开发的时候不需要对存储的元素排序，所以在开发的时候，大多用HashSet,HashSet的效率比较高
 * 			TreeSet在面试的时候比较多，比如问有几种排序方式，和几种排序方式的区别
 * 		Map()
 * 			HashMap
 * 				底层针对键来说是Hash算法
 * 				LinkedHashMap
 * 					底层是链表，也是针对键
 * 			TreeMap
 * 				底层是二叉树算法，针对键
 * 			开发中用HashMao比较多，
 * 			单列集合如果存储的是重复的元素，优先考虑ArrayList，如果不需要重复的元素，优先考虑HashSet.
 * 			双列集合优先考虑HashMap,付费需要对键进行排序。在考虑TreeMap
 * 				
 * @author 李闯
 *
 */
public class Demo3_Collection {

	public static void main(String[] args) {
		
	}
}
