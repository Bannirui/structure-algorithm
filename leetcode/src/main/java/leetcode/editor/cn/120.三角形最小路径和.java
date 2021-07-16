import java.util.Collections;
import java.util.List;

import javax.sql.RowSet;

/*
 * @Author: dingrui
 * @Date: 2021-07-16 16:04:18
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-16 17:05:09
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        // dp[r][c] 从[0][0]到[r][c]的最短路径和
        int ROWS = triangle.size();
        if (ROWS == 0) {
            return 0;
        }
        int[][] dp = new int[ROWS][ROWS];
        // base case
        dp[0][0] = triangle.get(0).get(0);
        for (int row = 1; row < ROWS; row++) {
            for (int col = 0; col <= row; col++) {
                // 上面两个[i]和[i+1]对应这层的[i]
                if (col == 0) {
                    // 左边界
                    dp[row][0] = dp[row - 1][0] + triangle.get(row).get(0);
                } else if (col == row) {
                    // 右边界
                    dp[row][row] = dp[row - 1][col - 1] + triangle.get(row).get(row);
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col - 1], dp[row - 1][col]) + triangle.get(row).get(col);
                }
            }
        }
        // dp[ROWS][0...ROWS-1]中的最小值
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < ROWS; i++) {
            res = Math.min(res, dp[ROWS - 1][i]);
        }
        return res;
    }
}
// @lc code=end
