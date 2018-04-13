/**
 * 
 */
package com.softeem.linearlist;

/**
 * @author XiongYan
 *
 * 2018年3月20日
 */
//链表节点
public class Node {
	protected char data;//数据域：假设为字符型
	protected Node next = null;//指针域：指向下一个节点
	/**
	 * 节点无参构造器：
	 */
	public Node() {
		
	}
	/**有参构造器*/
	public Node(char data) {
		this.data = data;
		this.next = null;
	}
	/**展示数据*/
	public void display() {
		if(this.next == null) {
			System.out.println(data+"-->");
		}else {
			System.out.println(data);
		}
	}
	/**重写toString方法*/
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	

}
