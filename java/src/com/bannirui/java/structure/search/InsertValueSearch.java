package com.bannirui.java.structure.search;

/**
 *@author dingrui
 *@date 2020-11-26
 *@description 插值查找 目标数据必须也是有序的
 */
public class InsertValueSearch {
	public static void main(String[] args) {
		// 初始化一个数组
		int[] arr = {1, 2, 3, 4, 5, 6, 67, 89};
		int findValue = 67;
		int index = insertValueSearch(arr, findValue, 0, arr.length - 1);

		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/11/26
	 * @param arr 查找数组
	 * @param findValue 查找目标值
	 * @param left 查找数据左索引
	 * @param right 查找数据右索引
	 * @return 如果找到了目标值返回对应的数组下标 如果没找到返回-1
	 * @description 插值查找
	 */
	private static int insertValueSearch(int[] arr, int findValue, int left, int right) {
		// 数组是有序的 如果查找的目标值超出了极值或者索引全部查找都没找到 退出
		if (findValue < arr[0] || findValue > arr[arr.length - 1] || left > right) {
			return -1;
		}

		// mid
		int midIndex = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
		int midValue = arr[midIndex];

		if (findValue > midValue) {
			// 向右递归
			return insertValueSearch(arr, findValue, midIndex + 1, right);
		} else if (findValue < midValue) {
			// 向左递归
			return insertValueSearch(arr, findValue, left, midIndex - 1);
		} else {
			// findValue==midValue 找到了
			return midIndex;
		}
	}
}
