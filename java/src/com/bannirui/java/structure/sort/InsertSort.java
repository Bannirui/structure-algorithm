package com.bannirui.java.structure.sort;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-11-23
 *@description 插入排序
 */
public class InsertSort {
	public static void main(String[] args) {
		// 插入排序推导过程
		sortV1();

		// 定义一个数组
		int[] arr = new int[]{101, 34, 119, 1};
		sortV2(arr);

		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/11/23
	 * @return
	 * @description 插入排序推导过程
	 */
	private static int[] sortV1() {
		// 定义一个4个元素的数组
		int[] arr = new int[]{101, 34, 119, 1};
		// 排序前
		System.out.println("排序前数组：");
		System.out.println(Arrays.toString(arr));

		// 第1轮
		// 待插入的数下标1 值34
		int insertValue = arr[1];
		// insertValue前面这个数的下标
		int inertIndex = 0;

		while (inertIndex >= 0 && insertValue < arr[inertIndex]) {
			arr[inertIndex + 1] = arr[inertIndex];
			inertIndex--;
		}
		// while退出过后说明找到了插入位置 就是inertIndex+1
		arr[inertIndex + 1] = insertValue;

		System.out.println("第1轮插入：");
		System.out.println(Arrays.toString(arr));


		// 第2轮
		// 待插入的数下标2 值119
		insertValue = arr[2];
		// insertValue前面这个数的下标
		inertIndex = 1;

		while (inertIndex >= 0 && insertValue < arr[inertIndex]) {
			arr[inertIndex + 1] = arr[inertIndex];
			inertIndex--;
		}
		// while退出过后说明找到了插入位置 就是inertIndex+1
		arr[inertIndex + 1] = insertValue;

		System.out.println("第2轮插入：");
		System.out.println(Arrays.toString(arr));


		// 第3轮
		// 待插入的数下标3 值1
		insertValue = arr[3];
		// insertValue前面这个数的下标
		inertIndex = 2;

		while (inertIndex >= 0 && insertValue < arr[inertIndex]) {
			arr[inertIndex + 1] = arr[inertIndex];
			inertIndex--;
		}
		// while退出过后说明找到了插入位置 就是inertIndex+1
		arr[inertIndex + 1] = insertValue;

		System.out.println("第3轮插入：");
		System.out.println(Arrays.toString(arr));


		return arr;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/23
	 * @param arr
	 * @return
	 * @description for循环插入排序
	 */
	private static void sortV2(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			// 第i轮
			// 待插入的数
			int insertValue = arr[i];
			// insertValue前面这个数的下标
			int inertIndex = i-1;

			while (inertIndex >= 0 && insertValue < arr[inertIndex]) {
				arr[inertIndex + 1] = arr[inertIndex];
				inertIndex--;
			}
			// while退出过后说明找到了插入位置 就是inertIndex+1
			arr[inertIndex + 1] = insertValue;

		}

	}
}
