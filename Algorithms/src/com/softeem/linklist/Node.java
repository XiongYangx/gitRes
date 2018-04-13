/**
 * 
 */
package com.softeem.linklist;

/**
 * @author XiongYan
 *
 * 2018年1月22日
 */
public class Node {
	protected Node next;//指针域
	protected int data;//数据域
	//无参构造器：
	public Node()
	{
		
	}
	//有参构造器：
	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
	//展示数据：
	public void display() 
	{
		if(this.next==null) 
		{
			System.out.print(data+"-->");
		}else {
			System.out.print(data);
		}
	}
	public String toString() {
		return "Node[data="+data+"]";
	}
}
