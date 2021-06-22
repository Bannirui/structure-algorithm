/*
 * @Author: dingrui
 * @Date: 2021-06-22 13:37:15
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-22 13:54:45
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 固定一个窗口
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        // 窗口右划 进一个元素出一个元素
        double maxSum = windowSum;
        for (int j = k; j < nums.length; j++) {
            windowSum = windowSum - nums[j - k] + nums[j];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum / k;
    }
}
// @lc code=end
