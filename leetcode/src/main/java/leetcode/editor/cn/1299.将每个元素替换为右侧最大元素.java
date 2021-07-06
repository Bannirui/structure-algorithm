/*
 * @Author: dingrui
 * @Date: 2021-07-06 15:54:16
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 16:06:53
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1299 lang=java
 *
 * [1299] 将每个元素替换为右侧最大元素
 */

// @lc code=start
class Solution {
    public int[] replaceElements(int[] arr) {
        // 数组从右到左 以index为首元素到最后的区间内最大值
        int[] startIndexMax = new int[arr.length];
        int globalMax = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                startIndexMax[i] = arr[i];
                globalMax = arr[i];
            }
            if (arr[i] > globalMax) {
                // 新的最大值
                globalMax = arr[i];
            }
            startIndexMax[i] = globalMax;
        }
        // 替换操作
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = -1;
            } else {
                arr[i] = startIndexMax[i + 1];
            }
        }
        return arr;
    }
}
// @lc code=end
