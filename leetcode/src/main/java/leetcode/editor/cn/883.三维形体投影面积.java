/*
 * @Author: dingrui
 * @Date: 2021-06-29 11:01:46
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 11:10:57
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=883 lang=java
 *
 * [883] 三维形体投影面积
 */

// @lc code=start
class Solution {
    public int projectionArea(int[][] grid) {
        int len = grid.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int maxRow = 0;
            int maxCol = 0;
            for (int j = 0; j < len; j++) {
                if (grid[i][j] > 0) {
                    res++;
                }
                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            res = res + maxRow + maxCol;
        }
        return res;
    }
}
// @lc code=end
