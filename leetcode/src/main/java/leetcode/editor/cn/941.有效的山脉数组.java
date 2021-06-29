/*
 * @Author: dingrui
 * @Date: 2021-06-29 15:16:46
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 15:32:01
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length <= 2) {
            return false;
        }
        int i = 0;
        // 找到峰值
        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == arr.length - 1) {
            return false;
        }
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == arr.length - 1;
    }
}
// @lc code=end
