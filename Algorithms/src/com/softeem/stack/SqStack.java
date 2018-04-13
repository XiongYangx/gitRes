/**
 * 
 */
package com.softeem.stack;

/**
 * @author XiongYan
 *
 * 2018年3月19日
 */
public class SqStack {
	private static final int maxSize = 20;//顺序栈容量
	private int top;//栈顶指针
	private char[] data;//存放栈元素
	/**
	 * @param top
	 * @param data
	 */
	//构造器：
	public SqStack(int top, char[] data) {
		this.top = -1;
		this.data = new char[maxSize];
	}
	/**
	 * 判断是否为空栈：
	 * return true 表示为空栈，否则不为空栈：
	 * */
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}else {
			return false;
		}
	}
	/**判断栈是否已经满了
	 * return true //表示已经满了
	 * false 是空栈
	 * */
	public boolean isFull() {
		if(top == maxSize-1) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 栈中元素个数：
	 * return 返回栈中元素个数
	 * */
	public int size() {
		return top+1;
	}
	/**
     * 元素出栈
     * 
     * @return 栈顶元素值，如果返回'#',当且仅当栈为空
     * @see #push(char)
     */
	public char push() {
		if(this.isEmpty()) {
			return '#';//若栈为空，则返回'#'
		}else {
			return data[this.top--];
		}
	}
	/**
     * 元素进栈
     * 
     * @param c
     *            进栈元素值
     * @return true表示进栈成功，否则失败
     * @see #pop()
     */
	public boolean push(char a) {
		if(this.isFull()) {
			return false;
		}else {
			data[top++] = a;
			return true;
		}
	}
	/**
     * 读取栈顶元素
     * 
     * @return 栈顶元素值，如果为'#'，当且仅当栈为空
     */
	public char getTop() {
		if(this.top ==-1) {
			return '#';
		}else {
			return data[top];
		}
	}
	/**清空栈：
	 * */
	public void clear() {
		this.top = -1;
	}
}
