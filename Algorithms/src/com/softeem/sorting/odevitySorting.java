/**
 * 
 */
package com.softeem.sorting;

/**
 * @author XiongYan
 *
 * 2018年3月21日
 */
public class odevitySorting {
	public static void main(String[] args) {
		int[] arr = {1,3,2,4,5,6,8,2,9,3};
		int[] arr1 = odevitySorting.odeSorting(arr);
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
	/**
	 * 给定一个整数数组，将其奇数排在左边，偶数排在右边，不能改变
	 * 其相对顺序，空间复杂度为O(1)
	 * */
    public static int[] odeSorting(int[] sources) {
    	for(int i = 0; i < sources.length;i++) {
    		if(sources[i]%2 == 1) //奇数
    		{
    			int index = i;
    			while(index>0 && sources[index-1]%2==0) {
    				int temp = sources[i];
    				sources[i] = sources[index];
    				sources[index] = temp;
    				--index;
    			}
    		}
    	}
    	return sources;
    }
}
