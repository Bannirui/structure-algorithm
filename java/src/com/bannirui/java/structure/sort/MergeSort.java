package com.bannirui.java.structure.sort;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-11-25
 *@description 归并排序算法
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
		int[] tmp = new int[arr.length];
		System.out.println("排序前：");
		System.out.println(Arrays.toString(arr));

		mergeSort(arr, 0, arr.length - 1, tmp);

		System.out.println("排序后：");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * @author dingrui
	 * @date 2020/11/25
	 * @param arr
	 * @param left
	 * @param right
	 * @param tmp
	 * @return
	 * @description 归并排序
	 */
	public static void mergeSort(int[] arr, int left, int right, int[] tmp) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 向左递归
			mergeSort(arr, left, mid, tmp);
			// 向右递归
			mergeSort(arr, mid + 1, right, tmp);
			// 每分解一次就合并一次
			merge(arr, left, mid, right, tmp);
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/25
	 * @param arr 待排序数组
	 * @param left 左边有序序列初始索引
	 * @param mid 中间索引
	 * @param right 右边索引
	 * @param tmp 临时中转数组
	 * @return
	 * @description 分治中的治环节 合并部分
	 */
	public static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
		// 初始化i，左边有序序列的初始索引
		int i = left;
		// 初始化j，右边有序序列的初始索引
		int j = mid + 1;
		// tmp数组的当前索引
		int t = 0;

		/**
		 * 现在左右两边的序列已经有序
		 * 先把左右两边的数据比较大小 按照从小到大规则填充到tmp数组
		 * 直到其中有一边全部处理完
		 */
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				// 如果左边的元素比右边的元素小 把左边的元素拷贝到tmp数组 指针后移
				tmp[t] = arr[i];
				t++;
				i++;
			} else {
				// 右边的元素比左边的元素小 把右边的元素拷贝到tmp数组 指针后移
				tmp[t] = arr[j];
				t++;
				j++;
			}
		}

		/**
		 * 因为一边的数据全部移到了tmp数组 现在把另一边的剩余全部数据复制到tmp数组就行
		 */
		while (i <= mid) {
			// 说明左边的数据还有剩余没拷贝到tmp数组
			tmp[t] = arr[i];
			t++;
			i++;
		}

		while (j <= right) {
			// 说明右边的数据还有剩余没拷贝到tmp数组
			tmp[t] = arr[j];
			t++;
			j++;
		}

		/**
		 * 将tmp数组的元素拷贝到arr数组中
		 */
		t = 0;
		int tmpLeft = left;
		while (tmpLeft <= right) {
			arr[tmpLeft] = tmp[t];
			t++;
			tmpLeft++;
		}
	}
}
