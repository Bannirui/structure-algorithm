package com.bannirui.java.algorithm;

/**
 *@author dingrui
 *@date 2020-12-09
 *@description 二分查找 非递归
 */
public class BinarySearchNonRecursion {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 7, 8, 99, 100};
		int target = 101;
		int i = new BinarySearchNonRecursion().binarySearch(arr, target);

		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/12/9
	 * @param arr 待查找数组，默认已经升序
	 * @param target 待查找目标值
	 * @return 如果在数组中找到目标值，返回该值对应的下标 否则返回-1
	 * @description 二分查找 非递归实现
	 *
	 */
	private int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				// 找到目标值 返回索引出去
				return mid;
			} else if (arr[mid] < target) {
				// 中间值<目标值 说明目标值在数组右边
				left = mid + 1;
			} else {
				// 中间值>目标值 说明目标值在数组左边
				right = mid - 1;
			}
		}
		// while循环走完都没return出去 说明在数组中没有找到目标值
		return -1;
	}
}
