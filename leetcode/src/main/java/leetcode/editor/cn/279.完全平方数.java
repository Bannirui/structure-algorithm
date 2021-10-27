/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        // dp[i] i最少需要多少个平方数求和
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // [1...i] 最少需要多少个平方数求和
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
// @lc code=end
