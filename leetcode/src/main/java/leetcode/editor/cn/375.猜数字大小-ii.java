/*
 * @Author: dingRui
 * @Date: 2021-08-14 17:40:33
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-16 11:11:10
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=375 lang=java
 *
 * [375] 猜数字大小 II
 */

// @lc code=start
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minRes = Integer.MAX_VALUE;
                for (int piv = start + (len - 1) / 2; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minRes = Math.min(res, minRes);
                }
                dp[start][start + len - 1] = minRes;
            }

        }
        return dp[1][n];
    }
}
// @lc code=end
