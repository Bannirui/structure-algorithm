/*
 * @Author: dingRui
 * @Date: 2021-08-05 09:43:20
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-05 10:08:07
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 以i结尾的最长子序列
        int[] dp = new int[nums.length];
        // base case
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            // [0...i-1]值都比自己大的时候自己单独成序列 长度为1
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end
