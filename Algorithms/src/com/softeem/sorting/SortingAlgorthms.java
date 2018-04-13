/**
 * 
 */
package com.softeem.sorting;

/**
 * @author XiongYan
 *
 * 2018年1月25日
 */
public class SortingAlgorthms {
	public static void main(String[] args) {
		int[]  arr1 = {3,-2,12,6,24,9,7,5,98,-16,89,11};
		directInsertSorting(arr1);
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		int[]  arr2 = {3,-2,12,6,24,9,7,5,98,-16,89,11};
		halfInsertSorting(arr2);
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		int[]  arr3 = {3,-2,12,6,24,9,7,5,98,-16,89,11};
		shellSorting(arr3);
		for(int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
		int[]  arr4 = {3,-2,12,6,24,9,7,5,98,-16,89,11};
		selectSorting(arr4);
		for(int i = 0; i < arr4.length; i++) {
			System.out.print(arr4[i]+" ");
		}
		System.out.println();
		int[]  arr5 = {3,-2,12,6,24,9,7,5,98,-16,89,11};
		heapSorting(arr5);
		for(int i = 0; i < arr5.length; i++) {
			System.out.print(arr5[i]+" ");
		}
		System.out.println();
		int[]  arr6 = {3,-2,12,6,24,9,7,5,98,-16,89,11};
		bubbleSorting(arr6);
		for(int i = 0; i < arr6.length; i++) {
			System.out.print(arr6[i]+" ");
		}
		System.out.println();
		int[]  arr7 = {3,-2,12,6,24,9,7,5,98,-16,89,11};
		quicklySorting(arr7, 0, arr7.length-1);
		for(int i = 0; i < arr7.length; i++) {
			System.out.print(arr7[i]+" ");
		}
		System.out.println();
		int[]  arr8 = {3,-2,12,6,24,9,7,5,98,-16,89,11};
		mergeSorting(arr8, 0, arr8.length-1);
		for(int i = 0; i < arr8.length; i++) {
			System.out.print(arr8[i]+" ");
		}
	}
/*说明：八大排序算法分别是：
 * 1.插入排序(直接插入，折半插入)
 * 2.希尔排序
 * 3.选择排序(简单选择排序)
 * 4.堆排序
 * 5.交换排序(冒泡排序,快速排序)
 * 6.归并排序
 * */
	
	/** 1.直接插入排序：将当前无序序列区R[i,...n]中的记录R[i]插入到有序序列区R[1,...i-1]
	 *  使有序序列区的长度增1.在有序子序列中寻找要插入的位置时，有序序列区中的元素比当前要插入的
	 *  元素要大时，就将该有序序列区的元素后移，直到判断该有序序列区的元素小于或等于当前要插入的元
	 *  素时，就将当前要插入的元素插入到该有序序列区元素的后面，将所有无序序列区的元素插入完毕后，整
	 *  个表就是有序表。
	 * */
	public static void directInsertSorting(int[] arr) {
		int i,j,temp;
		for(i = 1; i < arr.length; i++) {//将元素索引为[1,...arr.length-1]的元素逐个插入到前面有序序列区中
			temp = arr[i];//先将当前要插入的元素保存起来
			for(j = i-1; j>=0 && arr[j]>temp; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;//当前有序子序列中的元素小于或等于当前要插入的元素
		}
	}
	/**2.折半插入排序：排序思想与直接插入排序差不多，都是将无序序列区中的元素逐个插入到有序序列区
	 * 的过程。不同点在于：在折半插入排序中,当前需要插入的元素在寻找要插入的位置时，是在有序序列区
	 * 通过二分查找算法进行查找，并且找到要插入的位置后，一次性后移所有比当前要插入元素大的元素(直
	 * 接插入排序是边查找边后移)
	 * */
	public static void halfInsertSorting(int[] arr) {
		int i,j,low,mid,high,temp;
		for(i = 1; i < arr.length; i++) {
			temp = arr[i]; //将当前要插入的元素保存起来
			low = 0;
			high = i-1;
			while(low <= high) { // 当low==high时,还要继续判断是插入在low(high)的左边还是右边
				mid = (low+high)/2;
				if(arr[mid] > arr[i]) {
					high = mid-1;
				}else if(arr[mid]==arr[i]){ //当中间元素恰好等于待插入元素时,就将这个待插入元素直
					                        //接插入到这个中间位置的右边第一个位置(mid+1),
					high = mid;
					break;
				}else {
					low = mid + 1;
				}
			}
			for(j = i-1; j >= high+1; j--) { //将所有索引为[i-1,...high+1]的元素后移，其中i-1为当前要插入元素索引的前一个索引,high+1为当前要插入元素的索引位置
				arr[j+1] = arr[j];
			}
			arr[high+1] = temp;
		}
	}
	/**3.希尔排序：先取一个小于n的整数d1作为第一个增量,把文件的全部记录分组。所有距离为d1的倍数的记录放在
	 * 同一个组中，先在各组内进行直接插入排序或折半插入排序。然后，取第二个增量d2<d1重复上述的分组和排序，
	 * 直至所取的增量  dt=1(dt<dt-1 …<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
	 * */
	public static void shellSorting(int[] arr) {
		int d; //将序列分割成多个子序列的步长
		int i,j,temp;
		for(d = arr.length/2; d>=1; d/=2) {
			for(i=d; i < arr.length; i++) {
				temp = arr[i];
				for(j = i-d;j >= 0 && arr[j]>temp;j -= d) {//对每一组(步长为d)的内部进行直接插入排序
                    arr[j + d] = arr[j];
				}
				arr[j+d] = temp;
			}
		}
	}
	/**5.简单选择排序：基本思想是，从无序序列区选择关键字最小的记录插入到有序序列区的后面，
	 * 直到整个序列区基本有序。
	 * */
	public static void selectSorting(int[] arr) {
		int i,j,temp;
		int min;  //记录无序序列区中关键字最小的索引
		for(i = 0; i < arr.length; i++) {
			min = i;//首先将当前这个无序子序列[i, arr.length-1]的第一个元素看作最小
			temp = arr[i];
			for(j = i+1;j<arr.length; j++) {
				if(arr[min]>arr[j]) {//如果无序序列区中又出现比当前关键字更小的记录，则将该关键字的索引赋给min;
					min = j;
				}
			}
			//将当前无序序列第一个记录与最小记录进行交换
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	/**5.堆排序：
	 *  堆排序是将一个待排序表按照一棵完全二叉树的顺序存储结构进行存储，再利用完全二叉树中的双亲节点与其子节点的内在
	 * 关系在当前的无序区选择最大(最小)元素首先将这个无序表(完全二叉树的顺序存储结构)中的所有根节点依次进行大根堆调整
	 * ,直到整个表满足大根堆性质,接着就可以取堆顶元素(当前无序表最大元素)与当前无序表的最后一个元素进行交换,此时减少
	 * 一个元素(与上一次相比)的无序表已破坏大根堆性质,就要继续调整这个无序表,调整好之后,再次交换,再次调整,直
     * 到无序表只剩下一个元素为止
	 * */
	public static void heapSorting(int[] arr) {
		buildMaxHeap(arr); //将待排序表调整为一个大根堆,利用完全二叉树的顺序存储结构将其存储
		for(int i = arr.length-1; i > 0 ; i--) {
			// 当整个序列的初始大根堆建立完成后,就要将最大元素(整个序列堆顶,索引0处)与当前无序序列的最后(索引i处,
			//当然第一次为索引arr.length-1处)进行交换,这样就会破坏大根堆的性质那么就需要继续以根节点arr[0]进行向
			//下调整(每一次都是调整这个节点)
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, i);//因为交换后,破坏大根堆性质的根节点是arr[0],所以每一次需要调整这个根节点,每一次调整
                              //序列的元素个数比上次少一个(因为每一次已经选出一个最大元素放在当前无序序列的最后)
		}
	}

	/**
	 * @param arr
	 */
	private static void buildMaxHeap(int[] arr) {
		// 我们知道将一个顺序表按照完全二叉树的顺序存储结构来存储,它的所有根节点的索引为[0,
        // arr.length/2],任一个根节点i的孩子的索引为2*i与2*i+1(右孩子如果存在)
		for(int i = arr.length/2; i >= 0; i--) {// 对完全二叉树的每一个节点[arr.length/2, 0]进行满足大根堆的调整
            adjust(arr, i, arr.length);
			
		}
		
	}
	/**
	 * @param arr  待调整的序列
	 * @param k    当前需要调整的根节点的索引
	 * @param length
	 * 对于整个序列中待调整元素的个数(当然当第一次对整个序列建立大根堆的时候,每一次调整的元素个数应当是arr.length,
	 * 当整个序列的初始大根堆建立完成后,将最大元素(当前序列的堆顶)与当前无序序列的最后一个元素交换后,就会破坏大根堆
	 * 性质,就需要重新调整,此时需要调整的元素个数必然要比上一次调整的个数少一个(堆 顶元素与当前无序序列的最后一个元素
	 * 交换后,从这个索引位置到整个序列最后一个索引均有序))
	 */
	private static void adjust(int[] arr, int k, int length) {
		for(int i = 2*k; i < length; i *= 2 ) {// 当前根节点arr[k]的左孩子arr[2*k]
			if(i < (length-1) && arr[i] <arr[i+1]) {
				// i < (length-1)表示当arr[i]为最大根节点时,它有左孩子,但是有可能没有右孩子,
				//就不需要比较两个孩子arr[i] < arr[i+1](另一方面索引出现越界)
                i++;// 找出根节点arr[k]的两个孩子arr[2*k]与arr[2*k+1]的比较大的一个,注意当左孩子
                //arr[2*k]较大时,说明以右孩子arr[2*k+1]为根的树仍然满足大根堆性质,不需处理,当右孩子较大时,同理
			}
			if(arr[k] >= arr[i]) {//如果当前根节点不小于其左右孩子,说明以此根节点的二叉树满足大根堆性质,无需再进一步调整了
				break;
			}else {
				// 如果当前根节点小于其孩子节点中的一个,就要将这个较大的孩子移到当前堆顶处(statement1),然后将堆顶元素移到这个
				//较大孩子节点处(statement2),接着以这个较大的孩子节点为根节点(如果存在)继续调整(也就是i*=2)
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                k = i;     //下一个待处理的根节点(如果存在)就是当前处理根节点的两个孩子中的较大者
			}
		}
	}
	//交换算法：
	/**
	 * 6.冒泡排序：基本思想是，将关键字大的元素向尾部移动，关键字小的元素向头部移动
	 * */
	public static void bubbleSorting(int[] arr) {
		for(int i = 1; i <arr.length; i++) { //比较躺数
			for(int j = 0; j<arr.length-i; j++) { //当前比较躺数的比较次数
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	/**7.快速排序：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据
	 * 都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过
	 * 程可以递归进行，以此达到整个数据变成有序序列。快速排序算法的时间复杂度为O(nlogn)
	 * */
	public static void quicklySorting(int[] arr,int low,int high) {
		int i,j,k;
		if(low < high) {
			i = low;
			j = high;
			k = arr[i];
			while(i < j) {
				while(i < j && arr[j] > k) {
					j--;
				}
				if(i<j) {
					arr[i] = arr[j];
					i++;
				}
				while(i < j && arr[i] < k) {
					i++;
				}
				if(i<j) {
					arr[j] = arr[i];
					j--;
				}
			}
			arr[i] = k;
			quicklySorting(arr, low, i-1);
			quicklySorting(arr, i+1, high);
		}
	}
	/**8.归并排序：  归并排序：分而治之(divide - conquer);每个递归过程涉及三个步骤 第一, 
	 * 分解: 把待排序的 n 个元素的序列分解成两个子序列, 每个子序列包括 n/2 个元素. 第二, 
	 * 治理: 对每个子序列分别调用归并排序MergeSort, 进行递归操作 第三, 合并:
     * 合并两个排好序的子序列,生成排序结果.
	 * */
	public static void mergeSorting(int[] arr,int start,int end) {
		if(start <end) {
			int mid = (start+end)/2;
			mergeSorting(arr, start, mid);
			mergeSorting(arr, mid+1, end);
			merge(arr,start,mid,mid+1,end);
		}
	}

	/**
	 * @param arr    待排序数列
	 * @param start1  前一个数列开始关键字
	 * @param end1       前一个数列结束关键字
	 * @param satrt2 后一个数列开始关键字
	 * @param end2      后一个数列结束关键字
	 */
	private static void merge(int[] arr, int start1, int end1, int start2, int end2) {
		int i,j;
		{
			i = start1;
			j = start2;
		}
		int k = 0;
		int temp[] = new int[end2-start1+1];
		while(i <= end1 && j <= end2) {
			if(arr[i] >= arr[j]) {
				temp[k++] = arr[j++];
			}else {
				temp[k++] = arr[i++];
			}
		}
		while(i <= end1) {
			temp[k++] = arr[i++];
		}
		while(j <= end2) {
			temp[k++] = arr[j++];
		}
		k = start1;
		for(int element:temp) {
			arr[k++] = element;
		}
	}
}
