/*
 * @Author: dingRui
 * @Date: 2021-08-10 09:42:50
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-10 10:08:01
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
// @lc code=end
