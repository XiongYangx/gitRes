/**
 * 
 */
package com.softeem.map;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author XiongYan
 *
 * 2018年2月8日
 */

/**需求："aababcabcdabcde"，获取字符串中每一个字符出现的次数：要求结果：a(5)b(4)c(3)d(2)e(1)
 * 改为键盘录入
 * */
public class SumString {
	public static void main(String[] args) {
		//输入字符串：
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String line = sc.nextLine();
		//将字符串装换为字符数组
		char[] chs = line.toCharArray();
		
		TreeMap<Character, Integer> treeMap = new TreeMap<Character,Integer>();
		for (char ch : chs) {
			Integer i = treeMap.get(ch);
			if(i == null) {
				treeMap.put(ch, 1);
			}else {
				i++;
				treeMap.put(ch, i);
			}
		}
		StringBuffer sb = new StringBuffer();
		Set<Character> set = treeMap.keySet();
		for (Character key : set) {
			sb.append(key).append("(").append(treeMap.get(key)).append(")");
		}
	System.out.println("result:"+sb);	
	}
}
