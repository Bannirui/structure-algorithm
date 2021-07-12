/*
 * @Author: dingrui
 * @Date: 2021-07-12 22:17:45
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 22:20:18
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1893 lang=java
 *
 * [1893] 检查是否区域内所有整数都被覆盖
 */

// @lc code=start
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[51];
        for (int[] range : ranges) {
            for (int s = range[0]; s <= range[1]; s++) {
                arr[s]++;
            }
        }
        for (int i = left; i <= right; i++) {
            if (arr[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
