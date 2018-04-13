/**
 * 
 */
package com.softeem.list;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author XiongYan
 *
 * 2018年2月11日
 */
public class ArrayListDemo01 {
	public static void main(String[] args) {
		/**
		 * 1.创建一个牌盒
		 * 2.装牌
		 * 3.洗牌
		 * 4.发牌
		 * 5.看牌
		 * */
		ArrayList<String> arrayList = new ArrayList<String>();
		//定义一个颜色数组
		String[] colors = {"♥","♠","♣","方块"};
		//定义一个点数数组：
		String[] numbers = {"A","2","3","4","5","6","7","8",
				"9","10","J","Q","k"};
		//装牌
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < numbers.length; j++) {
				
				arrayList.add(colors[i].concat(numbers[j]));
			}
		}
		arrayList.add("大王");
		arrayList.add("小王");
		//洗牌：
		Collections.shuffle(arrayList);
		System.out.println(arrayList);
		//发牌：
		ArrayList<String> XiongYan = new ArrayList<String>();
		ArrayList<String> XiaoXue = new ArrayList<String>();
		ArrayList<String> HuanHuan = new ArrayList<String>();
		ArrayList<String> dipai = new ArrayList<String>();
		for(int k = 0; k < arrayList.size();k++) {
			if(k >= arrayList.size()-3) {
				dipai.add(arrayList.get(k));
			}else if(k%3 == 0) {
				XiongYan.add(arrayList.get(k));
			}else if(k%3 == 1) {
				XiaoXue.add(arrayList.get(k));
			}else if(k%3 == 2) {
				HuanHuan.add(arrayList.get(k));
			}
		}
		//看牌：
		kanPai("熊焱", XiongYan);
		kanPai("小雪", XiaoXue);
		kanPai("一一", HuanHuan);
		kanPai("底牌", dipai);
		
		
	}
	public static void kanPai(String name,ArrayList<String> list) {
		System.out.print(name+":");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+ " ");
		}
		System.out.println();
	}
}
