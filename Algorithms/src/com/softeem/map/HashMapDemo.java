/**
 * 
 */
package com.softeem.map;

import java.util.HashMap;
import java.util.Set;

/**
 * @author XiongYan
 *
 * 2018年2月10日
 */

//HashMap嵌套HashMap
public class HashMapDemo {
	/**信息管理与信息系统专业：
	 *     xy   信管一班：
	 *               雪儿     22
	 *               熊焱     24
	 *     xe   信管二班：
	 *               宋仲基   35
	 *               宋慧乔   37
	 *   先存储元素，再取出元素
	 *               
	 * */
	public static void main(String[] args) {
		 HashMap<String, HashMap<String, Integer>> hashmap = new HashMap<String, HashMap<String, Integer>>();
		 HashMap<String, Integer> hashmap1 = new HashMap<String,Integer>();
		 HashMap<String, Integer> hashmap2 = new HashMap<String,Integer>();
		 hashmap1.put("雪儿", 22);
		 hashmap1.put("熊焱", 24);
		 hashmap.put("信管一班", hashmap1);
		 hashmap2.put("宋仲基", 35);
		 hashmap2.put("宋慧乔", 37);
		 hashmap.put("信管二班", hashmap2);
		 Set<String> set1 = hashmap.keySet();
		 for (String str : set1) {
			   HashMap<String, Integer> value = hashmap.get(str);
			   Set<String> set2 = value.keySet();
			   for(String str2:set2) {
				   System.out.println(value.get(str2)+"-----"+str2);
			   }
		}
	}
	 
	 
}
