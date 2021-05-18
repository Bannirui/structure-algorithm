package com.bannirui.java.structure.search;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-11-26
 *@description 斐波那契查找 数组必须是有序数组
 */
public class FibonacciSearch {

	public static void main(String[] args) {
		// 生成一个目标数组
		int[] arr = {1,2,3,4,6,7,8,9,88};
		// 需要查找的值
		int findValue = 99;

		int index = fibonacciSearch(arr, findValue);

		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/11/26
	 * @param size 需要生成的斐比那契数组的长度
	 * @return
	 * @description 生成指定大小的斐波那契数组
	 */
	private static int[] getFibArray(int size) {
		if (size <= 0) {
			return new int[0];
		}
		int[] fib = new int[size];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i < size; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/26
	 * @param arr 待查找数组
	 * @param findValue 待查找的值
	 * @return
	 * @description 斐波那契查找
	 * 在数组中查找目标值 如果找到则返回该值对应的下标索引 如果没找到就返回-1
	 */
	private static int fibonacciSearch(int[] arr, int findValue) {
		int low = 0;
		int high = arr.length - 1;
		// 斐波那契分割数值的下标
		int k = 0;
		// 存放mid值
		int mid = 0;
		// 生成一个斐波那契数组
		int[] fibArray = getFibArray(20);
		// 获取到斐波那契分割值的下标
		while (high > fibArray[k] - 1) {
			k++;
		}

		// 因为fibArray[k]对应的值可能大于arr的长度 因此需要重新构造一个新的arr数组 一旦新生成的数组长度超出原来的 那么会默认使用0补齐 需要使用最后一个元素进行替换
		int[] tmpArray = Arrays.copyOf(arr, fibArray[k]);
		for (int i = high + 1; i < tmpArray.length; i++) {
			tmpArray[i] = arr[high];
		}

		// 循环查找目标值findValue
		while (low <= high) {
			mid = fibArray[k - 1] + 1;
			if (findValue < tmpArray[mid]) {
				// 向数组左边继续查找
				high = mid - 1;
				k--;
			} else if (findValue > tmpArray[mid]) {
				// 向数组右边继续查找
				low = mid + 1;
				k -= 2;
			} else {
				// 查找到了值 需要确定返回小一点的那个下标
				return Math.min(mid, high);
			}
		}
		// while循环了还没有找到 就返回-1
		return -1;
	}
}
