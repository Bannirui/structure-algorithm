/*
 * @Author: dingrui
 * @Date: 2021-06-18 14:33:11
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-18 14:48:01
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // 偷不偷最后一个房子 max(偷最后一个房子, 不偷最后一个房子)
        // base case
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(dp(nums, 0, len - 2), dp(nums, 1, len - 1));
    }

    /**
     * @author: dingrui
     * @Date: 2021-06-18 14:35:25
     * @param {int[]} nums
     * @param {int} start 数组下标开始的位置
     * @param {int} end 数组下标结束的位置
     * @return {*}
     * @description: len=nums.length [0, len-2]->不偷最后一家 [1, len-1]偷最后一家 
     * @example: 
     */
    public int dp(int[] nums, int start, int end) {
        int[] dp = new int[end + 1];
        // base case
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
// @lc code=end
