package com.bannirui.java.structure.sort;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-11-24
 *@description 希尔排序
 */
public class ShellSort {

	public static void main(String[] args) {

		// 希尔排序的原始推导过程
		sortV1();

		// 初始化一个10个元素的数组
		int[] arr0 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] arr1 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

		// 交换元素法
		sortExchange(arr0);
		System.out.println("交换元素法：");
		System.out.println(Arrays.toString(arr0));

		// 移动元素法
		sortMove(arr1);
		System.out.println("移动元素法：");
		System.out.println(Arrays.toString(arr1));
	}

	/**
	 * @author dingrui
	 * @date 2020/11/24
	 * @return
	 * @description 希尔排序 推导过程
	 */
	public static void sortV1() {
		// 初始化一个10个元素的数组
		int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

		// 第1轮排序 10个数据分成5组 每组2个元素 2个元素之间步长是5
		for (int i = 5; i < arr.length; i++) {
			for (int j = i - 5; j >= 0; j -= 5) {
				if (arr[j] > arr[j + 5]) {
					// 需要交换
					int tmp = arr[j + 5];
					arr[j + 5] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println("希尔排序第1轮：");
		System.out.println(Arrays.toString(arr));

		// 第2轮排序 10个数据分成5/2=2组 每组5个元素
		for (int i = 2; i < arr.length; i++) {
			for (int j = i - 2; j >= 0; j -= 2) {
				if (arr[j] > arr[j + 2]) {
					// 需要交换
					int tmp = arr[j + 2];
					arr[j + 2] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println("希尔排序第2轮：");
		System.out.println(Arrays.toString(arr));

		// 第3轮排序 10个数据分成2/2=1组 每组10个元素
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j -= 1) {
				if (arr[j] > arr[j + 1]) {
					// 需要交换
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println("希尔排序第2轮：");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * @author dingrui
	 * @date 2020/11/24
	 * @param arr
	 * @return
	 * @description 通过交换元素方式实现希尔排序
	 */
	public static void sortExchange(int[] arr) {
		// 元素步长
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						// 需要交换
						int tmp = arr[j + gap];
						arr[j + gap] = arr[j];
						arr[j] = tmp;
					}
				}
			}
		}
	}


	/**
	 * @author dingrui
	 * @date 2020/11/24
	 * @param arr
	 * @return
	 * @description 希尔排序 移动法
	 */
	public static void sortMove(int[] arr) {
		// 增量gap 逐步缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素开始 逐个对其所在的组进行插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int tmp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && tmp < arr[j - gap]) {
						// 移动
						arr[j] = arr[j - gap];
						j -= gap;
					}
					// 退出while循环说明找到了tmp的插入位置
					arr[j] = tmp;
				}
			}
		}
	}
}
