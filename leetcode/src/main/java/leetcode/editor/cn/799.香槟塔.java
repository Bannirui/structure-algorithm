/*
 * @Author: dingrui
 * @Date: 2021-07-17 17:38:00
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-17 18:04:01
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=799 lang=java
 *
 * [799] 香槟塔
 */

// @lc code=start
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // dp[r][c] [r][c]的酒有几杯
        float[][] dp = new float[query_row + 1][query_row + 1];
        // base case
        dp[0][0] = poured;
        for (int r = 0; r < query_row; r++) {
            // 第r行元素数量r+1
            for (int c = 0; c <= r + 1; c++) {
                // 倒进来的酒dp[r][j] 溢出杯子的量 去了下一层的两个杯子
                if (dp[r][c] > 1) {
                    float over = dp[r][c] - 1;
                    dp[r + 1][c] += (over / 2);
                    dp[r + 1][c + 1] += (over / 2);
                }
            }
        }
        return Math.min(dp[query_row][query_glass], 1);
    }
}
// @lc code=end
