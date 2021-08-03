import java.util.Arrays;

/*
 * @Author: dingRui
 * @Date: 2021-08-03 16:44:51
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-03 17:01:59
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 没有最优解的
        Arrays.fill(dp, Integer.MAX_VALUE);
        // base case
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            // dp[i] = min{dp[i-?]...}
            if (dp[i] == Integer.MAX_VALUE) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    min = Math.min(min, dp[i - j * j]);
                }
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }
}
// @lc code=end
