/**
 * 
 */
package com.softeem.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author XiongYan
 *
 * 2018年2月10日
 */
public class arrayListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ArrayList嵌套:HashMap嵌套ArrayList:
		/**
		 * 	三国演义：
		 *         曹操
		 *         刘备
		 *         孙权
		 *  笑傲江湖：
		 *        令狐冲
		 *        任盈盈
		 *  神雕侠侣：
		 *        杨过
		 *        郭靖
		 * */
		HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
		ArrayList<String>  arraylist1 =  new ArrayList<String>();
		ArrayList<String>  arraylist2 =  new ArrayList<String>();
		ArrayList<String>  arraylist3 =  new ArrayList<String>();
		arraylist1.add("曹操");
		arraylist1.add("孙权");
		arraylist1.add("刘备");
		arraylist2.add("令狐冲");
		arraylist2.add("任盈盈");
		arraylist3.add("杨过");
		arraylist3.add("郭靖");
		hashMap.put("三国演义", arraylist1);
		hashMap.put("笑傲江湖", arraylist2);
		hashMap.put("神雕侠侣", arraylist3);
		Set<String> set = hashMap.keySet();
		for (String setKey : set) {
			System.out.println(setKey);
			ArrayList setValue = hashMap.get(setKey);
			for (Object object : setValue) {
				System.out.println("  "+object);
			}
			
		}
	}

}
