package com.bannirui.java.structure.sort;

/**
 *@author dingrui
 *@date 2020-11-23
 *@description 选择排序
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = new int[]{1, -2, 3, 6, 98, 4};

		sort(arr);

		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/11/23
	 * @param arr
	 * @return
	 * @description 选择排序
	 */
	private static void sort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			// 预设当前下标就是最小值
			int minIndex = i;
			int min = arr[i];

			// 当前下标后面找是否有比预设的最小值还小的
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					minIndex = j;
					min = arr[j];
				}
			}

			// 如果最小值的下标不是当前的 也就是说在遍历过程中找到了最小值 需要交换
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}
}
