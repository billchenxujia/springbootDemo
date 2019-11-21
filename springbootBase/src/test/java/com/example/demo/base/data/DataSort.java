package com.example.demo.base.data;

/**
 * 
 * 类 @code(DataSort)
 *
 * <p>
 * 功能简介：
 * <p>
 * 
 * <p>
 * 创建时间：2019年9月2日
 *
 * @author chenxj
 */
public class DataSort {
	public static void main(String[] args) {

	}
	
	/**
	 * 优化版冒泡排序，如果不发生交换了，证明顺序已经正确用flag标记
	 * 时间复杂度O(n2)
	 * @param arr 示例数组
	 */
	public static void BubbleSort(int[] arr) {

		int temp;// 临时变量
		boolean flag;// 是否交换的标志
		for (int i = 0; i < arr.length - 1; i++) { // 表示趟数，一共 arr.length-1 次

			// 每次遍历标志位都要先置为false，才能判断后面的元素是否发生了交换
			flag = false;

			for (int j = arr.length - 1; j > i; j--) { // 选出该趟排序的最大值往后移动

				if (arr[j] < arr[j - 1]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					flag = true; // 只要有发生了交换，flag就置为true
				}
			}
			// 判断标志位是否为false，如果为false，说明后面的元素已经有序，就直接return
			if (!flag)
				break;
		}
	}
	
	/**
	 * 选择排序演示
	 * @param array 排序数组
	 * @param lenth 排序数组长度
	 */
	public static void select_sort(int array[],int lenth){

	   for(int i=0;i<lenth-1;i++){

	       int minIndex = i;
	       for(int j=i+1;j<lenth;j++){
	          if(array[j]<array[minIndex]){
	              minIndex = j;
	          }
	       }
	       if(minIndex != i){
	           int temp = array[i];
	           array[i] = array[minIndex];
	           array[minIndex] = temp;
	       }
	   }
	}
	
	/**
	 * 二分查找算法简单演示
	 * @param A 数组
	 * @param target 查找目标
	 * @param n 长度
	 * @return 查找目标
	 */
	public int binarySearch(int[] A, int target, int n){
	    int low = 0, high = n, mid;
	    while(low <= high){
	        mid = low + (high - low) / 2;
	        if(A[mid] == target){
	            return mid;
	        }else if(A[mid] > target){
	            high = mid - 1;
	        }else{
	            low = mid + 1;
	        }
	    }
	    return -1;
	}
}
