package com.bannirui.java.structure.search;

/**
 *@author dingrui
 *@date 2020-11-26
 *@description 线性查找
 */
public class SeqSearch {
	public static void main(String[] args) {
		// 初始化一个查找数组
		int[] arr = {1,2,3,4,5,6,7};
		int value = 8;
		int i = seqSearch(arr, value);
		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/11/26
	 * @param arr 待查找数组
	 * @param value 待查找目标值
	 * @return 返回查找到的目标值 没有没有该值 返回-1
	 * @description 线性查找 简单粗暴
	 *
	 */
	private static int seqSearch(int[] arr, int value) {
		for (int i : arr) {
			if (i == value) {
				return i;
			}
		}
		return -1;
	}
}
