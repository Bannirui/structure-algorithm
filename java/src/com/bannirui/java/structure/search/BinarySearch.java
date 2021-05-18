package com.bannirui.java.structure.search;

import java.util.ArrayList;
import java.util.List;

/**
 *@author dingrui
 *@date 2020-11-26
 *@description 二分查找 数组必须是有序数组
 */
public class BinarySearch {

	public static void main(String[] args) {
		// 初始化一个数组
		int[] arr = {1, 2, 3, 5, 6, 7, 8, 98, 98, 98, 100};
		int value = 98;
		int i = binarySearchV0(arr, value, 0, arr.length - 1);

		List<Integer> result = binarySearchV1(arr, value, 0, arr.length - 1);

		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/11/26
	 * @param arr 待查找数组
	 * @param value 待查找目标值
	 * @param left 查询数据左索引
	 * @param right 查询数据右索引
	 * @return 如果找到了目标值返回对应的下标索引 如果没找到返回-1
	 * @description 二分查找
	 */
	private static int binarySearchV0(int[] arr, int value, int left, int right) {
		if (left > right) {
			return -1;
		}
		int midIndex = (left + right) / 2;
		int midValue = arr[midIndex];
		if (value == midValue) {
			return midIndex;
		}
		if (value > midValue) {
			// 目标值在右边 右递归
			return binarySearchV0(arr, value, midIndex + 1, right);
		} else {
			// 目标值在左边 左递归
			return binarySearchV0(arr, value, left, midIndex);
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/26
	 * @param arr 待查找数组
	 * @param value 待查找目标值
	 * @param left 查询数据左索引
	 * @param right 查询数据右索引
	 * @return 如果找到了目标值返回对应的下标索引 如果没找到返回-1
	 * @description 二分查找 返回所有目标值的索引
	 */
	private static List<Integer> binarySearchV1(int[] arr, int value, int left, int right) {
		if (left > right) {
			return new ArrayList<Integer>(0);
		}
		int midIndex = (left + right) / 2;
		int midValue = arr[midIndex];
		if (value == midValue) {
			// midIndex就是找到的目标值的索引
			List<Integer> result = new ArrayList<>();
			result.add(midIndex);
			// 先往左扫描 再往右扫描 已经是有序的了 所以如果存在一样的值 一定是在已经找到了索引左右相邻的地方
			int tmp = midIndex - 1;
			while (true) {
				if (tmp < left || value != arr[tmp]) {
					break;
				}
				result.add(tmp);
				tmp--;
			}

			tmp = midIndex + 1;
			while (true) {
				if (tmp > right || value != arr[tmp]) {
					break;
				}
				result.add(tmp);
				tmp++;
			}

			return result;

		}

		if (value > midValue) {
			// 目标值在右边 右递归
			return binarySearchV1(arr, value, midIndex + 1, right);
		} else {
			// 目标值在左边 左递归
			return binarySearchV1(arr, value, left, midIndex);
		}
	}
}
