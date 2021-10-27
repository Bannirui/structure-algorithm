/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 以i结尾的最长递增子序列长度
        int len = nums.length;
        int[] dp = new int[len + 1];
        // base case
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            // 以i结尾
            // 自成单独一个序列
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // [0...j]
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end
