/**
 * 
 */
package com.softeem.linklist;

import java.util.LinkedList;
import java.util.List;

/**
 * @author XiongYan
 *
 * 2018年1月22日
 */
public class linkList {
	private Node first;//链表的第一个节点
	private Node rear;//链表的最后一个节点
	private int size;//当前链表的大小
	
	//构造器：
	public linkList() {
		this.first = null;
		this.rear = null;
		this.size = 0;
	}
	//链表中元素的个数：
	public int size() {
		return size;
	}
	//判断当前元素是否为空，当且仅当没有任何元素时，为空
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	//构建链表：头插法，在链表的头部插入节点：data 插入节点的数据
	public void insertAtHead(int data)
	{
		Node node = new Node(data);
		size++;
		if(size == 1) { //第一个节点用头插法
			first = node;
			rear = node;
		}else {
			node.next = first;
			first = node;
		}
	}
	//构建链表：尾插法，在链表的尾部插入节点：data 插入节点的数据
	public void insertAtRear(int data) 
	{
		Node node = new Node(data);
		size++;
		if(size == 1) { //第一个节点用尾插法
			first = node;
			rear = node;
		}else {
			rear.next = node; //当前节点插入到最后
			rear = node;
		}
	}
	//构建链表：指定索引位置插入节点(其后面)：index：插入索引位置；data 插入数据
	public void insertByIndex(int index,int data)
	{
		Node node = new Node(data);
		if(index < 0 || index >(size-1)) {
			return;
		}
		int pos = 0;
		Node current = first;
		if(pos!=index) 
		{
			current = current.next;
			pos++;
		}
		node.next = current.next;
		current.next = node;
		if(node.next == null) { //插入位置为最后一个位置
			rear = node;
		}
		size++;
	}
	//删除任意索引位置的节点，并返回该节点，如果位置不合法,返回null;index:指定删除节点的位置;return：返回要删除的节点
	public Node deleteByIndex(int index) 
	{
		Node current = first; //当前节点
		Node previous = null; //当前节点的下一个节点
		int pos = 0;
		if(index < 0 || index > size) {//超出索引范围
			return null;
		}else {
			while(pos != index) {
				pos++;
				previous = current;
				current = current.next;
			}
		}
		if(current == first) { //删除节点为第一个节点
			first = first.next;
		}else {
			previous.next = current.next;
		}
		if(current.next == null) { //删除节点为最后一个节点
			rear = previous;
		}
		size--;
		return current;//返回指定索引的节点。
	}
	//删除链表中指定数据的节点，并返回删除的节点(集) data:数据域； flag：true表示删除所有data元素,缺省为false
	public Node deleteByData(int data,boolean flag) {//flag = true 表示删除所有节点为data的数据，否则只删除第一个值为data的节点
		Node newFirst = null;//删除指定数据域的第一个节点
		Node newRear = null;//删除指定数据域的最后一个节点
		int pos = 0;
		Node current = first;
		if(flag == false)
		{
			while(current !=null)
			{
				if(current.data == data)
				{
					deleteByIndex(pos);
					newFirst = current;
					newFirst.next = null; //只保留数据域
					break;
				}
				current = current.next;
				pos++;//记录当前索引位置
			}
		}else {
			while(current !=null) 
			{
				if(current.data == data) 
				{
					deleteByIndex(pos);
					pos--;//删除链表中一个节点后，当前最新链表元素少一个，对应的索引也要减少
					if(newFirst ==null) 
					{ //在删除链表中插入第一个节点
						newFirst = current;
						newRear = current;
					}else 
					{
						newRear.next = current;
						newRear = current;
					}
				}
				current = current.next;
				pos++;
			}
		}
		return newFirst;
	}
	//仅删除链表中的第一个为指定数据的节点，并返回这个节点 data:指定数据，return 返回的节点
	public Node deleteByData(int data) {
		return deleteByData(data, false);
	}
    //获取指定数据在链表中首次出现的位置：data：指定数据，return 返回数据的位置，若没有此数据，则返回-1；
	public int findByData(int data) {
		Node current = first;
		int pos = 0;
		while(current != null) {
			if(current.data == data) {
				return pos;
			}
			pos++;
			current =current.next;
		}
		return -1;
	}
	//用新数据替代指定数据 (如果存在,修改第一个)
	public void replace(int oldData,int newData)
	{
		Node current = first;
		while(current != null) {
			if(current.data == oldData) {
				current.data = newData;
				return;
			}
			current = current.next;
		}
	}
	//用新数据替代指定数据 (如果存在,修改所有数据)
	public void replaceAll(int oldData,int newData)
	{
		Node current = first;
		while(current != null) {
			if(current.data == oldData) {
				current.data = newData;
			}
			current = current.next;
		}
	}
	//显示整个链表的信息
	public void displayAllNodes() {
		Node current = first;
		while(current !=null) {
			current.display();
			current = current.next;
		}
		
	}
	//反向输出单链表中的所有值(递归)
	public void outputReverse(Node first) {
		if(first == null) {
			return;
		}
		Node cur = first;
		if(cur.next == null) {
			System.out.print(new Integer(cur.data).toString()+" ");
		}else{
			outputReverse(cur.next);
			System.err.print(new Integer(cur.data).toString()+" ");
		}
	}
	//反向输出单链表中的所有的值(栈存储方式)
	public void outputReverse2(Node first) {
		List<Node> list = new LinkedList<Node>();
		Node node = first;
		while(node != null) {
			list.add(node);
			node = node.next;
		}
		while(list.size() != 0) {
			System.out.print(new Integer(list.remove(list.size()-1).data).toString()+" ");
		}
		
	}
	//将原链表进行倒置：first：原链表的头结点； return ：返回的是倒置后单链表的头结点
	public Node reverse(Node first) {
		if(first == null) {
			return null;
		}
		Node p,q;
		p = first.next;
		first.next = null;
		while(p.next != null) {
			q = p;
			p = p.next;
			q.next = first;
			first = q;
		}
		return first;
	}
}
