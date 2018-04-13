/**
 * 
 */
package com.softeem.linearlist;

/**
 * @author XiongYan
 *
 * 2018年3月20日
 */
/** 单链表的创建及基本操作
 * */
public class linList {
	private Node first;//链表头结点
	private Node rear;//链表尾节点
	private int size;//链表大小
	/**无参构造器*/
	public linList() {
		this.first = null;
		this.rear = null;
		this.size = 0;
	}
    /**链表中元素的个数*/
	public int size() {
		return size;
	}
	/**判断当前链表是否为空：当且仅当当前链表没有元素时，链表为空*/
	public boolean isEmpty() {
		if(this.size ==0) {
			return true;
		}else {
			return false;
		}
	}
	/**构建链表：头插法，在链表的头部插入节点：data 插入节点的数据*/
	public void insertAtHead(char data) {
		Node node =new Node(data);
		size++;
		if(size == 1) {
			first = node;
			rear = node;
		}else {
			node.next = first;
			first = node;
		}
	}
}
