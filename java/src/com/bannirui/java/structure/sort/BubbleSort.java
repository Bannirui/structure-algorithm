package com.bannirui.java.structure.sort;

/**
 *@author dingrui
 *@date 2020-11-23
 *@description 冒泡排序
 */
public class BubbleSort {

	public static void main(String[] args) {
		// 待排序数组
		int[] arr1 = new int[]{3, 9, -1, 10, -2};
		// 最原始的冒泡排序 模拟过程
		sortV1(arr1);

		// 待排序数组
		int[] arr2 = new int[]{3, 9, -1, 10, -2};
		// 两层for循环
		sortV2(arr2);

		// 待排序数组
		int[] arr3 = new int[]{3, 9, -1, 10, 20};
		// 两层for循环
		sortV3(arr3);

		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/11/23
	 * @param arr
	 * @return
	 * @description 维护一个标识符 如果某一趟中出现不需要排序就说明已经排好了 不需要再继续冒泡
	 */
	private static void sortV3(int[] arr) {
		// 辅助变量
		int tmp;
		for (int i = 0; i < arr.length - 1; i++) {
			// flag为true说明需要排序 如果为false就说明不需要排序
			boolean flag = false;
			// 第i+1趟
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
			System.out.println("第" + (i + 1) + "趟排序");
			if (!flag) {
				break;
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/23
	 * @param arr
	 * @return
	 * @description 两层for循环
	 */
	private static void sortV2(int[] arr) {
		// 辅助变量
		int tmp;
		for (int i = 0; i < arr.length - 1; i++) {
			// 第i+1趟
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/23
	 * @param arr
	 * @return
	 * @description 最原始的排序方法 模拟过程
	 */
	private static void sortV1(int[] arr) {
		// 辅助变量
		int tmp;

		// 第一趟排序
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
			}
		}

		// 第二趟排序
		for (int i = 0; i < arr.length - 2; i++) {
			if (arr[i] > arr[i + 1]) {
				tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
			}
		}

		// 第三趟排序
		for (int i = 0; i < arr.length - 3; i++) {
			if (arr[i] > arr[i + 1]) {
				tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
			}
		}

		// 第四趟排序
		for (int i = 0; i < arr.length - 4; i++) {
			if (arr[i] > arr[i + 1]) {
				tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
			}
		}
	}
}
