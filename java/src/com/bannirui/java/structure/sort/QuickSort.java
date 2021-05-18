package com.bannirui.java.structure.sort;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-11-24
 *@description 快排
 */
public class QuickSort {

    public static void main(String[] args) {
        // 实例化一个数组
        int[] arr = {12, 14, -1, 9, -6};

        System.out.println("排序之前：");
        System.out.println(Arrays.toString(arr));
        // quickSort(arr, 0, arr.length - 1);
        quick(arr, 0, arr.length - 1);
        System.out.println("排序之后：");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @author dingrui
     * @date 2020/11/24
     * @param arr 待排序数组
     * @param left 左下标
     * @param right 右下标
     * @return
     * @description 快排
     */
    public static void quickSort(int[] arr, int left, int right) {
        // 左下标
        int l = left;
        // 右下标
        int r = right;
        // 中间下标
        int mid = (right + left) >>> 1;
        // 中轴值
        int pivot = arr[mid];

        // 把pivot值左边都放上比pivot小的值 右边都放上比pivot值大的值
        while (l < r) {
            // 在pivot左边一直找 一直找到左边大于等于pivot值退出while循环
            while (arr[l] < pivot) {
                l++;
            }
            // 在pivot右边一直找 一直找到右边小于等于pivot值退出while循环
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                // 这个情况说明 中轴值左边找到了mid 中轴值右边也找到了mid 也就是mid两边都按照要求放置的 mid左边都比mid小 mid右边都比mid大
                break;
            }
            // mid两边的值进行交换
            int tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;
            // 如果交换完之后 发现arr[l]==pivot 右边指针左移r--
            if (l == mid) {
                // if (arr[l] == pivot) {
                r--;
            }
            // 如果交换完之后 发现arr[r]==pivot 左边指针右移l++
            if (r == mid) {
                // if (arr[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void quick(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int low = left;
        int high = right;
        int base = arr[low];
        while (low < high) {
            while (low < high && arr[high] > base) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < base) {
                low++;
            }
            arr[high] = arr[low];
        }
        // while循环的退出条件是left=right 这个位置就是base基准的脚标
        arr[low] = base;
        quick(arr, left, low - 1);
        quick(arr, low + 1, right);
    }
}
