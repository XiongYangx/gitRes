/**
 * 
 */
package com.softeem.search;

/**
 * @author XiongYan
 *
 * 2018年1月29日
 */
public class Search {
	public static void main(String[] args) {
		int[] sources = {-16,-2,3,5,6,7,9,11,12,24,89,98};
		System.out.println(binarySearch1(sources, 24));
		System.out.println(binarySearch2(sources, 24, 0, sources.length-1));
		System.out.println(binarySearch1(sources, 13));
		System.out.println(binarySearch2(sources, 13, 0, sources.length-1));
	}
	/**1.二分法查找：二分查找算法的思想是，将有序数列一分为二，然后让中间关键字与目标值进行比较
	 * 若中间关键字与目标值相等则找到，若目标值比中间关键字大，则low = mid+1;若目标值比中间
	 * 关键字小，则high = mid-1. 
	 * 
	 * */
	//1.1二分查找非递归算法：
	public static int binarySearch1(int[] sources,int target) {
		int low  = 0;
		int high = sources.length;
		while(low <= high) {
			int mid = (low + high)/2;
			if(target > sources[mid]) {
				low = mid +1;
			}else if(target == sources[mid]) {
				return mid;
			}else {
				high = mid -1;
			}
		}
		return -1;
	}
	//1.2 二分查找递归算法：
	public static int binarySearch2(int[] sources,int target,int low,int high) {
		if(low > high)
		   return -1;
		int mid  = (low + high)/2;
		if(target > sources[mid]) {
			return binarySearch2(sources, target, mid+1, high);
		}else if(target < sources[mid]) {
			return binarySearch2(sources, target, low, mid-1);
		}else {
			return mid;
		}
	}
}
