package com.bannirui.java.structure.sort;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-11-25
 *@description 基数排序
 */
public class RadixSort {

	public static void main(String[] args) {
		radixSortV0();

		int[] arr = {53, 3, 542, 748, 14, 214};
		System.out.println("基数排序前：");
		System.out.println(Arrays.toString(arr));
		radixSort(arr);
		System.out.println("基数排序后：");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * @author dingrui
	 * @date 2020/11/25
	 * @param arr
	 * @return
	 * @description 基数排序
	 */
	private static void radixSort(int[] arr) {
		// 先找到待排序数组中最大的那个数
		int maxValue = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
			}
		}
		// 最大数的位数 也就是这个数的长度
		int maxLength = (maxValue + "").length();

		/**
		 * 初始化桶
		 * 二维数组
		 * 第一层数组10个元素表示10个桶
		 * 第二层数组不确定需要放多少个数据 初始化的时候元素个数就是取待排序数组的长度 取上限
		 */
		int[][] bucket = new int[10][arr.length];

		// 因为桶中的数据还要再取出来 定义一个数组 脚标表示第一个桶 数字表示桶中已经存在数据个数 作为指针
		int[] bucketElementCount = new int[10];

		// 最大位数的长度也就是遍历的次数
		for (int i = 1, n = 1; i <= maxLength; i++, n *= 10) {
			// 第i轮
			// 待排序数组元素放到桶中
			for (int j = 0; j < arr.length; j++) {
				// 每个元素的个位的值
				int digitOfElement = arr[j] / n % 10;
				// 放入到对应的桶中
				bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
				// 记录桶中元素个数的指针移动
				bucketElementCount[digitOfElement]++;
			}

			// 按照桶的顺序把桶中元素取出来放回排序数组
			int index = 0;
			for (int k = 0; k < bucketElementCount.length; k++) {
				// 看看桶中是否有数据
				if (bucketElementCount[k] != 0) {
					// 循环第k个桶 取出来数据
					for (int l = 0; l < bucketElementCount[k]; l++) {
						arr[index] = bucket[k][l];
						index++;
					}
				}
				// 每一轮取完后再把每个桶中元素数量的指针置为0
				bucketElementCount[k] = 0;
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/25
	 * @return
	 * @description 基数排序 推导版本
	 */
	private static void radixSortV0() {
		int[] arr = {53, 3, 542, 748, 14, 214};

		/**
		 * 初始化桶
		 * 二维数组
		 * 第一层数组10个元素表示10个桶
		 * 第二层数组不确定需要放多少个数据 初始化的时候元素个数就是取待排序数组的长度 取上限
		 */
		int[][] bucket = new int[10][arr.length];

		// 因为桶中的数据还要再取出来 定义一个数组 脚标表示第一个桶 数字表示桶中已经存在数据个数 作为指针
		int[] bucketElementCount = new int[10];

		// 第1轮
		// 待排序数组元素放到桶中
		for (int j = 0; j < arr.length; j++) {
			// 每个元素的个位的值
			int digitOfElement = arr[j] % 10;
			// 放入到对应的桶中
			bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
			// 记录桶中元素个数的指针移动
			bucketElementCount[digitOfElement]++;
		}

		// 按照桶的顺序把桶中元素取出来放回排序数组
		int index = 0;
		for (int k = 0; k < bucketElementCount.length; k++) {
			// 看看桶中是否有数据
			if (bucketElementCount[k] != 0) {
				// 循环第k个桶 取出来数据
				for (int l = 0; l < bucketElementCount[k]; l++) {
					arr[index] = bucket[k][l];
					index++;
				}
			}
			// 每一轮取完后再把每个桶中元素数量的指针置为0
			bucketElementCount[k] = 0;
		}
		System.out.println("第1轮对个位排序：" + Arrays.toString(arr));

		// =============================

		// 第2轮
		// 待排序数组元素放到桶中
		for (int j = 0; j < arr.length; j++) {
			// 每个元素的十位的值
			int digitOfElement = arr[j] / 10 % 10;
			// 放入到对应的桶中
			bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
			// 记录桶中元素个数的指针移动
			bucketElementCount[digitOfElement]++;
		}

		// 按照桶的顺序把桶中元素取出来放回排序数组
		index = 0;
		for (int k = 0; k < bucketElementCount.length; k++) {
			// 看看桶中是否有数据
			if (bucketElementCount[k] != 0) {
				// 循环第k个桶 取出来数据
				for (int l = 0; l < bucketElementCount[k]; l++) {
					arr[index] = bucket[k][l];
					index++;
				}
			}
			// 每一轮取完后再把每个桶中元素数量的指针置为0
			bucketElementCount[k] = 0;
		}
		System.out.println("第2轮对十位排序：" + Arrays.toString(arr));

		// 第3轮
		// 待排序数组元素放到桶中
		for (int j = 0; j < arr.length; j++) {
			// 每个元素的十位的值
			int digitOfElement = arr[j] / 100 % 10;
			// 放入到对应的桶中
			bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
			// 记录桶中元素个数的指针移动
			bucketElementCount[digitOfElement]++;
		}

		// 按照桶的顺序把桶中元素取出来放回排序数组
		index = 0;
		for (int k = 0; k < bucketElementCount.length; k++) {
			// 看看桶中是否有数据
			if (bucketElementCount[k] != 0) {
				// 循环第k个桶 取出来数据
				for (int l = 0; l < bucketElementCount[k]; l++) {
					arr[index] = bucket[k][l];
					index++;
				}
			}
			// 每一轮取完后再把每个桶中元素数量的指针置为0
			bucketElementCount[k] = 0;
		}
		System.out.println("第3轮对百位排序：" + Arrays.toString(arr));
	}


}
