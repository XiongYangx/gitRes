/**
 * 
 */
package com.softeem.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author XiongYan
 *
 * 2018年2月7日
 */
public class mapErgodic {
	public static void main(String[] args) {
		//map集合遍历的两种方式：
		//1.创建map集合：
		Map<String, String> map = new HashMap<String,String>();
		//2.添加元素
		map.put("吴奇隆", "刘诗诗");
		map.put("邓超", "孙俪");
		map.put("张杰", "谢啦");
		map.put("三火", "雪儿");
		//遍历方式一：先取key值，再取value值：
		System.out.println("map:"+map);
		Set<String>  set = map.keySet();
		for (String key : set) {
			System.out.println("value"+map.get(key));
		}
		//遍历方式二：将整个map集合对象获取到，然后获取key和value
		System.out.println("----------------------");
		Set<Map.Entry<String, String>> set2 = map.entrySet();
		for (Map.Entry<String, String> entry : set2) {
			System.out.println("keys"+entry.getKey());
			System.out.println("values"+entry.getValue());
		}
	}

}
